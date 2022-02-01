package com.tencent.mobileqq.config.business.qvip;

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
    boolean bool = false;
    if ((paramJSONObject != null) && (!TextUtils.isEmpty(paramString))) {
      try
      {
        Object localObject = paramJSONObject.optJSONObject(paramString);
        paramJSONObject = ((JSONObject)localObject).optString("content", null);
        JSONArray localJSONArray = ((JSONObject)localObject).optJSONArray("keyWords");
        localObject = ((JSONObject)localObject).optJSONArray("actionUrls");
        String[] arrayOfString1 = new String[localJSONArray.length()];
        String[] arrayOfString2 = new String[localJSONArray.length()];
        int i = 0;
        while (i < localJSONArray.length())
        {
          arrayOfString1[i] = localJSONArray.optString(i, null);
          arrayOfString2[i] = ((JSONArray)localObject).optString(i, null);
          i += 1;
        }
        if (paramJSONObject != null) {
          bool = true;
        }
        paramJSONObject = new KingCardConfig.Item(paramString, bool, paramJSONObject, arrayOfString1, arrayOfString2);
        return paramJSONObject;
      }
      catch (Exception paramJSONObject)
      {
        QLog.e("KC.ConfigProcessor", 1, "json parse error:" + paramJSONObject);
      }
    }
    return new KingCardConfig.Item();
  }
  
  @NonNull
  public static KingCardConfig a()
  {
    return new KingCardConfig();
  }
  
  @NonNull
  public static KingCardConfig a(@Nullable String paramString)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = new JSONObject(paramString);
        return new KingCardConfig(a(paramString, "AIO"), a(paramString, "group"), a(paramString, "download"));
      }
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        QLog.e("KC.ConfigProcessor", 1, "json parse error:" + paramString);
        paramString = null;
      }
    }
  }
  
  public String toString()
  {
    return "KingCardConfig{aio=" + this.a + ", group=" + this.b + ", download=" + this.c + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.qvip.KingCardConfig
 * JD-Core Version:    0.7.0.1
 */