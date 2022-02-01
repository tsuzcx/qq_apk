package com.tencent.qqmini.sdk.core.manager;

import android.os.Parcelable;
import com.tencent.qqmini.sdk.core.utils.FileUtils;
import com.tencent.qqmini.sdk.core.utils.ParcelableUtil;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import org.json.JSONObject;

class PreCacheManager$4
  implements AsyncResult
{
  PreCacheManager$4(PreCacheManager paramPreCacheManager, String paramString1, String paramString2, MiniAppInfo paramMiniAppInfo, String paramString3, PreCacheManager.OnCacheListener paramOnCacheListener) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean)
    {
      try
      {
        Object localObject2 = (PreCacheManager.ContentAccelerateRsp)paramJSONObject.get("data");
        paramJSONObject = new StringBuilder();
        paramJSONObject.append(this.val$logPrefix);
        paramJSONObject.append(" fetch PreCache succful. CacheType:");
        paramJSONObject.append(this.val$cacheType);
        paramJSONObject.append(" httpCode=");
        paramJSONObject.append(((PreCacheManager.ContentAccelerateRsp)localObject2).httpReturnCode);
        paramJSONObject.append(" length=");
        paramJSONObject.append(((PreCacheManager.ContentAccelerateRsp)localObject2).cacheData.length);
        QMLog.i("minisdk-start_PreCacheManager", paramJSONObject.toString());
        if ((((PreCacheManager.ContentAccelerateRsp)localObject2).httpReturnCode != 200) || (((PreCacheManager.ContentAccelerateRsp)localObject2).cacheData.length > PreCacheManager.access$200())) {
          return;
        }
        localObject1 = new PreCacheManager.PreCacheDescData();
        ((PreCacheManager.PreCacheDescData)localObject1).appid = this.val$miniAppConfig.appId;
        ((PreCacheManager.PreCacheDescData)localObject1).url = this.val$origUrl;
        ((PreCacheManager.PreCacheDescData)localObject1).scene = this.val$miniAppConfig.launchParam.scene;
        ((PreCacheManager.PreCacheDescData)localObject1).path = this.val$miniAppConfig.launchParam.entryPath;
        ((PreCacheManager.PreCacheDescData)localObject1).timeStamp = System.currentTimeMillis();
        paramJSONObject = MiniAppFileManager.getPreCacheFilePath(this.val$miniAppConfig.appId, this.val$cacheType, ((PreCacheManager.PreCacheDescData)localObject1).getCacheKey(this.val$cacheType));
        FileUtils.writeFile(((PreCacheManager.ContentAccelerateRsp)localObject2).cacheData, paramJSONObject);
        ((PreCacheManager.PreCacheDescData)localObject1).filePath = paramJSONObject;
        localObject2 = this.val$miniAppConfig.appId;
        String str = this.val$cacheType;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(((PreCacheManager.PreCacheDescData)localObject1).getCacheKey(this.val$cacheType));
        localStringBuilder.append("_index");
        localObject2 = MiniAppFileManager.getPreCacheFilePath((String)localObject2, str, localStringBuilder.toString());
        ParcelableUtil.writeParcelableToFile((Parcelable)localObject1, (String)localObject2);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(this.val$logPrefix);
        ((StringBuilder)localObject1).append(" save PreCache info. index=");
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append(" content=");
        ((StringBuilder)localObject1).append(paramJSONObject);
        QMLog.i("minisdk-start_PreCacheManager", ((StringBuilder)localObject1).toString());
        if (this.val$listener == null) {
          return;
        }
        this.val$listener.onCacheUpdated(true, true);
        return;
      }
      catch (Throwable paramJSONObject)
      {
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(this.val$logPrefix);
        ((StringBuilder)localObject1).append(" request PreCache exception!");
        QMLog.e("minisdk-start_PreCacheManager", ((StringBuilder)localObject1).toString(), paramJSONObject);
        paramJSONObject = this.val$listener;
        if (paramJSONObject == null) {
          return;
        }
      }
      paramJSONObject.onCacheUpdated(false, false);
    }
    else
    {
      int i = paramJSONObject.optInt("retCode");
      paramJSONObject = new StringBuilder();
      paramJSONObject.append(this.val$logPrefix);
      paramJSONObject.append(" fetch PreCache failed! retCode=");
      paramJSONObject.append(i);
      paramJSONObject.append(" msg=");
      paramJSONObject.append("");
      QMLog.i("minisdk-start_PreCacheManager", paramJSONObject.toString());
      paramJSONObject = this.val$listener;
      if (paramJSONObject != null) {
        paramJSONObject.onCacheUpdated(false, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.manager.PreCacheManager.4
 * JD-Core Version:    0.7.0.1
 */