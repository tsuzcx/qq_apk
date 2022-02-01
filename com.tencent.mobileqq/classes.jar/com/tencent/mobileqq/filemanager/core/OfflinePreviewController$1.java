package com.tencent.mobileqq.filemanager.core;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.api.IFMConfig;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

class OfflinePreviewController$1
  extends FMObserver
{
  OfflinePreviewController$1(OfflinePreviewController paramOfflinePreviewController) {}
  
  protected void b(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, String paramString6, Bundle paramBundle)
  {
    try
    {
      if (((IFMConfig)QRoute.api(IFMConfig.class)).getUserHarCodeIp())
      {
        paramString6 = "183.61.37.13";
        str1 = "443";
        break label307;
      }
      if ((paramString4 == null) || (paramString4.length() <= 0)) {
        break label310;
      }
    }
    finally
    {
      for (;;)
      {
        String str1;
        String str2;
        short s2;
        short s1;
        for (;;)
        {
          throw paramString1;
        }
        label307:
        continue;
        label310:
        paramString4 = paramString5;
      }
    }
    str1 = String.valueOf(paramInt2);
    paramString6 = paramString4;
    break label307;
    paramString5 = null;
    paramString4 = paramString5;
    if (((IFMConfig)QRoute.api(IFMConfig.class)).isEnableHttpsDownload4C2C(this.a.b))
    {
      paramString4 = paramString5;
      if (paramBundle != null)
      {
        str2 = paramBundle.getString("strHttpsDomain");
        s2 = paramBundle.getShort("httpsPort", (short)0);
        paramString4 = paramString5;
        if (!TextUtils.isEmpty(str2))
        {
          s1 = s2;
          if (s2 == 0) {
            s1 = 443;
          }
          paramString4 = new Bundle();
          paramString4.putBoolean("ishttps", true);
          paramString4.putString("httpsdomain", str2);
          paramString4.putShort("httpsport", s1);
        }
      }
    }
    paramString5 = paramString4;
    if (QFileUtils.a())
    {
      paramString5 = paramString4;
      if (paramBundle != null)
      {
        paramBundle = paramBundle.getString("IPv6Dns");
        paramString5 = paramString4;
        if (paramString4 == null) {
          paramString5 = new Bundle();
        }
        paramString5.putString("ipv6domain", paramBundle);
      }
    }
    if (this.a.a != null) {
      this.a.a.a(paramBoolean, paramString6, str1, paramInt1, paramString1, paramString3, paramString2, this.a.c, paramString5);
    } else if (QLog.isColorLevel()) {
      QLog.e("OfflinePreviewController<FileAssistant>", 2, " callback is null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.OfflinePreviewController.1
 * JD-Core Version:    0.7.0.1
 */