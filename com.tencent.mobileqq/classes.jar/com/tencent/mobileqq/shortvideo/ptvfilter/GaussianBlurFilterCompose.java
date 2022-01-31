package com.tencent.mobileqq.shortvideo.ptvfilter;

import com.tencent.mobileqq.richmedia.mediacodec.renderer.RenderBuffer;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.TextureRender;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;

public class GaussianBlurFilterCompose
{
  private int jdField_a_of_type_Int;
  private RenderBuffer jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer;
  private TextureRender jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererTextureRender;
  private GaussianBlurFilter jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterGaussianBlurFilter;
  private int b;
  private int c;
  
  private float[] a(float paramFloat)
  {
    int i = 0;
    if (paramFloat >= 1.0F)
    {
      double d = Math.pow(paramFloat, 2.0D);
      i = (int)Math.floor(Math.sqrt(Math.log(0.0039063F * Math.sqrt(6.283185307179586D * Math.pow(paramFloat, 2.0D))) * (-2.0D * d)));
      i += i % 2;
    }
    float[] arrayOfFloat1 = new float[i + 1];
    float f = 0.0F;
    int j = 0;
    if (j < i + 1)
    {
      arrayOfFloat1[j] = ((float)(1.0D / Math.sqrt(6.283185307179586D * Math.pow(paramFloat, 2.0D)) * Math.exp(-Math.pow(j, 2.0D) / (2.0D * Math.pow(paramFloat, 2.0D)))));
      if (j == 0) {}
      for (f = arrayOfFloat1[j] + f;; f = (float)(f + 2.0D * arrayOfFloat1[j]))
      {
        j += 1;
        break;
      }
    }
    j = 0;
    while (j < i + 1)
    {
      arrayOfFloat1[j] /= f;
      j += 1;
    }
    int k = Math.min(i / 2 + i % 2, 7);
    float[] arrayOfFloat2 = new float[k];
    j = 0;
    while (j < k)
    {
      paramFloat = arrayOfFloat1[(j * 2 + 1)];
      f = arrayOfFloat1[(j * 2 + 2)];
      arrayOfFloat2[j] = ((paramFloat * (j * 2 + 1) + f * (j * 2 + 2)) / (paramFloat + f));
      j += 1;
    }
    j = i / 2 + i % 2;
    arrayOfFloat2 = new float[11];
    i = 0;
    while (i < 11)
    {
      arrayOfFloat2[i] = 0.0F;
      i += 1;
    }
    i = 0;
    while (i < k)
    {
      arrayOfFloat2[i] = (arrayOfFloat1[(i * 2 + 1)] + arrayOfFloat1[(i * 2 + 2)]);
      i += 1;
    }
    if (j > k)
    {
      i = k;
      while (i < j)
      {
        arrayOfFloat2[i] = (arrayOfFloat1[(i * 2 + 1)] + arrayOfFloat1[(i * 2 + 2)]);
        i += 1;
      }
    }
    paramFloat = -arrayOfFloat2[0];
    i = 0;
    while (i < arrayOfFloat2.length)
    {
      paramFloat += arrayOfFloat2[i] * 2.0F;
      i += 1;
    }
    i = 0;
    while (i < arrayOfFloat2.length)
    {
      arrayOfFloat2[i] /= paramFloat;
      i += 1;
    }
    return arrayOfFloat2;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.a();
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterGaussianBlurFilter == null) {}
    while (!this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterGaussianBlurFilter.a()) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.b();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererTextureRender.a(3553, paramInt, null, null);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.c();
    paramInt = this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.a();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.a(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.b();
    this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterGaussianBlurFilter.a(null, 1.0F, 0.0F);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterGaussianBlurFilter.a(paramInt);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.c();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.a(paramInt);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.b();
    this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterGaussianBlurFilter.a(null, 0.0F, 1.0F);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterGaussianBlurFilter.a(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.c();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.c = ((int)(paramInt1 * 0.25F));
    this.b = ((int)(0.25F * paramInt2));
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer = new RenderBuffer(this.c, this.b, 33986);
    this.jdField_a_of_type_Int = GlUtil.a(this.c, this.b, false);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererTextureRender = new TextureRender();
    this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterGaussianBlurFilter = new GaussianBlurFilter();
    this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterGaussianBlurFilter.a(this.c, this.b);
    float[] arrayOfFloat = a(9.8F);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterGaussianBlurFilter.a(arrayOfFloat, 0.0F, 0.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ptvfilter.GaussianBlurFilterCompose
 * JD-Core Version:    0.7.0.1
 */