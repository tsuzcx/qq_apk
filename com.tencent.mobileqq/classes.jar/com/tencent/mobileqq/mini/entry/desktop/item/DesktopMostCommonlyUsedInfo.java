package com.tencent.mobileqq.mini.entry.desktop.item;

import NS_MINI_INTERFACE.INTERFACE.StModuleInfo;
import NS_MINI_INTERFACE.INTERFACE.StUserAppInfo;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public class DesktopMostCommonlyUsedInfo
  extends DesktopItemInfo
{
  public MiniAppInfo appInfo = null;
  public INTERFACE.StModuleInfo moduleInfo = null;
  
  public DesktopMostCommonlyUsedInfo(int paramInt, INTERFACE.StModuleInfo paramStModuleInfo)
  {
    if ((paramStModuleInfo != null) && (paramStModuleInfo.userAppList != null))
    {
      if (paramStModuleInfo.userAppList.isEmpty()) {
        return;
      }
      this.mModuleType = paramInt;
      this.moduleInfo = paramStModuleInfo;
      this.appInfo = MiniAppInfo.from((INTERFACE.StUserAppInfo)paramStModuleInfo.userAppList.get(0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.item.DesktopMostCommonlyUsedInfo
 * JD-Core Version:    0.7.0.1
 */