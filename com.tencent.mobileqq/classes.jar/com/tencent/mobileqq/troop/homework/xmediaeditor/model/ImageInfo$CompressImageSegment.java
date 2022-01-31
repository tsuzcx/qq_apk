package com.tencent.mobileqq.troop.homework.xmediaeditor.model;

import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import cooperation.troop_homework.jsp.TroopHWJsPlugin;

public class ImageInfo$CompressImageSegment
  extends JobSegment
{
  private int jdField_a_of_type_Int;
  private boolean jdField_a_of_type_Boolean;
  
  public ImageInfo$CompressImageSegment(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  protected void a(JobContext paramJobContext, ImageInfo paramImageInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CompressImageSegment", 2, new Object[] { "CompressImageSegment start. info status=", Integer.valueOf(paramImageInfo.g) });
    }
    ImageInfo.b();
    try
    {
      String str = TroopHWJsPlugin.a(-1, paramImageInfo.a, this.jdField_a_of_type_Int, null);
      if (FileUtil.b(str)) {}
      for (paramImageInfo.c = str;; paramImageInfo.c = paramImageInfo.a)
      {
        QLog.d("CompressImageSegment", 2, new Object[] { "CompressImageSegment. in path=", paramImageInfo.a, ", out path=", paramImageInfo.c });
        if (isCanceled()) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("CompressImageSegment", 2, new Object[] { "CompressImageSegment notifyResult. info status=", Integer.valueOf(paramImageInfo.g) });
        }
        notifyResult(paramImageInfo);
        return;
        if (QLog.isColorLevel()) {
          QLog.e("CompressImageSegment", 2, "CompressImageSegment failed.");
        }
      }
      return;
    }
    catch (Exception paramJobContext)
    {
      QLog.e("CompressImageSegment", 1, "CompressImageSegment Exception: ", paramJobContext);
      notifyError(new Error("101"));
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      QLog.e("CompressImageSegment", 1, "CompressImageSegment error. OutOfMemoryError");
      URLDrawable.clearMemoryCache();
      System.gc();
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = true;
        a(paramJobContext, paramImageInfo);
        return;
      }
      notifyError(new Error("-1"));
    }
  }
  
  protected void onCancel()
  {
    notifyError(new Error("c_1000"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.model.ImageInfo.CompressImageSegment
 * JD-Core Version:    0.7.0.1
 */