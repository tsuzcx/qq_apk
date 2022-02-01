package com.tencent.mobileqq.qcall;

import android.text.TextUtils;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.qphone.base.util.QLog;
import friendlist.GetOnlineInfoResp;
import java.util.Map;

class QCallDetailActivity$2
  extends FriendListObserver
{
  QCallDetailActivity$2(QCallDetailActivity paramQCallDetailActivity) {}
  
  protected void onGetOnlineInfoByUinOrMobile(boolean paramBoolean, long paramLong, String paramString, GetOnlineInfoResp paramGetOnlineInfoResp)
  {
    if ((paramBoolean) && (TextUtils.equals(paramString, QCallDetailActivity.b(this.a))))
    {
      QCallDetailActivity.c(this.a);
      this.a.runOnUiThread(new QCallDetailActivity.2.1(this));
    }
  }
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if ((paramBoolean) && (QCallDetailActivity.a(this.a) == 3000))
    {
      Object localObject = (DiscussionManager)this.a.app.getManager(QQManagerFactory.DISCUSSION_MANAGER);
      if (localObject == null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("QCallDetailActivity", 2, " === onUpdateFriendInfo dm is null  ====");
        }
        return;
      }
      DiscussionInfo localDiscussionInfo = ((DiscussionManager)localObject).d(QCallDetailActivity.b(this.a));
      if (localDiscussionInfo == null)
      {
        QLog.i("QCallDetailActivity", 1, " ===onUpdateFriendInfo info is null ====");
        return;
      }
      if (TextUtils.isEmpty(paramString))
      {
        QLog.i("QCallDetailActivity", 1, " === onUpdateFriendInfo uin is null ====");
        return;
      }
      if (!localDiscussionInfo.hasRenamed())
      {
        localObject = ((DiscussionManager)localObject).b(QCallDetailActivity.b(this.a));
        if ((localObject != null) && (((Map)localObject).size() > 0) && (((Map)localObject).containsKey(paramString)))
        {
          paramString = this.a;
          paramString.a(QCallDetailActivity.b(paramString));
        }
      }
    }
  }
  
  protected void onUpdateOnlineFriend(boolean paramBoolean, String[] paramArrayOfString)
  {
    QCallDetailActivity.c(this.a);
    this.a.runOnUiThread(new QCallDetailActivity.2.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qcall.QCallDetailActivity.2
 * JD-Core Version:    0.7.0.1
 */