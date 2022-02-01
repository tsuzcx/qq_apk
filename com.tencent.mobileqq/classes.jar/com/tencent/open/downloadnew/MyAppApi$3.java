package com.tencent.open.downloadnew;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.LogUtility;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.tmassistantsdk.TMAssistantCallYYB_V2;
import com.tencent.tmassistantsdk.internal.logreport.OuterCallReportModel;

final class MyAppApi$3
  implements Runnable
{
  public void run()
  {
    long l = System.currentTimeMillis();
    int i;
    Object localObject2;
    if (MyAppApi.i()) {
      if (TMAssistantCallYYB_V2.getInstance().getIPCInterface() == null)
      {
        LogUtility.b("TAMST_WAKE", "getIPCInterface() == null");
        i = GlobalUtil.getInstance().getQQDownloaderVersionCode();
        localObject1 = MyAppApi.a();
        if (i >= 7172130)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("YYB version code:");
          ((StringBuilder)localObject2).append(i);
          ((StringBuilder)localObject2).append(",use new wake!");
          LogUtility.b("TAMST_WAKE", ((StringBuilder)localObject2).toString());
          localObject2 = new Intent();
          ((Intent)localObject2).setClassName("com.tencent.android.qqdownloader", "com.live.push.PushActivity");
          ((Intent)localObject2).putExtra("from", CommonDataAdapter.a().a().getPackageName());
          ((Intent)localObject2).putExtra("via", "CALL_LIVE_QQ");
          ((Intent)localObject2).addFlags(268435456);
        }
      }
    }
    try
    {
      try
      {
        CommonDataAdapter.a().a().startActivity((Intent)localObject2);
        ((OuterCallReportModel)localObject1).mComponentName = "com.live.push.PushActivity";
      }
      catch (ActivityNotFoundException localActivityNotFoundException)
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("activity not found error:");
        localStringBuilder2.append(localActivityNotFoundException.getMessage());
        LogUtility.e("TAMST_WAKE", localStringBuilder2.toString());
      }
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("YYB version code:");
      localStringBuilder1.append(i);
      localStringBuilder1.append(",use old wake!");
      LogUtility.b("TAMST_WAKE", localStringBuilder1.toString());
    }
    catch (SecurityException localSecurityException)
    {
      label246:
      break label246;
    }
    MyAppApi.a((OuterCallReportModel)localObject1);
    ControlPolicyUtil.c();
    break label274;
    LogUtility.b("TAMST_WAKE", "don't need tmast wake");
    break label274;
    LogUtility.b("TAMST_WAKE", "can not do tmast!");
    label274:
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("costTime = ");
    ((StringBuilder)localObject1).append(System.currentTimeMillis() - l);
    LogUtility.c("TAMST_WAKE", ((StringBuilder)localObject1).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.downloadnew.MyAppApi.3
 * JD-Core Version:    0.7.0.1
 */