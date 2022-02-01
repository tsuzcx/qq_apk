package com.tencent.mobileqq.qqlive.api.supervision;

import com.tencent.mobileqq.qqlive.api.IQQLiveModule;
import com.tencent.mobileqq.qqlive.callback.supervision.QueryBanedHistoryCallback;
import com.tencent.mobileqq.qqlive.callback.supervision.QueryIsBanedChatCallback;
import com.tencent.mobileqq.qqlive.callback.supervision.SetBanChatCallback;
import com.tencent.mobileqq.qqlive.data.room.AdminReason;
import java.util.List;

public abstract interface IQQLiveBanChat
  extends IQQLiveModule
{
  public abstract void banChat(long paramLong1, long paramLong2, long paramLong3, int paramInt, SetBanChatCallback paramSetBanChatCallback);
  
  public abstract void cancelBanChat(long paramLong1, long paramLong2, long paramLong3, SetBanChatCallback paramSetBanChatCallback);
  
  public abstract List<AdminReason> getBanChatReasonList();
  
  public abstract void isBanedChat(long paramLong1, long paramLong2, long paramLong3, QueryIsBanedChatCallback paramQueryIsBanedChatCallback);
  
  public abstract void queryBanedHistory(long paramLong1, long paramLong2, int paramInt1, int paramInt2, QueryBanedHistoryCallback paramQueryBanedHistoryCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.supervision.IQQLiveBanChat
 * JD-Core Version:    0.7.0.1
 */