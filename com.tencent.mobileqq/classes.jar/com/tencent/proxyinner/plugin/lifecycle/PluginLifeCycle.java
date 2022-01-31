package com.tencent.proxyinner.plugin.lifecycle;

import android.content.Context;
import com.tencent.proxyinner.utility.ApkUtility;

public class PluginLifeCycle
{
  boolean isLoaded = false;
  Context mContext;
  String mProcessName;
  
  public PluginLifeCycle(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public boolean isPluginLoaded()
  {
    return (ApkUtility.isProcessExist(this.mContext, this.mProcessName)) && (this.isLoaded);
  }
  
  public void onPluginLoaded(String paramString)
  {
    this.mProcessName = paramString;
    this.isLoaded = true;
  }
  
  public void onPluginUnLoaded()
  {
    this.isLoaded = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.proxyinner.plugin.lifecycle.PluginLifeCycle
 * JD-Core Version:    0.7.0.1
 */