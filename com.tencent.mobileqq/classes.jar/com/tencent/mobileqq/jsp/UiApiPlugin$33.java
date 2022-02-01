package com.tencent.mobileqq.jsp;

import android.os.Bundle;
import com.tencent.mobileqq.activity.miniaio.IMiniMsgUnreadCallback;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class UiApiPlugin$33
  implements IMiniMsgUnreadCallback
{
  UiApiPlugin$33(UiApiPlugin paramUiApiPlugin) {}
  
  public void destroy() {}
  
  public void hide() {}
  
  public void hideUnread()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("unReadHide", true);
      this.a.a("UnRead", localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      QLog.d("UiApiPlugin", 1, localException, new Object[0]);
    }
  }
  
  public boolean show(int paramInt)
  {
    return false;
  }
  
  public void updateOnBackFromMiniAIO(Bundle paramBundle)
  {
    try
    {
      paramBundle = new JSONObject();
      this.a.a("backFromMiniAIO", paramBundle);
      return;
    }
    catch (Exception paramBundle)
    {
      QLog.d("UiApiPlugin", 1, paramBundle, new Object[0]);
    }
  }
  
  public void updateUnreadCount(int paramInt, boolean paramBoolean)
  {
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("unReadC", paramInt);
      ((JSONObject)localObject).put("unReadHide", paramBoolean);
      this.a.a("updateUnreadCount", (JSONObject)localObject);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("mini_msg uiApiPlugin undateUnreadCount = ");
        ((StringBuilder)localObject).append(paramInt);
        QLog.d("UiApiPlugin", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.UiApiPlugin.33
 * JD-Core Version:    0.7.0.1
 */