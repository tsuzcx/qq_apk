package com.tencent.qqmini.sdk.entry;

import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

public class MiniAppExposureManager$MiniAppExposureData
  implements MiniAppExposureManager.BaseExposureReport
{
  private MiniAppInfo appConfig;
  private int position;
  private String reserves2;
  
  public MiniAppExposureManager$MiniAppExposureData(MiniAppInfo paramMiniAppInfo, int paramInt)
  {
    this.appConfig = paramMiniAppInfo;
    this.position = paramInt;
  }
  
  public MiniAppExposureManager$MiniAppExposureData(MiniAppInfo paramMiniAppInfo, int paramInt, String paramString)
  {
    this.appConfig = paramMiniAppInfo;
    this.position = paramInt;
    this.reserves2 = paramString;
  }
  
  public MiniAppInfo getMiniAppConfig()
  {
    return this.appConfig;
  }
  
  public int getPosition()
  {
    return this.position;
  }
  
  public String getReserves2()
  {
    return this.reserves2;
  }
  
  public void report() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.entry.MiniAppExposureManager.MiniAppExposureData
 * JD-Core Version:    0.7.0.1
 */