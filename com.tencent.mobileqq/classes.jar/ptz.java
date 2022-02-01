import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import java.net.URL;
import org.json.JSONObject;

public class ptz
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
      puo.a(paramBaseArticleInfo, localJSONObject1, true);
      puo.a(paramBaseArticleInfo, localJSONObject1);
      puo.b(paramBaseArticleInfo, localJSONObject1);
      puo.e(paramBaseArticleInfo, localJSONObject1);
      puo.l(paramBaseArticleInfo, localJSONObject1);
      puo.f(paramBaseArticleInfo, localJSONObject1);
      puo.X(paramBaseArticleInfo, localJSONObject1);
      puo.ab(paramBaseArticleInfo, localJSONObject1);
      localJSONObject1.put("style_ID", "ReadInjoy_small_cell");
      puo.a(localJSONObject1, paramBaseArticleInfo);
      puo.aa(paramBaseArticleInfo, localJSONObject1);
      return localJSONObject1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ptz
 * JD-Core Version:    0.7.0.1
 */