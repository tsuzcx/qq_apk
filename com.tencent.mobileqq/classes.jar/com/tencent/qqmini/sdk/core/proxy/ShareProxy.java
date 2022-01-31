package com.tencent.qqmini.sdk.core.proxy;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.qqmini.sdk.launcher.model.ShareData;
import java.util.HashMap;

public abstract interface ShareProxy
{
  public abstract int getDefaultShareTarget();
  
  public abstract boolean isShareTargetAvailable(Context paramContext, int paramInt);
  
  public abstract void onJsShareAppMessage(Object paramObject);
  
  public abstract void onJsShareAppPictureMessage(Object paramObject);
  
  public abstract void onShareActivityResult(int paramInt1, int paramInt2, Intent paramIntent);
  
  public abstract void share(Activity paramActivity, ShareData paramShareData);
  
  public abstract void showShareMenuForInnerShareButton(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, HashMap<String, Integer> paramHashMap, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.proxy.ShareProxy
 * JD-Core Version:    0.7.0.1
 */