package cooperation.qzone.contentbox.model;

import NS_QZONE_MQMSG.BottomCell;
import cooperation.qzone.util.QZLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class MQBottomCell
  implements Serializable
{
  public static final String TAG = "QZoneMsgManager.MQBottomCell";
  public String content = "";
  public String jumpUrl = "";
  public int total = 0;
  public ArrayList<String> userAvatar = null;
  
  private static JSONArray convertAvatarToJsonArray(ArrayList<String> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return null;
    }
    JSONArray localJSONArray = new JSONArray();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      localJSONArray.put((String)paramArrayList.next());
    }
    return localJSONArray;
  }
  
  private static ArrayList<String> parseAvatarArrayList(JSONArray paramJSONArray)
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
          localArrayList.add(paramJSONArray.getString(i));
          i += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            QZLog.e("QZoneMsgManager.MQBottomCell", "parseArrayList error", localException);
          }
        }
      }
    }
    return localArrayList;
  }
  
  public static MQBottomCell parseFromJson(JSONObject paramJSONObject)
  {
    if ((paramJSONObject == null) || (paramJSONObject.length() == 0)) {
      return null;
    }
    MQBottomCell localMQBottomCell = new MQBottomCell();
    try
    {
      localMQBottomCell.total = paramJSONObject.optInt("total");
      localMQBottomCell.content = paramJSONObject.optString("content");
      localMQBottomCell.jumpUrl = paramJSONObject.optString("jumpUrl");
      localMQBottomCell.userAvatar = parseAvatarArrayList(paramJSONObject.optJSONArray("userAvatar"));
      return localMQBottomCell;
    }
    catch (Exception paramJSONObject)
    {
      QZLog.e("QZoneMsgManager.MQBottomCell", "parseFromJson error", paramJSONObject);
    }
    return localMQBottomCell;
  }
  
  public static MQBottomCell readFrom(BottomCell paramBottomCell)
  {
    MQBottomCell localMQBottomCell = new MQBottomCell();
    localMQBottomCell.content = paramBottomCell.content;
    localMQBottomCell.jumpUrl = paramBottomCell.jumpUrl;
    localMQBottomCell.total = paramBottomCell.total;
    localMQBottomCell.userAvatar = paramBottomCell.userAvatar;
    return localMQBottomCell;
  }
  
  public JSONObject convertToJson()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("total", this.total);
      localJSONObject.put("content", this.content);
      localJSONObject.put("jumpUrl", this.jumpUrl);
      localJSONObject.put("total", convertAvatarToJsonArray(this.userAvatar));
      return localJSONObject;
    }
    catch (Exception localException)
    {
      QZLog.e("QZoneMsgManager.MQBottomCell", "convertToJson error", localException);
    }
    return localJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.contentbox.model.MQBottomCell
 * JD-Core Version:    0.7.0.1
 */