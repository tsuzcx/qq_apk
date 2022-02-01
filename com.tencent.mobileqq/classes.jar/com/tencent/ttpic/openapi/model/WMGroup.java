package com.tencent.ttpic.openapi.model;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.RectF;
import android.opengl.GLES20;
import android.text.TextUtils;
import com.tencent.aekit.openrender.UniformParam.Float2fParam;
import com.tencent.aekit.openrender.UniformParam.Float3fParam;
import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.aekit.openrender.UniformParam.IntParam;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.baseutils.fps.BenchUtil;
import com.tencent.ttpic.filter.WMAnimationFilterBase;
import com.tencent.ttpic.filter.WMDitheringAnimationFilter;
import com.tencent.ttpic.filter.WMFadeInAndOffAnimationFilter;
import com.tencent.ttpic.filter.WMScaleAnimationFilter;
import com.tencent.ttpic.openapi.watermark.LogicDataManager;
import com.tencent.ttpic.util.AlgoUtils;
import com.tencent.ttpic.util.FrameUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class WMGroup
{
  public int height;
  public int id;
  private boolean locked = false;
  private Map<String, WMAnimationFilterBase> mAnimationFilerMap = new HashMap();
  private BaseFilter mCopyFilter = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  private Frame mCopyFrame = new Frame();
  public Map<String, WMElement> mIdElementMap = new HashMap();
  private int[] mTexId = new int[1];
  public int width;
  public List<WMElement> wmElements = new ArrayList();
  
  public WMGroup(WMGroupConfig paramWMGroupConfig)
  {
    this.id = paramWMGroupConfig.id;
    this.width = paramWMGroupConfig.width;
    this.height = paramWMGroupConfig.height;
    if (paramWMGroupConfig.wmElementConfigs != null)
    {
      paramWMGroupConfig = paramWMGroupConfig.wmElementConfigs.iterator();
      while (paramWMGroupConfig.hasNext())
      {
        WMElementConfig localWMElementConfig = (WMElementConfig)paramWMGroupConfig.next();
        this.wmElements.add(WMElementFactory.createWMElement(localWMElementConfig));
      }
    }
  }
  
  public void clear()
  {
    this.mCopyFilter.clearGLSLSelf();
    this.mCopyFrame.clear();
    GLES20.glDeleteTextures(this.mTexId.length, this.mTexId, 0);
    Iterator localIterator = this.wmElements.iterator();
    while (localIterator.hasNext()) {
      ((WMElement)localIterator.next()).clear();
    }
    localIterator = this.mAnimationFilerMap.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((WMAnimationFilterBase)((Map.Entry)localIterator.next()).getValue()).clearGLSL();
    }
  }
  
  public WMAnimationFilterBase createAnimationFilter(WMElement paramWMElement, int paramInt1, int paramInt2)
  {
    if ("scale".equals(paramWMElement.animateType)) {
      return new WMScaleAnimationFilter(paramWMElement, paramInt1, paramInt2);
    }
    if ("dithering".equals(paramWMElement.animateType)) {
      return new WMDitheringAnimationFilter(paramWMElement, paramInt1, paramInt2);
    }
    if ("alpha".equals(paramWMElement.animateType)) {
      return new WMFadeInAndOffAnimationFilter(paramWMElement, paramInt1, paramInt2);
    }
    return null;
  }
  
  public int getCurTexture()
  {
    return this.mCopyFrame.getTextureId();
  }
  
  public int getTexture()
  {
    return this.mCopyFrame.getTextureId();
  }
  
  public void init()
  {
    this.mCopyFilter.addParam(new UniformParam.Float2fParam("ditheringOffset", 0.0F, 0.0F));
    this.mCopyFilter.addParam(new UniformParam.IntParam("texNeedTransform", 1));
    this.mCopyFilter.addParam(new UniformParam.Float2fParam("canvasSize", 0.0F, 0.0F));
    this.mCopyFilter.addParam(new UniformParam.Float2fParam("texAnchor", 0.0F, 0.0F));
    this.mCopyFilter.addParam(new UniformParam.FloatParam("texScale", 1.0F));
    this.mCopyFilter.addParam(new UniformParam.Float3fParam("texRotate", 0.0F, 0.0F, 0.0F));
    this.mCopyFilter.addParam(new UniformParam.FloatParam("positionRotate", 0.0F));
    this.mCopyFilter.apply();
    FrameUtil.clearFrame(this.mCopyFrame, 0.0F, 0.0F, 0.0F, 0.0F, this.width, this.height);
    GLES20.glGenTextures(this.mTexId.length, this.mTexId, 0);
    if (!this.mAnimationFilerMap.isEmpty())
    {
      localIterator = this.mAnimationFilerMap.values().iterator();
      while (localIterator.hasNext()) {
        ((WMAnimationFilterBase)localIterator.next()).apply();
      }
    }
    Iterator localIterator = this.wmElements.iterator();
    int j;
    for (int i = 0; localIterator.hasNext(); i = j)
    {
      WMElement localWMElement = (WMElement)localIterator.next();
      j = i;
      if (i == 0)
      {
        j = i;
        if ((localWMElement instanceof TextWMElement))
        {
          j = i;
          if (localWMElement.edittype == 1)
          {
            LogicDataManager.getInstance().getEditableWMElement().clear();
            j = 1;
          }
        }
      }
      localWMElement.init();
      if ((!TextUtils.isEmpty(localWMElement.animateType)) && (!this.mAnimationFilerMap.containsKey(localWMElement.animateType)))
      {
        WMAnimationFilterBase localWMAnimationFilterBase = createAnimationFilter(localWMElement, this.width, this.height);
        if (localWMAnimationFilterBase != null)
        {
          localWMAnimationFilterBase.apply();
          this.mAnimationFilerMap.put(localWMElement.animateType, localWMAnimationFilterBase);
        }
      }
      this.mIdElementMap.put(localWMElement.id, localWMElement);
    }
  }
  
  public boolean isAsyncDrawFinished()
  {
    Iterator localIterator = this.wmElements.iterator();
    while (localIterator.hasNext())
    {
      WMElement localWMElement = (WMElement)localIterator.next();
      if (((localWMElement instanceof TextWMElement)) && (((TextWMElement)localWMElement).isAsyncDrawFinished())) {
        return true;
      }
    }
    return false;
  }
  
  public boolean isLock()
  {
    return this.locked;
  }
  
  public void lock()
  {
    this.locked = true;
  }
  
  public void reset()
  {
    Iterator localIterator = this.wmElements.iterator();
    while (localIterator.hasNext()) {
      ((WMElement)localIterator.next()).reset();
    }
    localIterator = this.mAnimationFilerMap.values().iterator();
    while (localIterator.hasNext()) {
      ((WMAnimationFilterBase)localIterator.next()).resetStartTime();
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
  
  public void unlock()
  {
    this.locked = false;
  }
  
  public boolean updateTexture(long paramLong)
  {
    return updateTexture(paramLong, false, false, false);
  }
  
  public boolean updateTexture(long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    Object localObject1;
    boolean bool1;
    Object localObject2;
    if (paramBoolean1)
    {
      boolean bool3;
      if (!this.locked)
      {
        localObject1 = this.wmElements.iterator();
        bool1 = false;
        bool3 = bool1;
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = (WMElement)((Iterator)localObject1).next();
          if (((localObject2 instanceof TextWMElement)) && (paramBoolean2)) {
            ((TextWMElement)localObject2).updateTextShaderBmp(paramLong);
          }
          for (;;)
          {
            break;
            bool1 = ((WMElement)localObject2).updateBitmap(paramLong, paramBoolean3) | bool1;
          }
        }
      }
      else
      {
        bool3 = false;
      }
      if (bool3) {
        lock();
      }
      localObject1 = this.wmElements.iterator();
      do
      {
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (WMElement)((Iterator)localObject1).next();
      } while ((!(localObject2 instanceof TextWMElement)) || (((WMElement)localObject2).isContentChanged()));
    }
    for (paramBoolean1 = false;; paramBoolean1 = true)
    {
      localObject1 = this.wmElements.iterator();
      do
      {
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
      } while (!((WMElement)((Iterator)localObject1).next()).isContentChanged());
      label276:
      label917:
      label965:
      boolean bool2;
      for (bool1 = true;; bool2 = false)
      {
        if (bool1)
        {
          this.mCopyFrame.bindFrame(-1, this.width, this.height, 0.0D);
          paramBoolean2 = GlUtil.curBlendModeEnabled;
          GlUtil.setBlendMode(true);
          BenchUtil.benchStart("updateTexture");
          BenchUtil.benchStart("clear texture");
          FrameUtil.clearFrame(this.mCopyFrame, 0.0F, 0.0F, 0.0F, 0.0F, this.width, this.height);
          BenchUtil.benchEnd("clear texture");
          localObject2 = this.wmElements.iterator();
          for (;;)
          {
            if (!((Iterator)localObject2).hasNext()) {
              break label1077;
            }
            WMElement localWMElement = (WMElement)((Iterator)localObject2).next();
            localObject1 = localWMElement.getBitmap();
            Object localObject3;
            if ((localObject1 != null) && (!((Bitmap)localObject1).isRecycled())) {
              if (!localWMElement.numberSource.equals(""))
              {
                localObject3 = (String)LogicDataManager.getInstance().mFollowData.get(localWMElement.numberSource);
                if (localObject3 == null) {}
              }
            }
            try
            {
              i = Integer.parseInt((String)localObject3);
              if ((!localWMElement.showCaseMin.equals("")) && (!localWMElement.showCaseMax.equals("")))
              {
                int j = Integer.parseInt(localWMElement.showCaseMin);
                int k = Integer.parseInt(localWMElement.showCaseMax);
                if ((i < j) || (i > k)) {
                  continue;
                }
              }
            }
            catch (NumberFormatException localNumberFormatException)
            {
              for (;;)
              {
                int i;
                float f3;
                float f4;
                float f1;
                float f2;
                localNumberFormatException.printStackTrace();
                continue;
                localObject1 = (TextWMElement)localWMElement;
                localWMElement.finalContentRect.left = (((TextWMElement)localObject1).getTextRect().left + f2);
                localWMElement.finalContentRect.top = (((TextWMElement)localObject1).getTextRect().top + f1);
                localWMElement.finalContentRect.right = (((TextWMElement)localObject1).getTextRect().right + f2);
                localWMElement.finalContentRect.bottom = (((TextWMElement)localObject1).getTextRect().bottom + f1);
              }
            }
          }
          BenchUtil.benchStart("load texture");
          GlUtil.loadTexture(this.mTexId[0], (Bitmap)localObject1);
          BenchUtil.benchEnd("load texture");
          f3 = this.width;
          f4 = this.height;
          localObject1 = new PointF(0.0F, 0.0F);
          f1 = f4;
          f2 = f3;
          if (!TextUtils.isEmpty(localWMElement.relativeID))
          {
            localObject3 = (WMElement)this.mIdElementMap.get(localWMElement.relativeID);
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
                ((PointF)localObject1).x = ((WMElement)localObject3).finalContentRect.left;
                ((PointF)localObject1).y = ((WMElement)localObject3).finalContentRect.top;
              }
            }
          }
          localObject3 = new PointF(localWMElement.offsetX, localWMElement.offsetY);
          f3 = ((PointF)localObject1).x;
          f2 = f2 * localWMElement.relativeAnchor.x + f3 + ((PointF)localObject3).x - localWMElement.width * localWMElement.anchor.x;
          f3 = ((PointF)localObject1).y;
          f1 = f1 * localWMElement.relativeAnchor.y + f3 + ((PointF)localObject3).y - localWMElement.height * localWMElement.anchor.y;
          f3 = f2 + localWMElement.width;
          f4 = f1 + localWMElement.height;
          if ((localWMElement instanceof ImageWMElement))
          {
            localWMElement.finalContentRect.left = f2;
            localWMElement.finalContentRect.top = f1;
            localWMElement.finalContentRect.right = f3;
            localWMElement.finalContentRect.bottom = f4;
            localObject1 = this.mCopyFilter;
            if ((TextUtils.isEmpty(localWMElement.animateType)) || (!this.mAnimationFilerMap.containsKey(localWMElement.animateType))) {
              break label1091;
            }
            localObject1 = (WMAnimationFilterBase)this.mAnimationFilerMap.get(localWMElement.animateType);
            ((WMAnimationFilterBase)localObject1).updateParams(localWMElement, this.width, this.height, paramLong);
          }
        }
        label1077:
        label1091:
        for (;;)
        {
          BenchUtil.benchStart("draw texture");
          ((BaseFilter)localObject1).setPositions(AlgoUtils.calPositions(f2, f4, f3, f1, this.width, this.height));
          ((BaseFilter)localObject1).OnDrawFrameGLSL();
          ((BaseFilter)localObject1).renderTexture(this.mTexId[0], this.width, this.height);
          BenchUtil.benchEnd("draw texture");
          break label276;
          localObject1 = this.wmElements.iterator();
          i = 0;
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (WMElement)((Iterator)localObject1).next();
            if ((!(localObject2 instanceof TextWMElement)) || (!paramBoolean2)) {
              break label965;
            }
            ((TextWMElement)localObject2).updateTextShaderBmp(paramLong);
          }
          for (;;)
          {
            break label917;
            break;
            bool2 = ((WMElement)localObject2).updateBitmap(paramLong, paramBoolean3) | i;
          }
          BenchUtil.benchEnd("updateTexture");
          GlUtil.setBlendMode(paramBoolean2);
          return paramBoolean1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.model.WMGroup
 * JD-Core Version:    0.7.0.1
 */