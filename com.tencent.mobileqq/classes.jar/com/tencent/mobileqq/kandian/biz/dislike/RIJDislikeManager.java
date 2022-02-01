package com.tencent.mobileqq.kandian.biz.dislike;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataManager;
import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataManager.Builder;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.video.viewholder.ViewHolder;
import com.tencent.mobileqq.kandian.repo.dislike.DislikeInfo;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.widget.KandianNegativeWindow;
import com.tencent.widget.KandianNegativeWindowForAd;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class RIJDislikeManager
{
  private KandianNegativeWindow a;
  private KandianNegativeWindowForAd b;
  private ReadInJoyFeedbackPopupWindow c;
  
  public static String a(ArrayList<DislikeInfo> paramArrayList)
  {
    JSONArray localJSONArray;
    if ((paramArrayList != null) && (!paramArrayList.isEmpty()))
    {
      localJSONArray = new JSONArray();
      try
      {
        paramArrayList = paramArrayList.iterator();
        while (paramArrayList.hasNext())
        {
          DislikeInfo localDislikeInfo = (DislikeInfo)paramArrayList.next();
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("type", localDislikeInfo.d);
          localJSONObject.put("name", localDislikeInfo.c);
          localJSONObject.put("tagid", localDislikeInfo.e);
          localJSONArray.put(localJSONObject);
        }
        return localJSONArray.toString();
      }
      catch (Exception paramArrayList)
      {
        paramArrayList.printStackTrace();
      }
    }
    return "";
  }
  
  public ReadInJoyFeedbackPopupWindow a(Activity paramActivity, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    if (this.c == null) {
      this.c = new ReadInJoyFeedbackPopupWindow(paramActivity, paramReadInJoyBaseAdapter);
    }
    return this.c;
  }
  
  public KandianNegativeWindow a(Context paramContext)
  {
    if (this.a == null) {
      this.a = new KandianNegativeWindow(paramContext);
    }
    return this.a;
  }
  
  public void a()
  {
    this.a = null;
    this.b = null;
  }
  
  public void a(View paramView, ViewHolder paramViewHolder, AbsBaseArticleInfo paramAbsBaseArticleInfo, RIJDataManager paramRIJDataManager)
  {
    int i = paramViewHolder.P;
    paramViewHolder = new RIJDislikeManager.1(this, i, paramRIJDataManager, paramViewHolder, paramAbsBaseArticleInfo);
    if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo(paramAbsBaseArticleInfo))
    {
      localObject = this.a;
      if ((localObject != null) && (((KandianNegativeWindow)localObject).isShowing())) {
        this.a.dismiss();
      }
      this.b.a(i, paramRIJDataManager.a().B(), RIJFeedsType.g(paramAbsBaseArticleInfo), ((AdvertisementInfo)paramAbsBaseArticleInfo).mAdDislikeInfos);
      this.b.a(paramView, paramViewHolder);
      this.b.a(new RIJDislikeManager.2(this, paramRIJDataManager, paramAbsBaseArticleInfo));
      this.b.setOnDismissListener(new RIJDislikeManager.3(this, paramRIJDataManager));
      return;
    }
    Object localObject = this.b;
    if ((localObject != null) && (((KandianNegativeWindowForAd)localObject).isShowing())) {
      this.b.dismiss();
    }
    this.a.a(i, paramRIJDataManager.a().B(), RIJFeedsType.g(paramAbsBaseArticleInfo), paramAbsBaseArticleInfo.mDislikeInfos, paramAbsBaseArticleInfo.innerUniqueID);
    this.a.a(paramView, paramViewHolder);
    this.a.setOnDismissListener(new RIJDislikeManager.4(this, paramRIJDataManager));
  }
  
  public KandianNegativeWindowForAd b(Context paramContext)
  {
    if (this.b == null) {
      this.b = new KandianNegativeWindowForAd(paramContext);
    }
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.dislike.RIJDislikeManager
 * JD-Core Version:    0.7.0.1
 */