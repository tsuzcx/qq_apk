package com.tencent.mobileqq.hotchat.app;

import android.text.TextUtils;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.hotchat.api.IHotChatInfo;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;

class HotChatShare$2
  extends FriendListObserver
{
  HotChatShare$2(HotChatShare paramHotChatShare) {}
  
  protected void onGetFriendDateNick(boolean paramBoolean, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGetFriendDateNick.isSuccess=");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(",uin=");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(",nick=");
      localStringBuilder.append(paramString2);
      QLog.i("HotChatShare", 2, localStringBuilder.toString());
    }
    if ((!TextUtils.isEmpty(paramString1)) && (this.a.mInfo != null) && (paramString1.equals(this.a.mInfo.getOwnerUin())))
    {
      if (!TextUtils.isEmpty(this.a.ownerNickname)) {
        return;
      }
      if (paramBoolean) {
        this.a.ownerNickname = paramString2;
      }
      if (this.a.mLoading != null)
      {
        if (!this.a.mLoading.isShowing()) {
          return;
        }
        if (this.a.currentState == 0) {
          this.a.currentState = 1;
        } else if (this.a.currentState == 2) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.hotchat.app.HotChatShare.2
 * JD-Core Version:    0.7.0.1
 */