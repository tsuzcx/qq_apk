package com.tencent.mobileqq.leba.config;

import android.text.TextUtils;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class LebaRedTouchSwitchBean
{
  public boolean a = false;
  
  public static LebaRedTouchSwitchBean a(QConfItem[] paramArrayOfQConfItem)
  {
    LebaRedTouchSwitchBean localLebaRedTouchSwitchBean = new LebaRedTouchSwitchBean();
    Object localObject2 = null;
    boolean bool = false;
    Object localObject1 = localObject2;
    if (paramArrayOfQConfItem != null) {
      localObject1 = localObject2;
    }
    try
    {
      if (paramArrayOfQConfItem.length > 0) {
        localObject1 = paramArrayOfQConfItem[0].b;
      }
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        QLog.i("LebaRedTouchSwitchBean", 1, "content is empty");
        return localLebaRedTouchSwitchBean;
      }
      if (new JSONObject((String)localObject1).optInt("red_touch_all_tianshu", 0) == 1) {
        bool = true;
      }
      localLebaRedTouchSwitchBean.a = bool;
      paramArrayOfQConfItem = new StringBuilder("parse config=");
      paramArrayOfQConfItem.append((String)localObject1);
      paramArrayOfQConfItem.append(",mRedTouchAllTianshu=");
      paramArrayOfQConfItem.append(localLebaRedTouchSwitchBean.a);
      QLog.i("LebaRedTouchSwitchBean", 1, paramArrayOfQConfItem.toString());
      return localLebaRedTouchSwitchBean;
    }
    catch (Exception paramArrayOfQConfItem)
    {
      QLog.i("LebaRedTouchSwitchBean", 1, "handleLebaConfig parse", paramArrayOfQConfItem);
    }
    return localLebaRedTouchSwitchBean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.config.LebaRedTouchSwitchBean
 * JD-Core Version:    0.7.0.1
 */