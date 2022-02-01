package com.tencent.mobileqq.pushnotice;

import android.content.Intent;

public abstract interface IThirdPushDataHandler
{
  public abstract boolean a(Intent paramIntent);
  
  public abstract ThirdPushNotifyManager.PushNotificationData b(Intent paramIntent);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.pushnotice.IThirdPushDataHandler
 * JD-Core Version:    0.7.0.1
 */