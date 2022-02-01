package com.tencent.mobileqq.richmedia.ordersend;

import android.view.View;
import com.tencent.mobileqq.activity.aio.Callback;
import com.tencent.mobileqq.app.BaseMessageObserver;
import com.tencent.mobileqq.data.MessageRecord;

public abstract interface IMediaMsgApi
{
  public abstract int a(MessageRecord paramMessageRecord);
  
  public abstract void a(long paramLong);
  
  public abstract void a(View paramView, Callback paramCallback);
  
  public abstract void a(MessageRecord paramMessageRecord, BaseMessageObserver paramBaseMessageObserver, IOrderMediaMsgService.IMsgSendingListener paramIMsgSendingListener);
  
  public abstract boolean a(int paramInt);
  
  public abstract boolean a(String paramString);
  
  public abstract String b(MessageRecord paramMessageRecord);
  
  public abstract boolean b(int paramInt);
  
  public abstract boolean c(MessageRecord paramMessageRecord);
  
  public abstract void d(MessageRecord paramMessageRecord);
  
  public abstract boolean e(MessageRecord paramMessageRecord);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.ordersend.IMediaMsgApi
 * JD-Core Version:    0.7.0.1
 */