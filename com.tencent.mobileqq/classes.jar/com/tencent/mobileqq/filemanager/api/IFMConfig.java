package com.tencent.mobileqq.filemanager.api;

import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IFMConfig
  extends QRouteApi
{
  public abstract String getConfigValue(Context paramContext, String paramString);
  
  public abstract String getConfigValue(Context paramContext, String paramString1, String paramString2, String paramString3);
  
  public abstract long getFlowDialogSize();
  
  public abstract long getFlowDialogTime();
  
  public abstract long getMaxCreateThumbFileSize();
  
  public abstract String getPreviewConfig(Context paramContext, String paramString1, String paramString2);
  
  public abstract String getTAG();
  
  public abstract boolean getUserFtnSpeedTest();
  
  public abstract boolean getUserHarCodeIp();
  
  public abstract boolean isEnableHttpsDownload4C2C(BaseQQAppInterface paramBaseQQAppInterface);
  
  public abstract boolean isEnableHttpsDownload4C2C_ZipInner(BaseQQAppInterface paramBaseQQAppInterface);
  
  public abstract boolean isEnableHttpsDownload4Disc(BaseQQAppInterface paramBaseQQAppInterface);
  
  public abstract boolean isEnableHttpsDownload4Disc_ZipInner(BaseQQAppInterface paramBaseQQAppInterface);
  
  public abstract boolean isEnableHttpsThumb4C2C(BaseQQAppInterface paramBaseQQAppInterface);
  
  public abstract boolean isEnableHttpsThumb4Disc(BaseQQAppInterface paramBaseQQAppInterface);
  
  public abstract boolean isEnableHttpsUpload4C2C(BaseQQAppInterface paramBaseQQAppInterface);
  
  public abstract boolean isEnableHttpsUpload4Disc(BaseQQAppInterface paramBaseQQAppInterface);
  
  public abstract boolean preDownloadThumb();
  
  public abstract void setEnableHttpsDownload4C2C(BaseQQAppInterface paramBaseQQAppInterface, boolean paramBoolean);
  
  public abstract void setEnableHttpsDownload4C2C_ZipInner(BaseQQAppInterface paramBaseQQAppInterface, boolean paramBoolean);
  
  public abstract void setEnableHttpsDownload4Disc(BaseQQAppInterface paramBaseQQAppInterface, boolean paramBoolean);
  
  public abstract void setEnableHttpsDownload4Disc_ZipInner(BaseQQAppInterface paramBaseQQAppInterface, boolean paramBoolean);
  
  public abstract void setEnableHttpsThumb4C2C(BaseQQAppInterface paramBaseQQAppInterface, boolean paramBoolean);
  
  public abstract void setEnableHttpsThumb4Disc(BaseQQAppInterface paramBaseQQAppInterface, boolean paramBoolean);
  
  public abstract void setEnableHttpsUpload4C2C(BaseQQAppInterface paramBaseQQAppInterface, boolean paramBoolean);
  
  public abstract void setEnableHttpsUpload4Disc(BaseQQAppInterface paramBaseQQAppInterface, boolean paramBoolean);
  
  public abstract int timAIOGaryTipsCount();
  
  public abstract String timGuideUrl();
  
  public abstract void updatePreviewList(BaseQQAppInterface paramBaseQQAppInterface, String paramString, long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.api.IFMConfig
 * JD-Core Version:    0.7.0.1
 */