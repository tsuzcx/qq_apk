package cooperation.qzone.contentbox.model;

import NS_QZONE_MQMSG.UnReadSummaryInfo;
import cooperation.qzone.util.QZLog;
import java.io.Serializable;
import org.json.JSONObject;

public class MQUnReadSummaryInfo
  implements Serializable
{
  public static final String TAG = "QZoneMsgManager.MQUnReadSummaryInfo";
  public String attachInfo = "";
  public int hasMore = 0;
  public int needMoreUnreadMsg = 0;
  public int reqNum = 0;
  
  public static MQUnReadSummaryInfo parseFromJson(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    MQUnReadSummaryInfo localMQUnReadSummaryInfo = new MQUnReadSummaryInfo();
    try
    {
      localMQUnReadSummaryInfo.hasMore = paramJSONObject.optInt("hasmore");
      localMQUnReadSummaryInfo.attachInfo = paramJSONObject.optString("attach_info");
      localMQUnReadSummaryInfo.reqNum = paramJSONObject.optInt("req_num");
      localMQUnReadSummaryInfo.needMoreUnreadMsg = paramJSONObject.optInt("need_more_unread_msg");
      return localMQUnReadSummaryInfo;
    }
    catch (Exception paramJSONObject)
    {
      QZLog.e("QZoneMsgManager.MQUnReadSummaryInfo", "parseFromJson error", paramJSONObject);
    }
    return localMQUnReadSummaryInfo;
  }
  
  public static MQUnReadSummaryInfo readFrom(UnReadSummaryInfo paramUnReadSummaryInfo)
  {
    MQUnReadSummaryInfo localMQUnReadSummaryInfo = new MQUnReadSummaryInfo();
    localMQUnReadSummaryInfo.hasMore = paramUnReadSummaryInfo.hasmore;
    localMQUnReadSummaryInfo.attachInfo = paramUnReadSummaryInfo.attach_info;
    localMQUnReadSummaryInfo.reqNum = paramUnReadSummaryInfo.req_num;
    localMQUnReadSummaryInfo.needMoreUnreadMsg = paramUnReadSummaryInfo.need_more_unread_msg;
    return localMQUnReadSummaryInfo;
  }
  
  public JSONObject convertToJson()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("hasmore", this.hasMore);
      localJSONObject.put("attach_info", this.attachInfo);
      localJSONObject.put("req_num", this.reqNum);
      localJSONObject.put("need_more_unread_msg", this.needMoreUnreadMsg);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      QZLog.e("QZoneMsgManager.MQUnReadSummaryInfo", "convertToJson error", localException);
    }
    return localJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.contentbox.model.MQUnReadSummaryInfo
 * JD-Core Version:    0.7.0.1
 */