package com.tencent.mobileqq.config.business;

import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class GameCenterEnterConfBean
{
  public int a = 0;
  public int b = 0;
  
  public static GameCenterEnterConfBean a(QConfItem[] paramArrayOfQConfItem)
  {
    localGameCenterEnterConfBean = new GameCenterEnterConfBean();
    int i = 0;
    try
    {
      while (i < paramArrayOfQConfItem.length)
      {
        JSONObject localJSONObject = new JSONObject(paramArrayOfQConfItem[i].a);
        if (localJSONObject.has("gc_zone_entry_optimize"))
        {
          localGameCenterEnterConfBean.a = localJSONObject.optInt("gc_zone_entry_optimize");
          if (QLog.isColorLevel()) {
            QLog.d("GameCenterEnterConfBean", 1, "onParsed mGcZoneEntryOptimize=" + localGameCenterEnterConfBean.a);
          }
        }
        if (localJSONObject.has("gc_msg_remind_optimize"))
        {
          localGameCenterEnterConfBean.b = localJSONObject.optInt("gc_msg_remind_optimize");
          if (QLog.isColorLevel()) {
            QLog.d("GameCenterEnterConfBean", 1, "onParsed mgcMsgRemindOptimize=" + localGameCenterEnterConfBean.b);
          }
        }
        i += 1;
      }
      return localGameCenterEnterConfBean;
    }
    catch (Throwable paramArrayOfQConfItem)
    {
      QLog.e("GameCenterEnterConfBean", 1, "GameCenterEnterConfBean parse error e=" + paramArrayOfQConfItem.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.GameCenterEnterConfBean
 * JD-Core Version:    0.7.0.1
 */