import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import java.net.URL;
import org.json.JSONObject;

public class pju
{
  public static JSONObject a(BaseArticleInfo paramBaseArticleInfo)
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    String str;
    if (paramBaseArticleInfo.mSinglePicture != null)
    {
      str = paramBaseArticleInfo.mSinglePicture.getFile();
      localJSONObject2.put("article_small_imge_url", str);
      localJSONObject1.put("id_article_small_imge", localJSONObject2);
      pkm.a(paramBaseArticleInfo, localJSONObject1, true);
      oee.b(paramBaseArticleInfo, localJSONObject1);
      pkm.b(paramBaseArticleInfo, localJSONObject1);
      pkm.e(paramBaseArticleInfo, localJSONObject1);
      pkm.l(paramBaseArticleInfo, localJSONObject1);
      pkm.g(paramBaseArticleInfo, localJSONObject1);
      pkm.Z(paramBaseArticleInfo, localJSONObject1);
      if (!noy.a(paramBaseArticleInfo)) {
        break label125;
      }
      localJSONObject1.put("style_ID", "ReadInjoy_ad_small_location_cell");
    }
    for (;;)
    {
      localJSONObject1.put("id_small_cell_container", new JSONObject());
      pkm.a(localJSONObject1, paramBaseArticleInfo);
      return localJSONObject1;
      str = null;
      break;
      label125:
      localJSONObject1.put("style_ID", "ReadInjoy_ad_small_cell");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pju
 * JD-Core Version:    0.7.0.1
 */