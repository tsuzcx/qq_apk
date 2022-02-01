package com.tencent.mobileqq.extendfriend.limitchat;

import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

class ExtendFriendLimitChatMatchFragment$3
  extends AvatarObserver
{
  ExtendFriendLimitChatMatchFragment$3(ExtendFriendLimitChatMatchFragment paramExtendFriendLimitChatMatchFragment) {}
  
  public void onGetApolloHeadInfo(boolean paramBoolean, String paramString, byte paramByte)
  {
    super.onGetApolloHeadInfo(paramBoolean, paramString, paramByte);
    if (!TextUtils.equals(ExtendFriendLimitChatMatchFragment.a(this.a).getCurrentAccountUin(), paramString)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ExtendFriendLimitChatMatchFragment", 2, String.format("onGetApolloHeadInfo success=%s，uin=%s，faceType=%s", new Object[] { Boolean.valueOf(paramBoolean), paramString, Byte.valueOf(paramByte) }));
    }
    if (paramBoolean)
    {
      ExtendFriendLimitChatMatchFragment.b(this.a, true);
      ExtendFriendLimitChatMatchFragment.a(this.a, paramByte);
      ExtendFriendLimitChatMatchFragment.a(this.a, paramByte);
      return;
    }
    ExtendFriendLimitChatMatchFragment.b(this.a, false);
    ExtendFriendLimitChatMatchFragment.a(this.a, -1);
    ReportController.b(ExtendFriendLimitChatMatchFragment.a(this.a).app, "dc00898", "", "", "0X800B442", "0X800B442", 4, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.limitchat.ExtendFriendLimitChatMatchFragment.3
 * JD-Core Version:    0.7.0.1
 */