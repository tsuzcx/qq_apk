package cooperation.qzone.contentbox.model;

import NS_QZONE_MQMSG.ShareCell;
import cooperation.qzone.util.QZLog;
import java.io.Serializable;
import org.json.JSONObject;

public class MQShareCell
  implements Serializable
{
  public static final String TAG = "QZoneMsgManager.MQMsgNewCell";
  public String content = "";
  public String imgUrl = "";
  public String jumpUrl = "";
  public String title = "";
  
  public static MQShareCell parseFromJson(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    MQShareCell localMQShareCell = new MQShareCell();
    try
    {
      localMQShareCell.title = paramJSONObject.optString("title");
      localMQShareCell.content = paramJSONObject.optString("content");
      localMQShareCell.imgUrl = paramJSONObject.optString("imgUrl");
      localMQShareCell.jumpUrl = paramJSONObject.optString("jumpUrl");
      return localMQShareCell;
    }
    catch (Exception paramJSONObject)
    {
      QZLog.e("QZoneMsgManager.MQMsgNewCell", "parseFromJson error", paramJSONObject);
    }
    return localMQShareCell;
  }
  
  public static MQShareCell readFrom(ShareCell paramShareCell)
  {
    MQShareCell localMQShareCell = new MQShareCell();
    localMQShareCell.title = paramShareCell.title;
    localMQShareCell.content = paramShareCell.content;
    localMQShareCell.imgUrl = paramShareCell.imgUrl;
    localMQShareCell.jumpUrl = paramShareCell.jumpUrl;
    return localMQShareCell;
  }
  
  public JSONObject convertToJson()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("title", this.title);
      localJSONObject.put("content", this.content);
      localJSONObject.put("imgUrl", this.imgUrl);
      localJSONObject.put("jumpUrl", this.jumpUrl);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      QZLog.e("QZoneMsgManager.MQMsgNewCell", "convertToJson error", localException);
    }
    return localJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qzone.contentbox.model.MQShareCell
 * JD-Core Version:    0.7.0.1
 */