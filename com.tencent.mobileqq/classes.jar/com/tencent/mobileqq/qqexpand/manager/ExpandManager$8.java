package com.tencent.mobileqq.qqexpand.manager;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qqexpand.bean.chat.LimitChatRes;
import com.tencent.mobileqq.qqexpand.config.ExpandConfig;
import com.tencent.mobileqq.qqexpand.downloader.ExtendFriendResourceDownloader;
import com.tencent.mobileqq.qqexpand.manager.config.ExpandConfigManager;
import com.tencent.mobileqq.qqexpand.utils.ExpandLimitChatResourceUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class ExpandManager$8
  implements Runnable
{
  ExpandManager$8(ExpandManager paramExpandManager) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendManagerLimitchat", 2, "checkToDownloadResource");
    }
    if (!ExpandManager.a(this.this$0).a()) {
      QLog.d("ExtendFriendManagerLimitchat", 2, "checkToDownloadResource !inited");
    }
    if (!ExpandLimitChatResourceUtil.a())
    {
      QLog.e("ExtendFriendManagerLimitchat", 2, "isBgPicFileExist  no！");
      if (ExpandManager.a(this.this$0).a() == null)
      {
        QLog.d("ExtendFriendManagerLimitchat", 2, "mConfig  IS NOT READY");
        return;
      }
      long l1 = System.currentTimeMillis();
      long l2 = ExpandManager.a(this.this$0);
      if ((!NetworkUtil.isWifiConnected(BaseApplicationImpl.getContext())) && (l1 - l2 < 1200000L) && (ExpandManager.a(this.this$0) > 2))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(" limitChatResList IS NOT READY currentTime");
        ((StringBuilder)localObject).append(l1);
        ((StringBuilder)localObject).append(" lastDownloadTime ");
        ((StringBuilder)localObject).append(ExpandManager.a(this.this$0));
        ((StringBuilder)localObject).append(" downloadTimes");
        ((StringBuilder)localObject).append(ExpandManager.a(this.this$0));
        QLog.e("ExtendFriendManagerLimitchat", 2, ((StringBuilder)localObject).toString());
        return;
      }
      Object localObject = ExpandLimitChatResourceUtil.a();
      if ((ExpandManager.a(this.this$0) != null) && (ExpandManager.a(this.this$0).a().limitChatResList != null))
      {
        localObject = (LimitChatRes)ExpandManager.a(this.this$0).a().limitChatResList.get(localObject);
        ExpandManager.a(this.this$0).a((LimitChatRes)localObject);
        ExpandManager.a(this.this$0, l1);
        ExpandManager.b(this.this$0);
        return;
      }
      QLog.d("ExtendFriendManagerLimitchat", 2, " limitChatResList IS NOT READY");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.manager.ExpandManager.8
 * JD-Core Version:    0.7.0.1
 */