package cooperation.qzone.webviewplugin;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.remote.logic.RemoteRequestSender;
import org.json.JSONObject;

class QzoneRecommedPhotoJsPlugin$5
  implements Runnable
{
  QzoneRecommedPhotoJsPlugin$5(QzoneRecommedPhotoJsPlugin paramQzoneRecommedPhotoJsPlugin, String paramString) {}
  
  public void run()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(this.val$jsonString);
      Bundle localBundle = new Bundle();
      localBundle.putInt("status", localJSONObject.optInt("status"));
      RemoteHandleManager.getInstance().getSender().setQuickMakeDynamicStatus(localBundle);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.w("QzoneRecommedPhotoJsPlugin", 1, "handleSetQuickMakeDynamicStatus error", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzoneRecommedPhotoJsPlugin.5
 * JD-Core Version:    0.7.0.1
 */