package com.tencent.mobileqq.richmedia.mediacodec.renderer;

import android.graphics.PointF;
import android.opengl.EGL14;
import android.opengl.GLES20;
import android.os.Build.VERSION;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.sveffects.SLog;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import java.nio.ByteBuffer;
import java.util.List;

public class GPUSkinRegionFilter
{
  private static final String TAG = "GPUSkinRegionFilter";
  private static final int outputMaskHeight = 240;
  private static final int outputMaskWidth = 136;
  private static final int skinComputeHeight = 120;
  private static final int skinComputeWidth = 68;
  private static final boolean useFace = false;
  private int imageHeight;
  private int imageWidth;
  private boolean mIsInitialized = false;
  private RenderBuffer mRenderFBO;
  private final Object mTextureLock;
  private RenderBuffer mZoomFBO;
  private byte[] maskData;
  private SkinRegionComputeThread skinRegionComputeThread = new SkinRegionComputeThread();
  private GPUTextureMergeFilter textureMergeFilter = new GPUTextureMergeFilter();
  private GPUBaseFilter zoomFilter = new GPUBaseFilter();
  
  public GPUSkinRegionFilter()
  {
    this.skinRegionComputeThread.initRegionCompute(68, 120, 136, 240, false);
    this.mTextureLock = new Object();
  }
  
  public void init()
  {
    if (SLog.isEnable()) {
      SLog.d("GPUSkinRegionFilter", "GPU Skin RegionFilter init");
    }
    if (this.mIsInitialized) {
      return;
    }
    this.mIsInitialized = true;
    this.textureMergeFilter.init();
    this.zoomFilter.init();
    this.zoomFilter.onOutputSizeChanged(68, 120);
    if (this.mZoomFBO == null) {
      this.mZoomFBO = new RenderBuffer(false, 68, 120, 33985);
    }
    this.maskData = new byte[32640];
  }
  
  public int mergeTexture(List<List<PointF>> arg1, int paramInt1, int paramInt2)
  {
    if (this.mRenderFBO == null)
    {
      SLog.e("GPUSkinRegionFilter", "mergeTexture error, renderFBO == null");
      return paramInt2;
    }
    int i = ???.size();
    float f3 = 0.0F;
    float f1;
    if (i > 0)
    {
      ??? = (List)???.get(0);
      i = 0;
      f3 = 0.0F;
      f1 = 0.0F;
      f2 = 0.0F;
      f4 = 0.0F;
      while (i < ???.size())
      {
        PointF localPointF = (PointF)???.get(i);
        if (i == 0)
        {
          f3 = localPointF.x;
          f2 = localPointF.y;
          f4 = f2;
          f1 = f3;
        }
        else
        {
          if (f3 >= localPointF.x) {
            f3 = localPointF.x;
          }
          if (f2 >= localPointF.y) {
            f2 = localPointF.y;
          }
          if (f1 <= localPointF.x) {
            f1 = localPointF.x;
          }
          if (f4 <= localPointF.y) {
            f4 = localPointF.y;
          }
        }
        i += 1;
      }
    }
    else
    {
      f1 = 0.0F;
      f2 = 0.0F;
      f4 = 0.0F;
    }
    float f6 = 68.0F / this.imageWidth / 0.25F;
    float f5 = 120.0F / this.imageHeight / 0.25F;
    f3 *= f6;
    f1 *= f6;
    float f2 = 120.0F - f2 * f5;
    float f4 = 120.0F - f4 * f5;
    if ((f1 - f3) * (f2 - f4) > 4080.0F) {
      return paramInt2;
    }
    if (this.skinRegionComputeThread != null) {
      synchronized (this.mTextureLock)
      {
        this.mZoomFBO.bind();
        this.zoomFilter.drawTexture(paramInt1, null, null);
        this.mZoomFBO.unbind();
        this.skinRegionComputeThread.skinRegionCompute(this.mZoomFBO.getTexId(), new float[] { f3, f4, f1, f2 });
        bool = this.skinRegionComputeThread.copyMaskData(this.maskData);
      }
    }
    boolean bool = false;
    if (!bool)
    {
      SLog.d("GPUSkinRegionFilter", "maskData not exist, return");
      return paramInt2;
    }
    ??? = ByteBuffer.wrap(this.maskData);
    ???.position(0);
    int[] arrayOfInt = new int[1];
    GLES20.glGenTextures(1, arrayOfInt, 0);
    GlUtil.checkGlError("glGenTextures");
    GLES20.glBindTexture(3553, arrayOfInt[0]);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("glBindTexture ");
    localStringBuilder.append(arrayOfInt[0]);
    GlUtil.checkGlError(localStringBuilder.toString());
    GLES20.glTexParameterf(3553, 10241, 9729.0F);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
    GLES20.glTexParameteri(3553, 10242, 33071);
    GLES20.glTexParameteri(3553, 10243, 33071);
    GLES20.glTexImage2D(3553, 0, 6406, 136, 240, 0, 6406, 5121, ???);
    i = arrayOfInt[0];
    GlUtil.checkGlError("glTexParameter");
    this.mRenderFBO.setTexId(paramInt2);
    this.mRenderFBO.bind();
    this.textureMergeFilter.drawTexture(paramInt1, paramInt2, i, null, null);
    this.mRenderFBO.unbind();
    return paramInt2;
  }
  
  public void onOutputSizeChanged(int paramInt1, int paramInt2)
  {
    this.textureMergeFilter.onOutputSizeChanged(paramInt1, paramInt2);
    this.imageWidth = paramInt1;
    this.imageHeight = paramInt2;
    if (Build.VERSION.SDK_INT >= 17) {
      this.skinRegionComputeThread.init(paramInt1, paramInt2, EGL14.eglGetCurrentContext(), this.mTextureLock);
    }
    RenderBuffer localRenderBuffer = this.mRenderFBO;
    if ((localRenderBuffer == null) || ((localRenderBuffer.getHeight() != paramInt2) && (paramInt2 != 0)) || ((this.mRenderFBO.getWidth() != paramInt1) && (paramInt1 != 0)))
    {
      localRenderBuffer = this.mRenderFBO;
      if (localRenderBuffer != null) {
        localRenderBuffer.destroy();
      }
      this.mRenderFBO = new RenderBuffer(false, paramInt1, paramInt2, 33985);
    }
  }
  
  public void release()
  {
    Object localObject = this.textureMergeFilter;
    if (localObject != null)
    {
      ((GPUTextureMergeFilter)localObject).destroy();
      this.textureMergeFilter = null;
    }
    localObject = this.zoomFilter;
    if (localObject != null)
    {
      ((GPUBaseFilter)localObject).destroy();
      this.zoomFilter = null;
    }
    localObject = this.mRenderFBO;
    if (localObject != null)
    {
      ((RenderBuffer)localObject).destroy();
      this.mRenderFBO = null;
    }
    localObject = this.mZoomFBO;
    if (localObject != null)
    {
      ((RenderBuffer)localObject).destroy();
      this.mZoomFBO = null;
    }
    localObject = this.skinRegionComputeThread;
    if (localObject != null)
    {
      ((SkinRegionComputeThread)localObject).onDestroy();
      this.skinRegionComputeThread = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.renderer.GPUSkinRegionFilter
 * JD-Core Version:    0.7.0.1
 */