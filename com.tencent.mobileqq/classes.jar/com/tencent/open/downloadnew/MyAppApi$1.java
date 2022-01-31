package com.tencent.open.downloadnew;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import bbtm;
import bcds;
import bcgg;
import bchb;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.tmassistantsdk.TMAssistantCallYYB_V2;
import com.tencent.tmassistantsdk.internal.logreport.OuterCallReportModel;

public final class MyAppApi$1
  implements Runnable
{
  public void run()
  {
    long l = System.currentTimeMillis();
    int i;
    OuterCallReportModel localOuterCallReportModel;
    Intent localIntent;
    if (bchb.h()) {
      if (TMAssistantCallYYB_V2.getInstance().getIPCInterface() == null)
      {
        bcds.b("TAMST_WAKE", "getIPCInterface() == null");
        i = GlobalUtil.getInstance().getQQDownloaderVersionCode();
        localOuterCallReportModel = bchb.a();
        if (i >= 7172130)
        {
          bcds.b("TAMST_WAKE", "YYB version code:" + i + ",use new wake!");
          localIntent = new Intent();
          localIntent.setClassName("com.tencent.android.qqdownloader", "com.live.push.PushActivity");
          localIntent.putExtra("from", bbtm.a().a().getPackageName());
          localIntent.putExtra("via", "CALL_LIVE_QQ");
          localIntent.addFlags(268435456);
        }
      }
    }
    try
    {
      bbtm.a().a().startActivity(localIntent);
      localOuterCallReportModel.mComponentName = "com.live.push.PushActivity";
      label145:
      bchb.b(localOuterCallReportModel);
      bcgg.b();
      bcds.c("TAMST_WAKE", "costTime = " + (System.currentTimeMillis() - l));
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      for (;;)
      {
        bcds.e("TAMST_WAKE", "activity not found error:" + localActivityNotFoundException.getMessage());
        continue;
        bcds.b("TAMST_WAKE", "YYB version code:" + i + ",use old wake!");
        bchb.a(localOuterCallReportModel);
        continue;
        bcds.b("TAMST_WAKE", "don't need tmast wake");
        continue;
        bcds.b("TAMST_WAKE", "can not do tmast!");
      }
    }
    catch (SecurityException localSecurityException)
    {
      break label145;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.downloadnew.MyAppApi.1
 * JD-Core Version:    0.7.0.1
 */