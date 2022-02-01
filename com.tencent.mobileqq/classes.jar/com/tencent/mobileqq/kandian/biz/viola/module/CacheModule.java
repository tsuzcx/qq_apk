package com.tencent.mobileqq.kandian.biz.viola.module;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.annotation.JSMethod;
import com.tencent.viola.bridge.ViolaBridgeManager;
import com.tencent.viola.commons.Destroyable;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.module.BaseModule;
import java.util.Iterator;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CacheModule
  extends BaseModule
  implements Destroyable
{
  public static final String MODULE_NAME = "cache";
  public static final String TAG = "CacheModule";
  public static final String VIOLA_CACHE_FILE_NAME = "viola_cache_file_";
  
  protected static void handleBody(JSONObject paramJSONObject)
  {
    try
    {
      if (paramJSONObject.get("children") != null)
      {
        paramJSONObject = paramJSONObject.getJSONArray("children");
        int i = 0;
        while (i < paramJSONObject.length())
        {
          JSONObject localJSONObject = paramJSONObject.getJSONObject(i);
          if ("image".equals(localJSONObject.optString("type"))) {
            localJSONObject.optJSONObject("attr").put("src", "");
          }
          handleBody(localJSONObject);
          i += 1;
        }
      }
      return;
    }
    catch (JSONException paramJSONObject) {}
  }
  
  @JSMethod(uiThread=false)
  public void cacheBody(@NonNull String paramString)
  {
    JSONArray localJSONArray = new JSONArray();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("module", "dom");
      localJSONObject.put("method", "createBody");
      paramString = new JSONObject(paramString);
      handleBody(paramString);
      localJSONObject.put("args", paramString);
      localJSONArray.put(localJSONObject);
      setItem(getViolaInstance().getUrl(), localJSONArray.toString());
      return;
    }
    catch (JSONException paramString) {}
  }
  
  public void destroy() {}
  
  @JSMethod(uiThread=false)
  public void getItem(@NonNull String paramString1, String paramString2)
  {
    Object localObject = MobileQQ.sMobileQQ.peekAppRuntime();
    if (localObject == null)
    {
      QLog.e("CacheModule", 1, "failed to getItem");
      if (!TextUtils.isEmpty(paramString2)) {
        ViolaBridgeManager.getInstance().callbackJavascript(getViolaInstance().getInstanceId(), "cache", "callback", paramString2, new JSONObject().toString(), true);
      }
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("viola_cache_file_");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append(((AppRuntime)localObject).getAccount());
    localObject = FileUtils.readObject(localStringBuilder.toString());
    paramString1 = null;
    if ((localObject instanceof String)) {
      paramString1 = (String)localObject;
    }
    localObject = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      localObject = new JSONObject().toString();
    }
    if (!TextUtils.isEmpty(paramString2)) {
      ViolaBridgeManager.getInstance().callbackJavascript(getViolaInstance().getInstanceId(), "cache", "callback", paramString2, localObject, true);
    }
  }
  
  @JSMethod(uiThread=false)
  public void multiGet(@NonNull JSONObject paramJSONObject, String paramString)
  {
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
    if (localAppRuntime == null)
    {
      QLog.e("CacheModule", 1, "failed to getItem");
      if (!TextUtils.isEmpty(paramString)) {
        ViolaBridgeManager.getInstance().callbackJavascript(getViolaInstance().getInstanceId(), "cache", "callback", paramString, new JSONObject().toString(), true);
      }
      return;
    }
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    try
    {
      JSONArray localJSONArray = paramJSONObject.getJSONArray("keys");
      int i = 0;
      while (i < localJSONArray.length())
      {
        String str = localJSONArray.getString(i);
        paramJSONObject = new StringBuilder();
        paramJSONObject.append("viola_cache_file_");
        paramJSONObject.append(str);
        paramJSONObject.append("_");
        paramJSONObject.append(localAppRuntime.getAccount());
        Object localObject = FileUtils.readObject(paramJSONObject.toString());
        paramJSONObject = null;
        if ((localObject instanceof String)) {
          paramJSONObject = (String)localObject;
        }
        localObject = paramJSONObject;
        if (TextUtils.isEmpty(paramJSONObject)) {
          localObject = "";
        }
        localJSONObject2.put(str, localObject);
        i += 1;
      }
      localJSONObject1.put("data", localJSONObject2);
    }
    catch (JSONException paramJSONObject)
    {
      QLog.e("CacheModule", 1, "CacheModule multiGet:", paramJSONObject);
    }
    if (!TextUtils.isEmpty(paramString)) {
      ViolaBridgeManager.getInstance().callbackJavascript(getViolaInstance().getInstanceId(), "cache", "callback", paramString, localJSONObject1, true);
    }
  }
  
  @JSMethod(uiThread=false)
  public void multiRemove(@NonNull JSONObject paramJSONObject, String paramString)
  {
    paramString = MobileQQ.sMobileQQ.peekAppRuntime();
    if (paramString == null)
    {
      QLog.e("CacheModule", 1, "failed to remove");
      return;
    }
    try
    {
      paramJSONObject = paramJSONObject.getJSONArray("keys");
      int i = 0;
      while (i < paramJSONObject.length())
      {
        String str = paramJSONObject.getString(i);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(MobileQQ.getContext().getFilesDir());
        localStringBuilder.append("/");
        localStringBuilder.append("viola_cache_file_");
        localStringBuilder.append(str);
        localStringBuilder.append("_");
        localStringBuilder.append(paramString.getAccount());
        FileUtils.deleteFile(localStringBuilder.toString());
        i += 1;
      }
      return;
    }
    catch (JSONException paramJSONObject)
    {
      QLog.e("CacheModule", 1, "CacheModule multiRemove:", paramJSONObject);
    }
  }
  
  @JSMethod(uiThread=false)
  public void multiSet(@NonNull JSONObject paramJSONObject, String paramString)
  {
    paramString = MobileQQ.sMobileQQ.peekAppRuntime();
    if (paramString == null)
    {
      QLog.e("CacheModule", 1, "failed to setItem");
      return;
    }
    Iterator localIterator = paramJSONObject.keys();
    try
    {
      while (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        String str2 = (String)paramJSONObject.get(str1);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("viola_cache_file_");
        localStringBuilder.append(str1);
        localStringBuilder.append("_");
        localStringBuilder.append(paramString.getAccount());
        FileUtils.writeObject(localStringBuilder.toString(), str2);
      }
      return;
    }
    catch (JSONException paramJSONObject)
    {
      QLog.e("CacheModule", 1, "CacheModule multiSet:", paramJSONObject);
    }
  }
  
  @JSMethod(uiThread=false)
  public void remove(@NonNull String paramString)
  {
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
    if (localAppRuntime == null)
    {
      QLog.e("CacheModule", 1, "failed to remove");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(MobileQQ.getContext().getFilesDir());
    localStringBuilder.append("/");
    localStringBuilder.append("viola_cache_file_");
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(localAppRuntime.getAccount());
    FileUtils.deleteFile(localStringBuilder.toString());
  }
  
  @JSMethod(uiThread=false)
  public void setItem(@NonNull String paramString1, String paramString2)
  {
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
    if (localAppRuntime == null)
    {
      QLog.e("CacheModule", 1, "failed to setItem");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("viola_cache_file_");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append(localAppRuntime.getAccount());
    FileUtils.writeObject(localStringBuilder.toString(), paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.viola.module.CacheModule
 * JD-Core Version:    0.7.0.1
 */