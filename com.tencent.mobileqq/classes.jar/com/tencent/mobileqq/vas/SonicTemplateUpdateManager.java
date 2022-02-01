package com.tencent.mobileqq.vas;

import android.content.Intent;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webprocess.WebProcessReceiver;
import com.tencent.mobileqq.webview.api.IWebProcessPreload;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sonic.sdk.SonicEngine;
import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

public class SonicTemplateUpdateManager
  implements Manager
{
  QQAppInterface a;
  
  public SonicTemplateUpdateManager(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  private void a(JSONArray paramJSONArray, int paramInt, Map<String, Long> paramMap)
  {
    int i = 0;
    while (i < paramInt)
    {
      JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
      if (a(localJSONObject))
      {
        String str = localJSONObject.optString("url");
        if (!TextUtils.isEmpty(str))
        {
          Object localObject = null;
          if (WebAccelerateHelper.getSonicEngine() != null) {
            localObject = SonicEngine.makeSessionId(str, true);
          }
          if (localObject == null)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("parseJsonRunnable sonicSessionId = null, url = ");
            ((StringBuilder)localObject).append(str);
            QLog.e("SonicTemplateUpdateManager", 1, ((StringBuilder)localObject).toString());
          }
          else
          {
            paramMap.put(localObject, Long.valueOf(localJSONObject.optLong("templateUpdateTime")));
          }
        }
      }
      i += 1;
    }
  }
  
  private boolean a(JSONObject paramJSONObject)
  {
    boolean bool = VipGrayConfigHelper.a().a(this.a, paramJSONObject);
    if (QLog.isColorLevel())
    {
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("isConfigValid isValid = ");
      paramJSONObject.append(bool);
      QLog.d("SonicTemplateUpdateManager", 2, paramJSONObject.toString());
    }
    return bool;
  }
  
  private JSONObject c()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.a.getApplication().getFilesDir());
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append("sonicTemplateUpdate.json");
    localObject = new File(((StringBuilder)localObject).toString());
    if (((File)localObject).exists()) {
      try
      {
        JSONObject localJSONObject = new JSONObject(FileUtils.readFileContent((File)localObject));
        return localJSONObject;
      }
      catch (Throwable localThrowable)
      {
        if (QLog.isColorLevel()) {
          QLog.e("SonicTemplateUpdateManager", 2, "getJsonOOM,json_name:sonicTemplateUpdate.json", localThrowable);
        }
        ((File)localObject).delete();
      }
    } else {
      ((IVasQuickUpdateService)this.a.getRuntimeService(IVasQuickUpdateService.class, "")).downloadItem(1001L, "sonicTemplateUpdate.json", "getJSONFromLocal");
    }
    return null;
  }
  
  @Nullable
  private JSONArray d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SonicTemplateUpdateManager", 2, "parseJson begin");
    }
    Object localObject = c();
    if (localObject == null)
    {
      QLog.e("SonicTemplateUpdateManager", 1, "parseJson rootObj = null");
      return null;
    }
    localObject = ((JSONObject)localObject).optJSONArray("sonicTemplateUpdate");
    if ((localObject != null) && (((JSONArray)localObject).length() >= 1)) {
      return localObject;
    }
    QLog.e("SonicTemplateUpdateManager", 1, "parseJson configs = null or len < 1");
    return null;
  }
  
  public void a()
  {
    boolean bool;
    if (Looper.getMainLooper() == Looper.myLooper()) {
      bool = true;
    } else {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("parseJson isMainThread = ");
      localStringBuilder.append(bool);
      QLog.d("SonicTemplateUpdateManager", 2, localStringBuilder.toString());
    }
    if (bool)
    {
      ThreadManager.post(new SonicTemplateUpdateManager.1(this), 5, null, true);
      return;
    }
    b();
  }
  
  public void b()
  {
    Object localObject1 = d();
    if (localObject1 == null) {
      return;
    }
    try
    {
      int i = ((JSONArray)localObject1).length();
      localObject2 = new HashMap();
      a((JSONArray)localObject1, i, (Map)localObject2);
      if (((Map)localObject2).size() > 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SonicTemplateUpdateManager", 2, "parseJsonRunnable ready remove expire sonic template");
        }
        if (!((IWebProcessPreload)QRoute.api(IWebProcessPreload.class)).isWebProcessExist())
        {
          localObject1 = WebAccelerateHelper.getSonicEngine();
          if (localObject1 != null) {
            ((SonicEngine)localObject1).removeExpiredSessionCache((Map)localObject2);
          }
        }
        else
        {
          QLog.d("SonicTemplateUpdateManager", 1, "parseJsonRunnable WebProcess Exist");
          localObject1 = new Intent(BaseApplicationImpl.getApplication(), WebProcessReceiver.class);
          ((Intent)localObject1).setAction("action_delete_sonic_templateinfo");
          Object localObject3 = ((Map)localObject2).keySet();
          localObject2 = ((Map)localObject2).values();
          localObject3 = (String[])((Set)localObject3).toArray(new String[((Set)localObject3).size()]);
          long[] arrayOfLong = new long[((Collection)localObject2).size()];
          localObject2 = ((Collection)localObject2).iterator();
          i = 0;
          while (((Iterator)localObject2).hasNext()) {
            if (i < arrayOfLong.length)
            {
              arrayOfLong[i] = ((Long)((Iterator)localObject2).next()).longValue();
              i += 1;
            }
          }
          ((Intent)localObject1).putExtra("com.tencent.mobileqq.webprocess.sonic_template_delete_sessionId", (String[])localObject3);
          ((Intent)localObject1).putExtra("com.tencent.mobileqq.webprocess.sonic_template_delete_updateTime", arrayOfLong);
          BaseApplicationImpl.getApplication().sendBroadcast((Intent)localObject1, "com.tencent.msg.permission.pushnotify");
          return;
        }
      }
    }
    catch (Exception localException)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("parseJsonRunnable exception e = ");
      ((StringBuilder)localObject2).append(localException.getMessage());
      QLog.e("SonicTemplateUpdateManager", 1, ((StringBuilder)localObject2).toString());
    }
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.SonicTemplateUpdateManager
 * JD-Core Version:    0.7.0.1
 */