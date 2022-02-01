package cooperation.qzone.webviewplugin;

import android.os.Bundle;
import org.json.JSONObject;

class QzoneRecommedPhotoJsPlugin$7
  implements QzoneRecommedPhotoJsPlugin.OnCallJsBridge
{
  QzoneRecommedPhotoJsPlugin$7(QzoneRecommedPhotoJsPlugin paramQzoneRecommedPhotoJsPlugin) {}
  
  public void setData(JSONObject paramJSONObject, Bundle paramBundle)
  {
    paramJSONObject.put("status", paramBundle.getInt("status", 1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzoneRecommedPhotoJsPlugin.7
 * JD-Core Version:    0.7.0.1
 */