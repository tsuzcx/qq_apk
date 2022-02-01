package com.tencent.mobileqq.microapp.apkg;

import Wallet.ApkgConfig;
import aldt;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.microapp.a.c;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Map;

public class g
{
  public static final String a = BaseApplicationImpl.getApplication().getFilesDir().getPath() + "/miniapp/";
  private static volatile g b;
  private String c;
  private String d;
  private String e;
  private String f;
  
  public static g a()
  {
    if (b == null) {}
    try
    {
      if (b == null) {
        b = new g();
      }
      return b;
    }
    finally {}
  }
  
  public static String a(ApkgConfig paramApkgConfig)
  {
    if ((paramApkgConfig == null) || (TextUtils.isEmpty(paramApkgConfig.mini_appid))) {
      return "";
    }
    if (paramApkgConfig.getRuntimeType() == 1) {
      return a + paramApkgConfig.mini_appid + "_debug" + MD5.toMD5(paramApkgConfig.qq_qr_code);
    }
    return a + MD5.toMD5(paramApkgConfig.mini_appid) + "_" + paramApkgConfig.mini_version;
  }
  
  public void a(c paramc, String paramString, g.a parama)
  {
    String str2 = paramc.d(paramString);
    String str1 = "";
    if (paramc.f.config.sub_apkg_urls != null) {
      str1 = (String)paramc.f.config.sub_apkg_urls.get(str2);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ApkgManager", 1, "downloadSubPack | downPage=" + paramString + "subPackDownloadUrl=" + str1);
    }
    if (!TextUtils.isEmpty(str1))
    {
      aldt.a(BaseApplicationImpl.getApplication().getRuntime()).c(str1, new h(this, paramc, str2, parama));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.apkg.g
 * JD-Core Version:    0.7.0.1
 */