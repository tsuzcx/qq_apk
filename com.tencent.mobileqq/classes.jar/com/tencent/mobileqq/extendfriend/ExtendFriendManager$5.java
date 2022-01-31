package com.tencent.mobileqq.extendfriend;

import aoeu;
import aoex;
import aoey;
import aofa;
import aojm;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class ExtendFriendManager$5
  implements Runnable
{
  public ExtendFriendManager$5(aoeu paramaoeu) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendManagerLimitchat", 2, "checkToDownloadResource");
    }
    if (!aoeu.a(this.this$0)) {
      QLog.d("ExtendFriendManagerLimitchat", 2, "checkToDownloadResource !inited");
    }
    if (!aojm.a())
    {
      if (aoeu.a(this.this$0) == null) {
        QLog.d("ExtendFriendManagerLimitchat", 2, "mConfig  IS NOT READY");
      }
    }
    else {
      return;
    }
    Object localObject = aojm.a();
    if (aoeu.a(this.this$0).a != null)
    {
      localObject = (aoey)aoeu.a(this.this$0).a.get(localObject);
      aoeu.a(this.this$0).a((aoey)localObject);
      return;
    }
    QLog.d("ExtendFriendManagerLimitchat", 2, " limitChatResList IS NOT READY");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.ExtendFriendManager.5
 * JD-Core Version:    0.7.0.1
 */