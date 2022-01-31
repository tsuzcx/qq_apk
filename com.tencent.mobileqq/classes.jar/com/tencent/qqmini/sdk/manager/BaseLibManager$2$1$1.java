package com.tencent.qqmini.sdk.manager;

import bdnw;
import bdoc;
import bdom;
import com.tencent.qqmini.sdk.launcher.model.BaseLibInfo;
import org.json.JSONObject;

public class BaseLibManager$2$1$1
  implements Runnable
{
  public BaseLibManager$2$1$1(bdoc parambdoc, JSONObject paramJSONObject) {}
  
  public void run()
  {
    BaseLibInfo localBaseLibInfo1 = BaseLibInfo.fromJSON(this.jdField_a_of_type_OrgJsonJSONObject.optJSONObject(BaseLibInfo.getKey(2)));
    JSONObject localJSONObject = this.jdField_a_of_type_OrgJsonJSONObject.optJSONObject(BaseLibInfo.getKey(3));
    BaseLibInfo localBaseLibInfo2 = BaseLibInfo.fromJSON(localJSONObject);
    bdnw.b("miniapp-process_BaseLibManager", "[MiniEng] gameEngineLib " + localBaseLibInfo1 + ", miniAppEnginLib " + localJSONObject);
    if (localBaseLibInfo1 != null) {
      bdom.a().a(localBaseLibInfo1, null);
    }
    if (localBaseLibInfo2 != null) {
      bdom.a().a(localBaseLibInfo2, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.manager.BaseLibManager.2.1.1
 * JD-Core Version:    0.7.0.1
 */