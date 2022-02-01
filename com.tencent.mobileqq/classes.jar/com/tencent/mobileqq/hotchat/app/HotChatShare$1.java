package com.tencent.mobileqq.hotchat.app;

import android.text.TextUtils;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;
import com.tencent.mobileqq.hotchat.api.IHotChatInfo;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;

class HotChatShare$1
  extends AvatarObserver
{
  HotChatShare$1(HotChatShare paramHotChatShare) {}
  
  protected void onStrangerHeadReady(boolean paramBoolean, String paramString1, int paramInt, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onStrangerHeadReady.isSuccess=");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(",id=");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(",idType=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(",downloadUrl=");
      localStringBuilder.append(paramString2);
      QLog.i("HotChatShare", 2, localStringBuilder.toString());
    }
    if ((paramInt == 200) && (!TextUtils.isEmpty(paramString1)) && (this.a.mInfo != null))
    {
      if (!paramString1.equals(this.a.mInfo.getOwnerUin())) {
        return;
      }
      paramString1 = this.a;
      paramString1.ownerHeadUrl = paramString2;
      if (paramString1.mLoading != null)
      {
        if (!this.a.mLoading.isShowing()) {
          return;
        }
        if (this.a.currentState == 0) {
          this.a.currentState = 2;
        } else if (this.a.currentState == 1) {
          this.a.currentState = 3;
        }
        if (this.a.currentState == 3)
        {
          this.a.hideProgress();
          HotChatShare.access$000(this.a);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.hotchat.app.HotChatShare.1
 * JD-Core Version:    0.7.0.1
 */