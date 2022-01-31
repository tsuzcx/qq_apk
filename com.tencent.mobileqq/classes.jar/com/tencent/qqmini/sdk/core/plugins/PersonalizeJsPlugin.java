package com.tencent.qqmini.sdk.core.plugins;

import bgod;
import bgok;
import com.tencent.qqmini.sdk.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.log.QMLog;
import org.json.JSONObject;

public class PersonalizeJsPlugin
  extends BaseJsPlugin
{
  private static final String TAG = "PersonalizeJsPlugin";
  private ChannelProxy mChannelProxy;
  
  public void personalize(bgok parambgok)
  {
    try
    {
      Object localObject1 = new JSONObject(parambgok.b);
      if (((JSONObject)localObject1).has("api_name"))
      {
        Object localObject2 = ((JSONObject)localObject1).optJSONObject("data");
        if (localObject2 == null) {
          parambgok.a("params error.");
        }
        try
        {
          localObject1 = ((JSONObject)localObject2).optString("uin");
          int i = ((JSONObject)localObject2).optInt("set_type");
          String str = ((JSONObject)localObject2).optString("item_id");
          localObject2 = ((JSONObject)localObject2).optString("busi_info");
          this.mChannelProxy.setPersonalizeInfo(this.mApkgInfo.appId, (String)localObject1, i, str, (String)localObject2, new PersonalizeJsPlugin.1(this, parambgok));
          return;
        }
        catch (Exception localException1)
        {
          parambgok.a("params error.");
          return;
        }
      }
      parambgok.a("params error.");
    }
    catch (Exception localException2)
    {
      QMLog.e("PersonalizeJsPlugin", parambgok.a + " error.", localException2);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.PersonalizeJsPlugin
 * JD-Core Version:    0.7.0.1
 */