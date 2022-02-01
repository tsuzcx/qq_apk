package cooperation.qzone.contentbox.model;

import NS_QZONE_MQMSG.UserPersonalProfile;
import cooperation.qzone.util.QZLog;
import java.io.Serializable;
import org.json.JSONObject;

public class MQUserPersonalProfile
  implements Serializable
{
  public static final String TAG = "MsgVip.MQUserPersonalProfile";
  public int isAnnualVip;
  public int isLoversVip;
  public MQUserClientShowInfo userClientShowInfo;
  public int vip;
  public int vipLevel;
  
  public static MQUserPersonalProfile parseFromJson(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    MQUserPersonalProfile localMQUserPersonalProfile = new MQUserPersonalProfile();
    try
    {
      localMQUserPersonalProfile.vip = paramJSONObject.optInt("vip");
      localMQUserPersonalProfile.vipLevel = paramJSONObject.optInt("vipLevel");
      localMQUserPersonalProfile.isAnnualVip = paramJSONObject.optInt("isAnnualVip");
      localMQUserPersonalProfile.isLoversVip = paramJSONObject.optInt("isLoversVip");
      localMQUserPersonalProfile.userClientShowInfo = MQUserClientShowInfo.parseFromJson(paramJSONObject.optJSONObject("userClientShowInfo"));
      return localMQUserPersonalProfile;
    }
    catch (Exception paramJSONObject)
    {
      QZLog.e("MsgVip.MQUserPersonalProfile", "parseFromJson error", paramJSONObject);
    }
    return localMQUserPersonalProfile;
  }
  
  public static MQUserPersonalProfile readFrom(UserPersonalProfile paramUserPersonalProfile)
  {
    if (paramUserPersonalProfile == null) {
      return null;
    }
    MQUserPersonalProfile localMQUserPersonalProfile = new MQUserPersonalProfile();
    localMQUserPersonalProfile.vip = paramUserPersonalProfile.vip;
    localMQUserPersonalProfile.vipLevel = paramUserPersonalProfile.vipLevel;
    localMQUserPersonalProfile.isAnnualVip = paramUserPersonalProfile.isAnnualVip;
    localMQUserPersonalProfile.isLoversVip = paramUserPersonalProfile.isLoversVip;
    localMQUserPersonalProfile.userClientShowInfo = MQUserClientShowInfo.readFrom(paramUserPersonalProfile.vecBuff);
    return localMQUserPersonalProfile;
  }
  
  public JSONObject convertToJson()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("vip", this.vip);
      localJSONObject.put("vipLevel", this.vipLevel);
      localJSONObject.put("isAnnualVip", this.isAnnualVip);
      localJSONObject.put("isLoversVip", this.isLoversVip);
      Object localObject;
      if (this.userClientShowInfo == null) {
        localObject = "null";
      } else {
        localObject = this.userClientShowInfo.convertToJson();
      }
      localJSONObject.put("userClientShowInfo", localObject);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      QZLog.e("MsgVip.MQUserPersonalProfile", "convertToJson error", localException);
    }
    return localJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.contentbox.model.MQUserPersonalProfile
 * JD-Core Version:    0.7.0.1
 */