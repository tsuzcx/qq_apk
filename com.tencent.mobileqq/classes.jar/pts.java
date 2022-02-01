import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import java.net.URL;
import org.json.JSONObject;

public class pts
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
      ((JSONObject)localObject).put("gallery_cn_text", paramBaseArticleInfo.mGalleryPicNumber + anzj.a(2131711739));
      localJSONObject1.put("id_gallery_cnt", localObject);
      localObject = new JSONObject();
      ((JSONObject)localObject).put("gallery_icon", "qq_readinjoy_gallery_count");
      localJSONObject1.put("id_gallery_img", localObject);
      localJSONObject1.put("id_gallery_bg", new JSONObject());
      puo.a(paramBaseArticleInfo, localJSONObject1, true);
      if (AdvertisementInfo.isAdvertisementInfo(paramBaseArticleInfo)) {
        break label207;
      }
      puo.a(paramBaseArticleInfo, localJSONObject1);
      puo.b(paramBaseArticleInfo, localJSONObject1);
    }
    for (;;)
    {
      puo.l(paramBaseArticleInfo, localJSONObject1);
      puo.e(paramBaseArticleInfo, localJSONObject1);
      puo.g(paramBaseArticleInfo, localJSONObject1);
      localJSONObject1.put("style_ID", "ReadInjoy_large_cell");
      puo.a(localJSONObject1, paramBaseArticleInfo);
      return localJSONObject1;
      localObject = null;
      break;
      label207:
      puo.d(paramBaseArticleInfo, localJSONObject1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pts
 * JD-Core Version:    0.7.0.1
 */