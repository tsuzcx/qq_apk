package com.tencent.mobileqq.intervideo.groupvideo.plugininterface;

import android.content.Intent;

public abstract interface IVHostCallback
{
  public abstract void onHostActivityBackPress();
  
  public abstract void onHostActivityDestroy();
  
  public abstract void onHostActivityNewIntent(Intent paramIntent);
  
  public abstract void onHostActivityPause();
  
  public abstract void onHostActivityResult(int paramInt1, int paramInt2, Intent paramIntent);
  
  public abstract void onHostActivityResume();
  
  public abstract void onHostActivityStop();
  
  public abstract void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.groupvideo.plugininterface.IVHostCallback
 * JD-Core Version:    0.7.0.1
 */