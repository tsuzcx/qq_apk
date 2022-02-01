package com.tencent.mobileqq.config.business;

import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class MsgTabCameraConfBean
{
  public int a = 1;
  
  public static MsgTabCameraConfBean a(QConfItem[] paramArrayOfQConfItem)
  {
    MsgTabCameraConfBean localMsgTabCameraConfBean = new MsgTabCameraConfBean();
    for (;;)
    {
      int i;
      try
      {
        int j = paramArrayOfQConfItem.length;
        i = 0;
        if (i < j)
        {
          JSONObject localJSONObject = new JSONObject(paramArrayOfQConfItem[i].a);
          if (localJSONObject.has("cameraSwitchOnMessageTab")) {
            localMsgTabCameraConfBean.a = Integer.valueOf(localJSONObject.optString("cameraSwitchOnMessageTab")).intValue();
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("MsgTabCameraConfBean", 2, "onParsed switch= " + localMsgTabCameraConfBean.a);
          }
          return localMsgTabCameraConfBean;
        }
      }
      catch (Throwable paramArrayOfQConfItem)
      {
        QLog.e("MsgTabCameraConfBean", 1, "MsgTabCameraConfBean parse error, ", paramArrayOfQConfItem);
        return localMsgTabCameraConfBean;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.MsgTabCameraConfBean
 * JD-Core Version:    0.7.0.1
 */