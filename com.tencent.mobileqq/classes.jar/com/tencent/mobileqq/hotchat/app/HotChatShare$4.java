package com.tencent.mobileqq.hotchat.app;

import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.avatar.api.IQQAvatarHandlerService;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.hotchat.api.IHotChatInfo;
import com.tencent.qphone.base.util.QLog;

class HotChatShare$4
  implements Runnable
{
  HotChatShare$4(HotChatShare paramHotChatShare) {}
  
  public void run()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("stranger_");
    ((StringBuilder)localObject).append(String.valueOf(200));
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(this.this$0.mInfo.getOwnerUin());
    localObject = ((StringBuilder)localObject).toString();
    localObject = this.this$0.app.getSettingFromDb((String)localObject);
    if ((localObject != null) && (!TextUtils.isEmpty(((Setting)localObject).url)))
    {
      HotChatShare localHotChatShare = this.this$0;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(((Setting)localObject).url);
      localStringBuilder.append("140");
      localHotChatShare.ownerHeadUrl = localStringBuilder.toString();
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleShare.fromdb.ownerHeadUrl=");
      ((StringBuilder)localObject).append(this.this$0.ownerHeadUrl);
      QLog.i("HotChatShare", 2, ((StringBuilder)localObject).toString());
    }
    if (!TextUtils.isEmpty(this.this$0.ownerHeadUrl))
    {
      if (this.this$0.currentState == 0) {
        this.this$0.currentState = 2;
      } else if (this.this$0.currentState == 1) {
        this.this$0.currentState = 3;
      }
    }
    else {
      ((IQQAvatarHandlerService)this.this$0.app.getRuntimeService(IQQAvatarHandlerService.class, "")).getStrangerHead(this.this$0.mInfo.getOwnerUin(), 200, (byte)1, (byte)3);
    }
    if (this.this$0.currentState == 3) {
      this.this$0.mBaseActivity.runOnUiThread(new HotChatShare.4.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.hotchat.app.HotChatShare.4
 * JD-Core Version:    0.7.0.1
 */