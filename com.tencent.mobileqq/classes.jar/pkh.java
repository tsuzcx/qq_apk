import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import java.net.URL;
import org.json.JSONObject;

public class pkh
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
      ((JSONObject)localObject).put("small_video_duration", orc.a(paramBaseArticleInfo.mVideoDuration));
      localJSONObject1.put("id_small_video_duration", localObject);
      pkm.a(paramBaseArticleInfo, localJSONObject1, true);
      if (AdvertisementInfo.isAdvertisementInfo(paramBaseArticleInfo)) {
        break label186;
      }
      pkm.a(paramBaseArticleInfo, localJSONObject1);
      pkm.b(paramBaseArticleInfo, localJSONObject1);
    }
    for (;;)
    {
      pkm.l(paramBaseArticleInfo, localJSONObject1);
      pkm.e(paramBaseArticleInfo, localJSONObject1);
      pkm.g(paramBaseArticleInfo, localJSONObject1);
      localJSONObject1.put("style_ID", "ReadInjoy_small_cell");
      pkm.a(localJSONObject1, paramBaseArticleInfo);
      return localJSONObject1;
      localObject = null;
      break;
      label186:
      pkm.d(paramBaseArticleInfo, localJSONObject1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pkh
 * JD-Core Version:    0.7.0.1
 */