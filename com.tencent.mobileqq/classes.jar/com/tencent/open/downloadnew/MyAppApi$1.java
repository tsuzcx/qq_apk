package com.tencent.open.downloadnew;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import bjjo;
import bjtx;
import bjwj;
import bjxd;
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
    if (bjxd.h()) {
      if (TMAssistantCallYYB_V2.getInstance().getIPCInterface() == null)
      {
        bjtx.b("TAMST_WAKE", "getIPCInterface() == null");
        i = GlobalUtil.getInstance().getQQDownloaderVersionCode();
        localOuterCallReportModel = bjxd.a();
        if (i >= 7172130)
        {
          bjtx.b("TAMST_WAKE", "YYB version code:" + i + ",use new wake!");
          localIntent = new Intent();
          localIntent.setClassName("com.tencent.android.qqdownloader", "com.live.push.PushActivity");
          localIntent.putExtra("from", bjjo.a().a().getPackageName());
          localIntent.putExtra("via", "CALL_LIVE_QQ");
          localIntent.addFlags(268435456);
        }
      }
    }
    try
    {
      bjjo.a().a().startActivity(localIntent);
      localOuterCallReportModel.mComponentName = "com.live.push.PushActivity";
      label145:
      bjxd.b(localOuterCallReportModel);
      bjwj.b();
      bjtx.c("TAMST_WAKE", "costTime = " + (System.currentTimeMillis() - l));
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      for (;;)
      {
        bjtx.e("TAMST_WAKE", "activity not found error:" + localActivityNotFoundException.getMessage());
        continue;
        bjtx.b("TAMST_WAKE", "YYB version code:" + i + ",use old wake!");
        bjxd.a(localOuterCallReportModel);
        continue;
        bjtx.b("TAMST_WAKE", "don't need tmast wake");
        continue;
        bjtx.b("TAMST_WAKE", "can not do tmast!");
      }
    }
    catch (SecurityException localSecurityException)
    {
      break label145;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.downloadnew.MyAppApi.1
 * JD-Core Version:    0.7.0.1
 */