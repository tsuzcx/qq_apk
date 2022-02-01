package com.tencent.mobileqq.intervideo.lite_now_biz.now_live;

import android.app.Activity;
import com.tencent.falco.base.libapi.hostproxy.HostChargeCallback;
import com.tencent.falco.base.libapi.hostproxy.SdkEventInterface;
import com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.webview.WebViewPool;
import java.util.Map;

class NowHostProxyBuilder$1$3
  implements SdkEventInterface
{
  NowHostProxyBuilder$1$3(NowHostProxyBuilder.1 param1) {}
  
  public boolean onBackPressed()
  {
    return false;
  }
  
  public void onChargeJump(HostChargeCallback paramHostChargeCallback) {}
  
  public void onCoreUILoaded() {}
  
  public void onCreateRoom() {}
  
  public void onDestroyRoom()
  {
    WebViewPool.a.c();
  }
  
  public void onEnterRoom(long paramLong, int paramInt) {}
  
  public void onExitLive() {}
  
  public void onExitRoom() {}
  
  public void onFirstFrame() {}
  
  public void onLoginFail(String paramString, int paramInt) {}
  
  public void onLoginSuccess(long paramLong, String paramString) {}
  
  public void onStartEnterRoom(long paramLong) {}
  
  public void onStartLive() {}
  
  public void onTransferWebViewAction(String paramString, Runnable paramRunnable, Map<String, String> paramMap) {}
  
  public void overridePendingTransition(Activity paramActivity) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.now_live.NowHostProxyBuilder.1.3
 * JD-Core Version:    0.7.0.1
 */