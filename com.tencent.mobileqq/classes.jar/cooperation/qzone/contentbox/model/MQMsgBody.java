package cooperation.qzone.contentbox.model;

import NS_QZONE_MQMSG.MsgBody;
import NS_QZONE_MQMSG.PhotoCell;
import cooperation.qzone.util.QZLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class MQMsgBody
  implements Serializable
{
  public static final String TAG = "QZoneMsgManager.MQMsgBody";
  public String content = "";
  public String contentIcon = "";
  public String coverPicUrl = "";
  public int mediaType = 0;
  public ArrayList<MQPhotoCell> photolist = null;
  public String title = "";
  public ArrayList<String> vecUserAvatar = null;
  
  private static JSONArray convertAvatarToJsonArray(ArrayList<String> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() != 0))
    {
      JSONArray localJSONArray = new JSONArray();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        localJSONArray.put((String)paramArrayList.next());
      }
      return localJSONArray;
    }
    return null;
  }
  
  private static JSONArray convertPhotoCellToJsonArray(ArrayList<MQPhotoCell> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() != 0))
    {
      JSONArray localJSONArray = new JSONArray();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        localJSONArray.put(((MQPhotoCell)paramArrayList.next()).convertToJson());
      }
      return localJSONArray;
    }
    return null;
  }
  
  private static ArrayList<String> parseAvatarArrayList(JSONArray paramJSONArray)
  {
    if ((paramJSONArray != null) && (paramJSONArray.length() != 0))
    {
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < paramJSONArray.length())
      {
        try
        {
          localArrayList.add(paramJSONArray.getString(i));
        }
        catch (Exception localException)
        {
          QZLog.e("QZoneMsgManager.MQMsgBody", "parseArrayList error", localException);
        }
        i += 1;
      }
      return localArrayList;
    }
    return null;
  }
  
  public static MQMsgBody parseFromJson(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    MQMsgBody localMQMsgBody = new MQMsgBody();
    try
    {
      localMQMsgBody.mediaType = paramJSONObject.optInt("mediaType");
      localMQMsgBody.title = paramJSONObject.optString("title");
      localMQMsgBody.content = paramJSONObject.optString("content");
      localMQMsgBody.photolist = parsePhotoCellArrayList(paramJSONObject.optJSONArray("photolist"));
      localMQMsgBody.vecUserAvatar = parseAvatarArrayList(paramJSONObject.optJSONArray("vecUserAvatar"));
      localMQMsgBody.coverPicUrl = paramJSONObject.optString("coverPicUrl");
      localMQMsgBody.contentIcon = paramJSONObject.optString("contentIcon");
      return localMQMsgBody;
    }
    catch (Exception paramJSONObject)
    {
      QZLog.e("QZoneMsgManager.MQMsgBody", "parseFromJson error", paramJSONObject);
    }
    return localMQMsgBody;
  }
  
  private static ArrayList<MQPhotoCell> parsePhotoCellArrayList(JSONArray paramJSONArray)
  {
    if ((paramJSONArray != null) && (paramJSONArray.length() != 0))
    {
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < paramJSONArray.length())
      {
        try
        {
          localArrayList.add(MQPhotoCell.parseFromJson(paramJSONArray.getJSONObject(i)));
        }
        catch (Exception localException)
        {
          QZLog.e("QZoneMsgManager.MQMsgBody", "parseArrayList error", localException);
        }
        i += 1;
      }
      return localArrayList;
    }
    return null;
  }
  
  public static MQMsgBody readFrom(MsgBody paramMsgBody)
  {
    MQMsgBody localMQMsgBody = new MQMsgBody();
    localMQMsgBody.mediaType = paramMsgBody.mediaType;
    localMQMsgBody.title = paramMsgBody.title;
    localMQMsgBody.content = paramMsgBody.content;
    localMQMsgBody.photolist = readFrom(paramMsgBody.vecPhotos);
    localMQMsgBody.vecUserAvatar = paramMsgBody.vecUserAvatar;
    localMQMsgBody.coverPicUrl = paramMsgBody.coverPicUrl;
    localMQMsgBody.contentIcon = paramMsgBody.contentIcon;
    return localMQMsgBody;
  }
  
  private static ArrayList<MQPhotoCell> readFrom(ArrayList<PhotoCell> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      Iterator localIterator = paramArrayList.iterator();
      for (;;)
      {
        paramArrayList = localArrayList;
        if (!localIterator.hasNext()) {
          break;
        }
        paramArrayList = (PhotoCell)localIterator.next();
        if (paramArrayList != null) {
          localArrayList.add(MQPhotoCell.readFrom(paramArrayList));
        }
      }
    }
    paramArrayList = null;
    return paramArrayList;
  }
  
  public JSONObject convertToJson()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("mediaType", this.mediaType);
      localJSONObject.put("title", this.title);
      localJSONObject.put("content", this.content);
      localJSONObject.put("photolist", convertPhotoCellToJsonArray(this.photolist));
      localJSONObject.put("vecUserAvatar", convertAvatarToJsonArray(this.vecUserAvatar));
      localJSONObject.put("coverPicUrl", this.coverPicUrl);
      localJSONObject.put("contentIcon", this.contentIcon);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      QZLog.e("QZoneMsgManager.MQMsgBody", "convertToJson error", localException);
    }
    return localJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.contentbox.model.MQMsgBody
 * JD-Core Version:    0.7.0.1
 */