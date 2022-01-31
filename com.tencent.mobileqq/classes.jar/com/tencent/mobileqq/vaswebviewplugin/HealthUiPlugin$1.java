package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import axpw;
import bbdj;
import bbev;
import bbnq;
import bbnu;
import bcdb;
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
    if (this.this$0.mRuntime == null) {}
    for (;;)
    {
      return;
      int i;
      Object localObject4;
      synchronized (this.this$0.mJDUpdateConfig)
      {
        boolean bool = this.this$0.mIsJDUpdateConfigInit;
        if (!bool) {
          try
          {
            Object localObject1 = new File(this.this$0.mRuntime.a().getApplicationContext().getFilesDir(), bbnq.c.a);
            if ((localObject1 != null) && (((File)localObject1).exists()))
            {
              localObject1 = new JSONObject(bbdj.a((File)localObject1)).getJSONObject("data").getJSONArray("jdUploadLog");
              if (localObject1 != null)
              {
                int j = ((JSONArray)localObject1).length();
                i = 0;
                while (i < j)
                {
                  localObject4 = ((JSONArray)localObject1).getJSONObject(i);
                  if (((JSONObject)localObject4).has("jdUploadLog"))
                  {
                    localObject4 = ((JSONObject)localObject4).getString("jdUploadLog");
                    if (!TextUtils.isEmpty((CharSequence)localObject4)) {
                      this.this$0.mJDUpdateConfig.add(localObject4);
                    }
                  }
                  i += 1;
                }
              }
            }
          }
          catch (Exception localException2)
          {
            this.this$0.mIsJDUpdateConfigInit = true;
          }
        }
        if (this.this$0.mJDUpdateConfig.size() == 0) {
          continue;
        }
      }
      try
      {
        i = bbev.a(this.this$0.mRuntime.a().getApplicationContext());
        if (i == 0) {
          continue;
        }
        switch (i)
        {
        default: 
          ??? = null;
          if ((TextUtils.isEmpty(???)) || (!this.this$0.mJDUpdateConfig.contains(???))) {
            continue;
          }
          if ((this.val$url.contains("jd.com")) || (this.val$url.contains("wanggou.com")) || (this.val$url.contains("paipai.com"))) {
            localObject2 = new StringBuilder();
          }
          break;
        }
      }
      catch (Exception localException3)
      {
        try
        {
          ((StringBuilder)localObject2).append("jd").append("|").append(URLEncoder.encode(this.val$url, "UTF-8")).append("|").append(???).append("|").append("android").append("|").append("8.2.8").append("|").append("|").append("|").append("|").append("|").append("|").append("|");
          axpw.a(null, "dc00454", ((StringBuilder)localObject2).toString(), false);
          if ((!this.val$url.contains("91160.com")) && (!this.val$url.contains("guahao.com"))) {
            continue;
          }
          i = this.val$url.indexOf("?");
          if (i != -1)
          {
            localObject2 = this.val$url.substring(0, i);
            localObject4 = this.val$url.substring(i + 1);
            localObject5 = localObject2;
            if (TextUtils.isEmpty((CharSequence)localObject4)) {}
          }
        }
        catch (Exception localException3)
        {
          try
          {
            for (;;)
            {
              localObject5 = (String)localObject2 + "?" + URLEncoder.encode((String)localObject4, "UTF-8");
              if (QLog.isColorLevel()) {
                QLog.d("HealthUiPlugin", 2, "report guahao url \n" + (String)localObject5);
              }
              Object localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("jiankang").append("|").append((String)localObject5).append("|").append(???).append("|").append("android").append("|").append("8.2.8").append("|").append("|").append("|").append("|").append("|").append("|").append("|");
              axpw.a(null, "dc00454", ((StringBuilder)localObject2).toString(), false);
              return;
              localObject3 = finally;
              throw localObject3;
              localException1 = localException1;
              i = 0;
              continue;
              String str1 = "2G";
              continue;
              str1 = "3G";
              continue;
              str1 = "4G";
              continue;
              str1 = "wifi";
              continue;
              localException3 = localException3;
              localException3.printStackTrace();
            }
            str2 = this.val$url;
            localObject4 = null;
          }
          catch (Exception localException4)
          {
            for (;;)
            {
              String str2;
              Object localObject5 = str2;
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.HealthUiPlugin.1
 * JD-Core Version:    0.7.0.1
 */