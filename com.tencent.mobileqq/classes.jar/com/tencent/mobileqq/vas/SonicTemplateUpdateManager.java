package com.tencent.mobileqq.vas;

import akpj;
import android.content.Intent;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.mobileqq.webprocess.WebProcessReceiver;
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
  
  private JSONObject a()
  {
    File localFile = new File(this.a.getApplication().getFilesDir() + File.separator + "sonicTemplateUpdate.json");
    if (localFile.exists()) {
      try
      {
        JSONObject localJSONObject = new JSONObject(FileUtils.a(localFile));
        return localJSONObject;
      }
      catch (Throwable localThrowable)
      {
        if (QLog.isColorLevel()) {
          QLog.e("SonicTemplateUpdateManager", 2, "getJsonOOM,json_name:sonicTemplateUpdate.json", localThrowable);
        }
        localFile.delete();
      }
    }
    for (;;)
    {
      return null;
      ((VasQuickUpdateManager)this.a.getManager(183)).a(1001L, "sonicTemplateUpdate.json", "getJSONFromLocal");
    }
  }
  
  private boolean a(JSONObject paramJSONObject)
  {
    boolean bool = VipGrayConfigHelper.a().a(this.a, paramJSONObject);
    if (QLog.isColorLevel()) {
      QLog.d("SonicTemplateUpdateManager", 2, "isConfigValid isValid = " + bool);
    }
    return bool;
  }
  
  public void a()
  {
    if (Looper.getMainLooper() == Looper.myLooper()) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SonicTemplateUpdateManager", 2, "parseJson isMainThread = " + bool);
      }
      if (!bool) {
        break;
      }
      ThreadManager.post(new akpj(this), 5, null, true);
      return;
    }
    b();
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SonicTemplateUpdateManager", 2, "parseJson begin");
    }
    Object localObject1 = a();
    if (localObject1 == null)
    {
      QLog.e("SonicTemplateUpdateManager", 1, "parseJson rootObj = null");
      return;
    }
    Object localObject3 = ((JSONObject)localObject1).optJSONArray("sonicTemplateUpdate");
    if ((localObject3 == null) || (((JSONArray)localObject3).length() < 1))
    {
      QLog.e("SonicTemplateUpdateManager", 1, "parseJson configs = null or len < 1");
      return;
    }
    for (;;)
    {
      String str;
      try
      {
        int j = ((JSONArray)localObject3).length();
        localObject1 = new HashMap();
        i = 0;
        if (i >= j) {
          break label219;
        }
        localObject4 = ((JSONArray)localObject3).getJSONObject(i);
        if (!a((JSONObject)localObject4)) {
          break label415;
        }
        localObject5 = ((JSONObject)localObject4).optString("url");
        if (TextUtils.isEmpty((CharSequence)localObject5)) {
          break label415;
        }
        WebAccelerateHelper.getSonicEngine();
        str = SonicEngine.makeSessionId((String)localObject5, true);
        if (str == null) {
          QLog.e("SonicTemplateUpdateManager", 1, "parseJsonRunnable sonicSessionId = null, url = " + (String)localObject5);
        }
      }
      catch (Exception localException)
      {
        QLog.e("SonicTemplateUpdateManager", 1, "parseJsonRunnable exception e = " + localException.getMessage());
        return;
      }
      localException.put(str, Long.valueOf(((JSONObject)localObject4).optLong("templateUpdateTime")));
      break label415;
      label219:
      if (localException.size() <= 0) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SonicTemplateUpdateManager", 2, "parseJsonRunnable ready remove expire sonic template");
      }
      if (!WebProcessManager.c())
      {
        WebAccelerateHelper.getSonicEngine().removeExpiredSessionCache(localException);
        return;
      }
      QLog.d("SonicTemplateUpdateManager", 1, "parseJsonRunnable WebProcess Exist");
      localObject3 = new Intent(BaseApplicationImpl.getApplication(), WebProcessReceiver.class);
      ((Intent)localObject3).setAction("action_delete_sonic_templateinfo");
      Object localObject4 = localException.keySet();
      Object localObject2 = localException.values();
      localObject4 = (String[])((Set)localObject4).toArray(new String[((Set)localObject4).size()]);
      Object localObject5 = new long[((Collection)localObject2).size()];
      localObject2 = ((Collection)localObject2).iterator();
      int i = 0;
      while (((Iterator)localObject2).hasNext()) {
        if (i < localObject5.length)
        {
          localObject5[i] = ((Long)((Iterator)localObject2).next()).longValue();
          i += 1;
        }
      }
      ((Intent)localObject3).putExtra("com.tencent.mobileqq.webprocess.sonic_template_delete_sessionId", (String[])localObject4);
      ((Intent)localObject3).putExtra("com.tencent.mobileqq.webprocess.sonic_template_delete_updateTime", (long[])localObject5);
      BaseApplicationImpl.getApplication().sendBroadcast((Intent)localObject3, "com.tencent.msg.permission.pushnotify");
      return;
      label415:
      i += 1;
    }
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.vas.SonicTemplateUpdateManager
 * JD-Core Version:    0.7.0.1
 */