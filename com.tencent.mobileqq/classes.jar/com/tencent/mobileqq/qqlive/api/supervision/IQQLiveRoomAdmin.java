package com.tencent.mobileqq.qqlive.api.supervision;

import com.tencent.mobileqq.qqlive.api.IQQLiveModule;
import com.tencent.mobileqq.qqlive.callback.room.AdminListCallback;
import com.tencent.mobileqq.qqlive.callback.room.IsAdminCallback;
import com.tencent.mobileqq.qqlive.callback.room.SetAdminCallback;
import com.tencent.mobileqq.qqlive.listener.supervision.OnAdminStatusChangedListener;

public abstract interface IQQLiveRoomAdmin
  extends IQQLiveModule
{
  public static final int ERR_CODE_IS_BEEN_SET_ADMIN = 10012;
  public static final int ERR_CODE_NOT_HAVE_ADMIN = 999;
  
  public abstract void addAdminStatusListener(OnAdminStatusChangedListener paramOnAdminStatusChangedListener);
  
  public abstract void getAdminListByAnchorUid(long paramLong1, long paramLong2, AdminListCallback paramAdminListCallback);
  
  public abstract void isAdmin(long paramLong1, long paramLong2, long paramLong3, IsAdminCallback paramIsAdminCallback);
  
  public abstract void removeAdminStatusListener(OnAdminStatusChangedListener paramOnAdminStatusChangedListener);
  
  public abstract void setAdminState(long paramLong1, long paramLong2, long paramLong3, boolean paramBoolean, SetAdminCallback paramSetAdminCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.supervision.IQQLiveRoomAdmin
 * JD-Core Version:    0.7.0.1
 */