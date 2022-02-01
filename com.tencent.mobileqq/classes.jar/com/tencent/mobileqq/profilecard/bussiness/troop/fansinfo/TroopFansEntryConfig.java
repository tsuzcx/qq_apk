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
    int i = 0;
    TroopFansEntryConfig localTroopFansEntryConfig = new TroopFansEntryConfig();
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
            QLog.i("TroopFansEntryConfig", 2, "jsonObj:" + ((JSONObject)localObject).toString());
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
    }
    if (QLog.isColorLevel()) {
      QLog.i("TroopFansEntryConfig", 2, "config:" + localTroopFansEntryConfig.toString());
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
    localStringBuilder.append("mProfileCardEntranceSwitch:").append(this.mProfileCardEntranceSwitch).append("\r\n");
    localStringBuilder.append("mGroupEntranceSwitch:").append(this.mGroupEntranceSwitch).append("\r\n");
    localStringBuilder.append("mGuideSwitch:").append(this.mGuideSwitch).append("\r\n");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.troop.fansinfo.TroopFansEntryConfig
 * JD-Core Version:    0.7.0.1
 */