package com.tencent.mobileqq.emoticonview.ipc.proxy;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vas.updatesystem.callback.CallBacker;
import com.tencent.qphone.base.util.QLog;

public class VasQuickUpdateManagerProxy
  extends AbsManagerProxy<VasQuickUpdateManager>
{
  private static final String TAG = "VasQuickUpdateManagerProxy";
  
  public VasQuickUpdateManagerProxy(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface, QQManagerFactory.VAS_QUICKUPDATE_MANAGER);
  }
  
  public void removeCallBacker(CallBacker paramCallBacker)
  {
    if (this.manager != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VasQuickUpdateManagerProxy", 4, "do removeCallBacker.");
      }
      ((VasQuickUpdateManager)this.manager).removeCallBacker(paramCallBacker);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.ipc.proxy.VasQuickUpdateManagerProxy
 * JD-Core Version:    0.7.0.1
 */