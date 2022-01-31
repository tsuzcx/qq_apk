package com.tencent.mobileqq.identification;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.media.MediaFormat;
import android.opengl.EGL14;
import android.support.annotation.RequiresApi;
import apdh;
import aqic;
import auuf;
import auzf;
import auzr;
import auzt;
import awih;
import azzz;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.lang.ref.WeakReference;
import vgv;
import vlm;

@RequiresApi(api=18)
public class ConvertRunnable
  implements auzr, Runnable
{
  private static int e = 0;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private auzt jdField_a_of_type_Auzt;
  private QQFilterRenderManager jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<aqic> jdField_a_of_type_JavaLangRefWeakReference;
  private volatile boolean jdField_a_of_type_Boolean;
  private byte[][] jdField_a_of_type_Array2dOfByte;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long;
  private int d;
  
  public ConvertRunnable(byte[][] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, String paramString, aqic paramaqic)
  {
    this.jdField_a_of_type_Array2dOfByte = paramArrayOfByte;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramaqic);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Long = paramLong;
  }
  
  public static int a()
  {
    if (e != 0) {
      return e;
    }
    if (awih.a().a(17)) {
      e = 17;
    }
    for (;;)
    {
      return e;
      if (awih.a().a(842094169)) {
        e = 842094169;
      } else if (awih.a().a(20)) {
        e = 20;
      } else if (awih.a().a(4)) {
        e = 4;
      } else if (awih.a().a(256)) {
        e = 256;
      } else if (awih.a().a(16)) {
        e = 16;
      }
    }
  }
  
  private static Bitmap a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    Object localObject = new YuvImage(paramArrayOfByte, a(), paramInt1, paramInt2, null);
    paramArrayOfByte = new ByteArrayOutputStream();
    ((YuvImage)localObject).compressToJpeg(new Rect(0, 0, paramInt1, paramInt2), 80, paramArrayOfByte);
    localObject = BitmapFactory.decodeByteArray(paramArrayOfByte.toByteArray(), 0, paramArrayOfByte.size());
    azzz.a(paramArrayOfByte);
    return localObject;
  }
  
  private void a(int paramInt, String paramString, MediaFormat paramMediaFormat)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      aqic localaqic = (aqic)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localaqic != null)
      {
        vgv localvgv = new vgv();
        localvgv.jdField_a_of_type_Long = this.jdField_b_of_type_Long;
        localvgv.jdField_a_of_type_Int = paramInt;
        localvgv.b = paramString;
        localvgv.jdField_a_of_type_AndroidMediaMediaFormat = paramMediaFormat;
        localaqic.a(localvgv);
      }
    }
  }
  
  private boolean a()
  {
    if ((!this.jdField_a_of_type_Boolean) && (QLog.isColorLevel())) {
      QLog.d("identification_convert", 2, "run exit:" + this.jdField_b_of_type_Long + " run:" + this.jdField_a_of_type_Boolean);
    }
    return !this.jdField_a_of_type_Boolean;
  }
  
  private boolean b()
  {
    if ((this.jdField_a_of_type_Auzt == null) || (this.d >= this.jdField_a_of_type_Array2dOfByte.length)) {}
    int i;
    do
    {
      return false;
      byte[][] arrayOfByte = this.jdField_a_of_type_Array2dOfByte;
      i = this.d;
      this.d = (i + 1);
      this.jdField_a_of_type_AndroidGraphicsBitmap = a(arrayOfByte[i], this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      i = GlUtil.createTexture(3553, this.jdField_a_of_type_AndroidGraphicsBitmap);
      if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
      {
        this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
        this.jdField_a_of_type_AndroidGraphicsBitmap = null;
      }
    } while (i <= 0);
    this.jdField_a_of_type_Auzt.a(3553, i, null, null, this.jdField_a_of_type_Long);
    this.jdField_a_of_type_Long += 50000000L;
    return true;
  }
  
  private void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("identification_convert", 2, "run begin, taskid:" + this.jdField_b_of_type_Long + " run:" + this.jdField_a_of_type_Boolean);
    }
    if (a()) {
      a(9, null, null);
    }
    do
    {
      return;
      long l1 = System.currentTimeMillis();
      this.jdField_a_of_type_Long = 0L;
      if (a())
      {
        a(9, null, null);
        return;
      }
      long l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("identification_convert", 2, "run, start convert, taskid:" + this.jdField_b_of_type_Long + " create bitmap cost: " + (l2 - l1) + " ms");
      }
      l1 = System.currentTimeMillis();
      this.jdField_a_of_type_Auzt = new auzt();
      auzf localauzf = new auzf(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, auuf.a().a(1) * 1000, 1, false, 270);
      localauzf.a(EGL14.eglGetCurrentContext());
      this.jdField_a_of_type_Auzt.a(localauzf, this);
      l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("identification_convert", 2, "run, init encoder, taskid:" + this.jdField_b_of_type_Long + "  encoder init cost: " + (l2 - l1) + " ms");
      }
    } while (!QLog.isColorLevel());
    QLog.d("identification_convert", 2, "run end, taskid:" + this.jdField_b_of_type_Long);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("identification_convert", 2, "onEncodeStart, taskid:" + this.jdField_b_of_type_Long);
      }
      this.jdField_c_of_type_Long = System.currentTimeMillis();
      b();
    }
    do
    {
      return;
      if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
      {
        this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
        this.jdField_a_of_type_AndroidGraphicsBitmap = null;
      }
    } while (this.jdField_a_of_type_Auzt == null);
    this.jdField_a_of_type_Auzt.b();
  }
  
  public void a(String paramString)
  {
    long l = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("identification_convert", 2, "onEncodeFinish, taskid:" + this.jdField_b_of_type_Long + " run:" + this.jdField_a_of_type_Boolean + " finish cost: " + (l - this.jdField_c_of_type_Long) + " ms");
    }
    if (this.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("identification_convert", 2, "onEncodeFinish:" + this.jdField_b_of_type_Long + " file:" + this.jdField_a_of_type_JavaLangString);
      }
      this.jdField_c_of_type_Int = 0;
      if (apdh.a(this.jdField_a_of_type_JavaLangString))
      {
        l = apdh.a(this.jdField_a_of_type_JavaLangString);
        if (QLog.isColorLevel()) {
          QLog.d("identification_convert", 2, "onEncodeFinish, file exist, size:" + l + " file:" + this.jdField_a_of_type_JavaLangString);
        }
        paramString = this.jdField_a_of_type_Auzt.a();
        a(this.jdField_c_of_type_Int, this.jdField_a_of_type_JavaLangString, paramString);
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.surfaceDestroyed();
        this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager = null;
      }
      if (this.jdField_a_of_type_Auzt != null)
      {
        this.jdField_a_of_type_Auzt.c();
        this.jdField_a_of_type_Auzt = null;
      }
      return;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("identification_convert", 2, "onEncodeFinish, file not exist:" + this.jdField_b_of_type_Long + " file:" + this.jdField_a_of_type_JavaLangString);
      break;
      vlm.g(paramString);
    }
  }
  
  public void a_(int paramInt, Throwable paramThrowable)
  {
    if (QLog.isColorLevel()) {
      QLog.e("identification_convert", 2, "onEncodeError, code:" + paramInt + " taskID:" + this.jdField_b_of_type_Long + " run:" + this.jdField_a_of_type_Boolean);
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_c_of_type_Int = 7;
      a(this.jdField_c_of_type_Int, this.jdField_a_of_type_JavaLangString, null);
    }
  }
  
  public void b()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("identification_convert", 2, "onEncodeFrame, mRun is false, tasid." + this.jdField_b_of_type_Long);
      }
      if (this.jdField_a_of_type_Auzt != null) {
        this.jdField_a_of_type_Auzt.b();
      }
    }
    do
    {
      do
      {
        return;
      } while (b());
      if (QLog.isColorLevel()) {
        QLog.d("identification_convert", 2, "onEncodeFrame, stop recoder");
      }
      if (this.jdField_a_of_type_Auzt != null) {
        this.jdField_a_of_type_Auzt.b();
      }
    } while (!QLog.isColorLevel());
    QLog.d("identification_convert", 2, "onEncodeFrame, stop recoder, taskid:" + this.jdField_b_of_type_Long);
  }
  
  public void run()
  {
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.identification.ConvertRunnable
 * JD-Core Version:    0.7.0.1
 */