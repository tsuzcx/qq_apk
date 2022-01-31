import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import java.net.URL;
import org.json.JSONObject;

public class otb
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
      ((JSONObject)localObject).put("large_video_duration", obj.a(paramBaseArticleInfo.mVideoDuration));
      localJSONObject1.put("id_large_video_duration", localObject);
      localObject = new JSONObject();
      ((JSONObject)localObject).put("video_play_icon", "small_video_play_icon");
      localJSONObject1.put("id_video_play_icon", localObject);
      localJSONObject1.put("id_video_paly_text", new JSONObject());
      otl.a(paramBaseArticleInfo, localJSONObject1, true);
      otl.X(paramBaseArticleInfo, localJSONObject1);
      if (AdvertisementInfo.isAdvertisementInfo(paramBaseArticleInfo)) {
        break label288;
      }
      otl.a(paramBaseArticleInfo, localJSONObject1);
      otl.b(paramBaseArticleInfo, localJSONObject1);
    }
    for (;;)
    {
      otl.m(paramBaseArticleInfo, localJSONObject1);
      otl.e(paramBaseArticleInfo, localJSONObject1);
      localJSONObject1.put("id_large_video_activity_wrapper", new JSONObject());
      localObject = new JSONObject();
      ((JSONObject)localObject).put("activity_img_path", "free_netflow_icon");
      localJSONObject1.put("id_large_video_activity_img", localObject);
      localJSONObject1.put("id_large_video_activity_label", new JSONObject());
      localJSONObject1.put("style_ID", "ReadInjoy_large_cell");
      otl.f(paramBaseArticleInfo, localJSONObject1);
      otl.a(localJSONObject1, paramBaseArticleInfo);
      otl.aa(paramBaseArticleInfo, localJSONObject1);
      return localJSONObject1;
      localObject = null;
      break;
      label288:
      otl.d(paramBaseArticleInfo, localJSONObject1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     otb
 * JD-Core Version:    0.7.0.1
 */