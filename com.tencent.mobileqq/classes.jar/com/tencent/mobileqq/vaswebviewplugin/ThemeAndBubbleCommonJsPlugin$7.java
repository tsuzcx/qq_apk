package com.tencent.mobileqq.vaswebviewplugin;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import axqy;
import org.json.JSONObject;

class ThemeAndBubbleCommonJsPlugin$7
  extends Handler
{
  ThemeAndBubbleCommonJsPlugin$7(ThemeAndBubbleCommonJsPlugin paramThemeAndBubbleCommonJsPlugin) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1) {
      for (;;)
      {
        try
        {
          int i = paramMessage.getData().getInt("downResult");
          paramMessage = new JSONObject();
          switch (i)
          {
          case 0: 
            paramMessage.put("ret", 3);
            if (i != 0) {
              break label152;
            }
            axqy.b(null, "CliOper", "", "", "starphoto", "downloadsuc_starphoto_button", 0, 0, "", "", "", "");
            this.this$0.callJs(this.this$0.saveCallbackId, new String[] { paramMessage.toString() });
            return;
          }
        }
        catch (Exception paramMessage)
        {
          this.this$0.callJsOnError(this.this$0.saveCallbackId, paramMessage.getMessage());
          return;
        }
        paramMessage.put("ret", 0);
        continue;
        paramMessage.put("ret", 2);
        continue;
        label152:
        axqy.b(null, "CliOper", "", "", "starphoto", "downloadfail_starphoto_button", 0, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.ThemeAndBubbleCommonJsPlugin.7
 * JD-Core Version:    0.7.0.1
 */