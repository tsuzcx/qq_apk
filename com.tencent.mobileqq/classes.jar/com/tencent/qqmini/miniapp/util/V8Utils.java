package com.tencent.qqmini.miniapp.util;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.ipc.AppBrandCmdProxy;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.io.File;
import org.json.JSONObject;

public class V8Utils
{
  public static final String TAG = "V8Utils";
  
  public static boolean checkEnableV8()
  {
    int i = WnsConfig.getConfig("qqminiapp", "mini_app_enable_v8_service", 1);
    if (i > 0)
    {
      localObject = WnsConfig.getConfig("qqminiapp", "mini_app_v8_rt_url", "{ \"url\":\"https://down.qq.com/miniapp/libtv8rt_202008101130.so\",\"size\":535136, \"url64\":\"https://d3g.qq.com/sngapp/app/update/20210601154157_4983/VD1Vg6kzck5I0UmQ6W6dPA==_libtv8rt.so\",\"size64\":1733496}");
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        QMLog.e("V8Utils", "mini_app_v8_rt_url is null");
        return false;
      }
      localObject = parserUrlJson((String)localObject);
      if ((!TextUtils.isEmpty(((V8Utils.V8UrlInfo)localObject).a)) && (((V8Utils.V8UrlInfo)localObject).b != 0))
      {
        if (v8rtValid(((V8Utils.V8UrlInfo)localObject).b)) {
          return true;
        }
        AppBrandCmdProxy.g().sendCmd("cmd_update_v8rt", new Bundle(), new V8Utils.1());
        return false;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("url is");
      localStringBuilder.append(((V8Utils.V8UrlInfo)localObject).a);
      localStringBuilder.append("  size:");
      localStringBuilder.append(((V8Utils.V8UrlInfo)localObject).b);
      QMLog.e("V8Utils", localStringBuilder.toString());
      return false;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("mini_app_enable_v8_service is ");
    ((StringBuilder)localObject).append(i);
    QMLog.e("V8Utils", ((StringBuilder)localObject).toString());
    return false;
  }
  
  private static V8Utils.V8UrlInfo parserUrlJson(String paramString)
  {
    V8Utils.V8UrlInfo localV8UrlInfo = new V8Utils.V8UrlInfo(null);
    try
    {
      paramString = new JSONObject(paramString);
      boolean bool = SoUtil.a();
      if (bool)
      {
        localV8UrlInfo.a = paramString.optString("url64", "");
        localV8UrlInfo.b = paramString.optInt("size64", 0);
        return localV8UrlInfo;
      }
      localV8UrlInfo.a = paramString.optString("url", "");
      localV8UrlInfo.b = paramString.optInt("size", 0);
      return localV8UrlInfo;
    }
    catch (Exception paramString)
    {
      QMLog.e("V8Utils", "parse v8rt_url failed", paramString);
    }
    return localV8UrlInfo;
  }
  
  private static boolean v8rtValid(int paramInt)
  {
    File localFile = new File(MiniSDKConst.getMiniAppV8rtPath());
    if ((localFile.exists()) && (localFile.length() == paramInt)) {
      return true;
    }
    localFile.delete();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.util.V8Utils
 * JD-Core Version:    0.7.0.1
 */