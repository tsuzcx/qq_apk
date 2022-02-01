package com.tencent.mobileqq.imaxad;

import com.tencent.biz.pubaccount.Advertisement.data.AdvertisementItem;
import com.tencent.biz.pubaccount.Advertisement.data.VideoCoverItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

class ImaxAdRecentUserManager$1
  implements Runnable
{
  ImaxAdRecentUserManager$1(ImaxAdRecentUserManager paramImaxAdRecentUserManager, boolean paramBoolean, QQAppInterface paramQQAppInterface, AdvertisementItem paramAdvertisementItem, RecentUser paramRecentUser) {}
  
  public void run()
  {
    if (this.a) {
      ImaxAdPresenter.a().a(this.b, this.c);
    }
    if (this.c != null)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("doDeleteItem disk  uin:");
        ((StringBuilder)localObject).append(this.d.uin);
        QLog.d("ImaxAdvertisement", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = this.c.c.iterator();
      while (((Iterator)localObject).hasNext()) {
        ImaxAdVideoPreloadManager.c(((VideoCoverItem)((Iterator)localObject).next()).c);
      }
    }
    ImaxAdUtil.c(this.b.getCurrentUin(), this.d.uin);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.imaxad.ImaxAdRecentUserManager.1
 * JD-Core Version:    0.7.0.1
 */