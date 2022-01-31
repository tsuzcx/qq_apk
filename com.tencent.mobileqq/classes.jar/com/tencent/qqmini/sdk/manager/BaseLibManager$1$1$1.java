package com.tencent.qqmini.sdk.manager;

import android.text.TextUtils;
import bgrl;
import bgrm;
import bgrx;
import bgtd;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.model.BaseLibInfo;
import com.tencent.qqmini.sdk.log.QMLog;
import org.json.JSONObject;

public class BaseLibManager$1$1$1
  implements Runnable
{
  public BaseLibManager$1$1$1(bgrm parambgrm, JSONObject paramJSONObject) {}
  
  public void run()
  {
    BaseLibInfo localBaseLibInfo2 = BaseLibInfo.fromJSON(this.jdField_a_of_type_OrgJsonJSONObject.optJSONObject(BaseLibInfo.getKey(2)));
    JSONObject localJSONObject = this.jdField_a_of_type_OrgJsonJSONObject.optJSONObject(BaseLibInfo.getKey(3));
    BaseLibInfo localBaseLibInfo1 = BaseLibInfo.fromJSON(localJSONObject);
    QMLog.i("miniapp-process_BaseLibManager", "[MiniEng] gameEngineLib " + localBaseLibInfo2 + ", miniAppEnginLib " + localJSONObject);
    if ((TextUtils.isEmpty(((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getSoPath())) || (!"1.14.0.00225".equals(this.jdField_a_of_type_Bgrm.a)))
    {
      if (bgtd.a().b()) {
        break label131;
      }
      if (localBaseLibInfo2 != null) {
        bgrx.a().a(localBaseLibInfo2, null);
      }
    }
    for (;;)
    {
      if (localBaseLibInfo1 != null) {
        bgrx.a().a(localBaseLibInfo1, null);
      }
      return;
      label131:
      localBaseLibInfo2 = bgrl.a();
      QMLog.i("miniapp-process_BaseLibManager", "[MiniEng]MiniEng QQSpeed gameEngineLib " + localBaseLibInfo2);
      if ((localBaseLibInfo2 != null) && (localBaseLibInfo2.baseLibType == 2)) {
        bgrx.a().a(localBaseLibInfo2, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.manager.BaseLibManager.1.1.1
 * JD-Core Version:    0.7.0.1
 */