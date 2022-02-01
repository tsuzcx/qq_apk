package com.tencent.mobileqq.mini.entry.desktop.item;

import NS_MINI_INTERFACE.INTERFACE.StUserAppInfo;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.qphone.base.util.QLog;

public class DesktopAppModuleInfo
  extends DesktopItemInfo
{
  private static final String TAG = "DesktopAppModuleInfo";
  public MiniAppInfo appStoreInfo;
  public String moduleTitle;
  
  public DesktopAppModuleInfo(int paramInt)
  {
    this.mModuleType = paramInt;
  }
  
  public DesktopAppModuleInfo(int paramInt, String paramString)
  {
    this.mModuleType = paramInt;
    this.moduleTitle = paramString;
  }
  
  public DesktopAppModuleInfo(int paramInt, String paramString, INTERFACE.StUserAppInfo paramStUserAppInfo)
  {
    this.mModuleType = paramInt;
    this.moduleTitle = paramString;
    if (paramStUserAppInfo != null)
    {
      this.appStoreInfo = MiniAppInfo.from(paramStUserAppInfo);
      if (this.appStoreInfo != null)
      {
        paramStUserAppInfo = new StringBuilder();
        paramStUserAppInfo.append("create DesktopAppModuleInfo. appStoreInfo: id = ");
        paramStUserAppInfo.append(this.appStoreInfo.appId);
        paramStUserAppInfo.append(", name = ");
        paramStUserAppInfo.append(this.appStoreInfo.name);
        paramStUserAppInfo.append(", title: ");
        paramStUserAppInfo.append(paramString);
        QLog.d("DesktopAppModuleInfo", 1, paramStUserAppInfo.toString());
        return;
      }
      paramStUserAppInfo = new StringBuilder();
      paramStUserAppInfo.append("create DesktopAppModuleInfo. appStoreInfo is null. title: ");
      paramStUserAppInfo.append(paramString);
      QLog.d("DesktopAppModuleInfo", 1, paramStUserAppInfo.toString());
      return;
    }
    paramStUserAppInfo = new StringBuilder();
    paramStUserAppInfo.append("create DesktopAppModuleInfo. appInfo is null. title: ");
    paramStUserAppInfo.append(paramString);
    QLog.d("DesktopAppModuleInfo", 1, paramStUserAppInfo.toString());
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.moduleTitle);
    localStringBuilder.append("_");
    localStringBuilder.append(this.mModuleType);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppModuleInfo
 * JD-Core Version:    0.7.0.1
 */