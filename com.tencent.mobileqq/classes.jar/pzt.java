import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import java.net.URL;
import org.json.JSONObject;

public class pzt
{
  public static JSONObject a(BaseArticleInfo paramBaseArticleInfo)
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    if (paramBaseArticleInfo.mSinglePicture != null) {}
    for (String str = paramBaseArticleInfo.mSinglePicture.getFile();; str = null)
    {
      localJSONObject2.put("article_small_imge_url", str);
      localJSONObject1.put("id_article_small_imge", localJSONObject2);
      qai.a(paramBaseArticleInfo, localJSONObject1, true);
      qai.a(paramBaseArticleInfo, localJSONObject1);
      qai.d(paramBaseArticleInfo, localJSONObject1);
      qai.g(paramBaseArticleInfo, localJSONObject1);
      qai.n(paramBaseArticleInfo, localJSONObject1);
      qai.h(paramBaseArticleInfo, localJSONObject1);
      qai.Z(paramBaseArticleInfo, localJSONObject1);
      qai.ad(paramBaseArticleInfo, localJSONObject1);
      localJSONObject1.put("style_ID", "ReadInjoy_small_cell");
      qai.a(localJSONObject1, paramBaseArticleInfo);
      qai.ac(paramBaseArticleInfo, localJSONObject1);
      return localJSONObject1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pzt
 * JD-Core Version:    0.7.0.1
 */