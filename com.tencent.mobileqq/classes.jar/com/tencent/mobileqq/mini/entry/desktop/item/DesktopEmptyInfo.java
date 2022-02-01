package com.tencent.mobileqq.mini.entry.desktop.item;

import com.tencent.mobileqq.mini.apkg.MiniAppInfo;

public class DesktopEmptyInfo
  extends DesktopItemInfo
{
  public MiniAppInfo mMiniAppInfo;
  
  public DesktopEmptyInfo(int paramInt, MiniAppInfo paramMiniAppInfo)
  {
    this.dragEnable = false;
    this.dropEnable = true;
    this.deleteEnable = false;
    this.mModuleType = paramInt;
    this.mMiniAppInfo = paramMiniAppInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.item.DesktopEmptyInfo
 * JD-Core Version:    0.7.0.1
 */