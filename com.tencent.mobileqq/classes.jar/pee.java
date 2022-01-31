import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import java.net.URL;
import org.json.JSONObject;

public class pee
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
      pek.a(paramBaseArticleInfo, localJSONObject1, true);
      pek.a(paramBaseArticleInfo, localJSONObject1);
      pek.b(paramBaseArticleInfo, localJSONObject1);
      pek.e(paramBaseArticleInfo, localJSONObject1);
      pek.m(paramBaseArticleInfo, localJSONObject1);
      pek.f(paramBaseArticleInfo, localJSONObject1);
      pek.Y(paramBaseArticleInfo, localJSONObject1);
      pek.ac(paramBaseArticleInfo, localJSONObject1);
      localJSONObject1.put("style_ID", "ReadInjoy_small_cell");
      pek.a(localJSONObject1, paramBaseArticleInfo);
      pek.ab(paramBaseArticleInfo, localJSONObject1);
      return localJSONObject1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pee
 * JD-Core Version:    0.7.0.1
 */