package com.tencent.mobileqq.utils;

import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.ArkAppContainer;

public class QQCustomArkDialogForAio$AppInfo
{
  public String a;
  public String b;
  public String c;
  public String d;
  public float e;
  public SessionInfo f;
  public ArkAppContainer g = null;
  public String h = "";
  public boolean i = false;
  
  public QQCustomArkDialogForAio$AppInfo(Bundle paramBundle)
  {
    this.a = paramBundle.getString("appName");
    this.b = paramBundle.getString("appView");
    this.c = paramBundle.getString("appMinVersion");
    this.d = paramBundle.getString("metaData");
    this.e = paramBundle.getFloat("scale", 1.0F);
    this.f = new SessionInfo();
    paramBundle = paramBundle.getString("troopUin");
    if (paramBundle != null)
    {
      SessionInfo localSessionInfo = this.f;
      localSessionInfo.a = 1;
      localSessionInfo.b = paramBundle;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomArkDialogForAio.AppInfo
 * JD-Core Version:    0.7.0.1
 */