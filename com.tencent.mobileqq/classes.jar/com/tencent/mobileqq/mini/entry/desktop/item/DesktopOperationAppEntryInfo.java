package com.tencent.mobileqq.mini.entry.desktop.item;

import NS_MINI_INTERFACE.INTERFACE.StOperationApp;
import NS_MINI_INTERFACE.INTERFACE.StUserAppInfo;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.pb.PBStringField;

public class DesktopOperationAppEntryInfo
{
  private String mIcon;
  private MiniAppInfo mMiniAppInfo;
  private String mName;
  private String mNightIcon;
  
  public String getIcon()
  {
    return this.mIcon;
  }
  
  public MiniAppInfo getMiniAppInfo()
  {
    return this.mMiniAppInfo;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public String getNightIcon()
  {
    return this.mNightIcon;
  }
  
  public void mergePbData(@NonNull INTERFACE.StOperationApp paramStOperationApp)
  {
    if (paramStOperationApp != null)
    {
      this.mMiniAppInfo = MiniAppInfo.from((INTERFACE.StUserAppInfo)paramStOperationApp.app.get());
      this.mName = paramStOperationApp.name.get();
      this.mIcon = paramStOperationApp.icon.get();
      this.mNightIcon = paramStOperationApp.nightIcon.get();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.item.DesktopOperationAppEntryInfo
 * JD-Core Version:    0.7.0.1
 */