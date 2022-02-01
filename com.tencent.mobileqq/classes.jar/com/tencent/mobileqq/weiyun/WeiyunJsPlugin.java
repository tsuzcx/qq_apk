package com.tencent.mobileqq.weiyun;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.mobileqq.webview.swift.IPreCreatePluginChecker;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.weiyun.utils.WeiyunPathUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.util.URLUtil;
import java.util.ArrayList;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONObject;

public class WeiyunJsPlugin
  extends WebViewPlugin
  implements IPreCreatePluginChecker
{
  public WeiyunJsPlugin()
  {
    this.mPluginNameSpace = "Weiyun";
  }
  
  public static boolean a(String paramString)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = Uri.parse(paramString);
        localObject = paramString.getScheme();
        if ((!"http".equalsIgnoreCase((String)localObject)) && (!"https".equalsIgnoreCase((String)localObject)))
        {
          Log.e("WeiyunJsPlugin", "Weiyun urlString is not url!");
          return false;
        }
        paramString = paramString.getHost();
        if (!TextUtils.isEmpty(paramString)) {
          if (!paramString.contains("share.weiyun.com"))
          {
            boolean bool = paramString.contains("h5.weiyun.com");
            if (!bool) {}
          }
          else
          {
            return true;
          }
        }
      }
    }
    catch (Exception paramString)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Weiyun exception: ");
      ((StringBuilder)localObject).append(paramString);
      Log.e("WeiyunJsPlugin", ((StringBuilder)localObject).toString());
    }
    return false;
  }
  
  public WeiYunFileInfo a(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong)
  {
    WeiYunFileInfo localWeiYunFileInfo = new WeiYunFileInfo();
    localWeiYunFileInfo.a = paramString4;
    localWeiYunFileInfo.c = paramString3;
    localWeiYunFileInfo.d = paramLong;
    localWeiYunFileInfo.j = "FTN5K";
    localWeiYunFileInfo.k = paramString2;
    localWeiYunFileInfo.f = 2;
    localWeiYunFileInfo.i = URLUtil.d(paramString1);
    paramString1 = new StringBuilder();
    paramString1.append(WeiyunPathUtil.b());
    paramString1.append("/");
    paramString1.append(paramString3);
    localWeiYunFileInfo.l = paramString1.toString();
    paramString1 = new StringBuilder();
    paramString1.append("FTN5K=");
    paramString1.append(paramString2);
    localWeiYunFileInfo.b = paramString1.toString();
    localWeiYunFileInfo.e = System.currentTimeMillis();
    return localWeiYunFileInfo;
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    int i = 0;
    if ((paramString2 != null) && (paramString2.equalsIgnoreCase("Weiyun")))
    {
      if (paramString3 == null) {
        return false;
      }
      if (this.mRuntime != null)
      {
        if (this.mRuntime.d() == null) {
          return false;
        }
        if (paramString3.equals("createDownload")) {
          paramString1 = paramVarArgs[0];
        }
      }
    }
    try
    {
      paramJsBridgeListener = new ArrayList();
      paramString1 = new JSONObject(paramString1);
      if (paramString1.has("file_list"))
      {
        paramString1 = paramString1.getJSONArray("file_list");
        while (i < paramString1.length())
        {
          paramString2 = paramString1.getJSONObject(i);
          paramString3 = paramString2.getString("url");
          paramVarArgs = paramString2.getString("pack_name");
          String str = paramString2.getString("file_id");
          paramJsBridgeListener.add(a(paramString3, paramString2.getString("FTN5K"), paramVarArgs, str, paramString2.getLong("file_size")));
          i += 1;
        }
      }
      paramString1 = new Intent("com.weiyun.BROADCAST");
      paramString1.setPackage(MobileQQ.getContext().getPackageName());
      paramString1.putExtra("fileinfos", paramJsBridgeListener);
      this.mRuntime.d().sendBroadcast(paramString1);
    }
    catch (Exception paramJsBridgeListener)
    {
      label206:
      break label206;
    }
    return true;
    return false;
  }
  
  public boolean isNeedPreCreatePlugin(Intent paramIntent, String paramString1, String paramString2)
  {
    return a(paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.weiyun.WeiyunJsPlugin
 * JD-Core Version:    0.7.0.1
 */