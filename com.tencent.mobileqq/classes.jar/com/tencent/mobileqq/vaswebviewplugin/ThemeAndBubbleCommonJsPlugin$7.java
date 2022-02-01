package com.tencent.mobileqq.vaswebviewplugin;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.statistics.ReportController;
import org.json.JSONObject;

class ThemeAndBubbleCommonJsPlugin$7
  extends Handler
{
  ThemeAndBubbleCommonJsPlugin$7(ThemeAndBubbleCommonJsPlugin paramThemeAndBubbleCommonJsPlugin) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1) {
      try
      {
        int i = paramMessage.getData().getInt("downResult");
        paramMessage = new JSONObject();
        if (i != 0)
        {
          if (i != 1) {
            paramMessage.put("ret", 3);
          } else {
            paramMessage.put("ret", 2);
          }
        }
        else {
          paramMessage.put("ret", 0);
        }
        if (i == 0) {
          ReportController.b(null, "CliOper", "", "", "starphoto", "downloadsuc_starphoto_button", 0, 0, "", "", "", "");
        } else {
          ReportController.b(null, "CliOper", "", "", "starphoto", "downloadfail_starphoto_button", 0, 0, "", "", "", "");
        }
        this.this$0.callJs(ThemeAndBubbleCommonJsPlugin.access$000(this.this$0), new String[] { paramMessage.toString() });
        return;
      }
      catch (Exception paramMessage)
      {
        ThemeAndBubbleCommonJsPlugin localThemeAndBubbleCommonJsPlugin = this.this$0;
        localThemeAndBubbleCommonJsPlugin.callJsOnError(ThemeAndBubbleCommonJsPlugin.access$000(localThemeAndBubbleCommonJsPlugin), paramMessage.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.ThemeAndBubbleCommonJsPlugin.7
 * JD-Core Version:    0.7.0.1
 */