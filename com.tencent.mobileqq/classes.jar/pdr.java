import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import java.net.URL;
import org.json.JSONObject;

public class pdr
{
  public static JSONObject a(BaseArticleInfo paramBaseArticleInfo)
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    Object localObject;
    if (paramBaseArticleInfo.mSinglePicture != null)
    {
      localObject = paramBaseArticleInfo.mSinglePicture.getFile();
      localJSONObject2.put("article_large_imge_url", localObject);
      localJSONObject1.put("id_article_large_imge", localJSONObject2);
      if (AdvertisementInfo.isAdvertisementInfo(paramBaseArticleInfo)) {
        break label103;
      }
    }
    for (;;)
    {
      pek.a(paramBaseArticleInfo, localJSONObject1, true, "3");
      pek.m(paramBaseArticleInfo, localJSONObject1);
      pek.e(paramBaseArticleInfo, localJSONObject1);
      oar.b(paramBaseArticleInfo, localJSONObject1);
      oar.a(paramBaseArticleInfo, localJSONObject1);
      localJSONObject1.put("style_ID", "ReadInjoy_ad_pk_cell");
      pek.a(localJSONObject1, paramBaseArticleInfo);
      return localJSONObject1;
      localObject = null;
      break;
      label103:
      localObject = (AdvertisementInfo)paramBaseArticleInfo;
      if (((AdvertisementInfo)localObject).mAdvertisementExtInfo != null) {
        oar.a(localJSONObject1, ((AdvertisementInfo)localObject).mAdvertisementExtInfo);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pdr
 * JD-Core Version:    0.7.0.1
 */