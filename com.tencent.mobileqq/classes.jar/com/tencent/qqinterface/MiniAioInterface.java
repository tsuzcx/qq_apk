package com.tencent.qqinterface;

import android.content.Context;

public abstract interface MiniAioInterface
{
  public abstract void onBackground();
  
  public abstract void onCreate(Context paramContext, long paramLong, int paramInt);
  
  public abstract void onDestroy();
  
  public abstract void onForeground();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.qqinterface.MiniAioInterface
 * JD-Core Version:    0.7.0.1
 */