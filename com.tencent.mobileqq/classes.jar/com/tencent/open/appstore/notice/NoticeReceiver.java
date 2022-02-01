package com.tencent.open.appstore.notice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.appcommon.Common;
import com.tencent.open.base.LogUtility;
import com.tencent.open.business.base.AppUtil;
import com.tencent.open.downloadnew.common.IntentFactory;
import com.tencent.open.downloadnew.common.NoticeParam;

public class NoticeReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent != null)
    {
      String str2 = paramIntent.getStringExtra("processName");
      if (!TextUtils.isEmpty(str2))
      {
        if (!str2.equalsIgnoreCase(Common.x())) {
          return;
        }
        String str1 = paramIntent.getAction();
        Object localObject = (NoticeParam)paramIntent.getParcelableExtra("noticeParam");
        if (localObject == null) {
          return;
        }
        paramIntent = str2.replace(":", ".");
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(IntentFactory.e);
        localStringBuilder.append(".");
        localStringBuilder.append(paramIntent);
        if (localStringBuilder.toString().equals(str1))
        {
          AppUtil.c(paramContext, ((NoticeParam)localObject).d);
          return;
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("processName :");
        localStringBuilder.append(str2);
        localStringBuilder.append(" | formatStr:");
        localStringBuilder.append(paramIntent);
        LogUtility.b("NoticeReceiver", localStringBuilder.toString());
        str2 = ((NoticeParam)localObject).d;
        localObject = ((NoticeParam)localObject).e;
        if ((TextUtils.isEmpty(str2)) && (TextUtils.isEmpty((CharSequence)localObject))) {
          return;
        }
        ThreadManager.executeOnSubThread(new NoticeReceiver.1(this, (String)localObject, paramIntent, str1, paramContext));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.appstore.notice.NoticeReceiver
 * JD-Core Version:    0.7.0.1
 */