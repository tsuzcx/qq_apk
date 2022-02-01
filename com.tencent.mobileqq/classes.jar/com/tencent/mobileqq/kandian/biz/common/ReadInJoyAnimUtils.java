package com.tencent.mobileqq.kandian.biz.common;

import android.app.Activity;
import android.text.TextPaint;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.kandian.base.utils.ReadInJoyDisplayUtils;
import com.tencent.mobileqq.kandian.base.video.player.data.AbsReadInJoyVideoReportData;
import com.tencent.mobileqq.kandian.base.video.player.data.ReadInJoyVideoReportData;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;
import com.tencent.mobileqq.kandian.base.view.widget.RoundAngleFrameLayout;
import com.tencent.mobileqq.kandian.base.view.widget.VideoViewGroup;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyHeadImageView;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyNickNameTextView;
import com.tencent.mobileqq.kandian.biz.feeds.ReadInJoyArticleAdapter;
import com.tencent.mobileqq.kandian.biz.video.feeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.biz.video.view.ReadInJoyVideoInfoViewGroup;
import com.tencent.mobileqq.kandian.biz.video.viewholder.VideoFeedsViewHolder;
import com.tencent.mobileqq.kandian.repo.feeds.RIJBaseItemViewType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.pts.UtilsForComponent;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

public class ReadInJoyAnimUtils
{
  public static VideoPlayParam a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    VideoPlayParam localVideoPlayParam = new VideoPlayParam();
    localVideoPlayParam.jdField_c_of_type_JavaLangString = paramAbsBaseArticleInfo.mVideoVid;
    localVideoPlayParam.jdField_c_of_type_Long = paramAbsBaseArticleInfo.mArticleID;
    localVideoPlayParam.jdField_b_of_type_Int = paramAbsBaseArticleInfo.mVideoDuration;
    localVideoPlayParam.jdField_c_of_type_Int = paramAbsBaseArticleInfo.mVideoJsonWidth;
    localVideoPlayParam.jdField_d_of_type_Int = paramAbsBaseArticleInfo.mVideoJsonHeight;
    if (paramAbsBaseArticleInfo.mVideoCoverUrl == null) {
      localObject = null;
    } else {
      localObject = paramAbsBaseArticleInfo.mVideoCoverUrl.getFile();
    }
    localVideoPlayParam.jdField_b_of_type_JavaLangString = ((String)localObject);
    localVideoPlayParam.k = paramAbsBaseArticleInfo.mSubscribeID;
    localVideoPlayParam.jdField_g_of_type_Int = paramAbsBaseArticleInfo.mStrategyId;
    localVideoPlayParam.jdField_g_of_type_Long = paramAbsBaseArticleInfo.mAlgorithmID;
    Object localObject = new ReadInJoyVideoReportData();
    ((ReadInJoyVideoReportData)localObject).a = Long.valueOf(paramAbsBaseArticleInfo.mArticleID);
    ((ReadInJoyVideoReportData)localObject).jdField_b_of_type_JavaLangString = paramAbsBaseArticleInfo.innerUniqueID;
    ((ReadInJoyVideoReportData)localObject).jdField_c_of_type_JavaLangString = paramAbsBaseArticleInfo.mVideoVid;
    ((ReadInJoyVideoReportData)localObject).jdField_b_of_type_Int = paramAbsBaseArticleInfo.busiType;
    localVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData = ((AbsReadInJoyVideoReportData)localObject);
    localVideoPlayParam.jdField_d_of_type_JavaLangString = paramAbsBaseArticleInfo.thirdIcon;
    localVideoPlayParam.e = paramAbsBaseArticleInfo.thirdName;
    localVideoPlayParam.jdField_f_of_type_JavaLangString = paramAbsBaseArticleInfo.thirdAction;
    localVideoPlayParam.jdField_f_of_type_Int = paramAbsBaseArticleInfo.busiType;
    localVideoPlayParam.j = paramAbsBaseArticleInfo.innerUniqueID;
    localVideoPlayParam.jdField_b_of_type_Long = paramAbsBaseArticleInfo.mChannelID;
    return localVideoPlayParam;
  }
  
  public static void a(LinearLayout paramLinearLayout, int paramInt1, int paramInt2, Activity paramActivity, int paramInt3, int paramInt4)
  {
    paramLinearLayout.setVisibility(0);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)paramLinearLayout.getLayoutParams();
    localLayoutParams.leftMargin = paramInt3;
    localLayoutParams.topMargin = paramInt4;
    localLayoutParams.width = paramInt1;
    localLayoutParams.height = (paramInt2 + AIOUtils.b(42.0F, paramActivity.getResources()));
    paramLinearLayout.setLayoutParams(localLayoutParams);
  }
  
  public static void a(LinearLayout paramLinearLayout, AbsBaseArticleInfo paramAbsBaseArticleInfo, Activity paramActivity, ReadInJoyArticleAdapter paramReadInJoyArticleAdapter, int paramInt1, int paramInt2, int paramInt3)
  {
    VideoFeedsViewHolder localVideoFeedsViewHolder = new VideoFeedsViewHolder(paramActivity);
    localVideoFeedsViewHolder.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetRoundAngleFrameLayout = ((RoundAngleFrameLayout)paramLinearLayout.findViewById(2131380736));
    localVideoFeedsViewHolder.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView = ((KandianUrlImageView)paramLinearLayout.findViewById(2131368461));
    localVideoFeedsViewHolder.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyHeadImageView = ((ReadInJoyHeadImageView)paramLinearLayout.findViewById(2131368343));
    localVideoFeedsViewHolder.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyNickNameTextView = ((ReadInJoyNickNameTextView)paramLinearLayout.findViewById(2131376054));
    localVideoFeedsViewHolder.b = ((TextView)paramLinearLayout.findViewById(2131365996));
    localVideoFeedsViewHolder.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetVideoViewGroup = ((VideoViewGroup)paramLinearLayout.findViewById(2131380660));
    localVideoFeedsViewHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoViewReadInJoyVideoInfoViewGroup = ((ReadInJoyVideoInfoViewGroup)paramLinearLayout.findViewById(2131369723));
    a(localVideoFeedsViewHolder, paramAbsBaseArticleInfo, paramLinearLayout, paramActivity, paramReadInJoyArticleAdapter, paramInt1, paramInt2, paramInt3);
  }
  
  public static void a(KandianUrlImageView paramKandianUrlImageView, URL paramURL, boolean paramBoolean, Activity paramActivity, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    UtilsForComponent.a(paramActivity, paramKandianUrlImageView);
    if (RIJBaseItemViewType.a(paramAbsBaseArticleInfo) == 71) {
      paramURL = paramAbsBaseArticleInfo.getVideoCoverUrlWithSmartCut(false);
    }
    ReadInJoyDisplayUtils.a(paramKandianUrlImageView, paramURL, paramActivity, paramBoolean);
  }
  
  public static void a(ReadInJoyHeadImageView paramReadInJoyHeadImageView)
  {
    paramReadInJoyHeadImageView.setImageDrawable(ImageUtil.e());
  }
  
  public static void a(VideoFeedsViewHolder paramVideoFeedsViewHolder, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    VideoPlayParam localVideoPlayParam = a(paramAbsBaseArticleInfo);
    localVideoPlayParam.jdField_a_of_type_AndroidViewView = paramVideoFeedsViewHolder.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView;
    localVideoPlayParam.jdField_a_of_type_Int = paramVideoFeedsViewHolder.jdField_a_of_type_Int;
    localVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo = paramAbsBaseArticleInfo;
    paramVideoFeedsViewHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam = localVideoPlayParam;
  }
  
  public static void a(VideoFeedsViewHolder paramVideoFeedsViewHolder, AbsBaseArticleInfo paramAbsBaseArticleInfo, LinearLayout paramLinearLayout, Activity paramActivity, ReadInJoyArticleAdapter paramReadInJoyArticleAdapter, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramAbsBaseArticleInfo == null) {
      return;
    }
    a(paramVideoFeedsViewHolder, paramAbsBaseArticleInfo);
    VideoPlayParam localVideoPlayParam = paramVideoFeedsViewHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam;
    paramVideoFeedsViewHolder.b.setText(ReadInJoyDisplayUtils.a(localVideoPlayParam.jdField_b_of_type_Int));
    a(paramVideoFeedsViewHolder.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyHeadImageView);
    paramVideoFeedsViewHolder.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyHeadImageView.setTag(paramAbsBaseArticleInfo);
    paramVideoFeedsViewHolder.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyHeadImageView.setContentDescription(paramAbsBaseArticleInfo.mSubscribeName);
    Object localObject = paramAbsBaseArticleInfo.mSubscribeName;
    if (paramAbsBaseArticleInfo.mSubscribeName.length() > 18)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramAbsBaseArticleInfo.mSubscribeName.substring(0, 17));
      ((StringBuilder)localObject).append("…");
      localObject = ((StringBuilder)localObject).toString();
    }
    paramVideoFeedsViewHolder.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyNickNameTextView.setVisibility(0);
    paramVideoFeedsViewHolder.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyNickNameTextView.setText((CharSequence)localObject);
    paramVideoFeedsViewHolder.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyNickNameTextView.setContentDescription(paramAbsBaseArticleInfo.mSubscribeName);
    paramVideoFeedsViewHolder.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyNickNameTextView.getPaint().setFakeBoldText(true);
    localObject = new HashSet();
    paramVideoFeedsViewHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoViewReadInJoyVideoInfoViewGroup.setArticleInfo(paramAbsBaseArticleInfo, paramReadInJoyArticleAdapter, paramInt1, (Set)localObject);
    a(paramVideoFeedsViewHolder.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView, paramAbsBaseArticleInfo.getVideoCoverUrlWithSmartCut(false), false, paramActivity, paramAbsBaseArticleInfo);
    paramVideoFeedsViewHolder.b.setVisibility(0);
    paramVideoFeedsViewHolder.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetVideoViewGroup.setCustomSize(1.0F, ReadInJoyDisplayUtils.a(localVideoPlayParam.jdField_c_of_type_Int, localVideoPlayParam.jdField_d_of_type_Int));
    float f1 = DeviceInfoUtil.b(paramActivity);
    float f2 = ReadInJoyDisplayUtils.a(localVideoPlayParam.jdField_c_of_type_Int, localVideoPlayParam.jdField_d_of_type_Int);
    paramAbsBaseArticleInfo = paramVideoFeedsViewHolder.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetRoundAngleFrameLayout.getLayoutParams();
    paramInt1 = (int)f1;
    paramAbsBaseArticleInfo.width = paramInt1;
    int i = (int)(f2 * f1);
    paramAbsBaseArticleInfo.height = i;
    paramVideoFeedsViewHolder.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetRoundAngleFrameLayout.setLayoutParams(paramAbsBaseArticleInfo);
    a(paramLinearLayout, paramInt1, i, paramActivity, paramInt2, paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.ReadInJoyAnimUtils
 * JD-Core Version:    0.7.0.1
 */