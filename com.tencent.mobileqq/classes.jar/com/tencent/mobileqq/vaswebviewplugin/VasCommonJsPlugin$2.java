package com.tencent.mobileqq.vaswebviewplugin;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import org.json.JSONObject;

class VasCommonJsPlugin$2
  implements DialogInterface.OnClickListener
{
  VasCommonJsPlugin$2(VasCommonJsPlugin paramVasCommonJsPlugin, JsBridgeListener paramJsBridgeListener) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new JSONObject();
    try
    {
      paramDialogInterface.put("result", 1);
      paramDialogInterface.put("message", "btn1 press");
      this.val$listener.a(paramDialogInterface);
      return;
    }
    catch (Exception paramDialogInterface)
    {
      this.val$listener.a("Exception:" + paramDialogInterface.getMessage());
      paramDialogInterface.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.VasCommonJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */