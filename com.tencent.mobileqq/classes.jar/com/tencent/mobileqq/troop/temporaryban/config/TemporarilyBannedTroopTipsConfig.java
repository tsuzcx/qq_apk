package com.tencent.mobileqq.troop.temporaryban.config;

import android.text.TextUtils;
import com.tencent.mobileqq.troop.temporaryban.TemporarilyBannedTroopTipsBtn;
import com.tencent.mobileqq.troop.temporaryban.TemporarilyBannedTroopTipsItem;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TemporarilyBannedTroopTipsConfig
{
  public TemporarilyBannedTroopTipsItem a;
  public TemporarilyBannedTroopTipsItem b;
  
  public static TemporarilyBannedTroopTipsItem a(JSONObject paramJSONObject, String paramString)
  {
    paramString = paramJSONObject.getJSONArray(paramString);
    if ((paramString != null) && (paramString.length() != 0))
    {
      paramJSONObject = new TemporarilyBannedTroopTipsItem();
      int i = 0;
      paramString = paramString.getJSONObject(0);
      paramJSONObject.a = paramString.optString("title", "");
      paramJSONObject.b = paramString.optString("text", "");
      paramString = paramString.getJSONArray("btns");
      while (i < paramString.length())
      {
        Object localObject = paramString.getJSONObject(i);
        String str = ((JSONObject)localObject).getString("text");
        localObject = ((JSONObject)localObject).getString("action");
        paramJSONObject.c.add(new TemporarilyBannedTroopTipsBtn(str, (String)localObject));
        i += 1;
      }
      return paramJSONObject;
    }
    return null;
  }
  
  public static TemporarilyBannedTroopTipsConfig a(String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("content: ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("TemporarilyBannedTroopTipsConfig", 2, ((StringBuilder)localObject).toString());
    }
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      localObject = new JSONObject(paramString);
      paramString = a((JSONObject)localObject, "owner");
      localObject = a((JSONObject)localObject, "member");
      TemporarilyBannedTroopTipsConfig localTemporarilyBannedTroopTipsConfig = new TemporarilyBannedTroopTipsConfig();
      localTemporarilyBannedTroopTipsConfig.a = paramString;
      localTemporarilyBannedTroopTipsConfig.b = ((TemporarilyBannedTroopTipsItem)localObject);
      return localTemporarilyBannedTroopTipsConfig;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.temporaryban.config.TemporarilyBannedTroopTipsConfig
 * JD-Core Version:    0.7.0.1
 */