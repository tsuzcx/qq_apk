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
  
  public void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QCallDetailActivity", 2, " === onUpdateCustomHead isSuccess | " + paramBoolean + ", uin | " + paramString);
    }
    Object localObject;
    if ((paramBoolean) && (QCallDetailActivity.a(this.a) == 3000) && (!Utils.a(paramString, this.a.app.getCurrentAccountUin())))
    {
      localObject = (DiscussionManager)this.a.app.getManager(QQManagerFactory.DISCUSSION_MANAGER);
      if (localObject != null) {
        break label110;
      }
      if (QLog.isColorLevel()) {
        QLog.i("QCallDetailActivity", 2, " === onUpdateCustomHead dm is null  ====");
      }
    }
    label110:
    do
    {
      do
      {
        return;
        if (((DiscussionManager)localObject).a(QCallDetailActivity.a(this.a)) != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("QCallDetailActivity", 2, " === onUpdateCustomHead info is null ====");
      return;
      if (TextUtils.isEmpty(paramString))
      {
        QLog.i("QCallDetailActivity", 1, " === onUpdateCustomHead uin is null ====");
        return;
      }
      localObject = ((DiscussionManager)localObject).a(QCallDetailActivity.a(this.a));
    } while ((localObject == null) || (((Map)localObject).size() <= 0) || (!((Map)localObject).containsKey(paramString)));
    this.a.a(QCallDetailActivity.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qcall.QCallDetailActivity.1
 * JD-Core Version:    0.7.0.1
 */