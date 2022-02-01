package com.tencent.mobileqq.filemanageraux.core;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.api.IFMConfig;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.core.ControlerCallback;
import com.tencent.mobileqq.qroute.QRoute;

class DiscOfflinePreviewController$1
  extends FMObserver
{
  DiscOfflinePreviewController$1(DiscOfflinePreviewController paramDiscOfflinePreviewController) {}
  
  protected void a(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, String paramString6, Bundle paramBundle)
  {
    paramString6 = paramString4;
    try
    {
      if (((IFMConfig)QRoute.api(IFMConfig.class)).getUserHarCodeIp())
      {
        paramString6 = "183.61.37.13";
        str1 = "443";
        break label316;
      }
      if ((paramString6 == null) || (paramString4.length() <= 0) || (paramString6.equalsIgnoreCase("0.0.0.0"))) {
        break label319;
      }
      paramString4 = paramString6;
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
        continue;
        paramString4 = paramString5;
      }
    }
    str1 = String.valueOf(paramInt2);
    paramString6 = paramString4;
    break label316;
    paramString5 = null;
    paramString4 = paramString5;
    if (((IFMConfig)QRoute.api(IFMConfig.class)).isEnableHttpsDownload4Disc(this.a.c))
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
    str2 = paramString4;
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getString("IPv6Dns", "");
      paramString5 = paramString4;
      if (paramString4 == null) {
        paramString5 = new Bundle();
      }
      str2 = paramString5;
      if (!TextUtils.isEmpty(paramBundle))
      {
        paramString5.putString("ipv6domain", paramBundle);
        str2 = paramString5;
      }
    }
    if (this.a.a != null) {
      this.a.a.a(paramBoolean, paramString6, str1, paramInt1, paramString1, paramString3, paramString2, this.a.d, str2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.core.DiscOfflinePreviewController.1
 * JD-Core Version:    0.7.0.1
 */