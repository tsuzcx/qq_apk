package com.tencent.open.downloadnew.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.appcommon.Common;
import com.tencent.open.appstore.dl.DownloadInfoReport;
import com.tencent.open.base.LogUtility;
import com.tencent.open.business.base.AppUtil;
import java.util.concurrent.ConcurrentHashMap;

public class DownloadReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent != null)
    {
      String str3 = paramIntent.getStringExtra("processName");
      if (!TextUtils.isEmpty(str3))
      {
        if (!str3.equalsIgnoreCase(Common.r())) {
          return;
        }
        String str1 = paramIntent.getAction();
        paramIntent = (NoticeParam)paramIntent.getParcelableExtra("noticeParam");
        if (paramIntent == null) {
          return;
        }
        String str2 = str3.replace(":", ".");
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append(IntentFactory.e);
        ((StringBuilder)localObject).append(".");
        ((StringBuilder)localObject).append(str2);
        if (((StringBuilder)localObject).toString().equals(str1))
        {
          AppUtil.a(paramContext, paramIntent.d);
          return;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("processName :");
        ((StringBuilder)localObject).append(str3);
        ((StringBuilder)localObject).append(" | formatStr:");
        ((StringBuilder)localObject).append(str2);
        LogUtility.b("vivi", ((StringBuilder)localObject).toString());
        str3 = paramIntent.a;
        localObject = paramIntent.d;
        if ((TextUtils.isEmpty(str3)) && (TextUtils.isEmpty((CharSequence)localObject))) {
          return;
        }
        StackTraceElement[] arrayOfStackTraceElement = new Throwable().getStackTrace();
        StringBuilder localStringBuilder = new StringBuilder();
        int i = 1;
        while (i < arrayOfStackTraceElement.length)
        {
          localStringBuilder.append(arrayOfStackTraceElement[i].toString());
          i += 1;
        }
        if (!TextUtils.isEmpty(str3)) {
          DownloadInfoReport.a.put(str3, localStringBuilder.toString());
        } else if (!TextUtils.isEmpty(paramIntent.e)) {
          DownloadInfoReport.a.put(paramIntent.e, localStringBuilder.toString());
        }
        ThreadManager.executeOnSubThread(new DownloadReceiver.1(this, str3, (String)localObject, paramIntent, str2, str1, paramContext));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.downloadnew.common.DownloadReceiver
 * JD-Core Version:    0.7.0.1
 */