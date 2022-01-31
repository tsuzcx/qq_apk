package com.tencent.mobileqq.shortvideo.filter;

import android.annotation.SuppressLint;
import android.opengl.GLES20;
import android.os.Build.VERSION;
import com.tencent.mobileqq.richmedia.mediacodec.computeShader.GPUAvgPixelsFilter;
import com.tencent.mobileqq.richmedia.mediacodec.computeShader.GPUGuideFilterComputeFilter;
import com.tencent.mobileqq.richmedia.mediacodec.computeShader.GPUGuideFilterRecoverFilter;
import com.tencent.mobileqq.richmedia.mediacodec.computeShader.GPUImgFilterRecoverFilter;
import com.tencent.mobileqq.richmedia.mediacodec.computeShader.GPUMinMaxPixelsFilter;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.sveffects.SLog;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import com.tencent.ttpic.openapi.filter.TextureRender;

@SuppressLint({"NewApi"})
public class QQImgHazeRmoveFilter
  extends QQBaseFilter
{
  public static final String TAG = "QQImgHazeRmoveFilter";
  public int CLIP_HEIGHT;
  public int CLIP_WIDTH;
  public int SRC_HEIGHT;
  public int SRC_WIDTH;
  private boolean enableImgFilter = false;
  private GPUGuideFilterComputeFilter gpuGuideFilterComputeFilter;
  private GPUGuideFilterRecoverFilter gpuGuideFilterRecoverFilter;
  private GPUImgFilterRecoverFilter gpuImgFilterRecoverFilter;
  private GPUAvgPixelsFilter imgFilterPixelsFilter;
  private RenderBuffer mClip8RenderFBO;
  private RenderBuffer mCopyRenderFBO;
  private TextureRender mCopyTextureRender;
  private RenderBuffer mOutputRenderFBO;
  private RenderBuffer mSrcRenderFBO;
  private RenderBuffer mTranmissionRenderFBO;
  private float mW = 0.9F;
  private int mWindow = 11;
  private GPUMinMaxPixelsFilter minMaxPixelsFilter;
  
  public QQImgHazeRmoveFilter(int paramInt, QQFilterRenderManager paramQQFilterRenderManager)
  {
    super(paramInt, paramQQFilterRenderManager);
  }
  
  private int clipTexture(int paramInt)
  {
    this.mClip8RenderFBO.bind();
    this.mCopyTextureRender.drawTexture(3553, paramInt, null, null);
    this.mClip8RenderFBO.unbind();
    return this.mClip8RenderFBO.getTexId();
  }
  
  private int copyInputTexture(int paramInt)
  {
    this.mCopyRenderFBO.bind();
    this.mCopyTextureRender.drawTexture(3553, paramInt, null, null);
    this.mCopyRenderFBO.unbind();
    return this.mCopyRenderFBO.getTexId();
  }
  
  private int copyTransmissionTexture()
  {
    int i = GlUtil.createTexture(3553);
    this.mTranmissionRenderFBO.bind();
    this.mCopyTextureRender.drawTexture(3553, i, null, null);
    this.mTranmissionRenderFBO.unbind();
    return this.mTranmissionRenderFBO.getTexId();
  }
  
  private int copyoutputTexture(int paramInt)
  {
    this.mOutputRenderFBO.bind();
    this.mCopyTextureRender.drawTexture(3553, paramInt, null, null);
    this.mOutputRenderFBO.unbind();
    return this.mOutputRenderFBO.getTexId();
  }
  
  private void getTransmissionDark(int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3, int paramInt4, float[] paramArrayOfFloat, float paramFloat, int paramInt5)
  {
    this.minMaxPixelsFilter.glDisPatchGPUMinMaxPixelsFilterCompute(paramInt1, paramInt3, paramInt4, paramArrayOfInt, paramFloat, paramInt5);
    this.gpuGuideFilterComputeFilter.glDisPatchGuideFilterComputerCompute(paramArrayOfInt, paramInt3, paramInt4, paramInt5, 0.001F);
    this.gpuGuideFilterRecoverFilter.glDisPatchGuideFilterRecoverFilterCompute(paramInt2, paramArrayOfInt, paramInt3, paramInt4, paramInt5);
  }
  
  private void init()
  {
    boolean bool2 = true;
    if (this.mClip8RenderFBO != null) {
      this.mClip8RenderFBO.destroy();
    }
    if (this.mSrcRenderFBO != null) {
      this.mSrcRenderFBO.destroy();
    }
    if (this.mOutputRenderFBO != null) {
      this.mOutputRenderFBO.destroy();
    }
    if (this.mCopyRenderFBO != null) {
      this.mCopyRenderFBO.destroy();
    }
    if (this.mTranmissionRenderFBO != null) {
      this.mTranmissionRenderFBO.destroy();
    }
    if (this.mCopyTextureRender != null) {
      this.mCopyTextureRender.release();
    }
    if (this.gpuImgFilterRecoverFilter != null) {
      this.gpuImgFilterRecoverFilter.destroy();
    }
    this.gpuImgFilterRecoverFilter = new GPUImgFilterRecoverFilter();
    if (this.imgFilterPixelsFilter != null) {
      this.imgFilterPixelsFilter.destroy();
    }
    this.imgFilterPixelsFilter = new GPUAvgPixelsFilter();
    if (this.gpuGuideFilterComputeFilter != null) {
      this.gpuGuideFilterComputeFilter.destroy();
    }
    this.gpuGuideFilterComputeFilter = new GPUGuideFilterComputeFilter();
    if (this.gpuGuideFilterRecoverFilter != null) {
      this.gpuGuideFilterRecoverFilter.destroy();
    }
    this.gpuGuideFilterRecoverFilter = new GPUGuideFilterRecoverFilter();
    if (this.minMaxPixelsFilter != null) {
      this.minMaxPixelsFilter.destroy();
    }
    this.minMaxPixelsFilter = new GPUMinMaxPixelsFilter();
    this.SRC_WIDTH = getQQFilterRenderManager().getFilterWidth();
    this.SRC_HEIGHT = getQQFilterRenderManager().getFilterHeight();
    this.CLIP_WIDTH = getAlignment16(getQQFilterRenderManager().getFilterWidth() / 10);
    this.CLIP_HEIGHT = getAlignment16(getQQFilterRenderManager().getFilterHeight() / 10);
    int i = this.CLIP_WIDTH;
    int j = this.CLIP_HEIGHT;
    if (Build.VERSION.SDK_INT >= 21)
    {
      bool1 = true;
      this.mClip8RenderFBO = new RenderBuffer(i, j, 33984, bool1);
      i = this.SRC_WIDTH;
      j = this.SRC_HEIGHT;
      if (Build.VERSION.SDK_INT < 21) {
        break label507;
      }
      bool1 = true;
      label326:
      this.mSrcRenderFBO = new RenderBuffer(i, j, 33984, bool1);
      i = this.SRC_WIDTH;
      j = this.SRC_HEIGHT;
      if (Build.VERSION.SDK_INT < 21) {
        break label512;
      }
      bool1 = true;
      label362:
      this.mOutputRenderFBO = new RenderBuffer(i, j, 33984, bool1);
      i = this.SRC_WIDTH;
      j = this.SRC_HEIGHT;
      if (Build.VERSION.SDK_INT < 21) {
        break label517;
      }
      bool1 = true;
      label398:
      this.mCopyRenderFBO = new RenderBuffer(i, j, 33984, bool1);
      i = this.CLIP_WIDTH;
      j = this.CLIP_HEIGHT;
      if (Build.VERSION.SDK_INT < 21) {
        break label522;
      }
    }
    label512:
    label517:
    label522:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.mTranmissionRenderFBO = new RenderBuffer(i, j, 33984, bool1);
      this.mCopyTextureRender = new TextureRender();
      SLog.d("QQImgHazeRmoveFilter", "init CLIP_HEIGHT=" + this.CLIP_HEIGHT + " CLIP_WIDTH=" + this.CLIP_WIDTH);
      return;
      bool1 = false;
      break;
      label507:
      bool1 = false;
      break label326;
      bool1 = false;
      break label362;
      bool1 = false;
      break label398;
    }
  }
  
  private int[] maxFilter(int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3)
  {
    int[] arrayOfInt1 = new int[paramInt1 * paramInt2];
    int i3 = (paramInt3 << 1) + 1;
    int[] arrayOfInt2 = new int[paramInt2];
    int i = 0;
    int k;
    int j;
    while (i < paramInt2)
    {
      k = i * paramInt1;
      getMax(paramArrayOfInt, arrayOfInt1, i, paramInt1, paramInt3);
      j = 0;
      while (j < paramInt3)
      {
        arrayOfInt1[(j + k)] = paramArrayOfInt[(j + k)];
        arrayOfInt1[(paramInt1 - j - 1 + k)] = paramArrayOfInt[(paramInt1 - j - 1 + k)];
        j += 1;
      }
      i += 1;
    }
    int i1 = 0;
    while (i1 < paramInt1)
    {
      i = arrayOfInt1[i1];
      j = 1;
      k = 0;
      int n;
      int m;
      while (j < i3)
      {
        n = j * paramInt1;
        m = i;
        if (i <= arrayOfInt1[(i1 + n)])
        {
          m = arrayOfInt1[(i1 + n)];
          k = j;
        }
        j += 1;
        i = m;
      }
      arrayOfInt2[paramInt3] = i;
      int i2 = paramInt3 + 1;
      while (i2 < paramInt2 - paramInt3) {
        if (k >= i2 - paramInt3)
        {
          m = (i2 + paramInt3) * paramInt1;
          j = i;
          if (i <= arrayOfInt1[(i1 + m)])
          {
            j = arrayOfInt1[(i1 + m)];
            k = i2 + paramInt3;
          }
          arrayOfInt2[i2] = j;
          i2 += 1;
          i = j;
        }
        else
        {
          n = i2 - paramInt3;
          m = arrayOfInt1[((i2 - paramInt3) * paramInt1 + i1)];
          i = i2 - paramInt3 + 1;
          for (;;)
          {
            j = m;
            k = n;
            if (i >= i3 + i2 - paramInt3) {
              break;
            }
            k = i * paramInt1;
            j = m;
            if (m <= arrayOfInt1[(i1 + k)])
            {
              j = arrayOfInt1[(i1 + k)];
              n = i;
            }
            i += 1;
            m = j;
          }
        }
      }
      i = paramInt3;
      while (i < paramInt2 - paramInt3)
      {
        arrayOfInt1[(i * paramInt1 + i1)] = arrayOfInt2[i];
        i += 1;
      }
      i1 += 1;
    }
    return arrayOfInt1;
  }
  
  private int[] minFilter(int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3)
  {
    int[] arrayOfInt1 = new int[paramInt1 * paramInt2];
    int i3 = (paramInt3 << 1) + 1;
    int[] arrayOfInt2 = new int[paramInt2];
    int i = 0;
    int k;
    int j;
    while (i < paramInt2)
    {
      k = i * paramInt1;
      getMin(paramArrayOfInt, arrayOfInt1, i, paramInt1, paramInt3);
      j = 0;
      while (j < paramInt3)
      {
        arrayOfInt1[(j + k)] = paramArrayOfInt[(j + k)];
        arrayOfInt1[(paramInt1 - j - 1 + k)] = paramArrayOfInt[(paramInt1 - j - 1 + k)];
        j += 1;
      }
      i += 1;
    }
    int i1 = 0;
    while (i1 < paramInt1)
    {
      i = arrayOfInt1[i1];
      j = 1;
      k = 0;
      int n;
      int m;
      while (j < i3)
      {
        n = j * paramInt1;
        m = i;
        if (i >= arrayOfInt1[(i1 + n)])
        {
          m = arrayOfInt1[(i1 + n)];
          k = j;
        }
        j += 1;
        i = m;
      }
      arrayOfInt2[paramInt3] = i;
      int i2 = paramInt3 + 1;
      while (i2 < paramInt2 - paramInt3) {
        if (k >= i2 - paramInt3)
        {
          m = (i2 + paramInt3) * paramInt1;
          j = i;
          if (i >= arrayOfInt1[(i1 + m)])
          {
            j = arrayOfInt1[(i1 + m)];
            k = i2 + paramInt3;
          }
          arrayOfInt2[i2] = j;
          i2 += 1;
          i = j;
        }
        else
        {
          n = i2 - paramInt3;
          m = arrayOfInt1[((i2 - paramInt3) * paramInt1 + i1)];
          i = i2 - paramInt3 + 1;
          for (;;)
          {
            j = m;
            k = n;
            if (i >= i3 + i2 - paramInt3) {
              break;
            }
            k = i * paramInt1;
            j = m;
            if (m >= arrayOfInt1[(i1 + k)])
            {
              j = arrayOfInt1[(i1 + k)];
              n = i;
            }
            i += 1;
            m = j;
          }
        }
      }
      i = paramInt3;
      while (i < paramInt2 - paramInt3)
      {
        arrayOfInt1[(i * paramInt1 + i1)] = arrayOfInt2[i];
        i += 1;
      }
      i1 += 1;
    }
    return arrayOfInt1;
  }
  
  private void produceDarkImgAndLightImg(byte[] paramArrayOfByte, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4)
  {
    int j = 0;
    int i = 3;
    while (i < paramArrayOfByte.length)
    {
      int n = paramArrayOfByte[(i - 3)] & 0xFF;
      int i1 = paramArrayOfByte[(i - 2)] & 0xFF;
      int i2 = paramArrayOfByte[(i - 1)] & 0xFF;
      int k = getMax(n, i1, i2);
      int m = getMin(n, i1, i2);
      n = getGray(n, i1, i2);
      paramArrayOfInt1[j] = k;
      paramArrayOfInt2[j] = m;
      paramArrayOfInt3[j] = n;
      k = n / 20;
      paramArrayOfInt4[k] += 1;
      j += 1;
      i += 4;
    }
  }
  
  private int scaleTexture(int paramInt)
  {
    this.mSrcRenderFBO.bind();
    this.mCopyTextureRender.drawTexture(3553, paramInt, null, null);
    this.mSrcRenderFBO.unbind();
    return this.mSrcRenderFBO.getTexId();
  }
  
  public void checkGlError(String paramString)
  {
    for (;;)
    {
      int i = GLES20.glGetError();
      if (i == 0) {
        break;
      }
      SLog.e("QQImgHazeRmoveFilter", new RuntimeException(paramString + ": glError " + i));
    }
  }
  
  public int getAlignment16(int paramInt)
  {
    int i = paramInt % 16;
    if (i == 0) {
      return paramInt;
    }
    return paramInt + 16 - i;
  }
  
  float getAtmosphericLight(int[] paramArrayOfInt, long[] paramArrayOfLong, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = paramInt1 * paramInt2 / 1000;
    paramInt3 = i;
    if (i <= 0) {
      paramInt3 = paramInt1 * paramInt2 / 100;
    }
    paramInt2 = 0;
    float f1 = 0.0F;
    paramInt1 = 12;
    for (;;)
    {
      if ((paramInt1 < 0) || (paramInt2 > paramInt3)) {
        return f1 / paramInt2;
      }
      paramInt2 += paramArrayOfInt[paramInt1];
      float f2 = f1;
      if (paramArrayOfInt[paramInt1] > 0) {
        f2 = f1 + (float)paramArrayOfLong[paramInt1] * 1.0F;
      }
      paramInt1 -= 1;
      f1 = f2;
    }
  }
  
  public int getGray(int paramInt1, int paramInt2, int paramInt3)
  {
    return (int)(paramInt1 * 0.299F + paramInt2 * 0.587F + paramInt3 * 0.114F);
  }
  
  public int getMax(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt2 > paramInt1) {}
    while (paramInt3 > paramInt2)
    {
      return paramInt3;
      paramInt2 = paramInt1;
    }
    return paramInt2;
  }
  
  void getMax(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = 0;
    int n = paramInt1 * paramInt2;
    int i1 = (paramInt3 << 1) + 1;
    int j = paramArrayOfInt1[(n + 0)];
    paramInt1 = 1;
    while (paramInt1 < i1)
    {
      k = j;
      if (j <= paramArrayOfInt1[(paramInt1 + n)])
      {
        k = paramArrayOfInt1[(paramInt1 + n)];
        i = paramInt1;
      }
      paramInt1 += 1;
      j = k;
    }
    paramArrayOfInt2[(paramInt3 + n)] = paramArrayOfInt1[(i + n)];
    int k = paramInt3 + 1;
    if (k < paramInt2 - paramInt3) {
      if (i >= k - paramInt3)
      {
        paramInt1 = (paramInt3 << 1) + k - paramInt3;
        j = i;
        if (paramArrayOfInt1[(i + n)] > paramArrayOfInt1[(paramInt1 + n)]) {
          break label247;
        }
      }
    }
    for (;;)
    {
      paramArrayOfInt2[(k + n)] = paramArrayOfInt1[(paramInt1 + n)];
      k += 1;
      i = paramInt1;
      break;
      i = k - paramInt3;
      int m = paramArrayOfInt1[(k - paramInt3 + n)];
      paramInt1 = k - paramInt3 + 1;
      for (;;)
      {
        j = i;
        if (paramInt1 >= i1 + k - paramInt3) {
          break;
        }
        j = m;
        if (m <= paramArrayOfInt1[(paramInt1 + n)])
        {
          j = paramArrayOfInt1[(paramInt1 + n)];
          i = paramInt1;
        }
        paramInt1 += 1;
        m = j;
      }
      return;
      label247:
      paramInt1 = j;
    }
  }
  
  public int getMin(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt2 < paramInt1) {}
    while (paramInt3 < paramInt2)
    {
      return paramInt3;
      paramInt2 = paramInt1;
    }
    return paramInt2;
  }
  
  void getMin(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = 0;
    int n = paramInt1 * paramInt2;
    int i1 = (paramInt3 << 1) + 1;
    int j = paramArrayOfInt1[(n + 0)];
    paramInt1 = 1;
    while (paramInt1 < i1)
    {
      k = j;
      if (j >= paramArrayOfInt1[(paramInt1 + n)])
      {
        k = paramArrayOfInt1[(paramInt1 + n)];
        i = paramInt1;
      }
      paramInt1 += 1;
      j = k;
    }
    paramArrayOfInt2[(paramInt3 + n)] = paramArrayOfInt1[(i + n)];
    int k = paramInt3 + 1;
    if (k < paramInt2 - paramInt3) {
      if (i >= k - paramInt3)
      {
        paramInt1 = (paramInt3 << 1) + k - paramInt3;
        j = i;
        if (paramArrayOfInt1[(i + n)] < paramArrayOfInt1[(paramInt1 + n)]) {
          break label247;
        }
      }
    }
    for (;;)
    {
      paramArrayOfInt2[(k + n)] = paramArrayOfInt1[(paramInt1 + n)];
      k += 1;
      i = paramInt1;
      break;
      i = k - paramInt3;
      int m = paramArrayOfInt1[(k - paramInt3 + n)];
      paramInt1 = k - paramInt3 + 1;
      for (;;)
      {
        j = i;
        if (paramInt1 >= i1 + k - paramInt3) {
          break;
        }
        j = m;
        if (m >= paramArrayOfInt1[(paramInt1 + n)])
        {
          j = paramArrayOfInt1[(paramInt1 + n)];
          i = paramInt1;
        }
        paramInt1 += 1;
        m = j;
      }
      return;
      label247:
      paramInt1 = j;
    }
  }
  
  public void guidedFilter(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, int paramInt1, float paramFloat, int paramInt2, int paramInt3, float[] paramArrayOfFloat3, float[] paramArrayOfFloat4, float[] paramArrayOfFloat5, float[] paramArrayOfFloat6)
  {
    int i = paramInt1 * 2 + 1;
    int i1 = i * i;
    int j = 0;
    int k;
    float f1;
    int m;
    int n;
    while (j < paramInt3)
    {
      k = 0;
      while (k < paramInt2)
      {
        i = 0;
        float f2 = 0.0F;
        f1 = 0.0F;
        m = j - paramInt1;
        while (m <= j + paramInt1)
        {
          n = k - paramInt1;
          if (n <= k + paramInt1)
          {
            if ((m < 0) || (m >= paramInt3)) {
              i += 1;
            }
            for (;;)
            {
              n += 1;
              break;
              if ((n < 0) || (n >= paramInt2))
              {
                i += 1;
              }
              else
              {
                f2 += paramArrayOfFloat2[(m * paramInt2 + n)];
                f1 += paramArrayOfFloat1[(m * paramInt2 + n)];
              }
            }
          }
          m += 1;
        }
        float f3 = f2 / (i1 - i);
        float f4 = f1 / (i1 - i);
        i = 0;
        f2 = 0.0F;
        f1 = 0.0F;
        m = j - paramInt1;
        while (m <= j + paramInt1)
        {
          n = k - paramInt1;
          if (n <= k + paramInt1)
          {
            if ((m < 0) || (m >= paramInt3)) {
              i += 1;
            }
            for (;;)
            {
              n += 1;
              break;
              if ((n < 0) || (n >= paramInt2))
              {
                i += 1;
              }
              else
              {
                f2 += paramArrayOfFloat1[(m * paramInt2 + n)] * paramArrayOfFloat2[(m * paramInt2 + n)];
                f1 += (paramArrayOfFloat2[(m * paramInt2 + n)] - f3) * (paramArrayOfFloat2[(m * paramInt2 + n)] - f3);
              }
            }
          }
          m += 1;
        }
        paramArrayOfFloat3[(j * paramInt2 + k)] = ((f2 / (i1 - i) - f3 * f4) / (f1 / (i1 - i) + paramFloat));
        paramArrayOfFloat4[(j * paramInt2 + k)] = (f4 - paramArrayOfFloat3[(j * paramInt2 + k)] * f3);
        k += 1;
      }
      j += 1;
    }
    j = 0;
    while (j < paramInt3)
    {
      k = 0;
      while (k < paramInt2)
      {
        i = 0;
        f1 = 0.0F;
        paramFloat = 0.0F;
        m = j - paramInt1;
        while (m <= j + paramInt1)
        {
          n = k - paramInt1;
          if (n <= k + paramInt1)
          {
            if ((m < 0) || (m >= paramInt3)) {
              i += 1;
            }
            for (;;)
            {
              n += 1;
              break;
              if ((n < 0) || (n >= paramInt2))
              {
                i += 1;
              }
              else
              {
                f1 += paramArrayOfFloat3[(m * paramInt2 + n)];
                paramFloat += paramArrayOfFloat4[(m * paramInt2 + n)];
              }
            }
          }
          m += 1;
        }
        paramArrayOfFloat5[(j * paramInt2 + k)] = (f1 / (i1 - i));
        paramArrayOfFloat6[(j * paramInt2 + k)] = (paramFloat / (i1 - i));
        f1 = paramArrayOfFloat5[(j * paramInt2 + k)] * paramArrayOfFloat2[(j * paramInt2 + k)] + paramArrayOfFloat6[(j * paramInt2 + k)];
        paramFloat = f1;
        if (f1 > 1.0F) {
          paramFloat = 1.0F;
        }
        f1 = paramFloat;
        if (paramFloat < 0.0F) {
          f1 = 0.0F;
        }
        paramArrayOfFloat1[(j * paramInt2 + k)] = f1;
        k += 1;
      }
      j += 1;
    }
  }
  
  public boolean isFilterWork()
  {
    return super.isFilterWork();
  }
  
  @SuppressLint({"NewApi"})
  public void onDrawFrame()
  {
    if (!this.enableImgFilter)
    {
      this.mOutputTextureID = this.mInputTextureID;
      return;
    }
    if ((this.mClip8RenderFBO == null) || (this.mCopyTextureRender == null))
    {
      init();
      this.mOutputTextureID = this.mInputTextureID;
      return;
    }
    int[] arrayOfInt1 = new int[5];
    GLES20.glGenBuffers(5, arrayOfInt1, 0);
    checkGlError("glGenBuffers");
    int j = clipTexture(this.mInputTextureID);
    int[] arrayOfInt2 = this.imgFilterPixelsFilter.glDisPatchGPUAvgPixelsFilterCompute(j, this.CLIP_WIDTH, this.CLIP_HEIGHT, arrayOfInt1, this.mWindow);
    float[] arrayOfFloat = new float[this.CLIP_HEIGHT * this.CLIP_WIDTH];
    int[] arrayOfInt3 = new int[13];
    long[] arrayOfLong = new long[13];
    int i = 0;
    while (i < arrayOfInt2.length)
    {
      k = arrayOfInt2[i];
      int m = k / 20;
      arrayOfInt3[m] += 1;
      arrayOfLong[m] += k;
      arrayOfFloat[i] = (k / 255.0F);
      i += 1;
    }
    float f = getAtmosphericLight(arrayOfInt3, arrayOfLong, this.CLIP_WIDTH, this.CLIP_HEIGHT, this.mWindow);
    SLog.d("QQImgHazeRmoveFilter", "getAtmosphericLight=" + f);
    i = copyTransmissionTexture();
    getTransmissionDark(j, i, arrayOfInt1, this.CLIP_WIDTH, this.CLIP_HEIGHT, arrayOfFloat, f, this.mWindow);
    i = scaleTexture(i);
    j = copyInputTexture(this.mInputTextureID);
    int k = copyoutputTexture(this.mInputTextureID);
    i = this.gpuImgFilterRecoverFilter.glDisPatchImgFilterCompute(arrayOfInt1, j, k, i, f, this.SRC_WIDTH, this.SRC_HEIGHT, null);
    GLES20.glDeleteBuffers(5, arrayOfInt1, 0);
    this.mOutputTextureID = i;
  }
  
  public void onSurfaceChange(int paramInt1, int paramInt2)
  {
    super.onSurfaceChange(paramInt1, paramInt2);
  }
  
  public void onSurfaceCreate()
  {
    super.onSurfaceCreate();
  }
  
  public void onSurfaceDestroy()
  {
    super.onSurfaceDestroy();
  }
  
  public void setEnable(boolean paramBoolean)
  {
    this.enableImgFilter = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.filter.QQImgHazeRmoveFilter
 * JD-Core Version:    0.7.0.1
 */