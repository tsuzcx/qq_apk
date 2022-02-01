import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import org.json.JSONArray;
import org.json.JSONObject;

public class ptr
{
  public static JSONObject a(BaseArticleInfo paramBaseArticleInfo)
  {
    JSONObject localJSONObject = new JSONObject();
    String str4 = "";
    String str5 = "";
    String str6 = "";
    puo.a(paramBaseArticleInfo, localJSONObject, true);
    puo.a(paramBaseArticleInfo, localJSONObject);
    puo.b(paramBaseArticleInfo, localJSONObject);
    puo.l(paramBaseArticleInfo, localJSONObject);
    puo.e(paramBaseArticleInfo, localJSONObject);
    puo.f(paramBaseArticleInfo, localJSONObject);
    puo.X(paramBaseArticleInfo, localJSONObject);
    puo.aa(paramBaseArticleInfo, localJSONObject);
    puo.ab(paramBaseArticleInfo, localJSONObject);
    localJSONObject.put("style_ID", "ReadInjoy_ad_small_game_triple_img_cell");
    puo.a(localJSONObject, paramBaseArticleInfo);
    String str1 = str6;
    String str2 = str5;
    String str3 = str4;
    if (paramBaseArticleInfo.mSmallMiniGameInfo != null)
    {
      str1 = str6;
      str2 = str5;
      str3 = str4;
      if (paramBaseArticleInfo.mSmallMiniGameInfo.a != null)
      {
        str1 = str6;
        str2 = str5;
        str3 = str4;
        if (paramBaseArticleInfo.mSmallMiniGameInfo.a.length() > 2)
        {
          str3 = paramBaseArticleInfo.mSmallMiniGameInfo.a.optString(0);
          str2 = paramBaseArticleInfo.mSmallMiniGameInfo.a.optString(1);
          str1 = paramBaseArticleInfo.mSmallMiniGameInfo.a.optString(2);
        }
      }
    }
    paramBaseArticleInfo = new JSONObject();
    paramBaseArticleInfo.put("multi_img_url1", str3);
    localJSONObject.put("id_multi_img_1", paramBaseArticleInfo);
    paramBaseArticleInfo = new JSONObject();
    paramBaseArticleInfo.put("multi_img_url2", str2);
    localJSONObject.put("id_multi_img_2", paramBaseArticleInfo);
    paramBaseArticleInfo = new JSONObject();
    paramBaseArticleInfo.put("multi_img_url3", str1);
    localJSONObject.put("id_multi_img_3", paramBaseArticleInfo);
    return localJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ptr
 * JD-Core Version:    0.7.0.1
 */