package com.tencent.mobileqq.mini.entry.desktop;

import com.tencent.mobileqq.mini.apkg.MiniAppInfo;

public class DesktopAdData
{
  public boolean hasReport;
  public MiniAppInfo miniAppInfo;
  public int position;
  
  public DesktopAdData(int paramInt, boolean paramBoolean, MiniAppInfo paramMiniAppInfo)
  {
    this.position = paramInt;
    this.hasReport = paramBoolean;
    this.miniAppInfo = paramMiniAppInfo;
  }
  
  public boolean hasReport()
  {
    return this.hasReport;
  }
  
  public void setHasReport(boolean paramBoolean)
  {
    this.hasReport = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.DesktopAdData
 * JD-Core Version:    0.7.0.1
 */