package com.tencent.qqmini.sdk.report;

import NS_COMM.COMM.Entry;
import NS_MINI_REPORT.REPORT.SingleDcData;
import android.content.SharedPreferences;
import bdnw;
import bdsq;
import bdsr;
import bdzf;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import java.util.ArrayList;
import java.util.Arrays;

public final class MiniProgramLpReportDC04884$1
  implements Runnable
{
  public MiniProgramLpReportDC04884$1(String paramString1, String paramString2, String paramString3) {}
  
  public void run()
  {
    if (((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).isDebugVersion()) {
      bdnw.a("MiniProgramLpReportDC04", "reportApiReportcalled with args: " + this.a);
    }
    Object localObject = bdzf.a().getString("version", "1.10.0.00173");
    localObject = bdsq.a(9, String.valueOf(6), new ArrayList(Arrays.asList(new COMM.Entry[] { bdsq.a("appid", this.b), bdsq.a("miniapp_version", this.c), bdsq.a("baselib_version", (String)localObject), bdsq.a("apiResult", this.a) })), null);
    bdsr.a().a((REPORT.SingleDcData)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.report.MiniProgramLpReportDC04884.1
 * JD-Core Version:    0.7.0.1
 */