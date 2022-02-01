import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import java.net.URL;
import org.json.JSONObject;

public class pzg
{
  public static JSONObject a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
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
      localObject = ((URL)localObject).getFile();
      localJSONObject2.put("article_large_imge_url", localObject);
      localJSONObject1.put("id_article_large_imge", localJSONObject2);
      localJSONObject2 = new JSONObject();
      if ((!AdvertisementInfo.isAdvertisementInfo(paramBaseArticleInfo)) || (((AdvertisementInfo)paramBaseArticleInfo).mImaxShowAdType != 1001) || (paramBaseArticleInfo.mVideoDuration != 0)) {
        break label502;
      }
      localObject = "";
      label143:
      localJSONObject2.put("large_video_duration", localObject);
      localJSONObject1.put("id_large_video_duration", localJSONObject2);
      localObject = new JSONObject();
      ((JSONObject)localObject).put("video_play_icon", "video_play_icon");
      localJSONObject1.put("id_video_play_icon", localObject);
      localJSONObject1.put("id_video_paly_text", new JSONObject());
      if ((!((AdvertisementInfo)paramBaseArticleInfo).isIMaxAndNewStyle) || (paramInt != 115)) {
        break label513;
      }
      paramInt = 1;
      label221:
      if (paramInt != 0) {
        break label518;
      }
    }
    label513:
    label518:
    for (boolean bool = true;; bool = false)
    {
      qai.a(paramBaseArticleInfo, localJSONObject1, bool, "3");
      if (AdvertisementInfo.isAdvertisementInfo(paramBaseArticleInfo))
      {
        qai.f(paramBaseArticleInfo, localJSONObject1);
        localObject = new JSONObject();
        ((JSONObject)localObject).put("article_model", paramBaseArticleInfo);
        if (((AdvertisementInfo)paramBaseArticleInfo).mShowAdButton) {
          localJSONObject1.put("id_view_AdDownloadView", localObject);
        }
        if (!TextUtils.isEmpty(((AdvertisementInfo)paramBaseArticleInfo).mImaxImg))
        {
          localObject = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
          ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = new ColorDrawable(-16777216);
          localObject = URLDrawable.getDrawable(((AdvertisementInfo)paramBaseArticleInfo).mImaxImg, (URLDrawable.URLDrawableOptions)localObject);
          if (localObject != null) {
            ((URLDrawable)localObject).startDownload();
          }
        }
        if (new JSONObject(((AdvertisementInfo)paramBaseArticleInfo).mAdExtInfo).optInt("is_video_new") != 1) {}
      }
      qai.n(paramBaseArticleInfo, localJSONObject1);
      qai.g(paramBaseArticleInfo, localJSONObject1);
      twr.b(paramBaseArticleInfo, localJSONObject1);
      twr.a(paramBaseArticleInfo, localJSONObject1);
      twr.c(paramBaseArticleInfo, localJSONObject1);
      localJSONObject1.put("id_large_video_activity_wrapper", new JSONObject());
      localObject = new JSONObject();
      ((JSONObject)localObject).put("activity_img_path", "free_netflow_icon");
      localJSONObject1.put("id_large_video_activity_img", localObject);
      localJSONObject1.put("id_large_video_activity_label", new JSONObject());
      localJSONObject1.put("id_view_Ad_CompleteGudie", new JSONObject());
      localJSONObject1.put("id_video_cell_container", new JSONObject());
      localJSONObject1.put("style_ID", "ReadInjoy_ad_video_cell");
      qai.a(localJSONObject1, paramBaseArticleInfo);
      return localJSONObject1;
      localObject = null;
      break;
      label502:
      localObject = pai.a(paramBaseArticleInfo.mVideoDuration);
      break label143;
      paramInt = 0;
      break label221;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pzg
 * JD-Core Version:    0.7.0.1
 */