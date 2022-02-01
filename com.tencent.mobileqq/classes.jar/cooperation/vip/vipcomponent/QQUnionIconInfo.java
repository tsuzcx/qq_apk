package cooperation.vip.vipcomponent;

import NS_COMM_VIP_GROWTH.IconInfo;
import com.tencent.component.annotation.NeedParcel;
import cooperation.qzone.util.QZLog;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

public class QQUnionIconInfo
  implements Serializable
{
  @NeedParcel
  public int mIconHeight;
  @NeedParcel
  public String mIconUrl;
  @NeedParcel
  public int mIconWidth;
  
  public static JSONObject convertToJson(QQUnionIconInfo paramQQUnionIconInfo)
  {
    if (paramQQUnionIconInfo == null) {
      return null;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("mIconUrl", paramQQUnionIconInfo.mIconUrl);
      localJSONObject.put("mIconWidth", paramQQUnionIconInfo.mIconWidth);
      localJSONObject.put("mIconHeight", paramQQUnionIconInfo.mIconHeight);
      return localJSONObject;
    }
    catch (Exception paramQQUnionIconInfo)
    {
      QZLog.e("QQUnionIconInfo", "convertToJson error", paramQQUnionIconInfo);
    }
    return localJSONObject;
  }
  
  public static QQUnionIconInfo convertToQQUnionIconInfo(IconInfo paramIconInfo)
  {
    if (paramIconInfo == null) {
      return null;
    }
    QQUnionIconInfo localQQUnionIconInfo = new QQUnionIconInfo();
    localQQUnionIconInfo.mIconUrl = paramIconInfo.strUrl;
    localQQUnionIconInfo.mIconWidth = paramIconInfo.iWidth;
    localQQUnionIconInfo.mIconHeight = paramIconInfo.iHigh;
    return localQQUnionIconInfo;
  }
  
  public static Map<String, QQUnionIconInfo> convertToQQUnionIconMap(Map<String, IconInfo> paramMap)
  {
    if (paramMap == null) {
      return null;
    }
    HashMap localHashMap = new HashMap(paramMap.size());
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      if ((localEntry != null) && (localEntry.getKey() != null) && (localEntry.getValue() != null)) {
        localHashMap.put(localEntry.getKey(), convertToQQUnionIconInfo((IconInfo)localEntry.getValue()));
      }
    }
    return localHashMap;
  }
  
  public static QQUnionIconInfo parseFromJson(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    QQUnionIconInfo localQQUnionIconInfo = new QQUnionIconInfo();
    try
    {
      localQQUnionIconInfo.mIconUrl = paramJSONObject.optString("mIconUrl");
      localQQUnionIconInfo.mIconWidth = paramJSONObject.optInt("mIconWidth");
      localQQUnionIconInfo.mIconHeight = paramJSONObject.optInt("mIconHeight");
      return localQQUnionIconInfo;
    }
    catch (Exception paramJSONObject)
    {
      QZLog.e("QQUnionIconInfo", "parseFromJson error", paramJSONObject);
    }
    return localQQUnionIconInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.vip.vipcomponent.QQUnionIconInfo
 * JD-Core Version:    0.7.0.1
 */