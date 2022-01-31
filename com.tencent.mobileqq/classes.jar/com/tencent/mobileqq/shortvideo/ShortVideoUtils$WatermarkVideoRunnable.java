package com.tencent.mobileqq.shortvideo;

import aiad;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.media.MediaMetadataRetriever;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.biz.qqstory.utils.BitmapUtils;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpeg;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpegExecuteResponseCallback;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import java.io.File;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

public class ShortVideoUtils$WatermarkVideoRunnable
  implements Runnable
{
  private static FFmpeg jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpeg;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private int jdField_a_of_type_Int;
  public long a;
  private FFmpegExecuteResponseCallback jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpegExecuteResponseCallback;
  public String a;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString;
  
  public ShortVideoUtils$WatermarkVideoRunnable(Context paramContext, int paramInt, String paramString1, String paramString2, MqqHandler paramMqqHandler)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.jdField_c_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_MqqOsMqqHandler = paramMqqHandler;
    this.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpegExecuteResponseCallback = new aiad(this, paramString2);
    this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
  }
  
  private void a(int paramInt)
  {
    a(paramInt, 0);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      Message localMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(paramInt1, this.jdField_a_of_type_Int, paramInt2);
      this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  @TargetApi(10)
  public void run()
  {
    Object localObject1;
    Object localObject3;
    Object localObject5;
    if (VersionUtils.d())
    {
      localObject1 = new MediaMetadataRetriever();
      ((MediaMetadataRetriever)localObject1).setDataSource(this.jdField_b_of_type_JavaLangString);
      localObject3 = ((MediaMetadataRetriever)localObject1).extractMetadata(18);
      localObject5 = ((MediaMetadataRetriever)localObject1).extractMetadata(19);
      if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (!TextUtils.isEmpty((CharSequence)localObject5)))
      {
        this.jdField_b_of_type_Int = Integer.valueOf((String)localObject3).intValue();
        this.jdField_c_of_type_Int = Integer.valueOf((String)localObject5).intValue();
      }
      ((MediaMetadataRetriever)localObject1).release();
      if (jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpeg == null) {
        jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpeg = FFmpeg.a(BaseApplicationImpl.getContext());
      }
      this.jdField_a_of_type_JavaLangString = ShortVideoUtils.d();
      localObject5 = new File(this.jdField_a_of_type_JavaLangString);
      if ((((File)localObject5).getParentFile().exists()) || (((File)localObject5).getParentFile().mkdirs())) {
        break label180;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoUtils", 2, new Object[] { "create watermark dir failed: ", this.jdField_a_of_type_JavaLangString });
      }
      a(10001);
    }
    for (;;)
    {
      return;
      a(10001);
      return;
      label180:
      if (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoUtils", 2, "context is null");
        }
        a(10001);
        return;
      }
      try
      {
        localObject1 = BitmapFactory.decodeResource(((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources(), 2130843253);
        if (this.jdField_b_of_type_Int != 576)
        {
          float f = this.jdField_b_of_type_Int / 576.0F;
          localObject3 = Bitmap.createScaledBitmap((Bitmap)localObject1, (int)(((Bitmap)localObject1).getWidth() * f), (int)(f * ((Bitmap)localObject1).getHeight()), true);
          ((Bitmap)localObject1).recycle();
          localObject1 = localObject3;
        }
        for (;;)
        {
          localObject3 = Bitmap.createBitmap(this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, Bitmap.Config.ARGB_8888);
          new Canvas((Bitmap)localObject3).drawBitmap((Bitmap)localObject1, 20.0F, this.jdField_c_of_type_Int - 20 - ((Bitmap)localObject1).getHeight(), null);
          if (BitmapUtils.a((Bitmap)localObject3, Bitmap.CompressFormat.PNG, 100, ((File)localObject5).getAbsolutePath())) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ShortVideoUtils", 2, "compress watermark to file failed");
          }
          BitmapUtils.a((Bitmap)localObject3);
          BitmapUtils.a((Bitmap)localObject1);
          a(10001);
          return;
        }
        BitmapUtils.a((Bitmap)localObject3);
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ShortVideoUtils", 2, localOutOfMemoryError, new Object[0]);
        }
        a(10001);
        return;
      }
      catch (Exception localException1)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ShortVideoUtils", 2, localException1, new Object[0]);
        }
        a(10001);
        return;
      }
      BitmapUtils.a(localException1);
      if (jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpeg.a()) {
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoUtils", 2, "generate files mFFmpeg is running!");
        }
      }
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        try
        {
          jdField_a_of_type_JavaLangObject.wait();
          try
          {
            jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpeg.a(this.jdField_c_of_type_JavaLangString);
            jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpeg.a(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, this.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpegExecuteResponseCallback);
            return;
          }
          catch (Exception localException2) {}
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("ShortVideoUtils", 2, "generate files save alum:" + localException2);
          return;
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.e("ShortVideoUtils", 2, localInterruptedException, new Object[0]);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ShortVideoUtils.WatermarkVideoRunnable
 * JD-Core Version:    0.7.0.1
 */