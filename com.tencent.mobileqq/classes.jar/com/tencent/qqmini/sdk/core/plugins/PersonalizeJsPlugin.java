package com.tencent.qqmini.sdk.core.plugins;

import bgjw;
import bgkd;
import com.tencent.qqmini.sdk.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.log.QMLog;
import org.json.JSONObject;

public class PersonalizeJsPlugin
  extends BaseJsPlugin
{
  private static final String TAG = "PersonalizeJsPlugin";
  private ChannelProxy mChannelProxy;
  
  public void personalize(bgkd parambgkd)
  {
    try
    {
      Object localObject1 = new JSONObject(parambgkd.b);
      if (((JSONObject)localObject1).has("api_name"))
      {
        Object localObject2 = ((JSONObject)localObject1).optJSONObject("data");
        if (localObject2 == null) {
          parambgkd.a("params error.");
        }
        try
        {
          localObject1 = ((JSONObject)localObject2).optString("uin");
          int i = ((JSONObject)localObject2).optInt("set_type");
          String str = ((JSONObject)localObject2).optString("item_id");
          localObject2 = ((JSONObject)localObject2).optString("busi_info");
          this.mChannelProxy.setPersonalizeInfo(this.mApkgInfo.appId, (String)localObject1, i, str, (String)localObject2, new PersonalizeJsPlugin.1(this, parambgkd));
          return;
        }
        catch (Exception localException1)
        {
          parambgkd.a("params error.");
          return;
        }
      }
      parambgkd.a("params error.");
    }
    catch (Exception localException2)
    {
      QMLog.e("PersonalizeJsPlugin", parambgkd.a + " error.", localException2);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.PersonalizeJsPlugin
 * JD-Core Version:    0.7.0.1
 */