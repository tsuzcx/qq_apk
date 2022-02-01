package com.tencent.qqmini.sdk.report;

import NS_COMM.COMM.Entry;
import NS_MINI_REPORT.REPORT.SingleDcData;
import android.content.SharedPreferences;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.StorageUtil;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final class MiniProgramLpReportDC04884$1
  implements Runnable
{
  MiniProgramLpReportDC04884$1(String paramString1, String paramString2, String paramString3) {}
  
  public void run()
  {
    if (((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).isDebugVersion()) {
      QMLog.d("MiniProgramLpReportDC04", "reportApiReportcalled with args: " + this.val$jsonParams);
    }
    Object localObject = StorageUtil.getPreference().getString("version", "1.18.0.00132");
    localObject = new ArrayList(Arrays.asList(new COMM.Entry[] { MiniProgramReportHelper.newEntry("appid", this.val$appId), MiniProgramReportHelper.newEntry("miniapp_version", this.val$miniapp_version), MiniProgramReportHelper.newEntry("baselib_version", (String)localObject), MiniProgramReportHelper.newEntry("apiResult", this.val$jsonParams) }));
    if (!QUAUtil.isQQApp()) {
      ((ArrayList)localObject).addAll(MiniProgramReportHelper.newThirdSourceEntries());
    }
    localObject = MiniProgramReportHelper.newSingleDcData(9, String.valueOf(6), (List)localObject, null);
    MiniProgramReporter.getInstance().add((REPORT.SingleDcData)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.report.MiniProgramLpReportDC04884.1
 * JD-Core Version:    0.7.0.1
 */