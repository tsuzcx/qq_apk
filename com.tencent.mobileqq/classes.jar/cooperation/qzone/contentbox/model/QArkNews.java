package cooperation.qzone.contentbox.model;

import cooperation.qzone.util.QZLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public final class QArkNews
  implements Serializable
{
  public static final String TAG = "QZoneMsgManager.QArkNews";
  public String content = "";
  public String img_url = "";
  public String jump_url = "";
  public String title = "";
  public int type = 0;
  public String type_content = "";
  public long utime = 0L;
  
  private JSONObject convertToJson()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("type", this.type);
      localJSONObject.put("img_url", this.img_url);
      localJSONObject.put("content", this.content);
      localJSONObject.put("utime", this.utime);
      localJSONObject.put("jump_url", this.jump_url);
      localJSONObject.put("type_content", this.type_content);
      localJSONObject.put("title", this.title);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      QZLog.e("QZoneMsgManager.QArkNews", "convertToJson error", localException);
    }
    return localJSONObject;
  }
  
  public static JSONArray convertToJsonArray(ArrayList<QArkNews> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() != 0))
    {
      JSONArray localJSONArray = new JSONArray();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        QArkNews localQArkNews = (QArkNews)paramArrayList.next();
        if (localQArkNews != null) {
          localJSONArray.put(localQArkNews.convertToJson());
        }
      }
      return localJSONArray;
    }
    return null;
  }
  
  private static QArkNews parseFromJson(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    QArkNews localQArkNews = new QArkNews();
    try
    {
      localQArkNews.type = paramJSONObject.optInt("type");
      localQArkNews.img_url = paramJSONObject.optString("img_url");
      localQArkNews.content = paramJSONObject.optString("content");
      localQArkNews.utime = paramJSONObject.optLong("utime");
      localQArkNews.jump_url = paramJSONObject.optString("jump_url");
      localQArkNews.type_content = paramJSONObject.optString("type_content");
      localQArkNews.title = paramJSONObject.optString("title");
      return localQArkNews;
    }
    catch (Exception paramJSONObject)
    {
      QZLog.e("QZoneMsgManager.QArkNews", "parsejson error", paramJSONObject);
    }
    return localQArkNews;
  }
  
  public static ArrayList<QArkNews> parseFromJsonArray(JSONArray paramJSONArray)
  {
    if ((paramJSONArray != null) && (paramJSONArray.length() != 0))
    {
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < paramJSONArray.length())
      {
        try
        {
          localArrayList.add(parseFromJson((JSONObject)paramJSONArray.get(i)));
        }
        catch (Exception localException)
        {
          QZLog.e("QZoneMsgManager.QArkNews", "parseFromJsonArray error", localException);
        }
        i += 1;
      }
      return localArrayList;
    }
    return null;
  }
  
  private static QArkNews readFrom(NS_QZONE_MQMSG.QArkNews paramQArkNews)
  {
    QArkNews localQArkNews = new QArkNews();
    localQArkNews.type = paramQArkNews.type;
    localQArkNews.img_url = paramQArkNews.img_url;
    localQArkNews.content = paramQArkNews.content;
    localQArkNews.utime = paramQArkNews.utime;
    localQArkNews.jump_url = paramQArkNews.jump_url;
    localQArkNews.type_content = paramQArkNews.type_content;
    localQArkNews.title = paramQArkNews.title;
    return localQArkNews;
  }
  
  public static ArrayList<QArkNews> readFromList(ArrayList<NS_QZONE_MQMSG.QArkNews> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() != 0))
    {
      ArrayList localArrayList = new ArrayList();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        NS_QZONE_MQMSG.QArkNews localQArkNews = (NS_QZONE_MQMSG.QArkNews)paramArrayList.next();
        if (localQArkNews != null) {
          localArrayList.add(readFrom(localQArkNews));
        }
      }
      return localArrayList;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.contentbox.model.QArkNews
 * JD-Core Version:    0.7.0.1
 */