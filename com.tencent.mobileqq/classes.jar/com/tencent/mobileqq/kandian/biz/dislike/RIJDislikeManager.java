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
  private ReadInJoyFeedbackPopupWindow jdField_a_of_type_ComTencentMobileqqKandianBizDislikeReadInJoyFeedbackPopupWindow;
  private KandianNegativeWindow jdField_a_of_type_ComTencentWidgetKandianNegativeWindow;
  private KandianNegativeWindowForAd jdField_a_of_type_ComTencentWidgetKandianNegativeWindowForAd;
  
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
          localJSONObject.put("type", localDislikeInfo.c);
          localJSONObject.put("name", localDislikeInfo.jdField_a_of_type_JavaLangString);
          localJSONObject.put("tagid", localDislikeInfo.jdField_a_of_type_Long);
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
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizDislikeReadInJoyFeedbackPopupWindow == null) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizDislikeReadInJoyFeedbackPopupWindow = new ReadInJoyFeedbackPopupWindow(paramActivity, paramReadInJoyBaseAdapter);
    }
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizDislikeReadInJoyFeedbackPopupWindow;
  }
  
  public KandianNegativeWindow a(Context paramContext)
  {
    if (this.jdField_a_of_type_ComTencentWidgetKandianNegativeWindow == null) {
      this.jdField_a_of_type_ComTencentWidgetKandianNegativeWindow = new KandianNegativeWindow(paramContext);
    }
    return this.jdField_a_of_type_ComTencentWidgetKandianNegativeWindow;
  }
  
  public KandianNegativeWindowForAd a(Context paramContext)
  {
    if (this.jdField_a_of_type_ComTencentWidgetKandianNegativeWindowForAd == null) {
      this.jdField_a_of_type_ComTencentWidgetKandianNegativeWindowForAd = new KandianNegativeWindowForAd(paramContext);
    }
    return this.jdField_a_of_type_ComTencentWidgetKandianNegativeWindowForAd;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentWidgetKandianNegativeWindow = null;
    this.jdField_a_of_type_ComTencentWidgetKandianNegativeWindowForAd = null;
  }
  
  public void a(View paramView, ViewHolder paramViewHolder, AbsBaseArticleInfo paramAbsBaseArticleInfo, RIJDataManager paramRIJDataManager)
  {
    int i = paramViewHolder.a;
    paramViewHolder = new RIJDislikeManager.1(this, i, paramRIJDataManager, paramViewHolder, paramAbsBaseArticleInfo);
    if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo(paramAbsBaseArticleInfo))
    {
      localObject = this.jdField_a_of_type_ComTencentWidgetKandianNegativeWindow;
      if ((localObject != null) && (((KandianNegativeWindow)localObject).isShowing())) {
        this.jdField_a_of_type_ComTencentWidgetKandianNegativeWindow.dismiss();
      }
      this.jdField_a_of_type_ComTencentWidgetKandianNegativeWindowForAd.a(i, paramRIJDataManager.a().b(), RIJFeedsType.a(paramAbsBaseArticleInfo), ((AdvertisementInfo)paramAbsBaseArticleInfo).mAdDislikeInfos);
      this.jdField_a_of_type_ComTencentWidgetKandianNegativeWindowForAd.a(paramView, paramViewHolder);
      this.jdField_a_of_type_ComTencentWidgetKandianNegativeWindowForAd.a(new RIJDislikeManager.2(this, paramRIJDataManager, paramAbsBaseArticleInfo));
      this.jdField_a_of_type_ComTencentWidgetKandianNegativeWindowForAd.setOnDismissListener(new RIJDislikeManager.3(this, paramRIJDataManager));
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentWidgetKandianNegativeWindowForAd;
    if ((localObject != null) && (((KandianNegativeWindowForAd)localObject).isShowing())) {
      this.jdField_a_of_type_ComTencentWidgetKandianNegativeWindowForAd.dismiss();
    }
    this.jdField_a_of_type_ComTencentWidgetKandianNegativeWindow.a(i, paramRIJDataManager.a().b(), RIJFeedsType.a(paramAbsBaseArticleInfo), paramAbsBaseArticleInfo.mDislikeInfos, paramAbsBaseArticleInfo.innerUniqueID);
    this.jdField_a_of_type_ComTencentWidgetKandianNegativeWindow.a(paramView, paramViewHolder);
    this.jdField_a_of_type_ComTencentWidgetKandianNegativeWindow.setOnDismissListener(new RIJDislikeManager.4(this, paramRIJDataManager));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.dislike.RIJDislikeManager
 * JD-Core Version:    0.7.0.1
 */