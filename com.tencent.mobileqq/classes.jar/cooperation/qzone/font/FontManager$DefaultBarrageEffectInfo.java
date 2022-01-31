package cooperation.qzone.font;

import org.json.JSONObject;

public class FontManager$DefaultBarrageEffectInfo
{
  public int a = -1;
  public String a;
  
  public static String a(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("iItemId", paramInt);
      localJSONObject.put("strTextColor", paramString1);
      localJSONObject.put("strAndBgUrl", paramString2);
      localJSONObject.put("strIosBgUrl", paramString3);
      return localJSONObject.toString();
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        paramString1.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.font.FontManager.DefaultBarrageEffectInfo
 * JD-Core Version:    0.7.0.1
 */