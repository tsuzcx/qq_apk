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
    boolean bool = false;
    try
    {
      paramEIPCResult = paramEIPCResult.data;
      if (paramEIPCResult != null) {
        bool = paramEIPCResult.getBoolean("isWhiteName", false);
      }
      if (QLog.isColorLevel()) {
        QLog.d("CommonJsHandler", 2, "isWhiteName result return ");
      }
      paramEIPCResult = new JSONObject();
      paramEIPCResult.put("result", bool);
      this.this$0.callJs(this.val$callbackId + "(" + paramEIPCResult.toString() + ");");
      return;
    }
    catch (Exception paramEIPCResult)
    {
      QLog.e("CommonJsHandler", 2, "isWhiteName erro " + paramEIPCResult);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.ThemeAndBubbleCommonJsPlugin.6
 * JD-Core Version:    0.7.0.1
 */