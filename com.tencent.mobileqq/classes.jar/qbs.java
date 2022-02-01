import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import java.net.URL;
import org.json.JSONObject;

public class qbs
{
  public static JSONObject a(BaseArticleInfo paramBaseArticleInfo)
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    Object localObject;
    int i;
    if (paramBaseArticleInfo.mSinglePicture != null)
    {
      localObject = paramBaseArticleInfo.mSinglePicture.getFile();
      localJSONObject2.put("article_large_imge_url", localObject);
      localJSONObject2.put("article_model", paramBaseArticleInfo);
      localJSONObject1.put("id_article_double_image", localJSONObject2);
      localJSONObject2 = new JSONObject();
      localJSONObject2.put("article_large_imge_url", localObject);
      localJSONObject1.put("id_article_large_imge", localJSONObject2);
      qcd.a(paramBaseArticleInfo, localJSONObject1, true, "3");
      if (!AdvertisementInfo.isAdvertisementInfo(paramBaseArticleInfo)) {
        break label292;
      }
      qcd.d(paramBaseArticleInfo, localJSONObject1);
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
      if (new JSONObject(((AdvertisementInfo)paramBaseArticleInfo).mAdExtInfo).optInt("is_video_new") != 1) {
        break label275;
      }
      i = 1;
    }
    for (;;)
    {
      label220:
      qcd.l(paramBaseArticleInfo, localJSONObject1);
      qcd.e(paramBaseArticleInfo, localJSONObject1);
      qcd.c(paramBaseArticleInfo, localJSONObject1);
      oqj.b(paramBaseArticleInfo, localJSONObject1);
      oqj.a(paramBaseArticleInfo, localJSONObject1);
      oqj.c(paramBaseArticleInfo, localJSONObject1);
      if (i != 0) {
        localJSONObject1.put("style_ID", "ReadInjoy_ad_large_cell_new_division");
      }
      for (;;)
      {
        qcd.a(localJSONObject1, paramBaseArticleInfo);
        return localJSONObject1;
        localObject = null;
        break;
        label275:
        i = 0;
        break label220;
        localJSONObject1.put("style_ID", "ReadInjoy_ad_large_cell");
      }
      label292:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qbs
 * JD-Core Version:    0.7.0.1
 */