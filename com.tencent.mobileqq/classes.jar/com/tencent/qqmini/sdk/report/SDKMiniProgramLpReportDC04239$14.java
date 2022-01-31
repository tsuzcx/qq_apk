package com.tencent.qqmini.sdk.report;

import android.os.Bundle;
import beyu;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;

public final class SDKMiniProgramLpReportDC04239$14
  implements Runnable
{
  public void run()
  {
    if (beyu.a() != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("app_config", beyu.a());
      localBundle.putLong("add_duration_ms", beyu.a());
      ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).callServer("MiniAppTransferModule", "record_duration_sdk_4239", localBundle);
      beyu.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239.14
 * JD-Core Version:    0.7.0.1
 */