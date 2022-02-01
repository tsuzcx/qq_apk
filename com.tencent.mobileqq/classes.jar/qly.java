import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import java.net.URL;
import org.json.JSONObject;

public class qly
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
      qmm.a(paramBaseArticleInfo, localJSONObject1, true);
      qmm.a(paramBaseArticleInfo, localJSONObject1);
      qmm.d(paramBaseArticleInfo, localJSONObject1);
      qmm.g(paramBaseArticleInfo, localJSONObject1);
      qmm.n(paramBaseArticleInfo, localJSONObject1);
      qmm.h(paramBaseArticleInfo, localJSONObject1);
      qmm.Z(paramBaseArticleInfo, localJSONObject1);
      qmm.ad(paramBaseArticleInfo, localJSONObject1);
      localJSONObject1.put("style_ID", "ReadInjoy_small_cell");
      qmm.a(localJSONObject1, paramBaseArticleInfo);
      qmm.ac(paramBaseArticleInfo, localJSONObject1);
      return localJSONObject1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qly
 * JD-Core Version:    0.7.0.1
 */