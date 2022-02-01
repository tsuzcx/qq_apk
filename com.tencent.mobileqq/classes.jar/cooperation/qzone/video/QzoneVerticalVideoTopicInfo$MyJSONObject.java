package cooperation.qzone.video;

import android.text.TextUtils;
import cooperation.qzone.util.QZLog;
import org.json.JSONException;
import org.json.JSONObject;

class QzoneVerticalVideoTopicInfo$MyJSONObject
  extends JSONObject
{
  QzoneVerticalVideoTopicInfo$MyJSONObject(QzoneVerticalVideoTopicInfo paramQzoneVerticalVideoTopicInfo) {}
  
  public MyJSONObject putData(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return this;
    }
    try
    {
      put(paramString1, paramString2);
      return this;
    }
    catch (JSONException paramString1)
    {
      QZLog.d(QzoneVerticalVideoTopicInfo.access$800(this.this$0), 2, "put JSON error", paramString1);
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.video.QzoneVerticalVideoTopicInfo.MyJSONObject
 * JD-Core Version:    0.7.0.1
 */