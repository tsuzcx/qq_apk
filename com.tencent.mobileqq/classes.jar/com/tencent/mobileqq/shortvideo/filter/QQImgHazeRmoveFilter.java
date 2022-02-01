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
    Object localObject = this.mClip8RenderFBO;
    if (localObject != null) {
      ((RenderBuffer)localObject).destroy();
    }
    localObject = this.mSrcRenderFBO;
    if (localObject != null) {
      ((RenderBuffer)localObject).destroy();
    }
    localObject = this.mOutputRenderFBO;
    if (localObject != null) {
      ((RenderBuffer)localObject).destroy();
    }
    localObject = this.mCopyRenderFBO;
    if (localObject != null) {
      ((RenderBuffer)localObject).destroy();
    }
    localObject = this.mTranmissionRenderFBO;
    if (localObject != null) {
      ((RenderBuffer)localObject).destroy();
    }
    localObject = this.mCopyTextureRender;
    if (localObject != null) {
      ((TextureRender)localObject).release();
    }
    localObject = this.gpuImgFilterRecoverFilter;
    if (localObject != null) {
      ((GPUImgFilterRecoverFilter)localObject).destroy();
    }
    this.gpuImgFilterRecoverFilter = new GPUImgFilterRecoverFilter();
    localObject = this.imgFilterPixelsFilter;
    if (localObject != null) {
      ((GPUAvgPixelsFilter)localObject).destroy();
    }
    this.imgFilterPixelsFilter = new GPUAvgPixelsFilter();
    localObject = this.gpuGuideFilterComputeFilter;
    if (localObject != null) {
      ((GPUGuideFilterComputeFilter)localObject).destroy();
    }
    this.gpuGuideFilterComputeFilter = new GPUGuideFilterComputeFilter();
    localObject = this.gpuGuideFilterRecoverFilter;
    if (localObject != null) {
      ((GPUGuideFilterRecoverFilter)localObject).destroy();
    }
    this.gpuGuideFilterRecoverFilter = new GPUGuideFilterRecoverFilter();
    localObject = this.minMaxPixelsFilter;
    if (localObject != null) {
      ((GPUMinMaxPixelsFilter)localObject).destroy();
    }
    this.minMaxPixelsFilter = new GPUMinMaxPixelsFilter();
    this.SRC_WIDTH = getQQFilterRenderManager().getFilterWidth();
    this.SRC_HEIGHT = getQQFilterRenderManager().getFilterHeight();
    this.CLIP_WIDTH = getAlignment16(getQQFilterRenderManager().getFilterWidth() / 10);
    this.CLIP_HEIGHT = getAlignment16(getQQFilterRenderManager().getFilterHeight() / 10);
    int i = this.CLIP_WIDTH;
    int j = this.CLIP_HEIGHT;
    int k = Build.VERSION.SDK_INT;
    boolean bool2 = true;
    boolean bool1;
    if (k >= 21) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.mClip8RenderFBO = new RenderBuffer(i, j, 33984, bool1);
    i = this.SRC_WIDTH;
    j = this.SRC_HEIGHT;
    if (Build.VERSION.SDK_INT >= 21) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.mSrcRenderFBO = new RenderBuffer(i, j, 33984, bool1);
    i = this.SRC_WIDTH;
    j = this.SRC_HEIGHT;
    if (Build.VERSION.SDK_INT >= 21) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.mOutputRenderFBO = new RenderBuffer(i, j, 33984, bool1);
    i = this.SRC_WIDTH;
    j = this.SRC_HEIGHT;
    if (Build.VERSION.SDK_INT >= 21) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.mCopyRenderFBO = new RenderBuffer(i, j, 33984, bool1);
    i = this.CLIP_WIDTH;
    j = this.CLIP_HEIGHT;
    if (Build.VERSION.SDK_INT >= 21) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    this.mTranmissionRenderFBO = new RenderBuffer(i, j, 33984, bool1);
    this.mCopyTextureRender = new TextureRender();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("init CLIP_HEIGHT=");
    ((StringBuilder)localObject).append(this.CLIP_HEIGHT);
    ((StringBuilder)localObject).append(" CLIP_WIDTH=");
    ((StringBuilder)localObject).append(this.CLIP_WIDTH);
    SLog.d("QQImgHazeRmoveFilter", ((StringBuilder)localObject).toString());
  }
  
  private int[] maxFilter(int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3)
  {
    int[] arrayOfInt1 = new int[paramInt1 * paramInt2];
    int i3 = (paramInt3 << 1) + 1;
    int[] arrayOfInt2 = new int[paramInt2];
    int i = 0;
    int k;
    int j;
    int m;
    while (i < paramInt2)
    {
      k = i * paramInt1;
      getMax(paramArrayOfInt, arrayOfInt1, i, paramInt1, paramInt3);
      j = 0;
      while (j < paramInt3)
      {
        m = j + k;
        arrayOfInt1[m] = paramArrayOfInt[m];
        m = paramInt1 - j - 1 + k;
        arrayOfInt1[m] = paramArrayOfInt[m];
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
      while (j < i3)
      {
        n = j * paramInt1 + i1;
        m = i;
        if (i <= arrayOfInt1[n])
        {
          m = arrayOfInt1[n];
          k = j;
        }
        j += 1;
        i = m;
      }
      arrayOfInt2[paramInt3] = i;
      int i2 = paramInt3 + 1;
      for (;;)
      {
        j = paramInt2 - paramInt3;
        if (i2 >= j) {
          break;
        }
        j = i2 - paramInt3;
        if (k >= j)
        {
          n = i2 + paramInt3;
          j = n * paramInt1 + i1;
          m = i;
          if (i > arrayOfInt1[j]) {
            break label365;
          }
          m = arrayOfInt1[j];
        }
        else
        {
          m = arrayOfInt1[(j * paramInt1 + i1)];
          i = j + 1;
          k = j;
          for (j = m;; j = m)
          {
            m = j;
            n = k;
            if (i >= i3 + i2 - paramInt3) {
              break;
            }
            n = i * paramInt1 + i1;
            m = j;
            if (j <= arrayOfInt1[n])
            {
              m = arrayOfInt1[n];
              k = i;
            }
            i += 1;
          }
        }
        k = n;
        label365:
        arrayOfInt2[i2] = m;
        i2 += 1;
        i = m;
      }
      i = paramInt3;
      while (i < j)
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
    int m;
    while (i < paramInt2)
    {
      k = i * paramInt1;
      getMin(paramArrayOfInt, arrayOfInt1, i, paramInt1, paramInt3);
      j = 0;
      while (j < paramInt3)
      {
        m = j + k;
        arrayOfInt1[m] = paramArrayOfInt[m];
        m = paramInt1 - j - 1 + k;
        arrayOfInt1[m] = paramArrayOfInt[m];
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
      while (j < i3)
      {
        n = j * paramInt1 + i1;
        m = i;
        if (i >= arrayOfInt1[n])
        {
          m = arrayOfInt1[n];
          k = j;
        }
        j += 1;
        i = m;
      }
      arrayOfInt2[paramInt3] = i;
      int i2 = paramInt3 + 1;
      for (;;)
      {
        j = paramInt2 - paramInt3;
        if (i2 >= j) {
          break;
        }
        j = i2 - paramInt3;
        if (k >= j)
        {
          n = i2 + paramInt3;
          j = n * paramInt1 + i1;
          m = i;
          if (i < arrayOfInt1[j]) {
            break label365;
          }
          m = arrayOfInt1[j];
        }
        else
        {
          m = arrayOfInt1[(j * paramInt1 + i1)];
          i = j + 1;
          k = j;
          for (j = m;; j = m)
          {
            m = j;
            n = k;
            if (i >= i3 + i2 - paramInt3) {
              break;
            }
            n = i * paramInt1 + i1;
            m = j;
            if (j >= arrayOfInt1[n])
            {
              m = arrayOfInt1[n];
              k = i;
            }
            i += 1;
          }
        }
        k = n;
        label365:
        arrayOfInt2[i2] = m;
        i2 += 1;
        i = m;
      }
      i = paramInt3;
      while (i < j)
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
    int i = 3;
    int j = 0;
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(": glError ");
      localStringBuilder.append(i);
      SLog.e("QQImgHazeRmoveFilter", new RuntimeException(localStringBuilder.toString()));
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
    paramInt3 = paramInt1 * paramInt2;
    paramInt2 = paramInt3 / 1000;
    paramInt1 = paramInt2;
    if (paramInt2 <= 0) {
      paramInt1 = paramInt3 / 100;
    }
    paramInt3 = 0;
    float f1 = 0.0F;
    paramInt2 = 12;
    while ((paramInt2 >= 0) && (paramInt3 <= paramInt1))
    {
      paramInt3 += paramArrayOfInt[paramInt2];
      float f2 = f1;
      if (paramArrayOfInt[paramInt2] > 0) {
        f2 = f1 + (float)paramArrayOfLong[paramInt2] * 1.0F;
      }
      paramInt2 -= 1;
      f1 = f2;
    }
    return f1 / paramInt3;
  }
  
  public int getGray(int paramInt1, int paramInt2, int paramInt3)
  {
    return (int)(paramInt1 * 0.299F + paramInt2 * 0.587F + paramInt3 * 0.114F);
  }
  
  public int getMax(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = paramInt1;
    if (paramInt2 > paramInt1) {
      i = paramInt2;
    }
    paramInt1 = i;
    if (paramInt3 > i) {
      paramInt1 = paramInt3;
    }
    return paramInt1;
  }
  
  void getMax(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt1, int paramInt2, int paramInt3)
  {
    int n = paramInt1 * paramInt2;
    int i1 = paramInt3 << 1;
    int i2 = i1 + 1;
    int j = paramArrayOfInt1[(n + 0)];
    int i = 0;
    paramInt1 = 1;
    int m;
    while (paramInt1 < i2)
    {
      m = paramInt1 + n;
      k = j;
      if (j <= paramArrayOfInt1[m])
      {
        k = paramArrayOfInt1[m];
        i = paramInt1;
      }
      paramInt1 += 1;
      j = k;
    }
    paramArrayOfInt2[(paramInt3 + n)] = paramArrayOfInt1[(i + n)];
    int k = paramInt3 + 1;
    while (k < paramInt2 - paramInt3)
    {
      j = k - paramInt3;
      if (i >= j)
      {
        j = i1 + k - paramInt3;
        paramInt1 = i;
        if (paramArrayOfInt1[(i + n)] > paramArrayOfInt1[(j + n)]) {
          break label229;
        }
      }
      else
      {
        m = paramArrayOfInt1[(j + n)];
        paramInt1 = j + 1;
        i = j;
        for (;;)
        {
          j = i;
          if (paramInt1 >= i2 + k - paramInt3) {
            break;
          }
          int i3 = paramInt1 + n;
          j = m;
          if (m <= paramArrayOfInt1[i3])
          {
            j = paramArrayOfInt1[i3];
            i = paramInt1;
          }
          paramInt1 += 1;
          m = j;
        }
      }
      paramInt1 = j;
      label229:
      paramArrayOfInt2[(k + n)] = paramArrayOfInt1[(paramInt1 + n)];
      k += 1;
      i = paramInt1;
    }
  }
  
  public int getMin(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = paramInt1;
    if (paramInt2 < paramInt1) {
      i = paramInt2;
    }
    paramInt1 = i;
    if (paramInt3 < i) {
      paramInt1 = paramInt3;
    }
    return paramInt1;
  }
  
  void getMin(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt1, int paramInt2, int paramInt3)
  {
    int n = paramInt1 * paramInt2;
    int i1 = paramInt3 << 1;
    int i2 = i1 + 1;
    int j = paramArrayOfInt1[(n + 0)];
    int i = 0;
    paramInt1 = 1;
    int m;
    while (paramInt1 < i2)
    {
      m = paramInt1 + n;
      k = j;
      if (j >= paramArrayOfInt1[m])
      {
        k = paramArrayOfInt1[m];
        i = paramInt1;
      }
      paramInt1 += 1;
      j = k;
    }
    paramArrayOfInt2[(paramInt3 + n)] = paramArrayOfInt1[(i + n)];
    int k = paramInt3 + 1;
    while (k < paramInt2 - paramInt3)
    {
      j = k - paramInt3;
      if (i >= j)
      {
        j = i1 + k - paramInt3;
        paramInt1 = i;
        if (paramArrayOfInt1[(i + n)] < paramArrayOfInt1[(j + n)]) {
          break label229;
        }
      }
      else
      {
        m = paramArrayOfInt1[(j + n)];
        paramInt1 = j + 1;
        i = j;
        for (;;)
        {
          j = i;
          if (paramInt1 >= i2 + k - paramInt3) {
            break;
          }
          int i3 = paramInt1 + n;
          j = m;
          if (m >= paramArrayOfInt1[i3])
          {
            j = paramArrayOfInt1[i3];
            i = paramInt1;
          }
          paramInt1 += 1;
          m = j;
        }
      }
      paramInt1 = j;
      label229:
      paramArrayOfInt2[(k + n)] = paramArrayOfInt1[(paramInt1 + n)];
      k += 1;
      i = paramInt1;
    }
  }
  
  public void guidedFilter(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, int paramInt1, float paramFloat, int paramInt2, int paramInt3, float[] paramArrayOfFloat3, float[] paramArrayOfFloat4, float[] paramArrayOfFloat5, float[] paramArrayOfFloat6)
  {
    int i = paramInt1 * 2 + 1;
    int i2 = i * i;
    i = 0;
    int j;
    int k;
    int m;
    float f2;
    int i1;
    float f1;
    int n;
    while (i < paramInt3)
    {
      j = 0;
      while (j < paramInt2)
      {
        k = i - paramInt1;
        m = k;
        f2 = 0.0F;
        i1 = 0;
        f1 = 0.0F;
        int i3;
        for (;;)
        {
          i3 = i + paramInt1;
          if (m > i3) {
            break;
          }
          n = j - paramInt1;
          while (n <= j + paramInt1)
          {
            if ((m >= 0) && (m < paramInt3) && (n >= 0) && (n < paramInt2))
            {
              i3 = m * paramInt2 + n;
              f2 += paramArrayOfFloat2[i3];
              f1 += paramArrayOfFloat1[i3];
            }
            else
            {
              i1 += 1;
            }
            n += 1;
          }
          m += 1;
        }
        float f4 = i2 - i1;
        float f3 = f2 / f4;
        f4 = f1 / f4;
        f1 = 0.0F;
        n = 0;
        f2 = 0.0F;
        while (k <= i3)
        {
          m = j - paramInt1;
          while (m <= j + paramInt1)
          {
            if ((k >= 0) && (k < paramInt3) && (m >= 0) && (m < paramInt2))
            {
              i1 = k * paramInt2 + m;
              f1 += paramArrayOfFloat1[i1] * paramArrayOfFloat2[i1];
              f2 += (paramArrayOfFloat2[i1] - f3) * (paramArrayOfFloat2[i1] - f3);
            }
            else
            {
              n += 1;
            }
            m += 1;
          }
          k += 1;
        }
        k = i * paramInt2 + j;
        float f5 = i2 - n;
        paramArrayOfFloat3[k] = ((f1 / f5 - f3 * f4) / (f2 / f5 + paramFloat));
        paramArrayOfFloat4[k] = (f4 - paramArrayOfFloat3[k] * f3);
        j += 1;
      }
      i += 1;
    }
    i = 0;
    while (i < paramInt3)
    {
      j = 0;
      while (j < paramInt2)
      {
        k = i - paramInt1;
        paramFloat = 0.0F;
        n = 0;
        f1 = 0.0F;
        while (k <= i + paramInt1)
        {
          m = j - paramInt1;
          while (m <= j + paramInt1)
          {
            if ((k >= 0) && (k < paramInt3) && (m >= 0) && (m < paramInt2))
            {
              i1 = k * paramInt2 + m;
              paramFloat += paramArrayOfFloat3[i1];
              f1 += paramArrayOfFloat4[i1];
            }
            else
            {
              n += 1;
            }
            m += 1;
          }
          k += 1;
        }
        k = i * paramInt2 + j;
        f2 = i2 - n;
        paramArrayOfFloat5[k] = (paramFloat / f2);
        paramArrayOfFloat6[k] = (f1 / f2);
        f1 = paramArrayOfFloat5[k] * paramArrayOfFloat2[k] + paramArrayOfFloat6[k];
        paramFloat = f1;
        if (f1 > 1.0F) {
          paramFloat = 1.0F;
        }
        f1 = paramFloat;
        if (paramFloat < 0.0F) {
          f1 = 0.0F;
        }
        paramArrayOfFloat1[k] = f1;
        j += 1;
      }
      i += 1;
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
    if ((this.mClip8RenderFBO != null) && (this.mCopyTextureRender != null))
    {
      int[] arrayOfInt1 = new int[5];
      GLES20.glGenBuffers(5, arrayOfInt1, 0);
      checkGlError("glGenBuffers");
      int j = clipTexture(this.mInputTextureID);
      Object localObject = this.imgFilterPixelsFilter.glDisPatchGPUAvgPixelsFilterCompute(j, this.CLIP_WIDTH, this.CLIP_HEIGHT, arrayOfInt1, this.mWindow);
      float[] arrayOfFloat = new float[this.CLIP_HEIGHT * this.CLIP_WIDTH];
      int[] arrayOfInt2 = new int[13];
      long[] arrayOfLong = new long[13];
      int i = 0;
      while (i < localObject.length)
      {
        k = localObject[i];
        int m = k / 20;
        arrayOfInt2[m] += 1;
        arrayOfLong[m] += k;
        arrayOfFloat[i] = (k / 255.0F);
        i += 1;
      }
      float f = getAtmosphericLight(arrayOfInt2, arrayOfLong, this.CLIP_WIDTH, this.CLIP_HEIGHT, this.mWindow);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getAtmosphericLight=");
      ((StringBuilder)localObject).append(f);
      SLog.d("QQImgHazeRmoveFilter", ((StringBuilder)localObject).toString());
      i = copyTransmissionTexture();
      getTransmissionDark(j, i, arrayOfInt1, this.CLIP_WIDTH, this.CLIP_HEIGHT, arrayOfFloat, f, this.mWindow);
      i = scaleTexture(i);
      j = copyInputTexture(this.mInputTextureID);
      int k = copyoutputTexture(this.mInputTextureID);
      i = this.gpuImgFilterRecoverFilter.glDisPatchImgFilterCompute(arrayOfInt1, j, k, i, f, this.SRC_WIDTH, this.SRC_HEIGHT, null);
      GLES20.glDeleteBuffers(5, arrayOfInt1, 0);
      this.mOutputTextureID = i;
      return;
    }
    init();
    this.mOutputTextureID = this.mInputTextureID;
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