package com.tencent.mobileqq.intervideo.litelive_kandian.customized.services.hostproxy;

import android.app.Activity;
import com.tencent.falco.base.libapi.hostproxy.HostChargeCallback;
import com.tencent.falco.base.libapi.hostproxy.SdkEventInterface;
import com.tencent.mobileqq.intervideo.litelive_kandian.customized.roombizmodules.datareport.DataReportMgr;
import com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.webview.WebViewPool;
import java.util.Map;

class KandianHostProxyBuilder$1$2
  implements SdkEventInterface
{
  KandianHostProxyBuilder$1$2(KandianHostProxyBuilder.1 param1) {}
  
  public boolean onBackPressed()
  {
    return false;
  }
  
  public void onChargeJump(HostChargeCallback paramHostChargeCallback) {}
  
  public void onCreateRoom()
  {
    DataReportMgr.a().a();
  }
  
  public void onDestroyRoom()
  {
    WebViewPool.a.b();
    DataReportMgr.a().b();
  }
  
  public void onEnterRoom(long paramLong, int paramInt) {}
  
  public void onExitLive() {}
  
  public void onExitRoom() {}
  
  public void onFirstFrame() {}
  
  public void onStartLive() {}
  
  public void onTransferWebViewAction(String paramString, Runnable paramRunnable, Map<String, String> paramMap) {}
  
  public void overridePendingTransition(Activity paramActivity) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.litelive_kandian.customized.services.hostproxy.KandianHostProxyBuilder.1.2
 * JD-Core Version:    0.7.0.1
 */