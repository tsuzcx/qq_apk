package com.tencent.mobileqq.vaswebviewplugin;

import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;
import com.tencent.mobileqq.utils.QQCustomDialogThreeBtns;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import org.json.JSONObject;

class VasCommonJsPlugin$4
  implements DialogInterface.OnKeyListener
{
  VasCommonJsPlugin$4(VasCommonJsPlugin paramVasCommonJsPlugin, QQCustomDialogThreeBtns paramQQCustomDialogThreeBtns, JsBridgeListener paramJsBridgeListener) {}
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (this.val$treeBtnDialog.isShowing()))
    {
      this.val$treeBtnDialog.dismiss();
      paramDialogInterface = new JSONObject();
      try
      {
        paramDialogInterface.put("message", " press");
        this.val$listener.a(paramDialogInterface);
        return true;
      }
      catch (Exception paramDialogInterface)
      {
        for (;;)
        {
          this.val$listener.a("Exception:" + paramDialogInterface.getMessage());
          paramDialogInterface.printStackTrace();
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.VasCommonJsPlugin.4
 * JD-Core Version:    0.7.0.1
 */