import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import java.net.URL;
import org.json.JSONObject;

public class ptw
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
      puo.a(paramBaseArticleInfo, localJSONObject1, true);
      if (AdvertisementInfo.isAdvertisementInfo(paramBaseArticleInfo)) {
        break label130;
      }
      puo.a(paramBaseArticleInfo, localJSONObject1);
      puo.b(paramBaseArticleInfo, localJSONObject1);
    }
    for (;;)
    {
      puo.l(paramBaseArticleInfo, localJSONObject1);
      puo.e(paramBaseArticleInfo, localJSONObject1);
      puo.g(paramBaseArticleInfo, localJSONObject1);
      puo.X(paramBaseArticleInfo, localJSONObject1);
      localJSONObject1.put("style_ID", "ReadInjoy_large_cell");
      puo.a(localJSONObject1, paramBaseArticleInfo);
      puo.aa(paramBaseArticleInfo, localJSONObject1);
      return localJSONObject1;
      str = null;
      break;
      label130:
      puo.d(paramBaseArticleInfo, localJSONObject1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ptw
 * JD-Core Version:    0.7.0.1
 */