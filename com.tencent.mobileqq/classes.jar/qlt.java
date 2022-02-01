import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import java.net.URL;
import org.json.JSONObject;

public class qlt
{
  public static JSONObject a(BaseArticleInfo paramBaseArticleInfo)
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    if (paramBaseArticleInfo.mSinglePicture != null) {}
    for (Object localObject = paramBaseArticleInfo.mSinglePicture.getFile();; localObject = null)
    {
      localJSONObject2.put("article_large_imge_url", localObject);
      localJSONObject1.put("id_article_large_imge", localJSONObject2);
      if (paramBaseArticleInfo.mGalleryPicNumber > 1)
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("gallery_cn_text", paramBaseArticleInfo.mGalleryPicNumber + anvx.a(2131712354));
        localJSONObject1.put("id_gallery_cnt", localObject);
        localObject = new JSONObject();
        ((JSONObject)localObject).put("gallery_icon", "qq_readinjoy_gallery_count");
        localJSONObject1.put("id_gallery_img", localObject);
        localJSONObject1.put("id_gallery_bg", new JSONObject());
      }
      qmm.a(paramBaseArticleInfo, localJSONObject1, true);
      qmm.n(paramBaseArticleInfo, localJSONObject1);
      qmm.k(paramBaseArticleInfo, localJSONObject1);
      qmm.a(localJSONObject1);
      localJSONObject1.put("style_ID", "ReadInjoy_gallery_channel_large_cell");
      qmm.a(localJSONObject1, paramBaseArticleInfo);
      return localJSONObject1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qlt
 * JD-Core Version:    0.7.0.1
 */