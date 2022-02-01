package com.tencent.treasurecard.api;

import android.content.Context;
import com.tencent.treasurecard.net.INetCallBack;
import com.tencent.treasurecard.net.INetRequest;

public abstract interface ITcSdkContext
{
  public abstract void a(Context paramContext);
  
  public abstract void a(ITcSdkContext.OnCardStateChangeListener paramOnCardStateChangeListener);
  
  public abstract void a(INetCallBack paramINetCallBack);
  
  public abstract void a(INetRequest paramINetRequest);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.treasurecard.api.ITcSdkContext
 * JD-Core Version:    0.7.0.1
 */