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
import com.tencent.mobileqq.kandian.base.utils.RIJDisplayStyleManager;
import com.tencent.mobileqq.kandian.base.utils.RIJPBFieldUtils;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.utils.ReadInJoyDisplayUtils;
import com.tencent.mobileqq.kandian.base.utils.ReadInJoyTimeUtils;
import com.tencent.mobileqq.kandian.base.video.player.data.AbsReadInJoyVideoReportData;
import com.tencent.mobileqq.kandian.base.video.player.data.ReadInJoyVideoReportData;
import com.tencent.mobileqq.kandian.base.view.widget.KanDianUrlRoundCornerImageView;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;
import com.tencent.mobileqq.kandian.base.view.widget.RoundAngleFrameLayout;
import com.tencent.mobileqq.kandian.base.view.widget.VideoViewGroup;
import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataManager;
import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataManager.Builder;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
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
    localVideoPlayParam.d = paramAbsBaseArticleInfo.getVideoVid();
    localVideoPlayParam.j = paramAbsBaseArticleInfo.mArticleID;
    localVideoPlayParam.l = paramAbsBaseArticleInfo.getVideoDuration();
    localVideoPlayParam.n = paramAbsBaseArticleInfo.getVideoWidth();
    localVideoPlayParam.o = paramAbsBaseArticleInfo.getVideoHeight();
    localVideoPlayParam.c = paramAbsBaseArticleInfo.mXGFileSize;
    localVideoPlayParam.a = paramAbsBaseArticleInfo.mTitle;
    int i = 0;
    if (paramAbsBaseArticleInfo.getVideoCoverUrlWithSmartCut(false) == null) {
      localObject = null;
    } else {
      localObject = paramAbsBaseArticleInfo.getVideoCoverUrlWithSmartCut(false).getPath();
    }
    localVideoPlayParam.b = ((String)localObject);
    localVideoPlayParam.A = paramAbsBaseArticleInfo.getSubscribeUin();
    localVideoPlayParam.C = paramAbsBaseArticleInfo.mStrategyId;
    localVideoPlayParam.B = paramAbsBaseArticleInfo.mAlgorithmID;
    Object localObject = new ReadInJoyVideoReportData();
    ((ReadInJoyVideoReportData)localObject).d = Long.valueOf(paramAbsBaseArticleInfo.mArticleID);
    ((ReadInJoyVideoReportData)localObject).e = paramAbsBaseArticleInfo.innerUniqueID;
    ((ReadInJoyVideoReportData)localObject).f = paramAbsBaseArticleInfo.getVideoVid();
    ((ReadInJoyVideoReportData)localObject).g = paramAbsBaseArticleInfo.busiType;
    ((ReadInJoyVideoReportData)localObject).O = paramAbsBaseArticleInfo.getVideoWidth();
    ((ReadInJoyVideoReportData)localObject).P = paramAbsBaseArticleInfo.getVideoHeight();
    ((ReadInJoyVideoReportData)localObject).Q = paramAbsBaseArticleInfo.getVideoDuration();
    ((ReadInJoyVideoReportData)localObject).W = 0;
    ((ReadInJoyVideoReportData)localObject).X = 0;
    ((ReadInJoyVideoReportData)localObject).Y = 0;
    ((ReadInJoyVideoReportData)localObject).aa = false;
    ((ReadInJoyVideoReportData)localObject).ai = false;
    ((ReadInJoyVideoReportData)localObject).aj = false;
    ((ReadInJoyVideoReportData)localObject).ab = "";
    localVideoPlayParam.z = ((AbsReadInJoyVideoReportData)localObject);
    localVideoPlayParam.q = paramAbsBaseArticleInfo.thirdIcon;
    localVideoPlayParam.r = paramAbsBaseArticleInfo.thirdName;
    localVideoPlayParam.s = paramAbsBaseArticleInfo.thirdAction;
    localVideoPlayParam.x = paramAbsBaseArticleInfo.busiType;
    localVideoPlayParam.y = paramAbsBaseArticleInfo.getInnerUniqueID();
    localVideoPlayParam.f = paramAbsBaseArticleInfo.mChannelID;
    localVideoPlayParam.t = paramAbsBaseArticleInfo.mThirdVideoURL;
    localVideoPlayParam.u = paramAbsBaseArticleInfo.mThirdVideoURLExpireTime;
    localVideoPlayParam.D = paramAbsBaseArticleInfo;
    if (paramBoolean) {
      i = 3;
    }
    localVideoPlayParam.O = i;
    if (RIJBaseItemViewType.c(paramAbsBaseArticleInfo) == 4) {
      localVideoPlayParam.Q = true;
    }
    if ((paramAbsBaseArticleInfo.mChannelID == 56L) && (RIJKanDianFeedsCardStyleAladdinConfig.a()))
    {
      i = DisplayUtil.a(BaseApplicationImpl.getApplication().getApplicationContext(), 8.0F);
      localVideoPlayParam.R = i;
      localVideoPlayParam.S = i;
      localVideoPlayParam.T = i;
      localVideoPlayParam.U = i;
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
    int i = RIJDisplayStyleManager.INSTANCE.getItemMiddleStyle(paramContext, RIJKanDianFeedsCardStyleAladdinConfig.a());
    int j;
    if (paramBoolean)
    {
      j = RIJDisplayStyleManager.INSTANCE.getItemPaddingNewStyle(paramContext, RIJKanDianFeedsCardStyleAladdinConfig.a());
      i /= 2;
    }
    else
    {
      j = i / 2;
      i = RIJDisplayStyleManager.INSTANCE.getItemPaddingNewStyle(paramContext, RIJKanDianFeedsCardStyleAladdinConfig.a());
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
    if ((!RIJFeedsType.i(paramAbsBaseArticleInfo)) && ((paramAbsBaseArticleInfo.busiType != 1) || (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo(paramAbsBaseArticleInfo))))
    {
      localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = paramReadInJoyHeadImageView.getWidth();
      localURLDrawableOptions.mRequestHeight = paramReadInJoyHeadImageView.getHeight();
      localURLDrawableOptions.mLoadingDrawable = ImageUtil.j();
      localURLDrawableOptions.mFailedDrawable = ImageUtil.j();
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
        paramReadInJoyHeadImageView.setImageDrawable(ImageUtil.j());
        paramReadInJoyHeadImageView.setVisibility(0);
        return;
      }
      paramAbsBaseArticleInfo = URLDrawable.getDrawable(paramAbsBaseArticleInfo, localURLDrawableOptions);
      paramAbsBaseArticleInfo.setDecodeHandler(URLDrawableDecodeHandler.b);
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
    if (RIJFeedsType.i(paramAbsBaseArticleInfo))
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
      if (!TextUtils.isEmpty(((VideoColumnInfo)localObject).s))
      {
        paramBigImgVideoColumnItemViewHolder.m.setText(((VideoColumnInfo)localObject).s);
        paramBigImgVideoColumnItemViewHolder.m.setVisibility(0);
      }
      else
      {
        paramBigImgVideoColumnItemViewHolder.m.setVisibility(8);
      }
      if (!TextUtils.isEmpty(((VideoColumnInfo)localObject).d)) {
        try
        {
          URL localURL = new URL(((VideoColumnInfo)localObject).d);
          paramBigImgVideoColumnItemViewHolder.n.setImage(localURL);
          paramBigImgVideoColumnItemViewHolder.n.setVisibility(0);
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      } else {
        paramBigImgVideoColumnItemViewHolder.n.setVisibility(8);
      }
      if (!TextUtils.isEmpty(((VideoColumnInfo)localObject).c))
      {
        paramBigImgVideoColumnItemViewHolder.o.setText(((VideoColumnInfo)localObject).c);
        paramBigImgVideoColumnItemViewHolder.o.setVisibility(0);
        if (TextUtils.isEmpty(((VideoColumnInfo)localObject).t)) {
          break label215;
        }
      }
    }
    try
    {
      int i = Color.parseColor(((VideoColumnInfo)localObject).t);
      paramBigImgVideoColumnItemViewHolder.o.setTextColor(i);
    }
    catch (Throwable localThrowable)
    {
      label190:
      String str;
      break label190;
    }
    paramBigImgVideoColumnItemViewHolder.o.setTextColor(Color.parseColor("#0DC4FD"));
    break label215;
    paramBigImgVideoColumnItemViewHolder.o.setVisibility(8);
    label215:
    Object localObject = a(paramAbsBaseArticleInfo);
    ((VideoPlayParam)localObject).h = paramBigImgVideoColumnItemViewHolder.c;
    ((VideoPlayParam)localObject).e = paramBigImgVideoColumnItemViewHolder.P;
    ((VideoPlayParam)localObject).D = paramAbsBaseArticleInfo;
    paramBigImgVideoColumnItemViewHolder.q = ((VideoPlayParam)localObject);
    paramBigImgVideoColumnItemViewHolder.b.setText(paramAbsBaseArticleInfo.mTitle);
    paramBigImgVideoColumnItemViewHolder.b.getPaint().setFakeBoldText(true);
    paramBigImgVideoColumnItemViewHolder.b.setTextColor(paramRIJDataManager.a().A().getResources().getColor(2131168464));
    paramBigImgVideoColumnItemViewHolder.d.setVisibility(8);
    paramBigImgVideoColumnItemViewHolder.e.setText(ReadInJoyDisplayUtils.a(((VideoPlayParam)localObject).l, true));
    UIUtils.a(paramBigImgVideoColumnItemViewHolder.p, 10, 10, 10, 10);
    paramBigImgVideoColumnItemViewHolder.p.setTag(paramBigImgVideoColumnItemViewHolder);
    paramBigImgVideoColumnItemViewHolder.p.setOnClickListener(paramOnClickListener);
    VideoHandler.b(paramRIJDataManager.a().A(), paramBigImgVideoColumnItemViewHolder.c, paramBigImgVideoColumnItemViewHolder.q);
    a(paramBigImgVideoColumnItemViewHolder.c, paramAbsBaseArticleInfo.getVideoCoverUrlWithSmartCut(false), false, paramRIJDataManager.a().A());
    paramBigImgVideoColumnItemViewHolder.c.setOnLongClickListener(paramOnLongClickListener);
    paramBigImgVideoColumnItemViewHolder.f.setCustomSize(1.0F, ReadInJoyDisplayUtils.b(((VideoPlayParam)localObject).n, ((VideoPlayParam)localObject).o));
    paramBigImgVideoColumnItemViewHolder.f.setTag(paramBigImgVideoColumnItemViewHolder);
    if (paramRIJDataManager.a().v().c(paramRIJDataManager.a().B(), paramAbsBaseArticleInfo.mArticleID)) {
      paramBigImgVideoColumnItemViewHolder.Q.setBackgroundColor(paramRIJDataManager.a().A().getResources().getColor(2131167854));
    }
    if (paramAbsBaseArticleInfo.mXGFileSize <= 0L)
    {
      paramBigImgVideoColumnItemViewHolder.h.setText(HardCodeUtil.a(2131910511));
    }
    else
    {
      paramOnClickListener = paramBigImgVideoColumnItemViewHolder.h;
      paramOnLongClickListener = new StringBuilder();
      paramOnLongClickListener.append(VideoFeedsHelper.c(paramAbsBaseArticleInfo.mXGFileSize));
      paramOnLongClickListener.append(HardCodeUtil.a(2131910605));
      paramOnClickListener.setText(paramOnLongClickListener.toString());
    }
    if (NetworkUtil.isWifiConnected(paramRIJDataManager.a().A()))
    {
      paramBigImgVideoColumnItemViewHolder.g.setVisibility(0);
      paramBigImgVideoColumnItemViewHolder.h.setVisibility(8);
      paramBigImgVideoColumnItemViewHolder.i.setBackgroundColor(0);
      return;
    }
    paramBigImgVideoColumnItemViewHolder.g.setVisibility(8);
    paramOnClickListener = paramRIJDataManager.a().A().getResources().getDrawable(2130844245);
    paramBigImgVideoColumnItemViewHolder.h.setCompoundDrawablesWithIntrinsicBounds(paramOnClickListener, null, null, null);
    paramBigImgVideoColumnItemViewHolder.h.setCompoundDrawablePadding(AIOUtils.b(6.0F, paramRIJDataManager.a().A().getResources()));
    paramBigImgVideoColumnItemViewHolder.h.setVisibility(0);
    if (CUKingCardUtils.a() == 1)
    {
      paramBigImgVideoColumnItemViewHolder.h.setText(HardCodeUtil.a(2131910621));
      paramBigImgVideoColumnItemViewHolder.k.setVisibility(8);
      paramBigImgVideoColumnItemViewHolder.i.setBackgroundColor(0);
      return;
    }
    if ((RIJKingCardConfigSp.a()) && (!paramRIJDataManager.a().p()) && (paramBigImgVideoColumnItemViewHolder.P == 0))
    {
      paramOnLongClickListener = RIJKingCardConfigSp.b();
      localObject = RIJKingCardConfigSp.c();
      str = RIJKingCardConfigSp.d();
      if (!TextUtils.isEmpty(paramOnLongClickListener))
      {
        paramOnClickListener = RIJQQAppInterfaceUtil.a();
        if (paramOnClickListener != null) {
          paramOnClickListener = paramOnClickListener.getCurrentAccountUin();
        } else {
          paramOnClickListener = "";
        }
        paramAbsBaseArticleInfo = new VideoR5.Builder(null, null, null, null).o(paramOnClickListener).k(paramAbsBaseArticleInfo.innerUniqueID).b().a();
        paramBigImgVideoColumnItemViewHolder.k.setVisibility(0);
        paramBigImgVideoColumnItemViewHolder.k.setCompoundDrawablePadding(AIOUtils.b(2.0F, paramRIJDataManager.a().A().getResources()));
        paramOnClickListener = paramRIJDataManager.a().A().getResources().getDrawable(2130844046);
        paramOnClickListener.setBounds(0, 0, AIOUtils.b(10.0F, paramRIJDataManager.a().A().getResources()), AIOUtils.b(10.0F, paramRIJDataManager.a().A().getResources()));
        paramBigImgVideoColumnItemViewHolder.k.setCompoundDrawables(null, null, paramOnClickListener, null);
        VideoFeedsHelper.b(paramRIJDataManager.a().A(), paramBigImgVideoColumnItemViewHolder.k, (String)localObject, str, paramOnLongClickListener, new RIJConfigVideoItem.4(paramAbsBaseArticleInfo, paramBigImgVideoColumnItemViewHolder));
        paramBigImgVideoColumnItemViewHolder.i.setBackgroundColor(1711276032);
        paramRIJDataManager.a().c(true);
        PublicAccountReportUtils.a(null, "", "0X8009BE1", "0X8009BE1", 0, 0, "", "", "", paramAbsBaseArticleInfo, false);
        return;
      }
      paramBigImgVideoColumnItemViewHolder.k.setVisibility(8);
      paramBigImgVideoColumnItemViewHolder.i.setBackgroundColor(0);
      if (QLog.isColorLevel()) {
        QLog.w("Q.readinjoy.video", 2, "kingcard guideUrl is empty, so ignore");
      }
    }
    else
    {
      paramBigImgVideoColumnItemViewHolder.k.setVisibility(8);
      paramBigImgVideoColumnItemViewHolder.i.setBackgroundColor(0);
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
      paramBigImgVideoItemViewHolder.r.setText(paramAbsBaseArticleInfo.mArticleSubscriptText);
      if (TextUtils.isEmpty(paramAbsBaseArticleInfo.mArticleSubscriptColor)) {
        localObject1 = "#FF4222";
      } else {
        localObject1 = paramAbsBaseArticleInfo.mArticleSubscriptColor;
      }
      i = Color.parseColor((String)localObject1);
      paramBigImgVideoItemViewHolder.r.setTextColor(i);
      paramBigImgVideoItemViewHolder.r.setVisibility(0);
    }
    else
    {
      paramBigImgVideoItemViewHolder.r.setVisibility(8);
    }
    paramBigImgVideoItemViewHolder.n.setText(paramAbsBaseArticleInfo.mSubscribeName);
    if (paramAbsBaseArticleInfo.hasFamilyCommentIcon()) {}
    try
    {
      localObject1 = new URL(paramAbsBaseArticleInfo.familyCommentInfo.a);
      if (paramAbsBaseArticleInfo.familyCommentInfo.d > 0) {
        a(paramBigImgVideoItemViewHolder.q, (URL)localObject1, paramAbsBaseArticleInfo.familyCommentInfo.c, paramAbsBaseArticleInfo.familyCommentInfo.d, paramRIJDataManager.a().A());
      }
      paramBigImgVideoItemViewHolder.q.setVisibility(0);
      paramBigImgVideoItemViewHolder.o.setVisibility(8);
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
    paramBigImgVideoItemViewHolder.q.setVisibility(8);
    paramBigImgVideoItemViewHolder.o.setVisibility(0);
    QLog.d("ReadInJoyBaseAdapter", 2, "configBigImgVideoItemUI setCommentCountText");
    Object localObject1 = paramBigImgVideoItemViewHolder.o;
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(VideoFeedsHelper.d(paramAbsBaseArticleInfo.getCommentCount()));
    ((StringBuilder)localObject3).append(HardCodeUtil.a(2131910280));
    ((TextView)localObject1).setText(((StringBuilder)localObject3).toString());
    label270:
    if (!TextUtils.isEmpty(paramAbsBaseArticleInfo.vIconUrl)) {
      try
      {
        localObject1 = new URL(paramAbsBaseArticleInfo.vIconUrl);
        paramBigImgVideoItemViewHolder.s.setImage((URL)localObject1);
        paramBigImgVideoItemViewHolder.s.setVisibility(0);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    } else {
      paramBigImgVideoItemViewHolder.s.setVisibility(8);
    }
    UIUtils.a(paramBigImgVideoItemViewHolder.p, 10, 10, 10, 10);
    paramBigImgVideoItemViewHolder.p.setTag(paramBigImgVideoItemViewHolder);
    paramBigImgVideoItemViewHolder.p.setOnClickListener(paramOnClickListener);
    paramOnClickListener = a(paramAbsBaseArticleInfo);
    paramOnClickListener.h = paramBigImgVideoItemViewHolder.d;
    paramOnClickListener.e = paramBigImgVideoItemViewHolder.P;
    paramOnClickListener.D = paramAbsBaseArticleInfo;
    paramOnClickListener.P = 1;
    paramBigImgVideoItemViewHolder.t = paramOnClickListener;
    paramBigImgVideoItemViewHolder.b.setVisibility(8);
    paramBigImgVideoItemViewHolder.c.setVisibility(8);
    paramBigImgVideoItemViewHolder.j.setVisibility(8);
    paramBigImgVideoItemViewHolder.m.setText(paramAbsBaseArticleInfo.mTitle);
    localObject2 = paramBigImgVideoItemViewHolder.m;
    if (ReadInJoyLogicEngine.a().a(paramAbsBaseArticleInfo.mArticleID)) {
      i = Color.parseColor("#999999");
    } else {
      i = Color.parseColor("#262626");
    }
    ((TextView)localObject2).setTextColor(i);
    paramBigImgVideoItemViewHolder.e.setText(ReadInJoyDisplayUtils.a(paramOnClickListener.l, true));
    VideoHandler.b(paramRIJDataManager.a().A(), paramBigImgVideoItemViewHolder.d, paramBigImgVideoItemViewHolder.t);
    a(paramBigImgVideoItemViewHolder.d, paramAbsBaseArticleInfo.getVideoCoverUrlWithSmartCut(false), false, paramRIJDataManager.a().A());
    paramBigImgVideoItemViewHolder.d.setOnLongClickListener(paramOnLongClickListener);
    paramBigImgVideoItemViewHolder.e.setVisibility(0);
    paramBigImgVideoItemViewHolder.e.clearAnimation();
    paramBigImgVideoItemViewHolder.f.setCustomSize(1.0F, ReadInJoyDisplayUtils.b(paramOnClickListener.n, paramOnClickListener.o));
    paramBigImgVideoItemViewHolder.f.setTag(paramBigImgVideoItemViewHolder);
    if (paramRIJDataManager.a().v().c(paramRIJDataManager.a().B(), paramAbsBaseArticleInfo.mArticleID)) {
      paramBigImgVideoItemViewHolder.Q.setBackgroundColor(paramRIJDataManager.a().A().getResources().getColor(2131167854));
    }
    if (paramAbsBaseArticleInfo.mXGFileSize <= 0L)
    {
      paramBigImgVideoItemViewHolder.h.setText(HardCodeUtil.a(2131910511));
    }
    else
    {
      paramOnClickListener = paramBigImgVideoItemViewHolder.h;
      paramOnLongClickListener = new StringBuilder();
      paramOnLongClickListener.append(VideoFeedsHelper.c(paramAbsBaseArticleInfo.mXGFileSize));
      paramOnLongClickListener.append(HardCodeUtil.a(2131910605));
      paramOnClickListener.setText(paramOnLongClickListener.toString());
    }
    if (NetworkUtil.isWifiConnected(paramRIJDataManager.a().A()))
    {
      paramBigImgVideoItemViewHolder.g.setVisibility(0);
      paramBigImgVideoItemViewHolder.h.setVisibility(8);
      paramBigImgVideoItemViewHolder.i.setBackgroundColor(0);
      return;
    }
    paramBigImgVideoItemViewHolder.g.setVisibility(8);
    paramOnClickListener = paramRIJDataManager.a().A().getResources().getDrawable(2130844245);
    paramBigImgVideoItemViewHolder.h.setCompoundDrawablesWithIntrinsicBounds(paramOnClickListener, null, null, null);
    paramBigImgVideoItemViewHolder.h.setCompoundDrawablePadding(AIOUtils.b(6.0F, paramRIJDataManager.a().A().getResources()));
    paramBigImgVideoItemViewHolder.h.setVisibility(0);
    if (CUKingCardUtils.a() == 1)
    {
      paramBigImgVideoItemViewHolder.h.setText(HardCodeUtil.a(2131910621));
      paramBigImgVideoItemViewHolder.k.setVisibility(8);
      paramBigImgVideoItemViewHolder.i.setBackgroundColor(0);
      return;
    }
    if ((RIJKingCardConfigSp.a()) && (!paramRIJDataManager.a().p()) && (paramBigImgVideoItemViewHolder.P == 0))
    {
      paramOnLongClickListener = RIJKingCardConfigSp.b();
      localObject2 = RIJKingCardConfigSp.c();
      localObject3 = RIJKingCardConfigSp.d();
      if (!TextUtils.isEmpty(paramOnLongClickListener))
      {
        paramOnClickListener = RIJQQAppInterfaceUtil.a();
        if (paramOnClickListener != null) {
          paramOnClickListener = paramOnClickListener.getCurrentAccountUin();
        } else {
          paramOnClickListener = "";
        }
        paramAbsBaseArticleInfo = new VideoR5.Builder(null, null, null, null).o(paramOnClickListener).k(paramAbsBaseArticleInfo.innerUniqueID).b().a();
        paramBigImgVideoItemViewHolder.k.setVisibility(0);
        paramBigImgVideoItemViewHolder.k.setCompoundDrawablePadding(AIOUtils.b(2.0F, paramRIJDataManager.a().A().getResources()));
        paramOnClickListener = paramRIJDataManager.a().A().getResources().getDrawable(2130844046);
        paramOnClickListener.setBounds(0, 0, AIOUtils.b(10.0F, paramRIJDataManager.a().A().getResources()), AIOUtils.b(10.0F, paramRIJDataManager.a().A().getResources()));
        paramBigImgVideoItemViewHolder.k.setCompoundDrawables(null, null, paramOnClickListener, null);
        VideoFeedsHelper.b(paramRIJDataManager.a().A(), paramBigImgVideoItemViewHolder.k, (String)localObject2, (String)localObject3, paramOnLongClickListener, new RIJConfigVideoItem.3(paramAbsBaseArticleInfo, paramBigImgVideoItemViewHolder));
        paramBigImgVideoItemViewHolder.i.setBackgroundColor(1711276032);
        paramRIJDataManager.a().c(true);
        PublicAccountReportUtils.a(null, "", "0X8009BE1", "0X8009BE1", 0, 0, "", "", "", paramAbsBaseArticleInfo, false);
        return;
      }
      paramBigImgVideoItemViewHolder.k.setVisibility(8);
      paramBigImgVideoItemViewHolder.i.setBackgroundColor(0);
      if (QLog.isColorLevel()) {
        QLog.w("Q.readinjoy.video", 2, "kingcard guideUrl is empty, so ignore");
      }
    }
    else
    {
      paramBigImgVideoItemViewHolder.k.setVisibility(8);
      paramBigImgVideoItemViewHolder.i.setBackgroundColor(0);
    }
  }
  
  private static void a(VideoColumnItemViewHolder paramVideoColumnItemViewHolder, AbsBaseArticleInfo paramAbsBaseArticleInfo, RIJDataManager paramRIJDataManager)
  {
    paramVideoColumnItemViewHolder.d.getPaint().setFakeBoldText(true);
    if (paramAbsBaseArticleInfo.mVideoColumnInfo != null)
    {
      VideoColumnInfo localVideoColumnInfo = paramAbsBaseArticleInfo.mVideoColumnInfo;
      if (localVideoColumnInfo.r == 1)
      {
        paramAbsBaseArticleInfo = paramVideoColumnItemViewHolder.b.getLayoutParams();
        paramAbsBaseArticleInfo.height = DisplayUtil.a(paramRIJDataManager.a().A(), 90.0F);
        paramVideoColumnItemViewHolder.b.setLayoutParams(paramAbsBaseArticleInfo);
      }
      else
      {
        paramAbsBaseArticleInfo = paramVideoColumnItemViewHolder.b.getLayoutParams();
        paramAbsBaseArticleInfo.height = DisplayUtil.a(paramRIJDataManager.a().A(), 80.0F);
        paramVideoColumnItemViewHolder.b.setLayoutParams(paramAbsBaseArticleInfo);
      }
      try
      {
        if (!TextUtils.isEmpty(localVideoColumnInfo.i)) {
          a(paramVideoColumnItemViewHolder.b, new URL(localVideoColumnInfo.i), paramRIJDataManager.a().A());
        } else {
          paramVideoColumnItemViewHolder.b.setImageDrawable(new ColorDrawable(-15837762));
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
        if (!TextUtils.isEmpty(localVideoColumnInfo.j)) {
          paramAbsBaseArticleInfo = ReadInJoyDisplayUtils.b(localVideoColumnInfo.j);
        } else {
          paramAbsBaseArticleInfo = new ColorDrawable(-15837762);
        }
        paramVideoColumnItemViewHolder.g.setBackgroundDrawable(paramAbsBaseArticleInfo);
      }
      catch (Exception paramAbsBaseArticleInfo)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyBaseAdapter", 2, "configVideoColumnItemUI cardBgColor error: ", paramAbsBaseArticleInfo);
        }
        paramVideoColumnItemViewHolder.g.setBackgroundDrawable(new ColorDrawable(-15837762));
      }
      try
      {
        a(paramVideoColumnItemViewHolder.c, new URL(localVideoColumnInfo.k), paramRIJDataManager.a().A());
      }
      catch (MalformedURLException paramAbsBaseArticleInfo)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyBaseAdapter", 2, "configImage columnCardIcon error: ", paramAbsBaseArticleInfo);
        }
      }
      paramVideoColumnItemViewHolder.d.setText(localVideoColumnInfo.c);
      paramAbsBaseArticleInfo = new StringBuilder();
      paramAbsBaseArticleInfo.append(ReadInJoyTimeUtils.INSTANCE.getRelativeDisplayForTime(localVideoColumnInfo.e, true));
      paramAbsBaseArticleInfo.append(HardCodeUtil.a(2131910252));
      paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.toString();
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(ReadInJoyHelper.d(localVideoColumnInfo.f));
      ((StringBuilder)localObject1).append(HardCodeUtil.a(2131910355));
      localObject1 = ((StringBuilder)localObject1).toString();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(localVideoColumnInfo.g);
      ((StringBuilder)localObject2).append(HardCodeUtil.a(2131910583));
      localObject2 = ((StringBuilder)localObject2).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramAbsBaseArticleInfo);
      localStringBuilder.append(" · ");
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(" · ");
      localStringBuilder.append((String)localObject2);
      paramAbsBaseArticleInfo = localStringBuilder.toString();
      paramVideoColumnItemViewHolder.e.setText(paramAbsBaseArticleInfo);
      if (localVideoColumnInfo.h) {
        paramVideoColumnItemViewHolder.f.setVisibility(8);
      } else {
        paramVideoColumnItemViewHolder.f.setVisibility(0);
      }
      paramVideoColumnItemViewHolder.t.setText(localVideoColumnInfo.l);
      try
      {
        paramVideoColumnItemViewHolder.s.setCorner(DisplayUtil.a(paramRIJDataManager.a().A(), 2.0F));
        a(paramVideoColumnItemViewHolder.s, new URL(localVideoColumnInfo.m), paramRIJDataManager.a().A());
      }
      catch (Exception paramAbsBaseArticleInfo)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyBaseAdapter", 2, "configImage appIcon error: ", paramAbsBaseArticleInfo);
        }
      }
      paramVideoColumnItemViewHolder.a.setTag(paramVideoColumnItemViewHolder);
      paramVideoColumnItemViewHolder.f.setTag(paramVideoColumnItemViewHolder);
      paramVideoColumnItemViewHolder.r.setTag(paramVideoColumnItemViewHolder);
      paramVideoColumnItemViewHolder.s.setTag(paramVideoColumnItemViewHolder);
      paramVideoColumnItemViewHolder.t.setTag(paramVideoColumnItemViewHolder);
    }
  }
  
  public static void a(VideoColumnItemViewHolder paramVideoColumnItemViewHolder, AbsBaseArticleInfo paramAbsBaseArticleInfo, RIJDataManager paramRIJDataManager, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener)
  {
    if (paramAbsBaseArticleInfo == null) {
      return;
    }
    paramVideoColumnItemViewHolder.u.setTag(paramVideoColumnItemViewHolder);
    paramVideoColumnItemViewHolder.u.setOnClickListener(paramOnClickListener);
    paramOnClickListener = a(paramAbsBaseArticleInfo);
    paramOnClickListener.h = paramVideoColumnItemViewHolder.j;
    paramOnClickListener.e = paramVideoColumnItemViewHolder.P;
    paramOnClickListener.D = paramAbsBaseArticleInfo;
    paramVideoColumnItemViewHolder.v = paramOnClickListener;
    paramVideoColumnItemViewHolder.h.setText(paramAbsBaseArticleInfo.mTitle);
    paramVideoColumnItemViewHolder.h.getPaint().setFakeBoldText(true);
    paramVideoColumnItemViewHolder.h.setTextColor(paramRIJDataManager.a().A().getResources().getColor(2131168464));
    if (paramAbsBaseArticleInfo.mVideoPlayCount == 0)
    {
      paramVideoColumnItemViewHolder.i.setVisibility(8);
    }
    else
    {
      paramVideoColumnItemViewHolder.i.setVisibility(0);
      TextView localTextView = paramVideoColumnItemViewHolder.i;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(VideoFeedsHelper.c(paramAbsBaseArticleInfo.mVideoPlayCount));
      localStringBuilder.append(HardCodeUtil.a(2131910578));
      localTextView.setText(localStringBuilder.toString());
    }
    paramVideoColumnItemViewHolder.k.setText(ReadInJoyDisplayUtils.a(paramOnClickListener.l, true));
    VideoHandler.b(paramRIJDataManager.a().A(), paramVideoColumnItemViewHolder.j, paramVideoColumnItemViewHolder.v);
    a(paramVideoColumnItemViewHolder.j, paramAbsBaseArticleInfo.getVideoCoverUrlWithSmartCut(false), false, paramRIJDataManager.a().A());
    paramVideoColumnItemViewHolder.j.setOnLongClickListener(paramOnLongClickListener);
    paramVideoColumnItemViewHolder.j.setTag(paramVideoColumnItemViewHolder);
    paramVideoColumnItemViewHolder.k.setVisibility(0);
    paramVideoColumnItemViewHolder.k.clearAnimation();
    paramVideoColumnItemViewHolder.l.setCustomSize(1.0F, ReadInJoyDisplayUtils.b(paramOnClickListener.n, paramOnClickListener.o));
    paramVideoColumnItemViewHolder.l.setTag(paramVideoColumnItemViewHolder);
    if (paramRIJDataManager.a().v().c(paramRIJDataManager.a().B(), paramAbsBaseArticleInfo.mArticleID)) {
      paramVideoColumnItemViewHolder.Q.setBackgroundColor(paramRIJDataManager.a().A().getResources().getColor(2131167854));
    }
    a(paramVideoColumnItemViewHolder, paramAbsBaseArticleInfo, paramRIJDataManager);
    b(paramVideoColumnItemViewHolder, paramAbsBaseArticleInfo, paramRIJDataManager);
  }
  
  public static void a(VideoFeedsTwoItemViewHolder paramVideoFeedsTwoItemViewHolder, AbsBaseArticleInfo paramAbsBaseArticleInfo, RIJDataManager paramRIJDataManager, View.OnClickListener paramOnClickListener)
  {
    paramVideoFeedsTwoItemViewHolder.Q.setOnClickListener(null);
    paramVideoFeedsTwoItemViewHolder.D = paramAbsBaseArticleInfo;
    paramVideoFeedsTwoItemViewHolder.E = ((AbsBaseArticleInfo)paramAbsBaseArticleInfo.mSubArticleList.get(0));
    paramVideoFeedsTwoItemViewHolder.a.setBackgroundColor(paramRIJDataManager.a().A().getResources().getColor(2131168464));
    a(paramVideoFeedsTwoItemViewHolder.m, paramVideoFeedsTwoItemViewHolder.x, paramRIJDataManager.a().A());
    AbsBaseArticleInfo localAbsBaseArticleInfo = paramVideoFeedsTwoItemViewHolder.D;
    a(localAbsBaseArticleInfo, paramVideoFeedsTwoItemViewHolder.k, paramVideoFeedsTwoItemViewHolder.b, paramVideoFeedsTwoItemViewHolder.d, paramVideoFeedsTwoItemViewHolder.f, paramVideoFeedsTwoItemViewHolder.Q, paramRIJDataManager.a().A());
    a(paramVideoFeedsTwoItemViewHolder.h);
    paramVideoFeedsTwoItemViewHolder.k.setText(localAbsBaseArticleInfo.mTitle);
    paramVideoFeedsTwoItemViewHolder.k.getPaint().setFakeBoldText(true);
    paramVideoFeedsTwoItemViewHolder.l.setText(VideoFeedsHelper.c(localAbsBaseArticleInfo.mVideoPlayCount));
    a(paramVideoFeedsTwoItemViewHolder.i, paramVideoFeedsTwoItemViewHolder.j, localAbsBaseArticleInfo, false, paramRIJDataManager.a().A());
    paramVideoFeedsTwoItemViewHolder.i.setTag(paramVideoFeedsTwoItemViewHolder);
    paramVideoFeedsTwoItemViewHolder.i.setOnClickListener(paramOnClickListener);
    VideoReport.setElementExposePolicy(paramVideoFeedsTwoItemViewHolder.i, ExposurePolicy.REPORT_FIRST);
    VideoReport.setElementEndExposePolicy(paramVideoFeedsTwoItemViewHolder.i, EndExposurePolicy.REPORT_ALL);
    VideoReport.setElementId(paramVideoFeedsTwoItemViewHolder.i, "card");
    KandianUrlImageView localKandianUrlImageView = paramVideoFeedsTwoItemViewHolder.i;
    RIJDtParamBuilder localRIJDtParamBuilder = new RIJDtParamBuilder().a(Integer.valueOf(paramRIJDataManager.a().B()));
    boolean bool = TextUtils.isEmpty(localAbsBaseArticleInfo.innerUniqueID);
    String str = "null";
    if (bool) {
      paramAbsBaseArticleInfo = "null";
    } else {
      paramAbsBaseArticleInfo = localAbsBaseArticleInfo.innerUniqueID;
    }
    VideoReport.setElementParams(localKandianUrlImageView, localRIJDtParamBuilder.e(paramAbsBaseArticleInfo).c());
    VideoReport.setElementReuseIdentifier(paramVideoFeedsTwoItemViewHolder.i, localAbsBaseArticleInfo.innerUniqueID);
    paramVideoFeedsTwoItemViewHolder.f.setTag(localAbsBaseArticleInfo);
    VideoFeedsHelper.a(localAbsBaseArticleInfo.mVideoArticleSubsText, localAbsBaseArticleInfo.mVideoArticleSubsColor, paramVideoFeedsTwoItemViewHolder.n);
    long l;
    if ((localAbsBaseArticleInfo.isAccountShown) && (paramRIJDataManager.a().B() == 0) && (localAbsBaseArticleInfo.mPartnerAccountInfo != null))
    {
      paramVideoFeedsTwoItemViewHolder.o.setVisibility(0);
      paramVideoFeedsTwoItemViewHolder.o.setTag(localAbsBaseArticleInfo);
      paramVideoFeedsTwoItemViewHolder.o.setTag(2131444340, paramVideoFeedsTwoItemViewHolder);
      if (localAbsBaseArticleInfo.mPartnerAccountInfo.uint64_uin.has()) {
        l = localAbsBaseArticleInfo.mPartnerAccountInfo.uint64_uin.get();
      } else {
        l = 0L;
      }
      paramVideoFeedsTwoItemViewHolder.p.setHeadImgByUin(l);
      paramVideoFeedsTwoItemViewHolder.p.setTag(localAbsBaseArticleInfo);
      paramVideoFeedsTwoItemViewHolder.p.setTag(2131444340, paramVideoFeedsTwoItemViewHolder);
      a(paramVideoFeedsTwoItemViewHolder.p, 10, 10, 10, 10);
      paramAbsBaseArticleInfo = RIJPBFieldUtils.d(localAbsBaseArticleInfo.mPartnerAccountInfo.bytes_v_icon_url);
      if (!TextUtils.isEmpty(paramAbsBaseArticleInfo)) {
        try
        {
          paramAbsBaseArticleInfo = new URL(paramAbsBaseArticleInfo);
          paramVideoFeedsTwoItemViewHolder.q.setImage(paramAbsBaseArticleInfo);
        }
        catch (Exception paramAbsBaseArticleInfo)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ReadInJoyBaseAdapter", 2, "leftSmallIconImageView setImage error: ", paramAbsBaseArticleInfo);
          }
        }
      }
      paramVideoFeedsTwoItemViewHolder.r.setNickNameByUin(l);
      paramVideoFeedsTwoItemViewHolder.o.setOnClickListener(paramOnClickListener);
      paramVideoFeedsTwoItemViewHolder.p.setOnClickListener(paramOnClickListener);
    }
    else
    {
      paramVideoFeedsTwoItemViewHolder.o.setVisibility(8);
    }
    localAbsBaseArticleInfo = paramVideoFeedsTwoItemViewHolder.E;
    localAbsBaseArticleInfo.isTwoItem = true;
    a(localAbsBaseArticleInfo, paramVideoFeedsTwoItemViewHolder.v, paramVideoFeedsTwoItemViewHolder.c, paramVideoFeedsTwoItemViewHolder.e, paramVideoFeedsTwoItemViewHolder.g, paramVideoFeedsTwoItemViewHolder.Q, paramRIJDataManager.a().A());
    a(paramVideoFeedsTwoItemViewHolder.s);
    paramVideoFeedsTwoItemViewHolder.v.setText(localAbsBaseArticleInfo.mTitle);
    paramVideoFeedsTwoItemViewHolder.v.getPaint().setFakeBoldText(true);
    paramVideoFeedsTwoItemViewHolder.w.setText(VideoFeedsHelper.c(localAbsBaseArticleInfo.mVideoPlayCount));
    a(paramVideoFeedsTwoItemViewHolder.t, paramVideoFeedsTwoItemViewHolder.u, localAbsBaseArticleInfo, false, paramRIJDataManager.a().A());
    paramVideoFeedsTwoItemViewHolder.t.setTag(paramVideoFeedsTwoItemViewHolder);
    paramVideoFeedsTwoItemViewHolder.t.setOnClickListener(paramOnClickListener);
    VideoReport.setElementExposePolicy(paramVideoFeedsTwoItemViewHolder.i, ExposurePolicy.REPORT_FIRST);
    VideoReport.setElementEndExposePolicy(paramVideoFeedsTwoItemViewHolder.i, EndExposurePolicy.REPORT_ALL);
    VideoReport.setElementId(paramVideoFeedsTwoItemViewHolder.t, "card");
    localKandianUrlImageView = paramVideoFeedsTwoItemViewHolder.t;
    localRIJDtParamBuilder = new RIJDtParamBuilder().a(Integer.valueOf(paramRIJDataManager.a().B()));
    if (TextUtils.isEmpty(localAbsBaseArticleInfo.innerUniqueID)) {
      paramAbsBaseArticleInfo = str;
    } else {
      paramAbsBaseArticleInfo = localAbsBaseArticleInfo.innerUniqueID;
    }
    VideoReport.setElementParams(localKandianUrlImageView, localRIJDtParamBuilder.e(paramAbsBaseArticleInfo).c());
    VideoReport.setElementReuseIdentifier(paramVideoFeedsTwoItemViewHolder.t, localAbsBaseArticleInfo.innerUniqueID);
    paramVideoFeedsTwoItemViewHolder.g.setTag(localAbsBaseArticleInfo);
    VideoFeedsHelper.a(localAbsBaseArticleInfo.mVideoArticleSubsText, localAbsBaseArticleInfo.mVideoArticleSubsColor, paramVideoFeedsTwoItemViewHolder.y);
    if ((localAbsBaseArticleInfo.isAccountShown) && (paramRIJDataManager.a().B() == 0) && (localAbsBaseArticleInfo.mPartnerAccountInfo != null))
    {
      paramVideoFeedsTwoItemViewHolder.z.setVisibility(0);
      paramVideoFeedsTwoItemViewHolder.z.setTag(localAbsBaseArticleInfo);
      paramVideoFeedsTwoItemViewHolder.z.setTag(2131444340, paramVideoFeedsTwoItemViewHolder);
      if ((localAbsBaseArticleInfo.mPartnerAccountInfo != null) && (localAbsBaseArticleInfo.mPartnerAccountInfo.uint64_uin.has())) {
        l = localAbsBaseArticleInfo.mPartnerAccountInfo.uint64_uin.get();
      } else {
        l = 0L;
      }
      paramVideoFeedsTwoItemViewHolder.A.setHeadImgByUin(l);
      paramVideoFeedsTwoItemViewHolder.A.setTag(localAbsBaseArticleInfo);
      paramVideoFeedsTwoItemViewHolder.A.setTag(2131444340, paramVideoFeedsTwoItemViewHolder);
      a(paramVideoFeedsTwoItemViewHolder.A, 10, 10, 10, 10);
      paramAbsBaseArticleInfo = RIJPBFieldUtils.d(localAbsBaseArticleInfo.mPartnerAccountInfo.bytes_v_icon_url);
      if (!TextUtils.isEmpty(paramAbsBaseArticleInfo)) {
        try
        {
          paramAbsBaseArticleInfo = new URL(paramAbsBaseArticleInfo);
          paramVideoFeedsTwoItemViewHolder.B.setImage(paramAbsBaseArticleInfo);
        }
        catch (Exception paramAbsBaseArticleInfo)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ReadInJoyBaseAdapter", 2, "rightSmallIconImageView setImage error: ", paramAbsBaseArticleInfo);
          }
        }
      }
      paramVideoFeedsTwoItemViewHolder.C.setNickNameByUin(l);
      paramVideoFeedsTwoItemViewHolder.z.setOnClickListener(paramOnClickListener);
      paramVideoFeedsTwoItemViewHolder.A.setOnClickListener(paramOnClickListener);
      return;
    }
    paramVideoFeedsTwoItemViewHolder.z.setVisibility(8);
  }
  
  public static void a(VideoFeedsViewHolder paramVideoFeedsViewHolder, RIJDataManager paramRIJDataManager, View.OnClickListener paramOnClickListener)
  {
    paramVideoFeedsViewHolder.v.setVisibility(8);
  }
  
  public static void a(VideoFeedsViewHolder paramVideoFeedsViewHolder, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    VideoPlayParam localVideoPlayParam = a(paramAbsBaseArticleInfo);
    localVideoPlayParam.h = paramVideoFeedsViewHolder.c;
    localVideoPlayParam.e = paramVideoFeedsViewHolder.P;
    localVideoPlayParam.D = paramAbsBaseArticleInfo;
    paramVideoFeedsViewHolder.t = localVideoPlayParam;
  }
  
  private static void a(VideoFeedsViewHolder paramVideoFeedsViewHolder, AbsBaseArticleInfo paramAbsBaseArticleInfo, RIJDataManager paramRIJDataManager)
  {
    if (NetworkUtil.isWifiConnected(paramRIJDataManager.a().A()))
    {
      paramVideoFeedsViewHolder.x.setVisibility(0);
      paramVideoFeedsViewHolder.y.setVisibility(8);
      paramVideoFeedsViewHolder.B.setVisibility(0);
      paramVideoFeedsViewHolder.A.setBackgroundColor(0);
      return;
    }
    paramVideoFeedsViewHolder.x.setVisibility(8);
    Object localObject = paramRIJDataManager.a().A().getResources().getDrawable(2130844245);
    paramVideoFeedsViewHolder.y.setCompoundDrawablesWithIntrinsicBounds((Drawable)localObject, null, null, null);
    paramVideoFeedsViewHolder.y.setCompoundDrawablePadding(AIOUtils.b(6.0F, paramRIJDataManager.a().A().getResources()));
    paramVideoFeedsViewHolder.y.setVisibility(0);
    if (CUKingCardUtils.a() == 1)
    {
      paramVideoFeedsViewHolder.y.setText(HardCodeUtil.a(2131910367));
      paramVideoFeedsViewHolder.z.setVisibility(8);
      paramVideoFeedsViewHolder.B.setVisibility(0);
      paramVideoFeedsViewHolder.A.setBackgroundColor(0);
      return;
    }
    if ((RIJKingCardConfigSp.a()) && (!paramRIJDataManager.a().p()) && (paramVideoFeedsViewHolder.P == 0))
    {
      String str1 = RIJKingCardConfigSp.b();
      String str2 = RIJKingCardConfigSp.c();
      String str3 = RIJKingCardConfigSp.d();
      if (!TextUtils.isEmpty(str1))
      {
        localObject = RIJQQAppInterfaceUtil.a();
        if (localObject != null) {
          localObject = ((QQAppInterface)localObject).getCurrentAccountUin();
        } else {
          localObject = "";
        }
        paramAbsBaseArticleInfo = new VideoR5.Builder(null, null, null, null).o((String)localObject).k(paramAbsBaseArticleInfo.innerUniqueID).b().a();
        paramVideoFeedsViewHolder.z.setVisibility(0);
        paramVideoFeedsViewHolder.z.setCompoundDrawablePadding(AIOUtils.b(2.0F, paramRIJDataManager.a().A().getResources()));
        localObject = paramRIJDataManager.a().A().getResources().getDrawable(2130844046);
        ((Drawable)localObject).setBounds(0, 0, AIOUtils.b(10.0F, paramRIJDataManager.a().A().getResources()), AIOUtils.b(10.0F, paramRIJDataManager.a().A().getResources()));
        paramVideoFeedsViewHolder.z.setCompoundDrawables(null, null, (Drawable)localObject, null);
        VideoFeedsHelper.b(paramRIJDataManager.a().A(), paramVideoFeedsViewHolder.z, str2, str3, str1, new RIJConfigVideoItem.1(paramAbsBaseArticleInfo, paramVideoFeedsViewHolder));
        paramVideoFeedsViewHolder.A.setBackgroundColor(1711276032);
        paramVideoFeedsViewHolder.B.setVisibility(0);
        paramRIJDataManager.a().c(true);
        PublicAccountReportUtils.a(null, "", "0X8009BE1", "0X8009BE1", 0, 0, "", "", "", paramAbsBaseArticleInfo, false);
        return;
      }
      paramVideoFeedsViewHolder.z.setVisibility(8);
      paramVideoFeedsViewHolder.B.setVisibility(0);
      paramVideoFeedsViewHolder.A.setBackgroundColor(0);
      if (QLog.isColorLevel()) {
        QLog.w("Q.readinjoy.video", 2, "kingcard guideUrl is empty, so ignore");
      }
    }
    else
    {
      paramVideoFeedsViewHolder.z.setVisibility(8);
      paramVideoFeedsViewHolder.B.setVisibility(0);
      paramVideoFeedsViewHolder.A.setBackgroundColor(0);
    }
  }
  
  private static void a(VideoFeedsViewHolder paramVideoFeedsViewHolder, AbsBaseArticleInfo paramAbsBaseArticleInfo, RIJDataManager paramRIJDataManager, View.OnClickListener paramOnClickListener)
  {
    AdvertisementInfo localAdvertisementInfo = (AdvertisementInfo)paramAbsBaseArticleInfo;
    TextView localTextView = paramVideoFeedsViewHolder.D;
    int i = 0;
    localTextView.setVisibility(0);
    if (RIJKanDianFeedsCardStyleAladdinConfig.a())
    {
      ApiCompatibilityUtils.a(paramVideoFeedsViewHolder.D, null);
      paramVideoFeedsViewHolder.D.setTextColor(Color.parseColor("#777777"));
      paramVideoFeedsViewHolder.F.setTextColor(Color.parseColor("#40A0FF"));
    }
    else
    {
      ApiCompatibilityUtils.a(paramVideoFeedsViewHolder.D, ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).getAdBox(Color.parseColor("#BBBBBB"), paramRIJDataManager.a().A()));
    }
    if (!TextUtils.isEmpty(paramAbsBaseArticleInfo.mArticleSubscriptText)) {
      paramVideoFeedsViewHolder.D.setText(paramAbsBaseArticleInfo.mArticleSubscriptText);
    } else {
      paramVideoFeedsViewHolder.D.setText(paramRIJDataManager.a().A().getString(2131892899));
    }
    paramVideoFeedsViewHolder.E.setVisibility(0);
    if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAppAdvertisementInfo(paramAbsBaseArticleInfo)) {}
    try
    {
      paramAbsBaseArticleInfo = new JSONObject(localAdvertisementInfo.mAdExt);
      if (PackageUtil.a(paramRIJDataManager.a().A(), paramAbsBaseArticleInfo.optString("pkg_name")))
      {
        paramVideoFeedsViewHolder.F.setText(paramRIJDataManager.a().A().getString(2131915392));
        i = 1;
      }
      else
      {
        paramVideoFeedsViewHolder.F.setText(paramRIJDataManager.a().A().getString(2131915391));
      }
    }
    catch (JSONException paramAbsBaseArticleInfo)
    {
      label250:
      break label250;
    }
    paramVideoFeedsViewHolder.F.setText(paramRIJDataManager.a().A().getString(2131915449));
    if ((!TextUtils.isEmpty(localAdvertisementInfo.mAdBtnTxt)) && (i == 0)) {
      paramVideoFeedsViewHolder.F.setText(localAdvertisementInfo.mAdBtnTxt);
    }
    if ((i == 0) && (!Objects.equal(paramVideoFeedsViewHolder.F.getText(), paramRIJDataManager.a().A().getString(2131890946))))
    {
      ((IRIJAdDownloadService)QRoute.api(IRIJAdDownloadService.class)).queryState(localAdvertisementInfo, new RIJConfigVideoItem.2(paramVideoFeedsViewHolder, paramRIJDataManager));
      break label403;
      if (!TextUtils.isEmpty(localAdvertisementInfo.mAdBtnTxt)) {
        paramVideoFeedsViewHolder.F.setText(localAdvertisementInfo.mAdBtnTxt);
      } else {
        paramVideoFeedsViewHolder.F.setText(paramRIJDataManager.a().A().getString(2131915449));
      }
    }
    try
    {
      label403:
      paramAbsBaseArticleInfo = new JSONObject(localAdvertisementInfo.mAdExtInfo);
      if (!TextUtils.isEmpty(paramAbsBaseArticleInfo.optString("AdsIconText"))) {
        paramVideoFeedsViewHolder.D.setText(paramAbsBaseArticleInfo.optString("AdsIconText"));
      }
    }
    catch (JSONException paramAbsBaseArticleInfo)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyBaseAdapter", 2, "AdsIconText  error: ", paramAbsBaseArticleInfo);
      }
    }
    paramVideoFeedsViewHolder.G.setOnClickListener(paramOnClickListener);
    paramVideoFeedsViewHolder.F.setOnClickListener(paramOnClickListener);
    paramVideoFeedsViewHolder.D.setOnClickListener(paramOnClickListener);
    paramVideoFeedsViewHolder.D.setTag(paramVideoFeedsViewHolder);
    paramVideoFeedsViewHolder.F.setTag(paramVideoFeedsViewHolder);
    paramVideoFeedsViewHolder.G.setTag(paramVideoFeedsViewHolder);
    paramVideoFeedsViewHolder.s.setVisibility(8);
    paramVideoFeedsViewHolder.C.setVisibility(8);
  }
  
  public static void a(VideoFeedsViewHolder paramVideoFeedsViewHolder, AbsBaseArticleInfo paramAbsBaseArticleInfo, RIJDataManager paramRIJDataManager, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, Set<Long> paramSet)
  {
    if (paramAbsBaseArticleInfo == null) {
      return;
    }
    a(paramVideoFeedsViewHolder, paramAbsBaseArticleInfo);
    Object localObject1 = paramVideoFeedsViewHolder.t;
    paramVideoFeedsViewHolder.b.setText(paramAbsBaseArticleInfo.mTitle);
    paramVideoFeedsViewHolder.b.getPaint().setFakeBoldText(true);
    paramVideoFeedsViewHolder.b.setTextColor(paramRIJDataManager.a().A().getResources().getColor(2131168464));
    Object localObject2;
    if (paramAbsBaseArticleInfo.mVideoPlayCount == 0)
    {
      paramVideoFeedsViewHolder.q.setVisibility(8);
    }
    else
    {
      paramVideoFeedsViewHolder.q.setVisibility(0);
      localObject2 = paramVideoFeedsViewHolder.q;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(VideoFeedsHelper.c(paramAbsBaseArticleInfo.mVideoPlayCount));
      localStringBuilder.append(HardCodeUtil.a(2131910429));
      ((TextView)localObject2).setText(localStringBuilder.toString());
    }
    paramVideoFeedsViewHolder.h.setText(ReadInJoyDisplayUtils.a(((VideoPlayParam)localObject1).l, true));
    a(paramVideoFeedsViewHolder.e, paramAbsBaseArticleInfo, ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo(paramAbsBaseArticleInfo));
    a(paramVideoFeedsViewHolder.f, paramAbsBaseArticleInfo);
    paramVideoFeedsViewHolder.f.setContentDescription(paramAbsBaseArticleInfo.getSubscribeName());
    paramVideoFeedsViewHolder.e.setVisibility(0);
    paramVideoFeedsViewHolder.e.setContentDescription(paramAbsBaseArticleInfo.getSubscribeName());
    paramVideoFeedsViewHolder.g.setTag(paramAbsBaseArticleInfo);
    paramVideoFeedsViewHolder.g.setTag(2131444340, paramVideoFeedsViewHolder);
    paramVideoFeedsViewHolder.g.setOnClickListener(paramOnClickListener);
    if (!TextUtils.isEmpty(paramAbsBaseArticleInfo.vIconUrl)) {
      try
      {
        localObject2 = new URL(paramAbsBaseArticleInfo.vIconUrl);
        paramVideoFeedsViewHolder.H.setImage((URL)localObject2);
        paramVideoFeedsViewHolder.H.setVisibility(0);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    } else {
      paramVideoFeedsViewHolder.H.setVisibility(8);
    }
    if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo(paramAbsBaseArticleInfo))
    {
      a(paramVideoFeedsViewHolder, paramAbsBaseArticleInfo, paramRIJDataManager, paramOnClickListener);
    }
    else
    {
      paramVideoFeedsViewHolder.D.setVisibility(8);
      paramVideoFeedsViewHolder.E.setVisibility(8);
      paramVideoFeedsViewHolder.s.setVisibility(0);
      paramVideoFeedsViewHolder.C.setVisibility(0);
      paramVideoFeedsViewHolder.s.setArticleInfo(paramAbsBaseArticleInfo, paramRIJDataManager.a().v(), paramRIJDataManager.a().B(), paramSet);
      paramVideoFeedsViewHolder.k.setOnClickListener(paramOnClickListener);
      paramVideoFeedsViewHolder.k.setTag(paramVideoFeedsViewHolder);
      paramVideoFeedsViewHolder.l.setOnClickListener(paramOnClickListener);
      paramVideoFeedsViewHolder.l.setOnLongClickListener(paramOnLongClickListener);
      paramVideoFeedsViewHolder.l.setTag(paramVideoFeedsViewHolder);
      paramVideoFeedsViewHolder.m.setOnClickListener(paramOnClickListener);
      paramVideoFeedsViewHolder.m.setTag(paramVideoFeedsViewHolder);
    }
    VideoHandler.b(paramRIJDataManager.a().A(), paramVideoFeedsViewHolder.c, paramVideoFeedsViewHolder.t);
    a(paramVideoFeedsViewHolder.c, paramAbsBaseArticleInfo.getVideoCoverUrlWithSmartCut(false), false, paramRIJDataManager.a().A());
    paramVideoFeedsViewHolder.c.setOnClickListener(paramOnClickListener);
    paramVideoFeedsViewHolder.c.setOnLongClickListener(paramOnLongClickListener);
    paramVideoFeedsViewHolder.c.setTag(paramVideoFeedsViewHolder);
    paramVideoFeedsViewHolder.h.setVisibility(0);
    paramVideoFeedsViewHolder.h.clearAnimation();
    paramVideoFeedsViewHolder.i.setCustomSize(1.0F, ReadInJoyDisplayUtils.b(((VideoPlayParam)localObject1).n, ((VideoPlayParam)localObject1).o));
    paramVideoFeedsViewHolder.i.setOnClickListener(paramOnClickListener);
    paramVideoFeedsViewHolder.i.setTag(paramVideoFeedsViewHolder);
    if (paramRIJDataManager.a().v().c(paramRIJDataManager.a().B(), paramAbsBaseArticleInfo.mArticleID)) {
      paramVideoFeedsViewHolder.Q.setBackgroundColor(paramRIJDataManager.a().A().getResources().getColor(2131167854));
    }
    ReadInjoyFeedsUtils.a(paramRIJDataManager.a().A(), paramVideoFeedsViewHolder.u, paramVideoFeedsViewHolder.a);
    if (RIJKanDianFeedsCardStyleAladdinConfig.a())
    {
      paramVideoFeedsViewHolder.j.setCompoundDrawablePadding(DisplayUtil.a(paramRIJDataManager.a().A(), 5.0F));
      paramOnLongClickListener = paramRIJDataManager.a().A().getResources().getDrawable(2130844143);
      int i = DisplayUtil.a(paramRIJDataManager.a().A(), 17.0F);
      paramOnLongClickListener.setBounds(0, 0, i, i);
      paramVideoFeedsViewHolder.j.setCompoundDrawables(paramOnLongClickListener, null, null, null);
    }
    else
    {
      paramVideoFeedsViewHolder.j.setCompoundDrawablePadding(DisplayUtil.a(paramRIJDataManager.a().A(), 0.0F));
      paramOnLongClickListener = paramRIJDataManager.a().A().getResources().getDrawable(2130844142);
      paramVideoFeedsViewHolder.j.setCompoundDrawablesWithIntrinsicBounds(paramOnLongClickListener, null, null, null);
    }
    paramVideoFeedsViewHolder.a.setOnClickListener(paramOnClickListener);
    paramVideoFeedsViewHolder.a.setTag(paramVideoFeedsViewHolder);
    VideoFeedsHelper.a(paramVideoFeedsViewHolder.j, paramAbsBaseArticleInfo.getCommentCount(), HardCodeUtil.a(2131910427));
    paramVideoFeedsViewHolder.j.setOnClickListener(paramOnClickListener);
    paramVideoFeedsViewHolder.j.setTag(paramVideoFeedsViewHolder);
    paramVideoFeedsViewHolder.d.setOnClickListener(paramOnClickListener);
    paramVideoFeedsViewHolder.d.setTag(paramVideoFeedsViewHolder);
    if (paramAbsBaseArticleInfo.mXGFileSize <= 0L)
    {
      paramVideoFeedsViewHolder.y.setText(HardCodeUtil.a(2131910264));
    }
    else
    {
      paramOnLongClickListener = paramVideoFeedsViewHolder.y;
      paramSet = new StringBuilder();
      paramSet.append(VideoFeedsHelper.c(paramAbsBaseArticleInfo.mXGFileSize));
      paramSet.append(HardCodeUtil.a(2131910508));
      paramOnLongClickListener.setText(paramSet.toString());
    }
    if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo(paramAbsBaseArticleInfo))
    {
      paramOnLongClickListener = (AdvertisementInfo)paramAbsBaseArticleInfo;
      if (paramOnLongClickListener.mAdVideoFileSize >= 0L)
      {
        paramSet = paramVideoFeedsViewHolder.y;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(VideoFeedsHelper.c(paramOnLongClickListener.mAdVideoFileSize));
        ((StringBuilder)localObject1).append(HardCodeUtil.a(2131910508));
        paramSet.setText(((StringBuilder)localObject1).toString());
      }
    }
    a(paramVideoFeedsViewHolder, paramAbsBaseArticleInfo, paramRIJDataManager);
    a(paramVideoFeedsViewHolder, paramRIJDataManager, paramOnClickListener);
  }
  
  public static void a(WeishiGridTwoItemViewHolder paramWeishiGridTwoItemViewHolder, AbsBaseArticleInfo paramAbsBaseArticleInfo, RIJDataManager paramRIJDataManager, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener)
  {
    paramWeishiGridTwoItemViewHolder.Q.setOnClickListener(null);
    paramWeishiGridTwoItemViewHolder.Q.setOnLongClickListener(paramOnLongClickListener);
    paramWeishiGridTwoItemViewHolder.k = paramAbsBaseArticleInfo;
    paramWeishiGridTwoItemViewHolder.l = ((AbsBaseArticleInfo)paramAbsBaseArticleInfo.mSubArticleList.get(0));
    AbsBaseArticleInfo localAbsBaseArticleInfo = paramWeishiGridTwoItemViewHolder.k;
    paramWeishiGridTwoItemViewHolder.b.setText(localAbsBaseArticleInfo.mTitle);
    paramWeishiGridTwoItemViewHolder.b.getPaint().setFakeBoldText(true);
    paramWeishiGridTwoItemViewHolder.c.setText(VideoFeedsHelper.c(localAbsBaseArticleInfo.mVideoPlayCount));
    paramAbsBaseArticleInfo = paramRIJDataManager.a().A().getResources().getDrawable(2130844246);
    int i = ViewUtils.dpToPx(8.0F);
    paramAbsBaseArticleInfo.setBounds(0, 0, i, i);
    paramWeishiGridTwoItemViewHolder.c.setCompoundDrawables(paramAbsBaseArticleInfo, null, null, null);
    paramWeishiGridTwoItemViewHolder.c.setCompoundDrawablePadding(ViewUtils.dpToPx(3.0F));
    VideoFeedsHelper.a(paramWeishiGridTwoItemViewHolder.d, localAbsBaseArticleInfo.getCommentCount(), HardCodeUtil.a(2131910261), "0");
    URL localURL = localAbsBaseArticleInfo.getVideoCoverUrlWithSmartCut(true);
    a(paramWeishiGridTwoItemViewHolder.a, localURL, false, paramRIJDataManager.a().A());
    paramWeishiGridTwoItemViewHolder.a.setTag(paramWeishiGridTwoItemViewHolder);
    paramWeishiGridTwoItemViewHolder.a.setOnClickListener(paramOnClickListener);
    paramWeishiGridTwoItemViewHolder.a.setOnLongClickListener(paramOnLongClickListener);
    VideoFeedsHelper.a(localAbsBaseArticleInfo.mVideoArticleSubsText, localAbsBaseArticleInfo.mVideoArticleSubsColor, paramWeishiGridTwoItemViewHolder.e);
    localAbsBaseArticleInfo = paramWeishiGridTwoItemViewHolder.l;
    paramWeishiGridTwoItemViewHolder.g.setText(localAbsBaseArticleInfo.mTitle);
    paramWeishiGridTwoItemViewHolder.g.getPaint().setFakeBoldText(true);
    paramWeishiGridTwoItemViewHolder.h.setText(VideoFeedsHelper.c(localAbsBaseArticleInfo.mVideoPlayCount));
    paramWeishiGridTwoItemViewHolder.h.setCompoundDrawables(paramAbsBaseArticleInfo, null, null, null);
    paramWeishiGridTwoItemViewHolder.h.setCompoundDrawablePadding(ViewUtils.dpToPx(3.0F));
    VideoFeedsHelper.a(paramWeishiGridTwoItemViewHolder.i, localAbsBaseArticleInfo.getCommentCount(), HardCodeUtil.a(2131910250), "0");
    paramAbsBaseArticleInfo = localAbsBaseArticleInfo.getVideoCoverUrlWithSmartCut(true);
    a(paramWeishiGridTwoItemViewHolder.f, paramAbsBaseArticleInfo, false, paramRIJDataManager.a().A());
    paramWeishiGridTwoItemViewHolder.f.setTag(paramWeishiGridTwoItemViewHolder);
    paramWeishiGridTwoItemViewHolder.f.setOnClickListener(paramOnClickListener);
    paramWeishiGridTwoItemViewHolder.f.setOnLongClickListener(paramOnLongClickListener);
    VideoFeedsHelper.a(localAbsBaseArticleInfo.mVideoArticleSubsText, localAbsBaseArticleInfo.mVideoArticleSubsColor, paramWeishiGridTwoItemViewHolder.j);
  }
  
  private static void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, TextView paramTextView1, View paramView1, TextView paramTextView2, KandianUrlImageView paramKandianUrlImageView, View paramView2, Context paramContext)
  {
    int i = ReadInJoyHelper.F();
    boolean bool = ReadInJoyHelper.G();
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
      paramTextView1 = new URL(paramAbsBaseArticleInfo.familyCommentInfo.a);
      if (paramAbsBaseArticleInfo.familyCommentInfo.d > 0) {
        a(paramKandianUrlImageView, paramTextView1, paramAbsBaseArticleInfo.familyCommentInfo.c, paramAbsBaseArticleInfo.familyCommentInfo.d, paramContext);
      }
      paramKandianUrlImageView.setOnClickListener(new RIJConfigVideoItem.6(paramContext, paramAbsBaseArticleInfo.familyCommentInfo.b, paramView2));
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
    VideoFeedsHelper.a(paramTextView2, paramAbsBaseArticleInfo.getCommentCount(), HardCodeUtil.a(2131910437), "0");
  }
  
  private static void b(VideoColumnItemViewHolder paramVideoColumnItemViewHolder, AbsBaseArticleInfo paramAbsBaseArticleInfo, RIJDataManager paramRIJDataManager)
  {
    Object localObject2;
    if (paramAbsBaseArticleInfo.mXGFileSize <= 0L)
    {
      paramVideoColumnItemViewHolder.n.setText(HardCodeUtil.a(2131910506));
    }
    else
    {
      localObject1 = paramVideoColumnItemViewHolder.n;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(VideoFeedsHelper.c(paramAbsBaseArticleInfo.mXGFileSize));
      ((StringBuilder)localObject2).append(HardCodeUtil.a(2131910298));
      ((TextView)localObject1).setText(((StringBuilder)localObject2).toString());
    }
    if (NetworkUtil.isWifiConnected(paramRIJDataManager.a().A()))
    {
      paramVideoColumnItemViewHolder.m.setVisibility(0);
      paramVideoColumnItemViewHolder.n.setVisibility(8);
      paramVideoColumnItemViewHolder.p.setVisibility(0);
      paramVideoColumnItemViewHolder.o.setBackgroundColor(0);
      return;
    }
    paramVideoColumnItemViewHolder.m.setVisibility(8);
    Object localObject1 = paramRIJDataManager.a().A().getResources().getDrawable(2130844245);
    paramVideoColumnItemViewHolder.n.setCompoundDrawablesWithIntrinsicBounds((Drawable)localObject1, null, null, null);
    paramVideoColumnItemViewHolder.n.setCompoundDrawablePadding(AIOUtils.b(6.0F, paramRIJDataManager.a().A().getResources()));
    paramVideoColumnItemViewHolder.n.setVisibility(0);
    if (CUKingCardUtils.a() == 1)
    {
      paramVideoColumnItemViewHolder.n.setText(HardCodeUtil.a(2131910502));
      paramVideoColumnItemViewHolder.q.setVisibility(8);
      paramVideoColumnItemViewHolder.p.setVisibility(0);
      paramVideoColumnItemViewHolder.o.setBackgroundColor(0);
      return;
    }
    if ((RIJKingCardConfigSp.a()) && (!paramRIJDataManager.a().p()) && (paramVideoColumnItemViewHolder.P == 0))
    {
      localObject2 = RIJKingCardConfigSp.b();
      String str1 = RIJKingCardConfigSp.c();
      String str2 = RIJKingCardConfigSp.d();
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject1 = RIJQQAppInterfaceUtil.a();
        if (localObject1 != null) {
          localObject1 = ((QQAppInterface)localObject1).getCurrentAccountUin();
        } else {
          localObject1 = "";
        }
        paramAbsBaseArticleInfo = new VideoR5.Builder(null, null, null, null).o((String)localObject1).k(paramAbsBaseArticleInfo.innerUniqueID).b().a();
        paramVideoColumnItemViewHolder.q.setVisibility(0);
        paramVideoColumnItemViewHolder.q.setCompoundDrawablePadding(AIOUtils.b(2.0F, paramRIJDataManager.a().A().getResources()));
        localObject1 = paramRIJDataManager.a().A().getResources().getDrawable(2130844046);
        ((Drawable)localObject1).setBounds(0, 0, AIOUtils.b(10.0F, paramRIJDataManager.a().A().getResources()), AIOUtils.b(10.0F, paramRIJDataManager.a().A().getResources()));
        paramVideoColumnItemViewHolder.q.setCompoundDrawables(null, null, (Drawable)localObject1, null);
        VideoFeedsHelper.b(paramRIJDataManager.a().A(), paramVideoColumnItemViewHolder.q, str1, str2, (String)localObject2, new RIJConfigVideoItem.5(paramAbsBaseArticleInfo));
        paramVideoColumnItemViewHolder.o.setBackgroundColor(1711276032);
        paramVideoColumnItemViewHolder.p.setVisibility(0);
        paramRIJDataManager.a().c(true);
        PublicAccountReportUtils.a(null, "", "0X8009BE1", "0X8009BE1", 0, 0, "", "", "", paramAbsBaseArticleInfo, false);
        return;
      }
      paramVideoColumnItemViewHolder.q.setVisibility(8);
      paramVideoColumnItemViewHolder.p.setVisibility(0);
      paramVideoColumnItemViewHolder.o.setBackgroundColor(0);
      if (QLog.isColorLevel()) {
        QLog.w("Q.readinjoy.video", 2, "kingcard guideUrl is empty, so ignore");
      }
    }
    else
    {
      paramVideoColumnItemViewHolder.q.setVisibility(8);
      paramVideoColumnItemViewHolder.p.setVisibility(0);
      paramVideoColumnItemViewHolder.o.setBackgroundColor(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.RIJConfigVideoItem
 * JD-Core Version:    0.7.0.1
 */