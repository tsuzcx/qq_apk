package com.tencent.mobileqq.richmedia.capture.data;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class CapturePtvTemplateManager$4
  implements Runnable
{
  CapturePtvTemplateManager$4(CapturePtvTemplateManager paramCapturePtvTemplateManager) {}
  
  public void run()
  {
    boolean bool1 = PtvFilterSoLoad.a();
    boolean bool2 = NetworkUtil.isNetSupport(BaseApplication.getContext());
    int j = BaseApplicationImpl.sProcessId;
    int i = 1;
    if (j == 1) {
      i = 0;
    }
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("dealyPreDownload isSupport: ");
      ((StringBuilder)localObject).append(bool1);
      ((StringBuilder)localObject).append(" isNetWorkSupport: ");
      ((StringBuilder)localObject).append(bool2);
      QLog.i("CapturePtvTemplateManager", 2, ((StringBuilder)localObject).toString());
    }
    if ((bool1) && (bool2) && (i != 0))
    {
      localObject = this.this$0;
      ((CapturePtvTemplateManager)localObject).a(((CapturePtvTemplateManager)localObject).h);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.data.CapturePtvTemplateManager.4
 * JD-Core Version:    0.7.0.1
 */