package cooperation.qzone.contentbox.model;

import NS_CLIENT_SHOW_ALL_INFO.AllInfo;
import NS_COMM_VIP_GROWTH.UserClientShowInfo;
import cooperation.qzone.util.QZLog;
import cooperation.vip.JceEncoder;
import cooperation.vip.vipcomponent.QQUnionIconInfo;
import cooperation.vip.vipcomponent.util.VipResources;
import java.io.Serializable;
import org.json.JSONObject;

public class MQUserClientShowInfo
  implements Serializable
{
  public static final String TAG = "MsgVip.MQUserClientShowInfo";
  public int iIsUseVipIcon = 0;
  public int iKeepVipDays = 0;
  public int iLevel = 0;
  public int iScore = 0;
  public int iSpeed = 0;
  public int iVip = 0;
  public int iVipRatio = 0;
  public String strUid = "";
  public int unionIconHeight;
  public int unionIconWidth;
  public String unionVipUrl;
  
  public static MQUserClientShowInfo parseFromJson(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    MQUserClientShowInfo localMQUserClientShowInfo = new MQUserClientShowInfo();
    try
    {
      localMQUserClientShowInfo.strUid = paramJSONObject.optString("strUid");
      localMQUserClientShowInfo.iVipRatio = paramJSONObject.optInt("iVipRatio");
      localMQUserClientShowInfo.iKeepVipDays = paramJSONObject.optInt("iKeepVipDays");
      localMQUserClientShowInfo.iVip = paramJSONObject.optInt("iVip");
      localMQUserClientShowInfo.iLevel = paramJSONObject.optInt("iLevel");
      localMQUserClientShowInfo.iSpeed = paramJSONObject.optInt("iSpeed");
      localMQUserClientShowInfo.iScore = paramJSONObject.optInt("iScore");
      localMQUserClientShowInfo.iIsUseVipIcon = paramJSONObject.optInt("iIsUseVipIcon");
      localMQUserClientShowInfo.unionVipUrl = paramJSONObject.optString("unionVipUrl");
      localMQUserClientShowInfo.unionIconWidth = paramJSONObject.optInt("unionIconWidth");
      localMQUserClientShowInfo.unionIconHeight = paramJSONObject.optInt("unionIconHeight");
      return localMQUserClientShowInfo;
    }
    catch (Exception paramJSONObject)
    {
      QZLog.e("MsgVip.MQUserClientShowInfo", "parseFromJson error", paramJSONObject);
    }
    return localMQUserClientShowInfo;
  }
  
  public static MQUserClientShowInfo readFrom(byte[] paramArrayOfByte)
  {
    MQUserClientShowInfo localMQUserClientShowInfo = null;
    if (paramArrayOfByte == null) {
      return null;
    }
    Object localObject = (AllInfo)JceEncoder.a(AllInfo.class, paramArrayOfByte);
    paramArrayOfByte = localMQUserClientShowInfo;
    if (localObject != null)
    {
      paramArrayOfByte = (UserClientShowInfo)JceEncoder.a(UserClientShowInfo.class, ((AllInfo)localObject).vecQQBigVipInfo);
      if (paramArrayOfByte == null) {
        return null;
      }
      localMQUserClientShowInfo = new MQUserClientShowInfo();
      localMQUserClientShowInfo.strUid = paramArrayOfByte.strUid;
      localMQUserClientShowInfo.iVipRatio = paramArrayOfByte.iVipRatio;
      localMQUserClientShowInfo.iKeepVipDays = paramArrayOfByte.iKeepVipDays;
      localMQUserClientShowInfo.iVip = paramArrayOfByte.iVip;
      localMQUserClientShowInfo.iLevel = paramArrayOfByte.iLevel;
      localMQUserClientShowInfo.iSpeed = paramArrayOfByte.iSpeed;
      localMQUserClientShowInfo.iScore = paramArrayOfByte.iScore;
      localMQUserClientShowInfo.iIsUseVipIcon = paramArrayOfByte.iIsUseVipIcon;
      localObject = VipResources.a(8, paramArrayOfByte);
      paramArrayOfByte = localMQUserClientShowInfo;
      if (localObject != null)
      {
        localMQUserClientShowInfo.unionVipUrl = ((QQUnionIconInfo)localObject).mIconUrl;
        localMQUserClientShowInfo.unionIconWidth = ((QQUnionIconInfo)localObject).mIconWidth;
        localMQUserClientShowInfo.unionIconHeight = ((QQUnionIconInfo)localObject).mIconHeight;
        paramArrayOfByte = localMQUserClientShowInfo;
      }
    }
    return paramArrayOfByte;
  }
  
  public JSONObject convertToJson()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("strUid", this.strUid);
      localJSONObject.put("iVipRatio", this.iVipRatio);
      localJSONObject.put("iKeepVipDays", this.iKeepVipDays);
      localJSONObject.put("iVip", this.iVip);
      localJSONObject.put("iLevel", this.iLevel);
      localJSONObject.put("iSpeed", this.iSpeed);
      localJSONObject.put("iScore", this.iScore);
      localJSONObject.put("iIsUseVipIcon", this.iIsUseVipIcon);
      localJSONObject.put("unionVipUrl", this.unionVipUrl);
      localJSONObject.put("unionIconWidth", this.unionIconWidth);
      localJSONObject.put("unionIconHeight", this.unionIconHeight);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      QZLog.e("MsgVip.MQUserClientShowInfo", "convertToJson error", localException);
    }
    return localJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.contentbox.model.MQUserClientShowInfo
 * JD-Core Version:    0.7.0.1
 */