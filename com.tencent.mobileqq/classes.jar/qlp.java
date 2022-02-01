import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import java.net.URL;
import org.json.JSONObject;

public class qlp
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
      qmm.a(paramBaseArticleInfo, localJSONObject1, true);
      uks.e(paramBaseArticleInfo, localJSONObject1);
      qmm.d(paramBaseArticleInfo, localJSONObject1);
      qmm.g(paramBaseArticleInfo, localJSONObject1);
      qmm.n(paramBaseArticleInfo, localJSONObject1);
      qmm.i(paramBaseArticleInfo, localJSONObject1);
      qmm.ab(paramBaseArticleInfo, localJSONObject1);
      if (!ois.a(paramBaseArticleInfo)) {
        break label125;
      }
      localJSONObject1.put("style_ID", "ReadInjoy_ad_small_location_cell");
    }
    for (;;)
    {
      localJSONObject1.put("id_small_cell_container", new JSONObject());
      qmm.a(localJSONObject1, paramBaseArticleInfo);
      return localJSONObject1;
      str = null;
      break;
      label125:
      localJSONObject1.put("style_ID", "ReadInjoy_ad_small_cell");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qlp
 * JD-Core Version:    0.7.0.1
 */