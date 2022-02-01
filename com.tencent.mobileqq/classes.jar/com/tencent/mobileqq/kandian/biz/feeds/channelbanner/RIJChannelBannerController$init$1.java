package com.tencent.mobileqq.kandian.biz.feeds.channelbanner;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.pts.lite.PTSLiteEventTypeHandler;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ChannelBannerInfo;
import com.tencent.pts.core.PTSComposer;
import com.tencent.pts.core.lite.DefaultPTSLiteEventListener;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/kandian/biz/feeds/channelbanner/RIJChannelBannerController$init$1", "Lcom/tencent/pts/core/lite/DefaultPTSLiteEventListener;", "onScrollViewItemExposureTriggered", "", "identifier", "", "dataSet", "Ljava/util/HashMap;", "view", "Landroid/view/View;", "ptsComposer", "Lcom/tencent/pts/core/PTSComposer;", "onTapEventTriggered", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJChannelBannerController$init$1
  extends DefaultPTSLiteEventListener
{
  RIJChannelBannerController$init$1(Context paramContext) {}
  
  public void onScrollViewItemExposureTriggered(@Nullable String paramString, @Nullable HashMap<String, String> paramHashMap, @Nullable View paramView, @Nullable PTSComposer paramPTSComposer)
  {
    if (paramHashMap != null) {
      paramHashMap = (String)paramHashMap.get("avatarStatus");
    } else {
      paramHashMap = null;
    }
    paramView = RIJChannelBannerController.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsChannelbannerRIJChannelBannerController);
    if (paramView != null)
    {
      paramPTSComposer = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsChannelbannerRIJChannelBannerController;
      if (paramString == null) {
        paramString = "";
      }
      RIJChannelBannerController.b(paramPTSComposer, paramString, paramHashMap, paramView);
    }
  }
  
  public void onTapEventTriggered(@Nullable String paramString, @Nullable HashMap<String, String> paramHashMap, @Nullable View paramView, @Nullable PTSComposer paramPTSComposer)
  {
    paramView = new StringBuilder();
    paramView.append("[onTapEventTriggered], ");
    paramView.append(getLogString(paramString, paramHashMap));
    QLog.i("RIJChannelBannerController", 1, paramView.toString());
    PTSLiteEventTypeHandler.a.a(paramPTSComposer, paramHashMap);
    paramPTSComposer = null;
    if (paramHashMap != null) {
      paramView = (String)paramHashMap.get("jumpUrl");
    } else {
      paramView = null;
    }
    if (!TextUtils.isEmpty((CharSequence)paramView)) {
      ReadInJoyUtils.a(this.jdField_a_of_type_AndroidContentContext, paramView);
    }
    paramView = paramPTSComposer;
    if (paramHashMap != null) {
      paramView = (String)paramHashMap.get("avatarStatus");
    }
    int i;
    if (paramView != null) {
      i = Integer.parseInt(paramView);
    } else {
      i = 0;
    }
    if (i == 2) {
      RIJChannelBannerController.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsChannelbannerRIJChannelBannerController, paramString, 0);
    }
    paramPTSComposer = RIJChannelBannerController.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsChannelbannerRIJChannelBannerController);
    if (paramPTSComposer != null)
    {
      paramHashMap = RIJChannelBannerController.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsChannelbannerRIJChannelBannerController);
      if (paramHashMap != null)
      {
        paramHashMap = paramHashMap.getJsonData();
        if (paramHashMap != null) {}
      }
      else
      {
        paramHashMap = "";
      }
      paramPTSComposer.c(paramHashMap);
    }
    paramHashMap = RIJChannelBannerController.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsChannelbannerRIJChannelBannerController);
    if (paramHashMap != null) {
      RIJChannelBannerController.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsChannelbannerRIJChannelBannerController, paramHashMap);
    }
    paramHashMap = RIJChannelBannerController.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsChannelbannerRIJChannelBannerController);
    if (paramHashMap != null)
    {
      paramPTSComposer = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsChannelbannerRIJChannelBannerController;
      if (paramString == null) {
        paramString = "";
      }
      RIJChannelBannerController.a(paramPTSComposer, paramString, paramView, paramHashMap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.channelbanner.RIJChannelBannerController.init.1
 * JD-Core Version:    0.7.0.1
 */