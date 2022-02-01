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
  public int a;
  public ArrayList<String> a;
  public boolean a;
  
  public TroopEssenceMsgEntryConfig()
  {
    this.jdField_a_of_type_Int = 20;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Boolean = true;
  }
  
  public static TroopEssenceMsgEntryConfig a(QConfItem[] paramArrayOfQConfItem)
  {
    TroopEssenceMsgEntryConfig localTroopEssenceMsgEntryConfig = new TroopEssenceMsgEntryConfig();
    int i = 0;
    if (i < paramArrayOfQConfItem.length)
    {
      Object localObject = paramArrayOfQConfItem[i].a;
      if (TextUtils.isEmpty((CharSequence)localObject)) {}
      for (;;)
      {
        i += 1;
        break;
        try
        {
          localObject = new JSONObject((String)localObject);
          if (QLog.isColorLevel()) {
            QLog.i("TroopEssenceMsgEntryConfig", 2, "jsonObj:" + ((JSONObject)localObject).toString());
          }
          localTroopEssenceMsgEntryConfig.jdField_a_of_type_Int = ((JSONObject)localObject).optInt("limitMemberNum", 0);
          if (((JSONObject)localObject).optInt("globalOpenWithNoCheckGrayUin", 0) > 0) {}
          for (boolean bool = true;; bool = false)
          {
            localTroopEssenceMsgEntryConfig.jdField_a_of_type_Boolean = bool;
            localObject = ((JSONObject)localObject).optJSONArray("grayQunUin");
            if ((localObject == null) || (((JSONArray)localObject).length() <= 0)) {
              break;
            }
            int j = 0;
            while (j < ((JSONArray)localObject).length())
            {
              localTroopEssenceMsgEntryConfig.jdField_a_of_type_JavaUtilArrayList.add(String.valueOf(((JSONArray)localObject).get(j)));
              j += 1;
            }
          }
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("TroopEssenceMsgEntryConfig", 2, "config:" + localTroopEssenceMsgEntryConfig.toString());
    }
    return localTroopEssenceMsgEntryConfig;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public boolean a(String paramString)
  {
    if (this.jdField_a_of_type_Boolean) {
      return true;
    }
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    int i = paramString.length();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    String str;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      str = (String)localIterator.next();
    } while ((i < str.length()) || (!paramString.substring(i - str.length()).equals(str)));
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mLimitMemberNum:").append(this.jdField_a_of_type_Int).append("\r\n");
    localStringBuilder.append("mGlobalOpenWithNoCheckGrayUin:").append(this.jdField_a_of_type_Boolean).append("\r\n");
    localStringBuilder.append("mGrayTroopTailUins:").append(this.jdField_a_of_type_JavaUtilArrayList.toArray()).append("\r\n");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.essencemsg.TroopEssenceMsgEntryConfig
 * JD-Core Version:    0.7.0.1
 */