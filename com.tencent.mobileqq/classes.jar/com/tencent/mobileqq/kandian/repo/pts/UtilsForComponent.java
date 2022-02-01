package com.tencent.mobileqq.kandian.repo.pts;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;
import com.tencent.mobileqq.kandian.base.view.widget.RingAvatarView;
import com.tencent.mobileqq.kandian.glue.pts.util.ProteusSupportUtil;
import com.tencent.mobileqq.kandian.repo.common.RIJItemViewTypeUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FeedsInfoUser;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.articlesummary.articlesummary.FriendRecommendInfo;
import tencent.im.oidb.articlesummary.articlesummary.PackInfo;
import tencent.im.oidb.articlesummary.articlesummary.SpecialTopicInfo;
import tencent.im.oidb.articlesummary.articlesummary.SubscribeInfo;

public class UtilsForComponent
{
  public static Pair<Integer, Integer> a()
  {
    int i = BaseApplicationImpl.getApplication().getResources().getDisplayMetrics().widthPixels;
    return new Pair(Integer.valueOf(i), Integer.valueOf((int)(i * 0.562F)));
  }
  
  public static String a(int paramInt)
  {
    int i = paramInt / 3600;
    int j = (paramInt - i * 60) / 60;
    paramInt %= 60;
    String str1;
    if (j >= 10) {
      str1 = String.valueOf(j);
    } else {
      str1 = String.format("0%d", new Object[] { Integer.valueOf(j) });
    }
    String str2;
    if (paramInt >= 10) {
      str2 = String.valueOf(paramInt);
    } else {
      str2 = String.format("0%d", new Object[] { Integer.valueOf(paramInt) });
    }
    if (i > 0)
    {
      String str3;
      if (i >= 10) {
        str3 = String.valueOf(i);
      } else {
        str3 = String.format("0%d", new Object[] { Integer.valueOf(i) });
      }
      return String.format("%s:%s:%s", new Object[] { str3, str1, str2 });
    }
    return String.format("%s:%s", new Object[] { str1, str2 });
  }
  
  public static void a(Context paramContext, KandianUrlImageView paramKandianUrlImageView)
  {
    paramContext = a();
    int i = ((Integer)paramContext.first).intValue();
    int j = ((Integer)paramContext.second).intValue();
    paramContext = paramKandianUrlImageView.getLayoutParams();
    paramContext.width = i;
    paramContext.height = j;
    paramKandianUrlImageView.setLayoutParams(paramContext);
    paramKandianUrlImageView.setPadding(0, 0, 0, 0);
    paramKandianUrlImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
  }
  
  public static void a(Context paramContext, KandianUrlImageView paramKandianUrlImageView, double paramDouble)
  {
    int i = BaseApplicationImpl.getApplication().getResources().getDisplayMetrics().widthPixels;
    double d = i;
    Double.isNaN(d);
    int j = (int)(d / paramDouble);
    paramContext = new RelativeLayout.LayoutParams(i, j);
    paramContext.width = i;
    paramContext.height = j;
    paramContext.setMargins(0, 0, 0, 0);
    paramKandianUrlImageView.setLayoutParams(paramContext);
    paramKandianUrlImageView.setPadding(0, 0, 0, 0);
    paramKandianUrlImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
  }
  
  public static void a(Context paramContext, KandianUrlImageView paramKandianUrlImageView, boolean paramBoolean)
  {
    paramContext = b();
    int i = ((Integer)paramContext.first).intValue();
    int j = ((Integer)paramContext.second).intValue();
    ViewGroup.LayoutParams localLayoutParams = paramKandianUrlImageView.getLayoutParams();
    paramContext = localLayoutParams;
    if (localLayoutParams == null) {
      if (paramBoolean) {
        paramContext = new LinearLayout.LayoutParams(i, j);
      } else {
        paramContext = new RelativeLayout.LayoutParams(i, j);
      }
    }
    paramContext.width = i;
    paramContext.height = j;
    paramKandianUrlImageView.setLayoutParams(paramContext);
    paramKandianUrlImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
  }
  
  public static void a(Context paramContext, IReadInJoyModel paramIReadInJoyModel, ViewGroup.LayoutParams paramLayoutParams)
  {
    a(paramContext, paramIReadInJoyModel, paramLayoutParams, null);
  }
  
  public static void a(Context paramContext, IReadInJoyModel paramIReadInJoyModel, ViewGroup.LayoutParams paramLayoutParams, View paramView)
  {
    AbsBaseArticleInfo localAbsBaseArticleInfo = paramIReadInJoyModel.k();
    if (localAbsBaseArticleInfo == null)
    {
      QLog.d("UtilsForComponent", 1, "configDividerHeight failed, articleInfo is null.");
      return;
    }
    paramLayoutParams.height = paramContext.getResources().getDimensionPixelSize(2131299541);
    int j = paramIReadInJoyModel.o();
    int i = paramIReadInJoyModel.p();
    if (localAbsBaseArticleInfo.mChannelID == 70L)
    {
      paramLayoutParams.height = Utils.dp2px(5.0D);
      return;
    }
    if (paramIReadInJoyModel.m() == 56)
    {
      paramLayoutParams.height = Utils.dp2px(5.0D);
      return;
    }
    if ((j != 29) && (j != 30) && (i != 29) && (i != 30))
    {
      if (j == 53)
      {
        paramLayoutParams.height = Utils.dp2px(0.5D);
        return;
      }
      if ((localAbsBaseArticleInfo.mChannelID == 0L) && ((j == 6) || (j == 128) || (j == 46)))
      {
        i = 0;
        if (j == 6) {
          i = Utils.dp2px(13.0D);
        } else if (j == 46) {
          i = Utils.dp2px(8.0D);
        } else if (j == 128) {
          i = Utils.dp2px(0.0D);
        }
        if ((paramLayoutParams instanceof LinearLayout.LayoutParams))
        {
          paramContext = (LinearLayout.LayoutParams)paramLayoutParams;
          paramContext.topMargin = i;
          paramContext.leftMargin = Utils.dp2px(6.0D);
          paramContext.rightMargin = Utils.dp2px(6.0D);
        }
        paramLayoutParams.height = Utils.dp2px(0.5D);
        paramView.setBackgroundColor(Color.parseColor("#e5e5e5"));
        return;
      }
      if (ProteusSupportUtil.a(j, i, paramIReadInJoyModel.k()))
      {
        paramLayoutParams.height = Utils.dp2px(5.0D);
        return;
      }
      paramLayoutParams.height = Utils.dp2px(5.0D);
      return;
    }
    paramLayoutParams.height = Utils.dp2px(5.0D);
  }
  
  public static void a(IReadInJoyModel paramIReadInJoyModel, RingAvatarView paramRingAvatarView, ImageView paramImageView)
  {
    if ((paramRingAvatarView != null) && (paramImageView != null))
    {
      if (paramIReadInJoyModel == null) {
        return;
      }
      paramIReadInJoyModel = paramIReadInJoyModel.k();
      if ((paramIReadInJoyModel != null) && (paramIReadInJoyModel.mSocialFeedInfo != null) && (paramIReadInJoyModel.mSocialFeedInfo.c != null))
      {
        if (paramIReadInJoyModel.mSocialFeedInfo.c.b())
        {
          paramRingAvatarView.showStarRing();
          paramImageView.setVisibility(0);
          return;
        }
        paramRingAvatarView.showNormal();
        paramImageView.setVisibility(8);
      }
    }
  }
  
  public static boolean a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    boolean bool2 = false;
    if (paramAbsBaseArticleInfo == null) {
      return false;
    }
    boolean bool1 = bool2;
    if (paramAbsBaseArticleInfo.mFeedType == 1) {
      if (!RIJItemViewTypeUtils.l(paramAbsBaseArticleInfo))
      {
        bool1 = bool2;
        if (!RIJItemViewTypeUtils.p(paramAbsBaseArticleInfo)) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static Pair<Integer, Integer> b()
  {
    Resources localResources = BaseApplicationImpl.getApplication().getResources();
    return new Pair(Integer.valueOf((localResources.getDisplayMetrics().widthPixels - AIOUtils.b(3.0F, localResources)) / 3), Integer.valueOf(localResources.getDimensionPixelSize(2131299547)));
  }
  
  public static boolean b(int paramInt)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramInt != 1)
    {
      bool1 = bool2;
      if (paramInt != 5)
      {
        if (paramInt == 7) {
          return true;
        }
        bool1 = false;
      }
    }
    return bool1;
  }
  
  public static boolean b(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return (RIJItemViewTypeUtils.A(paramAbsBaseArticleInfo) == 23) || (RIJItemViewTypeUtils.B(paramAbsBaseArticleInfo) == 56);
  }
  
  public static int c(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramAbsBaseArticleInfo == null) {
      return 0;
    }
    if ((paramAbsBaseArticleInfo.mPackInfoObj != null) && (paramAbsBaseArticleInfo.mPackInfoObj.pack_type.has()))
    {
      if (paramAbsBaseArticleInfo.mPackInfoObj.pack_type.get() == 2)
      {
        if (paramAbsBaseArticleInfo.mPackInfoObj.msg_special_topic_info.has()) {
          return 1;
        }
        return 0;
      }
      if (paramAbsBaseArticleInfo.mPackInfoObj.pack_type.get() == 3)
      {
        if (paramAbsBaseArticleInfo.mPackInfoObj.msg_friend_recommend_info.has()) {
          return 2;
        }
        return 0;
      }
    }
    else if ((paramAbsBaseArticleInfo.mSubscribeInfoObj != null) && (paramAbsBaseArticleInfo.mSubscribeInfoObj.uint32_is_subscribed.has()) && (paramAbsBaseArticleInfo.mSubscribeInfoObj.uint32_is_subscribed.get() == 1))
    {
      return 3;
    }
    return 0;
  }
  
  public static boolean c(int paramInt)
  {
    return (paramInt == 22) || (paramInt == 21) || (paramInt == 23) || (paramInt == 107) || (paramInt == 108) || (paramInt == 54) || (paramInt == 55) || (paramInt == 56);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.pts.UtilsForComponent
 * JD-Core Version:    0.7.0.1
 */