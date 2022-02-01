package com.tencent.mobileqq.utils;

import afvi;
import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.SessionInfo;

public class QQCustomArkDialog$AppInfo
{
  public String appMinVersion;
  public String appName;
  public String appView;
  public afvi container;
  public String metaData;
  public float scale;
  public SessionInfo session;
  public boolean showShareMenu;
  public String title = "";
  
  public QQCustomArkDialog$AppInfo(Bundle paramBundle)
  {
    this.appName = paramBundle.getString("appName");
    this.appView = paramBundle.getString("appView");
    this.appMinVersion = paramBundle.getString("appMinVersion");
    this.metaData = paramBundle.getString("metaData");
    this.scale = paramBundle.getFloat("scale", 1.0F);
    this.session = new SessionInfo();
    paramBundle = paramBundle.getString("troopUin");
    if (paramBundle != null)
    {
      this.session.curType = 1;
      this.session.curFriendUin = paramBundle;
    }
  }
  
  public static Bundle zipArgs(String paramString1, String paramString2, String paramString3, String paramString4, float paramFloat, String paramString5, Bundle paramBundle)
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
    localBundle.putString("troopUin", paramString5);
    return localBundle;
  }
  
  public Bundle toBundle()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("appName", this.appName);
    localBundle.putString("appMinVersion", this.appMinVersion);
    localBundle.putString("appView", this.appView);
    localBundle.putString("metaData", this.metaData);
    localBundle.putFloat("scale", this.scale);
    if ((this.session != null) && (this.session.curType == 1)) {
      localBundle.putString("troopUin", this.session.curFriendUin);
    }
    return localBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomArkDialog.AppInfo
 * JD-Core Version:    0.7.0.1
 */