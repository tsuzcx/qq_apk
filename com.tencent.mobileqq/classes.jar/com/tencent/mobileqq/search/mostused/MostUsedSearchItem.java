package com.tencent.mobileqq.search.mostused;

import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

public class MostUsedSearchItem
  implements Serializable
{
  private static String a = "MostUsedSearchItem";
  public int businessType = 0;
  public String identify = "";
  public int identifyType;
  public String searchKey = "";
  public long timeStamp = -1L;
  
  public MostUsedSearchItem() {}
  
  public MostUsedSearchItem(MostUsedSearchItem paramMostUsedSearchItem)
  {
    if (paramMostUsedSearchItem == null) {
      return;
    }
    this.searchKey = paramMostUsedSearchItem.searchKey;
    this.timeStamp = paramMostUsedSearchItem.timeStamp;
    this.identify = paramMostUsedSearchItem.identify;
    this.businessType = paramMostUsedSearchItem.businessType;
    this.identifyType = paramMostUsedSearchItem.identifyType;
  }
  
  public MostUsedSearchItem(String paramString1, long paramLong, String paramString2, int paramInt1, int paramInt2)
  {
    this.searchKey = paramString1;
    this.timeStamp = paramLong;
    this.identify = paramString2;
    this.identifyType = paramInt1;
    this.businessType = paramInt2;
  }
  
  public static MostUsedSearchItem fromJson(String paramString)
  {
    String str = a;
    Object localObject;
    if (paramString == null)
    {
      localObject = "";
      QLog.d(str, 2, (String)localObject);
      localObject = new MostUsedSearchItem();
      if (paramString != null) {
        break label36;
      }
    }
    for (;;)
    {
      return localObject;
      localObject = paramString;
      break;
      try
      {
        label36:
        paramString = new JSONObject(paramString);
        if (paramString.has("searchKey")) {
          ((MostUsedSearchItem)localObject).searchKey = paramString.getString("searchKey");
        }
        if (paramString.has("timeStamp")) {
          ((MostUsedSearchItem)localObject).timeStamp = paramString.getLong("timeStamp");
        }
        if (paramString.has("identify")) {
          ((MostUsedSearchItem)localObject).identify = paramString.getString("identify");
        }
        if (paramString.has("businessType")) {
          ((MostUsedSearchItem)localObject).businessType = paramString.getInt("businessType");
        }
        if (paramString.has("identifyType"))
        {
          ((MostUsedSearchItem)localObject).identifyType = paramString.getInt("identifyType");
          return localObject;
        }
      }
      catch (JSONException paramString)
      {
        QLog.e(a, 2, "MostUsedSearchItem fromJson ERR;" + paramString.toString());
      }
    }
    return localObject;
  }
  
  public static boolean isSameIdentityItem(MostUsedSearchItem paramMostUsedSearchItem1, MostUsedSearchItem paramMostUsedSearchItem2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramMostUsedSearchItem1 != null)
    {
      bool1 = bool2;
      if (paramMostUsedSearchItem2 != null)
      {
        bool1 = bool2;
        if (paramMostUsedSearchItem1.businessType == paramMostUsedSearchItem2.businessType)
        {
          bool1 = bool2;
          if (paramMostUsedSearchItem1.identify.equals(paramMostUsedSearchItem2.identify))
          {
            bool1 = bool2;
            if (paramMostUsedSearchItem1.identifyType == paramMostUsedSearchItem2.identifyType) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public static JSONObject toJson(MostUsedSearchItem paramMostUsedSearchItem)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramMostUsedSearchItem != null) {}
    try
    {
      localJSONObject.put("searchKey", paramMostUsedSearchItem.searchKey);
      localJSONObject.put("timeStamp", paramMostUsedSearchItem.timeStamp);
      localJSONObject.put("identify", paramMostUsedSearchItem.identify);
      localJSONObject.put("businessType", paramMostUsedSearchItem.businessType);
      localJSONObject.put("identifyType", paramMostUsedSearchItem.identifyType);
      return localJSONObject;
    }
    catch (JSONException paramMostUsedSearchItem)
    {
      QLog.e(a, 2, "MostUsedSearchItem toJson ERR;" + paramMostUsedSearchItem.toString());
    }
    return localJSONObject;
  }
  
  public static String toJsonString(MostUsedSearchItem paramMostUsedSearchItem)
  {
    String str2 = null;
    String str1 = str2;
    if (paramMostUsedSearchItem != null)
    {
      paramMostUsedSearchItem = toJson(paramMostUsedSearchItem);
      str1 = str2;
      if (paramMostUsedSearchItem != null) {
        str1 = paramMostUsedSearchItem.toString();
      }
    }
    str2 = a;
    if (str1 == null) {}
    for (paramMostUsedSearchItem = "";; paramMostUsedSearchItem = str1)
    {
      QLog.d(str2, 2, paramMostUsedSearchItem);
      return str1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.mostused.MostUsedSearchItem
 * JD-Core Version:    0.7.0.1
 */