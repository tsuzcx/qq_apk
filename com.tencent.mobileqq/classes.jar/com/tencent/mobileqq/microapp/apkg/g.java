package com.tencent.mobileqq.microapp.apkg;

import Wallet.ApkgConfig;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManagerProxy;
import com.tencent.mobileqq.microapp.a.c;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Map;

public class g
{
  public static final String a;
  private static volatile g b;
  private String c;
  private String d;
  private String e;
  private String f;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(BaseApplicationImpl.getApplication().getFilesDir().getPath());
    localStringBuilder.append("/miniapp/");
    a = localStringBuilder.toString();
  }
  
  public static g a()
  {
    if (b == null) {
      try
      {
        if (b == null) {
          b = new g();
        }
      }
      finally {}
    }
    return b;
  }
  
  public static String a(ApkgConfig paramApkgConfig)
  {
    if ((paramApkgConfig != null) && (!TextUtils.isEmpty(paramApkgConfig.mini_appid)))
    {
      if (paramApkgConfig.getRuntimeType() == 1)
      {
        localStringBuilder = new StringBuilder(a);
        localStringBuilder.append(paramApkgConfig.mini_appid);
        localStringBuilder.append("_debug");
        localStringBuilder.append(MD5.toMD5(paramApkgConfig.qq_qr_code));
        return localStringBuilder.toString();
      }
      StringBuilder localStringBuilder = new StringBuilder(a);
      localStringBuilder.append(MD5.toMD5(paramApkgConfig.mini_appid));
      localStringBuilder.append("_");
      localStringBuilder.append(paramApkgConfig.mini_version);
      return localStringBuilder.toString();
    }
    return "";
  }
  
  public void a(c paramc, String paramString, g.a parama)
  {
    String str2 = paramc.d(paramString);
    String str1;
    if (paramc.f.config.sub_apkg_urls != null) {
      str1 = (String)paramc.f.config.sub_apkg_urls.get(str2);
    } else {
      str1 = "";
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("downloadSubPack | downPage=");
      localStringBuilder.append(paramString);
      localStringBuilder.append("subPackDownloadUrl=");
      localStringBuilder.append(str1);
      QLog.d("ApkgManager", 1, localStringBuilder.toString());
    }
    if (!TextUtils.isEmpty(str1))
    {
      PreloadManagerProxy.getInstance(BaseApplicationImpl.getApplication().getRuntime()).getResPath(str1, new h(this, paramc, str2, parama));
      return;
    }
    parama.onInitApkgInfo$76ec3a73(1, null);
  }
  
  public String b()
  {
    return this.c;
  }
  
  public String c()
  {
    return this.d;
  }
  
  public String d()
  {
    return this.e;
  }
  
  public String e()
  {
    if (this.f == null) {
      this.f = c.a(BaseApplicationImpl.getApplication(), "qvip_pay_miniapp_page_frame.html");
    }
    return this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.apkg.g
 * JD-Core Version:    0.7.0.1
 */