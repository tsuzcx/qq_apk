package com.tencent.thumbplayer.core.downloadproxy.api;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkRequest.Builder;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.thumbplayer.core.downloadproxy.apiinner.TPListenerManager;
import com.tencent.thumbplayer.core.downloadproxy.jni.TPDownloadProxyNative;
import com.tencent.thumbplayer.core.downloadproxy.net.NetworkChangeNotifier;
import com.tencent.thumbplayer.core.downloadproxy.utils.TPDLFileSystem;
import com.tencent.thumbplayer.core.downloadproxy.utils.TPDLProxyLog;
import com.tencent.thumbplayer.core.downloadproxy.utils.TPDLProxyUtils;
import java.io.File;

public class TPDownloadProxy
  implements ITPDownloadProxy
{
  private static final String FILE_NAME = "TPDownloadProxy";
  private Context mContext = null;
  private String mCurrentStoragePath = "";
  private boolean mIsInit = false;
  private int mServiceType;
  
  public TPDownloadProxy(int paramInt)
  {
    this.mServiceType = paramInt;
  }
  
  private void getCellularNetwork(Context paramContext)
  {
    if (paramContext == null)
    {
      TPDLProxyLog.i("TPDownloadProxy", 0, "tpdlnative", "cellular_network context is null, can not set interface 4g");
      return;
    }
    if (Build.VERSION.SDK_INT >= 23)
    {
      NetworkRequest.Builder localBuilder = new NetworkRequest.Builder();
      localBuilder.addCapability(12);
      localBuilder.addTransportType(0);
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (paramContext == null) {
        return;
      }
      paramContext.requestNetwork(localBuilder.build(), new TPDownloadProxy.1(this));
    }
  }
  
  public int deinit()
  {
    if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
      try
      {
        this.mIsInit = false;
        int i = TPDownloadProxyNative.getInstance().deInitService(this.mServiceType);
        return i;
      }
      catch (Throwable localThrowable)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("deinit failed, error:");
        localStringBuilder.append(localThrowable.toString());
        TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", localStringBuilder.toString());
      }
    }
    return -1;
  }
  
  public String getClipPlayUrl(int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool = TPDownloadProxyNative.getInstance().isNativeLoaded();
    String str2 = "";
    String str1 = str2;
    if (bool)
    {
      str1 = str2;
      try
      {
        str2 = TPDLProxyUtils.byteArrayToString(TPDownloadProxyNative.getInstance().getClipPlayUrl(paramInt1, paramInt2, paramInt3));
        str1 = str2;
        if (paramInt3 != 2)
        {
          str1 = str2;
          TPDownloadProxyNative.getInstance().startDownload(paramInt1);
          return str2;
        }
      }
      catch (Throwable localThrowable)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getClipPlayUrl failed, error:");
        localStringBuilder.append(localThrowable.toString());
        TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", localStringBuilder.toString());
      }
    }
    return str1;
  }
  
  public String getNativeInfo(int paramInt)
  {
    if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
      return TPDLProxyUtils.byteArrayToString(TPDownloadProxyNative.getInstance().getNativeInfo(paramInt));
    }
    return null;
  }
  
  public String getPlayErrorCodeStr(int paramInt)
  {
    if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
      try
      {
        String str = TPDLProxyUtils.byteArrayToString(TPDownloadProxyNative.getInstance().getErrorCodeStr(paramInt));
        return str;
      }
      catch (Throwable localThrowable)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getPlayErrorCodeStr failed, error:");
        localStringBuilder.append(localThrowable.toString());
        TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", localStringBuilder.toString());
      }
    }
    return "";
  }
  
  public String getPlayUrl(int paramInt1, int paramInt2)
  {
    boolean bool = TPDownloadProxyNative.getInstance().isNativeLoaded();
    String str2 = "";
    String str1 = str2;
    if (bool)
    {
      str1 = str2;
      try
      {
        str2 = TPDLProxyUtils.byteArrayToString(TPDownloadProxyNative.getInstance().getClipPlayUrl(paramInt1, 1, paramInt2));
        str1 = str2;
        if (paramInt2 != 2)
        {
          str1 = str2;
          TPDownloadProxyNative.getInstance().startDownload(paramInt1);
          return str2;
        }
      }
      catch (Throwable localThrowable)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getPlayUrl failed, error:");
        localStringBuilder.append(localThrowable.toString());
        TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", localStringBuilder.toString());
      }
    }
    return str1;
  }
  
  public int init(Context paramContext, TPDLProxyInitParam paramTPDLProxyInitParam)
  {
    try
    {
      if (this.mIsInit)
      {
        TPDLProxyLog.i("TPDownloadProxy", 0, "tpdlnative", "download already init");
        return 0;
      }
      TPDownloadProxyNative.getInstance().setAppContext(paramContext);
      boolean bool = TPDownloadProxyNative.getInstance().isNativeLoaded();
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
          String str2 = paramTPDLProxyInitParam.getCacheDir();
          bool = TextUtils.isEmpty(str2);
          String str1 = str2;
          if (bool)
          {
            str1 = str2;
            if (paramContext != null) {
              try
              {
                localObject2 = TPDLFileSystem.getProperCacheDirectory(paramContext, "download");
                str1 = str2;
                if (localObject2 != null) {
                  str1 = ((File)localObject2).getAbsolutePath();
                }
              }
              catch (Throwable localThrowable)
              {
                Object localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("init get cache dir failed, error:");
                ((StringBuilder)localObject2).append(localThrowable.toString());
                TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", ((StringBuilder)localObject2).toString());
                localObject1 = str2;
              }
            }
          }
          TPListenerManager.getInstance().initHandler();
          int i;
          if ((TextUtils.isEmpty(paramTPDLProxyInitParam.getDataDir())) && (!TextUtils.isEmpty(this.mCurrentStoragePath)))
          {
            i = TPDownloadProxyNative.getInstance().initService(this.mServiceType, (String)localObject1, this.mCurrentStoragePath, paramTPDLProxyInitParam.getConfigStr());
          }
          else
          {
            if (!TextUtils.isEmpty(paramTPDLProxyInitParam.getDataDir())) {
              this.mCurrentStoragePath = paramTPDLProxyInitParam.getDataDir();
            }
            i = TPDownloadProxyNative.getInstance().initService(this.mServiceType, (String)localObject1, paramTPDLProxyInitParam.getDataDir(), paramTPDLProxyInitParam.getConfigStr());
          }
          NetworkChangeNotifier.registerToReceiveNotificationsAlways();
          paramTPDLProxyInitParam = new IntentFilter();
          paramTPDLProxyInitParam.addAction("android.intent.action.SCREEN_OFF");
          paramTPDLProxyInitParam.addAction("android.intent.action.SCREEN_ON");
          paramTPDLProxyInitParam.addAction("android.intent.action.USER_PRESENT");
          Object localObject1 = new TPDownloadProxy.2(this);
          if (paramContext != null) {
            paramContext.registerReceiver((BroadcastReceiver)localObject1, paramTPDLProxyInitParam);
          }
          if (i == 0) {
            this.mIsInit = true;
          }
          this.mContext = paramContext;
          return i;
        }
        catch (Throwable paramContext)
        {
          paramTPDLProxyInitParam = new StringBuilder();
          paramTPDLProxyInitParam.append("init failed, error:");
          paramTPDLProxyInitParam.append(paramContext.toString());
          TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", paramTPDLProxyInitParam.toString());
        }
      }
      return -1;
    }
    finally {}
  }
  
  public int pauseDownload(int paramInt)
  {
    if (paramInt <= 0) {
      return -1;
    }
    if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
      try
      {
        paramInt = TPDownloadProxyNative.getInstance().pauseDownload(paramInt);
        return paramInt;
      }
      catch (Throwable localThrowable)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("pauseDownload failed, error:");
        localStringBuilder.append(localThrowable.toString());
        TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", localStringBuilder.toString());
      }
    }
    return -1;
  }
  
  public void pushEvent(int paramInt)
  {
    if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
      try
      {
        TPDownloadProxyNative.getInstance().pushEvent(paramInt);
        if (9 == paramInt)
        {
          TPDLProxyLog.i("TPDownloadProxy", 0, "tpdlnative", "cellular_network new change, update net interface info");
          getCellularNetwork(this.mContext);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("cellular_network pushEvent failed, error:");
        localStringBuilder.append(localThrowable.toString());
        TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", localStringBuilder.toString());
      }
    }
  }
  
  public int removeStorageCache(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return -1;
    }
    if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
      try
      {
        int i = TPDownloadProxyNative.getInstance().deleteCache(this.mCurrentStoragePath, paramString);
        return i;
      }
      catch (Throwable paramString)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("deleteCache failed, error:");
        localStringBuilder.append(paramString.toString());
        TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", localStringBuilder.toString());
      }
    }
    return -1;
  }
  
  public int resumeDownload(int paramInt)
  {
    if (paramInt <= 0) {
      return -1;
    }
    if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
      try
      {
        paramInt = TPDownloadProxyNative.getInstance().resumeDownload(paramInt);
        return paramInt;
      }
      catch (Throwable localThrowable)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("resumeDownload failed, error:");
        localStringBuilder.append(localThrowable.toString());
        TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", localStringBuilder.toString());
      }
    }
    return -1;
  }
  
  public void setBusinessDownloadStrategy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
      try
      {
        TPDownloadProxyNative.getInstance().setBusinessDownloadStrategy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
        return;
      }
      catch (Throwable localThrowable)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setBusinessDownloadStrategy failed, error:");
        localStringBuilder.append(localThrowable.toString());
        TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", localStringBuilder.toString());
      }
    }
  }
  
  public boolean setClipInfo(int paramInt1, int paramInt2, String paramString, TPDownloadParam paramTPDownloadParam)
  {
    int j = paramTPDownloadParam.getDlType();
    int i = j;
    if (paramTPDownloadParam.isOffline()) {
      i = j + 300;
    }
    if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
      try
      {
        paramInt1 = TPDownloadProxyNative.getInstance().setClipInfo(paramInt1, paramInt2, paramString, i, paramTPDownloadParam.getCdnUrls(), paramTPDownloadParam.getSavaPath(), paramTPDownloadParam.getExtraJsonInfo());
        if (paramInt1 >= 0) {
          return true;
        }
      }
      catch (Throwable paramString)
      {
        paramTPDownloadParam = new StringBuilder();
        paramTPDownloadParam.append("setClipInfo failed, error:");
        paramTPDownloadParam.append(paramString.toString());
        TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", paramTPDownloadParam.toString());
      }
    }
    return false;
  }
  
  public void setLogListener(ITPDLProxyLogListener paramITPDLProxyLogListener)
  {
    TPDLProxyLog.setLogListener(this.mServiceType, paramITPDLProxyLogListener);
  }
  
  public void setMaxStorageSizeMB(long paramLong)
  {
    if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
      try
      {
        TPDownloadProxyNative.getInstance().setMaxStorageSizeMB(this.mServiceType, paramLong);
        return;
      }
      catch (Throwable localThrowable)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setMaxStorageSizeMB failed, error:");
        localStringBuilder.append(localThrowable.toString());
        TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", localStringBuilder.toString());
      }
    }
  }
  
  public void setPlayState(int paramInt1, int paramInt2)
  {
    if (paramInt1 <= 0) {
      return;
    }
    if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
      try
      {
        TPDownloadProxyNative.getInstance().setPlayerState(paramInt1, paramInt2);
        return;
      }
      catch (Throwable localThrowable)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setPlayState failed, error:");
        localStringBuilder.append(localThrowable.toString());
        TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", localStringBuilder.toString());
      }
    }
  }
  
  public void setUpdatePlayerInfoInterval(int paramInt)
  {
    TPListenerManager.getInstance().setUpdatePlayerInfoInterval(paramInt);
  }
  
  public void setUserData(String paramString, Object paramObject)
  {
    if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {}
    for (;;)
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
        if (paramString.equalsIgnoreCase("guid"))
        {
          TPDownloadProxyNative.getInstance().setUserData("guid", (String)paramObject);
          return;
        }
        if (paramString.equalsIgnoreCase("qq_is_vip"))
        {
          TPDownloadProxyNative localTPDownloadProxyNative = TPDownloadProxyNative.getInstance();
          if (!((Boolean)paramObject).booleanValue()) {
            break label238;
          }
          paramString = "1";
          localTPDownloadProxyNative.setUserData("qq_is_vip", paramString);
          return;
        }
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
        if (paramString.equalsIgnoreCase("proxy_config"))
        {
          TPDownloadProxyNative.getInstance().setUserData("proxy_config", paramObject.toString());
          return;
        }
        TPDownloadProxyNative.getInstance().setUserData(paramString, paramObject.toString());
        return;
      }
      catch (Throwable paramString)
      {
        paramObject = new StringBuilder();
        paramObject.append("setUserData failed, error:");
        paramObject.append(paramString.toString());
        TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", paramObject.toString());
      }
      return;
      label238:
      paramString = "0";
    }
  }
  
  public int startClipOfflineDownload(String paramString, int paramInt, ITPOfflineDownloadListener paramITPOfflineDownloadListener)
  {
    boolean bool = TPDownloadProxyNative.getInstance().isNativeLoaded();
    int i = -1;
    int j = i;
    if (bool) {
      try
      {
        paramInt = TPDownloadProxyNative.getInstance().createDownloadTask(this.mServiceType, paramString, 102, paramInt);
        i = paramInt;
        TPListenerManager.getInstance().setOfflineDownloadListener(paramInt, paramITPOfflineDownloadListener);
        return paramInt;
      }
      catch (Throwable paramString)
      {
        paramITPOfflineDownloadListener = new StringBuilder();
        paramITPOfflineDownloadListener.append("startClipOfflineDownload failed, error:");
        paramITPOfflineDownloadListener.append(paramString.toString());
        TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", paramITPOfflineDownloadListener.toString());
        j = i;
      }
    }
    return j;
  }
  
  public int startClipPlay(String paramString, int paramInt, ITPPlayListener paramITPPlayListener)
  {
    boolean bool = TPDownloadProxyNative.getInstance().isNativeLoaded();
    int i = -1;
    int j = i;
    if (bool) {
      try
      {
        paramInt = TPDownloadProxyNative.getInstance().createDownloadTask(this.mServiceType, paramString, 2, paramInt);
        i = paramInt;
        TPListenerManager.getInstance().setPlayListener(paramInt, paramITPPlayListener);
        return paramInt;
      }
      catch (Throwable paramString)
      {
        paramITPPlayListener = new StringBuilder();
        paramITPPlayListener.append("startClipPlay failed, error:");
        paramITPPlayListener.append(paramString.toString());
        TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", paramITPPlayListener.toString());
        j = i;
      }
    }
    return j;
  }
  
  public int startOfflineDownload(String paramString, TPDownloadParam paramTPDownloadParam, ITPOfflineDownloadListener paramITPOfflineDownloadListener)
  {
    boolean bool = TPDownloadProxyNative.getInstance().isNativeLoaded();
    int i = -1;
    int j = i;
    if (bool)
    {
      try
      {
        int k = paramTPDownloadParam.getDlType() + 100;
        j = TPDownloadProxyNative.getInstance().createDownloadTask(this.mServiceType, paramString, k, paramTPDownloadParam.getClipCount());
        try
        {
          TPListenerManager.getInstance().setOfflineDownloadListener(j, paramITPOfflineDownloadListener);
          if (!TextUtils.isEmpty(paramTPDownloadParam.getKeyid())) {
            paramString = paramTPDownloadParam.getKeyid();
          }
          TPDownloadProxyNative.getInstance().setClipInfo(j, paramTPDownloadParam.getClipNo(), paramString, k, paramTPDownloadParam.getCdnUrls(), paramTPDownloadParam.getSavaPath(), paramTPDownloadParam.getExtraJsonInfo());
          return j;
        }
        catch (Throwable paramString)
        {
          i = j;
        }
        paramTPDownloadParam = new StringBuilder();
      }
      catch (Throwable paramString) {}
      paramTPDownloadParam.append("stopOfflineDownload failed, error:");
      paramTPDownloadParam.append(paramString.toString());
      TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", paramTPDownloadParam.toString());
      j = i;
    }
    return j;
  }
  
  public int startPlay(String paramString, TPDownloadParam paramTPDownloadParam, ITPPlayListener paramITPPlayListener)
  {
    int j = paramTPDownloadParam.getDlType();
    int i = j;
    if (paramTPDownloadParam.isOffline()) {
      i = j + 300;
    }
    boolean bool = TPDownloadProxyNative.getInstance().isNativeLoaded();
    j = -1;
    int k = j;
    if (bool)
    {
      k = i;
      try
      {
        if (paramTPDownloadParam.isAdaptive())
        {
          k = i;
          if (i == 3) {
            k = i + 400;
          }
        }
        i = TPDownloadProxyNative.getInstance().createDownloadTask(this.mServiceType, paramString, k, paramTPDownloadParam.getClipCount());
        try
        {
          if (!TextUtils.isEmpty(paramTPDownloadParam.getKeyid())) {
            paramString = paramTPDownloadParam.getKeyid();
          }
          TPDownloadProxyNative.getInstance().setClipInfo(i, paramTPDownloadParam.getClipNo(), paramString, k, paramTPDownloadParam.getCdnUrls(), paramTPDownloadParam.getSavaPath(), paramTPDownloadParam.getExtraJsonInfo());
          TPListenerManager.getInstance().setPlayListener(i, paramITPPlayListener);
          return i;
        }
        catch (Throwable paramString) {}
        paramTPDownloadParam = new StringBuilder();
      }
      catch (Throwable paramString)
      {
        i = j;
      }
      paramTPDownloadParam.append("startPlay failed, error:");
      paramTPDownloadParam.append(paramString.toString());
      TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", paramTPDownloadParam.toString());
      k = i;
    }
    return k;
  }
  
  public int startPreload(String paramString, TPDownloadParam paramTPDownloadParam, ITPPreLoadListener paramITPPreLoadListener)
  {
    boolean bool = TPDownloadProxyNative.getInstance().isNativeLoaded();
    int i = -1;
    int j = i;
    if (bool)
    {
      try
      {
        int k = paramTPDownloadParam.getDlType() + 200;
        j = TPDownloadProxyNative.getInstance().createDownloadTask(this.mServiceType, paramString, k, paramTPDownloadParam.getClipCount());
        try
        {
          TPListenerManager.getInstance().setPreLoadListener(j, paramITPPreLoadListener);
          if (!TextUtils.isEmpty(paramTPDownloadParam.getKeyid())) {
            paramString = paramTPDownloadParam.getKeyid();
          }
          TPDownloadProxyNative.getInstance().setClipInfo(j, paramTPDownloadParam.getClipNo(), paramString, k, paramTPDownloadParam.getCdnUrls(), paramTPDownloadParam.getSavaPath(), paramTPDownloadParam.getExtraJsonInfo());
          TPDownloadProxyNative.getInstance().startDownload(j);
          return j;
        }
        catch (Throwable paramString)
        {
          i = j;
        }
        paramTPDownloadParam = new StringBuilder();
      }
      catch (Throwable paramString) {}
      paramTPDownloadParam.append("startPreload failed, error:");
      paramTPDownloadParam.append(paramString.toString());
      TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", paramTPDownloadParam.toString());
      j = i;
    }
    return j;
  }
  
  public void startTask(int paramInt)
  {
    if (paramInt <= 0) {
      return;
    }
    if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
      try
      {
        TPDownloadProxyNative.getInstance().startDownload(paramInt);
        return;
      }
      catch (Throwable localThrowable)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("startTask failed, error:");
        localStringBuilder.append(localThrowable.toString());
        TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", localStringBuilder.toString());
      }
    }
  }
  
  public void stopOfflineDownload(int paramInt)
  {
    if (paramInt <= 0) {
      return;
    }
    if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
      try
      {
        TPDownloadProxyNative.getInstance().stopDownload(paramInt);
        TPListenerManager.getInstance().removeOfflineDownloadListener(paramInt);
        return;
      }
      catch (Throwable localThrowable)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("stopOfflineDownload failed, error:");
        localStringBuilder.append(localThrowable.toString());
        TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", localStringBuilder.toString());
      }
    }
  }
  
  public void stopPlay(int paramInt)
  {
    if (paramInt <= 0) {
      return;
    }
    if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
      try
      {
        TPDownloadProxyNative.getInstance().stopDownload(paramInt);
        TPListenerManager.getInstance().removePlayListener(paramInt);
        return;
      }
      catch (Throwable localThrowable)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("stopPlay failed, error:");
        localStringBuilder.append(localThrowable.toString());
        TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", localStringBuilder.toString());
      }
    }
  }
  
  public void stopPreload(int paramInt)
  {
    if (paramInt <= 0) {
      return;
    }
    if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
      try
      {
        TPDownloadProxyNative.getInstance().stopDownload(paramInt);
        TPListenerManager.getInstance().removePreLoadListener(paramInt);
        return;
      }
      catch (Throwable localThrowable)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("stopPreload failed, error:");
        localStringBuilder.append(localThrowable.toString());
        TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", localStringBuilder.toString());
      }
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateStoragePath failed, error:");
      localStringBuilder.append(paramString.toString());
      TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxy
 * JD-Core Version:    0.7.0.1
 */