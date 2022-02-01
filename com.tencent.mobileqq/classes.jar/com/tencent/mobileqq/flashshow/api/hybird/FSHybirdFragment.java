package com.tencent.mobileqq.flashshow.api.hybird;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.webview.swift.WebBrowserViewContainer;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.mobileqq.webview.swift.utils.WebViewKernelCallBack;

public class FSHybirdFragment
  extends WebViewFragment
{
  private static final String a = "FSHybirdFragment";
  private FSHybirdFragment.FSHybirdBroadcastReceiver b;
  
  private void a()
  {
    if (getWebView() != null)
    {
      getUIStyleHandler().E = getResources().getColor(2131166050);
      getUIStyleHandler().D.setBackgroundColor(getUIStyleHandler().E);
      if (getWebView().getX5WebViewExtension() != null) {
        try
        {
          getWebView().getView().setBackgroundColor(getResources().getColor(2131166050));
          getWebView().setBackgroundColor(getResources().getColor(2131166050));
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      } else {
        getWebView().setBackgroundColor(getResources().getColor(2131166050));
      }
      if (this.contentView != null) {
        this.contentView.setBackgroundColor(getResources().getColor(2131166050));
      }
    }
  }
  
  public void a(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("action_update_native_user_follow_state");
    localIntent.putExtra("uin", paramString1);
    localIntent.putExtra("followState", paramInt);
    localIntent.putExtra("nick", paramString2);
    localIntent.putExtra("avatar", paramString3);
    if (getHostActivity() != null) {
      getHostActivity().sendBroadcast(localIntent);
    }
  }
  
  public void doOnBackEvent()
  {
    super.doOnBackEvent();
  }
  
  public WebViewKernelCallBack getWebViewKernelCallBack()
  {
    return new FSHybirdFragment.1(this, this.webViewSurface);
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    a();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if ((getQBaseActivity() != null) && (this.b != null)) {
      getQBaseActivity().unregisterReceiver(this.b);
    }
  }
  
  public void onPause()
  {
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.api.hybird.FSHybirdFragment
 * JD-Core Version:    0.7.0.1
 */