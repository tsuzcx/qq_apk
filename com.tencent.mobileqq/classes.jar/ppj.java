import android.app.Activity;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.pts.PTSItemViewBuilder.1;
import com.tencent.biz.pubaccount.readinjoy.pts.PTSItemViewBuilder.2;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.pts.core.itemview.PTSItemData;
import com.tencent.pts.core.itemview.PTSItemData.Builder;
import com.tencent.pts.core.itemview.PTSItemView;
import com.tencent.pts.core.itemview.PTSItemViewManager;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class ppj
{
  private PTSItemViewManager a;
  
  public ppj(Activity paramActivity)
  {
    this.a = new PTSItemViewManager(paramActivity);
  }
  
  private PTSItemData a(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {
      return null;
    }
    Object localObject = new JSONObject();
    for (;;)
    {
      try
      {
        ((JSONObject)localObject).put("articleID", paramArticleInfo.mArticleID);
        ((JSONObject)localObject).put("rowKey", paramArticleInfo.innerUniqueID);
        ((JSONObject)localObject).put("title", paramArticleInfo.mTitle);
        ((JSONObject)localObject).put("coverImageUrl", paramArticleInfo.mFirstPagePicUrl);
        ((JSONObject)localObject).put("jsonImageUrl", paramArticleInfo.mJsonPictureList);
        ((JSONObject)localObject).put("articleContentUrl", paramArticleInfo.mArticleContentUrl);
        ((JSONObject)localObject).put("subscribeName", paramArticleInfo.mSubscribeName);
        ((JSONObject)localObject).put("channelID", paramArticleInfo.mChannelID);
        ((JSONObject)localObject).put("recommendSeq", paramArticleInfo.mRecommendSeq);
        ((JSONObject)localObject).put("algorithmID", paramArticleInfo.mAlgorithmID);
        ((JSONObject)localObject).put("strategyID", paramArticleInfo.mStrategyId);
        ((JSONObject)localObject).put("feedsType", paramArticleInfo.mFeedType);
        ((JSONObject)localObject).put("proteusItemData", paramArticleInfo.proteusItemsData);
      }
      catch (JSONException localJSONException)
      {
        int i;
        String str;
        QLog.e("PTSItemViewBuilder", 1, "[getItemData], articleInfo = " + paramArticleInfo);
        continue;
      }
      try
      {
        if (!osj.a().a(paramArticleInfo.mArticleID)) {
          continue;
        }
        i = 1;
        ((JSONObject)localObject).put("hasRead", i);
      }
      catch (Exception localException)
      {
        QLog.e("PTSItemViewBuilder", 1, "[getItemData], e = " + localException);
        continue;
      }
      localObject = ((JSONObject)localObject).toString();
      str = ppk.a().a("3978");
      ppm.a().getClass();
      return new PTSItemData.Builder().withItemID(paramArticleInfo.innerUniqueID).withAppName(a(paramArticleInfo)).withAppPath(str).withJsonData((String)localObject).build();
      i = 0;
    }
  }
  
  private static String a(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {
      return "";
    }
    if (rap.c(paramArticleInfo) == 3) {
      return "triple_img_card";
    }
    return "";
  }
  
  private void a(PTSItemData paramPTSItemData)
  {
    if (paramPTSItemData == null)
    {
      QLog.i("PTSItemViewBuilder", 1, "[reportItemViewExpose], itemData is null.");
      return;
    }
    bdse.a(new PTSItemViewBuilder.1(this, paramPTSItemData));
  }
  
  private void a(PTSItemData paramPTSItemData, long paramLong)
  {
    if (paramPTSItemData == null)
    {
      QLog.i("PTSItemViewBuilder", 1, "[reportItemViewExpose], itemData is null.");
      return;
    }
    bdse.a(new PTSItemViewBuilder.2(this, paramPTSItemData, paramLong));
  }
  
  public static boolean a(long paramLong)
  {
    return paramLong == 1L;
  }
  
  public static boolean a(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null)
    {
      QLog.i("PTSItemViewBuilder", 1, "[isAbleToUseItemView], res = false, articleInfo is null.");
      return false;
    }
    if (!pqj.a.c())
    {
      QLog.i("PTSItemViewBuilder", 1, "[isAbleToUseItemView], res = false, isViewEnabled = false.");
      return false;
    }
    if (!b(paramArticleInfo))
    {
      QLog.i("PTSItemViewBuilder", 1, "[isAbleToUseItemView], res = false, isArticleAvailable = false.");
      return false;
    }
    paramArticleInfo = a(paramArticleInfo);
    if (!ppk.a().a(paramArticleInfo))
    {
      QLog.i("PTSItemViewBuilder", 1, "[isAbleToUseItemView], res = false, appName = " + paramArticleInfo + ", isAppExists = false");
      return false;
    }
    QLog.i("PTSItemViewBuilder", 1, "[isAbleToUseItemView], res = true");
    return true;
  }
  
  private static boolean b(ArticleInfo paramArticleInfo)
  {
    boolean bool2 = true;
    if (paramArticleInfo == null) {
      return false;
    }
    boolean bool3 = a(paramArticleInfo.mChannelID);
    if (rap.c(paramArticleInfo) == 3)
    {
      bool1 = true;
      if (QLog.isColorLevel()) {
        QLog.i("PTSItemViewBuilder", 1, "[isArticleAvailable], isChannelIDValid = " + bool3 + ", isViewTypeValid = " + bool1);
      }
      if ((!bool3) || (!bool1)) {
        break label83;
      }
    }
    label83:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      return bool1;
      bool1 = false;
      break;
    }
  }
  
  public PTSItemView a(View paramView, ArticleInfo paramArticleInfo)
  {
    long l1 = System.currentTimeMillis();
    paramArticleInfo = a(paramArticleInfo);
    paramView = this.a.getView(paramView, paramArticleInfo);
    long l2 = System.currentTimeMillis();
    a(paramArticleInfo);
    a(paramArticleInfo, l2 - l1);
    return paramView;
  }
  
  public void a()
  {
    this.a.destroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ppj
 * JD-Core Version:    0.7.0.1
 */