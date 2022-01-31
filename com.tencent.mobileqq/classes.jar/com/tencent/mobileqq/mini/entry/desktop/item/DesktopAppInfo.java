package com.tencent.mobileqq.mini.entry.desktop.item;

import com.tencent.mobileqq.mini.apkg.MiniAppInfo;

public class DesktopAppInfo
  extends DesktopItemInfo
{
  public int fromBackup;
  private boolean fromCache;
  public MiniAppInfo mMiniAppInfo;
  
  public DesktopAppInfo(int paramInt, MiniAppInfo paramMiniAppInfo)
  {
    this.mModuleType = paramInt;
    this.mMiniAppInfo = paramMiniAppInfo;
    if (this.mModuleType == 1)
    {
      this.dragEnable = true;
      this.dropEnable = false;
      this.deleteEnable = true;
    }
    do
    {
      return;
      if (this.mModuleType == 2)
      {
        this.dragEnable = true;
        this.dropEnable = false;
        this.deleteEnable = false;
        return;
      }
    } while (this.mModuleType != 3);
    this.dragEnable = true;
    this.dropEnable = true;
    this.deleteEnable = true;
  }
  
  public boolean isFromCache()
  {
    return this.fromCache;
  }
  
  public void setFromCache(boolean paramBoolean)
  {
    this.fromCache = paramBoolean;
  }
  
  public String toString()
  {
    if (this.mMiniAppInfo != null) {
      return this.mMiniAppInfo.name + "_" + this.mModuleType;
    }
    return " ";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppInfo
 * JD-Core Version:    0.7.0.1
 */