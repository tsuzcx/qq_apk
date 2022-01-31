package com.tencent.qqmini.sdk.report;

import NS_COMM.COMM.Entry;
import NS_MINI_REPORT.REPORT.SingleDcData;
import android.content.SharedPreferences;
import betc;
import beze;
import bezf;
import bfhk;
import bfhm;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class MiniProgramLpReportDC04884$1
  implements Runnable
{
  public MiniProgramLpReportDC04884$1(String paramString1, String paramString2, String paramString3) {}
  
  public void run()
  {
    if (((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).isDebugVersion()) {
      betc.a("MiniProgramLpReportDC04", "reportApiReportcalled with args: " + this.a);
    }
    Object localObject = bfhm.a().getString("version", "1.13.0.00013");
    localObject = new ArrayList(Arrays.asList(new COMM.Entry[] { beze.a("appid", this.b), beze.a("miniapp_version", this.c), beze.a("baselib_version", (String)localObject), beze.a("apiResult", this.a) }));
    if (!bfhk.a()) {
      ((ArrayList)localObject).addAll(beze.a());
    }
    localObject = beze.a(9, String.valueOf(6), (List)localObject, null);
    bezf.a().a((REPORT.SingleDcData)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.report.MiniProgramLpReportDC04884.1
 * JD-Core Version:    0.7.0.1
 */