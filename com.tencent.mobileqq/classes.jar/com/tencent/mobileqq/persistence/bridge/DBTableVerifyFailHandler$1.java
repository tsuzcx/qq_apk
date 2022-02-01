package com.tencent.mobileqq.persistence.bridge;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class DBTableVerifyFailHandler$1
  implements Runnable
{
  DBTableVerifyFailHandler$1(DBTableVerifyFailHandler paramDBTableVerifyFailHandler, String paramString) {}
  
  public void run()
  {
    QBaseActivity localQBaseActivity = QBaseActivity.sTopActivity;
    QLog.d("DBVerifyFailToastHandler", 1, "handleErrorReport top activity: " + localQBaseActivity);
    if (localQBaseActivity != null) {
      DialogUtil.a(localQBaseActivity, BaseApplication.getContext().getString(2131720404, new Object[] { this.a, this.a }), 2131692161, 2131691335, new DBTableVerifyFailHandler.1.1(this), new DBTableVerifyFailHandler.1.2(this)).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.bridge.DBTableVerifyFailHandler.1
 * JD-Core Version:    0.7.0.1
 */