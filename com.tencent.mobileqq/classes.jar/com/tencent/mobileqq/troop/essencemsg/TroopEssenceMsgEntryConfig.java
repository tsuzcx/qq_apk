package com.tencent.mobileqq.troop.essencemsg;

import android.text.TextUtils;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TroopEssenceMsgEntryConfig
{
  public int a = 20;
  public ArrayList<String> b = new ArrayList();
  public boolean c = true;
  
  public static TroopEssenceMsgEntryConfig a(QConfItem[] paramArrayOfQConfItem)
  {
    TroopEssenceMsgEntryConfig localTroopEssenceMsgEntryConfig = new TroopEssenceMsgEntryConfig();
    int i = 0;
    Object localObject;
    if (i < paramArrayOfQConfItem.length)
    {
      localObject = paramArrayOfQConfItem[i].b;
      if (TextUtils.isEmpty((CharSequence)localObject)) {}
    }
    for (;;)
    {
      try
      {
        localObject = new JSONObject((String)localObject);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("jsonObj:");
          localStringBuilder.append(((JSONObject)localObject).toString());
          QLog.i("TroopEssenceMsgEntryConfig", 2, localStringBuilder.toString());
        }
        localTroopEssenceMsgEntryConfig.a = ((JSONObject)localObject).optInt("limitMemberNum", 0);
        if (((JSONObject)localObject).optInt("globalOpenWithNoCheckGrayUin", 0) <= 0) {
          break label243;
        }
        bool = true;
        localTroopEssenceMsgEntryConfig.c = bool;
        localObject = ((JSONObject)localObject).optJSONArray("grayQunUin");
        if ((localObject != null) && (((JSONArray)localObject).length() > 0))
        {
          int j = 0;
          if (j < ((JSONArray)localObject).length())
          {
            localTroopEssenceMsgEntryConfig.b.add(String.valueOf(((JSONArray)localObject).get(j)));
            j += 1;
            continue;
          }
        }
        i += 1;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      break;
      if (QLog.isColorLevel())
      {
        paramArrayOfQConfItem = new StringBuilder();
        paramArrayOfQConfItem.append("config:");
        paramArrayOfQConfItem.append(localTroopEssenceMsgEntryConfig.toString());
        QLog.i("TroopEssenceMsgEntryConfig", 2, paramArrayOfQConfItem.toString());
      }
      return localTroopEssenceMsgEntryConfig;
      label243:
      boolean bool = false;
    }
  }
  
  public int a()
  {
    return this.a;
  }
  
  public boolean a(String paramString)
  {
    if (this.c) {
      return true;
    }
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    int i = paramString.length();
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ((i >= str.length()) && (paramString.substring(i - str.length()).equals(str))) {
        return true;
      }
    }
    return false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mLimitMemberNum:");
    localStringBuilder.append(this.a);
    localStringBuilder.append("\r\n");
    localStringBuilder.append("mGlobalOpenWithNoCheckGrayUin:");
    localStringBuilder.append(this.c);
    localStringBuilder.append("\r\n");
    localStringBuilder.append("mGrayTroopTailUins:");
    localStringBuilder.append(this.b.toArray());
    localStringBuilder.append("\r\n");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.essencemsg.TroopEssenceMsgEntryConfig
 * JD-Core Version:    0.7.0.1
 */