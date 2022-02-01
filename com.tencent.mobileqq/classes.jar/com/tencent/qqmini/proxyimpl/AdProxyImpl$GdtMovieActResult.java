package com.tencent.qqmini.proxyimpl;

import android.content.Intent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.manager.ActivityResultManager;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultListener;

public class AdProxyImpl$GdtMovieActResult
  implements IActivityResultListener
{
  private AdProxyImpl.SDKRewardedVideoAdView a;
  
  public AdProxyImpl$GdtMovieActResult(AdProxyImpl.SDKRewardedVideoAdView paramSDKRewardedVideoAdView)
  {
    this.a = paramSDKRewardedVideoAdView;
  }
  
  public boolean doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doOnActivityResult requestCode=");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(" resultCode=");
      ((StringBuilder)localObject).append(paramInt2);
      QLog.d("AdProxyImpl", 1, ((StringBuilder)localObject).toString());
    }
    ActivityResultManager.g().removeActivityResultListener(this);
    if (paramInt1 == 4760)
    {
      localObject = this.a;
      if (localObject != null) {
        ((AdProxyImpl.SDKRewardedVideoAdView)localObject).a(paramInt2, paramIntent.getExtras());
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.AdProxyImpl.GdtMovieActResult
 * JD-Core Version:    0.7.0.1
 */