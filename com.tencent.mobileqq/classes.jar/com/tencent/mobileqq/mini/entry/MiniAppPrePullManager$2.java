package com.tencent.mobileqq.mini.entry;

import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.json.JSONObject;

class MiniAppPrePullManager$2
  implements MiniAppCmdInterface
{
  MiniAppPrePullManager$2(MiniAppPrePullManager paramMiniAppPrePullManager, String paramString1, String paramString2, MiniAppPrePullManager.IPrePullListener paramIPrePullListener) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    long l = paramJSONObject.optLong("retCode");
    ??? = paramJSONObject.optString("errMsg");
    if (paramBoolean)
    {
      QLog.d("MiniAppPrePullManager", 1, "prePullAppinfoById suc");
      synchronized (MiniAppPrePullManager.access$100())
      {
        MiniAppPrePullManager.MiniAppInfoPrePullWrapper localMiniAppInfoPrePullWrapper = new MiniAppPrePullManager.MiniAppInfoPrePullWrapper();
        localMiniAppInfoPrePullWrapper.setAppId(this.val$appId);
        localMiniAppInfoPrePullWrapper.setEntryPath(this.val$entryPath);
        localMiniAppInfoPrePullWrapper.setPullTimeStamp(System.currentTimeMillis());
        MiniAppPrePullManager.access$300().put(this.val$appId, localMiniAppInfoPrePullWrapper);
        if (this.val$prePullListener != null) {
          this.val$prePullListener.onPrePullCallback(true, paramJSONObject);
        }
        return;
      }
    }
    if (this.val$prePullListener != null) {
      this.val$prePullListener.onPrePullCallback(false, paramJSONObject);
    }
    QLog.e("MiniAppPrePullManager", 1, "prePullAppinfoById failed. retCode=" + l + " errMsg=" + (String)???);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppPrePullManager.2
 * JD-Core Version:    0.7.0.1
 */