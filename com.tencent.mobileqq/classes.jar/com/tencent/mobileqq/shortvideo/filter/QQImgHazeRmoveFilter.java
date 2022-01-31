package com.tencent.mobileqq.shortvideo.filter;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.SystemClock;
import com.tencent.mobileqq.richmedia.mediacodec.computeShader.GPUGuideFilterComputeFilter;
import com.tencent.mobileqq.richmedia.mediacodec.computeShader.GPUGuideFilterRecoverFilter;
import com.tencent.mobileqq.richmedia.mediacodec.computeShader.GPUImgFilterPixelsFilter;
import com.tencent.mobileqq.richmedia.mediacodec.computeShader.GPUImgFilterRecoverFilter;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.RenderBuffer;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.TextureRender;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.sveffects.SLog;

@SuppressLint({"NewApi"})
public class QQImgHazeRmoveFilter
  extends QQBaseFilter
{
  private float jdField_a_of_type_Float = 0.9F;
  private GPUGuideFilterComputeFilter jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecComputeShaderGPUGuideFilterComputeFilter;
  private GPUGuideFilterRecoverFilter jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecComputeShaderGPUGuideFilterRecoverFilter;
  private GPUImgFilterPixelsFilter jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecComputeShaderGPUImgFilterPixelsFilter;
  private GPUImgFilterRecoverFilter jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecComputeShaderGPUImgFilterRecoverFilter;
  private RenderBuffer jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer;
  private TextureRender jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererTextureRender;
  private boolean jdField_a_of_type_Boolean = false;
  private RenderBuffer jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer;
  private TextureRender jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecRendererTextureRender;
  private RenderBuffer jdField_c_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer;
  private TextureRender jdField_c_of_type_ComTencentMobileqqRichmediaMediacodecRendererTextureRender;
  private RenderBuffer jdField_d_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer;
  private TextureRender jdField_d_of_type_ComTencentMobileqqRichmediaMediacodecRendererTextureRender;
  public int e;
  public int f;
  public int g;
  public int h;
  private int i = 11;
  
  public QQImgHazeRmoveFilter(int paramInt, QQFilterRenderManager paramQQFilterRenderManager)
  {
    super(paramInt, paramQQFilterRenderManager);
  }
  
  private int a(float[] paramArrayOfFloat)
  {
    Object localObject = new int[paramArrayOfFloat.length];
    int j = 0;
    if (j < paramArrayOfFloat.length)
    {
      if (paramArrayOfFloat[j] > 0.1D) {}
      for (float f1 = paramArrayOfFloat[j];; f1 = 0.1F)
      {
        int m = (int)(f1 * 255.0F);
        int k = m;
        if (m > 255) {
          k = 255;
        }
        localObject[j] = Color.rgb(k, k, k);
        j += 1;
        break;
      }
    }
    paramArrayOfFloat = GlUtil.a((int[])localObject);
    localObject = Bitmap.createBitmap(this.h, this.g, Bitmap.Config.ARGB_8888);
    ((Bitmap)localObject).copyPixelsFromBuffer(paramArrayOfFloat);
    j = GlUtil.a(3553, (Bitmap)localObject);
    ((Bitmap)localObject).recycle();
    return j;
  }
  
  private void a()
  {
    boolean bool2 = true;
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.d();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererTextureRender != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererTextureRender.a();
    }
    if (this.jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer != null) {
      this.jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.d();
    }
    if (this.jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecRendererTextureRender != null) {
      this.jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecRendererTextureRender.a();
    }
    if (this.jdField_c_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer != null) {
      this.jdField_c_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.d();
    }
    if (this.jdField_c_of_type_ComTencentMobileqqRichmediaMediacodecRendererTextureRender != null) {
      this.jdField_c_of_type_ComTencentMobileqqRichmediaMediacodecRendererTextureRender.a();
    }
    if (this.jdField_d_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer != null) {
      this.jdField_d_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.d();
    }
    if (this.jdField_d_of_type_ComTencentMobileqqRichmediaMediacodecRendererTextureRender != null) {
      this.jdField_d_of_type_ComTencentMobileqqRichmediaMediacodecRendererTextureRender.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecComputeShaderGPUImgFilterRecoverFilter != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecComputeShaderGPUImgFilterRecoverFilter.b();
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecComputeShaderGPUImgFilterRecoverFilter = new GPUImgFilterRecoverFilter();
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecComputeShaderGPUImgFilterPixelsFilter != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecComputeShaderGPUImgFilterPixelsFilter.b();
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecComputeShaderGPUImgFilterPixelsFilter = new GPUImgFilterPixelsFilter();
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecComputeShaderGPUGuideFilterComputeFilter != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecComputeShaderGPUGuideFilterComputeFilter.b();
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecComputeShaderGPUGuideFilterComputeFilter = new GPUGuideFilterComputeFilter();
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecComputeShaderGPUGuideFilterRecoverFilter != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecComputeShaderGPUGuideFilterRecoverFilter.b();
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecComputeShaderGPUGuideFilterRecoverFilter = new GPUGuideFilterRecoverFilter();
    this.f = a().f();
    this.e = a().g();
    this.h = a(a().f() / 8);
    this.g = a(a().g() / 8);
    int j = this.h;
    int k = this.g;
    if (Build.VERSION.SDK_INT >= 21)
    {
      bool1 = true;
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer = new RenderBuffer(j, k, 33984, bool1);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererTextureRender = new TextureRender();
      j = this.f;
      k = this.e;
      if (Build.VERSION.SDK_INT < 21) {
        break label507;
      }
      bool1 = true;
      label340:
      this.jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer = new RenderBuffer(j, k, 33984, bool1);
      this.jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecRendererTextureRender = new TextureRender();
      j = this.f;
      k = this.e;
      if (Build.VERSION.SDK_INT < 21) {
        break label512;
      }
      bool1 = true;
      label387:
      this.jdField_c_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer = new RenderBuffer(j, k, 33984, bool1);
      this.jdField_c_of_type_ComTencentMobileqqRichmediaMediacodecRendererTextureRender = new TextureRender();
      j = this.f;
      k = this.e;
      if (Build.VERSION.SDK_INT < 21) {
        break label517;
      }
    }
    label512:
    label517:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.jdField_d_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer = new RenderBuffer(j, k, 33984, bool1);
      this.jdField_d_of_type_ComTencentMobileqqRichmediaMediacodecRendererTextureRender = new TextureRender();
      SLog.d("QQImgHazeRmoveFilter", "init CLIP_HEIGHT=" + this.g + " CLIP_WIDTH=" + this.h);
      return;
      bool1 = false;
      break;
      label507:
      bool1 = false;
      break label340;
      bool1 = false;
      break label387;
    }
  }
  
  private float[] a(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2, float[] paramArrayOfFloat, int[] paramArrayOfInt3, int paramInt3)
  {
    float f1 = (paramArrayOfInt3[0] + paramArrayOfInt3[1] + paramArrayOfInt3[2]) / 3.0F;
    paramArrayOfInt3 = new float[paramInt1 * paramInt2];
    int j = (paramInt3 - 1) / 2;
    j = 0;
    while (j < paramInt2)
    {
      int m = j * paramInt1;
      int k = 0;
      if (k < paramInt1)
      {
        if (paramArrayOfInt2[(k + m)] < 130)
        {
          paramArrayOfInt3[(k + m)] = (1.0F - paramArrayOfInt1[(k + m)] * 0.8F / 256.0F * this.jdField_a_of_type_Float * paramArrayOfInt2[(k + m)] / f1);
          if (paramArrayOfInt3[(k + m)] > 1.0F) {
            paramArrayOfInt3[(k + m)] = 1.0F;
          }
        }
        for (;;)
        {
          k += 1;
          break;
          if ((paramArrayOfInt2[(k + m)] >= 130) && (paramArrayOfInt2[(k + m)] < 200))
          {
            paramArrayOfInt3[(k + m)] = (1.0F - (1.8F - 0.01F * paramArrayOfInt2[(k + m)]) * this.jdField_a_of_type_Float * paramArrayOfInt2[(k + m)] / f1);
            if (paramArrayOfInt3[(k + m)] > 1.0F) {
              paramArrayOfInt3[(k + m)] = 1.0F;
            }
          }
          else
          {
            paramArrayOfInt3[(k + m)] = 1.0F;
          }
        }
      }
      j += 1;
    }
    long l = SystemClock.elapsedRealtimeNanos();
    paramArrayOfInt1 = this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecComputeShaderGPUGuideFilterComputeFilter.a(paramArrayOfInt3, paramArrayOfFloat, paramInt1, paramInt2, paramInt3, 0.001F);
    SLog.b("QQImgHazeRmoveFilter", " glDisPatchGuideFilterComputerCompute=" + (SystemClock.elapsedRealtimeNanos() - l) / 1000000L);
    l = SystemClock.elapsedRealtimeNanos();
    paramArrayOfInt1 = this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecComputeShaderGPUGuideFilterRecoverFilter.a(paramArrayOfFloat, paramArrayOfInt1, paramInt1, paramInt2, paramInt3);
    SLog.a("QQImgHazeRmoveFilter", " glDisPatchGuideFilterRecoverFilterCompute=" + (SystemClock.elapsedRealtimeNanos() - l) / 1000000L);
    return paramArrayOfInt1;
  }
  
  private int b(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.b();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererTextureRender.a(3553, paramInt, null, null);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.c();
    return this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.a();
  }
  
  private int c(int paramInt)
  {
    this.jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.b();
    this.jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecRendererTextureRender.a(3553, paramInt, null, null);
    this.jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.c();
    return this.jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.a();
  }
  
  private int d(int paramInt)
  {
    this.jdField_d_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.b();
    this.jdField_d_of_type_ComTencentMobileqqRichmediaMediacodecRendererTextureRender.a(3553, paramInt, null, null);
    this.jdField_d_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.c();
    return this.jdField_d_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.a();
  }
  
  private int e(int paramInt)
  {
    this.jdField_c_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.b();
    this.jdField_c_of_type_ComTencentMobileqqRichmediaMediacodecRendererTextureRender.a(3553, paramInt, null, null);
    this.jdField_c_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.c();
    return this.jdField_c_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.a();
  }
  
  public int a(int paramInt)
  {
    int j = paramInt % 16;
    if (j == 0) {
      return paramInt;
    }
    return paramInt + 16 - j;
  }
  
  int[] a(byte[] paramArrayOfByte, int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt3 = (paramInt3 - 1) / 2;
    paramInt2 = paramInt1 * paramInt2 / 1000;
    paramInt1 = paramInt2;
    if (paramInt2 <= 0) {
      paramInt1 = paramArrayOfByte.length;
    }
    paramInt3 = 12;
    int j = 0;
    paramInt2 = 0;
    if ((paramInt3 < 0) || (paramInt2 > paramInt1)) {
      return new int[] { j, j, j };
    }
    if (paramInt1 - paramInt2 < paramArrayOfInt[paramInt3]) {}
    for (int k = paramInt1 - paramInt2;; k = paramArrayOfInt[paramInt3])
    {
      float f2 = k * 1.0F / paramInt1;
      float f1 = f2;
      if (f2 > 1.0F) {
        f1 = 1.0F;
      }
      j += (int)(f1 * (paramInt3 * 20 + 10));
      paramInt2 += paramArrayOfInt[paramInt3];
      paramInt3 -= 1;
      break;
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    super.b(paramInt1, paramInt2);
  }
  
  public void d()
  {
    super.d();
  }
  
  public void e()
  {
    super.e();
  }
  
  public boolean f_()
  {
    return super.f_();
  }
  
  @SuppressLint({"NewApi"})
  public void h()
  {
    int j = 0;
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer == null) || (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererTextureRender == null))
    {
      a();
      this.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
      return;
    }
    int k = b(this.jdField_a_of_type_Int);
    Object localObject1 = GlUtil.a(k, this.h, this.g);
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecComputeShaderGPUImgFilterPixelsFilter.a(k, this.h, this.g, this.i);
    int[] arrayOfInt1 = localObject2[0];
    int[] arrayOfInt2 = localObject2[1];
    Object localObject3 = localObject2[2];
    localObject2 = new float[this.g * this.h];
    int[] arrayOfInt3 = new int[13];
    while (j < localObject3.length)
    {
      k = localObject3[j];
      m = k / 20;
      arrayOfInt3[m] += 1;
      localObject2[j] = (k / 255.0F);
      j += 1;
    }
    localObject1 = a((byte[])localObject1, arrayOfInt3, this.h, this.g, this.i);
    j = c(a(a(this.h, this.g, arrayOfInt1, arrayOfInt2, (float[])localObject2, (int[])localObject1, this.i)));
    k = d(this.jdField_a_of_type_Int);
    int m = e(this.jdField_a_of_type_Int);
    this.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecComputeShaderGPUImgFilterRecoverFilter.a(k, m, j, (int[])localObject1, this.f, this.e, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.filter.QQImgHazeRmoveFilter
 * JD-Core Version:    0.7.0.1
 */