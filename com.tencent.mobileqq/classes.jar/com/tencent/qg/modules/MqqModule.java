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
    boolean bool = false;
    if ("getQQVersion".equals(paramString)) {
      paramString = new JSONObject();
    }
    while (!"getQQVersionSync".equals(paramString)) {
      try
      {
        paramString.putOpt("version", "8.5.5");
        bool = paramInvokeCallback.exec(0, paramString);
        return bool;
      }
      catch (JSONException paramJSONObject)
      {
        for (;;)
        {
          paramJSONObject.printStackTrace();
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qg.modules.MqqModule
 * JD-Core Version:    0.7.0.1
 */