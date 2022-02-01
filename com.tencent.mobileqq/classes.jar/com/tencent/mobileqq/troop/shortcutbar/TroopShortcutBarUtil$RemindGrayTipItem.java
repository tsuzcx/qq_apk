package com.tencent.mobileqq.troop.shortcutbar;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class TroopShortcutBarUtil$RemindGrayTipItem
{
  public long a = 0L;
  public long b = 0L;
  public String c = "";
  public String d = "";
  
  String a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("appId", this.a);
      localJSONObject.put("appType", this.b);
      Object localObject = this.c;
      String str = "";
      if (localObject == null) {
        localObject = "";
      } else {
        localObject = this.c;
      }
      localJSONObject.put("appName", localObject);
      if (this.d == null) {
        localObject = str;
      } else {
        localObject = this.d;
      }
      localJSONObject.put("appJumpUrl", localObject);
    }
    catch (Exception localException)
    {
      label86:
      break label86;
    }
    return localJSONObject.toString();
  }
  
  public boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    try
    {
      paramString = new JSONObject(paramString);
      this.a = paramString.optLong("appId");
      this.b = paramString.optLong("appType");
      this.c = paramString.optString("appName");
      this.d = paramString.optString("appJumpUrl");
      return true;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("appId:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(" ");
    localStringBuilder.append("appType:");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" ");
    localStringBuilder.append("appName:");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" ");
    localStringBuilder.append("appJumpUrl:");
    localStringBuilder.append(this.d);
    localStringBuilder.append(" ");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.shortcutbar.TroopShortcutBarUtil.RemindGrayTipItem
 * JD-Core Version:    0.7.0.1
 */