package com.tencent.qqmini.minigame.plugins;

import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

class UDPJsPlugin$1
  implements Runnable
{
  UDPJsPlugin$1(UDPJsPlugin paramUDPJsPlugin, IJsService paramIJsService, JSONObject paramJSONObject, UDPJsPlugin.UDPTask paramUDPTask, int paramInt) {}
  
  public void run()
  {
    try
    {
      UDPJsPlugin.access$000(this.this$0, this.val$jsService, this.val$json, this.val$task);
      return;
    }
    catch (JSONException localJSONException)
    {
      QMLog.e("UDPPlugin", "performSend exception", localJSONException);
      UDPJsPlugin.access$100(this.this$0, localJSONException.getMessage(), this.val$taskId);
      return;
    }
    catch (IOException localIOException)
    {
      QMLog.e("UDPPlugin", "performSend exception", localIOException);
      UDPJsPlugin.access$100(this.this$0, localIOException.getMessage(), this.val$taskId);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.minigame.plugins.UDPJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */