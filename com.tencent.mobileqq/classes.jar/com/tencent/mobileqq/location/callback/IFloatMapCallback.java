package com.tencent.mobileqq.location.callback;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.location.data.LocationRoom.RoomKey;

public abstract interface IFloatMapCallback
{
  public abstract void a();
  
  public abstract boolean a(QBaseActivity paramQBaseActivity, LocationRoom.RoomKey paramRoomKey);
  
  public abstract void b();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.callback.IFloatMapCallback
 * JD-Core Version:    0.7.0.1
 */