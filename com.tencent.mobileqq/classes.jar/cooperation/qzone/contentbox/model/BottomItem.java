package cooperation.qzone.contentbox.model;

import NS_QZONE_MQMSG.BottomContentItem;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class BottomItem
{
  private static final String TAG = "BottomItem";
  public String content;
  public String url;
  
  public BottomItem() {}
  
  public BottomItem(String paramString1, String paramString2)
  {
    this.content = paramString1;
    this.url = paramString2;
  }
  
  public static BottomItem parseFromJSON(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    BottomItem localBottomItem = new BottomItem();
    localBottomItem.content = paramJSONObject.optString("content");
    localBottomItem.url = paramJSONObject.optString("url");
    return localBottomItem;
  }
  
  public static ArrayList<BottomItem> readFromeList(ArrayList<BottomContentItem> paramArrayList)
  {
    if (paramArrayList == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      BottomContentItem localBottomContentItem = (BottomContentItem)paramArrayList.next();
      if (localBottomContentItem != null)
      {
        BottomItem localBottomItem = new BottomItem();
        localBottomItem.content = localBottomContentItem.content;
        localBottomItem.url = localBottomContentItem.url;
        localArrayList.add(localBottomItem);
      }
    }
    return localArrayList;
  }
  
  public JSONObject convertToJSON()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("content", this.content);
      localJSONObject.put("url", this.url);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      QZLog.e("BottomItem", "convert json error", localJSONException);
    }
    return localJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.contentbox.model.BottomItem
 * JD-Core Version:    0.7.0.1
 */