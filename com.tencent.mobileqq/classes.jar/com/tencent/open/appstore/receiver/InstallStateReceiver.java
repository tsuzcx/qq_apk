package com.tencent.open.appstore.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import bfkr;
import bflg;
import bflp;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.downloadnew.DownloadInfo;
import java.util.Iterator;
import java.util.List;

public class InstallStateReceiver
  extends BroadcastReceiver
{
  protected final String a = "InstallStateReceiver";
  
  private void a(String paramString, int paramInt)
  {
    List localList = bfkr.a().b(paramString, 4);
    Object localObject = localList;
    if (localList.size() == 0) {
      localObject = bfkr.a().a(paramString, 4);
    }
    bflp.c("InstallStateReceiver", ">notifyInstalled " + paramString + ", info:" + localObject);
    paramString = ((List)localObject).iterator();
    while (paramString.hasNext())
    {
      localObject = (DownloadInfo)paramString.next();
      if ((localObject != null) && (((DownloadInfo)localObject).a() == 4))
      {
        bflp.c("InstallStateReceiver", ">notifyInstalled " + localObject);
        if (1 == paramInt) {
          bfkr.a().f((DownloadInfo)localObject);
        } else if (2 == paramInt) {
          bfkr.a().e((DownloadInfo)localObject);
        } else {
          bflp.e("InstallStateReceiver", ">notifyInstalled bad notifyType:" + paramInt);
        }
      }
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    bflp.c("InstallStateReceiver", "[onReceive] action=" + paramIntent.getAction());
    paramContext = paramIntent.getDataString();
    if (TextUtils.isEmpty(paramContext)) {
      bflp.e("InstallStateReceiver", "[onReceive] intentPkgNameString == null ");
    }
    Object localObject;
    String str;
    do
    {
      return;
      localObject = paramContext.split(":");
      if (localObject.length == 2)
      {
        localObject = localObject[1];
        str = paramIntent.getAction();
        if (TextUtils.equals(str, "android.intent.action.PACKAGE_REMOVED")) {
          ThreadManager.excute(new InstallStateReceiver.1(this, paramContext, (String)localObject), 16, null, true);
        }
      }
      else
      {
        bflp.e("InstallStateReceiver", "[onReceive] packageName == null " + paramIntent.getDataString());
        return;
      }
      if (TextUtils.equals(str, "android.intent.action.PACKAGE_REPLACED"))
      {
        bflg.a((String)localObject, true);
        ThreadManager.excute(new InstallStateReceiver.2(this, paramContext, (String)localObject), 16, null, true);
        return;
      }
    } while (!TextUtils.equals(str, "android.intent.action.PACKAGE_ADDED"));
    ThreadManager.excute(new InstallStateReceiver.3(this, paramIntent, paramContext, (String)localObject), 16, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.appstore.receiver.InstallStateReceiver
 * JD-Core Version:    0.7.0.1
 */