import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import java.net.URL;
import org.json.JSONObject;

public class pkg
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
      pkm.a(paramBaseArticleInfo, localJSONObject1, true);
      pkm.a(paramBaseArticleInfo, localJSONObject1);
      pkm.b(paramBaseArticleInfo, localJSONObject1);
      pkm.e(paramBaseArticleInfo, localJSONObject1);
      pkm.l(paramBaseArticleInfo, localJSONObject1);
      pkm.f(paramBaseArticleInfo, localJSONObject1);
      pkm.X(paramBaseArticleInfo, localJSONObject1);
      pkm.ab(paramBaseArticleInfo, localJSONObject1);
      localJSONObject1.put("style_ID", "ReadInjoy_small_cell");
      pkm.a(localJSONObject1, paramBaseArticleInfo);
      pkm.aa(paramBaseArticleInfo, localJSONObject1);
      return localJSONObject1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pkg
 * JD-Core Version:    0.7.0.1
 */