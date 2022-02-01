package com.tencent.open.business.base.appreport;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.http.HttpCgiAsyncTask;
import com.tencent.open.business.base.AppUtil;
import com.tencent.open.business.base.MobileInfoUtil;
import com.tencent.smtt.sdk.WebView;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import org.json.JSONException;
import org.json.JSONObject;

public class AppUpdate
{
  @TargetApi(11)
  protected static Executor a()
  {
    if (Build.VERSION.SDK_INT >= 11) {
      return AsyncTask.THREAD_POOL_EXECUTOR;
    }
    return null;
  }
  
  public static void a(Context paramContext, WebView paramWebView, String paramString1, boolean paramBoolean, String paramString2)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("httpRequest >>> ");
    ((StringBuilder)localObject1).append(paramString1.toString());
    LogUtility.c("AppUpdate", ((StringBuilder)localObject1).toString());
    for (;;)
    {
      try
      {
        Object localObject2 = new JSONObject(paramString1);
        localObject1 = ((JSONObject)localObject2).optString("guid");
        String str1 = ((JSONObject)localObject2).optString("url");
        String str2 = ((JSONObject)localObject2).optString("method");
        String str3 = ((JSONObject)localObject2).optString("oncomplate");
        String str4 = ((JSONObject)localObject2).optString("onerror");
        i = ((JSONObject)localObject2).optInt("supportetag", 1);
        int j = 0;
        if (i == 1)
        {
          i = 1;
          Bundle localBundle = new Bundle();
          localBundle.putString("platform", CommonDataAdapter.a().g());
          localBundle.putString("keystr", CommonDataAdapter.a().a());
          localBundle.putString("uin", paramString2);
          localBundle.putString("resolution", MobileInfoUtil.getResolution());
          localBundle.putString("keytype", "256");
          if (!AppUtil.a(paramContext)) {
            break label674;
          }
          paramString1 = "1";
          localBundle.putString("allowScan", paramString1);
          if (str2.equals("POST"))
          {
            paramString1 = ((JSONObject)localObject2).optJSONObject("params");
            if (paramString1 != null)
            {
              paramString2 = paramString1.keys();
              if (paramString2.hasNext())
              {
                localObject2 = paramString2.next().toString();
                Object localObject3 = paramString1.get((String)localObject2);
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append("key = ");
                localStringBuilder.append((String)localObject2);
                localStringBuilder.append(" value = ");
                localStringBuilder.append(localObject3.toString());
                LogUtility.c("AppUpdate", localStringBuilder.toString());
                if (TextUtils.isEmpty((CharSequence)localObject2)) {
                  continue;
                }
                localBundle.putString((String)localObject2, localObject3.toString());
                continue;
              }
            }
          }
          else if (i != 0)
          {
            localBundle.putString("needhttpcache", "");
            LogUtility.c("AppUpdate", "use supportEtag");
          }
          if (!paramBoolean)
          {
            paramString2 = AppUtil.a(paramContext);
            if ((paramString2 != null) && (paramString2.size() > 0))
            {
              paramString1 = new StringBuilder();
              i = j;
              if (i < paramString2.size())
              {
                localObject2 = (PackageInfo)paramString2.get(i);
                paramString1.append("[\"");
                paramString1.append(((PackageInfo)localObject2).packageName);
                paramString1.append("\",");
                paramString1.append(((PackageInfo)localObject2).versionCode);
                paramString1.append(",\"");
                paramString1.append(((PackageInfo)localObject2).versionName);
                paramString1.append("\"]");
                paramString1.append(",");
                i += 1;
                continue;
              }
              if (paramString1.length() > 0) {
                paramString1.delete(paramString1.length() - 1, paramString1.length());
              }
              paramString2 = new StringBuilder();
              paramString2.append("[");
              paramString2.append(paramString1.toString());
              paramString2.append("]");
              localBundle.putString("package", paramString2.toString());
              localBundle.remove("update_data");
            }
          }
          paramString1 = new StringBuilder();
          paramString1.append("execute asyncTask url >>> ");
          paramString1.append(str1);
          paramString1.append(" methodName ");
          paramString1.append(str2);
          LogUtility.c("AppUpdate", paramString1.toString());
          a(new HttpCgiAsyncTask(str1, str2, new AppUpdate.GetUpdateAppCallback(paramContext, paramWebView, (String)localObject1, str3, str4, paramBoolean)), localBundle);
          return;
        }
      }
      catch (Exception paramContext)
      {
        LogUtility.c("AppUpdate", "httpRequest Exception", paramContext);
        return;
      }
      catch (JSONException paramContext)
      {
        LogUtility.c("AppUpdate", "httpRequest JSONException", paramContext);
        return;
      }
      int i = 0;
      continue;
      label674:
      paramString1 = "0";
    }
  }
  
  @TargetApi(11)
  protected static void a(HttpCgiAsyncTask paramHttpCgiAsyncTask, Bundle paramBundle)
  {
    Executor localExecutor = a();
    if (localExecutor != null)
    {
      paramHttpCgiAsyncTask.executeOnExecutor(localExecutor, new Bundle[] { paramBundle });
      return;
    }
    paramHttpCgiAsyncTask.execute(new Bundle[] { paramBundle });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.business.base.appreport.AppUpdate
 * JD-Core Version:    0.7.0.1
 */