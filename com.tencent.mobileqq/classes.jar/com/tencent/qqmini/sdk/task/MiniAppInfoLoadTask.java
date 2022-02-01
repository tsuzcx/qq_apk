package com.tencent.qqmini.sdk.task;

import NS_MINI_INTERFACE.INTERFACE.StApiAppInfo;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.annotation.ClassTag;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppCacheProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppCacheProxy.LinkData;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.FirstPageInfo;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.runtime.BaseRuntimeLoader;
import org.json.JSONObject;

@ClassTag(tag="MiniAppInfoLoadTask")
public class MiniAppInfoLoadTask
  extends AsyncTask
{
  private static final String TAG = "MiniAppInfoLoadTask";
  private MiniAppInfo mMiniAppInfo;
  
  public MiniAppInfoLoadTask(Context paramContext, BaseRuntimeLoader paramBaseRuntimeLoader)
  {
    super(paramContext, paramBaseRuntimeLoader);
  }
  
  private boolean checkEnvVersionForCache(String paramString)
  {
    return (TextUtils.isEmpty(paramString)) || ("release".equals(paramString));
  }
  
  private void doRequestByAppId()
  {
    String str1;
    if (this.mMiniAppInfo.firstPath != null) {
      str1 = this.mMiniAppInfo.firstPath;
    }
    for (;;)
    {
      if (this.mMiniAppInfo.launchParam.envVersion == null) {}
      MiniAppCacheProxy localMiniAppCacheProxy;
      for (String str2 = "";; str2 = this.mMiniAppInfo.launchParam.envVersion)
      {
        localMiniAppCacheProxy = (MiniAppCacheProxy)ProxyManager.get(MiniAppCacheProxy.class);
        if ((localMiniAppCacheProxy == null) || (!localMiniAppCacheProxy.enableMiniAppCache()) || (!checkEnvVersionForCache(str2))) {
          break label212;
        }
        Object localObject = localMiniAppCacheProxy.getIdInfo(this.mMiniAppInfo.appId, str1);
        if (localObject == null) {
          break label212;
        }
        INTERFACE.StApiAppInfo localStApiAppInfo = new INTERFACE.StApiAppInfo();
        try
        {
          localStApiAppInfo.mergeFrom((byte[])localObject);
          localObject = MiniAppInfo.from(localStApiAppInfo);
          QMLog.d("MiniAppInfoLoadTask", "start by Id cache.");
          replaceByIdInfo((MiniAppInfo)localObject);
          onTaskSucceed();
          ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).getAppInfoById(this.mMiniAppInfo.appId, str1, str2, new MiniAppInfoLoadTask.2(this, str2, localMiniAppCacheProxy, str1));
          return;
        }
        catch (Throwable localThrowable)
        {
          QMLog.e("MiniAppInfoLoadTask", "StApiAppInfo error,", localThrowable);
        }
        if (this.mMiniAppInfo.launchParam.entryPath == null) {
          break label246;
        }
        str1 = this.mMiniAppInfo.launchParam.entryPath;
        break;
      }
      label212:
      ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).getAppInfoById(this.mMiniAppInfo.appId, str1, str2, new MiniAppInfoLoadTask.3(this, str2, localMiniAppCacheProxy, str1));
      return;
      label246:
      str1 = "";
    }
  }
  
  private void doRequestByLink()
  {
    MiniAppCacheProxy localMiniAppCacheProxy = (MiniAppCacheProxy)ProxyManager.get(MiniAppCacheProxy.class);
    if ((localMiniAppCacheProxy != null) && (localMiniAppCacheProxy.enableMiniAppCache()))
    {
      Object localObject1 = localMiniAppCacheProxy.getLinkInfo(this.mMiniAppInfo.link, this.mMiniAppInfo.linkType);
      if (localObject1 != null)
      {
        Object localObject2 = new INTERFACE.StApiAppInfo();
        try
        {
          ((INTERFACE.StApiAppInfo)localObject2).mergeFrom(((MiniAppCacheProxy.LinkData)localObject1).appInfo);
          localObject2 = MiniAppInfo.from((INTERFACE.StApiAppInfo)localObject2);
          localObject1 = ((MiniAppCacheProxy.LinkData)localObject1).shareTicket;
          QMLog.d("MiniAppInfoLoadTask", "start by Link cache.");
          replaceByLinkInfo((MiniAppInfo)localObject2, (String)localObject1);
          onTaskSucceed();
          ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).getAppInfoByLink(this.mMiniAppInfo.link, this.mMiniAppInfo.linkType, new MiniAppInfoLoadTask.4(this, localMiniAppCacheProxy));
          return;
        }
        catch (Throwable localThrowable)
        {
          QMLog.e("MiniAppInfoLoadTask", "StApiAppInfo error,", localThrowable);
        }
      }
    }
    ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).getAppInfoByLink(this.mMiniAppInfo.link, this.mMiniAppInfo.linkType, new MiniAppInfoLoadTask.5(this, localMiniAppCacheProxy));
  }
  
  private void reloadMiniAppInfoIfNeeded()
  {
    QMLog.i("MiniAppInfoLoadTask", "start executing");
    if (this.mMiniAppInfo == null)
    {
      QMLog.e("MiniAppInfoLoadTask", "MiniAppInfo must not be null");
      onTaskFailed();
      return;
    }
    if (this.mMiniAppInfo.isShortcutFakeApp())
    {
      QMLog.i("MiniAppInfoLoadTask", "Start from shortcut, download MiniAppInfo ");
      doRequestByAppId();
      return;
    }
    if (this.mMiniAppInfo.isFakeAppInfo())
    {
      if (this.mMiniAppInfo.link != null)
      {
        doRequestByLink();
        return;
      }
      doRequestByAppId();
      return;
    }
    onTaskSucceed();
  }
  
  private void replaceByIdInfo(MiniAppInfo paramMiniAppInfo)
  {
    paramMiniAppInfo.launchParam.clone(this.mMiniAppInfo.launchParam);
    paramMiniAppInfo.apkgInfo = this.mMiniAppInfo.apkgInfo;
    paramMiniAppInfo.launchParam.miniAppId = paramMiniAppInfo.appId;
    ThreadManager.executeOnNetworkIOThreadPool(new MiniAppInfoLoadTask.6(this, paramMiniAppInfo));
    if ((paramMiniAppInfo.firstPage != null) && (!TextUtils.isEmpty(paramMiniAppInfo.firstPage.pagePath)))
    {
      if (paramMiniAppInfo.firstPage.pagePath.startsWith("/")) {
        paramMiniAppInfo.firstPage.pagePath = paramMiniAppInfo.firstPage.pagePath.substring(1);
      }
      if (!paramMiniAppInfo.firstPage.pagePath.contains(".html")) {
        break label179;
      }
      paramMiniAppInfo.launchParam.entryPath = paramMiniAppInfo.firstPage.pagePath;
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(this.mMiniAppInfo.launchParam.extendData)) {
        paramMiniAppInfo.extendData = this.mMiniAppInfo.launchParam.extendData;
      }
      if (paramMiniAppInfo.verType != 3) {
        paramMiniAppInfo.forceReroad = 3;
      }
      this.mMiniAppInfo = paramMiniAppInfo;
      return;
      label179:
      if (paramMiniAppInfo.firstPage.pagePath.contains("?")) {
        paramMiniAppInfo.launchParam.entryPath = paramMiniAppInfo.firstPage.pagePath.replaceFirst("\\?", ".html\\?");
      } else {
        paramMiniAppInfo.launchParam.entryPath = (paramMiniAppInfo.firstPage.pagePath + ".html");
      }
    }
  }
  
  private void replaceByLinkInfo(MiniAppInfo paramMiniAppInfo, String paramString)
  {
    paramMiniAppInfo.launchParam.clone(this.mMiniAppInfo.launchParam);
    paramMiniAppInfo.apkgInfo = this.mMiniAppInfo.apkgInfo;
    ThreadManager.executeOnNetworkIOThreadPool(new MiniAppInfoLoadTask.7(this, paramMiniAppInfo));
    if ((paramMiniAppInfo.firstPage != null) && (!TextUtils.isEmpty(paramMiniAppInfo.firstPage.pagePath)))
    {
      if (paramMiniAppInfo.firstPage.pagePath.startsWith("/")) {
        paramMiniAppInfo.firstPage.pagePath = paramMiniAppInfo.firstPage.pagePath.substring(1);
      }
      if (paramMiniAppInfo.firstPage.pagePath.contains(".html")) {
        paramMiniAppInfo.launchParam.entryPath = paramMiniAppInfo.firstPage.pagePath;
      }
    }
    else
    {
      paramMiniAppInfo.launchParam.miniAppId = paramMiniAppInfo.appId;
      paramMiniAppInfo.launchParam.shareTicket = paramString;
      paramMiniAppInfo.launchParam.navigateExtData = paramMiniAppInfo.extraData;
      if (!TextUtils.isEmpty(paramMiniAppInfo.launchParam.shareTicket)) {
        paramMiniAppInfo.launchParam.scene = 1044;
      }
      if (!TextUtils.isEmpty(paramMiniAppInfo.launchParam.reportData)) {
        break label292;
      }
      paramMiniAppInfo.launchParam.reportData = paramMiniAppInfo.reportData;
    }
    for (;;)
    {
      if (paramMiniAppInfo.verType != 3) {
        paramMiniAppInfo.forceReroad = 3;
      }
      this.mMiniAppInfo = paramMiniAppInfo;
      return;
      if (paramMiniAppInfo.firstPage.pagePath.contains("?"))
      {
        paramMiniAppInfo.launchParam.entryPath = paramMiniAppInfo.firstPage.pagePath.replaceFirst("\\?", ".html\\?");
        break;
      }
      paramMiniAppInfo.launchParam.entryPath = (paramMiniAppInfo.firstPage.pagePath + ".html");
      break;
      label292:
      if (!TextUtils.isEmpty(paramMiniAppInfo.reportData)) {
        paramMiniAppInfo.launchParam.reportData = (paramMiniAppInfo.launchParam.reportData + "&" + paramMiniAppInfo.reportData);
      }
    }
  }
  
  private void saveIdInfo(JSONObject paramJSONObject, byte[] paramArrayOfByte, String paramString1, MiniAppCacheProxy paramMiniAppCacheProxy, String paramString2, String paramString3)
  {
    if (checkEnvVersionForCache(paramString1))
    {
      if (paramJSONObject == null) {
        break label65;
      }
      paramJSONObject = MiniAppInfo.pbFromJSON(paramJSONObject);
      if (paramJSONObject != null)
      {
        QMLog.d("MiniAppInfoLoadTask", "saveIdInfo cache.");
        if (paramMiniAppCacheProxy.saveIdInfo(paramString2, paramString3, ((INTERFACE.StApiAppInfo)paramJSONObject.get()).toByteArray(), System.currentTimeMillis())) {
          QMLog.d("MiniAppInfoLoadTask", "saveIdInfo cache success.");
        }
      }
    }
    label65:
    do
    {
      do
      {
        return;
      } while (paramArrayOfByte == null);
      QMLog.d("MiniAppInfoLoadTask", "saveIdInfo cache.");
    } while (!paramMiniAppCacheProxy.saveIdInfo(paramString2, paramString3, paramArrayOfByte, System.currentTimeMillis()));
    QMLog.d("MiniAppInfoLoadTask", "saveIdInfo cache success.");
  }
  
  private void saveLinkInfo(JSONObject paramJSONObject, byte[] paramArrayOfByte, String paramString1, MiniAppCacheProxy paramMiniAppCacheProxy, String paramString2, int paramInt)
  {
    if (paramJSONObject != null)
    {
      paramJSONObject = MiniAppInfo.pbFromJSON(paramJSONObject);
      if (paramJSONObject != null)
      {
        QMLog.d("MiniAppInfoLoadTask", "saveLinkInfo cache.");
        if (paramMiniAppCacheProxy.saveLinkInfo(paramString2, paramInt, paramString1, ((INTERFACE.StApiAppInfo)paramJSONObject.get()).toByteArray(), System.currentTimeMillis())) {
          QMLog.d("MiniAppInfoLoadTask", "saveLinkInfo cache success.");
        }
      }
    }
    do
    {
      do
      {
        return;
      } while (paramArrayOfByte == null);
      QMLog.d("MiniAppInfoLoadTask", "saveLinkInfo cache.");
    } while (!paramMiniAppCacheProxy.saveLinkInfo(paramString2, paramInt, paramString1, paramArrayOfByte, System.currentTimeMillis()));
    QMLog.d("MiniAppInfoLoadTask", "saveLinkInfo cache success.");
  }
  
  public void executeAsync() {}
  
  public MiniAppInfo getMiniAppInfo()
  {
    return this.mMiniAppInfo;
  }
  
  public void setMiniAppInfo(MiniAppInfo paramMiniAppInfo)
  {
    this.mMiniAppInfo = paramMiniAppInfo;
    if (!isMainThread())
    {
      reloadMiniAppInfoIfNeeded();
      return;
    }
    ThreadManager.getSubThreadHandler().post(new MiniAppInfoLoadTask.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.task.MiniAppInfoLoadTask
 * JD-Core Version:    0.7.0.1
 */