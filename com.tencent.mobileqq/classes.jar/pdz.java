import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import java.net.URL;
import org.json.JSONObject;

public class pdz
{
  public static JSONObject a(BaseArticleInfo paramBaseArticleInfo)
  {
    JSONObject localJSONObject1 = new JSONObject();
    localJSONObject1.put("id_test", new JSONObject());
    JSONObject localJSONObject2 = new JSONObject();
    String str;
    if (paramBaseArticleInfo.mSinglePicture != null)
    {
      str = paramBaseArticleInfo.mSinglePicture.getFile();
      localJSONObject2.put("article_large_imge_url", str);
      localJSONObject1.put("id_article_large_imge", localJSONObject2);
      pek.a(paramBaseArticleInfo, localJSONObject1, true);
      if (AdvertisementInfo.isAdvertisementInfo(paramBaseArticleInfo)) {
        break label130;
      }
      pek.a(paramBaseArticleInfo, localJSONObject1);
      pek.b(paramBaseArticleInfo, localJSONObject1);
    }
    for (;;)
    {
      pek.m(paramBaseArticleInfo, localJSONObject1);
      pek.e(paramBaseArticleInfo, localJSONObject1);
      pek.g(paramBaseArticleInfo, localJSONObject1);
      pek.Y(paramBaseArticleInfo, localJSONObject1);
      localJSONObject1.put("style_ID", "ReadInjoy_large_cell");
      pek.a(localJSONObject1, paramBaseArticleInfo);
      pek.ab(paramBaseArticleInfo, localJSONObject1);
      return localJSONObject1;
      str = null;
      break;
      label130:
      pek.d(paramBaseArticleInfo, localJSONObject1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pdz
 * JD-Core Version:    0.7.0.1
 */