package com.tencent.mobileqq.extendfriend.limitchat;

import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.utils.DialogUtil;
import mqq.app.QQPermissionCallback;

class ExtendFriendLimitChatMatchFragment$11
  implements QQPermissionCallback
{
  ExtendFriendLimitChatMatchFragment$11(ExtendFriendLimitChatMatchFragment paramExtendFriendLimitChatMatchFragment) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if ((ExtendFriendLimitChatMatchFragment.a(this.a) != null) && (!ExtendFriendLimitChatMatchFragment.a(this.a).isFinishing())) {
      DialogUtil.a(ExtendFriendLimitChatMatchFragment.a(this.a), paramArrayOfString, paramArrayOfInt);
    }
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    ExtendFriendLimitChatMatchFragment.g(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.limitchat.ExtendFriendLimitChatMatchFragment.11
 * JD-Core Version:    0.7.0.1
 */