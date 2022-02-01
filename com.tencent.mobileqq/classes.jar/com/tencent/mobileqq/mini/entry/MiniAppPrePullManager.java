package com.tencent.mobileqq.mini.entry;

import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.api.IPrePullListener;
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
  private static Runnable loadDataFromDBRunnable = new MiniAppPrePullManager.1();
  private static final Object mLock;
  private static HashMap<String, MiniAppPrePullManager.MiniAppInfoPrePullWrapper> prePullAppInfoMapForId;
  private static HashMap<String, MiniAppPrePullManager.MiniAppInfoPrePullWrapper> prePullAppInfoMapForLink;
  
  static
  {
    QzoneConfig localQzoneConfig = QzoneConfig.getInstance();
    boolean bool = true;
    if (localQzoneConfig.getConfig("qqminiapp", "mini_app_preload_switcher", 1) != 1) {
      bool = false;
    }
    enablePrePull = bool;
    INTERVAL_TIME = QzoneConfig.getInstance().getConfig("qqminiapp", "mini_app_preload_interval_time", 7200000L);
    prePullAppInfoMapForId = new HashMap();
    prePullAppInfoMapForLink = new HashMap();
    mLock = new Object();
  }
  
  public MiniAppPrePullManager()
  {
    ThreadManager.excute(loadDataFromDBRunnable, 32, null, true);
  }
  
  public static MiniAppPrePullManager getInstance()
  {
    if (instance == null) {
      try
      {
        if (instance == null) {
          instance = new MiniAppPrePullManager();
        }
      }
      finally {}
    }
    return instance;
  }
  
  private MiniAppPrePullManager.MiniAppInfoPrePullWrapper getPrePullAppInfoWrapperById(String paramString1, String paramString2)
  {
    HashMap localHashMap = prePullAppInfoMapForId;
    if (localHashMap != null)
    {
      paramString1 = (MiniAppPrePullManager.MiniAppInfoPrePullWrapper)localHashMap.get(paramString1);
      if (paramString1 != null) {
        if (paramString2 == null)
        {
          if (paramString1.getEntryPath() == null) {
            return paramString1;
          }
        }
        else if (paramString2.equals(paramString1.getEntryPath())) {
          return paramString1;
        }
      }
    }
    return null;
  }
  
  private MiniAppPrePullManager.MiniAppInfoPrePullWrapper getPrePullAppInfoWrapperByLink(String paramString)
  {
    HashMap localHashMap = prePullAppInfoMapForLink;
    if (localHashMap != null) {
      return (MiniAppPrePullManager.MiniAppInfoPrePullWrapper)localHashMap.get(paramString);
    }
    return null;
  }
  
  public void prePullAppinfoById(String paramString1, String paramString2, IPrePullListener paramIPrePullListener)
  {
    prePullAppinfoById(paramString1, paramString2, "release", paramIPrePullListener);
  }
  
  public void prePullAppinfoById(String paramString1, String paramString2, String paramString3, IPrePullListener paramIPrePullListener)
  {
    if (!enablePrePull) {
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("prePullAppinfoById, entryPath = ");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append(",envVersion = ");
    ((StringBuilder)localObject).append(paramString3);
    QLog.d("MiniAppPrePullManager", 1, ((StringBuilder)localObject).toString());
    localObject = getPrePullAppInfoWrapperById(paramString1, paramString2);
    if ((localObject != null) && (System.currentTimeMillis() - ((MiniAppPrePullManager.MiniAppInfoPrePullWrapper)localObject).getPullTimeStamp() < INTERVAL_TIME))
    {
      paramString2 = new StringBuilder();
      paramString2.append("prePullAppinfoById suc, has been preload, appInfo = ");
      paramString2.append(((MiniAppPrePullManager.MiniAppInfoPrePullWrapper)localObject).appId);
      QLog.d("MiniAppPrePullManager", 1, paramString2.toString());
      if (paramIPrePullListener != null)
      {
        paramString2 = new JSONObject();
        try
        {
          paramString2.put("retCode", 0);
          paramString3 = new StringBuilder();
          paramString3.append("appid:");
          paramString3.append(paramString1);
          paramString3.append(", has benn preloaded");
          paramString2.put("errMsg", paramString3.toString());
          paramIPrePullListener.onPrePullCallback(true, paramString2);
          return;
        }
        catch (JSONException paramString1)
        {
          paramString1.printStackTrace();
        }
      }
      return;
    }
    MiniAppCmdUtil.getInstance().getAppInfoById(null, paramString1, paramString2, paramString3, new MiniAppPrePullManager.2(this, paramString1, paramString2, paramIPrePullListener));
  }
  
  public void prePullAppinfoByLink(String paramString, int paramInt, boolean paramBoolean, IPrePullListener paramIPrePullListener)
  {
    if (!enablePrePull) {
      return;
    }
    Object localObject1 = BaseApplicationImpl.getApplication().getQQProcessName();
    if ((localObject1 != null) && (!((String)localObject1).equals("com.tencent.mobileqq")))
    {
      paramIPrePullListener = new StringBuilder();
      paramIPrePullListener.append("prePullAppinfoByLink need to change process: ");
      paramIPrePullListener.append((String)localObject1);
      paramIPrePullListener.append(", link = ");
      paramIPrePullListener.append(paramString);
      paramIPrePullListener.append(",linkType = ");
      paramIPrePullListener.append(paramInt);
      QLog.d("MiniAppPrePullManager", 1, paramIPrePullListener.toString());
      paramIPrePullListener = new Bundle();
      paramIPrePullListener.putString("miniapp_preload_link", paramString);
      paramIPrePullListener.putInt("miniapp_preload_link_type", paramInt);
      paramIPrePullListener.putBoolean("miniapp_repload_with_package_and_cache_preload", paramBoolean);
      QIPCClientHelper.getInstance().getClient().callServer("QzoneIPCModule", "action_pre_pull_mini_app", paramIPrePullListener);
      return;
    }
    localObject1 = paramString;
    int i = paramInt;
    Object localObject2;
    String str;
    if (paramString.startsWith("mqqapi://microapp/open?"))
    {
      localObject1 = new HashMap();
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[miniapp-scheme-prepull], open microapp scheme=");
        ((StringBuilder)localObject2).append(paramString);
        QLog.d("MiniAppPrePullManager", 2, ((StringBuilder)localObject2).toString());
      }
      localObject2 = paramString.split("\\?");
      if ((localObject2.length >= 2) && (localObject2[0].length() != 0))
      {
        localObject2 = paramString.substring(localObject2[0].length() + 1).split("&");
        if (localObject2 != null)
        {
          i = 0;
          while (i < localObject2.length)
          {
            String[] arrayOfString = localObject2[i].split("=");
            if ((arrayOfString != null) && (arrayOfString.length == 2))
            {
              ((HashMap)localObject1).put(arrayOfString[0], arrayOfString[1]);
              if (QLog.isColorLevel())
              {
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append("[miniapp-scheme-prepull], open microapp key=");
                localStringBuilder.append(arrayOfString[0]);
                localStringBuilder.append(", value=");
                localStringBuilder.append(arrayOfString[1]);
                QLog.d("MiniAppPrePullManager", 2, localStringBuilder.toString());
              }
            }
            i += 1;
          }
        }
        localObject1 = (String)((HashMap)localObject1).get("url");
        try
        {
          localObject1 = URLDecoder.decode((String)localObject1, "UTF-8");
          i = 0;
        }
        catch (Exception localException)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("prePullAppinfoByLink decode url get an Exception, ");
          ((StringBuilder)localObject2).append(localException);
          QLog.e("MiniAppPrePullManager", 1, ((StringBuilder)localObject2).toString());
          str = paramString;
          i = paramInt;
        }
      }
      else
      {
        paramIPrePullListener = new StringBuilder();
        paramIPrePullListener.append("[miniapp-scheme-prepull], scheme format err, scheme=");
        paramIPrePullListener.append(paramString);
        QLog.e("MiniAppPrePullManager", 1, paramIPrePullListener.toString());
        return;
      }
    }
    paramString = new StringBuilder();
    paramString.append("prePullAppinfoByLink, link = ");
    paramString.append(str);
    paramString.append(",linkType = ");
    paramString.append(i);
    QLog.d("MiniAppPrePullManager", 1, paramString.toString());
    paramString = getPrePullAppInfoWrapperByLink(str);
    if ((paramString != null) && (System.currentTimeMillis() - paramString.getPullTimeStamp() < INTERVAL_TIME))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("prePullAppinfoByLink suc, has been preload, appId = ");
      ((StringBuilder)localObject2).append(paramString.appId);
      QLog.d("MiniAppPrePullManager", 1, ((StringBuilder)localObject2).toString());
      if (paramIPrePullListener != null)
      {
        paramString = new JSONObject();
        try
        {
          paramString.put("retCode", 0);
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("link:");
          ((StringBuilder)localObject2).append(str);
          ((StringBuilder)localObject2).append(", has benn preloaded");
          paramString.put("errMsg", ((StringBuilder)localObject2).toString());
          paramIPrePullListener.onPrePullCallback(true, paramString);
          return;
        }
        catch (JSONException paramString)
        {
          paramString.printStackTrace();
        }
      }
      return;
    }
    MiniAppCmdUtil.getInstance().getAppInfoByLink(str, i, new MiniAppPrePullManager.3(this, str, paramBoolean, paramIPrePullListener));
  }
  
  public void prePullAppinfoByLink(String paramString, boolean paramBoolean, IPrePullListener paramIPrePullListener)
  {
    if ((paramString != null) && (paramString.startsWith("mqqapi://miniapp/")))
    {
      prePullAppinfoByLink(paramString, 2, paramBoolean, paramIPrePullListener);
      return;
    }
    if ((paramString != null) && (paramString.contains("fakeUrl")))
    {
      prePullAppinfoByLink(paramString, 0, paramBoolean, paramIPrePullListener);
      return;
    }
    if (paramString != null) {
      prePullAppinfoByLink(paramString, 1, paramBoolean, paramIPrePullListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppPrePullManager
 * JD-Core Version:    0.7.0.1
 */