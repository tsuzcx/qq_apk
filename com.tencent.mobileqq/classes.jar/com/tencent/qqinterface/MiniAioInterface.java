package com.tencent.qqinterface;

import android.content.Context;
import android.os.Bundle;

public abstract interface MiniAioInterface
{
  public abstract void onBackground();
  
  public abstract void onCreate(Context paramContext, Bundle paramBundle);
  
  public abstract void onDestroy();
  
  public abstract void onForeground();
  
  public abstract void showEntry(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqinterface.MiniAioInterface
 * JD-Core Version:    0.7.0.1
 */