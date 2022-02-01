package com.tencent.qqinterface;

import android.content.Context;

public abstract interface NewMiniAioInterface
{
  public abstract void onBackground();
  
  public abstract void onCreate(Context paramContext, String paramString1, String paramString2, long paramLong, int paramInt);
  
  public abstract void onDestroy();
  
  public abstract void onForeground();
  
  public abstract void setPoint(int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqinterface.NewMiniAioInterface
 * JD-Core Version:    0.7.0.1
 */