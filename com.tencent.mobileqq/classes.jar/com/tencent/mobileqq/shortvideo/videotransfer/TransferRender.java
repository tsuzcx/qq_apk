package com.tencent.mobileqq.shortvideo.videotransfer;

import android.text.TextUtils;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.GPUBaseFilter;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.RenderBuffer;
import java.util.ArrayList;
import java.util.Iterator;

public class TransferRender
{
  private static int jdField_a_of_type_Int = 300;
  private float jdField_a_of_type_Float = 1.0F;
  private long jdField_a_of_type_Long = -1L;
  private GPUBaseFilter jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter;
  private RenderBuffer jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer;
  private TransferData jdField_a_of_type_ComTencentMobileqqShortvideoVideotransferTransferData;
  private TransferInstFilter jdField_a_of_type_ComTencentMobileqqShortvideoVideotransferTransferInstFilter;
  private int jdField_b_of_type_Int = 0;
  private long jdField_b_of_type_Long = -1L;
  private RenderBuffer jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer;
  private int c = 0;
  private int d = 0;
  
  private long a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoVideotransferTransferData != null)
    {
      if (this.jdField_a_of_type_Float != -1.0F) {
        this.jdField_a_of_type_Float = 1.0F;
      }
      return ((float)this.jdField_a_of_type_ComTencentMobileqqShortvideoVideotransferTransferData.a.jdField_a_of_type_Long * this.jdField_a_of_type_Float);
    }
    return 0L;
  }
  
  private void a(long paramLong)
  {
    if ((paramLong < 0L) || (this.jdField_a_of_type_ComTencentMobileqqShortvideoVideotransferTransferData == null) || (this.jdField_a_of_type_ComTencentMobileqqShortvideoVideotransferTransferInstFilter == null))
    {
      this.d = 0;
      this.jdField_a_of_type_Long = -1L;
      this.jdField_b_of_type_Long = -1L;
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqShortvideoVideotransferTransferData.a();
    if ((localObject == null) || (((ArrayList)localObject).size() == 0))
    {
      this.d = 0;
      this.jdField_a_of_type_Long = -1L;
      this.jdField_b_of_type_Long = -1L;
      return;
    }
    Long localLong;
    long l2;
    if (this.jdField_a_of_type_Float > 0.0F)
    {
      l1 = a();
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        localLong = (Long)((Iterator)localObject).next();
        l2 = localLong.longValue() + l1;
        if (jdField_a_of_type_Int + paramLong < localLong.longValue())
        {
          this.d = 0;
          this.jdField_a_of_type_Long = -1L;
          this.jdField_b_of_type_Long = -1L;
          return;
        }
        if (jdField_a_of_type_Int + paramLong >= localLong.longValue())
        {
          if (paramLong < localLong.longValue())
          {
            this.d = 1;
            this.jdField_a_of_type_Long = localLong.longValue();
            this.jdField_b_of_type_Long = l2;
            return;
          }
          if (paramLong <= l2)
          {
            if (this.d == 0)
            {
              this.d = 1;
              this.jdField_a_of_type_Long = localLong.longValue();
              this.jdField_b_of_type_Long = l2;
              return;
            }
            if (this.d == 1)
            {
              this.d = 2;
              this.jdField_a_of_type_Long = localLong.longValue();
              this.jdField_b_of_type_Long = l2;
              return;
            }
            this.jdField_a_of_type_Long = localLong.longValue();
            this.jdField_b_of_type_Long = l2;
            return;
          }
        }
      }
      this.d = 0;
      this.jdField_a_of_type_Long = -1L;
      this.jdField_b_of_type_Long = -1L;
      return;
    }
    long l1 = a();
    int i = ((ArrayList)localObject).size() - 1;
    while (i >= 0)
    {
      localLong = Long.valueOf(((Long)((ArrayList)localObject).get(i)).longValue() - this.jdField_a_of_type_ComTencentMobileqqShortvideoVideotransferTransferData.a());
      l2 = localLong.longValue() + l1;
      if (paramLong - jdField_a_of_type_Int > localLong.longValue())
      {
        this.d = 0;
        this.jdField_a_of_type_Long = -1L;
        this.jdField_b_of_type_Long = -1L;
        return;
      }
      if (paramLong - jdField_a_of_type_Int <= localLong.longValue())
      {
        if (paramLong > localLong.longValue())
        {
          this.d = 1;
          this.jdField_a_of_type_Long = localLong.longValue();
          this.jdField_b_of_type_Long = l2;
          return;
        }
        if (paramLong >= l2) {}
      }
      else
      {
        i -= 1;
        continue;
      }
      if (this.d == 0)
      {
        this.d = 1;
        this.jdField_a_of_type_Long = localLong.longValue();
        this.jdField_b_of_type_Long = l2;
        return;
      }
      if (this.d == 1)
      {
        this.d = 2;
        this.jdField_a_of_type_Long = localLong.longValue();
        this.jdField_b_of_type_Long = l2;
        return;
      }
      this.jdField_a_of_type_Long = localLong.longValue();
      this.jdField_b_of_type_Long = l2;
      return;
    }
    this.d = 0;
    this.jdField_a_of_type_Long = -1L;
    this.jdField_b_of_type_Long = -1L;
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoVideotransferTransferInstFilter != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoVideotransferTransferInstFilter.d();
      this.jdField_a_of_type_ComTencentMobileqqShortvideoVideotransferTransferInstFilter = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoVideotransferTransferData != null)
    {
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqShortvideoVideotransferTransferData.a.jdField_a_of_type_JavaLangString)) {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoVideotransferTransferData.a.jdField_a_of_type_JavaLangString = "uniform mat4 uMVPMatrix;\nuniform mat4 uTextureMatrix;\nattribute vec4 position;\nattribute vec4 inputTextureCoordinate;\nvarying highp vec2 textureCoordinate;\nvoid main()\n{\ngl_Position = uMVPMatrix * position;\ntextureCoordinate = (uTextureMatrix * inputTextureCoordinate).xy;\n}";
      }
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqShortvideoVideotransferTransferData.a.b)) {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoVideotransferTransferData.a.b = "precision highp float;\n\nvarying highp vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTexture2;\nuniform vec2 inputImageTextureSize;\nuniform vec2 inputImageTexture2Size;\nuniform vec2 timeRange; //start, duration\nuniform float time;\n\nvoid main() {\n    gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}\n";
      }
      this.jdField_a_of_type_ComTencentMobileqqShortvideoVideotransferTransferInstFilter = new TransferInstFilter(this.jdField_a_of_type_ComTencentMobileqqShortvideoVideotransferTransferData.a.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqShortvideoVideotransferTransferData.a.b);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoVideotransferTransferInstFilter.a();
      this.jdField_a_of_type_ComTencentMobileqqShortvideoVideotransferTransferInstFilter.a(this.jdField_b_of_type_Int, this.c);
    }
  }
  
  public int a(int paramInt, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, long paramLong)
  {
    a(paramLong);
    if (this.d == 0) {}
    do
    {
      do
      {
        return -1;
        if (this.d != 1) {
          break;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter == null)
        {
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter = new GPUBaseFilter("uniform mat4 uMVPMatrix;\nuniform mat4 uTextureMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTextureMatrix * aTextureCoord).xy;\n}\n", "precision mediump float;\n\nvarying vec2 vTextureCoord;\nuniform sampler2D uTexture;\n\nvoid main() {\n    gl_FragColor = texture2D(uTexture, vTextureCoord);\n}\n");
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter.a();
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter.a(this.jdField_b_of_type_Int, this.c);
        }
      } while ((this.jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer == null) || (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter == null));
      this.jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.b();
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter.a(paramInt, paramArrayOfFloat1, paramArrayOfFloat2);
      this.jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.c();
      return -1;
    } while ((this.jdField_a_of_type_ComTencentMobileqqShortvideoVideotransferTransferInstFilter == null) || (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer == null) || (this.jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer == null));
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.b();
    if (this.jdField_a_of_type_Float > 0.0F) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoVideotransferTransferInstFilter.a((int)this.jdField_a_of_type_Long, (int)this.jdField_b_of_type_Long, (int)paramLong);
    }
    for (;;)
    {
      boolean bool = this.jdField_a_of_type_ComTencentMobileqqShortvideoVideotransferTransferInstFilter.a(paramInt, this.jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.a(), paramArrayOfFloat1, paramArrayOfFloat2);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.c();
      if (!bool) {
        break;
      }
      return this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.a();
      this.jdField_a_of_type_ComTencentMobileqqShortvideoVideotransferTransferInstFilter.a((int)this.jdField_b_of_type_Long, (int)this.jdField_a_of_type_Long, (int)(this.jdField_a_of_type_Long + this.jdField_b_of_type_Long - paramLong));
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoVideotransferTransferInstFilter != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoVideotransferTransferInstFilter.d();
      this.jdField_a_of_type_ComTencentMobileqqShortvideoVideotransferTransferInstFilter = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter.d();
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.d();
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer = null;
    }
    if (this.jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer != null)
    {
      this.jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.d();
      this.jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer = null;
    }
    this.jdField_b_of_type_Int = 0;
    this.c = 0;
  }
  
  public void a(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.c = paramInt2;
    this.jdField_b_of_type_Int = paramInt1;
    if ((this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer == null) || (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.b() != paramInt1) || (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.c() != paramInt2)) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer = new RenderBuffer(paramInt1, paramInt2, 33984);
    }
    if ((this.jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer == null) || (this.jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.b() != paramInt1) || (this.jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.c() != paramInt2)) {
      this.jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer = new RenderBuffer(paramInt1, paramInt2, 33984);
    }
    b();
  }
  
  public void a(TransferData paramTransferData)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoVideotransferTransferData = paramTransferData;
    b();
  }
  
  public boolean a()
  {
    return this.d != 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.videotransfer.TransferRender
 * JD-Core Version:    0.7.0.1
 */