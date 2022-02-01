package cooperation.qzone.contentbox.model;

import NS_QZONE_MQMSG.QzoneMessageBoxRsp;
import NS_QZONE_MQMSG.UnReadSummaryInfo;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.contentbox.IMQMsg;
import com.tencent.qzonehub.model.MQUnReadSummaryInfo;
import com.tencent.qzonehub.model.QZoneMsgEntityNew;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MsgEntityConverter
{
  public static final String TAG = "QZoneMsgEntity.MsgEntityConverter";
  
  public static void addMsg(QZoneMsgEntityNew paramQZoneMsgEntityNew, ArrayList<IMQMsg> paramArrayList)
  {
    if (paramQZoneMsgEntityNew != null)
    {
      if (paramArrayList == null) {
        return;
      }
      if (paramQZoneMsgEntityNew.ArkNes_vec == null) {
        paramQZoneMsgEntityNew.ArkNes_vec = paramArrayList;
      } else {
        paramQZoneMsgEntityNew.ArkNes_vec.addAll(paramArrayList);
      }
      writeArkNewsToBuffer(paramQZoneMsgEntityNew);
    }
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
      localMQMsg.reportValue = paramJSONObject.optString("reportValue");
      localMQMsg.content = paramJSONObject.optString("content");
      localMQMsg.msgSize = paramJSONObject.optInt("msgSize");
      localMQMsg.isNewStyle = paramJSONObject.optInt("isNewStyle");
      return localMQMsg;
    }
    catch (Exception paramJSONObject)
    {
      QLog.e("QZoneMsgEntity.MsgEntityConverter", 1, "parseFromJson error", paramJSONObject);
    }
    return localMQMsg;
  }
  
  public static void readArkNewsFromBuffer(QZoneMsgEntityNew paramQZoneMsgEntityNew)
  {
    if (paramQZoneMsgEntityNew != null)
    {
      if (TextUtils.isEmpty(paramQZoneMsgEntityNew.msgBuffer)) {
        return;
      }
      if (paramQZoneMsgEntityNew.ArkNes_vec != null) {
        paramQZoneMsgEntityNew.ArkNes_vec.clear();
      } else {
        paramQZoneMsgEntityNew.ArkNes_vec = new ArrayList();
      }
      try
      {
        JSONArray localJSONArray = new JSONArray(paramQZoneMsgEntityNew.msgBuffer);
        int i = 0;
        while (i < localJSONArray.length())
        {
          MQMsg localMQMsg = parseFromJson(localJSONArray.getJSONObject(i));
          if (localMQMsg != null) {
            paramQZoneMsgEntityNew.ArkNes_vec.add(localMQMsg);
          }
          i += 1;
        }
        return;
      }
      catch (Exception paramQZoneMsgEntityNew)
      {
        QLog.e("QZoneMsgEntity.MsgEntityConverter", 1, "readArkNewsFromBuffer error", paramQZoneMsgEntityNew);
      }
    }
  }
  
  public static void readBottomItemsFromBuffer(QZoneMsgEntityNew paramQZoneMsgEntityNew)
  {
    if (paramQZoneMsgEntityNew != null)
    {
      if (TextUtils.isEmpty(paramQZoneMsgEntityNew.bottomItemBuffer)) {
        return;
      }
      if (paramQZoneMsgEntityNew.bottomItems != null) {
        paramQZoneMsgEntityNew.bottomItems.clear();
      } else {
        paramQZoneMsgEntityNew.bottomItems = new ArrayList();
      }
      try
      {
        JSONArray localJSONArray = new JSONArray(paramQZoneMsgEntityNew.bottomItemBuffer);
        int i = 0;
        while (i < localJSONArray.length())
        {
          BottomItem localBottomItem = BottomItem.parseFromJSON(localJSONArray.getJSONObject(i));
          if (localBottomItem != null) {
            paramQZoneMsgEntityNew.bottomItems.add(localBottomItem);
          }
          i += 1;
        }
        return;
      }
      catch (JSONException paramQZoneMsgEntityNew)
      {
        QLog.e("QZoneMsgEntity.MsgEntityConverter", 1, "readBottomItemsFromBuffer error", paramQZoneMsgEntityNew);
      }
    }
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
  
  public static QZoneMsgEntityNew readFrom(QzoneMessageBoxRsp paramQzoneMessageBoxRsp)
  {
    if (paramQzoneMessageBoxRsp == null) {
      return null;
    }
    QZoneMsgEntityNew localQZoneMsgEntityNew = new QZoneMsgEntityNew();
    localQZoneMsgEntityNew.ArkNes_vec = MQMsg.readFromList(paramQzoneMessageBoxRsp.vecNews);
    localQZoneMsgEntityNew.trace_info = paramQzoneMessageBoxRsp.sTraceInfo;
    localQZoneMsgEntityNew.hasmore = paramQzoneMessageBoxRsp.hasMore;
    localQZoneMsgEntityNew.registered_days = paramQzoneMessageBoxRsp.registered_days;
    localQZoneMsgEntityNew.qzone_level = paramQzoneMessageBoxRsp.qzone_level;
    localQZoneMsgEntityNew.visitor_count = paramQzoneMessageBoxRsp.visitor_count;
    localQZoneMsgEntityNew.more_url = paramQzoneMessageBoxRsp.more_url;
    writeArkNewsToBuffer(localQZoneMsgEntityNew);
    localQZoneMsgEntityNew.bottomItems = BottomItem.readFromeList(paramQzoneMessageBoxRsp.bottomVec);
    writeBottomItemToBuffer(localQZoneMsgEntityNew);
    if ((localQZoneMsgEntityNew.ArkNes_vec != null) && (localQZoneMsgEntityNew.ArkNes_vec.size() > 0) && (((IMQMsg)localQZoneMsgEntityNew.ArkNes_vec.get(0)).getPushTime() > 0L)) {
      localQZoneMsgEntityNew.pushTime = ((IMQMsg)localQZoneMsgEntityNew.ArkNes_vec.get(0)).getPushTime();
    }
    if (paramQzoneMessageBoxRsp.unread_info != null) {
      localQZoneMsgEntityNew.unReadSummaryInfo = readFrom(paramQzoneMessageBoxRsp.unread_info);
    }
    return localQZoneMsgEntityNew;
  }
  
  public static void writeArkNewsToBuffer(QZoneMsgEntityNew paramQZoneMsgEntityNew)
  {
    if ((paramQZoneMsgEntityNew != null) && (paramQZoneMsgEntityNew.ArkNes_vec != null))
    {
      if (paramQZoneMsgEntityNew.ArkNes_vec.size() == 0) {
        return;
      }
      JSONArray localJSONArray = new JSONArray();
      Iterator localIterator = paramQZoneMsgEntityNew.ArkNes_vec.iterator();
      while (localIterator.hasNext())
      {
        IMQMsg localIMQMsg = (IMQMsg)localIterator.next();
        if ((localIMQMsg != null) && (!localIMQMsg.isRecommGuideCard())) {
          localJSONArray.put(localIMQMsg.convertToJson());
        }
      }
      paramQZoneMsgEntityNew.msgBuffer = localJSONArray.toString();
    }
  }
  
  public static void writeBottomItemToBuffer(QZoneMsgEntityNew paramQZoneMsgEntityNew)
  {
    if ((paramQZoneMsgEntityNew != null) && (paramQZoneMsgEntityNew.bottomItems != null))
    {
      if (paramQZoneMsgEntityNew.bottomItems.size() == 0) {
        return;
      }
      JSONArray localJSONArray = new JSONArray();
      Iterator localIterator = paramQZoneMsgEntityNew.bottomItems.iterator();
      while (localIterator.hasNext())
      {
        BottomItem localBottomItem = (BottomItem)localIterator.next();
        if (localBottomItem != null) {
          localJSONArray.put(localBottomItem.convertToJSON());
        }
      }
      paramQZoneMsgEntityNew.bottomItemBuffer = localJSONArray.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.contentbox.model.MsgEntityConverter
 * JD-Core Version:    0.7.0.1
 */