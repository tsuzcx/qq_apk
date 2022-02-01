package com.tencent.mobileqq.vaswebviewplugin;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import org.json.JSONObject;

class ThemeAndBubbleCommonJsPlugin$6
  implements EIPCResultCallback
{
  ThemeAndBubbleCommonJsPlugin$6(ThemeAndBubbleCommonJsPlugin paramThemeAndBubbleCommonJsPlugin, String paramString) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    try
    {
      paramEIPCResult = paramEIPCResult.data;
      boolean bool = false;
      if (paramEIPCResult != null) {
        bool = paramEIPCResult.getBoolean("isWhiteName", false);
      }
      if (QLog.isColorLevel()) {
        QLog.d("CommonJsHandler", 2, "isWhiteName result return ");
      }
      paramEIPCResult = new JSONObject();
      paramEIPCResult.put("result", bool);
      localObject = this.this$0;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.val$callbackId);
      localStringBuilder.append("(");
      localStringBuilder.append(paramEIPCResult.toString());
      localStringBuilder.append(");");
      ((ThemeAndBubbleCommonJsPlugin)localObject).callJs(localStringBuilder.toString());
      return;
    }
    catch (Exception paramEIPCResult)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isWhiteName erro ");
      ((StringBuilder)localObject).append(paramEIPCResult);
      QLog.e("CommonJsHandler", 2, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.ThemeAndBubbleCommonJsPlugin.6
 * JD-Core Version:    0.7.0.1
 */