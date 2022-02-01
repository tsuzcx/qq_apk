package com.tencent.mobileqq.kandian.biz.video;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.huawei.hms.common.internal.Objects;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdDownloadService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.base.utils.ApiCompatibilityUtils;
import com.tencent.mobileqq.kandian.base.utils.RIJPBFieldUtils;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.utils.ReadInJoyDisplayUtils;
import com.tencent.mobileqq.kandian.base.utils.api.IRIJDisplayStyleManager;
import com.tencent.mobileqq.kandian.base.utils.api.IReadInJoyTimeUtils;
import com.tencent.mobileqq.kandian.base.video.player.data.AbsReadInJoyVideoReportData;
import com.tencent.mobileqq.kandian.base.video.player.data.ReadInJoyVideoReportData;
import com.tencent.mobileqq.kandian.base.view.widget.KanDianUrlRoundCornerImageView;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;
import com.tencent.mobileqq.kandian.base.view.widget.RoundAngleFrameLayout;
import com.tencent.mobileqq.kandian.base.view.widget.VideoViewGroup;
import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataManager;
import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataManager.Builder;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyHeadImageView;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyNickNameTextView;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.framework.handlers.VideoHandler;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsHelper;
import com.tencent.mobileqq.kandian.biz.pts.util.ReadInjoyFeedsUtils;
import com.tencent.mobileqq.kandian.biz.video.feeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.biz.video.view.ReadInJoyVideoInfoViewGroup;
import com.tencent.mobileqq.kandian.biz.video.viewholder.BigImgVideoColumnItemViewHolder;
import com.tencent.mobileqq.kandian.biz.video.viewholder.BigImgVideoItemViewHolder;
import com.tencent.mobileqq.kandian.biz.video.viewholder.VideoColumnItemViewHolder;
import com.tencent.mobileqq.kandian.biz.video.viewholder.VideoFeedsTwoItemViewHolder;
import com.tencent.mobileqq.kandian.biz.video.viewholder.VideoFeedsViewHolder;
import com.tencent.mobileqq.kandian.biz.video.viewholder.WeishiGridTwoItemViewHolder;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.report.dt.RIJDtParamBuilder;
import com.tencent.mobileqq.kandian.glue.video.report.VideoR5;
import com.tencent.mobileqq.kandian.glue.video.report.VideoR5.Builder;
import com.tencent.mobileqq.kandian.repo.aladdin.RIJKanDianFeedsCardStyleAladdinConfig;
import com.tencent.mobileqq.kandian.repo.aladdin.sp.RIJKingCardConfigSp;
import com.tencent.mobileqq.kandian.repo.comment.FamilyCommentInfo;
import com.tencent.mobileqq.kandian.repo.feeds.RIJBaseItemViewType;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.video.entity.VideoColumnInfo;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vip.CUKingCardUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.articlesummary.articlesummary.PartnerAccountInfo;

public class RIJConfigVideoItem
{
  public static VideoPlayParam a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return a(paramAbsBaseArticleInfo, false);
  }
  
  public static VideoPlayParam a(AbsBaseArticleInfo paramAbsBaseArticleInfo, boolean paramBoolean)
  {
    VideoPlayParam localVideoPlayParam = new VideoPlayParam();
    localVideoPlayParam.jdField_c_of_type_JavaLangString = paramAbsBaseArticleInfo.getVideoVid();
    localVideoPlayParam.jdField_c_of_type_Long = paramAbsBaseArticleInfo.mArticleID;
    localVideoPlayParam.jdField_b_of_type_Int = paramAbsBaseArticleInfo.getVideoDuration();
    localVideoPlayParam.jdField_c_of_type_Int = paramAbsBaseArticleInfo.getVideoWidth();
    localVideoPlayParam.jdField_d_of_type_Int = paramAbsBaseArticleInfo.getVideoHeight();
    localVideoPlayParam.jdField_a_of_type_Long = paramAbsBaseArticleInfo.mXGFileSize;
    localVideoPlayParam.jdField_a_of_type_JavaLangString = paramAbsBaseArticleInfo.mTitle;
    int i = 0;
    if (paramAbsBaseArticleInfo.getVideoCoverUrlWithSmartCut(false) == null) {
      localObject = null;
    } else {
      localObject = paramAbsBaseArticleInfo.getVideoCoverUrlWithSmartCut(false).getPath();
    }
    localVideoPlayParam.jdField_b_of_type_JavaLangString = ((String)localObject);
    localVideoPlayParam.k = paramAbsBaseArticleInfo.getSubscribeUin();
    localVideoPlayParam.jdField_g_of_type_Int = paramAbsBaseArticleInfo.mStrategyId;
    localVideoPlayParam.jdField_g_of_type_Long = paramAbsBaseArticleInfo.mAlgorithmID;
    Object localObject = new ReadInJoyVideoReportData();
    ((ReadInJoyVideoReportData)localObject).a = Long.valueOf(paramAbsBaseArticleInfo.mArticleID);
    ((ReadInJoyVideoReportData)localObject).jdField_b_of_type_JavaLangString = paramAbsBaseArticleInfo.innerUniqueID;
    ((ReadInJoyVideoReportData)localObject).jdField_c_of_type_JavaLangString = paramAbsBaseArticleInfo.getVideoVid();
    ((ReadInJoyVideoReportData)localObject).jdField_b_of_type_Int = paramAbsBaseArticleInfo.busiType;
    ((ReadInJoyVideoReportData)localObject).l = paramAbsBaseArticleInfo.getVideoWidth();
    ((ReadInJoyVideoReportData)localObject).m = paramAbsBaseArticleInfo.getVideoHeight();
    ((ReadInJoyVideoReportData)localObject).jdField_s_of_type_Long = paramAbsBaseArticleInfo.getVideoDuration();
    ((ReadInJoyVideoReportData)localObject).q = 0;
    ((ReadInJoyVideoReportData)localObject).r = 0;
    ((ReadInJoyVideoReportData)localObject).jdField_s_of_type_Int = 0;
    ((ReadInJoyVideoReportData)localObject).f = false;
    ((ReadInJoyVideoReportData)localObject).jdField_g_of_type_Boolean = false;
    ((ReadInJoyVideoReportData)localObject).h = false;
    ((ReadInJoyVideoReportData)localObject).jdField_g_of_type_JavaLangString = "";
    localVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData = ((AbsReadInJoyVideoReportData)localObject);
    localVideoPlayParam.jdField_d_of_type_JavaLangString = paramAbsBaseArticleInfo.thirdIcon;
    localVideoPlayParam.e = paramAbsBaseArticleInfo.thirdName;
    localVideoPlayParam.jdField_f_of_type_JavaLangString = paramAbsBaseArticleInfo.thirdAction;
    localVideoPlayParam.jdField_f_of_type_Int = paramAbsBaseArticleInfo.busiType;
    localVideoPlayParam.j = paramAbsBaseArticleInfo.getInnerUniqueID();
    localVideoPlayParam.jdField_b_of_type_Long = paramAbsBaseArticleInfo.mChannelID;
    localVideoPlayParam.jdField_g_of_type_JavaLangString = paramAbsBaseArticleInfo.mThirdVideoURL;
    localVideoPlayParam.jdField_f_of_type_Long = paramAbsBaseArticleInfo.mThirdVideoURLExpireTime;
    localVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo = paramAbsBaseArticleInfo;
    if (paramBoolean) {
      i = 3;
    }
    localVideoPlayParam.m = i;
    if (RIJBaseItemViewType.a(paramAbsBaseArticleInfo) == 4) {
      localVideoPlayParam.jdField_c_of_type_Boolean = true;
    }
    if ((paramAbsBaseArticleInfo.mChannelID == 56L) && (RIJKanDianFeedsCardStyleAladdinConfig.a()))
    {
      i = DisplayUtil.a(BaseApplicationImpl.getApplication().getApplicationContext(), 8.0F);
      localVideoPlayParam.o = i;
      localVideoPlayParam.p = i;
      localVideoPlayParam.q = i;
      localVideoPlayParam.r = i;
    }
    return localVideoPlayParam;
  }
  
  public static void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramView.getParent() instanceof View)) {
      a(paramView, paramInt1, paramInt2, paramInt3, paramInt4, (View)paramView.getParent());
    }
  }
  
  public static void a(View paramView1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView2)
  {
    paramView2.post(new RIJConfigVideoItem.7(paramView1, paramInt1, paramInt2, paramInt3, paramInt4, paramView2));
  }
  
  private static void a(View paramView1, View paramView2, Context paramContext)
  {
    a(paramView1, true, paramContext);
    a(paramView2, false, paramContext);
  }
  
  private static void a(View paramView, boolean paramBoolean, Context paramContext)
  {
    paramView.getPaddingLeft();
    int k = paramView.getPaddingTop();
    paramView.getPaddingRight();
    int m = paramView.getPaddingBottom();
    int i = ((IRIJDisplayStyleManager)QRoute.api(IRIJDisplayStyleManager.class)).getItemMiddleStyle(paramContext, RIJKanDianFeedsCardStyleAladdinConfig.a());
    int j;
    if (paramBoolean)
    {
      j = ((IRIJDisplayStyleManager)QRoute.api(IRIJDisplayStyleManager.class)).getItemPaddingNewStyle(paramContext, RIJKanDianFeedsCardStyleAladdinConfig.a());
      i /= 2;
    }
    else
    {
      j = i / 2;
      i = ((IRIJDisplayStyleManager)QRoute.api(IRIJDisplayStyleManager.class)).getItemPaddingNewStyle(paramContext, RIJKanDianFeedsCardStyleAladdinConfig.a());
    }
    paramView.setPadding(j, k, i, m);
  }
  
  private static void a(KandianUrlImageView paramKandianUrlImageView, ImageView paramImageView, AbsBaseArticleInfo paramAbsBaseArticleInfo, boolean paramBoolean, Context paramContext)
  {
    boolean bool;
    if ((paramAbsBaseArticleInfo.isUseGif) && (NetworkUtil.isWifiConnected(paramContext))) {
      bool = true;
    } else {
      bool = false;
    }
    paramAbsBaseArticleInfo.isShowGif = bool;
    URL localURL = paramAbsBaseArticleInfo.getVideoCoverUrlWithSmartCut(true);
    if (paramAbsBaseArticleInfo.isShowGif)
    {
      paramImageView.setVisibility(0);
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mPlayGifImage = true;
      localURLDrawableOptions.mLoadingDrawable = new ColorDrawable(0);
      paramImageView.setImageDrawable(URLDrawable.getDrawable(paramAbsBaseArticleInfo.gifCoverUrl, localURLDrawableOptions));
    }
    else
    {
      paramImageView.setVisibility(8);
    }
    a(paramKandianUrlImageView, localURL, paramBoolean, paramContext);
  }
  
  private static void a(KandianUrlImageView paramKandianUrlImageView, URL paramURL, int paramInt1, int paramInt2, Context paramContext)
  {
    if (paramKandianUrlImageView != null)
    {
      if (paramInt2 <= 0) {
        return;
      }
      double d1 = paramInt1;
      double d2 = paramInt2;
      Double.isNaN(d1);
      Double.isNaN(d2);
      d1 /= d2;
      ViewGroup.LayoutParams localLayoutParams = paramKandianUrlImageView.getLayoutParams();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("configImage | whRate ");
      localStringBuilder.append(d1);
      localStringBuilder.append(", origin width ");
      localStringBuilder.append(localLayoutParams.width);
      localStringBuilder.append(" ,origin height ");
      localStringBuilder.append(localLayoutParams.height);
      QLog.d("ReadInJoyBaseAdapter", 2, localStringBuilder.toString());
      localLayoutParams.height = Utils.dp2px(18.0D);
      d2 = localLayoutParams.height;
      Double.isNaN(d2);
      localLayoutParams.width = ((int)(d2 * d1));
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("configImage | whRate ");
      localStringBuilder.append(d1);
      localStringBuilder.append(", width ");
      localStringBuilder.append(localLayoutParams.width);
      localStringBuilder.append(" , height ");
      localStringBuilder.append(localLayoutParams.height);
      QLog.d("ReadInJoyBaseAdapter", 2, localStringBuilder.toString());
      paramKandianUrlImageView.setLayoutParams(localLayoutParams);
      a(paramKandianUrlImageView, paramURL, false, paramContext);
    }
  }
  
  private static void a(KandianUrlImageView paramKandianUrlImageView, URL paramURL, Context paramContext)
  {
    a(paramKandianUrlImageView, paramURL, false, paramContext);
  }
  
  private static void a(KandianUrlImageView paramKandianUrlImageView, URL paramURL, boolean paramBoolean, Context paramContext)
  {
    ReadInJoyDisplayUtils.a(paramKandianUrlImageView, paramURL, paramContext, paramBoolean);
  }
  
  private static void a(RoundAngleFrameLayout paramRoundAngleFrameLayout)
  {
    if (RIJKanDianFeedsCardStyleAladdinConfig.a())
    {
      paramRoundAngleFrameLayout.setRadius(28);
      return;
    }
    paramRoundAngleFrameLayout.setRadius(0);
  }
  
  private static void a(ReadInJoyHeadImageView paramReadInJoyHeadImageView, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions;
    if ((!RIJFeedsType.g(paramAbsBaseArticleInfo)) && ((paramAbsBaseArticleInfo.busiType != 1) || (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo(paramAbsBaseArticleInfo))))
    {
      localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = paramReadInJoyHeadImageView.getWidth();
      localURLDrawableOptions.mRequestHeight = paramReadInJoyHeadImageView.getHeight();
      localURLDrawableOptions.mLoadingDrawable = ImageUtil.e();
      localURLDrawableOptions.mFailedDrawable = ImageUtil.e();
    }
    for (;;)
    {
      try
      {
        if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo(paramAbsBaseArticleInfo))
        {
          localAdvertisementInfo = (AdvertisementInfo)paramAbsBaseArticleInfo;
          boolean bool = ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAppAdvertisementInfo(paramAbsBaseArticleInfo);
          localObject = null;
          if (!bool) {}
        }
      }
      catch (MalformedURLException paramReadInJoyHeadImageView)
      {
        AdvertisementInfo localAdvertisementInfo;
        Object localObject;
        if (!QLog.isColorLevel()) {
          break;
        }
      }
      try
      {
        paramAbsBaseArticleInfo = new JSONObject(localAdvertisementInfo.mAdExt).getString("applogo");
        if (TextUtils.isEmpty(paramAbsBaseArticleInfo)) {
          paramAbsBaseArticleInfo = localObject;
        } else {
          paramAbsBaseArticleInfo = new URL(paramAbsBaseArticleInfo);
        }
      }
      catch (JSONException paramAbsBaseArticleInfo)
      {
        continue;
      }
      paramAbsBaseArticleInfo = localObject;
      if (QLog.isColorLevel())
      {
        QLog.d("ReadInJoyBaseAdapter", 2, "cannot get avatar from app advertisement");
        paramAbsBaseArticleInfo = localObject;
        continue;
        if (TextUtils.isEmpty(localAdvertisementInfo.mAdCorporateLogo))
        {
          paramAbsBaseArticleInfo = localObject;
        }
        else
        {
          paramAbsBaseArticleInfo = new URL(localAdvertisementInfo.mAdCorporateLogo);
          continue;
          if (TextUtils.isEmpty(paramAbsBaseArticleInfo.thirdIcon))
          {
            paramAbsBaseArticleInfo = new URL("https://pub.idqqimg.com/pc/misc/files/20191114/1014c7cfd33e4333b818ceecc0885938.png");
          }
          else
          {
            paramAbsBaseArticleInfo = new URL(paramAbsBaseArticleInfo.thirdIcon);
            continue;
          }
        }
      }
      if (paramAbsBaseArticleInfo == null)
      {
        paramReadInJoyHeadImageView.setImageDrawable(ImageUtil.e());
        paramReadInJoyHeadImageView.setVisibility(0);
        return;
      }
      paramAbsBaseArticleInfo = URLDrawable.getDrawable(paramAbsBaseArticleInfo, localURLDrawableOptions);
      paramAbsBaseArticleInfo.setDecodeHandler(URLDrawableDecodeHandler.a);
      paramReadInJoyHeadImageView.setImageDrawable(paramAbsBaseArticleInfo);
      paramReadInJoyHeadImageView.setVisibility(0);
      return;
      paramAbsBaseArticleInfo = new StringBuilder();
      paramAbsBaseArticleInfo.append("configVideoItemUI() ERROR e = ");
      paramAbsBaseArticleInfo.append(paramReadInJoyHeadImageView.getMessage());
      QLog.d("ReadInJoyBaseAdapter", 2, paramAbsBaseArticleInfo.toString());
      return;
      paramReadInJoyHeadImageView.setHeadImgByUin(paramAbsBaseArticleInfo.getSubscribeUin());
    }
  }
  
  private static void a(ReadInJoyNickNameTextView paramReadInJoyNickNameTextView, AbsBaseArticleInfo paramAbsBaseArticleInfo, boolean paramBoolean)
  {
    if (RIJFeedsType.g(paramAbsBaseArticleInfo))
    {
      paramReadInJoyNickNameTextView.setNickNameByUin(paramAbsBaseArticleInfo.getSubscribeUin());
      return;
    }
    if (paramBoolean)
    {
      paramReadInJoyNickNameTextView.setText(((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).getAdvertisementInfoNickName(paramAbsBaseArticleInfo));
      return;
    }
    paramReadInJoyNickNameTextView.setText(ReadInJoyDisplayUtils.a(paramAbsBaseArticleInfo.getSubscribeName(), 18));
  }
  
  public static void a(BigImgVideoColumnItemViewHolder paramBigImgVideoColumnItemViewHolder, AbsBaseArticleInfo paramAbsBaseArticleInfo, RIJDataManager paramRIJDataManager, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener)
  {
    if (paramAbsBaseArticleInfo == null) {
      return;
    }
    if (paramAbsBaseArticleInfo.mSimpleVideoColumnInfo != null)
    {
      localObject = paramAbsBaseArticleInfo.mSimpleVideoColumnInfo;
      if (!TextUtils.isEmpty(((VideoColumnInfo)localObject).i))
      {
        paramBigImgVideoColumnItemViewHolder.jdField_f_of_type_AndroidWidgetTextView.setText(((VideoColumnInfo)localObject).i);
        paramBigImgVideoColumnItemViewHolder.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      else
      {
        paramBigImgVideoColumnItemViewHolder.jdField_f_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      if (!TextUtils.isEmpty(((VideoColumnInfo)localObject).jdField_c_of_type_JavaLangString)) {
        try
        {
          URL localURL = new URL(((VideoColumnInfo)localObject).jdField_c_of_type_JavaLangString);
          paramBigImgVideoColumnItemViewHolder.jdField_b_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setImage(localURL);
          paramBigImgVideoColumnItemViewHolder.jdField_b_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setVisibility(0);
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      } else {
        paramBigImgVideoColumnItemViewHolder.jdField_b_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setVisibility(8);
      }
      if (!TextUtils.isEmpty(((VideoColumnInfo)localObject).jdField_b_of_type_JavaLangString))
      {
        paramBigImgVideoColumnItemViewHolder.jdField_g_of_type_AndroidWidgetTextView.setText(((VideoColumnInfo)localObject).jdField_b_of_type_JavaLangString);
        paramBigImgVideoColumnItemViewHolder.jdField_g_of_type_AndroidWidgetTextView.setVisibility(0);
        if (TextUtils.isEmpty(((VideoColumnInfo)localObject).j)) {
          break label215;
        }
      }
    }
    try
    {
      int i = Color.parseColor(((VideoColumnInfo)localObject).j);
      paramBigImgVideoColumnItemViewHolder.jdField_g_of_type_AndroidWidgetTextView.setTextColor(i);
    }
    catch (Throwable localThrowable)
    {
      label190:
      String str;
      break label190;
    }
    paramBigImgVideoColumnItemViewHolder.jdField_g_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#0DC4FD"));
    break label215;
    paramBigImgVideoColumnItemViewHolder.jdField_g_of_type_AndroidWidgetTextView.setVisibility(8);
    label215:
    Object localObject = a(paramAbsBaseArticleInfo);
    ((VideoPlayParam)localObject).jdField_a_of_type_AndroidViewView = paramBigImgVideoColumnItemViewHolder.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView;
    ((VideoPlayParam)localObject).jdField_a_of_type_Int = paramBigImgVideoColumnItemViewHolder.jdField_a_of_type_Int;
    ((VideoPlayParam)localObject).jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo = paramAbsBaseArticleInfo;
    paramBigImgVideoColumnItemViewHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam = ((VideoPlayParam)localObject);
    paramBigImgVideoColumnItemViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramAbsBaseArticleInfo.mTitle);
    paramBigImgVideoColumnItemViewHolder.jdField_a_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
    paramBigImgVideoColumnItemViewHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramRIJDataManager.a().a().getResources().getColor(2131167394));
    paramBigImgVideoColumnItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    paramBigImgVideoColumnItemViewHolder.jdField_c_of_type_AndroidWidgetTextView.setText(ReadInJoyDisplayUtils.a(((VideoPlayParam)localObject).jdField_b_of_type_Int, true));
    UIUtils.a(paramBigImgVideoColumnItemViewHolder.jdField_b_of_type_AndroidWidgetImageView, 10, 10, 10, 10);
    paramBigImgVideoColumnItemViewHolder.jdField_b_of_type_AndroidWidgetImageView.setTag(paramBigImgVideoColumnItemViewHolder);
    paramBigImgVideoColumnItemViewHolder.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(paramOnClickListener);
    VideoHandler.b(paramRIJDataManager.a().a(), paramBigImgVideoColumnItemViewHolder.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView, paramBigImgVideoColumnItemViewHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam);
    a(paramBigImgVideoColumnItemViewHolder.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView, paramAbsBaseArticleInfo.getVideoCoverUrlWithSmartCut(false), false, paramRIJDataManager.a().a());
    paramBigImgVideoColumnItemViewHolder.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setOnLongClickListener(paramOnLongClickListener);
    paramBigImgVideoColumnItemViewHolder.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetVideoViewGroup.setCustomSize(1.0F, ReadInJoyDisplayUtils.a(((VideoPlayParam)localObject).jdField_c_of_type_Int, ((VideoPlayParam)localObject).jdField_d_of_type_Int));
    paramBigImgVideoColumnItemViewHolder.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetVideoViewGroup.setTag(paramBigImgVideoColumnItemViewHolder);
    if (paramRIJDataManager.a().a().b(paramRIJDataManager.a().b(), paramAbsBaseArticleInfo.mArticleID)) {
      paramBigImgVideoColumnItemViewHolder.jdField_g_of_type_AndroidViewView.setBackgroundColor(paramRIJDataManager.a().a().getResources().getColor(2131166933));
    }
    if (paramAbsBaseArticleInfo.mXGFileSize <= 0L)
    {
      paramBigImgVideoColumnItemViewHolder.jdField_d_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131712945));
    }
    else
    {
      paramOnClickListener = paramBigImgVideoColumnItemViewHolder.jdField_d_of_type_AndroidWidgetTextView;
      paramOnLongClickListener = new StringBuilder();
      paramOnLongClickListener.append(VideoFeedsHelper.b(paramAbsBaseArticleInfo.mXGFileSize));
      paramOnLongClickListener.append(HardCodeUtil.a(2131713044));
      paramOnClickListener.setText(paramOnLongClickListener.toString());
    }
    if (NetworkUtil.isWifiConnected(paramRIJDataManager.a().a()))
    {
      paramBigImgVideoColumnItemViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      paramBigImgVideoColumnItemViewHolder.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      paramBigImgVideoColumnItemViewHolder.jdField_b_of_type_AndroidViewView.setBackgroundColor(0);
      return;
    }
    paramBigImgVideoColumnItemViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    paramOnClickListener = paramRIJDataManager.a().a().getResources().getDrawable(2130843291);
    paramBigImgVideoColumnItemViewHolder.jdField_d_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(paramOnClickListener, null, null, null);
    paramBigImgVideoColumnItemViewHolder.jdField_d_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(AIOUtils.b(6.0F, paramRIJDataManager.a().a().getResources()));
    paramBigImgVideoColumnItemViewHolder.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
    if (CUKingCardUtils.a() == 1)
    {
      paramBigImgVideoColumnItemViewHolder.jdField_d_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131713060));
      paramBigImgVideoColumnItemViewHolder.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
      paramBigImgVideoColumnItemViewHolder.jdField_b_of_type_AndroidViewView.setBackgroundColor(0);
      return;
    }
    if ((RIJKingCardConfigSp.a()) && (!paramRIJDataManager.a().e()) && (paramBigImgVideoColumnItemViewHolder.jdField_a_of_type_Int == 0))
    {
      paramOnLongClickListener = RIJKingCardConfigSp.a();
      localObject = RIJKingCardConfigSp.b();
      str = RIJKingCardConfigSp.c();
      if (!TextUtils.isEmpty(paramOnLongClickListener))
      {
        paramOnClickListener = RIJQQAppInterfaceUtil.a();
        if (paramOnClickListener != null) {
          paramOnClickListener = paramOnClickListener.getCurrentAccountUin();
        } else {
          paramOnClickListener = "";
        }
        paramAbsBaseArticleInfo = new VideoR5.Builder(null, null, null, null).n(paramOnClickListener).j(paramAbsBaseArticleInfo.innerUniqueID).a().a();
        paramBigImgVideoColumnItemViewHolder.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
        paramBigImgVideoColumnItemViewHolder.jdField_e_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(AIOUtils.b(2.0F, paramRIJDataManager.a().a().getResources()));
        paramOnClickListener = paramRIJDataManager.a().a().getResources().getDrawable(2130843091);
        paramOnClickListener.setBounds(0, 0, AIOUtils.b(10.0F, paramRIJDataManager.a().a().getResources()), AIOUtils.b(10.0F, paramRIJDataManager.a().a().getResources()));
        paramBigImgVideoColumnItemViewHolder.jdField_e_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, paramOnClickListener, null);
        VideoFeedsHelper.b(paramRIJDataManager.a().a(), paramBigImgVideoColumnItemViewHolder.jdField_e_of_type_AndroidWidgetTextView, (String)localObject, str, paramOnLongClickListener, new RIJConfigVideoItem.4(paramAbsBaseArticleInfo, paramBigImgVideoColumnItemViewHolder));
        paramBigImgVideoColumnItemViewHolder.jdField_b_of_type_AndroidViewView.setBackgroundColor(1711276032);
        paramRIJDataManager.a().c(true);
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8009BE1", "0X8009BE1", 0, 0, "", "", "", paramAbsBaseArticleInfo, false);
        return;
      }
      paramBigImgVideoColumnItemViewHolder.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
      paramBigImgVideoColumnItemViewHolder.jdField_b_of_type_AndroidViewView.setBackgroundColor(0);
      if (QLog.isColorLevel()) {
        QLog.w("Q.readinjoy.video", 2, "kingcard guideUrl is empty, so ignore");
      }
    }
    else
    {
      paramBigImgVideoColumnItemViewHolder.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
      paramBigImgVideoColumnItemViewHolder.jdField_b_of_type_AndroidViewView.setBackgroundColor(0);
    }
  }
  
  public static void a(BigImgVideoItemViewHolder paramBigImgVideoItemViewHolder, AbsBaseArticleInfo paramAbsBaseArticleInfo, RIJDataManager paramRIJDataManager, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener)
  {
    if (paramAbsBaseArticleInfo == null) {
      return;
    }
    int i;
    if (!TextUtils.isEmpty(paramAbsBaseArticleInfo.mArticleSubscriptText))
    {
      paramBigImgVideoItemViewHolder.i.setText(paramAbsBaseArticleInfo.mArticleSubscriptText);
      if (TextUtils.isEmpty(paramAbsBaseArticleInfo.mArticleSubscriptColor)) {
        localObject1 = "#FF4222";
      } else {
        localObject1 = paramAbsBaseArticleInfo.mArticleSubscriptColor;
      }
      i = Color.parseColor((String)localObject1);
      paramBigImgVideoItemViewHolder.i.setTextColor(i);
      paramBigImgVideoItemViewHolder.i.setVisibility(0);
    }
    else
    {
      paramBigImgVideoItemViewHolder.i.setVisibility(8);
    }
    paramBigImgVideoItemViewHolder.jdField_g_of_type_AndroidWidgetTextView.setText(paramAbsBaseArticleInfo.mSubscribeName);
    if (paramAbsBaseArticleInfo.hasFamilyCommentIcon()) {}
    try
    {
      localObject1 = new URL(paramAbsBaseArticleInfo.familyCommentInfo.jdField_a_of_type_JavaLangString);
      if (paramAbsBaseArticleInfo.familyCommentInfo.jdField_b_of_type_Int > 0) {
        a(paramBigImgVideoItemViewHolder.jdField_b_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView, (URL)localObject1, paramAbsBaseArticleInfo.familyCommentInfo.jdField_a_of_type_Int, paramAbsBaseArticleInfo.familyCommentInfo.jdField_b_of_type_Int, paramRIJDataManager.a().a());
      }
      paramBigImgVideoItemViewHolder.jdField_b_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setVisibility(0);
      paramBigImgVideoItemViewHolder.h.setVisibility(8);
    }
    catch (MalformedURLException localMalformedURLException)
    {
      label180:
      Object localObject3;
      Object localObject2;
      break label180;
    }
    QLog.d("ReadInJoyBaseAdapter", 2, "configBigImgVideoItemUI exception");
    break label270;
    paramBigImgVideoItemViewHolder.jdField_b_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setVisibility(8);
    paramBigImgVideoItemViewHolder.h.setVisibility(0);
    QLog.d("ReadInJoyBaseAdapter", 2, "configBigImgVideoItemUI setCommentCountText");
    Object localObject1 = paramBigImgVideoItemViewHolder.h;
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(VideoFeedsHelper.d(paramAbsBaseArticleInfo.getCommentCount()));
    ((StringBuilder)localObject3).append(HardCodeUtil.a(2131712704));
    ((TextView)localObject1).setText(((StringBuilder)localObject3).toString());
    label270:
    if (!TextUtils.isEmpty(paramAbsBaseArticleInfo.vIconUrl)) {
      try
      {
        localObject1 = new URL(paramAbsBaseArticleInfo.vIconUrl);
        paramBigImgVideoItemViewHolder.jdField_c_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setImage((URL)localObject1);
        paramBigImgVideoItemViewHolder.jdField_c_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setVisibility(0);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    } else {
      paramBigImgVideoItemViewHolder.jdField_c_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setVisibility(8);
    }
    UIUtils.a(paramBigImgVideoItemViewHolder.jdField_b_of_type_AndroidWidgetImageView, 10, 10, 10, 10);
    paramBigImgVideoItemViewHolder.jdField_b_of_type_AndroidWidgetImageView.setTag(paramBigImgVideoItemViewHolder);
    paramBigImgVideoItemViewHolder.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(paramOnClickListener);
    paramOnClickListener = a(paramAbsBaseArticleInfo);
    paramOnClickListener.jdField_a_of_type_AndroidViewView = paramBigImgVideoItemViewHolder.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView;
    paramOnClickListener.jdField_a_of_type_Int = paramBigImgVideoItemViewHolder.jdField_a_of_type_Int;
    paramOnClickListener.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo = paramAbsBaseArticleInfo;
    paramOnClickListener.n = 1;
    paramBigImgVideoItemViewHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam = paramOnClickListener;
    paramBigImgVideoItemViewHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    paramBigImgVideoItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    paramBigImgVideoItemViewHolder.jdField_c_of_type_AndroidViewView.setVisibility(8);
    paramBigImgVideoItemViewHolder.jdField_f_of_type_AndroidWidgetTextView.setText(paramAbsBaseArticleInfo.mTitle);
    localObject2 = paramBigImgVideoItemViewHolder.jdField_f_of_type_AndroidWidgetTextView;
    if (ReadInJoyLogicEngine.a().a(paramAbsBaseArticleInfo.mArticleID)) {
      i = Color.parseColor("#999999");
    } else {
      i = Color.parseColor("#262626");
    }
    ((TextView)localObject2).setTextColor(i);
    paramBigImgVideoItemViewHolder.jdField_c_of_type_AndroidWidgetTextView.setText(ReadInJoyDisplayUtils.a(paramOnClickListener.jdField_b_of_type_Int, true));
    VideoHandler.b(paramRIJDataManager.a().a(), paramBigImgVideoItemViewHolder.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView, paramBigImgVideoItemViewHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam);
    a(paramBigImgVideoItemViewHolder.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView, paramAbsBaseArticleInfo.getVideoCoverUrlWithSmartCut(false), false, paramRIJDataManager.a().a());
    paramBigImgVideoItemViewHolder.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setOnLongClickListener(paramOnLongClickListener);
    paramBigImgVideoItemViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    paramBigImgVideoItemViewHolder.jdField_c_of_type_AndroidWidgetTextView.clearAnimation();
    paramBigImgVideoItemViewHolder.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetVideoViewGroup.setCustomSize(1.0F, ReadInJoyDisplayUtils.a(paramOnClickListener.jdField_c_of_type_Int, paramOnClickListener.jdField_d_of_type_Int));
    paramBigImgVideoItemViewHolder.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetVideoViewGroup.setTag(paramBigImgVideoItemViewHolder);
    if (paramRIJDataManager.a().a().b(paramRIJDataManager.a().b(), paramAbsBaseArticleInfo.mArticleID)) {
      paramBigImgVideoItemViewHolder.jdField_g_of_type_AndroidViewView.setBackgroundColor(paramRIJDataManager.a().a().getResources().getColor(2131166933));
    }
    if (paramAbsBaseArticleInfo.mXGFileSize <= 0L)
    {
      paramBigImgVideoItemViewHolder.jdField_d_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131712945));
    }
    else
    {
      paramOnClickListener = paramBigImgVideoItemViewHolder.jdField_d_of_type_AndroidWidgetTextView;
      paramOnLongClickListener = new StringBuilder();
      paramOnLongClickListener.append(VideoFeedsHelper.b(paramAbsBaseArticleInfo.mXGFileSize));
      paramOnLongClickListener.append(HardCodeUtil.a(2131713044));
      paramOnClickListener.setText(paramOnLongClickListener.toString());
    }
    if (NetworkUtil.isWifiConnected(paramRIJDataManager.a().a()))
    {
      paramBigImgVideoItemViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      paramBigImgVideoItemViewHolder.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      paramBigImgVideoItemViewHolder.jdField_b_of_type_AndroidViewView.setBackgroundColor(0);
      return;
    }
    paramBigImgVideoItemViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    paramOnClickListener = paramRIJDataManager.a().a().getResources().getDrawable(2130843291);
    paramBigImgVideoItemViewHolder.jdField_d_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(paramOnClickListener, null, null, null);
    paramBigImgVideoItemViewHolder.jdField_d_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(AIOUtils.b(6.0F, paramRIJDataManager.a().a().getResources()));
    paramBigImgVideoItemViewHolder.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
    if (CUKingCardUtils.a() == 1)
    {
      paramBigImgVideoItemViewHolder.jdField_d_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131713060));
      paramBigImgVideoItemViewHolder.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
      paramBigImgVideoItemViewHolder.jdField_b_of_type_AndroidViewView.setBackgroundColor(0);
      return;
    }
    if ((RIJKingCardConfigSp.a()) && (!paramRIJDataManager.a().e()) && (paramBigImgVideoItemViewHolder.jdField_a_of_type_Int == 0))
    {
      paramOnLongClickListener = RIJKingCardConfigSp.a();
      localObject2 = RIJKingCardConfigSp.b();
      localObject3 = RIJKingCardConfigSp.c();
      if (!TextUtils.isEmpty(paramOnLongClickListener))
      {
        paramOnClickListener = RIJQQAppInterfaceUtil.a();
        if (paramOnClickListener != null) {
          paramOnClickListener = paramOnClickListener.getCurrentAccountUin();
        } else {
          paramOnClickListener = "";
        }
        paramAbsBaseArticleInfo = new VideoR5.Builder(null, null, null, null).n(paramOnClickListener).j(paramAbsBaseArticleInfo.innerUniqueID).a().a();
        paramBigImgVideoItemViewHolder.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
        paramBigImgVideoItemViewHolder.jdField_e_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(AIOUtils.b(2.0F, paramRIJDataManager.a().a().getResources()));
        paramOnClickListener = paramRIJDataManager.a().a().getResources().getDrawable(2130843091);
        paramOnClickListener.setBounds(0, 0, AIOUtils.b(10.0F, paramRIJDataManager.a().a().getResources()), AIOUtils.b(10.0F, paramRIJDataManager.a().a().getResources()));
        paramBigImgVideoItemViewHolder.jdField_e_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, paramOnClickListener, null);
        VideoFeedsHelper.b(paramRIJDataManager.a().a(), paramBigImgVideoItemViewHolder.jdField_e_of_type_AndroidWidgetTextView, (String)localObject2, (String)localObject3, paramOnLongClickListener, new RIJConfigVideoItem.3(paramAbsBaseArticleInfo, paramBigImgVideoItemViewHolder));
        paramBigImgVideoItemViewHolder.jdField_b_of_type_AndroidViewView.setBackgroundColor(1711276032);
        paramRIJDataManager.a().c(true);
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8009BE1", "0X8009BE1", 0, 0, "", "", "", paramAbsBaseArticleInfo, false);
        return;
      }
      paramBigImgVideoItemViewHolder.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
      paramBigImgVideoItemViewHolder.jdField_b_of_type_AndroidViewView.setBackgroundColor(0);
      if (QLog.isColorLevel()) {
        QLog.w("Q.readinjoy.video", 2, "kingcard guideUrl is empty, so ignore");
      }
    }
    else
    {
      paramBigImgVideoItemViewHolder.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
      paramBigImgVideoItemViewHolder.jdField_b_of_type_AndroidViewView.setBackgroundColor(0);
    }
  }
  
  private static void a(VideoColumnItemViewHolder paramVideoColumnItemViewHolder, AbsBaseArticleInfo paramAbsBaseArticleInfo, RIJDataManager paramRIJDataManager)
  {
    paramVideoColumnItemViewHolder.jdField_a_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
    if (paramAbsBaseArticleInfo.mVideoColumnInfo != null)
    {
      VideoColumnInfo localVideoColumnInfo = paramAbsBaseArticleInfo.mVideoColumnInfo;
      if (localVideoColumnInfo.jdField_d_of_type_Int == 1)
      {
        paramAbsBaseArticleInfo = paramVideoColumnItemViewHolder.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.getLayoutParams();
        paramAbsBaseArticleInfo.height = DisplayUtil.a(paramRIJDataManager.a().a(), 90.0F);
        paramVideoColumnItemViewHolder.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setLayoutParams(paramAbsBaseArticleInfo);
      }
      else
      {
        paramAbsBaseArticleInfo = paramVideoColumnItemViewHolder.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.getLayoutParams();
        paramAbsBaseArticleInfo.height = DisplayUtil.a(paramRIJDataManager.a().a(), 80.0F);
        paramVideoColumnItemViewHolder.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setLayoutParams(paramAbsBaseArticleInfo);
      }
      try
      {
        if (!TextUtils.isEmpty(localVideoColumnInfo.jdField_d_of_type_JavaLangString)) {
          a(paramVideoColumnItemViewHolder.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView, new URL(localVideoColumnInfo.jdField_d_of_type_JavaLangString), paramRIJDataManager.a().a());
        } else {
          paramVideoColumnItemViewHolder.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setImageDrawable(new ColorDrawable(-15837762));
        }
      }
      catch (Exception paramAbsBaseArticleInfo)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyBaseAdapter", 2, "configVideoColumnItemUI cardBgUrl error: ", paramAbsBaseArticleInfo);
        }
      }
      try
      {
        if (!TextUtils.isEmpty(localVideoColumnInfo.e)) {
          paramAbsBaseArticleInfo = ReadInJoyDisplayUtils.a(localVideoColumnInfo.e);
        } else {
          paramAbsBaseArticleInfo = new ColorDrawable(-15837762);
        }
        paramVideoColumnItemViewHolder.jdField_a_of_type_AndroidViewViewGroup.setBackgroundDrawable(paramAbsBaseArticleInfo);
      }
      catch (Exception paramAbsBaseArticleInfo)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyBaseAdapter", 2, "configVideoColumnItemUI cardBgColor error: ", paramAbsBaseArticleInfo);
        }
        paramVideoColumnItemViewHolder.jdField_a_of_type_AndroidViewViewGroup.setBackgroundDrawable(new ColorDrawable(-15837762));
      }
      try
      {
        a(paramVideoColumnItemViewHolder.jdField_b_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView, new URL(localVideoColumnInfo.jdField_f_of_type_JavaLangString), paramRIJDataManager.a().a());
      }
      catch (MalformedURLException paramAbsBaseArticleInfo)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyBaseAdapter", 2, "configImage columnCardIcon error: ", paramAbsBaseArticleInfo);
        }
      }
      paramVideoColumnItemViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(localVideoColumnInfo.jdField_b_of_type_JavaLangString);
      paramAbsBaseArticleInfo = new StringBuilder();
      paramAbsBaseArticleInfo.append(((IReadInJoyTimeUtils)QRoute.api(IReadInJoyTimeUtils.class)).getRelativeDisplayForTime(localVideoColumnInfo.jdField_a_of_type_Long, true));
      paramAbsBaseArticleInfo.append(HardCodeUtil.a(2131712674));
      paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.toString();
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(ReadInJoyHelper.b(localVideoColumnInfo.jdField_b_of_type_Int));
      ((StringBuilder)localObject1).append(HardCodeUtil.a(2131712782));
      localObject1 = ((StringBuilder)localObject1).toString();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(localVideoColumnInfo.jdField_c_of_type_Int);
      ((StringBuilder)localObject2).append(HardCodeUtil.a(2131713021));
      localObject2 = ((StringBuilder)localObject2).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramAbsBaseArticleInfo);
      localStringBuilder.append(" · ");
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(" · ");
      localStringBuilder.append((String)localObject2);
      paramAbsBaseArticleInfo = localStringBuilder.toString();
      paramVideoColumnItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(paramAbsBaseArticleInfo);
      if (localVideoColumnInfo.jdField_a_of_type_Boolean) {
        paramVideoColumnItemViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      } else {
        paramVideoColumnItemViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      paramVideoColumnItemViewHolder.i.setText(localVideoColumnInfo.jdField_g_of_type_JavaLangString);
      try
      {
        paramVideoColumnItemViewHolder.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianUrlRoundCornerImageView.setCorner(DisplayUtil.a(paramRIJDataManager.a().a(), 2.0F));
        a(paramVideoColumnItemViewHolder.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianUrlRoundCornerImageView, new URL(localVideoColumnInfo.h), paramRIJDataManager.a().a());
      }
      catch (Exception paramAbsBaseArticleInfo)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyBaseAdapter", 2, "configImage appIcon error: ", paramAbsBaseArticleInfo);
        }
      }
      paramVideoColumnItemViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(paramVideoColumnItemViewHolder);
      paramVideoColumnItemViewHolder.jdField_c_of_type_AndroidWidgetTextView.setTag(paramVideoColumnItemViewHolder);
      paramVideoColumnItemViewHolder.jdField_b_of_type_AndroidViewViewGroup.setTag(paramVideoColumnItemViewHolder);
      paramVideoColumnItemViewHolder.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianUrlRoundCornerImageView.setTag(paramVideoColumnItemViewHolder);
      paramVideoColumnItemViewHolder.i.setTag(paramVideoColumnItemViewHolder);
    }
  }
  
  public static void a(VideoColumnItemViewHolder paramVideoColumnItemViewHolder, AbsBaseArticleInfo paramAbsBaseArticleInfo, RIJDataManager paramRIJDataManager, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener)
  {
    if (paramAbsBaseArticleInfo == null) {
      return;
    }
    paramVideoColumnItemViewHolder.jdField_b_of_type_AndroidWidgetImageView.setTag(paramVideoColumnItemViewHolder);
    paramVideoColumnItemViewHolder.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(paramOnClickListener);
    paramOnClickListener = a(paramAbsBaseArticleInfo);
    paramOnClickListener.jdField_a_of_type_AndroidViewView = paramVideoColumnItemViewHolder.jdField_c_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView;
    paramOnClickListener.jdField_a_of_type_Int = paramVideoColumnItemViewHolder.jdField_a_of_type_Int;
    paramOnClickListener.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo = paramAbsBaseArticleInfo;
    paramVideoColumnItemViewHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam = paramOnClickListener;
    paramVideoColumnItemViewHolder.jdField_d_of_type_AndroidWidgetTextView.setText(paramAbsBaseArticleInfo.mTitle);
    paramVideoColumnItemViewHolder.jdField_d_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
    paramVideoColumnItemViewHolder.jdField_d_of_type_AndroidWidgetTextView.setTextColor(paramRIJDataManager.a().a().getResources().getColor(2131167394));
    if (paramAbsBaseArticleInfo.mVideoPlayCount == 0)
    {
      paramVideoColumnItemViewHolder.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    else
    {
      paramVideoColumnItemViewHolder.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
      TextView localTextView = paramVideoColumnItemViewHolder.jdField_e_of_type_AndroidWidgetTextView;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(VideoFeedsHelper.c(paramAbsBaseArticleInfo.mVideoPlayCount));
      localStringBuilder.append(HardCodeUtil.a(2131713015));
      localTextView.setText(localStringBuilder.toString());
    }
    paramVideoColumnItemViewHolder.jdField_f_of_type_AndroidWidgetTextView.setText(ReadInJoyDisplayUtils.a(paramOnClickListener.jdField_b_of_type_Int, true));
    VideoHandler.b(paramRIJDataManager.a().a(), paramVideoColumnItemViewHolder.jdField_c_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView, paramVideoColumnItemViewHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam);
    a(paramVideoColumnItemViewHolder.jdField_c_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView, paramAbsBaseArticleInfo.getVideoCoverUrlWithSmartCut(false), false, paramRIJDataManager.a().a());
    paramVideoColumnItemViewHolder.jdField_c_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setOnLongClickListener(paramOnLongClickListener);
    paramVideoColumnItemViewHolder.jdField_c_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setTag(paramVideoColumnItemViewHolder);
    paramVideoColumnItemViewHolder.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
    paramVideoColumnItemViewHolder.jdField_f_of_type_AndroidWidgetTextView.clearAnimation();
    paramVideoColumnItemViewHolder.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetVideoViewGroup.setCustomSize(1.0F, ReadInJoyDisplayUtils.a(paramOnClickListener.jdField_c_of_type_Int, paramOnClickListener.jdField_d_of_type_Int));
    paramVideoColumnItemViewHolder.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetVideoViewGroup.setTag(paramVideoColumnItemViewHolder);
    if (paramRIJDataManager.a().a().b(paramRIJDataManager.a().b(), paramAbsBaseArticleInfo.mArticleID)) {
      paramVideoColumnItemViewHolder.jdField_g_of_type_AndroidViewView.setBackgroundColor(paramRIJDataManager.a().a().getResources().getColor(2131166933));
    }
    a(paramVideoColumnItemViewHolder, paramAbsBaseArticleInfo, paramRIJDataManager);
    b(paramVideoColumnItemViewHolder, paramAbsBaseArticleInfo, paramRIJDataManager);
  }
  
  public static void a(VideoFeedsTwoItemViewHolder paramVideoFeedsTwoItemViewHolder, AbsBaseArticleInfo paramAbsBaseArticleInfo, RIJDataManager paramRIJDataManager, View.OnClickListener paramOnClickListener)
  {
    paramVideoFeedsTwoItemViewHolder.jdField_g_of_type_AndroidViewView.setOnClickListener(null);
    paramVideoFeedsTwoItemViewHolder.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo = paramAbsBaseArticleInfo;
    paramVideoFeedsTwoItemViewHolder.jdField_b_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo = ((AbsBaseArticleInfo)paramAbsBaseArticleInfo.mSubArticleList.get(0));
    paramVideoFeedsTwoItemViewHolder.jdField_a_of_type_AndroidViewView.setBackgroundColor(paramRIJDataManager.a().a().getResources().getColor(2131167394));
    a(paramVideoFeedsTwoItemViewHolder.jdField_a_of_type_AndroidViewViewGroup, paramVideoFeedsTwoItemViewHolder.jdField_b_of_type_AndroidViewViewGroup, paramRIJDataManager.a().a());
    AbsBaseArticleInfo localAbsBaseArticleInfo = paramVideoFeedsTwoItemViewHolder.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
    a(localAbsBaseArticleInfo, paramVideoFeedsTwoItemViewHolder.jdField_c_of_type_AndroidWidgetTextView, paramVideoFeedsTwoItemViewHolder.jdField_b_of_type_AndroidViewView, paramVideoFeedsTwoItemViewHolder.jdField_a_of_type_AndroidWidgetTextView, paramVideoFeedsTwoItemViewHolder.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView, paramVideoFeedsTwoItemViewHolder.jdField_g_of_type_AndroidViewView, paramRIJDataManager.a().a());
    a(paramVideoFeedsTwoItemViewHolder.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetRoundAngleFrameLayout);
    paramVideoFeedsTwoItemViewHolder.jdField_c_of_type_AndroidWidgetTextView.setText(localAbsBaseArticleInfo.mTitle);
    paramVideoFeedsTwoItemViewHolder.jdField_c_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
    paramVideoFeedsTwoItemViewHolder.jdField_d_of_type_AndroidWidgetTextView.setText(VideoFeedsHelper.c(localAbsBaseArticleInfo.mVideoPlayCount));
    a(paramVideoFeedsTwoItemViewHolder.jdField_c_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView, paramVideoFeedsTwoItemViewHolder.jdField_a_of_type_AndroidWidgetImageView, localAbsBaseArticleInfo, false, paramRIJDataManager.a().a());
    paramVideoFeedsTwoItemViewHolder.jdField_c_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setTag(paramVideoFeedsTwoItemViewHolder);
    paramVideoFeedsTwoItemViewHolder.jdField_c_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setOnClickListener(paramOnClickListener);
    VideoReport.setElementExposePolicy(paramVideoFeedsTwoItemViewHolder.jdField_c_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView, ExposurePolicy.REPORT_FIRST);
    VideoReport.setElementEndExposePolicy(paramVideoFeedsTwoItemViewHolder.jdField_c_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView, EndExposurePolicy.REPORT_ALL);
    VideoReport.setElementId(paramVideoFeedsTwoItemViewHolder.jdField_c_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView, "card");
    KandianUrlImageView localKandianUrlImageView = paramVideoFeedsTwoItemViewHolder.jdField_c_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView;
    RIJDtParamBuilder localRIJDtParamBuilder = new RIJDtParamBuilder().a(Integer.valueOf(paramRIJDataManager.a().b()));
    boolean bool = TextUtils.isEmpty(localAbsBaseArticleInfo.innerUniqueID);
    String str = "null";
    if (bool) {
      paramAbsBaseArticleInfo = "null";
    } else {
      paramAbsBaseArticleInfo = localAbsBaseArticleInfo.innerUniqueID;
    }
    VideoReport.setElementParams(localKandianUrlImageView, localRIJDtParamBuilder.e(paramAbsBaseArticleInfo).a());
    VideoReport.setElementReuseIdentifier(paramVideoFeedsTwoItemViewHolder.jdField_c_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView, localAbsBaseArticleInfo.innerUniqueID);
    paramVideoFeedsTwoItemViewHolder.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setTag(localAbsBaseArticleInfo);
    VideoFeedsHelper.a(localAbsBaseArticleInfo.mVideoArticleSubsText, localAbsBaseArticleInfo.mVideoArticleSubsColor, paramVideoFeedsTwoItemViewHolder.jdField_e_of_type_AndroidWidgetTextView);
    long l;
    if ((localAbsBaseArticleInfo.isAccountShown) && (paramRIJDataManager.a().b() == 0) && (localAbsBaseArticleInfo.mPartnerAccountInfo != null))
    {
      paramVideoFeedsTwoItemViewHolder.jdField_d_of_type_AndroidViewView.setVisibility(0);
      paramVideoFeedsTwoItemViewHolder.jdField_d_of_type_AndroidViewView.setTag(localAbsBaseArticleInfo);
      paramVideoFeedsTwoItemViewHolder.jdField_d_of_type_AndroidViewView.setTag(2131376138, paramVideoFeedsTwoItemViewHolder);
      if (localAbsBaseArticleInfo.mPartnerAccountInfo.uint64_uin.has()) {
        l = localAbsBaseArticleInfo.mPartnerAccountInfo.uint64_uin.get();
      } else {
        l = 0L;
      }
      paramVideoFeedsTwoItemViewHolder.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyHeadImageView.setHeadImgByUin(l);
      paramVideoFeedsTwoItemViewHolder.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyHeadImageView.setTag(localAbsBaseArticleInfo);
      paramVideoFeedsTwoItemViewHolder.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyHeadImageView.setTag(2131376138, paramVideoFeedsTwoItemViewHolder);
      a(paramVideoFeedsTwoItemViewHolder.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyHeadImageView, 10, 10, 10, 10);
      paramAbsBaseArticleInfo = RIJPBFieldUtils.b(localAbsBaseArticleInfo.mPartnerAccountInfo.bytes_v_icon_url);
      if (!TextUtils.isEmpty(paramAbsBaseArticleInfo)) {
        try
        {
          paramAbsBaseArticleInfo = new URL(paramAbsBaseArticleInfo);
          paramVideoFeedsTwoItemViewHolder.jdField_d_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setImage(paramAbsBaseArticleInfo);
        }
        catch (Exception paramAbsBaseArticleInfo)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ReadInJoyBaseAdapter", 2, "leftSmallIconImageView setImage error: ", paramAbsBaseArticleInfo);
          }
        }
      }
      paramVideoFeedsTwoItemViewHolder.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyNickNameTextView.setNickNameByUin(l);
      paramVideoFeedsTwoItemViewHolder.jdField_d_of_type_AndroidViewView.setOnClickListener(paramOnClickListener);
      paramVideoFeedsTwoItemViewHolder.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyHeadImageView.setOnClickListener(paramOnClickListener);
    }
    else
    {
      paramVideoFeedsTwoItemViewHolder.jdField_d_of_type_AndroidViewView.setVisibility(8);
    }
    localAbsBaseArticleInfo = paramVideoFeedsTwoItemViewHolder.jdField_b_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
    localAbsBaseArticleInfo.isTwoItem = true;
    a(localAbsBaseArticleInfo, paramVideoFeedsTwoItemViewHolder.jdField_f_of_type_AndroidWidgetTextView, paramVideoFeedsTwoItemViewHolder.jdField_c_of_type_AndroidViewView, paramVideoFeedsTwoItemViewHolder.jdField_b_of_type_AndroidWidgetTextView, paramVideoFeedsTwoItemViewHolder.jdField_b_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView, paramVideoFeedsTwoItemViewHolder.jdField_g_of_type_AndroidViewView, paramRIJDataManager.a().a());
    a(paramVideoFeedsTwoItemViewHolder.jdField_b_of_type_ComTencentMobileqqKandianBaseViewWidgetRoundAngleFrameLayout);
    paramVideoFeedsTwoItemViewHolder.jdField_f_of_type_AndroidWidgetTextView.setText(localAbsBaseArticleInfo.mTitle);
    paramVideoFeedsTwoItemViewHolder.jdField_f_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
    paramVideoFeedsTwoItemViewHolder.jdField_g_of_type_AndroidWidgetTextView.setText(VideoFeedsHelper.c(localAbsBaseArticleInfo.mVideoPlayCount));
    a(paramVideoFeedsTwoItemViewHolder.jdField_e_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView, paramVideoFeedsTwoItemViewHolder.jdField_b_of_type_AndroidWidgetImageView, localAbsBaseArticleInfo, false, paramRIJDataManager.a().a());
    paramVideoFeedsTwoItemViewHolder.jdField_e_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setTag(paramVideoFeedsTwoItemViewHolder);
    paramVideoFeedsTwoItemViewHolder.jdField_e_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setOnClickListener(paramOnClickListener);
    VideoReport.setElementExposePolicy(paramVideoFeedsTwoItemViewHolder.jdField_c_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView, ExposurePolicy.REPORT_FIRST);
    VideoReport.setElementEndExposePolicy(paramVideoFeedsTwoItemViewHolder.jdField_c_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView, EndExposurePolicy.REPORT_ALL);
    VideoReport.setElementId(paramVideoFeedsTwoItemViewHolder.jdField_e_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView, "card");
    localKandianUrlImageView = paramVideoFeedsTwoItemViewHolder.jdField_e_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView;
    localRIJDtParamBuilder = new RIJDtParamBuilder().a(Integer.valueOf(paramRIJDataManager.a().b()));
    if (TextUtils.isEmpty(localAbsBaseArticleInfo.innerUniqueID)) {
      paramAbsBaseArticleInfo = str;
    } else {
      paramAbsBaseArticleInfo = localAbsBaseArticleInfo.innerUniqueID;
    }
    VideoReport.setElementParams(localKandianUrlImageView, localRIJDtParamBuilder.e(paramAbsBaseArticleInfo).a());
    VideoReport.setElementReuseIdentifier(paramVideoFeedsTwoItemViewHolder.jdField_e_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView, localAbsBaseArticleInfo.innerUniqueID);
    paramVideoFeedsTwoItemViewHolder.jdField_b_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setTag(localAbsBaseArticleInfo);
    VideoFeedsHelper.a(localAbsBaseArticleInfo.mVideoArticleSubsText, localAbsBaseArticleInfo.mVideoArticleSubsColor, paramVideoFeedsTwoItemViewHolder.h);
    if ((localAbsBaseArticleInfo.isAccountShown) && (paramRIJDataManager.a().b() == 0) && (localAbsBaseArticleInfo.mPartnerAccountInfo != null))
    {
      paramVideoFeedsTwoItemViewHolder.jdField_e_of_type_AndroidViewView.setVisibility(0);
      paramVideoFeedsTwoItemViewHolder.jdField_e_of_type_AndroidViewView.setTag(localAbsBaseArticleInfo);
      paramVideoFeedsTwoItemViewHolder.jdField_e_of_type_AndroidViewView.setTag(2131376138, paramVideoFeedsTwoItemViewHolder);
      if ((localAbsBaseArticleInfo.mPartnerAccountInfo != null) && (localAbsBaseArticleInfo.mPartnerAccountInfo.uint64_uin.has())) {
        l = localAbsBaseArticleInfo.mPartnerAccountInfo.uint64_uin.get();
      } else {
        l = 0L;
      }
      paramVideoFeedsTwoItemViewHolder.jdField_b_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyHeadImageView.setHeadImgByUin(l);
      paramVideoFeedsTwoItemViewHolder.jdField_b_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyHeadImageView.setTag(localAbsBaseArticleInfo);
      paramVideoFeedsTwoItemViewHolder.jdField_b_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyHeadImageView.setTag(2131376138, paramVideoFeedsTwoItemViewHolder);
      a(paramVideoFeedsTwoItemViewHolder.jdField_b_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyHeadImageView, 10, 10, 10, 10);
      paramAbsBaseArticleInfo = RIJPBFieldUtils.b(localAbsBaseArticleInfo.mPartnerAccountInfo.bytes_v_icon_url);
      if (!TextUtils.isEmpty(paramAbsBaseArticleInfo)) {
        try
        {
          paramAbsBaseArticleInfo = new URL(paramAbsBaseArticleInfo);
          paramVideoFeedsTwoItemViewHolder.jdField_f_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setImage(paramAbsBaseArticleInfo);
        }
        catch (Exception paramAbsBaseArticleInfo)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ReadInJoyBaseAdapter", 2, "rightSmallIconImageView setImage error: ", paramAbsBaseArticleInfo);
          }
        }
      }
      paramVideoFeedsTwoItemViewHolder.jdField_b_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyNickNameTextView.setNickNameByUin(l);
      paramVideoFeedsTwoItemViewHolder.jdField_e_of_type_AndroidViewView.setOnClickListener(paramOnClickListener);
      paramVideoFeedsTwoItemViewHolder.jdField_b_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyHeadImageView.setOnClickListener(paramOnClickListener);
      return;
    }
    paramVideoFeedsTwoItemViewHolder.jdField_e_of_type_AndroidViewView.setVisibility(8);
  }
  
  public static void a(VideoFeedsViewHolder paramVideoFeedsViewHolder, RIJDataManager paramRIJDataManager, View.OnClickListener paramOnClickListener)
  {
    paramVideoFeedsViewHolder.jdField_b_of_type_AndroidViewView.setVisibility(8);
  }
  
  public static void a(VideoFeedsViewHolder paramVideoFeedsViewHolder, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    VideoPlayParam localVideoPlayParam = a(paramAbsBaseArticleInfo);
    localVideoPlayParam.jdField_a_of_type_AndroidViewView = paramVideoFeedsViewHolder.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView;
    localVideoPlayParam.jdField_a_of_type_Int = paramVideoFeedsViewHolder.jdField_a_of_type_Int;
    localVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo = paramAbsBaseArticleInfo;
    paramVideoFeedsViewHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam = localVideoPlayParam;
  }
  
  private static void a(VideoFeedsViewHolder paramVideoFeedsViewHolder, AbsBaseArticleInfo paramAbsBaseArticleInfo, RIJDataManager paramRIJDataManager)
  {
    if (NetworkUtil.isWifiConnected(paramRIJDataManager.a().a()))
    {
      paramVideoFeedsViewHolder.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
      paramVideoFeedsViewHolder.jdField_f_of_type_AndroidWidgetTextView.setVisibility(8);
      paramVideoFeedsViewHolder.jdField_e_of_type_AndroidViewView.setVisibility(0);
      paramVideoFeedsViewHolder.jdField_d_of_type_AndroidViewView.setBackgroundColor(0);
      return;
    }
    paramVideoFeedsViewHolder.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
    Object localObject = paramRIJDataManager.a().a().getResources().getDrawable(2130843291);
    paramVideoFeedsViewHolder.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds((Drawable)localObject, null, null, null);
    paramVideoFeedsViewHolder.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(AIOUtils.b(6.0F, paramRIJDataManager.a().a().getResources()));
    paramVideoFeedsViewHolder.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
    if (CUKingCardUtils.a() == 1)
    {
      paramVideoFeedsViewHolder.jdField_f_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131712794));
      paramVideoFeedsViewHolder.jdField_g_of_type_AndroidWidgetTextView.setVisibility(8);
      paramVideoFeedsViewHolder.jdField_e_of_type_AndroidViewView.setVisibility(0);
      paramVideoFeedsViewHolder.jdField_d_of_type_AndroidViewView.setBackgroundColor(0);
      return;
    }
    if ((RIJKingCardConfigSp.a()) && (!paramRIJDataManager.a().e()) && (paramVideoFeedsViewHolder.jdField_a_of_type_Int == 0))
    {
      String str1 = RIJKingCardConfigSp.a();
      String str2 = RIJKingCardConfigSp.b();
      String str3 = RIJKingCardConfigSp.c();
      if (!TextUtils.isEmpty(str1))
      {
        localObject = RIJQQAppInterfaceUtil.a();
        if (localObject != null) {
          localObject = ((QQAppInterface)localObject).getCurrentAccountUin();
        } else {
          localObject = "";
        }
        paramAbsBaseArticleInfo = new VideoR5.Builder(null, null, null, null).n((String)localObject).j(paramAbsBaseArticleInfo.innerUniqueID).a().a();
        paramVideoFeedsViewHolder.jdField_g_of_type_AndroidWidgetTextView.setVisibility(0);
        paramVideoFeedsViewHolder.jdField_g_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(AIOUtils.b(2.0F, paramRIJDataManager.a().a().getResources()));
        localObject = paramRIJDataManager.a().a().getResources().getDrawable(2130843091);
        ((Drawable)localObject).setBounds(0, 0, AIOUtils.b(10.0F, paramRIJDataManager.a().a().getResources()), AIOUtils.b(10.0F, paramRIJDataManager.a().a().getResources()));
        paramVideoFeedsViewHolder.jdField_g_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, (Drawable)localObject, null);
        VideoFeedsHelper.b(paramRIJDataManager.a().a(), paramVideoFeedsViewHolder.jdField_g_of_type_AndroidWidgetTextView, str2, str3, str1, new RIJConfigVideoItem.1(paramAbsBaseArticleInfo, paramVideoFeedsViewHolder));
        paramVideoFeedsViewHolder.jdField_d_of_type_AndroidViewView.setBackgroundColor(1711276032);
        paramVideoFeedsViewHolder.jdField_e_of_type_AndroidViewView.setVisibility(0);
        paramRIJDataManager.a().c(true);
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8009BE1", "0X8009BE1", 0, 0, "", "", "", paramAbsBaseArticleInfo, false);
        return;
      }
      paramVideoFeedsViewHolder.jdField_g_of_type_AndroidWidgetTextView.setVisibility(8);
      paramVideoFeedsViewHolder.jdField_e_of_type_AndroidViewView.setVisibility(0);
      paramVideoFeedsViewHolder.jdField_d_of_type_AndroidViewView.setBackgroundColor(0);
      if (QLog.isColorLevel()) {
        QLog.w("Q.readinjoy.video", 2, "kingcard guideUrl is empty, so ignore");
      }
    }
    else
    {
      paramVideoFeedsViewHolder.jdField_g_of_type_AndroidWidgetTextView.setVisibility(8);
      paramVideoFeedsViewHolder.jdField_e_of_type_AndroidViewView.setVisibility(0);
      paramVideoFeedsViewHolder.jdField_d_of_type_AndroidViewView.setBackgroundColor(0);
    }
  }
  
  private static void a(VideoFeedsViewHolder paramVideoFeedsViewHolder, AbsBaseArticleInfo paramAbsBaseArticleInfo, RIJDataManager paramRIJDataManager, View.OnClickListener paramOnClickListener)
  {
    AdvertisementInfo localAdvertisementInfo = (AdvertisementInfo)paramAbsBaseArticleInfo;
    TextView localTextView = paramVideoFeedsViewHolder.h;
    int i = 0;
    localTextView.setVisibility(0);
    if (RIJKanDianFeedsCardStyleAladdinConfig.a())
    {
      ApiCompatibilityUtils.a(paramVideoFeedsViewHolder.h, null);
      paramVideoFeedsViewHolder.h.setTextColor(Color.parseColor("#777777"));
      paramVideoFeedsViewHolder.i.setTextColor(Color.parseColor("#40A0FF"));
    }
    else
    {
      ApiCompatibilityUtils.a(paramVideoFeedsViewHolder.h, ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).getAdBox(Color.parseColor("#BBBBBB"), paramRIJDataManager.a().a()));
    }
    if (!TextUtils.isEmpty(paramAbsBaseArticleInfo.mArticleSubscriptText)) {
      paramVideoFeedsViewHolder.h.setText(paramAbsBaseArticleInfo.mArticleSubscriptText);
    } else {
      paramVideoFeedsViewHolder.h.setText(paramRIJDataManager.a().a().getString(2131695166));
    }
    paramVideoFeedsViewHolder.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAppAdvertisementInfo(paramAbsBaseArticleInfo)) {}
    try
    {
      paramAbsBaseArticleInfo = new JSONObject(localAdvertisementInfo.mAdExt);
      if (PackageUtil.a(paramRIJDataManager.a().a(), paramAbsBaseArticleInfo.optString("pkg_name")))
      {
        paramVideoFeedsViewHolder.i.setText(paramRIJDataManager.a().a().getString(2131717918));
        i = 1;
      }
      else
      {
        paramVideoFeedsViewHolder.i.setText(paramRIJDataManager.a().a().getString(2131717917));
      }
    }
    catch (JSONException paramAbsBaseArticleInfo)
    {
      label250:
      break label250;
    }
    paramVideoFeedsViewHolder.i.setText(paramRIJDataManager.a().a().getString(2131717969));
    if ((!TextUtils.isEmpty(localAdvertisementInfo.mAdBtnTxt)) && (i == 0)) {
      paramVideoFeedsViewHolder.i.setText(localAdvertisementInfo.mAdBtnTxt);
    }
    if ((i == 0) && (!Objects.equal(paramVideoFeedsViewHolder.i.getText(), paramRIJDataManager.a().a().getString(2131693397))))
    {
      ((IRIJAdDownloadService)QRoute.api(IRIJAdDownloadService.class)).queryState(localAdvertisementInfo, new RIJConfigVideoItem.2(paramVideoFeedsViewHolder, paramRIJDataManager));
      break label403;
      if (!TextUtils.isEmpty(localAdvertisementInfo.mAdBtnTxt)) {
        paramVideoFeedsViewHolder.i.setText(localAdvertisementInfo.mAdBtnTxt);
      } else {
        paramVideoFeedsViewHolder.i.setText(paramRIJDataManager.a().a().getString(2131717969));
      }
    }
    try
    {
      label403:
      paramAbsBaseArticleInfo = new JSONObject(localAdvertisementInfo.mAdExtInfo);
      if (!TextUtils.isEmpty(paramAbsBaseArticleInfo.optString("AdsIconText"))) {
        paramVideoFeedsViewHolder.h.setText(paramAbsBaseArticleInfo.optString("AdsIconText"));
      }
    }
    catch (JSONException paramAbsBaseArticleInfo)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyBaseAdapter", 2, "AdsIconText  error: ", paramAbsBaseArticleInfo);
      }
    }
    paramVideoFeedsViewHolder.jdField_e_of_type_AndroidWidgetImageView.setOnClickListener(paramOnClickListener);
    paramVideoFeedsViewHolder.i.setOnClickListener(paramOnClickListener);
    paramVideoFeedsViewHolder.h.setOnClickListener(paramOnClickListener);
    paramVideoFeedsViewHolder.h.setTag(paramVideoFeedsViewHolder);
    paramVideoFeedsViewHolder.i.setTag(paramVideoFeedsViewHolder);
    paramVideoFeedsViewHolder.jdField_e_of_type_AndroidWidgetImageView.setTag(paramVideoFeedsViewHolder);
    paramVideoFeedsViewHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoViewReadInJoyVideoInfoViewGroup.setVisibility(8);
    paramVideoFeedsViewHolder.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
  }
  
  public static void a(VideoFeedsViewHolder paramVideoFeedsViewHolder, AbsBaseArticleInfo paramAbsBaseArticleInfo, RIJDataManager paramRIJDataManager, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, Set<Long> paramSet)
  {
    if (paramAbsBaseArticleInfo == null) {
      return;
    }
    a(paramVideoFeedsViewHolder, paramAbsBaseArticleInfo);
    Object localObject1 = paramVideoFeedsViewHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam;
    paramVideoFeedsViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramAbsBaseArticleInfo.mTitle);
    paramVideoFeedsViewHolder.jdField_a_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
    paramVideoFeedsViewHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramRIJDataManager.a().a().getResources().getColor(2131167394));
    Object localObject2;
    if (paramAbsBaseArticleInfo.mVideoPlayCount == 0)
    {
      paramVideoFeedsViewHolder.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    else
    {
      paramVideoFeedsViewHolder.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
      localObject2 = paramVideoFeedsViewHolder.jdField_e_of_type_AndroidWidgetTextView;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(VideoFeedsHelper.c(paramAbsBaseArticleInfo.mVideoPlayCount));
      localStringBuilder.append(HardCodeUtil.a(2131712858));
      ((TextView)localObject2).setText(localStringBuilder.toString());
    }
    paramVideoFeedsViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(ReadInJoyDisplayUtils.a(((VideoPlayParam)localObject1).jdField_b_of_type_Int, true));
    a(paramVideoFeedsViewHolder.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyNickNameTextView, paramAbsBaseArticleInfo, ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo(paramAbsBaseArticleInfo));
    a(paramVideoFeedsViewHolder.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyHeadImageView, paramAbsBaseArticleInfo);
    paramVideoFeedsViewHolder.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyHeadImageView.setContentDescription(paramAbsBaseArticleInfo.getSubscribeName());
    paramVideoFeedsViewHolder.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyNickNameTextView.setVisibility(0);
    paramVideoFeedsViewHolder.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyNickNameTextView.setContentDescription(paramAbsBaseArticleInfo.getSubscribeName());
    paramVideoFeedsViewHolder.jdField_a_of_type_AndroidViewViewGroup.setTag(paramAbsBaseArticleInfo);
    paramVideoFeedsViewHolder.jdField_a_of_type_AndroidViewViewGroup.setTag(2131376138, paramVideoFeedsViewHolder);
    paramVideoFeedsViewHolder.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(paramOnClickListener);
    if (!TextUtils.isEmpty(paramAbsBaseArticleInfo.vIconUrl)) {
      try
      {
        localObject2 = new URL(paramAbsBaseArticleInfo.vIconUrl);
        paramVideoFeedsViewHolder.jdField_b_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setImage((URL)localObject2);
        paramVideoFeedsViewHolder.jdField_b_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setVisibility(0);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    } else {
      paramVideoFeedsViewHolder.jdField_b_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setVisibility(8);
    }
    if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo(paramAbsBaseArticleInfo))
    {
      a(paramVideoFeedsViewHolder, paramAbsBaseArticleInfo, paramRIJDataManager, paramOnClickListener);
    }
    else
    {
      paramVideoFeedsViewHolder.h.setVisibility(8);
      paramVideoFeedsViewHolder.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      paramVideoFeedsViewHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoViewReadInJoyVideoInfoViewGroup.setVisibility(0);
      paramVideoFeedsViewHolder.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      paramVideoFeedsViewHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoViewReadInJoyVideoInfoViewGroup.setArticleInfo(paramAbsBaseArticleInfo, paramRIJDataManager.a().a(), paramRIJDataManager.a().b(), paramSet);
      paramVideoFeedsViewHolder.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(paramOnClickListener);
      paramVideoFeedsViewHolder.jdField_a_of_type_AndroidWidgetImageView.setTag(paramVideoFeedsViewHolder);
      paramVideoFeedsViewHolder.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(paramOnClickListener);
      paramVideoFeedsViewHolder.jdField_b_of_type_AndroidWidgetImageView.setOnLongClickListener(paramOnLongClickListener);
      paramVideoFeedsViewHolder.jdField_b_of_type_AndroidWidgetImageView.setTag(paramVideoFeedsViewHolder);
      paramVideoFeedsViewHolder.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(paramOnClickListener);
      paramVideoFeedsViewHolder.jdField_c_of_type_AndroidWidgetImageView.setTag(paramVideoFeedsViewHolder);
    }
    VideoHandler.b(paramRIJDataManager.a().a(), paramVideoFeedsViewHolder.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView, paramVideoFeedsViewHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam);
    a(paramVideoFeedsViewHolder.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView, paramAbsBaseArticleInfo.getVideoCoverUrlWithSmartCut(false), false, paramRIJDataManager.a().a());
    paramVideoFeedsViewHolder.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setOnClickListener(paramOnClickListener);
    paramVideoFeedsViewHolder.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setOnLongClickListener(paramOnLongClickListener);
    paramVideoFeedsViewHolder.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setTag(paramVideoFeedsViewHolder);
    paramVideoFeedsViewHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    paramVideoFeedsViewHolder.jdField_b_of_type_AndroidWidgetTextView.clearAnimation();
    paramVideoFeedsViewHolder.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetVideoViewGroup.setCustomSize(1.0F, ReadInJoyDisplayUtils.a(((VideoPlayParam)localObject1).jdField_c_of_type_Int, ((VideoPlayParam)localObject1).jdField_d_of_type_Int));
    paramVideoFeedsViewHolder.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetVideoViewGroup.setOnClickListener(paramOnClickListener);
    paramVideoFeedsViewHolder.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetVideoViewGroup.setTag(paramVideoFeedsViewHolder);
    if (paramRIJDataManager.a().a().b(paramRIJDataManager.a().b(), paramAbsBaseArticleInfo.mArticleID)) {
      paramVideoFeedsViewHolder.jdField_g_of_type_AndroidViewView.setBackgroundColor(paramRIJDataManager.a().a().getResources().getColor(2131166933));
    }
    ReadInjoyFeedsUtils.a(paramRIJDataManager.a().a(), paramVideoFeedsViewHolder.jdField_b_of_type_AndroidViewViewGroup, paramVideoFeedsViewHolder.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetRoundAngleFrameLayout);
    if (RIJKanDianFeedsCardStyleAladdinConfig.a())
    {
      paramVideoFeedsViewHolder.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(DisplayUtil.a(paramRIJDataManager.a().a(), 5.0F));
      paramOnLongClickListener = paramRIJDataManager.a().a().getResources().getDrawable(2130843189);
      int i = DisplayUtil.a(paramRIJDataManager.a().a(), 17.0F);
      paramOnLongClickListener.setBounds(0, 0, i, i);
      paramVideoFeedsViewHolder.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawables(paramOnLongClickListener, null, null, null);
    }
    else
    {
      paramVideoFeedsViewHolder.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(DisplayUtil.a(paramRIJDataManager.a().a(), 0.0F));
      paramOnLongClickListener = paramRIJDataManager.a().a().getResources().getDrawable(2130843188);
      paramVideoFeedsViewHolder.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(paramOnLongClickListener, null, null, null);
    }
    paramVideoFeedsViewHolder.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetRoundAngleFrameLayout.setOnClickListener(paramOnClickListener);
    paramVideoFeedsViewHolder.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetRoundAngleFrameLayout.setTag(paramVideoFeedsViewHolder);
    VideoFeedsHelper.a(paramVideoFeedsViewHolder.jdField_c_of_type_AndroidWidgetTextView, paramAbsBaseArticleInfo.getCommentCount(), HardCodeUtil.a(2131712856));
    paramVideoFeedsViewHolder.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(paramOnClickListener);
    paramVideoFeedsViewHolder.jdField_c_of_type_AndroidWidgetTextView.setTag(paramVideoFeedsViewHolder);
    paramVideoFeedsViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(paramOnClickListener);
    paramVideoFeedsViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(paramVideoFeedsViewHolder);
    if (paramAbsBaseArticleInfo.mXGFileSize <= 0L)
    {
      paramVideoFeedsViewHolder.jdField_f_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131712686));
    }
    else
    {
      paramOnLongClickListener = paramVideoFeedsViewHolder.jdField_f_of_type_AndroidWidgetTextView;
      paramSet = new StringBuilder();
      paramSet.append(VideoFeedsHelper.b(paramAbsBaseArticleInfo.mXGFileSize));
      paramSet.append(HardCodeUtil.a(2131712942));
      paramOnLongClickListener.setText(paramSet.toString());
    }
    if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo(paramAbsBaseArticleInfo))
    {
      paramOnLongClickListener = (AdvertisementInfo)paramAbsBaseArticleInfo;
      if (paramOnLongClickListener.mAdVideoFileSize >= 0L)
      {
        paramSet = paramVideoFeedsViewHolder.jdField_f_of_type_AndroidWidgetTextView;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(VideoFeedsHelper.b(paramOnLongClickListener.mAdVideoFileSize));
        ((StringBuilder)localObject1).append(HardCodeUtil.a(2131712942));
        paramSet.setText(((StringBuilder)localObject1).toString());
      }
    }
    a(paramVideoFeedsViewHolder, paramAbsBaseArticleInfo, paramRIJDataManager);
    a(paramVideoFeedsViewHolder, paramRIJDataManager, paramOnClickListener);
  }
  
  public static void a(WeishiGridTwoItemViewHolder paramWeishiGridTwoItemViewHolder, AbsBaseArticleInfo paramAbsBaseArticleInfo, RIJDataManager paramRIJDataManager, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener)
  {
    paramWeishiGridTwoItemViewHolder.jdField_g_of_type_AndroidViewView.setOnClickListener(null);
    paramWeishiGridTwoItemViewHolder.jdField_g_of_type_AndroidViewView.setOnLongClickListener(paramOnLongClickListener);
    paramWeishiGridTwoItemViewHolder.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo = paramAbsBaseArticleInfo;
    paramWeishiGridTwoItemViewHolder.jdField_b_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo = ((AbsBaseArticleInfo)paramAbsBaseArticleInfo.mSubArticleList.get(0));
    AbsBaseArticleInfo localAbsBaseArticleInfo = paramWeishiGridTwoItemViewHolder.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
    paramWeishiGridTwoItemViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(localAbsBaseArticleInfo.mTitle);
    paramWeishiGridTwoItemViewHolder.jdField_a_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
    paramWeishiGridTwoItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(VideoFeedsHelper.c(localAbsBaseArticleInfo.mVideoPlayCount));
    paramAbsBaseArticleInfo = paramRIJDataManager.a().a().getResources().getDrawable(2130843292);
    int i = ViewUtils.b(8.0F);
    paramAbsBaseArticleInfo.setBounds(0, 0, i, i);
    paramWeishiGridTwoItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawables(paramAbsBaseArticleInfo, null, null, null);
    paramWeishiGridTwoItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(ViewUtils.b(3.0F));
    VideoFeedsHelper.a(paramWeishiGridTwoItemViewHolder.jdField_c_of_type_AndroidWidgetTextView, localAbsBaseArticleInfo.getCommentCount(), HardCodeUtil.a(2131712683), "0");
    URL localURL = localAbsBaseArticleInfo.getVideoCoverUrlWithSmartCut(true);
    a(paramWeishiGridTwoItemViewHolder.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView, localURL, false, paramRIJDataManager.a().a());
    paramWeishiGridTwoItemViewHolder.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setTag(paramWeishiGridTwoItemViewHolder);
    paramWeishiGridTwoItemViewHolder.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setOnClickListener(paramOnClickListener);
    paramWeishiGridTwoItemViewHolder.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setOnLongClickListener(paramOnLongClickListener);
    VideoFeedsHelper.a(localAbsBaseArticleInfo.mVideoArticleSubsText, localAbsBaseArticleInfo.mVideoArticleSubsColor, paramWeishiGridTwoItemViewHolder.jdField_d_of_type_AndroidWidgetTextView);
    localAbsBaseArticleInfo = paramWeishiGridTwoItemViewHolder.jdField_b_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
    paramWeishiGridTwoItemViewHolder.jdField_e_of_type_AndroidWidgetTextView.setText(localAbsBaseArticleInfo.mTitle);
    paramWeishiGridTwoItemViewHolder.jdField_e_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
    paramWeishiGridTwoItemViewHolder.jdField_f_of_type_AndroidWidgetTextView.setText(VideoFeedsHelper.c(localAbsBaseArticleInfo.mVideoPlayCount));
    paramWeishiGridTwoItemViewHolder.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawables(paramAbsBaseArticleInfo, null, null, null);
    paramWeishiGridTwoItemViewHolder.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(ViewUtils.b(3.0F));
    VideoFeedsHelper.a(paramWeishiGridTwoItemViewHolder.jdField_g_of_type_AndroidWidgetTextView, localAbsBaseArticleInfo.getCommentCount(), HardCodeUtil.a(2131712672), "0");
    paramAbsBaseArticleInfo = localAbsBaseArticleInfo.getVideoCoverUrlWithSmartCut(true);
    a(paramWeishiGridTwoItemViewHolder.jdField_b_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView, paramAbsBaseArticleInfo, false, paramRIJDataManager.a().a());
    paramWeishiGridTwoItemViewHolder.jdField_b_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setTag(paramWeishiGridTwoItemViewHolder);
    paramWeishiGridTwoItemViewHolder.jdField_b_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setOnClickListener(paramOnClickListener);
    paramWeishiGridTwoItemViewHolder.jdField_b_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setOnLongClickListener(paramOnLongClickListener);
    VideoFeedsHelper.a(localAbsBaseArticleInfo.mVideoArticleSubsText, localAbsBaseArticleInfo.mVideoArticleSubsColor, paramWeishiGridTwoItemViewHolder.h);
  }
  
  private static void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, TextView paramTextView1, View paramView1, TextView paramTextView2, KandianUrlImageView paramKandianUrlImageView, View paramView2, Context paramContext)
  {
    int i = ReadInJoyHelper.d();
    boolean bool = ReadInJoyHelper.s();
    paramTextView1.setMaxLines(i);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramTextView1.getLayoutParams();
    float f;
    if (bool) {
      f = 5.0F;
    } else {
      f = 8.0F;
    }
    localLayoutParams.bottomMargin = AIOUtils.b(f, paramContext.getResources());
    localLayoutParams.alignWithParent = (bool ^ true);
    paramTextView1.setLayoutParams(localLayoutParams);
    if (paramView1 != null)
    {
      if (bool) {
        i = 0;
      } else {
        i = 8;
      }
      paramView1.setVisibility(i);
    }
    if (paramAbsBaseArticleInfo.hasFamilyCommentIcon()) {}
    try
    {
      paramTextView1 = new URL(paramAbsBaseArticleInfo.familyCommentInfo.jdField_a_of_type_JavaLangString);
      if (paramAbsBaseArticleInfo.familyCommentInfo.jdField_b_of_type_Int > 0) {
        a(paramKandianUrlImageView, paramTextView1, paramAbsBaseArticleInfo.familyCommentInfo.jdField_a_of_type_Int, paramAbsBaseArticleInfo.familyCommentInfo.jdField_b_of_type_Int, paramContext);
      }
      paramKandianUrlImageView.setOnClickListener(new RIJConfigVideoItem.6(paramContext, paramAbsBaseArticleInfo.familyCommentInfo.jdField_b_of_type_JavaLangString, paramView2));
      paramKandianUrlImageView.setVisibility(0);
      paramTextView2.setVisibility(8);
      return;
    }
    catch (MalformedURLException paramAbsBaseArticleInfo)
    {
      label187:
      break label187;
    }
    QLog.d("ReadInJoyBaseAdapter", 2, "innerConfigTwoItemVideoUI exception");
    return;
    QLog.d("ReadInJoyBaseAdapter", 2, "innerConfigTwoItemVideoUI setCommentCountText");
    paramKandianUrlImageView.setVisibility(8);
    paramTextView2.setVisibility(0);
    VideoFeedsHelper.a(paramTextView2, paramAbsBaseArticleInfo.getCommentCount(), HardCodeUtil.a(2131712866), "0");
  }
  
  private static void b(VideoColumnItemViewHolder paramVideoColumnItemViewHolder, AbsBaseArticleInfo paramAbsBaseArticleInfo, RIJDataManager paramRIJDataManager)
  {
    Object localObject2;
    if (paramAbsBaseArticleInfo.mXGFileSize <= 0L)
    {
      paramVideoColumnItemViewHolder.jdField_g_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131712940));
    }
    else
    {
      localObject1 = paramVideoColumnItemViewHolder.jdField_g_of_type_AndroidWidgetTextView;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(VideoFeedsHelper.b(paramAbsBaseArticleInfo.mXGFileSize));
      ((StringBuilder)localObject2).append(HardCodeUtil.a(2131712722));
      ((TextView)localObject1).setText(((StringBuilder)localObject2).toString());
    }
    if (NetworkUtil.isWifiConnected(paramRIJDataManager.a().a()))
    {
      paramVideoColumnItemViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      paramVideoColumnItemViewHolder.jdField_g_of_type_AndroidWidgetTextView.setVisibility(8);
      paramVideoColumnItemViewHolder.jdField_b_of_type_AndroidViewView.setVisibility(0);
      paramVideoColumnItemViewHolder.jdField_a_of_type_AndroidViewView.setBackgroundColor(0);
      return;
    }
    paramVideoColumnItemViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    Object localObject1 = paramRIJDataManager.a().a().getResources().getDrawable(2130843291);
    paramVideoColumnItemViewHolder.jdField_g_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds((Drawable)localObject1, null, null, null);
    paramVideoColumnItemViewHolder.jdField_g_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(AIOUtils.b(6.0F, paramRIJDataManager.a().a().getResources()));
    paramVideoColumnItemViewHolder.jdField_g_of_type_AndroidWidgetTextView.setVisibility(0);
    if (CUKingCardUtils.a() == 1)
    {
      paramVideoColumnItemViewHolder.jdField_g_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131712936));
      paramVideoColumnItemViewHolder.h.setVisibility(8);
      paramVideoColumnItemViewHolder.jdField_b_of_type_AndroidViewView.setVisibility(0);
      paramVideoColumnItemViewHolder.jdField_a_of_type_AndroidViewView.setBackgroundColor(0);
      return;
    }
    if ((RIJKingCardConfigSp.a()) && (!paramRIJDataManager.a().e()) && (paramVideoColumnItemViewHolder.jdField_a_of_type_Int == 0))
    {
      localObject2 = RIJKingCardConfigSp.a();
      String str1 = RIJKingCardConfigSp.b();
      String str2 = RIJKingCardConfigSp.c();
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject1 = RIJQQAppInterfaceUtil.a();
        if (localObject1 != null) {
          localObject1 = ((QQAppInterface)localObject1).getCurrentAccountUin();
        } else {
          localObject1 = "";
        }
        paramAbsBaseArticleInfo = new VideoR5.Builder(null, null, null, null).n((String)localObject1).j(paramAbsBaseArticleInfo.innerUniqueID).a().a();
        paramVideoColumnItemViewHolder.h.setVisibility(0);
        paramVideoColumnItemViewHolder.h.setCompoundDrawablePadding(AIOUtils.b(2.0F, paramRIJDataManager.a().a().getResources()));
        localObject1 = paramRIJDataManager.a().a().getResources().getDrawable(2130843091);
        ((Drawable)localObject1).setBounds(0, 0, AIOUtils.b(10.0F, paramRIJDataManager.a().a().getResources()), AIOUtils.b(10.0F, paramRIJDataManager.a().a().getResources()));
        paramVideoColumnItemViewHolder.h.setCompoundDrawables(null, null, (Drawable)localObject1, null);
        VideoFeedsHelper.b(paramRIJDataManager.a().a(), paramVideoColumnItemViewHolder.h, str1, str2, (String)localObject2, new RIJConfigVideoItem.5(paramAbsBaseArticleInfo));
        paramVideoColumnItemViewHolder.jdField_a_of_type_AndroidViewView.setBackgroundColor(1711276032);
        paramVideoColumnItemViewHolder.jdField_b_of_type_AndroidViewView.setVisibility(0);
        paramRIJDataManager.a().c(true);
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8009BE1", "0X8009BE1", 0, 0, "", "", "", paramAbsBaseArticleInfo, false);
        return;
      }
      paramVideoColumnItemViewHolder.h.setVisibility(8);
      paramVideoColumnItemViewHolder.jdField_b_of_type_AndroidViewView.setVisibility(0);
      paramVideoColumnItemViewHolder.jdField_a_of_type_AndroidViewView.setBackgroundColor(0);
      if (QLog.isColorLevel()) {
        QLog.w("Q.readinjoy.video", 2, "kingcard guideUrl is empty, so ignore");
      }
    }
    else
    {
      paramVideoColumnItemViewHolder.h.setVisibility(8);
      paramVideoColumnItemViewHolder.jdField_b_of_type_AndroidViewView.setVisibility(0);
      paramVideoColumnItemViewHolder.jdField_a_of_type_AndroidViewView.setBackgroundColor(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.RIJConfigVideoItem
 * JD-Core Version:    0.7.0.1
 */