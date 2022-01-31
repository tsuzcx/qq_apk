package com.tencent.ttpic.filters;

import android.graphics.PointF;
import android.opengl.GLES20;
import android.text.TextUtils;
import com.tencent.aekit.openrender.AttributeParam;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.openapi.model.StickerItem;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class SwitchFaceFilterBase
  extends BaseFilter
{
  public static final double DEFAULT_SCALE = 1.0D;
  public static final float[] EMPTY_POSITIONS = { 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F };
  public static final float[] ORIGIN_POSITION_COORDS = { -1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F, 1.0F, -1.0F };
  public static final float[] ORIGIN_TEX_COORDS = { 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F };
  protected String dataPath;
  protected int height;
  private boolean isFaceOff;
  private boolean isSnakeFace;
  protected StickerItem item;
  private boolean loadImageFromCache;
  private Map<String, AttributeParam> mAttrParams;
  private int mCoordNum;
  private int mRenderMode;
  protected int mSTextureHandle;
  protected int width;
  protected double windowScale;
  
  public SwitchFaceFilterBase(String paramString1, String paramString2, StickerItem paramStickerItem)
  {
    super(paramString1, paramString2);
    this.item = paramStickerItem;
    this.mAttrParams = new HashMap();
    this.mSTextureHandle = -1;
    this.mCoordNum = 4;
  }
  
  public void ApplyGLSLFilter()
  {
    initAttribParams();
    super.apply();
    Iterator localIterator = this.mAttrParams.values().iterator();
    while (localIterator.hasNext()) {
      ((AttributeParam)localIterator.next()).initialParams(getProgramIds());
    }
    this.mSTextureHandle = GLES20.glGetUniformLocation(getProgramIds(), "inputImageTexture");
  }
  
  public void OnDrawFrameGLSL()
  {
    super.OnDrawFrameGLSL();
    Iterator localIterator = this.mAttrParams.values().iterator();
    while (localIterator.hasNext()) {
      ((AttributeParam)localIterator.next()).setParams(getProgramIds());
    }
  }
  
  public void addAttribParma(AttributeParam paramAttributeParam)
  {
    if (paramAttributeParam != null)
    {
      AttributeParam localAttributeParam2 = (AttributeParam)this.mAttrParams.get(paramAttributeParam.name);
      AttributeParam localAttributeParam1 = localAttributeParam2;
      if (localAttributeParam2 == null)
      {
        localAttributeParam1 = new AttributeParam(paramAttributeParam.name, paramAttributeParam.vertices, paramAttributeParam.perVertexFloat);
        this.mAttrParams.put(paramAttributeParam.name, localAttributeParam1);
      }
      localAttributeParam1.setVertices(paramAttributeParam.vertices);
      localAttributeParam1.perVertexFloat = paramAttributeParam.perVertexFloat;
    }
  }
  
  public void addAttribParma(String paramString, float[] paramArrayOfFloat)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      AttributeParam localAttributeParam2 = (AttributeParam)this.mAttrParams.get(paramString);
      AttributeParam localAttributeParam1 = localAttributeParam2;
      if (localAttributeParam2 == null)
      {
        localAttributeParam1 = new AttributeParam(paramString, paramArrayOfFloat);
        this.mAttrParams.put(paramString, localAttributeParam1);
      }
      localAttributeParam1.setVertices(paramArrayOfFloat);
    }
  }
  
  public AttributeParam getAttribParam(String paramString)
  {
    return (AttributeParam)this.mAttrParams.get(paramString);
  }
  
  public StickerItem getStickerItem()
  {
    return this.item;
  }
  
  public void initAttribParams()
  {
    setPositions(ORIGIN_POSITION_COORDS);
    setTexCords(new float[] { 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F, 1.0F });
  }
  
  public abstract void initParams();
  
  public boolean isLoadImageFromCache()
  {
    return this.loadImageFromCache;
  }
  
  public boolean renderTexture(int paramInt1, int paramInt2, int paramInt3)
  {
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(3553, paramInt1);
    GLES20.glTexParameterf(3553, 10241, 9729.0F);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
    GLES20.glTexParameterf(3553, 10242, 33071.0F);
    GLES20.glTexParameterf(3553, 10243, 33071.0F);
    GLES20.glUniform1i(this.mSTextureHandle, 0);
    if (this.isSnakeFace)
    {
      GLES20.glDrawArrays(5, 0, this.mCoordNum);
      if (this.mRenderMode != 0) {
        break label124;
      }
      GLES20.glFinish();
    }
    label124:
    while (this.mRenderMode != 1)
    {
      return true;
      if (this.isFaceOff)
      {
        GLES20.glDrawArrays(4, 0, this.mCoordNum);
        break;
      }
      GLES20.glDrawArrays(6, 0, this.mCoordNum);
      break;
    }
    GLES20.glFlush();
    return true;
  }
  
  public boolean setCoordNum(int paramInt)
  {
    this.mCoordNum = paramInt;
    return true;
  }
  
  public boolean setFaceOff(boolean paramBoolean)
  {
    this.isFaceOff = paramBoolean;
    return true;
  }
  
  public boolean setGrayCords(float[] paramArrayOfFloat)
  {
    addAttribParma("inputGrayTextureCoordinate", paramArrayOfFloat);
    return true;
  }
  
  public void setLoadImageFromCache(boolean paramBoolean)
  {
    this.loadImageFromCache = paramBoolean;
  }
  
  public boolean setPositions(float[] paramArrayOfFloat)
  {
    addAttribParma("position", paramArrayOfFloat);
    return true;
  }
  
  public boolean setRenderMode(int paramInt)
  {
    this.mRenderMode = paramInt;
    return true;
  }
  
  public boolean setSnakeFace(boolean paramBoolean)
  {
    this.isSnakeFace = paramBoolean;
    return true;
  }
  
  public boolean setTexCords(float[] paramArrayOfFloat)
  {
    addAttribParma("inputTextureCoordinate", paramArrayOfFloat);
    return true;
  }
  
  public abstract void updatePreview(List<PointF> paramList, float[] paramArrayOfFloat, float paramFloat, long paramLong);
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    this.width = paramInt1;
    this.height = paramInt2;
    this.windowScale = paramDouble;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ttpic.filters.SwitchFaceFilterBase
 * JD-Core Version:    0.7.0.1
 */