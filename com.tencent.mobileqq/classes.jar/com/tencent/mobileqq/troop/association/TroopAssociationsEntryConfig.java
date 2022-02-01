package com.tencent.mobileqq.troop.association;

import android.text.TextUtils;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TroopAssociationsEntryConfig
{
  public int a = 0;
  public int b = 0;
  public ArrayList<Integer> c = new ArrayList();
  
  public static TroopAssociationsEntryConfig a(QConfItem[] paramArrayOfQConfItem)
  {
    TroopAssociationsEntryConfig localTroopAssociationsEntryConfig = new TroopAssociationsEntryConfig();
    int i = 0;
    while (i < paramArrayOfQConfItem.length)
    {
      Object localObject = paramArrayOfQConfItem[i].b;
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        try
        {
          localObject = new JSONObject((String)localObject);
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("jsonObj:");
            localStringBuilder.append(((JSONObject)localObject).toString());
            QLog.i("TroopAssociationsEntryConfig", 2, localStringBuilder.toString());
          }
          localTroopAssociationsEntryConfig.a = ((JSONObject)localObject).optInt("switchOn", 0);
          localTroopAssociationsEntryConfig.b = ((JSONObject)localObject).optInt("troopMemberCount_ahn", 0);
          localObject = ((JSONObject)localObject).optJSONArray("troopType_ahn");
          if ((localObject != null) && (((JSONArray)localObject).length() > 0))
          {
            int j = 0;
            while (j < ((JSONArray)localObject).length())
            {
              if ((((JSONArray)localObject).get(j) instanceof Integer)) {
                localTroopAssociationsEntryConfig.c.add((Integer)((JSONArray)localObject).get(j));
              }
              j += 1;
            }
          }
          i += 1;
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
        }
      }
    }
    if (QLog.isColorLevel())
    {
      paramArrayOfQConfItem = new StringBuilder();
      paramArrayOfQConfItem.append("config:");
      paramArrayOfQConfItem.append(localTroopAssociationsEntryConfig.toString());
      QLog.i("TroopAssociationsEntryConfig", 2, paramArrayOfQConfItem.toString());
    }
    return localTroopAssociationsEntryConfig;
  }
  
  public boolean a(TroopInfoData paramTroopInfoData)
  {
    int i = this.a;
    if (i == 0) {
      return false;
    }
    if (i == 2) {
      return true;
    }
    if ((i == 1) && (paramTroopInfoData != null))
    {
      if (TextUtils.isEmpty(paramTroopInfoData.troopUin)) {
        return false;
      }
      if ((paramTroopInfoData.troopMemberMaxNum <= this.b) && (this.c.contains(Integer.valueOf((int)paramTroopInfoData.dwGroupClassExt)))) {
        return true;
      }
    }
    return false;
  }
  
  public boolean a(String paramString, int paramInt, long paramLong)
  {
    int i = this.a;
    if (i == 0) {
      return false;
    }
    if (i == 2) {
      return true;
    }
    if (i == 1)
    {
      if (TextUtils.isEmpty(paramString)) {
        return false;
      }
      if ((paramInt <= this.b) && (this.c.contains(Integer.valueOf((int)paramLong)))) {
        return true;
      }
    }
    return false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mSwitchOn:");
    localStringBuilder.append(this.a);
    localStringBuilder.append("\r\n");
    localStringBuilder.append("mTroopMemberCount:");
    localStringBuilder.append(this.b);
    localStringBuilder.append("\r\n");
    localStringBuilder.append("mGrayTroopType:");
    localStringBuilder.append(this.c.toString());
    localStringBuilder.append("\r\n");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.association.TroopAssociationsEntryConfig
 * JD-Core Version:    0.7.0.1
 */