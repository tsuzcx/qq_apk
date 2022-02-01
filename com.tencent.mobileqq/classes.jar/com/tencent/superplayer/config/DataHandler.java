package com.tencent.superplayer.config;

import com.tencent.superplayer.utils.LogUtil;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class DataHandler
{
  private static String TAG = "DataHandler";
  private DataHandler.ConfigGroupParseCallback mCallback;
  
  private void parseItems(JSONArray paramJSONArray)
  {
    int i = 0;
    for (;;)
    {
      if (i < paramJSONArray.length()) {
        try
        {
          parseOneItem(paramJSONArray.getJSONObject(i));
          i += 1;
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            LogUtil.e(TAG, "parseItems error, index:" + i, localJSONException);
          }
        }
      }
    }
  }
  
  private void parseOneItem(JSONObject paramJSONObject)
  {
    Object localObject = paramJSONObject.getString("group");
    localObject = ConfigManager.get().getCacheByOriginGroupName((String)localObject);
    paramJSONObject = paramJSONObject.getString("key_values");
    if (this.mCallback != null) {
      this.mCallback.onConfigGroupParsed((CacheContent)localObject, paramJSONObject);
    }
  }
  
  public void parseServerResult(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      int i = paramString.getInt("ret_code");
      String str = paramString.getString("ret_msg");
      if (i != 0)
      {
        LogUtil.e(TAG, "parseServerResult failed, resultCode:" + i + " resultMsg:" + str);
        return;
      }
      parseItems(paramString.getJSONObject("config").getJSONArray("items"));
      return;
    }
    catch (JSONException paramString)
    {
      LogUtil.e(TAG, "parseServerResult error", paramString);
    }
  }
  
  public void setCallback(DataHandler.ConfigGroupParseCallback paramConfigGroupParseCallback)
  {
    this.mCallback = paramConfigGroupParseCallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.superplayer.config.DataHandler
 * JD-Core Version:    0.7.0.1
 */