package cooperation.qzone.contentbox.model;

import NS_QZONE_MQMSG.UserPersonalData;
import NS_QZONE_MQMSG.UserPersonalProfile;
import bhye;
import cooperation.qzone.util.QZLog;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

public class MQUserPersonalData
  implements Serializable
{
  public static final String TAG = "MsgVip.MQUserPersonalData";
  public String mBVJumpUrl = "";
  public String mLYJumpUrl = "";
  public Map<String, MQUserPersonalProfile> mUserPersonalProfileMap;
  public String mYJumpUrl = "";
  
  private Map<String, JSONObject> a()
  {
    if (this.mUserPersonalProfileMap == null)
    {
      QZLog.i("MsgVip.MQUserPersonalData", 1, "getMapJson = null");
      return null;
    }
    HashMap localHashMap = new HashMap();
    Iterator localIterator = this.mUserPersonalProfileMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if ((localEntry != null) && (localEntry.getValue() != null)) {
        localHashMap.put(localEntry.getKey(), ((MQUserPersonalProfile)localEntry.getValue()).convertToJson());
      }
    }
    return localHashMap;
  }
  
  private static Map<String, MQUserPersonalProfile> a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    HashMap localHashMap;
    do
    {
      return null;
      localHashMap = new HashMap();
      paramJSONObject = bhye.a(paramJSONObject.toString());
    } while (paramJSONObject == null);
    paramJSONObject = paramJSONObject.entrySet().iterator();
    while (paramJSONObject.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramJSONObject.next();
      if (localEntry != null) {
        localHashMap.put(localEntry.getKey(), MQUserPersonalProfile.parseFromJson(new JSONObject((Map)localEntry.getValue())));
      }
    }
    return localHashMap;
  }
  
  public static MQUserPersonalData parseFromJson(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    MQUserPersonalData localMQUserPersonalData = new MQUserPersonalData();
    try
    {
      localMQUserPersonalData.mUserPersonalProfileMap = a(paramJSONObject.optJSONObject("mUserPersonalProfileMap"));
      localMQUserPersonalData.mYJumpUrl = paramJSONObject.optString("mYJumpUrl");
      localMQUserPersonalData.mLYJumpUrl = paramJSONObject.optString("mLYJumpUrl");
      localMQUserPersonalData.mBVJumpUrl = paramJSONObject.optString("mBVJumpUrl");
      return localMQUserPersonalData;
    }
    catch (Exception paramJSONObject)
    {
      QZLog.e("MsgVip.MQUserPersonalData", "parseFromJson error", paramJSONObject);
    }
    return localMQUserPersonalData;
  }
  
  public static MQUserPersonalData readFrom(UserPersonalData paramUserPersonalData)
  {
    if (paramUserPersonalData == null) {
      return null;
    }
    MQUserPersonalData localMQUserPersonalData = new MQUserPersonalData();
    if (paramUserPersonalData.mpUinToProfile != null)
    {
      HashMap localHashMap = new HashMap(paramUserPersonalData.mpUinToProfile.size());
      Iterator localIterator = paramUserPersonalData.mpUinToProfile.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (localEntry != null) {
          localHashMap.put(String.valueOf(localEntry.getKey()), MQUserPersonalProfile.readFrom((UserPersonalProfile)localEntry.getValue()));
        }
      }
      localMQUserPersonalData.mUserPersonalProfileMap = localHashMap;
    }
    localMQUserPersonalData.mYJumpUrl = paramUserPersonalData.yJumpUrl;
    localMQUserPersonalData.mLYJumpUrl = paramUserPersonalData.lJumpUrl;
    localMQUserPersonalData.mBVJumpUrl = paramUserPersonalData.bigVipJumpUrl;
    return localMQUserPersonalData;
  }
  
  public JSONObject convertToJson()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      Map localMap = a();
      if (localMap != null) {
        localJSONObject.put("mUserPersonalProfileMap", new JSONObject(localMap));
      }
      localJSONObject.put("mYJumpUrl", this.mYJumpUrl);
      localJSONObject.put("mLYJumpUrl", this.mLYJumpUrl);
      localJSONObject.put("mBVJumpUrl", this.mBVJumpUrl);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      QZLog.e("MsgVip.MQUserPersonalData", "convertToJson error", localException);
    }
    return localJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.contentbox.model.MQUserPersonalData
 * JD-Core Version:    0.7.0.1
 */