package com.tencent.qqmini.sdk.report;

import NS_COMM.COMM.Entry;
import NS_MINI_REPORT.REPORT.SingleDcData;
import android.content.SharedPreferences;
import bhcg;
import bhch;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import com.tencent.qqmini.sdk.utils.StorageUtil;
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
      QMLog.d("MiniProgramLpReportDC04", "reportApiReportcalled with args: " + this.a);
    }
    Object localObject = StorageUtil.getPreference().getString("version", "1.14.0.00225");
    localObject = new ArrayList(Arrays.asList(new COMM.Entry[] { bhcg.a("appid", this.b), bhcg.a("miniapp_version", this.c), bhcg.a("baselib_version", (String)localObject), bhcg.a("apiResult", this.a) }));
    if (!QUAUtil.isQQApp()) {
      ((ArrayList)localObject).addAll(bhcg.a());
    }
    localObject = bhcg.a(9, String.valueOf(6), (List)localObject, null);
    bhch.a().a((REPORT.SingleDcData)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.report.MiniProgramLpReportDC04884.1
 * JD-Core Version:    0.7.0.1
 */