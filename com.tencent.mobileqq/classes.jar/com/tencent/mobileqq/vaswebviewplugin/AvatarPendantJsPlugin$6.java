package com.tencent.mobileqq.vaswebviewplugin;

import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet.OnDismissListener;
import org.json.JSONException;
import org.json.JSONObject;

class AvatarPendantJsPlugin$6
  implements ActionSheet.OnDismissListener
{
  AvatarPendantJsPlugin$6(AvatarPendantJsPlugin paramAvatarPendantJsPlugin, String paramString) {}
  
  public void onDismiss()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("result", 2);
    }
    catch (JSONException localJSONException)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("changeFace cancel failed: ");
        localStringBuilder.append(localJSONException.getMessage());
        QLog.e("AvatarPendantJsPlugin", 2, localStringBuilder.toString());
      }
    }
    AvatarPendantJsPlugin localAvatarPendantJsPlugin = this.this$0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.val$callbackId);
    localStringBuilder.append("(");
    localStringBuilder.append(localJSONObject.toString());
    localStringBuilder.append(");");
    localAvatarPendantJsPlugin.callJs(localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.AvatarPendantJsPlugin.6
 * JD-Core Version:    0.7.0.1
 */