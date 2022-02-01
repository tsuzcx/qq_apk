package cooperation.qzone.contentbox.model;

import NS_MOBILE_FEEDS.single_feed;
import NS_QZONE_MQMSG.NewMQMsg;
import NS_QZONE_MQMSG.PostBar;
import com.tencent.qzonehub.api.contentbox.IMQMsg;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class MQMsg
  implements IMQMsg
{
  public static final String TAG = "QZoneMsgManager.MQMsg";
  public MQBottomCell bottomCell = null;
  public String capTime;
  public String content = "";
  public String eventTitle;
  public Map<String, String> expand = null;
  public List<single_feed> feeds;
  public int isNewStyle = 0;
  public String jumpUrlToDetail = "";
  public MQUserPersonalData mqUserPersonalData;
  public MQMsgBody msgBody = null;
  public MQMsgInteractData msgInteractData = null;
  public long msgSize = 0L;
  public int msgType = 0;
  public PostBar postGuide;
  public String promot = "";
  public long pushTime = 0L;
  public String reportValue;
  public String title = "";
  public String uniKey;
  public String user_avatar = "";
  public String user_nick = "";
  
  private static JSONObject convertToJson(Map<String, String> paramMap)
  {
    if ((paramMap != null) && (paramMap.size() != 0)) {
      return new JSONObject(paramMap);
    }
    return null;
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
    localMQMsg.reportValue = paramNewMQMsg.reportValue;
    localMQMsg.content = paramNewMQMsg.content;
    localMQMsg.msgSize = paramNewMQMsg.msgSize;
    localMQMsg.isNewStyle = paramNewMQMsg.isNewStyle;
    localMQMsg.postGuide = paramNewMQMsg.postGuide;
    return localMQMsg;
  }
  
  public static ArrayList<IMQMsg> readFromList(ArrayList<NewMQMsg> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() != 0))
    {
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
    return null;
  }
  
  public JSONObject convertToJson()
  {
    JSONObject localJSONObject = new JSONObject();
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
      Object localObject;
      if (this.mqUserPersonalData == null) {
        localObject = this.mqUserPersonalData;
      } else {
        localObject = this.mqUserPersonalData.convertToJson();
      }
      localJSONObject.put("mqUserPersonalData", localObject);
      localJSONObject.put("uniKey", this.uniKey);
      localJSONObject.put("eventTitle", this.eventTitle);
      localJSONObject.put("capTime", this.capTime);
      localJSONObject.put("reportValue", this.reportValue);
      localJSONObject.put("content", this.content);
      localJSONObject.put("msgSize", this.msgSize);
      localJSONObject.put("isNewStyle", this.isNewStyle);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      QZLog.e("QZoneMsgManager.MQMsg", "convertToJson error", localException);
    }
    return localJSONObject;
  }
  
  public List getFeeds()
  {
    return this.feeds;
  }
  
  public long getPushTime()
  {
    return this.pushTime;
  }
  
  public String getReportRev6()
  {
    if (this.isNewStyle < 2) {
      return "1";
    }
    if (this.msgSize == 0L) {
      return "3";
    }
    return "2";
  }
  
  public boolean isNewSmallCard()
  {
    return (this.isNewStyle >= 2) && (this.msgSize == 0L);
  }
  
  public int isNewStyle()
  {
    return this.isNewStyle;
  }
  
  public boolean isNewStyleCard()
  {
    return this.isNewStyle >= 2;
  }
  
  public boolean isRecommGuideCard()
  {
    return this.msgType == 13;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.contentbox.model.MQMsg
 * JD-Core Version:    0.7.0.1
 */