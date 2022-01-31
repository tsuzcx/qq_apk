import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import java.net.URL;
import org.json.JSONObject;

public class pdn
{
  public static JSONObject a(BaseArticleInfo paramBaseArticleInfo)
  {
    JSONObject localJSONObject1 = new JSONObject();
    localJSONObject1.put("id_test", new JSONObject());
    JSONObject localJSONObject2 = new JSONObject();
    Object localObject;
    if (paramBaseArticleInfo.mSinglePicture != null)
    {
      localObject = paramBaseArticleInfo.mSinglePicture.getFile();
      localJSONObject2.put("article_large_imge_url", localObject);
      localJSONObject1.put("id_article_large_imge", localJSONObject2);
      localObject = new JSONObject();
      ((JSONObject)localObject).put("gallery_cn_text", paramBaseArticleInfo.mGalleryPicNumber + ajya.a(2131712867));
      localJSONObject1.put("id_gallery_cnt", localObject);
      localObject = new JSONObject();
      ((JSONObject)localObject).put("gallery_icon", "qq_readinjoy_gallery_count");
      localJSONObject1.put("id_gallery_img", localObject);
      localJSONObject1.put("id_gallery_bg", new JSONObject());
      pek.a(paramBaseArticleInfo, localJSONObject1, true);
      if (AdvertisementInfo.isAdvertisementInfo(paramBaseArticleInfo)) {
        break label207;
      }
      pek.a(paramBaseArticleInfo, localJSONObject1);
      pek.b(paramBaseArticleInfo, localJSONObject1);
    }
    for (;;)
    {
      pek.m(paramBaseArticleInfo, localJSONObject1);
      pek.e(paramBaseArticleInfo, localJSONObject1);
      pek.g(paramBaseArticleInfo, localJSONObject1);
      localJSONObject1.put("style_ID", "ReadInjoy_large_cell");
      pek.a(localJSONObject1, paramBaseArticleInfo);
      return localJSONObject1;
      localObject = null;
      break;
      label207:
      pek.d(paramBaseArticleInfo, localJSONObject1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pdn
 * JD-Core Version:    0.7.0.1
 */