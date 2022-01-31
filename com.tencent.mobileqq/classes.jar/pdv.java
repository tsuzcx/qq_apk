import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import java.net.URL;
import org.json.JSONObject;

public class pdv
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
      pen.a(paramBaseArticleInfo, localJSONObject1, true);
      oau.b(paramBaseArticleInfo, localJSONObject1);
      pen.b(paramBaseArticleInfo, localJSONObject1);
      pen.e(paramBaseArticleInfo, localJSONObject1);
      pen.m(paramBaseArticleInfo, localJSONObject1);
      pen.g(paramBaseArticleInfo, localJSONObject1);
      pen.aa(paramBaseArticleInfo, localJSONObject1);
      if (!nmf.a(paramBaseArticleInfo)) {
        break label125;
      }
      localJSONObject1.put("style_ID", "ReadInjoy_ad_small_location_cell");
    }
    for (;;)
    {
      localJSONObject1.put("id_small_cell_container", new JSONObject());
      pen.a(localJSONObject1, paramBaseArticleInfo);
      return localJSONObject1;
      str = null;
      break;
      label125:
      localJSONObject1.put("style_ID", "ReadInjoy_ad_small_cell");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pdv
 * JD-Core Version:    0.7.0.1
 */