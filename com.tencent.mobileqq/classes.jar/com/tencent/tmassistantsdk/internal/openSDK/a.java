package com.tencent.tmassistantsdk.internal.openSDK;

import android.content.Intent;
import com.tencent.tmassistantsdk.TMAssistantCallYYBParamStruct;
import java.util.ArrayList;
import java.util.Iterator;

class a
  implements Runnable
{
  a(DownloadStateChangedReceiver paramDownloadStateChangedReceiver, Intent paramIntent) {}
  
  public void run()
  {
    e locale = new e();
    locale.b = this.a.getStringExtra("hostPackageName");
    locale.c = this.a.getStringExtra("hostVersion");
    locale.d = this.a.getStringExtra("taskId");
    locale.f = Integer.parseInt(this.a.getStringExtra("errorCode"));
    locale.g = this.a.getStringExtra("errorMsg");
    locale.e = Integer.parseInt(this.a.getStringExtra("state"));
    Object localObject = new TMAssistantCallYYBParamStruct();
    ((TMAssistantCallYYBParamStruct)localObject).SNGAppId = this.a.getStringExtra("sngAppId");
    ((TMAssistantCallYYBParamStruct)localObject).taskAppId = this.a.getStringExtra("taskAppId");
    ((TMAssistantCallYYBParamStruct)localObject).taskApkId = this.a.getStringExtra("taskApkId");
    ((TMAssistantCallYYBParamStruct)localObject).taskPackageName = this.a.getStringExtra("taskPackageName");
    ((TMAssistantCallYYBParamStruct)localObject).taskVersion = Integer.parseInt(this.a.getStringExtra("taskVersion"));
    ((TMAssistantCallYYBParamStruct)localObject).via = this.a.getStringExtra("via");
    ((TMAssistantCallYYBParamStruct)localObject).uin = this.a.getStringExtra("uin");
    ((TMAssistantCallYYBParamStruct)localObject).uinType = this.a.getStringExtra("uinType");
    locale.a = ((TMAssistantCallYYBParamStruct)localObject);
    localObject = this.b.f.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((b)((Iterator)localObject).next()).onDownloadStateChanged(locale);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmassistantsdk.internal.openSDK.a
 * JD-Core Version:    0.7.0.1
 */