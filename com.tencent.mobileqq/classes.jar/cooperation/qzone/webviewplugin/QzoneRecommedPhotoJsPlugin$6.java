package cooperation.qzone.webviewplugin;

import android.os.Bundle;
import org.json.JSONObject;

class QzoneRecommedPhotoJsPlugin$6
  implements QzoneRecommedPhotoJsPlugin.OnCallJsBridge
{
  QzoneRecommedPhotoJsPlugin$6(QzoneRecommedPhotoJsPlugin paramQzoneRecommedPhotoJsPlugin) {}
  
  public void setData(JSONObject paramJSONObject, Bundle paramBundle)
  {
    paramJSONObject.put("recommend_on", paramBundle.getString("recommend_on"));
    paramJSONObject.put("recommendPush_on", paramBundle.getString("recommendPush_on"));
    paramJSONObject.put("recommendNotification_on", paramBundle.getString("recommendNotification_on"));
    paramJSONObject.put("recommendChatCachePhoto_on", paramBundle.getString("recommendChatCachePhoto_on"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzoneRecommedPhotoJsPlugin.6
 * JD-Core Version:    0.7.0.1
 */