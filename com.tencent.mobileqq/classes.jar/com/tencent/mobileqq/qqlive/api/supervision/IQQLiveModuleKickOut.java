package com.tencent.mobileqq.qqlive.api.supervision;

import com.tencent.mobileqq.qqlive.api.IQQLiveModule;
import com.tencent.mobileqq.qqlive.callback.supervision.KickOutUserCallback;
import com.tencent.mobileqq.qqlive.callback.supervision.QueryKickOutHistoryCallback;
import com.tencent.mobileqq.qqlive.data.room.AdminReason;
import com.tencent.mobileqq.qqlive.listener.supervision.OnKickedOutOfRoomListener;
import java.util.List;

public abstract interface IQQLiveModuleKickOut
  extends IQQLiveModule
{
  public abstract void addKickedOutOfRoomListener(OnKickedOutOfRoomListener paramOnKickedOutOfRoomListener);
  
  public abstract void cancelKickOutUser(long paramLong1, long paramLong2, long paramLong3, KickOutUserCallback paramKickOutUserCallback);
  
  public abstract List<AdminReason> getKickOutReasonList();
  
  public abstract void kickOutUser(long paramLong1, long paramLong2, long paramLong3, int paramInt, KickOutUserCallback paramKickOutUserCallback);
  
  public abstract void queryKickOutHistory(long paramLong, int paramInt1, int paramInt2, QueryKickOutHistoryCallback paramQueryKickOutHistoryCallback);
  
  public abstract void removeKickedOutOfRoomListener(OnKickedOutOfRoomListener paramOnKickedOutOfRoomListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.supervision.IQQLiveModuleKickOut
 * JD-Core Version:    0.7.0.1
 */