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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("handleErrorReport top activity: ");
    ((StringBuilder)localObject).append(localQBaseActivity);
    QLog.d("DBVerifyFailToastHandler", 1, ((StringBuilder)localObject).toString());
    if (localQBaseActivity != null)
    {
      localObject = BaseApplication.getContext();
      String str = this.a;
      DialogUtil.a(localQBaseActivity, ((BaseApplication)localObject).getString(2131917773, new Object[] { str, str }), 2131889053, 2131888202, new DBTableVerifyFailHandler.1.1(this), new DBTableVerifyFailHandler.1.2(this)).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.bridge.DBTableVerifyFailHandler.1
 * JD-Core Version:    0.7.0.1
 */