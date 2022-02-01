package com.tencent.mobileqq.extendfriend;

import asfu;
import asgd;
import asge;
import asgg;
import aslb;
import bgnt;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class ExtendFriendManager$5
  implements Runnable
{
  public ExtendFriendManager$5(asfu paramasfu) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendManagerLimitchat", 2, "checkToDownloadResource");
    }
    if (!asfu.a(this.this$0)) {
      QLog.d("ExtendFriendManagerLimitchat", 2, "checkToDownloadResource !inited");
    }
    if (!aslb.a())
    {
      QLog.e("ExtendFriendManagerLimitchat", 2, "isBgPicFileExist  no！");
      if (asfu.a(this.this$0) == null) {
        QLog.d("ExtendFriendManagerLimitchat", 2, "mConfig  IS NOT READY");
      }
    }
    else
    {
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2 = asfu.a(this.this$0);
    if ((!bgnt.h(BaseApplicationImpl.getContext())) && (l1 - l2 < 1200000L) && (asfu.a(this.this$0) > 2))
    {
      QLog.e("ExtendFriendManagerLimitchat", 2, " limitChatResList IS NOT READY currentTime" + l1 + " lastDownloadTime " + asfu.a(this.this$0) + " downloadTimes" + asfu.a(this.this$0));
      return;
    }
    Object localObject = aslb.a();
    if (asfu.a(this.this$0).a != null)
    {
      localObject = (asge)asfu.a(this.this$0).a.get(localObject);
      asfu.a(this.this$0).a((asge)localObject);
      asfu.a(this.this$0, l1);
      asfu.b(this.this$0);
      return;
    }
    QLog.d("ExtendFriendManagerLimitchat", 2, " limitChatResList IS NOT READY");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.ExtendFriendManager.5
 * JD-Core Version:    0.7.0.1
 */