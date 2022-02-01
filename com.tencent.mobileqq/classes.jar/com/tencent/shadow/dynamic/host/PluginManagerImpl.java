package com.tencent.shadow.dynamic.host;

import android.os.Bundle;

public abstract interface PluginManagerImpl
  extends PluginManager
{
  public abstract void onCreate(Bundle paramBundle);
  
  public abstract void onDestroy();
  
  public abstract void onSaveInstanceState(Bundle paramBundle);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.shadow.dynamic.host.PluginManagerImpl
 * JD-Core Version:    0.7.0.1
 */