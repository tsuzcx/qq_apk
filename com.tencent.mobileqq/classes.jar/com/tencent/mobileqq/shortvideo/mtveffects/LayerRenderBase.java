package com.tencent.mobileqq.shortvideo.mtveffects;

import android.graphics.RectF;
import android.opengl.GLES20;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import java.util.HashMap;

public class LayerRenderBase
{
  protected int mHeight;
  private int mMaterialHeight;
  private HashMap<Integer, RectF> mMaterialMap = new HashMap();
  private int mMaterialTextureID = -1;
  private int mMaterialWidth;
  protected int mWidth;
  
  public static void clearColorBuffer(RenderBuffer paramRenderBuffer, int paramInt)
  {
    if (paramRenderBuffer == null) {
      return;
    }
    paramRenderBuffer.bind();
    GLES20.glClearColor(getRed(paramInt), getGreen(paramInt), getBlue(paramInt), getAlpha(paramInt));
    GLES20.glClear(16384);
    paramRenderBuffer.unbind();
  }
  
  public static float getAlpha(int paramInt)
  {
    return (paramInt >> 24 & 0xFF) * 1.0F / 255.0F;
  }
  
  public static float getBlue(int paramInt)
  {
    return (paramInt & 0xFF) * 1.0F / 255.0F;
  }
  
  public static float getGreen(int paramInt)
  {
    return (paramInt >> 8 & 0xFF) * 1.0F / 255.0F;
  }
  
  public static float getRed(int paramInt)
  {
    return (paramInt >> 16 & 0xFF) * 1.0F / 255.0F;
  }
  
  public static void releaseRenderBuffer(RenderBuffer paramRenderBuffer)
  {
    if (paramRenderBuffer == null) {
      return;
    }
    if (paramRenderBuffer.getTexId() >= 0)
    {
      GlUtil.deleteTexture(paramRenderBuffer.getTexId());
      paramRenderBuffer.setTexId(0);
    }
    paramRenderBuffer.destroy();
  }
  
  public void addMaterial(int paramInt, RectF paramRectF)
  {
    this.mMaterialMap.put(Integer.valueOf(paramInt), paramRectF);
  }
  
  public int getHeight()
  {
    return this.mHeight;
  }
  
  public RectF getMaterialArea(int paramInt)
  {
    return (RectF)this.mMaterialMap.get(Integer.valueOf(paramInt));
  }
  
  public int getMaterialHeight()
  {
    return this.mMaterialHeight;
  }
  
  public int getMaterialTextureID()
  {
    return this.mMaterialTextureID;
  }
  
  public int getMaterialWidth()
  {
    return this.mMaterialWidth;
  }
  
  public int getWidth()
  {
    return this.mWidth;
  }
  
  public void onMusicScale(float paramFloat) {}
  
  public void onSurfaceChanged(int paramInt1, int paramInt2)
  {
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
  }
  
  public void onSurfaceDestroy()
  {
    this.mMaterialMap.clear();
  }
  
  public int process(RenderBuffer paramRenderBuffer, int paramInt, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    return -1;
  }
  
  public void removeAllMaterials()
  {
    this.mMaterialMap.clear();
  }
  
  public void removeMaterial(int paramInt)
  {
    this.mMaterialMap.remove(Integer.valueOf(paramInt));
  }
  
  public void setMaterialTexture(int paramInt1, int paramInt2, int paramInt3)
  {
    this.mMaterialTextureID = paramInt1;
    this.mMaterialWidth = paramInt2;
    this.mMaterialHeight = paramInt3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.mtveffects.LayerRenderBase
 * JD-Core Version:    0.7.0.1
 */