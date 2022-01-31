package com.tencent.mobileqq.extendfriend;

import anoe;
import anoh;
import anoi;
import anok;
import ansv;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class ExtendFriendManager$5
  implements Runnable
{
  public ExtendFriendManager$5(anoe paramanoe) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendManagerLimitchat", 2, "checkToDownloadResource");
    }
    if (!anoe.a(this.this$0)) {
      QLog.d("ExtendFriendManagerLimitchat", 2, "checkToDownloadResource !inited");
    }
    if (!ansv.a())
    {
      if (anoe.a(this.this$0) == null) {
        QLog.d("ExtendFriendManagerLimitchat", 2, "mConfig  IS NOT READY");
      }
    }
    else {
      return;
    }
    Object localObject = ansv.a();
    if (anoe.a(this.this$0).a != null)
    {
      localObject = (anoi)anoe.a(this.this$0).a.get(localObject);
      anoe.a(this.this$0).a((anoi)localObject);
      return;
    }
    QLog.d("ExtendFriendManagerLimitchat", 2, " limitChatResList IS NOT READY");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.ExtendFriendManager.5
 * JD-Core Version:    0.7.0.1
 */