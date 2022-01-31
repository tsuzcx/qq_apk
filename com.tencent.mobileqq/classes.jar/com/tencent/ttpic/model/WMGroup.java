package com.tencent.ttpic.model;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.RectF;
import android.opengl.GLES20;
import android.text.TextUtils;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.Frame;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.Param.Float2fParam;
import com.tencent.filter.Param.Float3fParam;
import com.tencent.filter.Param.FloatParam;
import com.tencent.filter.Param.IntParam;
import com.tencent.ttpic.filter.WMDitheringAnimationFilter;
import com.tencent.ttpic.filter.WMScaleAnimationFilter;
import com.tencent.ttpic.gles.GlUtil;
import com.tencent.ttpic.util.AlgoUtils;
import com.tencent.ttpic.util.BenchUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class WMGroup
{
  private int height;
  private Map<String, BaseFilter> mAnimationFilerMap = new HashMap();
  private BaseFilter mCopyFilter = new BaseFilter(GLSLRender.FILTER_SHADER_NONE);
  private Frame mCopyFrame = new Frame();
  private Map<String, WMElement> mIdElementMap = new HashMap();
  private int[] mTexId = new int[1];
  private int width;
  public List<WMElement> wmElements = new ArrayList();
  
  public void clear()
  {
    this.mCopyFilter.clearGLSLSelf();
    this.mCopyFrame.clear();
    GLES20.glDeleteTextures(this.mTexId.length, this.mTexId, 0);
    Iterator localIterator = this.wmElements.iterator();
    while (localIterator.hasNext()) {
      ((WMElement)localIterator.next()).clear();
    }
  }
  
  public BaseFilter createAnimationFilter(WMElement paramWMElement, int paramInt1, int paramInt2)
  {
    if ("scale".equals(paramWMElement.animateType)) {
      return new WMScaleAnimationFilter(paramWMElement, paramInt1, paramInt2);
    }
    if ("dithering".equals(paramWMElement.animateType)) {
      return new WMDitheringAnimationFilter(paramWMElement, paramInt1, paramInt2);
    }
    return new BaseFilter(GLSLRender.FILTER_SHADER_NONE);
  }
  
  public int getTexture()
  {
    return this.mCopyFrame.getTextureId();
  }
  
  public void init()
  {
    this.mCopyFilter.addParam(new Param.Float2fParam("ditheringOffset", 0.0F, 0.0F));
    this.mCopyFilter.addParam(new Param.IntParam("texNeedTransform", 1));
    this.mCopyFilter.addParam(new Param.Float2fParam("canvasSize", 0.0F, 0.0F));
    this.mCopyFilter.addParam(new Param.Float2fParam("texAnchor", 0.0F, 0.0F));
    this.mCopyFilter.addParam(new Param.FloatParam("texScale", 1.0F));
    this.mCopyFilter.addParam(new Param.Float3fParam("texRotate", 0.0F, 0.0F, 0.0F));
    this.mCopyFilter.addParam(new Param.FloatParam("positionRotate", 0.0F));
    this.mCopyFilter.ApplyGLSLFilter();
    this.mCopyFrame.bindFrame(-1, this.width, this.height, 0.0D);
    GLES20.glGenTextures(this.mTexId.length, this.mTexId, 0);
    Iterator localIterator = this.wmElements.iterator();
    while (localIterator.hasNext())
    {
      WMElement localWMElement = (WMElement)localIterator.next();
      localWMElement.init();
      this.mIdElementMap.put(localWMElement.id, localWMElement);
    }
  }
  
  public void setItemId(String paramString)
  {
    Iterator localIterator = this.wmElements.iterator();
    while (localIterator.hasNext()) {
      ((WMElement)localIterator.next()).itemId = paramString;
    }
  }
  
  public void setSize(int paramInt1, int paramInt2)
  {
    this.width = paramInt1;
    this.height = paramInt2;
  }
  
  public void updateTexture(long paramLong)
  {
    Object localObject1 = this.wmElements.iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((WMElement)((Iterator)localObject1).next()).updateBitmap(paramLong);
    }
    int j = 0;
    localObject1 = this.wmElements.iterator();
    do
    {
      i = j;
      if (!((Iterator)localObject1).hasNext()) {
        break;
      }
    } while (!((WMElement)((Iterator)localObject1).next()).needUpdate());
    int i = 1;
    if (i != 0)
    {
      BenchUtil.benchStart("updateTexture");
      BenchUtil.benchStart("clear texture");
      this.mCopyFrame.bindFrame(-1, this.width, this.height, 0.0D);
      GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
      GLES20.glClear(16384);
      BenchUtil.benchEnd("clear texture");
      Iterator localIterator = this.wmElements.iterator();
      if (localIterator.hasNext())
      {
        localObject1 = (WMElement)localIterator.next();
        Object localObject2 = ((WMElement)localObject1).getBitmap();
        BenchUtil.benchStart("load texture");
        GlUtil.loadTexture(this.mTexId[0], (Bitmap)localObject2);
        BenchUtil.benchEnd("load texture");
        float f3 = this.width;
        float f4 = this.height;
        localObject2 = new PointF(0.0F, 0.0F);
        float f1 = f4;
        float f2 = f3;
        if (!TextUtils.isEmpty(((WMElement)localObject1).relativeID))
        {
          localObject3 = (WMElement)this.mIdElementMap.get(((WMElement)localObject1).relativeID);
          f1 = f4;
          f2 = f3;
          if (localObject3 != null)
          {
            f1 = f4;
            f2 = f3;
            if (((WMElement)localObject3).finalContentRect != null)
            {
              f2 = ((WMElement)localObject3).finalContentRect.width();
              f1 = ((WMElement)localObject3).finalContentRect.height();
              ((PointF)localObject2).x = ((WMElement)localObject3).finalContentRect.left;
              ((PointF)localObject2).y = ((WMElement)localObject3).finalContentRect.top;
            }
          }
        }
        Object localObject3 = new PointF(((WMElement)localObject1).offsetX, ((WMElement)localObject1).offsetY);
        f2 = ((PointF)localObject2).x + ((WMElement)localObject1).relativeAnchor.x * f2 + ((PointF)localObject3).x - ((WMElement)localObject1).width * ((WMElement)localObject1).anchor.x;
        f1 = ((PointF)localObject2).y + ((WMElement)localObject1).relativeAnchor.y * f1 + ((PointF)localObject3).y - ((WMElement)localObject1).height * ((WMElement)localObject1).anchor.y;
        f3 = f2 + ((WMElement)localObject1).width;
        f4 = f1 + ((WMElement)localObject1).height;
        if ((localObject1 instanceof ImageWMElement))
        {
          ((WMElement)localObject1).finalContentRect.left = f2;
          ((WMElement)localObject1).finalContentRect.top = f1;
          ((WMElement)localObject1).finalContentRect.right = f3;
          ((WMElement)localObject1).finalContentRect.bottom = f4;
          label501:
          if ((!TextUtils.isEmpty(((WMElement)localObject1).animateType)) && (!this.mAnimationFilerMap.containsKey(((WMElement)localObject1).animateType)))
          {
            localObject2 = createAnimationFilter((WMElement)localObject1, this.width, this.height);
            ((BaseFilter)localObject2).ApplyGLSLFilter();
            this.mAnimationFilerMap.put(((WMElement)localObject1).animateType, localObject2);
          }
          BenchUtil.benchStart("draw texture");
          if (!TextUtils.isEmpty(((WMElement)localObject1).animateType)) {
            break label733;
          }
        }
        label733:
        for (localObject1 = this.mCopyFilter;; localObject1 = (BaseFilter)this.mAnimationFilerMap.get(((WMElement)localObject1).animateType))
        {
          ((BaseFilter)localObject1).setPositions(AlgoUtils.calPositions(f2, f4, f3, f1, this.width, this.height));
          ((BaseFilter)localObject1).OnDrawFrameGLSL();
          ((BaseFilter)localObject1).renderTexture(this.mTexId[0], this.width, this.height);
          BenchUtil.benchEnd("draw texture");
          break;
          localObject2 = (TextWMElement)localObject1;
          ((WMElement)localObject1).finalContentRect.left = (((TextWMElement)localObject2).getTextRect().left + f2);
          ((WMElement)localObject1).finalContentRect.top = (((TextWMElement)localObject2).getTextRect().top + f1);
          ((WMElement)localObject1).finalContentRect.right = (((TextWMElement)localObject2).getTextRect().right + f2);
          ((WMElement)localObject1).finalContentRect.bottom = (((TextWMElement)localObject2).getTextRect().bottom + f1);
          break label501;
        }
      }
      BenchUtil.benchEnd("updateTexture");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.model.WMGroup
 * JD-Core Version:    0.7.0.1
 */