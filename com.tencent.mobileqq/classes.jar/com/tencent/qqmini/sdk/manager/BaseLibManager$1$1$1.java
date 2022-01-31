package com.tencent.qqmini.sdk.manager;

import betc;
import bete;
import betf;
import betq;
import beus;
import com.tencent.qqmini.sdk.launcher.model.BaseLibInfo;
import org.json.JSONObject;

public class BaseLibManager$1$1$1
  implements Runnable
{
  public BaseLibManager$1$1$1(betf parambetf, JSONObject paramJSONObject) {}
  
  public void run()
  {
    BaseLibInfo localBaseLibInfo2 = BaseLibInfo.fromJSON(this.jdField_a_of_type_OrgJsonJSONObject.optJSONObject(BaseLibInfo.getKey(2)));
    JSONObject localJSONObject = this.jdField_a_of_type_OrgJsonJSONObject.optJSONObject(BaseLibInfo.getKey(3));
    BaseLibInfo localBaseLibInfo1 = BaseLibInfo.fromJSON(localJSONObject);
    betc.b("miniapp-process_BaseLibManager", "[MiniEng] gameEngineLib " + localBaseLibInfo2 + ", miniAppEnginLib " + localJSONObject);
    if (!beus.a().b()) {
      if (localBaseLibInfo2 != null) {
        betq.a().a(localBaseLibInfo2, null);
      }
    }
    for (;;)
    {
      if (localBaseLibInfo1 != null) {
        betq.a().a(localBaseLibInfo1, null);
      }
      return;
      localBaseLibInfo2 = bete.a();
      betc.b("miniapp-process_BaseLibManager", "[MiniEng]MiniEng QQSpeed gameEngineLib " + localBaseLibInfo2);
      if ((localBaseLibInfo2 != null) && (localBaseLibInfo2.baseLibType == 2)) {
        betq.a().a(localBaseLibInfo2, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.manager.BaseLibManager.1.1.1
 * JD-Core Version:    0.7.0.1
 */