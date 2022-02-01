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
    while (i < paramJSONArray.length())
    {
      try
      {
        parseOneItem(paramJSONArray.getJSONObject(i));
      }
      catch (JSONException localJSONException)
      {
        String str = TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("parseItems error, index:");
        localStringBuilder.append(i);
        LogUtil.e(str, localStringBuilder.toString(), localJSONException);
      }
      i += 1;
    }
  }
  
  private void parseOneItem(JSONObject paramJSONObject)
  {
    Object localObject = paramJSONObject.getString("group");
    localObject = ConfigManager.get().getCacheByOriginGroupName((String)localObject);
    paramJSONObject = paramJSONObject.getString("key_values");
    DataHandler.ConfigGroupParseCallback localConfigGroupParseCallback = this.mCallback;
    if (localConfigGroupParseCallback != null) {
      localConfigGroupParseCallback.onConfigGroupParsed((CacheContent)localObject, paramJSONObject);
    }
  }
  
  public void parseServerResult(String paramString)
  {
    try
    {
      Object localObject = new JSONObject(paramString);
      int i = ((JSONObject)localObject).getInt("ret_code");
      paramString = ((JSONObject)localObject).getString("ret_msg");
      if (i != 0)
      {
        localObject = TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("parseServerResult failed, resultCode:");
        localStringBuilder.append(i);
        localStringBuilder.append(" resultMsg:");
        localStringBuilder.append(paramString);
        LogUtil.e((String)localObject, localStringBuilder.toString());
        return;
      }
      parseItems(((JSONObject)localObject).getJSONObject("config").getJSONArray("items"));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.superplayer.config.DataHandler
 * JD-Core Version:    0.7.0.1
 */