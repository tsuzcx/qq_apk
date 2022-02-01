package com.tencent.mobileqq.troop.essencemsg;

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
  public ArrayList<String> a;
  public boolean a;
  
  public TroopEssenceMsgEntryInCardConfig()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Boolean = false;
  }
  
  public static TroopEssenceMsgEntryInCardConfig a(QConfItem[] paramArrayOfQConfItem)
  {
    TroopEssenceMsgEntryInCardConfig localTroopEssenceMsgEntryInCardConfig = new TroopEssenceMsgEntryInCardConfig();
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
            QLog.i("TroopEssenceMsgEntryInCardConfig", 2, "jsonObj:" + ((JSONObject)localObject).toString());
          }
          if (((JSONObject)localObject).optInt("Summary_globalOpenWithNoCheckGrayUin", 0) > 0) {}
          for (boolean bool = true;; bool = false)
          {
            localTroopEssenceMsgEntryInCardConfig.jdField_a_of_type_Boolean = bool;
            localObject = ((JSONObject)localObject).optJSONArray("Summary_grayQunUin");
            if ((localObject == null) || (((JSONArray)localObject).length() <= 0)) {
              break;
            }
            int j = 0;
            while (j < ((JSONArray)localObject).length())
            {
              localTroopEssenceMsgEntryInCardConfig.jdField_a_of_type_JavaUtilArrayList.add(String.valueOf(((JSONArray)localObject).get(j)));
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
      QLog.i("TroopEssenceMsgEntryInCardConfig", 2, "config:" + localTroopEssenceMsgEntryInCardConfig.toString());
    }
    return localTroopEssenceMsgEntryInCardConfig;
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
    return "TroopEssenceMsgEntryInCardConfig{mGrayTroopTailUins=" + this.jdField_a_of_type_JavaUtilArrayList + ", mGlobalOpenWithNoCheckGrayUin=" + this.jdField_a_of_type_Boolean + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.essencemsg.TroopEssenceMsgEntryInCardConfig
 * JD-Core Version:    0.7.0.1
 */