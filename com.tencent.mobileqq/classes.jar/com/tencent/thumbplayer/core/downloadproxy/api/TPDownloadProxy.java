package com.tencent.thumbplayer.core.downloadproxy.api;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.tencent.thumbplayer.core.downloadproxy.apiinner.TPListenerManager;
import com.tencent.thumbplayer.core.downloadproxy.apiinner.TPProxyAdapterManager;
import com.tencent.thumbplayer.core.downloadproxy.jni.TPDownloadProxyNative;
import com.tencent.thumbplayer.core.downloadproxy.utils.TPDLFileSystem;
import com.tencent.thumbplayer.core.downloadproxy.utils.TPDLProxyLog;
import com.tencent.thumbplayer.core.downloadproxy.utils.TPDLProxyUtils;
import java.io.File;

public class TPDownloadProxy
  implements ITPDownloadProxy
{
  private static final String FILE_NAME = "TPDownloadProxy";
  private boolean IsInit = false;
  private String mCurrentStoragePath;
  private int mServiceType;
  
  public TPDownloadProxy(int paramInt)
  {
    this.mServiceType = paramInt;
  }
  
  public int deinit()
  {
    if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
      try
      {
        int i = TPDownloadProxyNative.getInstance().deInitService(this.mServiceType);
        return i;
      }
      catch (Throwable localThrowable)
      {
        TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", "deinit failed, error:" + localThrowable.toString());
      }
    }
    return -1;
  }
  
  public String getClipPlayUrl(int paramInt1, int paramInt2)
  {
    Object localObject1 = TPProxyAdapterManager.getInstance().getProxyClipUrl(paramInt1, paramInt2);
    Object localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject2 = localObject1;
      if (!TPDownloadProxyNative.getInstance().isNativeLoaded()) {}
    }
    try
    {
      localObject2 = TPDLProxyUtils.byteArrayToString(TPDownloadProxyNative.getInstance().getClipPlayUrl(paramInt1, paramInt2));
      localObject1 = localObject2;
      TPDownloadProxyNative.getInstance().startDownload(paramInt1);
      return localObject2;
    }
    catch (Throwable localThrowable)
    {
      TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", "getClipPlayUrl failed, error:" + localThrowable.toString());
    }
    return localObject1;
  }
  
  public String getPlayErrorCodeStr(int paramInt)
  {
    String str = "";
    if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {}
    try
    {
      str = TPDLProxyUtils.byteArrayToString(TPDownloadProxyNative.getInstance().getErrorCodeStr(paramInt));
      return str;
    }
    catch (Throwable localThrowable)
    {
      TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", "getPlayErrorCodeStr failed, error:" + localThrowable.toString());
    }
    return "";
  }
  
  public String getPlayUrl(int paramInt)
  {
    Object localObject1 = TPProxyAdapterManager.getInstance().getProxyClipUrl(paramInt, 1);
    Object localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject2 = localObject1;
      if (!TPDownloadProxyNative.getInstance().isNativeLoaded()) {}
    }
    try
    {
      localObject2 = TPDLProxyUtils.byteArrayToString(TPDownloadProxyNative.getInstance().getClipPlayUrl(paramInt, 1));
      localObject1 = localObject2;
      TPDownloadProxyNative.getInstance().startDownload(paramInt);
      return localObject2;
    }
    catch (Throwable localThrowable)
    {
      TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", "getPlayUrl failed, error:" + localThrowable.toString());
    }
    return localObject1;
  }
  
  public int init(Context paramContext, TPDLProxyInitParam paramTPDLProxyInitParam)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        if (this.IsInit)
        {
          TPDLProxyLog.i("TPDownloadProxy", 0, "tpdlnative", "download already init");
          return i;
        }
        boolean bool = TPDownloadProxyNative.getInstance().isNativeLoaded();
        String str2;
        int j;
        if (bool) {
          try
          {
            if (!TextUtils.isEmpty(paramTPDLProxyInitParam.getAppVer())) {
              setUserData("app_version_name", paramTPDLProxyInitParam.getAppVer());
            }
            if (paramTPDLProxyInitParam.getPlatform() > 0) {
              setUserData("platform", Integer.valueOf(paramTPDLProxyInitParam.getPlatform()));
            }
            if (!TextUtils.isEmpty(paramTPDLProxyInitParam.getGuid())) {
              setUserData("guid", paramTPDLProxyInitParam.getGuid());
            }
            str2 = paramTPDLProxyInitParam.getCacheDir();
            bool = TextUtils.isEmpty(str2);
            localObject = str2;
            if (bool)
            {
              localObject = str2;
              if (paramContext == null) {}
            }
          }
          catch (Throwable paramContext)
          {
            Object localObject;
            File localFile;
            TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", "init failed, error:" + paramContext.toString());
          }
        }
        try
        {
          localFile = TPDLFileSystem.getProperCacheDirectory(paramContext, "download");
          localObject = str2;
          if (localFile != null) {
            localObject = localFile.getAbsolutePath();
          }
        }
        catch (Throwable localThrowable)
        {
          TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", "init get cache dir failed, error:" + localThrowable.toString());
          str1 = str2;
          continue;
        }
        TPListenerManager.getInstance().initHandler();
        if ((TextUtils.isEmpty(paramTPDLProxyInitParam.getDataDir())) && (!TextUtils.isEmpty(this.mCurrentStoragePath)))
        {
          j = TPDownloadProxyNative.getInstance().initService(this.mServiceType, (String)localObject, this.mCurrentStoragePath, paramTPDLProxyInitParam.getConfigDir());
          paramTPDLProxyInitParam = new IntentFilter();
          paramTPDLProxyInitParam.addAction("android.intent.action.SCREEN_OFF");
          paramTPDLProxyInitParam.addAction("android.intent.action.SCREEN_ON");
          paramTPDLProxyInitParam.addAction("android.intent.action.USER_PRESENT");
          localObject = new TPDownloadProxy.1(this);
          if (paramContext != null) {
            paramContext.registerReceiver((BroadcastReceiver)localObject, paramTPDLProxyInitParam);
          }
          i = j;
          if (j == 0)
          {
            this.IsInit = true;
            i = j;
            continue;
            i = -1;
          }
        }
        else
        {
          String str1;
          j = TPDownloadProxyNative.getInstance().initService(this.mServiceType, str1, paramTPDLProxyInitParam.getDataDir(), paramTPDLProxyInitParam.getConfigDir());
        }
      }
      finally {}
    }
  }
  
  public int pauseDownload(int paramInt)
  {
    if (paramInt <= 0) {}
    while (!TPDownloadProxyNative.getInstance().isNativeLoaded()) {
      return -1;
    }
    try
    {
      paramInt = TPDownloadProxyNative.getInstance().pauseDownload(paramInt);
      return paramInt;
    }
    catch (Throwable localThrowable)
    {
      TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", "pauseDownload failed, error:" + localThrowable.toString());
    }
    return -1;
  }
  
  public void pushEvent(int paramInt)
  {
    if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {}
    try
    {
      TPDownloadProxyNative.getInstance().pushEvent(paramInt);
      return;
    }
    catch (Throwable localThrowable)
    {
      TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", "pushEvent failed, error:" + localThrowable.toString());
    }
  }
  
  public int removeOfflineDownload(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (!TPDownloadProxyNative.getInstance().isNativeLoaded()) {
      return -1;
    }
    try
    {
      int i = TPDownloadProxyNative.getInstance().deleteOfflineCache(paramString);
      return i;
    }
    catch (Throwable paramString)
    {
      TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", "removeOfflineDownload failed, error:" + paramString.toString());
    }
    return -1;
  }
  
  public int resumeDownload(int paramInt)
  {
    if (paramInt <= 0) {}
    while (!TPDownloadProxyNative.getInstance().isNativeLoaded()) {
      return -1;
    }
    try
    {
      paramInt = TPDownloadProxyNative.getInstance().resumeDownload(paramInt);
      return paramInt;
    }
    catch (Throwable localThrowable)
    {
      TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", "resumeDownload failed, error:" + localThrowable.toString());
    }
    return -1;
  }
  
  public boolean setClipInfo(int paramInt1, int paramInt2, String paramString, TPDownloadParam paramTPDownloadParam)
  {
    boolean bool = false;
    int j = paramTPDownloadParam.getDlType();
    int i = j;
    if (paramTPDownloadParam.isOffline()) {
      i = j + 300;
    }
    if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {}
    try
    {
      paramInt1 = TPDownloadProxyNative.getInstance().setClipInfo(paramInt1, paramInt2, paramString, i, paramTPDownloadParam.getCdnUrls(), paramTPDownloadParam.getSavaPath(), paramTPDownloadParam.getExtraJsonInfo());
      if (paramInt1 >= 0) {}
      for (bool = true;; bool = false) {
        return bool;
      }
      return false;
    }
    catch (Throwable paramString)
    {
      TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", "setClipInfo failed, error:" + paramString.toString());
    }
  }
  
  public void setLogListener(ITPDLProxyLogListener paramITPDLProxyLogListener)
  {
    TPDLProxyLog.setLogListener(this.mServiceType, paramITPDLProxyLogListener);
  }
  
  public void setMaxStorageSizeMB(long paramLong)
  {
    if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {}
    try
    {
      TPDownloadProxyNative.getInstance().setMaxStorageSizeMB(this.mServiceType, paramLong);
      return;
    }
    catch (Throwable localThrowable)
    {
      TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", "setMaxStorageSizeMB failed, error:" + localThrowable.toString());
    }
  }
  
  public void setPlayState(int paramInt1, int paramInt2)
  {
    if (paramInt1 <= 0) {}
    while (!TPDownloadProxyNative.getInstance().isNativeLoaded()) {
      return;
    }
    try
    {
      TPDownloadProxyNative.getInstance().setPlayerState(paramInt1, paramInt2);
      return;
    }
    catch (Throwable localThrowable)
    {
      TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", "setPlayState failed, error:" + localThrowable.toString());
    }
  }
  
  public void setUserData(String paramString, Object paramObject)
  {
    TPDownloadProxyNative localTPDownloadProxyNative;
    if (TPDownloadProxyNative.getInstance().isNativeLoaded())
    {
      try
      {
        if (paramString.equalsIgnoreCase("app_version_name"))
        {
          TPDownloadProxyNative.getInstance().setUserData("app_version_name", (String)paramObject);
          return;
        }
        if (paramString.equalsIgnoreCase("platform"))
        {
          TPDownloadProxyNative.getInstance().setUserData("platform", paramObject.toString());
          return;
        }
      }
      catch (Throwable paramString)
      {
        TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", "setUserData failed, error:" + paramString.toString());
        return;
      }
      if (paramString.equalsIgnoreCase("guid"))
      {
        TPDownloadProxyNative.getInstance().setUserData("guid", (String)paramObject);
        return;
      }
      if (paramString.equalsIgnoreCase("qq_is_vip"))
      {
        localTPDownloadProxyNative = TPDownloadProxyNative.getInstance();
        if (!((Boolean)paramObject).booleanValue()) {
          break label205;
        }
      }
    }
    label205:
    for (paramString = "1";; paramString = "0")
    {
      localTPDownloadProxyNative.setUserData("qq_is_vip", paramString);
      return;
      if (paramString.equalsIgnoreCase("carrier_pesudo_code"))
      {
        TPDownloadProxyNative.getInstance().setUserData("carrier_pesudo_code", (String)paramObject);
        return;
      }
      if (paramString.equalsIgnoreCase("carrier_pesudo_state"))
      {
        TPDownloadProxyNative.getInstance().setUserData("carrier_pesudo_state", paramObject.toString());
        return;
      }
      TPDownloadProxyNative.getInstance().setUserData(paramString, paramObject.toString());
      return;
    }
  }
  
  public int startClipOfflineDownload(String paramString, int paramInt, ITPOfflineDownloadListener paramITPOfflineDownloadListener)
  {
    int i = -1;
    int j = i;
    if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {}
    try
    {
      j = TPDownloadProxyNative.getInstance().createDownloadTask(this.mServiceType, paramString, 102, paramInt);
      i = j;
      TPListenerManager.getInstance().setOfflineDownloadListener(j, paramITPOfflineDownloadListener);
      return j;
    }
    catch (Throwable paramString)
    {
      TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", "startClipOfflineDownload failed, error:" + paramString.toString());
    }
    return i;
  }
  
  public int startClipPlay(String paramString, int paramInt, ITPPlayListener paramITPPlayListener)
  {
    int i = -1;
    int j = i;
    if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {}
    try
    {
      j = TPDownloadProxyNative.getInstance().createDownloadTask(this.mServiceType, paramString, 2, paramInt);
      i = j;
      TPListenerManager.getInstance().setPlayListener(j, paramITPPlayListener);
      return j;
    }
    catch (Throwable paramString)
    {
      TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", "startClipPlay failed, error:" + paramString.toString());
    }
    return i;
  }
  
  public int startOfflineDownload(String paramString, TPDownloadParam paramTPDownloadParam, ITPOfflineDownloadListener paramITPOfflineDownloadListener)
  {
    int j = -1;
    i = j;
    if (TPDownloadProxyNative.getInstance().isNativeLoaded())
    {
      i = j;
      try
      {
        int k = paramTPDownloadParam.getDlType() + 100;
        i = j;
        j = TPDownloadProxyNative.getInstance().createDownloadTask(this.mServiceType, paramString, k, paramTPDownloadParam.getClipCount());
        i = j;
        TPListenerManager.getInstance().setOfflineDownloadListener(j, paramITPOfflineDownloadListener);
        i = j;
        if (TextUtils.isEmpty(paramTPDownloadParam.getKeyid())) {}
        for (;;)
        {
          i = j;
          TPDownloadProxyNative.getInstance().setClipInfo(j, paramTPDownloadParam.getClipNo(), paramString, k, paramTPDownloadParam.getCdnUrls(), paramTPDownloadParam.getSavaPath(), paramTPDownloadParam.getExtraJsonInfo());
          return j;
          i = j;
          paramString = paramTPDownloadParam.getKeyid();
        }
        return i;
      }
      catch (Throwable paramString)
      {
        TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", "stopOfflineDownload failed, error:" + paramString.toString());
      }
    }
  }
  
  public int startPlay(String paramString, TPDownloadParam paramTPDownloadParam, ITPPlayListener paramITPPlayListener)
  {
    int k = -1;
    int j = paramTPDownloadParam.getDlType();
    int i = j;
    String str1;
    String str2;
    if (paramTPDownloadParam.isOffline())
    {
      i = j + 300;
      str1 = paramTPDownloadParam.getVid();
      str2 = paramTPDownloadParam.getPlayDefinition();
      if ((str1.isEmpty()) || (str2.isEmpty())) {
        j = -1;
      }
    }
    do
    {
      do
      {
        return j;
        if (TPDownloadProxyFactory.isReadyForDownload()) {
          break;
        }
        i = TPProxyAdapterManager.getInstance().startOnlineOrOfflinePlay(3, "", str1, str2, false, false, 0, null, paramTPDownloadParam.getOfflinePlayExtraInfo());
        j = i;
      } while (i <= 0);
      TPListenerManager.getInstance().setProxyPlayListener(i, paramITPPlayListener);
      return i;
      j = k;
    } while (!TPDownloadProxyNative.getInstance().isNativeLoaded());
    j = k;
    label282:
    for (;;)
    {
      try
      {
        if ((!paramTPDownloadParam.isAdaptive()) || (i != 3)) {
          break label282;
        }
        i += 400;
        j = k;
        k = TPDownloadProxyNative.getInstance().createDownloadTask(this.mServiceType, paramString, i, paramTPDownloadParam.getClipCount());
        j = k;
        if (TextUtils.isEmpty(paramTPDownloadParam.getKeyid()))
        {
          j = k;
          TPDownloadProxyNative.getInstance().setClipInfo(k, paramTPDownloadParam.getClipNo(), paramString, i, paramTPDownloadParam.getCdnUrls(), paramTPDownloadParam.getSavaPath(), paramTPDownloadParam.getExtraJsonInfo());
          j = k;
          TPListenerManager.getInstance().setPlayListener(k, paramITPPlayListener);
          return k;
        }
      }
      catch (Throwable paramString)
      {
        TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", "startPlay failed, error:" + paramString.toString());
        return j;
      }
      j = k;
      paramString = paramTPDownloadParam.getKeyid();
    }
  }
  
  public int startPreload(String paramString, TPDownloadParam paramTPDownloadParam, ITPPreLoadListener paramITPPreLoadListener)
  {
    int j = -1;
    i = j;
    if (TPDownloadProxyNative.getInstance().isNativeLoaded())
    {
      i = j;
      try
      {
        int k = paramTPDownloadParam.getDlType() + 200;
        i = j;
        j = TPDownloadProxyNative.getInstance().createDownloadTask(this.mServiceType, paramString, k, paramTPDownloadParam.getClipCount());
        i = j;
        TPListenerManager.getInstance().setPreLoadListener(j, paramITPPreLoadListener);
        i = j;
        if (TextUtils.isEmpty(paramTPDownloadParam.getKeyid())) {}
        for (;;)
        {
          i = j;
          TPDownloadProxyNative.getInstance().setClipInfo(j, paramTPDownloadParam.getClipNo(), paramString, k, paramTPDownloadParam.getCdnUrls(), paramTPDownloadParam.getSavaPath(), paramTPDownloadParam.getExtraJsonInfo());
          i = j;
          TPDownloadProxyNative.getInstance().startDownload(j);
          return j;
          i = j;
          paramString = paramTPDownloadParam.getKeyid();
        }
        return i;
      }
      catch (Throwable paramString)
      {
        TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", "startPreload failed, error:" + paramString.toString());
      }
    }
  }
  
  public void startTask(int paramInt)
  {
    if (paramInt <= 0) {}
    while (!TPDownloadProxyNative.getInstance().isNativeLoaded()) {
      return;
    }
    try
    {
      TPDownloadProxyNative.getInstance().startDownload(paramInt);
      return;
    }
    catch (Throwable localThrowable)
    {
      TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", "startTask failed, error:" + localThrowable.toString());
    }
  }
  
  public void stopOfflineDownload(int paramInt)
  {
    if (paramInt <= 0) {}
    while (!TPDownloadProxyNative.getInstance().isNativeLoaded()) {
      return;
    }
    try
    {
      TPDownloadProxyNative.getInstance().stopDownload(paramInt);
      TPListenerManager.getInstance().removeOfflineDownloadListener(paramInt);
      return;
    }
    catch (Throwable localThrowable)
    {
      TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", "stopOfflineDownload failed, error:" + localThrowable.toString());
    }
  }
  
  public void stopPlay(int paramInt)
  {
    if (paramInt <= 0) {}
    do
    {
      return;
      TPProxyAdapterManager.getInstance().stopPlay(paramInt);
      TPListenerManager.getInstance().removeProxyPlayListener(paramInt);
    } while (!TPDownloadProxyNative.getInstance().isNativeLoaded());
    try
    {
      TPDownloadProxyNative.getInstance().stopDownload(paramInt);
      TPListenerManager.getInstance().removePlayListener(paramInt);
      return;
    }
    catch (Throwable localThrowable)
    {
      TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", "stopPlay failed, error:" + localThrowable.toString());
    }
  }
  
  public void stopPreload(int paramInt)
  {
    if (paramInt <= 0) {}
    while (!TPDownloadProxyNative.getInstance().isNativeLoaded()) {
      return;
    }
    try
    {
      TPDownloadProxyNative.getInstance().stopDownload(paramInt);
      TPListenerManager.getInstance().removePreLoadListener(paramInt);
      return;
    }
    catch (Throwable localThrowable)
    {
      TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", "stopPreload failed, error:" + localThrowable.toString());
    }
  }
  
  public void updateStoragePath(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    try
    {
      this.mCurrentStoragePath = paramString;
      TPDownloadProxyNative.getInstance().updateStoragePath(this.mServiceType, paramString);
      return;
    }
    catch (Throwable paramString)
    {
      TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", "updateStoragePath failed, error:" + paramString.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxy
 * JD-Core Version:    0.7.0.1
 */