package com.tencent.mobileqq.jsp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppActivity;
import mqq.app.QQPermissionCallback;
import org.json.JSONObject;

class MediaApiPlugin$1
  implements QQPermissionCallback
{
  MediaApiPlugin$1(MediaApiPlugin paramMediaApiPlugin, Intent paramIntent, Context paramContext, String paramString, JSONObject paramJSONObject, boolean paramBoolean, AppActivity paramAppActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QLog.d(MediaApiPlugin.d, 1, "User requestPermissions RECORD_AUDIO denied");
    DialogUtil.a(this.f, paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    try
    {
      this.g.startActivityForResult(this.a, (byte)1);
      MediaApiPlugin.a(this.b).edit().putString("camera_photo_path", this.c).putString("getMediaParam", this.d.toString()).putBoolean("calledFromOpenApi", this.e).commit();
      return;
    }
    catch (Exception paramArrayOfString)
    {
      QLog.e(MediaApiPlugin.d, 1, paramArrayOfString, new Object[0]);
      QQToast.makeText(this.b, 2131887645, 0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.MediaApiPlugin.1
 * JD-Core Version:    0.7.0.1
 */