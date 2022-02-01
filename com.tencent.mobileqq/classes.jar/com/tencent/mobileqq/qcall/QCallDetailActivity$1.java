package com.tencent.mobileqq.qcall;

import android.text.TextUtils;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

class QCallDetailActivity$1
  extends AvatarObserver
{
  QCallDetailActivity$1(QCallDetailActivity paramQCallDetailActivity) {}
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" === onUpdateCustomHead isSuccess | ");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(", uin | ");
      ((StringBuilder)localObject).append(paramString);
      QLog.i("QCallDetailActivity", 2, ((StringBuilder)localObject).toString());
    }
    if ((paramBoolean) && (QCallDetailActivity.a(this.a) == 3000) && (!Utils.a(paramString, this.a.app.getCurrentAccountUin())))
    {
      localObject = (DiscussionManager)this.a.app.getManager(QQManagerFactory.DISCUSSION_MANAGER);
      if (localObject == null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("QCallDetailActivity", 2, " === onUpdateCustomHead dm is null  ====");
        }
        return;
      }
      if (((DiscussionManager)localObject).a(QCallDetailActivity.a(this.a)) == null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("QCallDetailActivity", 2, " === onUpdateCustomHead info is null ====");
        }
        return;
      }
      if (TextUtils.isEmpty(paramString))
      {
        QLog.i("QCallDetailActivity", 1, " === onUpdateCustomHead uin is null ====");
        return;
      }
      localObject = ((DiscussionManager)localObject).a(QCallDetailActivity.a(this.a));
      if ((localObject != null) && (((Map)localObject).size() > 0) && (((Map)localObject).containsKey(paramString)))
      {
        paramString = this.a;
        paramString.a(QCallDetailActivity.a(paramString));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.qcall.QCallDetailActivity.1
 * JD-Core Version:    0.7.0.1
 */