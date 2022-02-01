package com.tencent.qg.modules;

import com.tencent.qg.sdk.invoke.BaseJsModule;
import com.tencent.qg.sdk.invoke.InvokeCallback;
import org.json.JSONException;
import org.json.JSONObject;

public class MqqModule
  extends BaseJsModule
{
  public String getModuleName()
  {
    return "mqq";
  }
  
  public boolean handleJsRequest(String paramString, JSONObject paramJSONObject, InvokeCallback paramInvokeCallback)
  {
    if ("getQQVersion".equals(paramString))
    {
      paramString = new JSONObject();
      try
      {
        paramString.putOpt("version", "8.8.17");
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
      }
      return paramInvokeCallback.exec(0, paramString);
    }
    "getQQVersionSync".equals(paramString);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qg.modules.MqqModule
 * JD-Core Version:    0.7.0.1
 */