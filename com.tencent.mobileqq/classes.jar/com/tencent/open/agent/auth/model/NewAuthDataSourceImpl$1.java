package com.tencent.open.agent.auth.model;

import com.tencent.open.agent.authority.CGICallback;
import com.tencent.open.agent.util.SSOLog;
import com.tencent.open.model.AccountInfo;
import com.tencent.open.virtual.OpenSdkVirtualUtil;
import org.json.JSONException;
import org.json.JSONObject;

class NewAuthDataSourceImpl$1
  implements Runnable
{
  NewAuthDataSourceImpl$1(NewAuthDataSourceImpl paramNewAuthDataSourceImpl, long paramLong, AccountInfo paramAccountInfo, CGICallback paramCGICallback, boolean paramBoolean) {}
  
  public void run()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("uint64_vuid", this.a);
    }
    catch (JSONException localJSONException)
    {
      SSOLog.c(NewAuthDataSourceImpl.a(), "deleteVirtual.e:", localJSONException);
    }
    OpenSdkVirtualUtil.a("oidb_0xd18_1", this.b, localJSONObject.toString(), this.c, this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.auth.model.NewAuthDataSourceImpl.1
 * JD-Core Version:    0.7.0.1
 */