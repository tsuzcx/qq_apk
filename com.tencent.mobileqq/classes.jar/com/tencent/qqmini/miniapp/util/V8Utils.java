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
      String str = WnsConfig.getConfig("qqminiapp", "mini_app_v8_rt_url", "{ \"url\":\"https://down.qq.com/miniapp/libtv8rt_202008101130.so\",\"size\":535136 }");
      if (TextUtils.isEmpty(str))
      {
        QMLog.e("V8Utils", "mini_app_v8_rt_url is null");
        return false;
      }
      try
      {
        Object localObject = new JSONObject(str);
        str = ((JSONObject)localObject).getString("url");
        i = ((JSONObject)localObject).getInt("size");
        if ((!TextUtils.isEmpty(str)) && (i != 0))
        {
          if (v8rtValid(i)) {
            return true;
          }
          AppBrandCmdProxy.g().sendCmd("cmd_update_v8rt", new Bundle(), new V8Utils.1());
          return false;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("url is");
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append("  size:");
        ((StringBuilder)localObject).append(i);
        QMLog.e("V8Utils", ((StringBuilder)localObject).toString());
        return false;
      }
      catch (Exception localException)
      {
        QMLog.e("V8Utils", "parse v8rt_url failed", localException);
        return false;
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mini_app_enable_v8_service is ");
    localStringBuilder.append(i);
    QMLog.e("V8Utils", localStringBuilder.toString());
    return false;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.util.V8Utils
 * JD-Core Version:    0.7.0.1
 */