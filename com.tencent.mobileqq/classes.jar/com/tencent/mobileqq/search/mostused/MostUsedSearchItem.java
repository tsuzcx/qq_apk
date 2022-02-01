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
  public int identifyType = 0;
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
    if (paramString == null) {
      localObject = "";
    } else {
      localObject = paramString;
    }
    QLog.d(str, 2, (String)localObject);
    Object localObject = new MostUsedSearchItem();
    if (paramString == null) {
      return localObject;
    }
    try
    {
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
      str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("MostUsedSearchItem fromJson ERR;");
      localStringBuilder.append(paramString.toString());
      QLog.e(str, 2, localStringBuilder.toString());
    }
    return localObject;
  }
  
  public static boolean isSameIdentityItem(MostUsedSearchItem paramMostUsedSearchItem1, MostUsedSearchItem paramMostUsedSearchItem2)
  {
    return (paramMostUsedSearchItem1 != null) && (paramMostUsedSearchItem2 != null) && (paramMostUsedSearchItem1.businessType == paramMostUsedSearchItem2.businessType) && (paramMostUsedSearchItem1.identify.equals(paramMostUsedSearchItem2.identify)) && (paramMostUsedSearchItem1.identifyType == paramMostUsedSearchItem2.identifyType);
  }
  
  public static JSONObject toJson(MostUsedSearchItem paramMostUsedSearchItem)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramMostUsedSearchItem != null) {
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
        String str = a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("MostUsedSearchItem toJson ERR;");
        localStringBuilder.append(paramMostUsedSearchItem.toString());
        QLog.e(str, 2, localStringBuilder.toString());
      }
    }
    return localJSONObject;
  }
  
  public static String toJsonString(MostUsedSearchItem paramMostUsedSearchItem)
  {
    if (paramMostUsedSearchItem != null)
    {
      paramMostUsedSearchItem = toJson(paramMostUsedSearchItem);
      if (paramMostUsedSearchItem != null)
      {
        paramMostUsedSearchItem = paramMostUsedSearchItem.toString();
        break label23;
      }
    }
    paramMostUsedSearchItem = null;
    label23:
    String str = a;
    Object localObject;
    if (paramMostUsedSearchItem == null) {
      localObject = "";
    } else {
      localObject = paramMostUsedSearchItem;
    }
    QLog.d(str, 2, (String)localObject);
    return paramMostUsedSearchItem;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.mostused.MostUsedSearchItem
 * JD-Core Version:    0.7.0.1
 */