package com.tencent.mobileqq.vaswebviewplugin;

import com.tencent.qphone.base.util.QLog;
import cooperation.ilive.lite.floatwindow.IliveFloatWindowHelper.IPermissionCallback;
import org.json.JSONObject;

class QQIliveJsPlugin$PermissionCallback
  implements IliveFloatWindowHelper.IPermissionCallback
{
  private int mCloseFrom;
  private JSONObject mJsObject;
  private long mRoomId;
  
  public QQIliveJsPlugin$PermissionCallback(QQIliveJsPlugin paramQQIliveJsPlugin, long paramLong, int paramInt, JSONObject paramJSONObject)
  {
    this.mRoomId = paramLong;
    this.mCloseFrom = paramInt;
    this.mJsObject = paramJSONObject;
  }
  
  public void onFinish(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("float window PermissionCallback isAuth = ");
    localStringBuilder.append(paramBoolean);
    QLog.e("QQIliveJsPlugin", 1, localStringBuilder.toString());
    QQIliveJsPlugin.access$200(this.this$0, this.mRoomId, this.mCloseFrom, this.mJsObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.QQIliveJsPlugin.PermissionCallback
 * JD-Core Version:    0.7.0.1
 */