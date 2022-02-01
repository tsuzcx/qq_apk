package com.tencent.mobileqq.mini.entry;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.api.IPrePullListener;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.json.JSONObject;

class MiniAppPrePullManager$3
  implements MiniAppCmdInterface
{
  MiniAppPrePullManager$3(MiniAppPrePullManager paramMiniAppPrePullManager, String paramString, boolean paramBoolean, IPrePullListener paramIPrePullListener) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    long l = paramJSONObject.optLong("retCode");
    ??? = paramJSONObject.optString("errMsg");
    if (paramBoolean) {
      synchronized (MiniAppPrePullManager.access$100())
      {
        localObject2 = new MiniAppPrePullManager.MiniAppInfoPrePullWrapper();
        ((MiniAppPrePullManager.MiniAppInfoPrePullWrapper)localObject2).setLink(this.val$finalLink);
        ((MiniAppPrePullManager.MiniAppInfoPrePullWrapper)localObject2).setPullTimeStamp(System.currentTimeMillis());
        MiniAppPrePullManager.access$200().put(this.val$finalLink, localObject2);
        if (this.val$withPackageAndCachePreload)
        {
          ??? = (MiniAppInfo)paramJSONObject.opt("appInfo");
          if (??? != null)
          {
            MiniAppController.preloadPackage((MiniAppInfo)???);
            MiniAppUtils.preFetchAppCacheData(BaseApplicationImpl.getApplication(), (MiniAppInfo)???);
          }
        }
        ??? = this.val$prePullListener;
        if (??? != null) {
          ((IPrePullListener)???).onPrePullCallback(true, paramJSONObject);
        }
        QLog.d("MiniAppPrePullManager", 1, "prePullAppinfoByLink suc");
        return;
      }
    }
    Object localObject2 = this.val$prePullListener;
    if (localObject2 != null) {
      ((IPrePullListener)localObject2).onPrePullCallback(false, paramJSONObject);
    }
    paramJSONObject = new StringBuilder();
    paramJSONObject.append("prePullAppinfoByLink failed. retCode=");
    paramJSONObject.append(l);
    paramJSONObject.append(" errMsg=");
    paramJSONObject.append((String)???);
    QLog.e("MiniAppPrePullManager", 1, paramJSONObject.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppPrePullManager.3
 * JD-Core Version:    0.7.0.1
 */