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
        QLog.d("DesktopAppModuleInfo", 1, "create DesktopAppModuleInfo. appStoreInfo: id = " + this.appStoreInfo.appId + ", name = " + this.appStoreInfo.name + ", title: " + paramString);
        return;
      }
      QLog.d("DesktopAppModuleInfo", 1, "create DesktopAppModuleInfo. appStoreInfo is null. title: " + paramString);
      return;
    }
    QLog.d("DesktopAppModuleInfo", 1, "create DesktopAppModuleInfo. appInfo is null. title: " + paramString);
  }
  
  public String toString()
  {
    return this.moduleTitle + "_" + this.mModuleType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppModuleInfo
 * JD-Core Version:    0.7.0.1
 */