package com.tencent.mobileqq.shortvideo.util;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.text.TextUtils;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.FileUtils;
import com.tencent.mobileqq.richmedia.mediacodec.encoder.EncodeConfig;
import com.tencent.mobileqq.richmedia.mediacodec.encoder.EncodeInputSurface;
import com.tencent.mobileqq.richmedia.mediacodec.encoder.HWVideoEncoder;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.mobileqq.utils.ImageUtil;

public class PicToVideoConverter
{
  private int jdField_a_of_type_Int;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private EncodeInputSurface jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeInputSurface;
  public HWVideoEncoder a;
  private String jdField_a_of_type_JavaLangString;
  private float[] jdField_a_of_type_ArrayOfFloat;
  
  private static long a(int paramInt)
  {
    return paramInt * 1000000000L / 25L;
  }
  
  private Bitmap a(Bitmap paramBitmap)
  {
    Bitmap localBitmap = paramBitmap;
    if (paramBitmap.getWidth() % 2 == 1)
    {
      localBitmap = Bitmap.createBitmap(paramBitmap.getWidth() + 1, paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap);
      localCanvas.drawARGB(0, 0, 0, 0);
      localCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, null);
    }
    return localBitmap;
  }
  
  private void a()
  {
    SLog.b("Q.qqstory.publish.upload.PicToVideoConverter", "preparing.");
    this.jdField_a_of_type_AndroidGraphicsBitmap = a(this.jdField_a_of_type_AndroidGraphicsBitmap);
    SLog.b("Q.qqstory.publish.upload.PicToVideoConverter", "bitmap's width = " + this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() + ", height = " + this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight());
    EncodeConfig localEncodeConfig = new EncodeConfig(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth(), this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight(), 532480, 1, false, 0);
    localEncodeConfig.d = 25;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderHWVideoEncoder = new HWVideoEncoder();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderHWVideoEncoder.a(localEncodeConfig);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeInputSurface = new EncodeInputSurface();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeInputSurface.a(localEncodeConfig, this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderHWVideoEncoder.a());
    this.jdField_a_of_type_Int = GlUtil.a(3553, this.jdField_a_of_type_AndroidGraphicsBitmap);
    this.jdField_a_of_type_ArrayOfFloat = new float[] { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F };
  }
  
  private void b()
  {
    SLog.b("Q.qqstory.publish.upload.PicToVideoConverter", "releasing.");
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeInputSurface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeInputSurface.a();
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeInputSurface = null;
    }
  }
  
  public int a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      throw new IllegalStateException("convert image to video failed. because input path or target path is null!");
    }
    SLog.d("Q.qqstory.publish.upload.PicToVideoConverter", "input file path is %s. output file path is %s.", new Object[] { paramString1, paramString2 });
    if (!FileUtils.c(paramString1))
    {
      SLog.e("Q.qqstory.publish.upload.PicToVideoConverter", "input file does not exists or is empty.");
      return 940007;
    }
    this.jdField_a_of_type_JavaLangString = paramString2;
    try
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeFile(paramString1);
      l = System.currentTimeMillis();
    }
    catch (OutOfMemoryError paramString2)
    {
      try
      {
        for (;;)
        {
          a();
          i = 0;
          for (;;)
          {
            if (i < 75)
            {
              this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderHWVideoEncoder.a();
              this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeInputSurface.a(3553, this.jdField_a_of_type_Int, this.jdField_a_of_type_ArrayOfFloat, null, a(i));
              i += 1;
              continue;
              paramString2 = paramString2;
              System.gc();
              try
              {
                Thread.sleep(1000L);
                this.jdField_a_of_type_AndroidGraphicsBitmap = ImageUtil.a(paramString1, 540, 960);
                if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
                  this.jdField_a_of_type_AndroidGraphicsBitmap = ImageUtil.a(paramString1, 360, 640);
                }
                if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
                  break;
                }
                SLog.e("Q.qqstory.publish.upload.PicToVideoConverter", "decode bitmap <%s> error:%s", new Object[] { paramString1, paramString2 });
                return 942014;
              }
              catch (InterruptedException localInterruptedException)
              {
                for (;;)
                {
                  localInterruptedException.printStackTrace();
                }
              }
            }
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderHWVideoEncoder.b();
        b();
        i = 0;
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          long l;
          SLog.b("Q.qqstory.publish.upload.PicToVideoConverter", "convert picture to video error. %s.", paramString1);
          int i = 942013;
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderHWVideoEncoder.c();
          b();
        }
      }
      finally
      {
        b();
      }
      SLog.d("Q.qqstory.publish.upload.PicToVideoConverter", "convert image to video done. cost time %d. errorCode is %d.", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(i) });
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.util.PicToVideoConverter
 * JD-Core Version:    0.7.0.1
 */