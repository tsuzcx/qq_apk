package cooperation.qzone.contentbox.model;

import NS_CLIENT_SHOW_ALL_INFO.AllInfo;
import NS_COMM_VIP_GROWTH.UserClientShowInfo;
import bkdv;
import bkhb;
import cooperation.qzone.util.QZLog;
import cooperation.vip.vipcomponent.QQUnionIconInfo;
import java.io.Serializable;
import org.json.JSONObject;

public class MQUserClientShowInfo
  implements Serializable
{
  public static final String TAG = "MsgVip.MQUserClientShowInfo";
  public int iIsUseVipIcon;
  public int iKeepVipDays;
  public int iLevel;
  public int iScore;
  public int iSpeed;
  public int iVip;
  public int iVipRatio;
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
    if (paramArrayOfByte == null) {
      return null;
    }
    paramArrayOfByte = (AllInfo)bkdv.a(AllInfo.class, paramArrayOfByte);
    if (paramArrayOfByte != null)
    {
      Object localObject = (UserClientShowInfo)bkdv.a(UserClientShowInfo.class, paramArrayOfByte.vecQQBigVipInfo);
      if (localObject == null) {
        return null;
      }
      paramArrayOfByte = new MQUserClientShowInfo();
      paramArrayOfByte.strUid = ((UserClientShowInfo)localObject).strUid;
      paramArrayOfByte.iVipRatio = ((UserClientShowInfo)localObject).iVipRatio;
      paramArrayOfByte.iKeepVipDays = ((UserClientShowInfo)localObject).iKeepVipDays;
      paramArrayOfByte.iVip = ((UserClientShowInfo)localObject).iVip;
      paramArrayOfByte.iLevel = ((UserClientShowInfo)localObject).iLevel;
      paramArrayOfByte.iSpeed = ((UserClientShowInfo)localObject).iSpeed;
      paramArrayOfByte.iScore = ((UserClientShowInfo)localObject).iScore;
      paramArrayOfByte.iIsUseVipIcon = ((UserClientShowInfo)localObject).iIsUseVipIcon;
      localObject = bkhb.a(8, (UserClientShowInfo)localObject);
      if (localObject != null)
      {
        paramArrayOfByte.unionVipUrl = ((QQUnionIconInfo)localObject).mIconUrl;
        paramArrayOfByte.unionIconWidth = ((QQUnionIconInfo)localObject).mIconWidth;
        paramArrayOfByte.unionIconHeight = ((QQUnionIconInfo)localObject).mIconHeight;
      }
      return paramArrayOfByte;
    }
    return null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qzone.contentbox.model.MQUserClientShowInfo
 * JD-Core Version:    0.7.0.1
 */