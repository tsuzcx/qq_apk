package cooperation.qzone.contentbox.model;

import NS_MOBILE_FEEDS.single_feed;
import NS_QZONE_MQMSG.NewMQMsg;
import cooperation.qzone.util.QZLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class MQMsg
  implements Serializable
{
  public static final String TAG = "QZoneMsgManager.MQMsg";
  public MQBottomCell bottomCell;
  public String capTime;
  public String eventTitle;
  public Map<String, String> expand;
  public List<single_feed> feeds;
  public String jumpUrlToDetail = "";
  public MQUserPersonalData mqUserPersonalData;
  public MQMsgBody msgBody;
  public MQMsgInteractData msgInteractData;
  public int msgType;
  public String promot = "";
  public long pushTime;
  public String title = "";
  public String uniKey;
  public String user_avatar = "";
  public String user_nick = "";
  
  private static JSONObject convertToJson(Map<String, String> paramMap)
  {
    if ((paramMap == null) || (paramMap.size() == 0)) {
      return null;
    }
    return new JSONObject(paramMap);
  }
  
  private static Map<String, String> parseExpand(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramJSONObject.keys();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localHashMap.put(str, paramJSONObject.optString(str));
    }
    return localHashMap;
  }
  
  public static MQMsg parseFromJson(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    MQMsg localMQMsg = new MQMsg();
    try
    {
      localMQMsg.msgType = paramJSONObject.optInt("msgType");
      localMQMsg.title = paramJSONObject.optString("title");
      localMQMsg.pushTime = paramJSONObject.optLong("pushTime");
      localMQMsg.user_avatar = paramJSONObject.optString("user_avatar");
      localMQMsg.user_nick = paramJSONObject.optString("user_nick");
      localMQMsg.promot = paramJSONObject.optString("promot");
      localMQMsg.msgBody = MQMsgBody.parseFromJson(paramJSONObject.optJSONObject("msgBody"));
      localMQMsg.msgInteractData = MQMsgInteractData.parseFromJson(paramJSONObject.optJSONObject("msgInteractData"));
      localMQMsg.jumpUrlToDetail = paramJSONObject.optString("jumpUrlToDetail");
      localMQMsg.bottomCell = MQBottomCell.parseFromJson(paramJSONObject.optJSONObject("bottomCell"));
      localMQMsg.expand = parseExpand(paramJSONObject.optJSONObject("expand"));
      localMQMsg.mqUserPersonalData = MQUserPersonalData.parseFromJson(paramJSONObject.optJSONObject("mqUserPersonalData"));
      localMQMsg.uniKey = paramJSONObject.optString("uniKey");
      localMQMsg.eventTitle = paramJSONObject.optString("eventTitle");
      localMQMsg.capTime = paramJSONObject.optString("capTime");
      return localMQMsg;
    }
    catch (Exception paramJSONObject)
    {
      QZLog.e("QZoneMsgManager.MQMsg", "parseFromJson error", paramJSONObject);
    }
    return localMQMsg;
  }
  
  private static MQMsg readFrom(NewMQMsg paramNewMQMsg)
  {
    MQMsg localMQMsg = new MQMsg();
    localMQMsg.msgType = paramNewMQMsg.msgType;
    localMQMsg.title = paramNewMQMsg.title;
    localMQMsg.pushTime = paramNewMQMsg.pushTime;
    localMQMsg.user_avatar = paramNewMQMsg.userAvatar;
    localMQMsg.user_nick = paramNewMQMsg.nick;
    localMQMsg.promot = paramNewMQMsg.promot;
    localMQMsg.msgBody = MQMsgBody.readFrom(paramNewMQMsg.msgBody);
    localMQMsg.msgInteractData = MQMsgInteractData.readFrom(paramNewMQMsg.msgInteractData);
    localMQMsg.jumpUrlToDetail = paramNewMQMsg.jumpUrlToDetail;
    localMQMsg.bottomCell = MQBottomCell.readFrom(paramNewMQMsg.bottomCell);
    localMQMsg.expand = paramNewMQMsg.mpExtent;
    localMQMsg.mqUserPersonalData = MQUserPersonalData.readFrom(paramNewMQMsg.userPersonalData);
    localMQMsg.feeds = paramNewMQMsg.all_feeds_data;
    return localMQMsg;
  }
  
  public static ArrayList<MQMsg> readFromList(ArrayList<NewMQMsg> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      NewMQMsg localNewMQMsg = (NewMQMsg)paramArrayList.next();
      if (localNewMQMsg != null) {
        localArrayList.add(readFrom(localNewMQMsg));
      }
    }
    return localArrayList;
  }
  
  public JSONObject convertToJson()
  {
    localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("msgType", this.msgType);
      localJSONObject.put("title", this.title);
      localJSONObject.put("pushTime", this.pushTime);
      localJSONObject.put("user_avatar", this.user_avatar);
      localJSONObject.put("user_nick", this.user_nick);
      localJSONObject.put("promot", this.promot);
      localJSONObject.put("msgBody", this.msgBody.convertToJson());
      localJSONObject.put("msgInteractData", this.msgInteractData.convertToJson());
      localJSONObject.put("jumpUrlToDetail", this.jumpUrlToDetail);
      localJSONObject.put("bottomCell", this.bottomCell.convertToJson());
      localJSONObject.put("expand", convertToJson(this.expand));
      if (this.mqUserPersonalData == null) {}
      for (Object localObject = this.mqUserPersonalData;; localObject = this.mqUserPersonalData.convertToJson())
      {
        localJSONObject.put("mqUserPersonalData", localObject);
        localJSONObject.put("uniKey", this.uniKey);
        localJSONObject.put("eventTitle", this.eventTitle);
        localJSONObject.put("capTime", this.capTime);
        return localJSONObject;
      }
      return localJSONObject;
    }
    catch (Exception localException)
    {
      QZLog.e("QZoneMsgManager.MQMsg", "convertToJson error", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.contentbox.model.MQMsg
 * JD-Core Version:    0.7.0.1
 */