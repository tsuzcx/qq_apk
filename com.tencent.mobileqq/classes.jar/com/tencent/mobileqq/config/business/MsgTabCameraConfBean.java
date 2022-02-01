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
          if (!localJSONObject.has("cameraSwitchOnMessageTab")) {
            break label117;
          }
          localMsgTabCameraConfBean.a = Integer.valueOf(localJSONObject.optString("cameraSwitchOnMessageTab")).intValue();
          break label117;
        }
        if (QLog.isColorLevel())
        {
          paramArrayOfQConfItem = new StringBuilder();
          paramArrayOfQConfItem.append("onParsed switch= ");
          paramArrayOfQConfItem.append(localMsgTabCameraConfBean.a);
          QLog.d("MsgTabCameraConfBean", 2, paramArrayOfQConfItem.toString());
          return localMsgTabCameraConfBean;
        }
      }
      catch (Throwable paramArrayOfQConfItem)
      {
        QLog.e("MsgTabCameraConfBean", 1, "MsgTabCameraConfBean parse error, ", paramArrayOfQConfItem);
      }
      return localMsgTabCameraConfBean;
      label117:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.MsgTabCameraConfBean
 * JD-Core Version:    0.7.0.1
 */