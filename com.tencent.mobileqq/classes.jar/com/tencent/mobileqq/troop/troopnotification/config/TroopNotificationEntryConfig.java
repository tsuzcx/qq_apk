package com.tencent.mobileqq.troop.troopnotification.config;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class TroopNotificationEntryConfig
{
  public int a;
  public int b;
  
  public TroopNotificationEntryConfig()
  {
    a();
  }
  
  public static TroopNotificationEntryConfig a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("parse, newConf = ");
    localStringBuilder.append(paramString);
    QLog.d("TroopNotificationEntryConfig", 1, localStringBuilder.toString());
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    int j = 0;
    int i;
    try
    {
      paramString = new JSONObject(paramString);
      i = paramString.optInt("showNewEntryFlag", 0);
      try
      {
        int k = paramString.optInt("oddEvenFlag", 0);
        j = k;
      }
      catch (JSONException paramString) {}
      paramString.printStackTrace();
    }
    catch (JSONException paramString)
    {
      i = 0;
    }
    paramString = new TroopNotificationEntryConfig();
    paramString.a = i;
    paramString.b = j;
    return paramString;
  }
  
  private void a()
  {
    this.a = 2;
    this.b = 0;
  }
  
  public boolean b(String paramString)
  {
    int i = this.a;
    boolean bool2 = false;
    if (i == 0)
    {
      if (paramString != null)
      {
        if (paramString.isEmpty()) {
          return false;
        }
        i = paramString.charAt(paramString.length() - 1);
        int j = this.b;
        if (j == 0) {
          return false;
        }
        if (j == 1)
        {
          bool1 = bool2;
          if (i % 2 == 0) {
            break label101;
          }
        }
        else
        {
          bool1 = bool2;
          if (j != 2) {
            break label101;
          }
          bool1 = bool2;
          if (i % 2 != 0) {
            break label101;
          }
        }
      }
      else
      {
        return false;
      }
    }
    else
    {
      bool1 = bool2;
      if (i != 1) {
        break label101;
      }
    }
    boolean bool1 = true;
    label101:
    return bool1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TroopNotificationEntryConfig{showNewEntryFlag=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", oddEvenFlag=");
    localStringBuilder.append(this.b);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopnotification.config.TroopNotificationEntryConfig
 * JD-Core Version:    0.7.0.1
 */