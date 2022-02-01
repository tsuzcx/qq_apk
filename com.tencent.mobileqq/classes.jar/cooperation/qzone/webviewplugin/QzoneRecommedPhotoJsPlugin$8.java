package cooperation.qzone.webviewplugin;

import android.os.Bundle;
import org.json.JSONObject;

class QzoneRecommedPhotoJsPlugin$8
  implements QzoneRecommedPhotoJsPlugin.OnCallJsBridge
{
  QzoneRecommedPhotoJsPlugin$8(QzoneRecommedPhotoJsPlugin paramQzoneRecommedPhotoJsPlugin) {}
  
  public void setData(JSONObject paramJSONObject, Bundle paramBundle)
  {
    paramJSONObject.put("event_video_album_state", paramBundle.getString("event_video_album_state"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzoneRecommedPhotoJsPlugin.8
 * JD-Core Version:    0.7.0.1
 */