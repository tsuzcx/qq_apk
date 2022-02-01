import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import java.net.URL;
import org.json.JSONObject;

public class qmc
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
      localJSONObject2.put("article_model", paramBaseArticleInfo);
      localJSONObject1.put("id_article_double_image", localJSONObject2);
      localJSONObject2 = new JSONObject();
      localJSONObject2.put("article_large_imge_url", localObject);
      localJSONObject1.put("id_article_large_imge", localJSONObject2);
      qmm.a(paramBaseArticleInfo, localJSONObject1, true, "3");
      if (AdvertisementInfo.isAdvertisementInfo(paramBaseArticleInfo))
      {
        qmm.f(paramBaseArticleInfo, localJSONObject1);
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
      qmm.n(paramBaseArticleInfo, localJSONObject1);
      qmm.g(paramBaseArticleInfo, localJSONObject1);
      qmm.e(paramBaseArticleInfo, localJSONObject1);
      uks.e(paramBaseArticleInfo, localJSONObject1);
      uks.a(paramBaseArticleInfo, localJSONObject1);
      uks.g(paramBaseArticleInfo, localJSONObject1);
      if (uks.a(paramBaseArticleInfo)) {
        break label280;
      }
      uks.h(paramBaseArticleInfo, localJSONObject1);
    }
    for (;;)
    {
      uks.b(paramBaseArticleInfo, localJSONObject1);
      uks.c(paramBaseArticleInfo, localJSONObject1);
      uks.d(paramBaseArticleInfo, localJSONObject1);
      qmm.a(localJSONObject1, paramBaseArticleInfo);
      return localJSONObject1;
      localObject = null;
      break;
      label280:
      uks.f(paramBaseArticleInfo, localJSONObject1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qmc
 * JD-Core Version:    0.7.0.1
 */