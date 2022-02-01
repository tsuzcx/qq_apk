package com.tencent.mobileqq.vaswebviewplugin;

import org.json.JSONObject;

class AvatarPendantJsPlugin$1$1
  implements Runnable
{
  AvatarPendantJsPlugin$1$1(AvatarPendantJsPlugin.1 param1, JSONObject paramJSONObject) {}
  
  public void run()
  {
    AvatarPendantJsPlugin localAvatarPendantJsPlugin = this.this$1.this$0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.this$1.val$callbackId);
    localStringBuilder.append("(");
    localStringBuilder.append(this.val$result.toString());
    localStringBuilder.append(");");
    localAvatarPendantJsPlugin.callJs(localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.AvatarPendantJsPlugin.1.1
 * JD-Core Version:    0.7.0.1
 */