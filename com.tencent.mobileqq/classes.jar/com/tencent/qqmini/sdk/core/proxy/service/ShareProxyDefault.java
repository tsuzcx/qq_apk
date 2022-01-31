package com.tencent.qqmini.sdk.core.proxy.service;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.qqmini.sdk.core.proxy.ShareProxy;
import com.tencent.qqmini.sdk.launcher.model.ShareData;
import java.util.HashMap;

public class ShareProxyDefault
  implements ShareProxy
{
  private static final String TAG = "ShareProxy";
  
  public int getDefaultShareTarget()
  {
    return -1;
  }
  
  public boolean isShareTargetAvailable(Context paramContext, int paramInt)
  {
    return true;
  }
  
  public void onJsShareAppMessage(Object paramObject) {}
  
  public void onJsShareAppPictureMessage(Object paramObject) {}
  
  public void onShareActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void share(Activity paramActivity, ShareData paramShareData) {}
  
  public void showShareMenuForInnerShareButton(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, HashMap<String, Integer> paramHashMap, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.proxy.service.ShareProxyDefault
 * JD-Core Version:    0.7.0.1
 */