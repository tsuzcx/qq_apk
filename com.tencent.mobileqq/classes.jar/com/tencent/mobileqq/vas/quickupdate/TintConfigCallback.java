package com.tencent.mobileqq.vas.quickupdate;

import com.tencent.mobileqq.vas.updatesystem.callback.QuickUpdateListener;

public class TintConfigCallback
  extends BaseUpdateCallback
{
  public static TintConfigCallback sInstance = new TintConfigCallback();
  private int mCallDownloadTimes = 0;
  
  public void downloadAtMostTwice(QuickUpdateListener paramQuickUpdateListener)
  {
    int i = this.mCallDownloadTimes;
    this.mCallDownloadTimes = (i + 1);
    if (i < 2) {
      download(0, paramQuickUpdateListener, false);
    }
  }
  
  public long getBID()
  {
    return 3L;
  }
  
  protected String getRootDir()
  {
    return "tintconfig";
  }
  
  public String getScid(int paramInt)
  {
    return getScidPrefix();
  }
  
  protected String getScidPrefix()
  {
    return "theme_mapping_config_android";
  }
  
  protected boolean isZip_KeepZip()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.quickupdate.TintConfigCallback
 * JD-Core Version:    0.7.0.1
 */