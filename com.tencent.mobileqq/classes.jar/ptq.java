import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import java.net.URL;
import org.json.JSONObject;

public class ptq
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
      puo.a(paramBaseArticleInfo, localJSONObject1, true);
      tqa.b(paramBaseArticleInfo, localJSONObject1);
      puo.b(paramBaseArticleInfo, localJSONObject1);
      puo.e(paramBaseArticleInfo, localJSONObject1);
      puo.l(paramBaseArticleInfo, localJSONObject1);
      puo.g(paramBaseArticleInfo, localJSONObject1);
      puo.Z(paramBaseArticleInfo, localJSONObject1);
      if (!nzq.a(paramBaseArticleInfo)) {
        break label125;
      }
      localJSONObject1.put("style_ID", "ReadInjoy_ad_small_location_cell");
    }
    for (;;)
    {
      localJSONObject1.put("id_small_cell_container", new JSONObject());
      puo.a(localJSONObject1, paramBaseArticleInfo);
      return localJSONObject1;
      str = null;
      break;
      label125:
      localJSONObject1.put("style_ID", "ReadInjoy_ad_small_cell");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ptq
 * JD-Core Version:    0.7.0.1
 */