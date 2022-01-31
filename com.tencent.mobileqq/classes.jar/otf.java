import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import java.net.URL;
import org.json.JSONObject;

public class otf
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
      otl.a(paramBaseArticleInfo, localJSONObject1, true);
      otl.a(paramBaseArticleInfo, localJSONObject1);
      otl.b(paramBaseArticleInfo, localJSONObject1);
      otl.e(paramBaseArticleInfo, localJSONObject1);
      otl.m(paramBaseArticleInfo, localJSONObject1);
      otl.f(paramBaseArticleInfo, localJSONObject1);
      otl.X(paramBaseArticleInfo, localJSONObject1);
      otl.ab(paramBaseArticleInfo, localJSONObject1);
      localJSONObject1.put("style_ID", "ReadInjoy_small_cell");
      otl.a(localJSONObject1, paramBaseArticleInfo);
      otl.aa(paramBaseArticleInfo, localJSONObject1);
      return localJSONObject1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     otf
 * JD-Core Version:    0.7.0.1
 */