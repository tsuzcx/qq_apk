package cooperation.qzone.contentbox.model;

import NS_QZONE_MQMSG.PhotoCell;
import cooperation.qzone.util.QZLog;
import java.io.Serializable;
import org.json.JSONObject;

public class MQPhotoCell
  implements Serializable
{
  public static final String TAG = "QZoneMsgManager.MQMsgNewCell";
  public String coverUrl = "";
  public int type = 0;
  
  public static MQPhotoCell parseFromJson(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    MQPhotoCell localMQPhotoCell = new MQPhotoCell();
    try
    {
      localMQPhotoCell.type = paramJSONObject.optInt("type");
      localMQPhotoCell.coverUrl = paramJSONObject.optString("coverUrl");
      return localMQPhotoCell;
    }
    catch (Exception paramJSONObject)
    {
      QZLog.e("QZoneMsgManager.MQMsgNewCell", "parseFromJson error", paramJSONObject);
    }
    return localMQPhotoCell;
  }
  
  public static MQPhotoCell readFrom(PhotoCell paramPhotoCell)
  {
    MQPhotoCell localMQPhotoCell = new MQPhotoCell();
    localMQPhotoCell.type = paramPhotoCell.type;
    localMQPhotoCell.coverUrl = paramPhotoCell.coverUrl;
    return localMQPhotoCell;
  }
  
  public JSONObject convertToJson()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("type", this.type);
      localJSONObject.put("coverUrl", this.coverUrl);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      QZLog.e("QZoneMsgManager.MQMsgNewCell", "convertToJson error", localException);
    }
    return localJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.contentbox.model.MQPhotoCell
 * JD-Core Version:    0.7.0.1
 */