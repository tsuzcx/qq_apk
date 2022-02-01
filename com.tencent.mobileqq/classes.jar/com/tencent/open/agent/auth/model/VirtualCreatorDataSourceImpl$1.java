package com.tencent.open.agent.auth.model;

import com.tencent.open.agent.authority.CGICallback;
import com.tencent.open.agent.util.SSOLog;
import com.tencent.open.model.AccountInfo;
import com.tencent.open.virtual.OpenSdkVirtualUtil;
import org.json.JSONException;
import org.json.JSONObject;

class VirtualCreatorDataSourceImpl$1
  implements Runnable
{
  VirtualCreatorDataSourceImpl$1(VirtualCreatorDataSourceImpl paramVirtualCreatorDataSourceImpl, long paramLong, String paramString1, String paramString2, AccountInfo paramAccountInfo, CGICallback paramCGICallback, boolean paramBoolean) {}
  
  public void run()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("uint64_appid", this.a);
      localJSONObject.put("str_nick", this.b);
      localJSONObject.put("str_head_id", this.c);
    }
    catch (JSONException localJSONException)
    {
      SSOLog.a("VirtualCreatorPresenter", "createVirtual.e:", localJSONException);
    }
    OpenSdkVirtualUtil.a("oidb_0xd17_1", this.d, localJSONObject.toString(), this.e, this.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.auth.model.VirtualCreatorDataSourceImpl.1
 * JD-Core Version:    0.7.0.1
 */