import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import java.net.URL;
import org.json.JSONObject;

public class qbo
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
      qcd.a(paramBaseArticleInfo, localJSONObject1, true);
      qcd.a(paramBaseArticleInfo, localJSONObject1);
      qcd.b(paramBaseArticleInfo, localJSONObject1);
      qcd.e(paramBaseArticleInfo, localJSONObject1);
      qcd.l(paramBaseArticleInfo, localJSONObject1);
      qcd.f(paramBaseArticleInfo, localJSONObject1);
      qcd.X(paramBaseArticleInfo, localJSONObject1);
      qcd.ab(paramBaseArticleInfo, localJSONObject1);
      localJSONObject1.put("style_ID", "ReadInjoy_small_cell");
      qcd.a(localJSONObject1, paramBaseArticleInfo);
      qcd.aa(paramBaseArticleInfo, localJSONObject1);
      return localJSONObject1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qbo
 * JD-Core Version:    0.7.0.1
 */