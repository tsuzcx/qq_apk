package com.tencent.mobileqq.wxmini.impl.loader;

import android.text.TextUtils;
import com.tencent.luggage.wxaapi.InitDynamicPkgResult;
import com.tencent.luggage.wxaapi.WxaApi;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.wxmini.impl.WxMiniAppDownloadUtil;
import com.tencent.mobileqq.wxmini.impl.WxMiniSDKImpl;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.io.File;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class WxDFLoader
{
  private static volatile WxDFLoader a;
  private volatile boolean b = false;
  
  public static WxDFLoader a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new WxDFLoader();
        }
      }
      finally {}
    }
    return a;
  }
  
  private void a(String paramString)
  {
    paramString = QzoneConfig.getInstance().getConfig("qqminiapp", "wx_mini_app_df_url", "{ \"url\":\"https://down.qq.com/miniapp/wxminiapp/wxa_dynamic_pkg_release_armeabi-v7a_1.5.1_ex.zip\",\"size\":32980126 }");
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("wxmini.WxDFLoader", 1, "downloadDF fail, dfUrl is null");
      return;
    }
    QLog.e("wxmini.WxDFLoader", 1, "downloadDF start");
    try
    {
      paramString = new JSONObject(paramString);
      String str = paramString.optString("url");
      paramString.optLong("size", 0L);
      WxMiniAppDownloadUtil.a().a(str, e(), 60, new WxDFLoader.3(this));
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("wxmini.WxDFLoader", 1, "downloadDF failed", paramString);
    }
  }
  
  private static String e()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(VFSAssistantUtils.getSDKPrivatePath("Tencent/wxminiapp/"));
    localStringBuilder.append("df/");
    localStringBuilder.append("wxa_dynamic_pkg_release_armeabi-v7a.zip");
    return localStringBuilder.toString();
  }
  
  private boolean f()
  {
    QLog.e("wxmini.WxDFLoader", 1, "checkWxDF ");
    Object localObject = QzoneConfig.getInstance().getConfig("qqminiapp", "wx_mini_app_df_url", "{ \"url\":\"https://down.qq.com/miniapp/wxminiapp/wxa_dynamic_pkg_release_armeabi-v7a_1.5.1_ex.zip\",\"size\":32980126 }");
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return false;
    }
    try
    {
      localObject = new JSONObject((String)localObject);
      ((JSONObject)localObject).optString("url");
      long l = ((JSONObject)localObject).optLong("size", 0L);
      localObject = new File(e());
      if ((((File)localObject).exists()) && (((File)localObject).length() == l))
      {
        QLog.e("wxmini.WxDFLoader", 1, "checkWxDF success.");
        return true;
      }
      return false;
    }
    catch (Exception localException)
    {
      QLog.e("wxmini.WxDFLoader", 1, "checkWxDF failed", localException);
    }
    return false;
  }
  
  public boolean b()
  {
    boolean bool2 = this.b;
    boolean bool1 = true;
    if (bool2) {
      return true;
    }
    if (f())
    {
      if (WxMiniSDKImpl.a.c().initDynamicPkg(e()) != InitDynamicPkgResult.OK) {
        bool1 = false;
      }
      this.b = bool1;
      return this.b;
    }
    ThreadManager.getSubThreadHandler().post(new WxDFLoader.1(this));
    return false;
  }
  
  public void c()
  {
    if (!f())
    {
      QLog.i("wxmini.WxDFLoader", 1, "df file not exist, need pre download");
      ThreadManager.getSubThreadHandler().post(new WxDFLoader.2(this));
      return;
    }
    QLog.i("wxmini.WxDFLoader", 1, "df file exist, not need predownload");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.wxmini.impl.loader.WxDFLoader
 * JD-Core Version:    0.7.0.1
 */