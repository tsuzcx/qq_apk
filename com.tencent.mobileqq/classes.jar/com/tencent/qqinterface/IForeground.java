package com.tencent.qqinterface;

import android.content.Context;

public abstract interface IForeground
{
  public abstract void onCreate(Context paramContext);
  
  public abstract void onDestroy();
  
  public abstract void onPause();
  
  public abstract void onResume();
  
  public abstract void onStart();
  
  public abstract void onStop();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqinterface.IForeground
 * JD-Core Version:    0.7.0.1
 */