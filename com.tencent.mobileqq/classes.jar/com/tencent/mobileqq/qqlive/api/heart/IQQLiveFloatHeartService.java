package com.tencent.mobileqq.qqlive.api.heart;

import com.tencent.mobileqq.qqlive.api.IQQLiveModule;
import com.tencent.mobileqq.qqlive.data.heart.FloatHeart;
import com.tencent.mobileqq.qqlive.listener.heart.OnReceiveFloatHeartListener;

public abstract interface IQQLiveFloatHeartService
  extends IQQLiveModule
{
  public abstract void addOnReceiveFloatHeartListener(OnReceiveFloatHeartListener paramOnReceiveFloatHeartListener);
  
  public abstract void removeOnReceiveFloatHeartListener(OnReceiveFloatHeartListener paramOnReceiveFloatHeartListener);
  
  public abstract void sendFloatHeart(FloatHeart paramFloatHeart);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.heart.IQQLiveFloatHeartService
 * JD-Core Version:    0.7.0.1
 */