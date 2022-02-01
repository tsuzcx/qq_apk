package com.tencent.mobileqq.extendfriend;

import aslo;
import aslx;
import asly;
import asma;
import asrl;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class ExtendFriendManager$5
  implements Runnable
{
  public ExtendFriendManager$5(aslo paramaslo) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendManagerLimitchat", 2, "checkToDownloadResource");
    }
    if (!aslo.a(this.this$0)) {
      QLog.d("ExtendFriendManagerLimitchat", 2, "checkToDownloadResource !inited");
    }
    if (!asrl.a())
    {
      QLog.e("ExtendFriendManagerLimitchat", 2, "isBgPicFileExist  no！");
      if (aslo.a(this.this$0) == null) {
        QLog.d("ExtendFriendManagerLimitchat", 2, "mConfig  IS NOT READY");
      }
    }
    else
    {
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2 = aslo.a(this.this$0);
    if ((!NetworkUtil.isWifiConnected(BaseApplicationImpl.getContext())) && (l1 - l2 < 1200000L) && (aslo.a(this.this$0) > 2))
    {
      QLog.e("ExtendFriendManagerLimitchat", 2, " limitChatResList IS NOT READY currentTime" + l1 + " lastDownloadTime " + aslo.a(this.this$0) + " downloadTimes" + aslo.a(this.this$0));
      return;
    }
    Object localObject = asrl.a();
    if (aslo.a(this.this$0).a != null)
    {
      localObject = (asly)aslo.a(this.this$0).a.get(localObject);
      aslo.a(this.this$0).a((asly)localObject);
      aslo.a(this.this$0, l1);
      aslo.b(this.this$0);
      return;
    }
    QLog.d("ExtendFriendManagerLimitchat", 2, " limitChatResList IS NOT READY");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.ExtendFriendManager.5
 * JD-Core Version:    0.7.0.1
 */