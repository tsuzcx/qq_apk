package cooperation.qzone.webviewplugin;

import android.text.TextUtils;
import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.remote.logic.RemoteRequestSender;
import org.json.JSONException;
import org.json.JSONObject;

class QZonePassivePraiseJsPlugin$1
  implements Runnable
{
  QZonePassivePraiseJsPlugin$1(QZonePassivePraiseJsPlugin paramQZonePassivePraiseJsPlugin, String[] paramArrayOfString) {}
  
  public void run()
  {
    Object localObject = this.val$args;
    if ((localObject != null) && (localObject.length > 0) && (localObject[0] != null))
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(localObject[0]);
        localObject = localJSONObject.getString("zipUrl");
        try
        {
          QZonePassivePraiseJsPlugin.access$002(this.this$0, localJSONObject.getString("callback"));
        }
        catch (JSONException localJSONException1) {}
        localJSONException2.printStackTrace();
      }
      catch (JSONException localJSONException2)
      {
        localObject = "";
      }
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        if (TextUtils.isEmpty(QZonePassivePraiseJsPlugin.access$000(this.this$0))) {
          return;
        }
        RemoteHandleManager.getInstance().getSender().downloadPassivePraise("", (String)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QZonePassivePraiseJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */