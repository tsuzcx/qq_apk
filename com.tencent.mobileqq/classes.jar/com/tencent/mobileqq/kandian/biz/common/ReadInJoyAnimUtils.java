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
    localVideoPlayParam.d = paramAbsBaseArticleInfo.mVideoVid;
    localVideoPlayParam.j = paramAbsBaseArticleInfo.mArticleID;
    localVideoPlayParam.l = paramAbsBaseArticleInfo.mVideoDuration;
    localVideoPlayParam.n = paramAbsBaseArticleInfo.mVideoJsonWidth;
    localVideoPlayParam.o = paramAbsBaseArticleInfo.mVideoJsonHeight;
    if (paramAbsBaseArticleInfo.mVideoCoverUrl == null) {
      localObject = null;
    } else {
      localObject = paramAbsBaseArticleInfo.mVideoCoverUrl.getFile();
    }
    localVideoPlayParam.b = ((String)localObject);
    localVideoPlayParam.A = paramAbsBaseArticleInfo.mSubscribeID;
    localVideoPlayParam.C = paramAbsBaseArticleInfo.mStrategyId;
    localVideoPlayParam.B = paramAbsBaseArticleInfo.mAlgorithmID;
    Object localObject = new ReadInJoyVideoReportData();
    ((ReadInJoyVideoReportData)localObject).d = Long.valueOf(paramAbsBaseArticleInfo.mArticleID);
    ((ReadInJoyVideoReportData)localObject).e = paramAbsBaseArticleInfo.innerUniqueID;
    ((ReadInJoyVideoReportData)localObject).f = paramAbsBaseArticleInfo.mVideoVid;
    ((ReadInJoyVideoReportData)localObject).g = paramAbsBaseArticleInfo.busiType;
    localVideoPlayParam.z = ((AbsReadInJoyVideoReportData)localObject);
    localVideoPlayParam.q = paramAbsBaseArticleInfo.thirdIcon;
    localVideoPlayParam.r = paramAbsBaseArticleInfo.thirdName;
    localVideoPlayParam.s = paramAbsBaseArticleInfo.thirdAction;
    localVideoPlayParam.x = paramAbsBaseArticleInfo.busiType;
    localVideoPlayParam.y = paramAbsBaseArticleInfo.innerUniqueID;
    localVideoPlayParam.f = paramAbsBaseArticleInfo.mChannelID;
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
    localVideoFeedsViewHolder.a = ((RoundAngleFrameLayout)paramLinearLayout.findViewById(2131449704));
    localVideoFeedsViewHolder.c = ((KandianUrlImageView)paramLinearLayout.findViewById(2131435357));
    localVideoFeedsViewHolder.f = ((ReadInJoyHeadImageView)paramLinearLayout.findViewById(2131435219));
    localVideoFeedsViewHolder.e = ((ReadInJoyNickNameTextView)paramLinearLayout.findViewById(2131444254));
    localVideoFeedsViewHolder.h = ((TextView)paramLinearLayout.findViewById(2131432267));
    localVideoFeedsViewHolder.i = ((VideoViewGroup)paramLinearLayout.findViewById(2131449619));
    localVideoFeedsViewHolder.s = ((ReadInJoyVideoInfoViewGroup)paramLinearLayout.findViewById(2131436837));
    a(localVideoFeedsViewHolder, paramAbsBaseArticleInfo, paramLinearLayout, paramActivity, paramReadInJoyArticleAdapter, paramInt1, paramInt2, paramInt3);
  }
  
  public static void a(KandianUrlImageView paramKandianUrlImageView, URL paramURL, boolean paramBoolean, Activity paramActivity, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    UtilsForComponent.a(paramActivity, paramKandianUrlImageView);
    if (RIJBaseItemViewType.c(paramAbsBaseArticleInfo) == 71) {
      paramURL = paramAbsBaseArticleInfo.getVideoCoverUrlWithSmartCut(false);
    }
    ReadInJoyDisplayUtils.a(paramKandianUrlImageView, paramURL, paramActivity, paramBoolean);
  }
  
  public static void a(ReadInJoyHeadImageView paramReadInJoyHeadImageView)
  {
    paramReadInJoyHeadImageView.setImageDrawable(ImageUtil.j());
  }
  
  public static void a(VideoFeedsViewHolder paramVideoFeedsViewHolder, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    VideoPlayParam localVideoPlayParam = a(paramAbsBaseArticleInfo);
    localVideoPlayParam.h = paramVideoFeedsViewHolder.c;
    localVideoPlayParam.e = paramVideoFeedsViewHolder.P;
    localVideoPlayParam.D = paramAbsBaseArticleInfo;
    paramVideoFeedsViewHolder.t = localVideoPlayParam;
  }
  
  public static void a(VideoFeedsViewHolder paramVideoFeedsViewHolder, AbsBaseArticleInfo paramAbsBaseArticleInfo, LinearLayout paramLinearLayout, Activity paramActivity, ReadInJoyArticleAdapter paramReadInJoyArticleAdapter, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramAbsBaseArticleInfo == null) {
      return;
    }
    a(paramVideoFeedsViewHolder, paramAbsBaseArticleInfo);
    VideoPlayParam localVideoPlayParam = paramVideoFeedsViewHolder.t;
    paramVideoFeedsViewHolder.h.setText(ReadInJoyDisplayUtils.a(localVideoPlayParam.l));
    a(paramVideoFeedsViewHolder.f);
    paramVideoFeedsViewHolder.f.setTag(paramAbsBaseArticleInfo);
    paramVideoFeedsViewHolder.f.setContentDescription(paramAbsBaseArticleInfo.mSubscribeName);
    Object localObject = paramAbsBaseArticleInfo.mSubscribeName;
    if (paramAbsBaseArticleInfo.mSubscribeName.length() > 18)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramAbsBaseArticleInfo.mSubscribeName.substring(0, 17));
      ((StringBuilder)localObject).append("…");
      localObject = ((StringBuilder)localObject).toString();
    }
    paramVideoFeedsViewHolder.e.setVisibility(0);
    paramVideoFeedsViewHolder.e.setText((CharSequence)localObject);
    paramVideoFeedsViewHolder.e.setContentDescription(paramAbsBaseArticleInfo.mSubscribeName);
    paramVideoFeedsViewHolder.e.getPaint().setFakeBoldText(true);
    localObject = new HashSet();
    paramVideoFeedsViewHolder.s.setArticleInfo(paramAbsBaseArticleInfo, paramReadInJoyArticleAdapter, paramInt1, (Set)localObject);
    a(paramVideoFeedsViewHolder.c, paramAbsBaseArticleInfo.getVideoCoverUrlWithSmartCut(false), false, paramActivity, paramAbsBaseArticleInfo);
    paramVideoFeedsViewHolder.h.setVisibility(0);
    paramVideoFeedsViewHolder.i.setCustomSize(1.0F, ReadInJoyDisplayUtils.b(localVideoPlayParam.n, localVideoPlayParam.o));
    float f1 = DeviceInfoUtil.h(paramActivity);
    float f2 = ReadInJoyDisplayUtils.b(localVideoPlayParam.n, localVideoPlayParam.o);
    paramAbsBaseArticleInfo = paramVideoFeedsViewHolder.a.getLayoutParams();
    paramInt1 = (int)f1;
    paramAbsBaseArticleInfo.width = paramInt1;
    int i = (int)(f2 * f1);
    paramAbsBaseArticleInfo.height = i;
    paramVideoFeedsViewHolder.a.setLayoutParams(paramAbsBaseArticleInfo);
    a(paramLinearLayout, paramInt1, i, paramActivity, paramInt2, paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.ReadInJoyAnimUtils
 * JD-Core Version:    0.7.0.1
 */