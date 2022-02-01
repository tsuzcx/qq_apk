package com.tencent.open.downloadnew;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.LogUtility;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.tmassistantsdk.TMAssistantCallYYB_V2;
import com.tencent.tmassistantsdk.internal.logreport.OuterCallReportModel;

final class MyAppApi$1
  implements Runnable
{
  public void run()
  {
    long l = System.currentTimeMillis();
    int i;
    OuterCallReportModel localOuterCallReportModel;
    Intent localIntent;
    if (MyAppApi.h()) {
      if (TMAssistantCallYYB_V2.getInstance().getIPCInterface() == null)
      {
        LogUtility.b("TAMST_WAKE", "getIPCInterface() == null");
        i = GlobalUtil.getInstance().getQQDownloaderVersionCode();
        localOuterCallReportModel = MyAppApi.a();
        if (i >= 7172130)
        {
          LogUtility.b("TAMST_WAKE", "YYB version code:" + i + ",use new wake!");
          localIntent = new Intent();
          localIntent.setClassName("com.tencent.android.qqdownloader", "com.live.push.PushActivity");
          localIntent.putExtra("from", CommonDataAdapter.a().a().getPackageName());
          localIntent.putExtra("via", "CALL_LIVE_QQ");
          localIntent.addFlags(268435456);
        }
      }
    }
    try
    {
      CommonDataAdapter.a().a().startActivity(localIntent);
      localOuterCallReportModel.mComponentName = "com.live.push.PushActivity";
      label145:
      MyAppApi.b(localOuterCallReportModel);
      ControlPolicyUtil.b();
      LogUtility.c("TAMST_WAKE", "costTime = " + (System.currentTimeMillis() - l));
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      for (;;)
      {
        LogUtility.e("TAMST_WAKE", "activity not found error:" + localActivityNotFoundException.getMessage());
        continue;
        LogUtility.b("TAMST_WAKE", "YYB version code:" + i + ",use old wake!");
        MyAppApi.a(localOuterCallReportModel);
        continue;
        LogUtility.b("TAMST_WAKE", "don't need tmast wake");
        continue;
        LogUtility.b("TAMST_WAKE", "can not do tmast!");
      }
    }
    catch (SecurityException localSecurityException)
    {
      break label145;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.downloadnew.MyAppApi.1
 * JD-Core Version:    0.7.0.1
 */