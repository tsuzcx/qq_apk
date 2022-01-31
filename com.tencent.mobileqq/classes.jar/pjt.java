import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import java.net.URL;
import org.json.JSONObject;

public class pjt
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
      pkm.a(paramBaseArticleInfo, localJSONObject1, true, "3");
      pkm.l(paramBaseArticleInfo, localJSONObject1);
      pkm.e(paramBaseArticleInfo, localJSONObject1);
      oee.b(paramBaseArticleInfo, localJSONObject1);
      oee.a(paramBaseArticleInfo, localJSONObject1);
      localJSONObject1.put("style_ID", "ReadInjoy_ad_pk_cell");
      pkm.a(localJSONObject1, paramBaseArticleInfo);
      return localJSONObject1;
      localObject = null;
      break;
      label103:
      localObject = (AdvertisementInfo)paramBaseArticleInfo;
      if (((AdvertisementInfo)localObject).mAdvertisementExtInfo != null) {
        oee.a(localJSONObject1, ((AdvertisementInfo)localObject).mAdvertisementExtInfo);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pjt
 * JD-Core Version:    0.7.0.1
 */