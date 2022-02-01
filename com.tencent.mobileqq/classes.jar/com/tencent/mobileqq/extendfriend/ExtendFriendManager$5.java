package com.tencent.mobileqq.extendfriend;

import asvi;
import asvr;
import asvs;
import asvu;
import atax;
import bhnv;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class ExtendFriendManager$5
  implements Runnable
{
  public ExtendFriendManager$5(asvi paramasvi) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendManagerLimitchat", 2, "checkToDownloadResource");
    }
    if (!asvi.a(this.this$0)) {
      QLog.d("ExtendFriendManagerLimitchat", 2, "checkToDownloadResource !inited");
    }
    if (!atax.a())
    {
      QLog.e("ExtendFriendManagerLimitchat", 2, "isBgPicFileExist  no！");
      if (asvi.a(this.this$0) == null) {
        QLog.d("ExtendFriendManagerLimitchat", 2, "mConfig  IS NOT READY");
      }
    }
    else
    {
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2 = asvi.a(this.this$0);
    if ((!bhnv.h(BaseApplicationImpl.getContext())) && (l1 - l2 < 1200000L) && (asvi.a(this.this$0) > 2))
    {
      QLog.e("ExtendFriendManagerLimitchat", 2, " limitChatResList IS NOT READY currentTime" + l1 + " lastDownloadTime " + asvi.a(this.this$0) + " downloadTimes" + asvi.a(this.this$0));
      return;
    }
    Object localObject = atax.a();
    if (asvi.a(this.this$0).a != null)
    {
      localObject = (asvs)asvi.a(this.this$0).a.get(localObject);
      asvi.a(this.this$0).a((asvs)localObject);
      asvi.a(this.this$0, l1);
      asvi.b(this.this$0);
      return;
    }
    QLog.d("ExtendFriendManagerLimitchat", 2, " limitChatResList IS NOT READY");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.ExtendFriendManager.5
 * JD-Core Version:    0.7.0.1
 */