package com.tencent.mobileqq.jsp;

import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppActivity;
import mqq.app.QQPermissionCallback;
import org.json.JSONObject;

class MediaApiPlugin$6
  implements QQPermissionCallback
{
  MediaApiPlugin$6(MediaApiPlugin paramMediaApiPlugin, JSONObject paramJSONObject, boolean paramBoolean, AppActivity paramAppActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QLog.d(MediaApiPlugin.d, 1, "User requestPermissions WRITE_EXTERNAL_STORAGE denied");
    DialogUtil.a(this.c, paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.d.a(this.a, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.MediaApiPlugin.6
 * JD-Core Version:    0.7.0.1
 */