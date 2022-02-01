import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import java.net.URL;
import org.json.JSONObject;

public class qlv
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
      qmm.a(paramBaseArticleInfo, localJSONObject1, true);
      if (AdvertisementInfo.isAdvertisementInfo(paramBaseArticleInfo)) {
        break label130;
      }
      qmm.a(paramBaseArticleInfo, localJSONObject1);
      qmm.d(paramBaseArticleInfo, localJSONObject1);
    }
    for (;;)
    {
      qmm.n(paramBaseArticleInfo, localJSONObject1);
      qmm.g(paramBaseArticleInfo, localJSONObject1);
      qmm.i(paramBaseArticleInfo, localJSONObject1);
      qmm.Z(paramBaseArticleInfo, localJSONObject1);
      localJSONObject1.put("style_ID", "ReadInjoy_large_cell");
      qmm.a(localJSONObject1, paramBaseArticleInfo);
      qmm.ac(paramBaseArticleInfo, localJSONObject1);
      return localJSONObject1;
      str = null;
      break;
      label130:
      qmm.f(paramBaseArticleInfo, localJSONObject1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qlv
 * JD-Core Version:    0.7.0.1
 */