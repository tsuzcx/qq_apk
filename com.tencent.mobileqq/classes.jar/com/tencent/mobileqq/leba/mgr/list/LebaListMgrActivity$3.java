package com.tencent.mobileqq.leba.mgr.list;

import com.tencent.mobileqq.leba.core.LebaShowListManager;
import com.tencent.mobileqq.leba.observer.LebaSettingObserver;
import com.tencent.qphone.base.util.QLog;

class LebaListMgrActivity$3
  extends LebaSettingObserver
{
  LebaListMgrActivity$3(LebaListMgrActivity paramLebaListMgrActivity) {}
  
  public void a(boolean paramBoolean, Object paramObject)
  {
    QLog.i("IphoneTitleBarActivity", 4, "notifyLebaViewItemsReloaded");
    if ((LebaListMgrActivity.a(this.a) == null) || (!this.a.isResume())) {
      return;
    }
    paramObject = LebaShowListManager.a().a();
    this.a.runOnUiThread(new LebaListMgrActivity.3.1(this, paramObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.mgr.list.LebaListMgrActivity.3
 * JD-Core Version:    0.7.0.1
 */