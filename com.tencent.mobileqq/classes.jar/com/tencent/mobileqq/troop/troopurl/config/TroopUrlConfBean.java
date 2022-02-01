package com.tencent.mobileqq.troop.troopurl.config;

import android.text.TextUtils;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class TroopUrlConfBean
{
  public String a;
  public boolean a;
  public String b = "https://qun.qq.com/qqweb/m/qun/qun_robot/auto-approval.html?_wv=1027&gc=$GCODE$&page=groupSetting";
  
  public TroopUrlConfBean()
  {
    this.jdField_a_of_type_JavaLangString = "https://web.qun.qq.com/mannounce/index.html?_wv=1031&_bid=148#gc=$GCODE$&role=$ROLE$&actionIcon=1&from=troop_profile";
    this.jdField_a_of_type_Boolean = false;
  }
  
  public static TroopUrlConfBean a(QConfItem[] paramArrayOfQConfItem)
  {
    TroopUrlConfBean localTroopUrlConfBean = new TroopUrlConfBean();
    int i;
    Object localObject;
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      int j = paramArrayOfQConfItem.length;
      i = 0;
      if (i < j)
      {
        localObject = paramArrayOfQConfItem[i];
        if ((localObject != null) && (((QConfItem)localObject).jdField_a_of_type_JavaLangString != null)) {
          localObject = ((QConfItem)localObject).jdField_a_of_type_JavaLangString;
        }
      }
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject((String)localObject);
        if (localJSONObject.has("announcementUrl")) {
          localTroopUrlConfBean.jdField_a_of_type_JavaLangString = localJSONObject.optString("announcementUrl");
        }
        if (localJSONObject.has("autoApprovalUrl")) {
          localTroopUrlConfBean.b = localJSONObject.optString("autoApprovalUrl");
        }
        if (localJSONObject.has("frequencyLimitVisible"))
        {
          int k = localJSONObject.getInt("frequencyLimitVisible");
          bool = true;
          if (k != 1) {
            break label254;
          }
          localTroopUrlConfBean.jdField_a_of_type_Boolean = bool;
        }
        else
        {
          localTroopUrlConfBean.jdField_a_of_type_Boolean = false;
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("parse: ");
        localStringBuilder.append((String)localObject);
        QLog.i("TroopUrlConfBean", 2, localStringBuilder.toString());
      }
      i += 1;
      break;
      if (TextUtils.isEmpty(localTroopUrlConfBean.jdField_a_of_type_JavaLangString)) {
        localTroopUrlConfBean.jdField_a_of_type_JavaLangString = "https://web.qun.qq.com/mannounce/index.html?_wv=1031&_bid=148#gc=$GCODE$&role=$ROLE$&actionIcon=1&from=troop_profile";
      }
      if (TextUtils.isEmpty(localTroopUrlConfBean.b)) {
        localTroopUrlConfBean.b = "https://qun.qq.com/qqweb/m/qun/qun_robot/auto-approval.html?_wv=1027&gc=$GCODE$&page=groupSetting";
      }
      return localTroopUrlConfBean;
      label254:
      boolean bool = false;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(200);
    localStringBuilder.append("TroopUrlConfBean [announcement: ");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(", autoApproval: ");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", freqLimitVisible: ");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopurl.config.TroopUrlConfBean
 * JD-Core Version:    0.7.0.1
 */