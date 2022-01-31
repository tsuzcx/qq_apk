package com.tencent.open.downloadnew;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import bexd;
import bfhg;
import bfjt;
import bfko;
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
    if (bfko.h()) {
      if (TMAssistantCallYYB_V2.getInstance().getIPCInterface() == null)
      {
        bfhg.b("TAMST_WAKE", "getIPCInterface() == null");
        i = GlobalUtil.getInstance().getQQDownloaderVersionCode();
        localOuterCallReportModel = bfko.a();
        if (i >= 7172130)
        {
          bfhg.b("TAMST_WAKE", "YYB version code:" + i + ",use new wake!");
          localIntent = new Intent();
          localIntent.setClassName("com.tencent.android.qqdownloader", "com.live.push.PushActivity");
          localIntent.putExtra("from", bexd.a().a().getPackageName());
          localIntent.putExtra("via", "CALL_LIVE_QQ");
          localIntent.addFlags(268435456);
        }
      }
    }
    try
    {
      bexd.a().a().startActivity(localIntent);
      localOuterCallReportModel.mComponentName = "com.live.push.PushActivity";
      label145:
      bfko.b(localOuterCallReportModel);
      bfjt.b();
      bfhg.c("TAMST_WAKE", "costTime = " + (System.currentTimeMillis() - l));
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      for (;;)
      {
        bfhg.e("TAMST_WAKE", "activity not found error:" + localActivityNotFoundException.getMessage());
        continue;
        bfhg.b("TAMST_WAKE", "YYB version code:" + i + ",use old wake!");
        bfko.a(localOuterCallReportModel);
        continue;
        bfhg.b("TAMST_WAKE", "don't need tmast wake");
        continue;
        bfhg.b("TAMST_WAKE", "can not do tmast!");
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