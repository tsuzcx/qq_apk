package com.tencent.mobileqq.mini.entry;

import com.tencent.mobileqq.mini.api.IPrePullListener;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.json.JSONObject;

class MiniAppPrePullManager$2
  implements MiniAppCmdInterface
{
  MiniAppPrePullManager$2(MiniAppPrePullManager paramMiniAppPrePullManager, String paramString1, String paramString2, IPrePullListener paramIPrePullListener) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    long l = paramJSONObject.optLong("retCode");
    ??? = paramJSONObject.optString("errMsg");
    if (paramBoolean)
    {
      QLog.d("MiniAppPrePullManager", 1, "prePullAppinfoById suc");
      synchronized (MiniAppPrePullManager.access$100())
      {
        localObject2 = new MiniAppPrePullManager.MiniAppInfoPrePullWrapper();
        ((MiniAppPrePullManager.MiniAppInfoPrePullWrapper)localObject2).setAppId(this.val$appId);
        ((MiniAppPrePullManager.MiniAppInfoPrePullWrapper)localObject2).setEntryPath(this.val$entryPath);
        ((MiniAppPrePullManager.MiniAppInfoPrePullWrapper)localObject2).setPullTimeStamp(System.currentTimeMillis());
        MiniAppPrePullManager.access$300().put(this.val$appId, localObject2);
        ??? = this.val$prePullListener;
        if (??? == null) {
          return;
        }
        ((IPrePullListener)???).onPrePullCallback(true, paramJSONObject);
        return;
      }
    }
    Object localObject2 = this.val$prePullListener;
    if (localObject2 != null) {
      ((IPrePullListener)localObject2).onPrePullCallback(false, paramJSONObject);
    }
    paramJSONObject = new StringBuilder();
    paramJSONObject.append("prePullAppinfoById failed. retCode=");
    paramJSONObject.append(l);
    paramJSONObject.append(" errMsg=");
    paramJSONObject.append((String)???);
    QLog.e("MiniAppPrePullManager", 1, paramJSONObject.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppPrePullManager.2
 * JD-Core Version:    0.7.0.1
 */