package com.tencent.mobileqq.utils;

import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.ArkAppContainer;

public class QQCustomArkDialog$AppInfo
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
  
  public QQCustomArkDialog$AppInfo(Bundle paramBundle)
  {
    this.a = paramBundle.getString("appName");
    this.b = paramBundle.getString("appView");
    this.c = paramBundle.getString("appMinVersion");
    this.d = paramBundle.getString("metaData");
    this.e = paramBundle.getFloat("scale", 1.0F);
    this.f = new SessionInfo();
    paramBundle = paramBundle.getString("troop_uin");
    if (paramBundle != null)
    {
      SessionInfo localSessionInfo = this.f;
      localSessionInfo.a = 1;
      localSessionInfo.b = paramBundle;
    }
  }
  
  public static Bundle a(String paramString1, String paramString2, String paramString3, String paramString4, float paramFloat, String paramString5, Bundle paramBundle)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putString("appName", paramString1);
    localBundle.putString("appMinVersion", paramString3);
    localBundle.putString("appView", paramString2);
    localBundle.putString("metaData", paramString4);
    localBundle.putFloat("scale", paramFloat);
    localBundle.putString("troop_uin", paramString5);
    return localBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomArkDialog.AppInfo
 * JD-Core Version:    0.7.0.1
 */