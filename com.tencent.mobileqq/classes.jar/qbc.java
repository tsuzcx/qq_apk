import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import java.net.URL;
import org.json.JSONObject;

public class qbc
{
  public static JSONObject a(BaseArticleInfo paramBaseArticleInfo)
  {
    JSONObject localJSONObject1 = new JSONObject();
    Object localObject = new JSONObject();
    ((JSONObject)localObject).put("large_video_icon", "pa_video_play.png");
    localJSONObject1.put("id_large_video_icon", localObject);
    localObject = new JSONObject();
    ((JSONObject)localObject).put("large_video_cover", "mengceng.png");
    localJSONObject1.put("id_large_video_cover", localObject);
    JSONObject localJSONObject2 = new JSONObject();
    localObject = paramBaseArticleInfo.getVideoCoverUrlWithSmartCut(false);
    if (localObject != null)
    {
      localObject = ((URL)localObject).getPath();
      localJSONObject2.put("article_large_imge_url", localObject);
      localJSONObject1.put("id_article_large_imge", localJSONObject2);
      localObject = new JSONObject();
      ((JSONObject)localObject).put("large_video_duration", pgk.a(paramBaseArticleInfo.mVideoDuration));
      localJSONObject1.put("id_large_video_duration", localObject);
      localObject = new JSONObject();
      ((JSONObject)localObject).put("video_play_icon", "small_video_play_icon");
      localJSONObject1.put("id_video_play_icon", localObject);
      localJSONObject1.put("id_video_paly_text", new JSONObject());
      qcd.a(paramBaseArticleInfo, localJSONObject1, true);
      qcd.X(paramBaseArticleInfo, localJSONObject1);
      if (AdvertisementInfo.isAdvertisementInfo(paramBaseArticleInfo)) {
        break label393;
      }
      qcd.a(paramBaseArticleInfo, localJSONObject1);
      qcd.b(paramBaseArticleInfo, localJSONObject1);
      label194:
      qcd.l(paramBaseArticleInfo, localJSONObject1);
      qcd.e(paramBaseArticleInfo, localJSONObject1);
      localJSONObject1.put("id_large_video_activity_wrapper", new JSONObject());
      localObject = new JSONObject();
      ((JSONObject)localObject).put("activity_img_path", "free_netflow_icon");
      localJSONObject1.put("id_large_video_activity_img", localObject);
      localJSONObject1.put("id_large_video_activity_label", new JSONObject());
      localObject = new JSONObject();
      if ((paramBaseArticleInfo.mSmallMiniGameInfo == null) || (TextUtils.isEmpty(paramBaseArticleInfo.mSmallMiniGameInfo.f))) {
        break label401;
      }
      ((JSONObject)localObject).put("video_paly_text", paramBaseArticleInfo.mSmallMiniGameInfo.f);
    }
    for (;;)
    {
      localJSONObject1.put("id_video_paly_text", localObject);
      localObject = new JSONObject();
      if ((paramBaseArticleInfo.mSmallMiniGameInfo != null) && (!TextUtils.isEmpty(paramBaseArticleInfo.mSmallMiniGameInfo.g))) {
        ((JSONObject)localObject).put("video_play_icon", paramBaseArticleInfo.mSmallMiniGameInfo.g);
      }
      localJSONObject1.put("id_video_play_icon", localObject);
      localJSONObject1.put("style_ID", "ReadInjoy_ad_small_game_large_cell");
      qcd.f(paramBaseArticleInfo, localJSONObject1);
      qcd.aj(paramBaseArticleInfo, localJSONObject1);
      qcd.a(localJSONObject1, paramBaseArticleInfo);
      qcd.aa(paramBaseArticleInfo, localJSONObject1);
      return localJSONObject1;
      localObject = null;
      break;
      label393:
      qcd.d(paramBaseArticleInfo, localJSONObject1);
      break label194;
      label401:
      ((JSONObject)localObject).put("video_paly_text", "轻触玩游戏");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qbc
 * JD-Core Version:    0.7.0.1
 */