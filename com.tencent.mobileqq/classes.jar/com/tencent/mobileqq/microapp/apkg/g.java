package com.tencent.mobileqq.microapp.apkg;

import Wallet.ApkgConfig;
import ahbw;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.qwallet.preload.DownloadParam;
import com.tencent.mobileqq.microapp.b.a;
import com.tencent.mobileqq.microapp.c.c;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.utils.FileUtil;
import cooperation.qwallet.plugin.QWalletHelper;
import java.io.File;
import java.net.URLEncoder;
import java.util.LinkedList;
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
  
  public static String a(File paramFile, String paramString)
  {
    return QWalletHelper.desDecrypt(a.a(paramFile), paramString, paramString);
  }
  
  private void a(MiniAppConfig paramMiniAppConfig, g.c paramc)
  {
    if ((paramMiniAppConfig == null) || (paramMiniAppConfig.config == null)) {}
    String str;
    Object localObject;
    label203:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            str = paramMiniAppConfig.config.apkg_url;
            long l = paramMiniAppConfig.config.mini_version;
            if (QLog.isColorLevel()) {
              QLog.d("ApkgManager", 2, "getApkgInfoByConfig version:" + l);
            }
            if (l != -1L) {
              break label203;
            }
            str = a(paramMiniAppConfig.config);
            if (!new File(str).exists()) {
              break;
            }
            paramMiniAppConfig = f.a(str, paramMiniAppConfig);
          } while (paramc == null);
          paramc.a(paramMiniAppConfig);
          return;
          localObject = c.a(paramMiniAppConfig.config.mini_appid + ".wxapkg");
          boolean bool = false;
          if (localObject != null)
          {
            bool = c.a(((File)localObject).getAbsolutePath(), str);
            FileUtil.delete((File)localObject);
          }
          if (!bool) {
            break;
          }
          paramMiniAppConfig = f.a(str, paramMiniAppConfig);
        } while (paramc == null);
        paramc.a(paramMiniAppConfig);
        return;
      } while (paramc == null);
      paramc.a(null);
      return;
      localObject = a(paramMiniAppConfig.config);
      if (!new File((String)localObject).exists()) {
        break;
      }
      paramMiniAppConfig = f.a((String)localObject, paramMiniAppConfig);
    } while (paramc == null);
    paramc.a(paramMiniAppConfig);
    return;
    ahbw localahbw = ahbw.a(BaseApplicationImpl.getApplication().getRuntime());
    DownloadParam localDownloadParam = new DownloadParam();
    localDownloadParam.headers = new LinkedList();
    localDownloadParam.url = (str + "?sign=" + URLEncoder.encode(paramMiniAppConfig.config.cos_sign));
    if (QLog.isColorLevel()) {
      QLog.d("ApkgManager", 2, "begin download apkg:" + localDownloadParam);
    }
    localahbw.a(localDownloadParam, new l(this, (String)localObject, paramMiniAppConfig, paramc));
  }
  
  private void a(g.d paramd, int paramInt, f paramf, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApkgManager", 2, "onInitApkgInfo :" + paramInt + "|" + paramString);
    }
    if (paramd != null) {
      paramd.onInitApkgInfo(paramInt, paramf);
    }
  }
  
  private void b(MiniAppConfig paramMiniAppConfig, g.d paramd)
  {
    a(paramMiniAppConfig, new k(this, paramd, System.currentTimeMillis()));
  }
  
  public void a(MiniAppConfig paramMiniAppConfig, g.d paramd)
  {
    if (!f())
    {
      g.b localb = new g.b();
      h localh = new h(this, 1, paramMiniAppConfig);
      paramMiniAppConfig = new j(this, 2, paramMiniAppConfig);
      localb.a(localh);
      localb.a(paramMiniAppConfig);
      localb.a(paramd);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ApkgManager", 2, "initApkgByConfig - base lib is ready");
    }
    b(paramMiniAppConfig, paramd);
  }
  
  public void a(f paramf, String paramString, g.d paramd)
  {
    String str2 = paramf.d(paramString);
    String str1 = "";
    if (paramf.f.config.sub_apkg_urls != null) {
      str1 = (String)paramf.f.config.sub_apkg_urls.get(str2);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ApkgManager", 1, "downloadSubPack | downPage=" + paramString + "subPackDownloadUrl=" + str1);
    }
    if (!TextUtils.isEmpty(str1))
    {
      ahbw.a(BaseApplicationImpl.getApplication().getRuntime()).c(str1, new m(this, paramf, str2, paramd));
      return;
    }
    paramd.onInitApkgInfo(1, null);
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
      this.f = a.a(BaseApplicationImpl.getApplication(), "qvip_pay_miniapp_page_frame.html");
    }
    return this.f;
  }
  
  public boolean f()
  {
    return (!TextUtils.isEmpty(this.d)) && (!TextUtils.isEmpty(this.c)) && (!TextUtils.isEmpty(this.e));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.apkg.g
 * JD-Core Version:    0.7.0.1
 */