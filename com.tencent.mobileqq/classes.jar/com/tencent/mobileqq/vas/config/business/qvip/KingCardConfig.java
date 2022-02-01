package com.tencent.mobileqq.vas.config.business.qvip;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class KingCardConfig
{
  @NonNull
  public final KingCardConfig.Item a;
  @NonNull
  public final KingCardConfig.Item b;
  @NonNull
  public final KingCardConfig.Item c;
  
  private KingCardConfig()
  {
    this(a(null, ""), a(null, ""), a(null, ""));
  }
  
  private KingCardConfig(KingCardConfig.Item paramItem1, KingCardConfig.Item paramItem2, KingCardConfig.Item paramItem3)
  {
    this.a = paramItem1;
    this.b = paramItem2;
    this.c = paramItem3;
    if (QLog.isColorLevel()) {
      QLog.d("KC.ConfigProcessor", 1, toString());
    }
  }
  
  @NonNull
  private static KingCardConfig.Item a(JSONObject paramJSONObject, String paramString)
  {
    if ((paramJSONObject != null) && (!TextUtils.isEmpty(paramString))) {}
    for (;;)
    {
      try
      {
        Object localObject = paramJSONObject.optJSONObject(paramString);
        paramJSONObject = ((JSONObject)localObject).optString("content", null);
        JSONArray localJSONArray = ((JSONObject)localObject).optJSONArray("keyWords");
        localObject = ((JSONObject)localObject).optJSONArray("actionUrls");
        String[] arrayOfString1 = new String[localJSONArray.length()];
        String[] arrayOfString2 = new String[localJSONArray.length()];
        int i = 0;
        if (i < localJSONArray.length())
        {
          arrayOfString1[i] = localJSONArray.optString(i, null);
          arrayOfString2[i] = ((JSONArray)localObject).optString(i, null);
          i += 1;
          continue;
        }
        if (paramJSONObject == null) {
          break label171;
        }
        bool = true;
        paramJSONObject = new KingCardConfig.Item(paramString, bool, paramJSONObject, arrayOfString1, arrayOfString2);
        return paramJSONObject;
      }
      catch (Exception paramJSONObject)
      {
        paramString = new StringBuilder();
        paramString.append("json parse error:");
        paramString.append(paramJSONObject);
        QLog.e("KC.ConfigProcessor", 1, paramString.toString());
      }
      return new KingCardConfig.Item();
      label171:
      boolean bool = false;
    }
  }
  
  @NonNull
  public static KingCardConfig a()
  {
    return new KingCardConfig();
  }
  
  @NonNull
  public static KingCardConfig a(@Nullable String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    try
    {
      if (!TextUtils.isEmpty(paramString)) {
        localObject1 = new JSONObject(paramString);
      }
    }
    catch (JSONException paramString)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("json parse error:");
      ((StringBuilder)localObject1).append(paramString);
      QLog.e("KC.ConfigProcessor", 1, ((StringBuilder)localObject1).toString());
      localObject1 = localObject2;
    }
    return new KingCardConfig(a((JSONObject)localObject1, "AIO"), a((JSONObject)localObject1, "group"), a((JSONObject)localObject1, "download"));
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("KingCardConfig{aio=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", group=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", download=");
    localStringBuilder.append(this.c);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.config.business.qvip.KingCardConfig
 * JD-Core Version:    0.7.0.1
 */