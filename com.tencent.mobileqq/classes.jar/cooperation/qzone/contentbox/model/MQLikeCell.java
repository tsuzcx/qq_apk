package cooperation.qzone.contentbox.model;

import NS_QZONE_MQMSG.LikInfo;
import cooperation.qzone.util.QZLog;
import java.io.Serializable;
import org.json.JSONObject;

public class MQLikeCell
  implements Serializable
{
  public static final String TAG = "QZoneMsgManager.MQLikeCell";
  public int appid = 0;
  public long hostUin = 0L;
  public String likeKey = "";
  public boolean liked = false;
  public int totalLike = 0;
  
  public static MQLikeCell parseFromJson(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    MQLikeCell localMQLikeCell = new MQLikeCell();
    try
    {
      localMQLikeCell.totalLike = paramJSONObject.optInt("totalLike");
      localMQLikeCell.likeKey = paramJSONObject.optString("likeKey");
      localMQLikeCell.appid = paramJSONObject.optInt("appid");
      localMQLikeCell.hostUin = paramJSONObject.optLong("hostUin");
      localMQLikeCell.liked = paramJSONObject.optBoolean("liked");
      return localMQLikeCell;
    }
    catch (Exception paramJSONObject)
    {
      QZLog.e("QZoneMsgManager.MQLikeCell", "parseFromJson error", paramJSONObject);
    }
    return localMQLikeCell;
  }
  
  public static MQLikeCell readFrom(LikInfo paramLikInfo)
  {
    MQLikeCell localMQLikeCell = new MQLikeCell();
    localMQLikeCell.totalLike = paramLikInfo.totalLik;
    localMQLikeCell.likeKey = paramLikInfo.likeKey;
    localMQLikeCell.appid = paramLikInfo.appid;
    localMQLikeCell.hostUin = paramLikInfo.hostUin;
    int i = paramLikInfo.hasDoLik;
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    localMQLikeCell.liked = bool;
    return localMQLikeCell;
  }
  
  public JSONObject convertToJson()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("totalLike", this.totalLike);
      localJSONObject.put("likeKey", this.likeKey);
      localJSONObject.put("appid", this.appid);
      localJSONObject.put("hostUin", this.hostUin);
      localJSONObject.put("liked", this.liked);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      QZLog.e("QZoneMsgManager.MQLikeCell", "convertToJson error", localException);
    }
    return localJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.contentbox.model.MQLikeCell
 * JD-Core Version:    0.7.0.1
 */