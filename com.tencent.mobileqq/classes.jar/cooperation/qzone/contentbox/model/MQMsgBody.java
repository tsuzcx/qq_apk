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
  public int mediaType;
  public ArrayList<MQPhotoCell> photolist;
  public String title = "";
  public ArrayList<String> vecUserAvatar;
  
  private static ArrayList<MQPhotoCell> a(ArrayList<PhotoCell> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        PhotoCell localPhotoCell = (PhotoCell)paramArrayList.next();
        if (localPhotoCell != null) {
          localArrayList.add(MQPhotoCell.readFrom(localPhotoCell));
        }
      }
      return localArrayList;
    }
    return null;
  }
  
  private static ArrayList<MQPhotoCell> a(JSONArray paramJSONArray)
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
          localArrayList.add(MQPhotoCell.parseFromJson(paramJSONArray.getJSONObject(i)));
          i += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            QZLog.e("QZoneMsgManager.MQMsgBody", "parseArrayList error", localException);
          }
        }
      }
    }
    return localArrayList;
  }
  
  private static JSONArray a(ArrayList<String> paramArrayList)
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
  
  private static ArrayList<String> b(JSONArray paramJSONArray)
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
            QZLog.e("QZoneMsgManager.MQMsgBody", "parseArrayList error", localException);
          }
        }
      }
    }
    return localArrayList;
  }
  
  private static JSONArray b(ArrayList<MQPhotoCell> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return null;
    }
    JSONArray localJSONArray = new JSONArray();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      localJSONArray.put(((MQPhotoCell)paramArrayList.next()).convertToJson());
    }
    return localJSONArray;
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
      localMQMsgBody.photolist = a(paramJSONObject.optJSONArray("photolist"));
      localMQMsgBody.vecUserAvatar = b(paramJSONObject.optJSONArray("vecUserAvatar"));
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
  
  public static MQMsgBody readFrom(MsgBody paramMsgBody)
  {
    MQMsgBody localMQMsgBody = new MQMsgBody();
    localMQMsgBody.mediaType = paramMsgBody.mediaType;
    localMQMsgBody.title = paramMsgBody.title;
    localMQMsgBody.content = paramMsgBody.content;
    localMQMsgBody.photolist = a(paramMsgBody.vecPhotos);
    localMQMsgBody.vecUserAvatar = paramMsgBody.vecUserAvatar;
    localMQMsgBody.coverPicUrl = paramMsgBody.coverPicUrl;
    localMQMsgBody.contentIcon = paramMsgBody.contentIcon;
    return localMQMsgBody;
  }
  
  public JSONObject convertToJson()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("mediaType", this.mediaType);
      localJSONObject.put("title", this.title);
      localJSONObject.put("content", this.content);
      localJSONObject.put("photolist", b(this.photolist));
      localJSONObject.put("vecUserAvatar", a(this.vecUserAvatar));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.contentbox.model.MQMsgBody
 * JD-Core Version:    0.7.0.1
 */