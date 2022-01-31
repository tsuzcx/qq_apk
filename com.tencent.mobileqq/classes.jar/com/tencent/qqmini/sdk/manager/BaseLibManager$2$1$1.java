package com.tencent.qqmini.sdk.manager;

import android.text.TextUtils;
import bgvu;
import bgwe;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.model.BaseLibInfo;
import com.tencent.qqmini.sdk.log.QMLog;
import org.json.JSONObject;

public class BaseLibManager$2$1$1
  implements Runnable
{
  public BaseLibManager$2$1$1(bgvu parambgvu, JSONObject paramJSONObject) {}
  
  public void run()
  {
    BaseLibInfo localBaseLibInfo1 = BaseLibInfo.fromJSON(this.jdField_a_of_type_OrgJsonJSONObject.optJSONObject(BaseLibInfo.getKey(2)));
    JSONObject localJSONObject = this.jdField_a_of_type_OrgJsonJSONObject.optJSONObject(BaseLibInfo.getKey(3));
    BaseLibInfo localBaseLibInfo2 = BaseLibInfo.fromJSON(localJSONObject);
    QMLog.i("miniapp-process_BaseLibManager", "[MiniEng] gameEngineLib " + localBaseLibInfo1 + ", miniAppEnginLib " + localJSONObject);
    if ((TextUtils.isEmpty(((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getSoPath())) || (!"1.14.0.00225".equals(this.jdField_a_of_type_Bgvu.a)))
    {
      if (localBaseLibInfo1 != null) {
        bgwe.a().a(localBaseLibInfo1, null);
      }
      if (localBaseLibInfo2 != null) {
        bgwe.a().a(localBaseLibInfo2, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.manager.BaseLibManager.2.1.1
 * JD-Core Version:    0.7.0.1
 */