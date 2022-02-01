package com.tencent.mobileqq.qqexpand.widget;

import com.tencent.mobileqq.qqexpand.chat.utils.LimitChatUtil;
import com.tencent.mobileqq.qqexpand.network.ExpandObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.Semaphore;

class ExtendFriendCardOnHeadIconClick$6
  extends ExpandObserver
{
  ExtendFriendCardOnHeadIconClick$6(ExtendFriendCardOnHeadIconClick paramExtendFriendCardOnHeadIconClick) {}
  
  protected void a(boolean paramBoolean, Object paramObject, int paramInt)
  {
    if ((paramInt != 32) && (paramInt != 33))
    {
      QLog.e("ExtendFriendCardOnHeadIconClick", 1, "error! type must be either 32 or 33");
      return;
    }
    if ((paramBoolean) && (paramObject != null))
    {
      ExtendFriendCardOnHeadIconClick.a(this.a, (String)paramObject);
      ExtendFriendCardOnHeadIconClick.j(this.a).release();
      LimitChatUtil.a(ExtendFriendCardOnHeadIconClick.k(this.a), ExtendFriendCardOnHeadIconClick.d(this.a), paramObject);
      return;
    }
    QLog.w("ExtendFriendCardOnHeadIconClick", 1, "onPreLoadDataForAvatarProfileCard network error, data is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.widget.ExtendFriendCardOnHeadIconClick.6
 * JD-Core Version:    0.7.0.1
 */