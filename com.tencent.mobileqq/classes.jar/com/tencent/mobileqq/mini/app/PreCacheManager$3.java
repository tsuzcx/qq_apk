package com.tencent.mobileqq.mini.app;

import android.os.Parcelable;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.appbrand.utils.FileUtils;
import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.util.ParcelableUtil;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class PreCacheManager$3
  implements MiniAppCmdInterface
{
  PreCacheManager$3(PreCacheManager paramPreCacheManager, String paramString1, String paramString2, MiniAppConfig paramMiniAppConfig, String paramString3, PreCacheManager.OnCacheListener paramOnCacheListener) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    Object localObject1;
    if (paramBoolean)
    {
      try
      {
        Object localObject2 = (PreCacheManager.ContentAccelerateRsp)paramJSONObject.get("mini_rsp_data");
        paramJSONObject = new StringBuilder();
        paramJSONObject.append(this.val$logPrefix);
        paramJSONObject.append(" fetch PreCache succful. CacheType:");
        paramJSONObject.append(this.val$cacheType);
        paramJSONObject.append(" httpCode=");
        paramJSONObject.append(((PreCacheManager.ContentAccelerateRsp)localObject2).httpReturnCode);
        paramJSONObject.append(" length=");
        paramJSONObject.append(((PreCacheManager.ContentAccelerateRsp)localObject2).cacheData.length);
        QLog.i("miniapp-start_PreCacheManager", 1, paramJSONObject.toString());
        if ((((PreCacheManager.ContentAccelerateRsp)localObject2).httpReturnCode != 200) || (((PreCacheManager.ContentAccelerateRsp)localObject2).cacheData.length > PreCacheManager.access$200(this.this$0))) {
          return;
        }
        localObject1 = new PreCacheManager.PreCacheDescData();
        ((PreCacheManager.PreCacheDescData)localObject1).appid = this.val$miniAppConfig.config.appId;
        ((PreCacheManager.PreCacheDescData)localObject1).url = this.val$origUrl;
        ((PreCacheManager.PreCacheDescData)localObject1).scene = this.val$miniAppConfig.launchParam.scene;
        ((PreCacheManager.PreCacheDescData)localObject1).path = this.val$miniAppConfig.launchParam.entryPath;
        ((PreCacheManager.PreCacheDescData)localObject1).timeStamp = System.currentTimeMillis();
        MiniAppFileManager.getInstance();
        paramJSONObject = MiniAppFileManager.getPreCacheFilePath(this.val$miniAppConfig.config.appId, this.val$cacheType, ((PreCacheManager.PreCacheDescData)localObject1).getCacheKey(this.val$cacheType));
        FileUtils.writeFile(((PreCacheManager.ContentAccelerateRsp)localObject2).cacheData, paramJSONObject);
        ((PreCacheManager.PreCacheDescData)localObject1).filePath = paramJSONObject;
        MiniAppFileManager.getInstance();
        localObject2 = this.val$miniAppConfig.config.appId;
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
        QLog.i("miniapp-start_PreCacheManager", 1, ((StringBuilder)localObject1).toString());
        if (this.val$listener == null) {
          return;
        }
        this.val$listener.onCacheUpdated(true, true);
        return;
      }
      catch (Throwable paramJSONObject)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(this.val$logPrefix);
        ((StringBuilder)localObject1).append(" request PreCache exception!");
        QLog.e("miniapp-start_PreCacheManager", 1, ((StringBuilder)localObject1).toString(), paramJSONObject);
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
      paramJSONObject = paramJSONObject.optString("errMsg");
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(this.val$logPrefix);
      ((StringBuilder)localObject1).append(" fetch PreCache failed! retCode=");
      ((StringBuilder)localObject1).append(i);
      ((StringBuilder)localObject1).append(" msg=");
      ((StringBuilder)localObject1).append(paramJSONObject);
      QLog.i("miniapp-start_PreCacheManager", 1, ((StringBuilder)localObject1).toString());
      paramJSONObject = this.val$listener;
      if (paramJSONObject != null) {
        paramJSONObject.onCacheUpdated(false, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.app.PreCacheManager.3
 * JD-Core Version:    0.7.0.1
 */