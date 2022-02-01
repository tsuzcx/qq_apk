package com.tencent.mobileqq.troop.homework.xmediaeditor.model;

import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import cooperation.troop_homework.jsp.TroopHWJsPlugin;

public class ImageInfo$CompressImageSegment
  extends JobSegment<ImageInfo, ImageInfo>
{
  private int a;
  private boolean b;
  
  public ImageInfo$CompressImageSegment(int paramInt)
  {
    this.a = paramInt;
  }
  
  protected void a(JobContext paramJobContext, ImageInfo paramImageInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CompressImageSegment", 2, new Object[] { "CompressImageSegment start. info status=", Integer.valueOf(paramImageInfo.o) });
    }
    ImageInfo.h();
    try
    {
      String str = TroopHWJsPlugin.a(-1, paramImageInfo.a, this.a, null);
      if (FileUtils.fileExistsAndNotEmpty(str))
      {
        paramImageInfo.c = str;
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.e("CompressImageSegment", 2, "CompressImageSegment failed.");
        }
        paramImageInfo.c = paramImageInfo.a;
      }
      QLog.d("CompressImageSegment", 2, new Object[] { "CompressImageSegment. in path=", paramImageInfo.a, ", out path=", paramImageInfo.c });
      if (isCanceled()) {
        break label234;
      }
      if (QLog.isColorLevel()) {
        QLog.d("CompressImageSegment", 2, new Object[] { "CompressImageSegment notifyResult. info status=", Integer.valueOf(paramImageInfo.o) });
      }
      notifyResult(paramImageInfo);
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
      label164:
      break label164;
    }
    QLog.e("CompressImageSegment", 1, "CompressImageSegment error. OutOfMemoryError");
    URLDrawable.clearMemoryCache();
    System.gc();
    if (!this.b)
    {
      this.b = true;
      a(paramJobContext, paramImageInfo);
      return;
    }
    notifyError(new Error("-1"));
  }
  
  protected void onCancel()
  {
    notifyError(new Error("c_1000"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.model.ImageInfo.CompressImageSegment
 * JD-Core Version:    0.7.0.1
 */