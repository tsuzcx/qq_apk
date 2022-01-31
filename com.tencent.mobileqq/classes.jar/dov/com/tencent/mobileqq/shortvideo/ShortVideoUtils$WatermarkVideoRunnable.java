package dov.com.tencent.mobileqq.shortvideo;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.media.MediaMetadataRetriever;
import android.os.Message;
import android.text.TextUtils;
import bhtb;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;
import xqw;
import xtc;
import xtk;

public class ShortVideoUtils$WatermarkVideoRunnable
  implements Runnable
{
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private static xtc jdField_a_of_type_Xtc;
  private int jdField_a_of_type_Int;
  String jdField_a_of_type_JavaLangString;
  private WeakReference<Context> jdField_a_of_type_JavaLangRefWeakReference;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private xtk jdField_a_of_type_Xtk;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString;
  
  private void a(int paramInt)
  {
    a(paramInt, 0);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_MqqOsMqqHandler != null))
    {
      Message localMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(paramInt1, this.jdField_a_of_type_Int, paramInt2);
      this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
    }
  }
  
  @TargetApi(10)
  public void run()
  {
    Object localObject1;
    Object localObject3;
    Object localObject5;
    Object localObject6;
    if (bhtb.d())
    {
      localObject1 = new MediaMetadataRetriever();
      ((MediaMetadataRetriever)localObject1).setDataSource(this.jdField_b_of_type_JavaLangString);
      localObject3 = ((MediaMetadataRetriever)localObject1).extractMetadata(18);
      localObject5 = ((MediaMetadataRetriever)localObject1).extractMetadata(19);
      localObject6 = ((MediaMetadataRetriever)localObject1).extractMetadata(24);
      ((MediaMetadataRetriever)localObject1).release();
      if ((TextUtils.isEmpty((CharSequence)localObject3)) || (TextUtils.isEmpty((CharSequence)localObject5)) || (TextUtils.isEmpty((CharSequence)localObject6))) {
        break label808;
      }
      this.jdField_b_of_type_Int = Integer.valueOf((String)localObject3).intValue();
      this.jdField_c_of_type_Int = Integer.valueOf((String)localObject5).intValue();
    }
    label808:
    for (int i = Integer.valueOf((String)localObject6).intValue();; i = 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoUtils", 2, "watermark task measure, w=" + this.jdField_b_of_type_Int + ", h=" + this.jdField_c_of_type_Int + ",r=" + i);
      }
      if (jdField_a_of_type_Xtc == null) {
        jdField_a_of_type_Xtc = xtc.a(BaseApplicationImpl.getContext());
      }
      this.jdField_a_of_type_JavaLangString = ShortVideoUtils.b();
      localObject5 = new File(this.jdField_a_of_type_JavaLangString);
      if ((!((File)localObject5).getParentFile().exists()) && (!((File)localObject5).getParentFile().mkdirs()))
      {
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
        if (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ShortVideoUtils", 2, "context is null");
          }
          a(10001);
          return;
        }
        for (;;)
        {
          try
          {
            localObject1 = BitmapFactory.decodeResource(((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources(), 2130845598);
            if (this.jdField_b_of_type_Int != 576)
            {
              float f = this.jdField_b_of_type_Int / 576.0F;
              localObject3 = Bitmap.createScaledBitmap((Bitmap)localObject1, (int)(((Bitmap)localObject1).getWidth() * f), (int)(f * ((Bitmap)localObject1).getHeight()), true);
              ((Bitmap)localObject1).recycle();
              localObject1 = localObject3;
              localObject3 = Bitmap.createBitmap(this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, Bitmap.Config.ARGB_8888);
              localObject6 = new Canvas((Bitmap)localObject3);
              if ((i / 90 + 1) % 2 == 0)
              {
                j = 1;
                if (j == 0) {
                  break label631;
                }
                k = this.jdField_b_of_type_Int - 20 - ((Bitmap)localObject1).getHeight();
                if (j != 0)
                {
                  ((Canvas)localObject6).save();
                  int m = this.jdField_b_of_type_Int / 2;
                  int n = this.jdField_c_of_type_Int / 2;
                  ((Canvas)localObject6).rotate(360 - i, m, n);
                  ((Canvas)localObject6).translate(m - n, n - m);
                }
                ((Canvas)localObject6).drawBitmap((Bitmap)localObject1, 20.0F, k, null);
                if (j != 0) {
                  ((Canvas)localObject6).restore();
                }
                if (xqw.a((Bitmap)localObject3, Bitmap.CompressFormat.PNG, 100, ((File)localObject5).getAbsolutePath())) {
                  break;
                }
                if (QLog.isColorLevel()) {
                  QLog.d("ShortVideoUtils", 2, "compress watermark to file failed");
                }
                xqw.a((Bitmap)localObject3);
                xqw.a((Bitmap)localObject1);
                a(10001);
              }
            }
            else
            {
              continue;
            }
            int j = 0;
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
          continue;
          label631:
          int k = this.jdField_c_of_type_Int - 20 - localException1.getHeight();
        }
        xqw.a((Bitmap)localObject3);
        xqw.a(localException1);
        if (jdField_a_of_type_Xtc.a()) {
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
              jdField_a_of_type_Xtc.a(this.jdField_c_of_type_JavaLangString);
              jdField_a_of_type_Xtc.a(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, this.jdField_a_of_type_Xtk);
              return;
            }
            catch (Exception localException2) {}
            if (QLog.isColorLevel())
            {
              QLog.d("ShortVideoUtils", 2, "generate files save alum:" + localException2);
              return;
            }
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.ShortVideoUtils.WatermarkVideoRunnable
 * JD-Core Version:    0.7.0.1
 */