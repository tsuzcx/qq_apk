package cooperation.qzone.contentbox.model;

import NS_QZONE_MQMSG.QzoneMessageBoxRsp;
import android.text.TextUtils;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import cooperation.qzone.util.QZLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;

public class QZoneMsgEntityNew
  extends Entity
  implements Serializable
{
  public static final String TAG;
  @notColumn
  public ArrayList<MQMsg> ArkNes_vec;
  public String bottomItemBuffer;
  @notColumn
  public ArrayList<BottomItem> bottomItems;
  public boolean hasmore = true;
  public String more_url = "";
  public String msgBuffer = "";
  public long pushTime;
  public long qzone_level;
  public long registered_days;
  public String trace_info = "";
  public long visitor_count;
  
  static
  {
    TAG += ".QZoneMsgEntity";
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
    localQZoneMsgEntityNew.writeArkNewsToBuffer();
    localQZoneMsgEntityNew.bottomItems = BottomItem.readFromeList(paramQzoneMessageBoxRsp.bottomVec);
    localQZoneMsgEntityNew.writeBottomItemToBuffer();
    if ((localQZoneMsgEntityNew.ArkNes_vec != null) && (localQZoneMsgEntityNew.ArkNes_vec.size() > 0) && (((MQMsg)localQZoneMsgEntityNew.ArkNes_vec.get(0)).pushTime > 0L)) {
      localQZoneMsgEntityNew.pushTime = ((MQMsg)localQZoneMsgEntityNew.ArkNes_vec.get(0)).pushTime;
    }
    return localQZoneMsgEntityNew;
  }
  
  public void addMsg(ArrayList<MQMsg> paramArrayList)
  {
    if (paramArrayList == null) {
      return;
    }
    if (this.ArkNes_vec == null) {
      this.ArkNes_vec = paramArrayList;
    }
    for (;;)
    {
      writeArkNewsToBuffer();
      return;
      this.ArkNes_vec.addAll(paramArrayList);
    }
  }
  
  public void readArkNewsFromBuffer()
  {
    if (TextUtils.isEmpty(this.msgBuffer)) {}
    for (;;)
    {
      return;
      if (this.ArkNes_vec != null) {
        this.ArkNes_vec.clear();
      }
      try
      {
        for (;;)
        {
          JSONArray localJSONArray = new JSONArray(this.msgBuffer);
          int i = 0;
          while (i < localJSONArray.length())
          {
            MQMsg localMQMsg = MQMsg.parseFromJson(localJSONArray.getJSONObject(i));
            if (localMQMsg != null) {
              this.ArkNes_vec.add(localMQMsg);
            }
            i += 1;
          }
          this.ArkNes_vec = new ArrayList();
        }
        return;
      }
      catch (Exception localException)
      {
        QZLog.e(TAG, "readArkNewsFromBuffer error", localException);
      }
    }
  }
  
  public void readBottomItemsFromBuffer()
  {
    if (TextUtils.isEmpty(this.bottomItemBuffer)) {}
    for (;;)
    {
      return;
      if (this.bottomItems != null) {
        this.bottomItems.clear();
      }
      try
      {
        for (;;)
        {
          JSONArray localJSONArray = new JSONArray(this.bottomItemBuffer);
          int i = 0;
          while (i < localJSONArray.length())
          {
            BottomItem localBottomItem = BottomItem.parseFromJSON(localJSONArray.getJSONObject(i));
            if (localBottomItem != null) {
              this.bottomItems.add(localBottomItem);
            }
            i += 1;
          }
          this.bottomItems = new ArrayList();
        }
        return;
      }
      catch (JSONException localJSONException)
      {
        QZLog.e(TAG, "readBottomItemsFromBuffer error", localJSONException);
      }
    }
  }
  
  public void writeArkNewsToBuffer()
  {
    if ((this.ArkNes_vec == null) || (this.ArkNes_vec.size() == 0)) {
      return;
    }
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = this.ArkNes_vec.iterator();
    while (localIterator.hasNext())
    {
      MQMsg localMQMsg = (MQMsg)localIterator.next();
      if (localMQMsg != null) {
        localJSONArray.put(localMQMsg.convertToJson());
      }
    }
    this.msgBuffer = localJSONArray.toString();
  }
  
  public void writeBottomItemToBuffer()
  {
    if ((this.bottomItems == null) || (this.bottomItems.size() == 0)) {
      return;
    }
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = this.bottomItems.iterator();
    while (localIterator.hasNext())
    {
      BottomItem localBottomItem = (BottomItem)localIterator.next();
      if (localBottomItem != null) {
        localJSONArray.put(localBottomItem.convertToJSON());
      }
    }
    this.bottomItemBuffer = localJSONArray.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.contentbox.model.QZoneMsgEntityNew
 * JD-Core Version:    0.7.0.1
 */