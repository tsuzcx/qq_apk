package cooperation.qzone.font;

import org.json.JSONObject;

public class DefaultBarrageEffectInfo
{
  public int itemId = -1;
  public String jsonStr;
  
  public static String toJson(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("iItemId", paramInt1);
      localJSONObject.put("strTextColor", paramString1);
      localJSONObject.put("strAndBgUrl", paramString2);
      localJSONObject.put("strIosBgUrl", paramString3);
      localJSONObject.put("strFrameZip", paramString4);
      localJSONObject.put("iFrameRate", paramInt2);
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
    return localJSONObject.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.font.DefaultBarrageEffectInfo
 * JD-Core Version:    0.7.0.1
 */