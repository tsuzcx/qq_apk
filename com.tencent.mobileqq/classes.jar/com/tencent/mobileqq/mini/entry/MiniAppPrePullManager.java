package com.tencent.mobileqq.mini.entry;

import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import eipc.EIPCClient;
import java.net.URLDecoder;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class MiniAppPrePullManager
{
  private static final long DEFAULT_INTERVAL_TIME = 7200000L;
  private static final long INTERVAL_TIME;
  private static final String QQ_PROCESS_NAME = "com.tencent.mobileqq";
  private static final String TAG = "MiniAppPrePullManager";
  private static boolean enablePrePull;
  private static volatile MiniAppPrePullManager instance;
  private static Runnable loadDataFromDBRunnable;
  private static final Object mLock;
  private static HashMap<String, MiniAppPrePullManager.MiniAppInfoPrePullWrapper> prePullAppInfoMapForId;
  private static HashMap<String, MiniAppPrePullManager.MiniAppInfoPrePullWrapper> prePullAppInfoMapForLink;
  
  static
  {
    boolean bool = true;
    if (QzoneConfig.getInstance().getConfig("qqminiapp", "mini_app_preload_switcher", 1) == 1) {}
    for (;;)
    {
      enablePrePull = bool;
      INTERVAL_TIME = QzoneConfig.getInstance().getConfig("qqminiapp", "mini_app_preload_interval_time", 7200000L);
      prePullAppInfoMapForId = new HashMap();
      prePullAppInfoMapForLink = new HashMap();
      mLock = new Object();
      loadDataFromDBRunnable = new MiniAppPrePullManager.1();
      return;
      bool = false;
    }
  }
  
  public MiniAppPrePullManager()
  {
    ThreadManager.excute(loadDataFromDBRunnable, 32, null, true);
  }
  
  public static MiniAppPrePullManager getInstance()
  {
    if (instance == null) {}
    try
    {
      if (instance == null) {
        instance = new MiniAppPrePullManager();
      }
      return instance;
    }
    finally {}
  }
  
  private MiniAppPrePullManager.MiniAppInfoPrePullWrapper getPrePullAppInfoWrapperById(String paramString1, String paramString2)
  {
    if (prePullAppInfoMapForId != null)
    {
      paramString1 = (MiniAppPrePullManager.MiniAppInfoPrePullWrapper)prePullAppInfoMapForId.get(paramString1);
      if (paramString1 != null) {
        if (paramString2 == null)
        {
          if (paramString1.getEntryPath() != null) {}
        }
        else {
          while (paramString2.equals(paramString1.getEntryPath())) {
            return paramString1;
          }
        }
      }
    }
    return null;
  }
  
  private MiniAppPrePullManager.MiniAppInfoPrePullWrapper getPrePullAppInfoWrapperByLink(String paramString)
  {
    if (prePullAppInfoMapForLink != null) {
      return (MiniAppPrePullManager.MiniAppInfoPrePullWrapper)prePullAppInfoMapForLink.get(paramString);
    }
    return null;
  }
  
  public void prePullAppinfoById(String paramString1, String paramString2, MiniAppPrePullManager.IPrePullListener paramIPrePullListener)
  {
    prePullAppinfoById(paramString1, paramString2, "release", paramIPrePullListener);
  }
  
  public void prePullAppinfoById(String paramString1, String paramString2, String paramString3, MiniAppPrePullManager.IPrePullListener paramIPrePullListener)
  {
    if (!enablePrePull) {}
    do
    {
      return;
      QLog.d("MiniAppPrePullManager", 1, "prePullAppinfoById, entryPath = " + paramString2 + ",envVersion = " + paramString3);
      MiniAppPrePullManager.MiniAppInfoPrePullWrapper localMiniAppInfoPrePullWrapper = getPrePullAppInfoWrapperById(paramString1, paramString2);
      if ((localMiniAppInfoPrePullWrapper == null) || (System.currentTimeMillis() - localMiniAppInfoPrePullWrapper.getPullTimeStamp() >= INTERVAL_TIME)) {
        break;
      }
      QLog.d("MiniAppPrePullManager", 1, "prePullAppinfoById suc, has been preload, appInfo = " + localMiniAppInfoPrePullWrapper.appId);
    } while (paramIPrePullListener == null);
    paramString2 = new JSONObject();
    try
    {
      paramString2.put("retCode", 0);
      paramString2.put("errMsg", "appid:" + paramString1 + ", has benn preloaded");
      paramIPrePullListener.onPrePullCallback(true, paramString2);
      return;
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
      return;
    }
    MiniAppCmdUtil.getInstance().getAppInfoById(null, paramString1, paramString2, paramString3, new MiniAppPrePullManager.2(this, paramString1, paramString2, paramIPrePullListener));
  }
  
  public void prePullAppinfoByLink(String paramString, int paramInt, MiniAppPrePullManager.IPrePullListener paramIPrePullListener)
  {
    if (!enablePrePull) {}
    Object localObject;
    int i;
    do
    {
      return;
      localObject = BaseApplicationImpl.getApplication().getQQProcessName();
      if ((localObject != null) && (!((String)localObject).equals("com.tencent.mobileqq")))
      {
        QLog.d("MiniAppPrePullManager", 1, "prePullAppinfoByLink need to change process: " + (String)localObject + ", link = " + paramString + ",linkType = " + paramInt);
        paramIPrePullListener = new Bundle();
        paramIPrePullListener.putString("miniapp_preload_link", paramString);
        paramIPrePullListener.putInt("miniapp_preload_link_type", paramInt);
        QIPCClientHelper.getInstance().getClient().callServer("QzoneIPCModule", "action_pre_pull_mini_app", paramIPrePullListener);
        return;
      }
      localObject = paramString;
      i = paramInt;
      if (paramString.startsWith("mqqapi://microapp/open?"))
      {
        localObject = new HashMap();
        if (QLog.isColorLevel()) {
          QLog.d("MiniAppPrePullManager", 2, "[miniapp-scheme-prepull], open microapp scheme=" + paramString);
        }
        String[] arrayOfString1 = paramString.split("\\?");
        if ((arrayOfString1.length < 2) || (arrayOfString1[0].length() == 0))
        {
          QLog.e("MiniAppPrePullManager", 1, "[miniapp-scheme-prepull], scheme format err, scheme=" + paramString);
          return;
        }
        arrayOfString1 = paramString.substring(arrayOfString1[0].length() + 1).split("&");
        if (arrayOfString1 != null)
        {
          i = 0;
          while (i < arrayOfString1.length)
          {
            String[] arrayOfString2 = arrayOfString1[i].split("=");
            if ((arrayOfString2 != null) && (arrayOfString2.length == 2))
            {
              ((HashMap)localObject).put(arrayOfString2[0], arrayOfString2[1]);
              if (QLog.isColorLevel()) {
                QLog.d("MiniAppPrePullManager", 2, "[miniapp-scheme-prepull], open microapp key=" + arrayOfString2[0] + ", value=" + arrayOfString2[1]);
              }
            }
            i += 1;
          }
        }
        localObject = (String)((HashMap)localObject).get("url");
      }
      try
      {
        localObject = URLDecoder.decode((String)localObject, "UTF-8");
        i = 0;
      }
      catch (Exception localException)
      {
        String str;
        for (;;)
        {
          QLog.e("MiniAppPrePullManager", 1, "prePullAppinfoByLink decode url get an Exception, " + localException);
          str = paramString;
          i = paramInt;
        }
        MiniAppCmdUtil.getInstance().getAppInfoByLink(str, i, new MiniAppPrePullManager.3(this, str, paramIPrePullListener));
      }
      QLog.d("MiniAppPrePullManager", 1, "prePullAppinfoByLink, link = " + (String)localObject + ",linkType = " + i);
      paramString = getPrePullAppInfoWrapperByLink((String)localObject);
      if ((paramString == null) || (System.currentTimeMillis() - paramString.getPullTimeStamp() >= INTERVAL_TIME)) {
        break;
      }
      QLog.d("MiniAppPrePullManager", 1, "prePullAppinfoByLink suc, has been preload, appId = " + paramString.appId);
    } while (paramIPrePullListener == null);
    paramString = new JSONObject();
    try
    {
      paramString.put("retCode", 0);
      paramString.put("errMsg", "link:" + (String)localObject + ", has benn preloaded");
      paramIPrePullListener.onPrePullCallback(true, paramString);
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
      return;
    }
  }
  
  public void prePullAppinfoByLink(String paramString, MiniAppPrePullManager.IPrePullListener paramIPrePullListener)
  {
    if ((paramString != null) && (paramString.startsWith("mqqapi://miniapp/"))) {
      prePullAppinfoByLink(paramString, 2, paramIPrePullListener);
    }
    do
    {
      return;
      if ((paramString != null) && (paramString.contains("fakeUrl")))
      {
        prePullAppinfoByLink(paramString, 0, paramIPrePullListener);
        return;
      }
    } while (paramString == null);
    prePullAppinfoByLink(paramString, 1, paramIPrePullListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppPrePullManager
 * JD-Core Version:    0.7.0.1
 */