package com.tencent.open.appstore.notice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import bfel;
import bfhg;
import bfij;
import bflr;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.downloadnew.common.NoticeParam;

public class NoticeReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str2;
    if (paramIntent != null)
    {
      str2 = paramIntent.getStringExtra("processName");
      if ((!TextUtils.isEmpty(str2)) && (str2.equalsIgnoreCase(bfel.r()))) {
        break label32;
      }
    }
    label32:
    String str1;
    Object localObject;
    do
    {
      do
      {
        return;
        str1 = paramIntent.getAction();
        localObject = (NoticeParam)paramIntent.getParcelableExtra("noticeParam");
      } while (localObject == null);
      paramIntent = str2.replace(":", ".");
      if ((bflr.e + "." + paramIntent).equals(str1))
      {
        bfij.a(paramContext, ((NoticeParam)localObject).d);
        return;
      }
      bfhg.b("NoticeReceiver", "processName :" + str2 + " | formatStr:" + paramIntent);
      str2 = ((NoticeParam)localObject).d;
      localObject = ((NoticeParam)localObject).e;
    } while ((TextUtils.isEmpty(str2)) && (TextUtils.isEmpty((CharSequence)localObject)));
    ThreadManager.executeOnSubThread(new NoticeReceiver.1(this, (String)localObject, paramIntent, str1, paramContext));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.appstore.notice.NoticeReceiver
 * JD-Core Version:    0.7.0.1
 */