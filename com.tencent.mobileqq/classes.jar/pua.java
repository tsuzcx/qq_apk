import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import java.net.URL;
import org.json.JSONObject;

public class pua
{
  public static JSONObject a(BaseArticleInfo paramBaseArticleInfo)
  {
    JSONObject localJSONObject1 = new JSONObject();
    Object localObject = new JSONObject();
    ((JSONObject)localObject).put("small_video_icon", "public_account_video_profile");
    localJSONObject1.put("id_small_video_icon", localObject);
    localObject = new JSONObject();
    ((JSONObject)localObject).put("small_video_cover", "public_account_small_video_mengceng");
    localJSONObject1.put("id_small_video_cover", localObject);
    JSONObject localJSONObject2 = new JSONObject();
    if (paramBaseArticleInfo.mSinglePicture != null)
    {
      localObject = paramBaseArticleInfo.mSinglePicture.getFile();
      localJSONObject2.put("article_small_imge_url", localObject);
      localJSONObject1.put("id_article_small_imge", localJSONObject2);
      localObject = new JSONObject();
      ((JSONObject)localObject).put("small_video_duration", ozc.a(paramBaseArticleInfo.mVideoDuration));
      localJSONObject1.put("id_small_video_duration", localObject);
      puo.a(paramBaseArticleInfo, localJSONObject1, true);
      if (AdvertisementInfo.isAdvertisementInfo(paramBaseArticleInfo)) {
        break label186;
      }
      puo.a(paramBaseArticleInfo, localJSONObject1);
      puo.b(paramBaseArticleInfo, localJSONObject1);
    }
    for (;;)
    {
      puo.l(paramBaseArticleInfo, localJSONObject1);
      puo.e(paramBaseArticleInfo, localJSONObject1);
      puo.g(paramBaseArticleInfo, localJSONObject1);
      localJSONObject1.put("style_ID", "ReadInjoy_small_cell");
      puo.a(localJSONObject1, paramBaseArticleInfo);
      return localJSONObject1;
      localObject = null;
      break;
      label186:
      puo.d(paramBaseArticleInfo, localJSONObject1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pua
 * JD-Core Version:    0.7.0.1
 */