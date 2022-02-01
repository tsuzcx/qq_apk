package com.tencent.mobileqq.vas;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.manager.Manager;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

public class URLInterceptManager
  implements Manager
{
  public static String a = "URLInterceptManager";
  public static int b = -1;
  public static int c = 1;
  public static int d = 2;
  public static int e = 3;
  Map<String, String> f = new HashMap();
  Map<String, String> g = new HashMap();
  Map<String, String> h = new HashMap();
  AtomicBoolean i = new AtomicBoolean(false);
  
  public URLInterceptManager() {}
  
  public URLInterceptManager(QQAppInterface paramQQAppInterface) {}
  
  private void a(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    if ((IndividuationConfigInfo.a("8.8.17", paramString4)) && (IndividuationConfigInfo.a(paramString3, "8.8.17")))
    {
      if (QLog.isColorLevel())
      {
        paramString3 = a;
        paramString4 = new StringBuilder();
        paramString4.append("Parse from Json: URL = ");
        paramString4.append(paramString1);
        paramString4.append(" API = ");
        paramString4.append(paramString2);
        paramString4.append(" type = ");
        paramString4.append(paramInt);
        QLog.d(paramString3, 2, paramString4.toString());
      }
      if (paramInt == c)
      {
        this.f.put(paramString1, paramString2);
        return;
      }
      if (paramInt == d)
      {
        this.g.put(paramString1, paramString2);
        return;
      }
      if (paramInt == e) {
        this.h.put(paramString1, paramString2);
      }
    }
  }
  
  private void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {}
    for (;;)
    {
      int j;
      try
      {
        if (!paramJSONObject.has("urltoapi")) {
          break label97;
        }
        paramJSONObject = paramJSONObject.getJSONArray("urltoapi");
      }
      catch (Exception paramJSONObject)
      {
        String str = a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("doParseJson fail: ");
        localStringBuilder.append(paramJSONObject.getMessage());
        QLog.e(str, 1, localStringBuilder.toString());
      }
      if (j < paramJSONObject.length())
      {
        a(paramJSONObject, j);
        j += 1;
      }
      else
      {
        this.i.set(true);
        return;
        return;
        label97:
        paramJSONObject = null;
        if (paramJSONObject != null) {
          j = 0;
        }
      }
    }
  }
  
  private boolean a(JSONArray paramJSONArray, int paramInt)
  {
    Object localObject = paramJSONArray.getJSONObject(paramInt);
    if (localObject != null)
    {
      paramJSONArray = ((JSONObject)localObject).optString("url", null);
      if (paramJSONArray == null) {
        return true;
      }
      String str1 = ((JSONObject)localObject).optString("api", null);
      if (!TextUtils.isEmpty(str1))
      {
        if (!str1.startsWith("mqqapi")) {
          return true;
        }
        paramInt = ((JSONObject)localObject).optInt("match_type", b);
        if (paramInt == b) {
          return true;
        }
        String str2 = ((JSONObject)localObject).optString("minVer", null);
        if (TextUtils.isEmpty(str2)) {
          return true;
        }
        localObject = ((JSONObject)localObject).optString("maxVer", null);
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          return true;
        }
        a(paramJSONArray, str1, paramInt, str2, (String)localObject);
      }
      else
      {
        return true;
      }
    }
    return false;
  }
  
  @Nullable
  private String b(String paramString)
  {
    int j = paramString.indexOf("?");
    int k = paramString.indexOf("#");
    int m = Math.min(j, k);
    String str;
    if (m > 0)
    {
      str = paramString.substring(0, m);
    }
    else
    {
      j = Math.max(j, k);
      if (j > 0) {
        str = paramString.substring(0, j);
      } else {
        str = paramString;
      }
    }
    Object localObject;
    StringBuilder localStringBuilder;
    if (this.g.containsKey(str))
    {
      if (QLog.isColorLevel())
      {
        localObject = a;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("checkURL without param match url=");
        localStringBuilder.append(paramString);
        localStringBuilder.append(" Replace with: ");
        localStringBuilder.append((String)this.g.get(str));
        QLog.d((String)localObject, 2, localStringBuilder.toString());
      }
      return (String)this.g.get(str);
    }
    if (this.h.keySet().size() > 0)
    {
      localObject = this.h.keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        str = (String)((Iterator)localObject).next();
        if (paramString.startsWith(str))
        {
          if (QLog.isColorLevel())
          {
            localObject = a;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("checkURL part match url=");
            localStringBuilder.append(paramString);
            localStringBuilder.append(" Replace with: ");
            localStringBuilder.append((String)this.h.get(paramString));
            QLog.d((String)localObject, 2, localStringBuilder.toString());
          }
          return (String)this.h.get(str);
        }
      }
    }
    if (QLog.isColorLevel())
    {
      str = a;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("checkURL not match! url = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d(str, 2, ((StringBuilder)localObject).toString());
    }
    return null;
  }
  
  private boolean c(String paramString)
  {
    if (!this.i.get())
    {
      if (QLog.isColorLevel()) {
        QLog.e(a, 2, "checkURL fail config not load");
      }
      return true;
    }
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.e(a, 2, "checkURL url = null");
      }
      return true;
    }
    return false;
  }
  
  public String a(String paramString)
  {
    if (c(paramString)) {
      return null;
    }
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      str = a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkURL original url = ");
      localStringBuilder.append(paramString);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    String str = paramString;
    if (paramString.contains("www.urlshare.cn/umirror_url_check"))
    {
      int j = paramString.indexOf("&url=");
      str = paramString;
      if (j > 0)
      {
        j += 5;
        int k = paramString.indexOf("&src_uin", j);
        str = paramString;
        if (k > j) {
          str = paramString.substring(j, k);
        }
      }
    }
    if (this.f.containsKey(str))
    {
      if (QLog.isColorLevel())
      {
        paramString = a;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("checkURL full match url=");
        localStringBuilder.append(str);
        localStringBuilder.append(" Replace with: ");
        localStringBuilder.append((String)this.f.get(str));
        QLog.d(paramString, 2, localStringBuilder.toString());
      }
      return (String)this.f.get(str);
    }
    return b(str);
  }
  
  public void a(Context paramContext)
  {
    ThreadManager.post(new URLInterceptManager.1(this, paramContext), 8, null, true);
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    a(ClubContentJsonTask.a(paramQQAppInterface, ClubContentJsonTask.h, true));
  }
  
  public boolean a()
  {
    return this.i.get();
  }
  
  public boolean a(Intent paramIntent, Activity paramActivity)
  {
    if ((paramIntent.getComponent() != null) && ("com.tencent.mobileqq.activity.QQBrowserActivity".equals(paramIntent.getComponent().getClassName())))
    {
      paramIntent = a(paramIntent.getStringExtra("url"));
      if (!TextUtils.isEmpty(paramIntent))
      {
        Intent localIntent = new Intent(paramActivity, JumpActivity.class);
        localIntent.setData(Uri.parse(paramIntent));
        localIntent.putExtra("from", "webview");
        paramActivity.startActivity(localIntent);
        return true;
      }
    }
    return false;
  }
  
  public boolean a(Intent paramIntent, QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramIntent.getComponent() != null) && ("com.tencent.mobileqq.activity.QQBrowserActivity".equals(paramIntent.getComponent().getClassName())))
    {
      if (!this.i.get())
      {
        ThreadManager.post(new URLInterceptManager.2(this, paramQQAppInterface), 8, null, true);
        return false;
      }
      paramIntent = a(paramIntent.getStringExtra("url"));
      if (!TextUtils.isEmpty(paramIntent))
      {
        paramIntent = JumpParser.a(paramQQAppInterface, paramContext, paramIntent);
        if (paramIntent != null)
        {
          paramIntent.a();
          return true;
        }
      }
    }
    return false;
  }
  
  public void b(Context paramContext)
  {
    String str1 = ClubContentJsonTask.h.a;
    paramContext = new File(paramContext.getFilesDir(), str1);
    if (paramContext.exists())
    {
      String str2;
      StringBuilder localStringBuilder;
      try
      {
        paramContext = FileUtils.readFileContent(paramContext);
      }
      catch (OutOfMemoryError paramContext)
      {
        if (QLog.isColorLevel())
        {
          str2 = a;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("getJsonOOM,json_name:");
          localStringBuilder.append(str1);
          localStringBuilder.append(paramContext.getMessage());
          QLog.e(str2, 2, localStringBuilder.toString());
        }
        paramContext = null;
      }
      if (paramContext == null) {
        return;
      }
      try
      {
        a(new JSONObject(paramContext));
        return;
      }
      catch (Exception paramContext)
      {
        str2 = a;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("getJsonError,Exception:");
        localStringBuilder.append(str1);
        localStringBuilder.append(paramContext.getMessage());
        QLog.e(str2, 1, localStringBuilder.toString());
        return;
      }
    }
    QLog.w(a, 1, "json file not exist");
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.URLInterceptManager
 * JD-Core Version:    0.7.0.1
 */