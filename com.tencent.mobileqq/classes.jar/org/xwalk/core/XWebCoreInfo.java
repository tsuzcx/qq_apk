package org.xwalk.core;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.xweb.util.h;

public class XWebCoreInfo
{
  private static final String TAG = "XWebCoreInfo";
  public String strAbi;
  public int ver;
  public String verDetail;
  
  public static XWebCoreInfo getBackupCoreInfo(String paramString)
  {
    XWebCoreInfo localXWebCoreInfo = new XWebCoreInfo();
    localXWebCoreInfo.strAbi = paramString;
    SharedPreferences localSharedPreferences = XWalkEnvironment.getSharedPreferencesForVersionInfo();
    localXWebCoreInfo.ver = localSharedPreferences.getInt(getBackupKey(paramString, "version"), -1);
    localXWebCoreInfo.verDetail = localSharedPreferences.getString(getBackupKey(paramString, "versionDetail"), "");
    return localXWebCoreInfo;
  }
  
  private static String getBackupKey(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("back_core_");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("_for_");
    localStringBuilder.append(paramString1);
    return localStringBuilder.toString();
  }
  
  public static int getCurAbiInstalledNewestVersion(Context paramContext)
  {
    if (paramContext == null) {
      return -5;
    }
    if (XWalkEnvironment.getApplicationContext() == null) {
      XWalkEnvironment.init(paramContext);
    }
    return XWalkEnvironment.getSharedPreferencesForVersionInfo().getInt(getBackupKey(XWalkEnvironment.getRuntimeAbi(), "version"), -1);
  }
  
  private static boolean isValidAbi(String paramString)
  {
    return TextUtils.isEmpty(paramString) ^ true;
  }
  
  public static boolean setVersionForAbi(int paramInt, String paramString1, String paramString2)
  {
    SharedPreferences.Editor localEditor = XWalkEnvironment.getSharedPreferencesForVersionInfo().edit();
    localEditor.putInt(getBackupKey(paramString2, "version"), paramInt);
    localEditor.putString(getBackupKey(paramString2, "versionDetail"), paramString1);
    boolean bool = localEditor.commit();
    if ((bool) && (paramInt > 0) && (!XWalkEnvironment.getRuntimeAbi().equalsIgnoreCase(paramString2))) {
      if ("armeabi-v7a".equalsIgnoreCase(paramString2)) {
        h.a(577L, 238L, 1L);
      } else if ("arm64-v8a".equalsIgnoreCase(paramString2)) {
        h.a(577L, 239L, 1L);
      }
    }
    paramString1 = new StringBuilder();
    paramString1.append("set xwalk version to ");
    paramString1.append(paramInt);
    paramString1.append(" suc = ");
    paramString1.append(bool);
    paramString1.append(" abi = ");
    paramString1.append(paramString2);
    XWalkEnvironment.addXWalkInitializeLog("XWebCoreInfo", paramString1.toString());
    return bool;
  }
  
  public static boolean setVersionForAbi(XWebCoreInfo paramXWebCoreInfo)
  {
    if (paramXWebCoreInfo == null)
    {
      Log.e("XWebCoreInfo", "setVersionForAbi info is null");
      return false;
    }
    return setVersionForAbi(paramXWebCoreInfo.ver, paramXWebCoreInfo.verDetail, paramXWebCoreInfo.strAbi);
  }
  
  public boolean isValid()
  {
    return this.ver > 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.xwalk.core.XWebCoreInfo
 * JD-Core Version:    0.7.0.1
 */