package com.tencent.mobileqq.qwallet.hb.grap.draw.impl;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileOutputStream;
import java.lang.ref.WeakReference;

class LineLayer$SaveTempFileJob
  implements Runnable
{
  private int jdField_a_of_type_Int;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  public final String a;
  private WeakReference<SaveTempFileJobListener> jdField_a_of_type_JavaLangRefWeakReference;
  private int b;
  
  public LineLayer$SaveTempFileJob(LineLayer paramLineLayer, int paramInt1, int paramInt2, Bitmap paramBitmap, SaveTempFileJobListener paramSaveTempFileJobListener)
  {
    paramLineLayer = new StringBuilder();
    paramLineLayer.append(AppConstants.SCRIBBLE_FILE_DIR);
    paramLineLayer.append("temp");
    paramLineLayer.append(File.separator);
    this.jdField_a_of_type_JavaLangString = paramLineLayer.toString();
    this.jdField_a_of_type_Int = -1;
    this.b = -1;
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    QLog.d("SaveTempFileJob", 2, "SaveTempFileJob begin:");
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramSaveTempFileJobListener);
    if (paramBitmap == null) {
      return;
    }
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    try
    {
      if (this.jdField_a_of_type_AndroidGraphicsBitmap == null)
      {
        this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
      }
      else if ((this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() != paramBitmap.getHeight()) || (this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() != paramBitmap.getWidth()))
      {
        this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
        this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
      }
      paramLineLayer = new Paint();
      paramLineLayer.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
      new Canvas(this.jdField_a_of_type_AndroidGraphicsBitmap).drawBitmap(paramBitmap, 0.0F, 0.0F, paramLineLayer);
    }
    catch (OutOfMemoryError paramLineLayer)
    {
      if (QLog.isColorLevel())
      {
        paramBitmap = new StringBuilder();
        paramBitmap.append("SaveTempFileJob OOM:");
        paramBitmap.append(paramLineLayer.toString());
        QLog.d("SaveTempFileJob", 2, paramBitmap.toString());
      }
    }
    catch (Exception paramLineLayer)
    {
      if (QLog.isColorLevel())
      {
        paramBitmap = new StringBuilder();
        paramBitmap.append("SaveTempFileJob exception:");
        paramBitmap.append(paramLineLayer);
        QLog.d("SaveTempFileJob", 2, paramBitmap.toString());
      }
    }
    QLog.d("SaveTempFileJob", 2, "SaveTempFileJob end:");
  }
  
  private String a(int paramInt, Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return null;
    }
    try
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(".tmp");
      localObject = ((StringBuilder)localObject).toString();
      if (FileUtils.fileExists((String)localObject)) {
        FileUtils.deleteFile((String)localObject);
      }
      FileOutputStream localFileOutputStream = new FileOutputStream((String)localObject);
      paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, localFileOutputStream);
      localFileOutputStream.flush();
      localFileOutputStream.close();
      return localObject;
    }
    catch (Exception paramBitmap)
    {
      Object localObject;
      paramBitmap.printStackTrace();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("saveFileCache exception:");
        ((StringBuilder)localObject).append(paramBitmap);
        QLog.e("SaveTempFileJob", 2, ((StringBuilder)localObject).toString());
      }
    }
    return null;
  }
  
  private void a()
  {
    try
    {
      File localFile = new File(this.jdField_a_of_type_JavaLangString);
      if (!localFile.exists())
      {
        localFile.mkdirs();
        return;
      }
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("makedir execption: ");
      localStringBuilder.append(localException);
      QLog.d("SaveTempFileJobdownloading", 2, localStringBuilder.toString());
    }
  }
  
  private void a(String paramString)
  {
    new Handler(Looper.getMainLooper()).post(new LineLayer.SaveTempFileJob.1(this, paramString));
  }
  
  public void run()
  {
    if (LineLayer.a(this.this$0) == null) {
      return;
    }
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null)
    {
      a(null);
      return;
    }
    a();
    a(a(this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidGraphicsBitmap));
    Bitmap localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
    if (localBitmap != null)
    {
      localBitmap.recycle();
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.grap.draw.impl.LineLayer.SaveTempFileJob
 * JD-Core Version:    0.7.0.1
 */