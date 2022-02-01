package com.tencent.mobileqq.extendfriend;

import arhi;
import arhr;
import arhs;
import arhu;
import arnf;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class ExtendFriendManager$5
  implements Runnable
{
  public ExtendFriendManager$5(arhi paramarhi) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendManagerLimitchat", 2, "checkToDownloadResource");
    }
    if (!arhi.a(this.this$0)) {
      QLog.d("ExtendFriendManagerLimitchat", 2, "checkToDownloadResource !inited");
    }
    if (!arnf.a())
    {
      QLog.e("ExtendFriendManagerLimitchat", 2, "isBgPicFileExist  no！");
      if (arhi.a(this.this$0) == null) {
        QLog.d("ExtendFriendManagerLimitchat", 2, "mConfig  IS NOT READY");
      }
    }
    else
    {
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2 = arhi.a(this.this$0);
    if ((!NetworkUtil.isWifiConnected(BaseApplicationImpl.getContext())) && (l1 - l2 < 1200000L) && (arhi.a(this.this$0) > 2))
    {
      QLog.e("ExtendFriendManagerLimitchat", 2, " limitChatResList IS NOT READY currentTime" + l1 + " lastDownloadTime " + arhi.a(this.this$0) + " downloadTimes" + arhi.a(this.this$0));
      return;
    }
    Object localObject = arnf.a();
    if (arhi.a(this.this$0).a != null)
    {
      localObject = (arhs)arhi.a(this.this$0).a.get(localObject);
      arhi.a(this.this$0).a((arhs)localObject);
      arhi.a(this.this$0, l1);
      arhi.b(this.this$0);
      return;
    }
    QLog.d("ExtendFriendManagerLimitchat", 2, " limitChatResList IS NOT READY");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.ExtendFriendManager.5
 * JD-Core Version:    0.7.0.1
 */