package com.tencent.mobileqq.profilecard.bussiness.troop.fansinfo;

import android.text.TextUtils;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class TroopFansEntryConfig
{
  protected static final int SWITCH_OFF = 0;
  protected static final int SWITCH_ON = 1;
  public static final String TAG = "TroopFansEntryConfig";
  public int mGroupEntranceSwitch = 1;
  public int mGuideSwitch = 1;
  public int mProfileCardEntranceSwitch = 1;
  
  public static TroopFansEntryConfig parse(QConfItem[] paramArrayOfQConfItem)
  {
    TroopFansEntryConfig localTroopFansEntryConfig = new TroopFansEntryConfig();
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
            QLog.i("TroopFansEntryConfig", 2, localStringBuilder.toString());
          }
          localTroopFansEntryConfig.mProfileCardEntranceSwitch = ((JSONObject)localObject).optInt("profileCardEntranceSwitch", 0);
          localTroopFansEntryConfig.mGroupEntranceSwitch = ((JSONObject)localObject).optInt("groupEntranceSwitch", 0);
          localTroopFansEntryConfig.mGuideSwitch = ((JSONObject)localObject).optInt("guideSwitch", 0);
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
        }
      }
      i += 1;
    }
    if (QLog.isColorLevel())
    {
      paramArrayOfQConfItem = new StringBuilder();
      paramArrayOfQConfItem.append("config:");
      paramArrayOfQConfItem.append(localTroopFansEntryConfig.toString());
      QLog.i("TroopFansEntryConfig", 2, paramArrayOfQConfItem.toString());
    }
    return localTroopFansEntryConfig;
  }
  
  public boolean isGroupEntranceSwitchOn()
  {
    return this.mGroupEntranceSwitch == 1;
  }
  
  public boolean isGuideSwitchOn()
  {
    return this.mGuideSwitch == 1;
  }
  
  public boolean isProfileCardEntranceSwitchOn()
  {
    return this.mProfileCardEntranceSwitch == 1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mProfileCardEntranceSwitch:");
    localStringBuilder.append(this.mProfileCardEntranceSwitch);
    localStringBuilder.append("\r\n");
    localStringBuilder.append("mGroupEntranceSwitch:");
    localStringBuilder.append(this.mGroupEntranceSwitch);
    localStringBuilder.append("\r\n");
    localStringBuilder.append("mGuideSwitch:");
    localStringBuilder.append(this.mGuideSwitch);
    localStringBuilder.append("\r\n");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.troop.fansinfo.TroopFansEntryConfig
 * JD-Core Version:    0.7.0.1
 */