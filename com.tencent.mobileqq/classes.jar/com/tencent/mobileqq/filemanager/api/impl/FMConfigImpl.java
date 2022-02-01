package com.tencent.mobileqq.filemanager.api.impl;

import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.filemanager.api.IFMConfig;
import com.tencent.mobileqq.filemanager.data.FMConfig;

public class FMConfigImpl
  implements IFMConfig
{
  public String getConfigValue(Context paramContext, String paramString)
  {
    return FMConfig.a(paramContext, paramString);
  }
  
  public String getConfigValue(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    return FMConfig.a(paramContext, paramString1, paramString2, paramString3);
  }
  
  public long getFlowDialogSize()
  {
    return FMConfig.c();
  }
  
  public long getFlowDialogTime()
  {
    return FMConfig.d();
  }
  
  public long getMaxCreateThumbFileSize()
  {
    return FMConfig.f();
  }
  
  public String getPreviewConfig(Context paramContext, String paramString1, String paramString2)
  {
    return FMConfig.a(paramContext, paramString1, paramString2);
  }
  
  public String getTAG()
  {
    return "FMConfig<FileAssistant>";
  }
  
  public boolean getUserFtnSpeedTest()
  {
    return FMConfig.b();
  }
  
  public boolean getUserHarCodeIp()
  {
    return FMConfig.a();
  }
  
  public boolean isEnableHttpsDownload4C2C(BaseQQAppInterface paramBaseQQAppInterface)
  {
    return FMConfig.b(paramBaseQQAppInterface);
  }
  
  public boolean isEnableHttpsDownload4C2C_ZipInner(BaseQQAppInterface paramBaseQQAppInterface)
  {
    return FMConfig.c(paramBaseQQAppInterface);
  }
  
  public boolean isEnableHttpsDownload4Disc(BaseQQAppInterface paramBaseQQAppInterface)
  {
    return FMConfig.f(paramBaseQQAppInterface);
  }
  
  public boolean isEnableHttpsDownload4Disc_ZipInner(BaseQQAppInterface paramBaseQQAppInterface)
  {
    return FMConfig.g(paramBaseQQAppInterface);
  }
  
  public boolean isEnableHttpsThumb4C2C(BaseQQAppInterface paramBaseQQAppInterface)
  {
    return FMConfig.d(paramBaseQQAppInterface);
  }
  
  public boolean isEnableHttpsThumb4Disc(BaseQQAppInterface paramBaseQQAppInterface)
  {
    return FMConfig.h(paramBaseQQAppInterface);
  }
  
  public boolean isEnableHttpsUpload4C2C(BaseQQAppInterface paramBaseQQAppInterface)
  {
    return FMConfig.a(paramBaseQQAppInterface);
  }
  
  public boolean isEnableHttpsUpload4Disc(BaseQQAppInterface paramBaseQQAppInterface)
  {
    return FMConfig.e(paramBaseQQAppInterface);
  }
  
  public boolean preDownloadThumb()
  {
    return FMConfig.e();
  }
  
  public void setEnableHttpsDownload4C2C(BaseQQAppInterface paramBaseQQAppInterface, boolean paramBoolean)
  {
    FMConfig.b(paramBaseQQAppInterface, paramBoolean);
  }
  
  public void setEnableHttpsDownload4C2C_ZipInner(BaseQQAppInterface paramBaseQQAppInterface, boolean paramBoolean)
  {
    FMConfig.c(paramBaseQQAppInterface, paramBoolean);
  }
  
  public void setEnableHttpsDownload4Disc(BaseQQAppInterface paramBaseQQAppInterface, boolean paramBoolean)
  {
    FMConfig.f(paramBaseQQAppInterface, paramBoolean);
  }
  
  public void setEnableHttpsDownload4Disc_ZipInner(BaseQQAppInterface paramBaseQQAppInterface, boolean paramBoolean)
  {
    FMConfig.g(paramBaseQQAppInterface, paramBoolean);
  }
  
  public void setEnableHttpsThumb4C2C(BaseQQAppInterface paramBaseQQAppInterface, boolean paramBoolean)
  {
    FMConfig.d(paramBaseQQAppInterface, paramBoolean);
  }
  
  public void setEnableHttpsThumb4Disc(BaseQQAppInterface paramBaseQQAppInterface, boolean paramBoolean)
  {
    FMConfig.h(paramBaseQQAppInterface, paramBoolean);
  }
  
  public void setEnableHttpsUpload4C2C(BaseQQAppInterface paramBaseQQAppInterface, boolean paramBoolean)
  {
    FMConfig.a(paramBaseQQAppInterface, paramBoolean);
  }
  
  public void setEnableHttpsUpload4Disc(BaseQQAppInterface paramBaseQQAppInterface, boolean paramBoolean)
  {
    FMConfig.e(paramBaseQQAppInterface, paramBoolean);
  }
  
  public int timAIOGaryTipsCount()
  {
    return FMConfig.g();
  }
  
  public String timGuideUrl()
  {
    return FMConfig.h();
  }
  
  public void updatePreviewList(BaseQQAppInterface paramBaseQQAppInterface, String paramString, long paramLong)
  {
    FMConfig.a(paramBaseQQAppInterface, paramString, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.api.impl.FMConfigImpl
 * JD-Core Version:    0.7.0.1
 */