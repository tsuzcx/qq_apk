package com.tencent.mobileqq.extendfriend;

import apwx;
import apxa;
import apxb;
import apxd;
import aqbo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class ExtendFriendManager$5
  implements Runnable
{
  public ExtendFriendManager$5(apwx paramapwx) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendManagerLimitchat", 2, "checkToDownloadResource");
    }
    if (!apwx.a(this.this$0)) {
      QLog.d("ExtendFriendManagerLimitchat", 2, "checkToDownloadResource !inited");
    }
    if (!aqbo.a())
    {
      if (apwx.a(this.this$0) == null) {
        QLog.d("ExtendFriendManagerLimitchat", 2, "mConfig  IS NOT READY");
      }
    }
    else {
      return;
    }
    Object localObject = aqbo.a();
    if (apwx.a(this.this$0).a != null)
    {
      localObject = (apxb)apwx.a(this.this$0).a.get(localObject);
      apwx.a(this.this$0).a((apxb)localObject);
      return;
    }
    QLog.d("ExtendFriendManagerLimitchat", 2, " limitChatResList IS NOT READY");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.ExtendFriendManager.5
 * JD-Core Version:    0.7.0.1
 */