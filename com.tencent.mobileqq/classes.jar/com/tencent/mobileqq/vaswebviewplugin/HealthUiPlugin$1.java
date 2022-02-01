package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.statistics.DcReportUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.ClubContentJsonTask;
import com.tencent.mobileqq.vas.ClubContentJsonTask.TaskInfo;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URLEncoder;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

class HealthUiPlugin$1
  implements Runnable
{
  HealthUiPlugin$1(HealthUiPlugin paramHealthUiPlugin, String paramString) {}
  
  public void run()
  {
    if (this.this$0.mRuntime == null) {
      return;
    }
    synchronized (this.this$0.mJDUpdateConfig)
    {
      boolean bool = this.this$0.mIsJDUpdateConfigInit;
      if (!bool) {}
      try
      {
        localObject2 = new File(this.this$0.mRuntime.d().getApplicationContext().getFilesDir(), ClubContentJsonTask.c.a);
        if (((File)localObject2).exists())
        {
          localObject2 = new JSONObject(FileUtils.readFileContent((File)localObject2)).getJSONObject("data").getJSONArray("jdUploadLog");
          if (localObject2 != null)
          {
            int j = ((JSONArray)localObject2).length();
            i = 0;
            while (i < j)
            {
              localObject5 = ((JSONArray)localObject2).getJSONObject(i);
              if (((JSONObject)localObject5).has("jdUploadLog"))
              {
                localObject5 = ((JSONObject)localObject5).getString("jdUploadLog");
                if (!TextUtils.isEmpty((CharSequence)localObject5)) {
                  this.this$0.mJDUpdateConfig.add(localObject5);
                }
              }
              i += 1;
            }
          }
        }
      }
      catch (Exception localException1)
      {
        try
        {
          int i = NetworkUtil.getSystemNetwork(this.this$0.mRuntime.d().getApplicationContext());
          break label218;
          i = 0;
          if (i != 0) {
            break label223;
          }
          return;
          if (i == 1) {
            break label270;
          }
          if (i == 2) {
            break label263;
          }
          if (i == 3) {
            break label256;
          }
          if (i == 4) {
            break label249;
          }
          ??? = null;
          break label274;
          ??? = "4G";
          break label274;
          ??? = "3G";
          break label274;
          ??? = "2G";
          break label274;
          ??? = "wifi";
          if (!TextUtils.isEmpty((CharSequence)???)) {
            break label283;
          }
          return;
          if (!this.this$0.mJDUpdateConfig.contains(???)) {
            break label822;
          }
          if ((!this.val$url.contains("jd.com")) && (!this.val$url.contains("wanggou.com")) && (!this.val$url.contains("paipai.com"))) {
            break label500;
          }
          Object localObject2 = new StringBuilder();
          try
          {
            ((StringBuilder)localObject2).append("jd");
            ((StringBuilder)localObject2).append("|");
            ((StringBuilder)localObject2).append(URLEncoder.encode(this.val$url, "UTF-8"));
            ((StringBuilder)localObject2).append("|");
            ((StringBuilder)localObject2).append((String)???);
            ((StringBuilder)localObject2).append("|");
            ((StringBuilder)localObject2).append("android");
            ((StringBuilder)localObject2).append("|");
            ((StringBuilder)localObject2).append("8.8.17");
            ((StringBuilder)localObject2).append("|");
            ((StringBuilder)localObject2).append("|");
            ((StringBuilder)localObject2).append("|");
            ((StringBuilder)localObject2).append("|");
            ((StringBuilder)localObject2).append("|");
            ((StringBuilder)localObject2).append("|");
            ((StringBuilder)localObject2).append("|");
            DcReportUtil.a(null, "dc00454", ((StringBuilder)localObject2).toString(), false);
          }
          catch (Exception localException2)
          {
            localException2.printStackTrace();
          }
          if ((!this.val$url.contains("91160.com")) && (!this.val$url.contains("guahao.com"))) {
            break label822;
          }
          i = this.val$url.indexOf("?");
          if (i == -1) {
            break label565;
          }
          localObject3 = this.val$url.substring(0, i);
          localObject5 = this.val$url.substring(i + 1);
          break label574;
          localObject3 = this.val$url;
          localObject5 = null;
          localObject6 = localObject3;
          if (TextUtils.isEmpty((CharSequence)localObject5)) {
            break label631;
          }
        }
        catch (Exception localException1)
        {
          try
          {
            for (;;)
            {
              Object localObject5;
              localObject6 = new StringBuilder();
              ((StringBuilder)localObject6).append((String)localObject3);
              ((StringBuilder)localObject6).append("?");
              ((StringBuilder)localObject6).append(URLEncoder.encode((String)localObject5, "UTF-8"));
              localObject6 = ((StringBuilder)localObject6).toString();
              if (QLog.isColorLevel())
              {
                localObject3 = new StringBuilder();
                ((StringBuilder)localObject3).append("report guahao url \n");
                ((StringBuilder)localObject3).append((String)localObject6);
                QLog.d("HealthUiPlugin", 2, ((StringBuilder)localObject3).toString());
              }
              Object localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("jiankang");
              ((StringBuilder)localObject3).append("|");
              ((StringBuilder)localObject3).append((String)localObject6);
              ((StringBuilder)localObject3).append("|");
              ((StringBuilder)localObject3).append((String)???);
              ((StringBuilder)localObject3).append("|");
              ((StringBuilder)localObject3).append("android");
              ((StringBuilder)localObject3).append("|");
              ((StringBuilder)localObject3).append("8.8.17");
              ((StringBuilder)localObject3).append("|");
              ((StringBuilder)localObject3).append("|");
              ((StringBuilder)localObject3).append("|");
              ((StringBuilder)localObject3).append("|");
              ((StringBuilder)localObject3).append("|");
              ((StringBuilder)localObject3).append("|");
              ((StringBuilder)localObject3).append("|");
              DcReportUtil.a(null, "dc00454", ((StringBuilder)localObject3).toString(), false);
              return;
              localObject4 = finally;
              for (;;)
              {
                throw localObject4;
              }
              localException3 = localException3;
            }
            localException1 = localException1;
          }
          catch (Exception localException4)
          {
            for (;;)
            {
              Object localObject6 = localException3;
            }
          }
        }
      }
      this.this$0.mIsJDUpdateConfigInit = true;
      if (this.this$0.mJDUpdateConfig.size() == 0) {
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.HealthUiPlugin.1
 * JD-Core Version:    0.7.0.1
 */