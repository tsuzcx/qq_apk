package com.tencent.open.downloadnew.common;

import aktn;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.appcommon.Common;
import com.tencent.open.base.LogUtility;
import com.tencent.open.business.base.AppUtil;

public class DownloadReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str3;
    if (paramIntent != null)
    {
      str3 = paramIntent.getStringExtra("processName");
      if ((!TextUtils.isEmpty(str3)) && (str3.equalsIgnoreCase(Common.r()))) {
        break label32;
      }
    }
    label32:
    String str1;
    String str2;
    String str4;
    do
    {
      do
      {
        return;
        str1 = paramIntent.getAction();
        paramIntent = (NoticeParam)paramIntent.getParcelableExtra("noticeParam");
      } while (paramIntent == null);
      str2 = str3.replace(":", ".");
      if ((IntentFactory.e + "." + str2).equals(str1))
      {
        AppUtil.a(paramContext, paramIntent.d);
        return;
      }
      LogUtility.b("vivi", "processName :" + str3 + " | formatStr:" + str2);
      str3 = paramIntent.a;
      str4 = paramIntent.d;
    } while ((TextUtils.isEmpty(str3)) && (TextUtils.isEmpty(str4)));
    ThreadManager.executeOnSubThread(new aktn(this, str3, str4, paramIntent, str2, str1, paramContext));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.open.downloadnew.common.DownloadReceiver
 * JD-Core Version:    0.7.0.1
 */