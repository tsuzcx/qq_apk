package com.tencent.mobileqq.richmedia.capture.data;

import avrv;
import axle;
import bbfj;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class CapturePtvTemplateManager$4
  implements Runnable
{
  public CapturePtvTemplateManager$4(avrv paramavrv) {}
  
  public void run()
  {
    int i = 1;
    boolean bool1 = axle.c();
    boolean bool2 = bbfj.d(BaseApplication.getContext());
    if (BaseApplicationImpl.sProcessId == 1) {
      i = 0;
    }
    if (QLog.isColorLevel()) {
      QLog.i("CapturePtvTemplateManager", 2, "dealyPreDownload isSupport: " + bool1 + " isNetWorkSupport: " + bool2);
    }
    if ((bool1) && (bool2) && (i != 0)) {
      this.this$0.a(this.this$0.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.data.CapturePtvTemplateManager.4
 * JD-Core Version:    0.7.0.1
 */