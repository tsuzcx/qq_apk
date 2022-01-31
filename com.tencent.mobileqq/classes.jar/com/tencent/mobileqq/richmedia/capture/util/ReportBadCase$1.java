package com.tencent.mobileqq.richmedia.capture.util;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import axpw;
import bdhb;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.dancemachine.BadcaseReportUtils;
import com.tencent.mobileqq.shortvideo.dancemachine.BadcaseReportUtils.BadDataFrame;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class ReportBadCase$1
  implements Runnable
{
  public ReportBadCase$1(axpw paramaxpw, BadcaseReportUtils.BadDataFrame paramBadDataFrame) {}
  
  public void run()
  {
    ??? = Bitmap.createBitmap(this.a.width, this.a.height, Bitmap.Config.ARGB_8888);
    ((Bitmap)???).copyPixelsFromBuffer(this.a.pictureBuffer);
    String str1 = axpw.a();
    boolean bool = axpw.a((Bitmap)???, str1);
    if (QLog.isColorLevel()) {
      QLog.d("BadcaseReportUtils", 2, "BadcaseReportUtils|writeBitmapToFile success=" + bool);
    }
    this.a.pictureBuffer = null;
    if (bool)
    {
      this.a.picturePath = str1;
      this.a.convertedPath = (str1 + "_ct_2");
      BadcaseReportUtils.convertDataFormat(this.a);
      synchronized (axpw.a())
      {
        axpw.a().add(this.a);
      }
    }
    synchronized (axpw.a())
    {
      int i = axpw.a().size();
      if (i == 3) {
        ThreadManager.postDownLoadTask(new ReportBadCase.1.1(this), 5, null, true);
      }
      return;
      str2 = finally;
      throw str2;
      bdhb.d(str2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.util.ReportBadCase.1
 * JD-Core Version:    0.7.0.1
 */