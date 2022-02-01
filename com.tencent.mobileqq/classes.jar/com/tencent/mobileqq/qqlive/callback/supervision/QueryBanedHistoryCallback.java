package com.tencent.mobileqq.qqlive.callback.supervision;

import com.tencent.mobileqq.qqlive.callback.BaseCallback;
import com.tencent.mobileqq.qqlive.data.supervision.BanChatUserListData;

public abstract interface QueryBanedHistoryCallback
  extends BaseCallback
{
  public abstract void a(BanChatUserListData paramBanChatUserListData);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.callback.supervision.QueryBanedHistoryCallback
 * JD-Core Version:    0.7.0.1
 */