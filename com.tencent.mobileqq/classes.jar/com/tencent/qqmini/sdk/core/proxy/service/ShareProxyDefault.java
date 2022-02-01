package com.tencent.qqmini.sdk.core.proxy.service;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.proxy.ShareProxy;
import com.tencent.qqmini.sdk.launcher.model.ShareData;
import com.tencent.qqmini.sdk.ui.MorePanel;

@ProxyService(proxy=ShareProxy.class)
public class ShareProxyDefault
  implements ShareProxy
{
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
  
  public void sharePic(Activity paramActivity, ShareData paramShareData) {}
  
  public void showSharePanel(IMiniAppContext paramIMiniAppContext)
  {
    MorePanel.show(paramIMiniAppContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.proxy.service.ShareProxyDefault
 * JD-Core Version:    0.7.0.1
 */