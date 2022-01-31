package com.tencent.mobileqq.mini.entry;

import com.tencent.mobileqq.mini.apkg.MiniAppConfig;

public class MiniAppExposureManager$MiniAppExposureData
  extends MiniAppExposureManager.BaseExposureReport
{
  private MiniAppConfig appConfig;
  private int position;
  private String reserves2;
  
  public MiniAppExposureManager$MiniAppExposureData(MiniAppConfig paramMiniAppConfig, int paramInt)
  {
    this.appConfig = paramMiniAppConfig;
    this.position = paramInt;
  }
  
  public MiniAppExposureManager$MiniAppExposureData(MiniAppConfig paramMiniAppConfig, int paramInt, String paramString)
  {
    this.appConfig = paramMiniAppConfig;
    this.position = paramInt;
    this.reserves2 = paramString;
  }
  
  public MiniAppConfig getMiniAppConfig()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppExposureManager.MiniAppExposureData
 * JD-Core Version:    0.7.0.1
 */