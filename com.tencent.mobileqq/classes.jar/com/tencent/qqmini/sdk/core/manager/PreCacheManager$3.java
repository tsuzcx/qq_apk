package com.tencent.qqmini.sdk.core.manager;

import com.tencent.qqmini.sdk.core.utils.FileUtils;
import com.tencent.qqmini.sdk.core.utils.ParcelableUtil;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import org.json.JSONObject;

class PreCacheManager$3
  implements AsyncResult
{
  PreCacheManager$3(PreCacheManager paramPreCacheManager, String paramString1, String paramString2, MiniAppInfo paramMiniAppInfo, String paramString3, PreCacheManager.OnCacheListener paramOnCacheListener) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean) {}
    do
    {
      try
      {
        Object localObject = (PreCacheManager.ContentAccelerateRsp)paramJSONObject.get("data");
        QMLog.i("minisdk-start_PreCacheManager", this.val$logPrefix + " fetch PreCache succful. CacheType:" + this.val$cacheType + " httpCode=" + ((PreCacheManager.ContentAccelerateRsp)localObject).httpReturnCode + " length=" + ((PreCacheManager.ContentAccelerateRsp)localObject).cacheData.length);
        if ((((PreCacheManager.ContentAccelerateRsp)localObject).httpReturnCode == 200) && (((PreCacheManager.ContentAccelerateRsp)localObject).cacheData.length <= PreCacheManager.access$200()))
        {
          paramJSONObject = new PreCacheManager.PreCacheDescData();
          paramJSONObject.appid = this.val$miniAppConfig.appId;
          paramJSONObject.url = this.val$origUrl;
          paramJSONObject.scene = this.val$miniAppConfig.launchParam.scene;
          paramJSONObject.path = this.val$miniAppConfig.launchParam.entryPath;
          paramJSONObject.timeStamp = System.currentTimeMillis();
          String str = MiniAppFileManager.getPreCacheFilePath(this.val$miniAppConfig.appId, this.val$cacheType, paramJSONObject.getCacheKey(this.val$cacheType));
          FileUtils.writeFile(((PreCacheManager.ContentAccelerateRsp)localObject).cacheData, str);
          paramJSONObject.filePath = str;
          localObject = MiniAppFileManager.getPreCacheFilePath(this.val$miniAppConfig.appId, this.val$cacheType, paramJSONObject.getCacheKey(this.val$cacheType) + "_index");
          ParcelableUtil.writeParcelableToFile(paramJSONObject, (String)localObject);
          QMLog.i("minisdk-start_PreCacheManager", this.val$logPrefix + " save PreCache info. index=" + (String)localObject + " content=" + str);
          if (this.val$listener != null) {
            this.val$listener.onCacheUpdated(true, true);
          }
        }
        return;
      }
      catch (Throwable paramJSONObject)
      {
        do
        {
          QMLog.e("minisdk-start_PreCacheManager", this.val$logPrefix + " request PreCache exception!", paramJSONObject);
        } while (this.val$listener == null);
        this.val$listener.onCacheUpdated(false, false);
        return;
      }
      int i = paramJSONObject.optInt("retCode");
      QMLog.i("minisdk-start_PreCacheManager", this.val$logPrefix + " fetch PreCache failed! retCode=" + i + " msg=" + "");
    } while (this.val$listener == null);
    this.val$listener.onCacheUpdated(false, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.manager.PreCacheManager.3
 * JD-Core Version:    0.7.0.1
 */