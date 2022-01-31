package com.tencent.qqmini.sdk.launcher.shell;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.ShareState;

public abstract interface IMiniRuntime
{
  public static final int SHARE_QQ = 1;
  public static final int SHARE_QQ_CHAT = 5;
  public static final int SHARE_QZONE = 2;
  public static final int SHARE_WX_FRIEND = 3;
  public static final int SHARE_WX_MOMENT = 4;
  
  public abstract void close();
  
  public abstract Activity getAttachedActivity();
  
  public abstract MiniAppInfo getMiniAppInfo();
  
  public abstract int getRuntimeId();
  
  public abstract ShareState getShareState();
  
  public abstract boolean restart();
  
  public abstract void share(int paramInt, Bundle paramBundle);
  
  public abstract boolean toggleDebugPanel();
  
  public abstract boolean toggleMonitorPanel();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.shell.IMiniRuntime
 * JD-Core Version:    0.7.0.1
 */