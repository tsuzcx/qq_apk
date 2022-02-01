import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import java.net.URL;
import org.json.JSONObject;

public class pzx
{
  public static JSONObject a(BaseArticleInfo paramBaseArticleInfo)
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    if (paramBaseArticleInfo.mSinglePicture != null) {}
    for (Object localObject = paramBaseArticleInfo.mSinglePicture.getFile();; localObject = null)
    {
      localJSONObject2.put("article_large_imge_url", localObject);
      localJSONObject2.put("article_model", paramBaseArticleInfo);
      localJSONObject1.put("id_article_double_image", localJSONObject2);
      localJSONObject2 = new JSONObject();
      localJSONObject2.put("article_large_imge_url", localObject);
      localJSONObject1.put("id_article_large_imge", localJSONObject2);
      qai.a(paramBaseArticleInfo, localJSONObject1, true, "3");
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
      qai.e(paramBaseArticleInfo, localJSONObject1);
      twr.b(paramBaseArticleInfo, localJSONObject1);
      twr.a(paramBaseArticleInfo, localJSONObject1);
      twr.c(paramBaseArticleInfo, localJSONObject1);
      twr.d(paramBaseArticleInfo, localJSONObject1);
      localJSONObject1.put("style_ID", "ReadInjoy_ad_large_cell");
      qai.a(localJSONObject1, paramBaseArticleInfo);
      return localJSONObject1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pzx
 * JD-Core Version:    0.7.0.1
 */