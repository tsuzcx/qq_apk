package com.tencent.treasurecard.bean;

import android.text.TextUtils;
import com.tencent.treasurecard.util.JsonUtil;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class UserInfoRsp
{
  public String a;
  public String b;
  public String c;
  public String d;
  public String e = String.valueOf(1003);
  public String f;
  public List<Map<String, Object>> g;
  public String h = "";
  
  public UserInfoRsp a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return this;
    }
    try
    {
      paramString = new JSONObject(paramString);
      this.a = paramString.optString("msgId", "");
      this.b = paramString.optString("systemTime", "");
      this.c = paramString.optString("message", "");
      this.d = paramString.optString("expandParams", "");
      this.e = paramString.optString("resultcode", "");
      this.f = paramString.optString("desc", "");
      this.h = paramString.optString("pcId", "");
      this.g = JsonUtil.b(paramString.optString("orderStatus", ""));
      return this;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.treasurecard.bean.UserInfoRsp
 * JD-Core Version:    0.7.0.1
 */