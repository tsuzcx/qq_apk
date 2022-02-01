package cooperation.qzone.contentbox.model;

import NS_QZONE_MQMSG.ButtonInfo;
import cooperation.qzone.util.QZLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class MQButtonCell
  implements Serializable
{
  public static final String TAG = "QZoneMsgManager.MQButtonCell";
  public String iconUrl = "";
  public String jumpUrl = "";
  public String words = "";
  
  public static JSONArray convertToJsonArray(List<MQButtonCell> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return null;
    }
    JSONArray localJSONArray = new JSONArray();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      MQButtonCell localMQButtonCell = (MQButtonCell)paramList.next();
      if (localMQButtonCell != null) {
        localJSONArray.put(localMQButtonCell.convertToJson());
      }
    }
    return localJSONArray;
  }
  
  public static MQButtonCell parseFromJson(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    MQButtonCell localMQButtonCell = new MQButtonCell();
    try
    {
      localMQButtonCell.words = paramJSONObject.optString("words");
      localMQButtonCell.iconUrl = paramJSONObject.optString("iconUrl");
      localMQButtonCell.jumpUrl = paramJSONObject.optString("jumpUrl");
      return localMQButtonCell;
    }
    catch (Exception paramJSONObject)
    {
      QZLog.e("QZoneMsgManager.MQButtonCell", "parseFromJson error", paramJSONObject);
    }
    return localMQButtonCell;
  }
  
  public static List<MQButtonCell> parseFromJsonArray(JSONArray paramJSONArray)
  {
    if ((paramJSONArray == null) || (paramJSONArray.length() == 0)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    for (;;)
    {
      if (i < paramJSONArray.length()) {
        try
        {
          localArrayList.add(parseFromJson(paramJSONArray.getJSONObject(i)));
          i += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            QZLog.e("QZoneMsgManager.MQButtonCell", "parseFromJsonArray error", localException);
          }
        }
      }
    }
    return localArrayList;
  }
  
  public static MQButtonCell readFrom(ButtonInfo paramButtonInfo)
  {
    MQButtonCell localMQButtonCell = new MQButtonCell();
    localMQButtonCell.words = paramButtonInfo.words;
    localMQButtonCell.iconUrl = paramButtonInfo.iconUrl;
    localMQButtonCell.jumpUrl = paramButtonInfo.jumpUrl;
    return localMQButtonCell;
  }
  
  public static List<MQButtonCell> readFromList(List<ButtonInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ButtonInfo localButtonInfo = (ButtonInfo)paramList.next();
      MQButtonCell localMQButtonCell = new MQButtonCell();
      localMQButtonCell.words = localButtonInfo.words;
      localMQButtonCell.iconUrl = localButtonInfo.iconUrl;
      localMQButtonCell.jumpUrl = localButtonInfo.jumpUrl;
      localArrayList.add(localMQButtonCell);
    }
    return localArrayList;
  }
  
  public JSONObject convertToJson()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("words", this.words);
      localJSONObject.put("iconUrl", this.iconUrl);
      localJSONObject.put("jumpUrl", this.jumpUrl);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      QZLog.e("QZoneMsgManager.MQButtonCell", "convertToJson error", localException);
    }
    return localJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.contentbox.model.MQButtonCell
 * JD-Core Version:    0.7.0.1
 */