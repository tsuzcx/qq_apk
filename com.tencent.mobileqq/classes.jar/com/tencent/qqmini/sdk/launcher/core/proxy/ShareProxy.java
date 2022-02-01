package com.tencent.qqmini.sdk.launcher.core.proxy;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.model.ShareData;

public abstract interface ShareProxy
{
  public abstract int getDefaultShareTarget();
  
  public abstract boolean isShareTargetAvailable(Context paramContext, int paramInt);
  
  public abstract void onJsShareAppMessage(Object paramObject);
  
  public abstract void onJsShareAppPictureMessage(Object paramObject);
  
  public abstract void onShareActivityResult(int paramInt1, int paramInt2, Intent paramIntent);
  
  public abstract void share(Activity paramActivity, ShareData paramShareData);
  
  public abstract void sharePic(Activity paramActivity, ShareData paramShareData);
  
  public abstract void showSharePanel(IMiniAppContext paramIMiniAppContext);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.core.proxy.ShareProxy
 * JD-Core Version:    0.7.0.1
 */