package com.tencent.mobileqq.troop.essence;

import android.text.TextUtils;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TroopEssenceMsgEntryInCardConfig
{
  public ArrayList<String> a = new ArrayList();
  public boolean b = false;
  
  public static TroopEssenceMsgEntryInCardConfig a(QConfItem[] paramArrayOfQConfItem)
  {
    TroopEssenceMsgEntryInCardConfig localTroopEssenceMsgEntryInCardConfig = new TroopEssenceMsgEntryInCardConfig();
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
          QLog.i("TroopEssenceMsgEntryInCardConfig", 2, localStringBuilder.toString());
        }
        if (((JSONObject)localObject).optInt("Summary_globalOpenWithNoCheckGrayUin", 0) <= 0) {
          break label230;
        }
        bool = true;
        localTroopEssenceMsgEntryInCardConfig.b = bool;
        localObject = ((JSONObject)localObject).optJSONArray("Summary_grayQunUin");
        if ((localObject != null) && (((JSONArray)localObject).length() > 0))
        {
          int j = 0;
          if (j < ((JSONArray)localObject).length())
          {
            localTroopEssenceMsgEntryInCardConfig.a.add(String.valueOf(((JSONArray)localObject).get(j)));
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
        paramArrayOfQConfItem.append(localTroopEssenceMsgEntryInCardConfig.toString());
        QLog.i("TroopEssenceMsgEntryInCardConfig", 2, paramArrayOfQConfItem.toString());
      }
      return localTroopEssenceMsgEntryInCardConfig;
      label230:
      boolean bool = false;
    }
  }
  
  public boolean a(String paramString)
  {
    if (this.b) {
      return true;
    }
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    int i = paramString.length();
    Iterator localIterator = this.a.iterator();
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
    localStringBuilder.append("TroopEssenceMsgEntryInCardConfig{mGrayTroopTailUins=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", mGlobalOpenWithNoCheckGrayUin=");
    localStringBuilder.append(this.b);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.essence.TroopEssenceMsgEntryInCardConfig
 * JD-Core Version:    0.7.0.1
 */