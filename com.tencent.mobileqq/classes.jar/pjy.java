import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import java.net.URL;
import org.json.JSONObject;

public class pjy
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
        ((JSONObject)localObject).put("gallery_cn_text", paramBaseArticleInfo.mGalleryPicNumber + alud.a(2131713287));
        localJSONObject1.put("id_gallery_cnt", localObject);
        localObject = new JSONObject();
        ((JSONObject)localObject).put("gallery_icon", "qq_readinjoy_gallery_count");
        localJSONObject1.put("id_gallery_img", localObject);
        localJSONObject1.put("id_gallery_bg", new JSONObject());
      }
      pkm.a(paramBaseArticleInfo, localJSONObject1, true);
      pkm.l(paramBaseArticleInfo, localJSONObject1);
      pkm.i(paramBaseArticleInfo, localJSONObject1);
      pkm.a(localJSONObject1);
      localJSONObject1.put("style_ID", "ReadInjoy_gallery_channel_large_cell");
      pkm.a(localJSONObject1, paramBaseArticleInfo);
      return localJSONObject1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pjy
 * JD-Core Version:    0.7.0.1
 */