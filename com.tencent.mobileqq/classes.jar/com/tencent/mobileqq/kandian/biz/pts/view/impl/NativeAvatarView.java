package com.tencent.mobileqq.kandian.biz.pts.view.impl;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import androidx.annotation.UiThread;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IView;
import com.tencent.mobileqq.kandian.base.view.widget.RingAvatarView;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyVIconHelper;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.common.widget.NativeReadInjoyImageView;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyHeadImageView;
import com.tencent.mobileqq.kandian.biz.framework.RIJAppSetting;
import com.tencent.mobileqq.kandian.biz.pts.component.CmpCtxt;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyUserInfoModule.RefreshUserInfoCallBack;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils;
import com.tencent.mobileqq.kandian.repo.common.RIJItemViewTypeUtils;
import com.tencent.mobileqq.kandian.repo.common.constant.ReadInJoyConstants;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FeedsInfoUser;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ReadInJoyUserInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.qav.thread.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.articlesummary.articlesummary.PartnerAccountInfo;

public class NativeAvatarView
  extends RingAvatarView
  implements IView, IReadInJoyUserInfoModule.RefreshUserInfoCallBack
{
  public static final String TAG = "NativeAvatarView";
  private ReadInJoyHeadImageView avatar;
  private ImageView background;
  private NativeReadInjoyImageView iconV;
  private Drawable iconVPlaceHolder = new ColorDrawable(0);
  private boolean isLive;
  private long lastRefreshTime;
  private NativeReadInjoyImageView liveRing;
  private Drawable liveRingPlaceHolder = new ColorDrawable(0);
  private String liveRingUrl;
  private NativeReadInjoyImageView liveStatus;
  private Drawable liveStatusPlaceHolder = new ColorDrawable(0);
  private String liveStatusUrl;
  private CmpCtxt mCtxt = new CmpCtxt();
  private long refreshMinInterval = 1000L;
  private long uin;
  private ReadInJoyUserInfo userInfo;
  
  public NativeAvatarView(Context paramContext)
  {
    super(paramContext);
    initView(paramContext);
  }
  
  public NativeAvatarView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initView(paramContext);
  }
  
  private void adjustRingMargin()
  {
    if (this.liveRing != null)
    {
      int i = -(int)(getWidth() * 0.076F);
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.liveRing.getLayoutParams();
      localLayoutParams.bottomMargin = i;
      localLayoutParams.topMargin = i;
      localLayoutParams.rightMargin = i;
      localLayoutParams.leftMargin = i;
      this.liveRing.setLayoutParams(localLayoutParams);
    }
  }
  
  private boolean canRefreshInTimeLimit()
  {
    return System.currentTimeMillis() - this.lastRefreshTime > this.refreshMinInterval;
  }
  
  private void doReport(String paramString)
  {
    Object localObject2 = this.mCtxt.a.a();
    if (localObject2 == null) {
      return;
    }
    Object localObject1;
    if (RIJItemViewTypeUtils.m((AbsBaseArticleInfo)localObject2)) {
      localObject1 = "3";
    } else if (RIJItemViewTypeUtils.a((AbsBaseArticleInfo)localObject2)) {
      localObject1 = "4";
    } else {
      localObject1 = "1";
    }
    String str = RIJTransMergeKanDianReport.a((String)localObject1, (AbsBaseArticleInfo)localObject2, this.uin);
    if (ReadinjoyReportUtils.a(((AbsBaseArticleInfo)localObject2).mChannelID)) {
      localObject1 = "0X800935C";
    } else {
      localObject1 = "0X8007BA3";
    }
    IPublicAccountReportUtils localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
    long l1 = this.uin;
    long l2 = ((AbsBaseArticleInfo)localObject2).mFeedId;
    long l3 = ((AbsBaseArticleInfo)localObject2).mArticleID;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(((AbsBaseArticleInfo)localObject2).mStrategyId);
    localIPublicAccountReportUtils.publicAccountReportClickEvent(null, String.valueOf(l1), (String)localObject1, (String)localObject1, 0, 0, String.valueOf(l2), String.valueOf(l3), localStringBuilder.toString(), str, false);
    for (;;)
    {
      try
      {
        localObject1 = RIJTransMergeKanDianReport.a();
        ((JSONObject)localObject1).put("feeds_source", paramString);
        ((JSONObject)localObject1).put("kandian_mode", RIJAppSetting.a());
        localObject2 = RIJFeedsType.d(this.mCtxt.a.a());
        if (ReadinjoyReportUtils.a(this.mCtxt.a.c()))
        {
          paramString = "0X8009357";
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", paramString, paramString, 0, 0, (String)localObject2, "", "", ((JSONObject)localObject1).toString(), false);
          return;
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return;
      }
      paramString = "0X800744D";
    }
  }
  
  @NotNull
  private String getIConVUrl(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramAbsBaseArticleInfo.mPartnerAccountInfo != null) {
      return paramAbsBaseArticleInfo.mPartnerAccountInfo.bytes_v_icon_url.get().toStringUtf8();
    }
    return "";
  }
  
  private void initView(Context paramContext)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2131560098, this);
    this.background = ((ImageView)paramContext.findViewById(2131363349));
    this.background.setImageResource(2130849763);
    this.background.setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.background.setVisibility(8);
    this.liveRing = ((NativeReadInjoyImageView)paramContext.findViewById(2131376605));
    this.liveRing.setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.liveRing.setImagePlaceHolder(this.liveRingPlaceHolder);
    this.liveRing.setVisibility(8);
    this.avatar = ((ReadInJoyHeadImageView)paramContext.findViewById(2131363135));
    this.avatar.setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.iconV = ((NativeReadInjoyImageView)paramContext.findViewById(2131368391));
    this.iconV.setImageResource(2130842994);
    this.iconV.setVisibility(8);
    this.iconV.setImagePlaceHolder(this.iconVPlaceHolder);
    this.liveStatus = ((NativeReadInjoyImageView)paramContext.findViewById(2131370201));
    this.liveStatus.setImagePlaceHolder(this.liveStatusPlaceHolder);
    this.liveStatus.setVisibility(8);
    setLayerType(1, null);
  }
  
  private void setIConVType(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramAbsBaseArticleInfo.mSocialFeedInfo.a.a == 1)
    {
      this.iconV.setVisibility(0);
      return;
    }
    this.iconV.setVisibility(8);
  }
  
  private void setIConVUrl(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.iconV.setVisibility(0);
      try
      {
        this.iconV.setImage(new URL(paramString));
        return;
      }
      catch (Exception paramString)
      {
        QLog.e("NativeAvatarView", 2, paramString, new Object[0]);
        return;
      }
    }
    this.iconV.setVisibility(8);
  }
  
  private void showLive()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isLive: ");
    localStringBuilder.append(this.isLive);
    localStringBuilder.append(" liveCircle:  liveStatus: ");
    localStringBuilder.append(this.liveStatusUrl);
    QLog.d("NativeAvatarView", 1, localStringBuilder.toString());
    showLiveRing();
    showLiveStatus();
  }
  
  @UiThread
  private void showLiveRing()
  {
    if ((this.liveRing != null) && (this.background != null) && (this.iconV != null))
    {
      if ((TextUtils.isEmpty(this.liveRingUrl) ^ true))
      {
        this.liveRing.setVisibility(0);
        this.liveRing.setImageSrc(this.liveRingUrl);
        this.background.setVisibility(8);
        this.iconV.setVisibility(8);
        adjustRingMargin();
        return;
      }
      this.liveRing.setVisibility(8);
    }
  }
  
  @UiThread
  private void showLiveStatus()
  {
    if ((this.liveStatus != null) && (this.background != null) && (this.iconV != null))
    {
      if ((TextUtils.isEmpty(this.liveStatusUrl) ^ true))
      {
        this.liveStatus.setVisibility(0);
        this.liveStatus.setImageSrc(this.liveStatusUrl);
        this.background.setVisibility(8);
        this.iconV.setVisibility(8);
        return;
      }
      this.liveStatus.setVisibility(8);
    }
  }
  
  public void bindStarStyle(IReadInJoyModel paramIReadInJoyModel)
  {
    if (paramIReadInJoyModel == null) {
      return;
    }
    paramIReadInJoyModel = paramIReadInJoyModel.a();
    if ((paramIReadInJoyModel != null) && (paramIReadInJoyModel.mSocialFeedInfo != null) && (paramIReadInJoyModel.mSocialFeedInfo.a != null))
    {
      if (paramIReadInJoyModel.mSocialFeedInfo.a.a())
      {
        this.background.setVisibility(0);
        return;
      }
      this.background.setVisibility(8);
    }
  }
  
  public void comLayout(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    onComLayout(true, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public int getComMeasuredHeight()
  {
    return getMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return getMeasuredWidth();
  }
  
  public void measureComponent(int paramInt1, int paramInt2)
  {
    onComMeasure(paramInt1, paramInt2);
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    layout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    measure(paramInt1, paramInt2);
  }
  
  public void onHeadClick()
  {
    if ((this.mCtxt.a != null) && (this.mCtxt.a.a() != null))
    {
      com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils.a = this.mCtxt.a.a();
      Object localObject;
      if (this.mCtxt.a.d() == 34)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(ReadInJoyConstants.k);
        ((StringBuilder)localObject).append(Base64Util.encodeToString(String.valueOf(this.uin).getBytes(), 2));
        localObject = ((StringBuilder)localObject).toString();
        ReadInJoyUtils.a(getContext(), (String)localObject);
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(ReadInJoyConstants.g);
        ((StringBuilder)localObject).append(Base64Util.encodeToString(String.valueOf(this.uin).getBytes(), 2));
        localObject = ((StringBuilder)localObject).toString();
        ReadInJoyUtils.a(getContext(), (String)localObject);
      }
      doReport(RIJFeedsType.c(this.mCtxt.a.a()));
    }
  }
  
  public void onLoadUserInfoFailed(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onLoadUserInfoFailed: ");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(" ");
    localStringBuilder.append(paramString2);
    QLog.d("NativeAvatarView", 1, localStringBuilder.toString());
  }
  
  public void onLoadUserInfoSucceed(String paramString, ReadInJoyUserInfo paramReadInJoyUserInfo)
  {
    this.userInfo = paramReadInJoyUserInfo;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("load uin success: ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" ");
    localStringBuilder.append(paramReadInJoyUserInfo);
    QLog.d("NativeAvatarView", 1, localStringBuilder.toString());
    if (paramReadInJoyUserInfo != null) {
      this.isLive = paramReadInJoyUserInfo.isLiving();
    }
    ThreadManager.a().post(new NativeAvatarView.1(this));
  }
  
  public void refresh(boolean paramBoolean)
  {
    this.lastRefreshTime = System.currentTimeMillis();
    this.avatar.setHeadImgByUin(this.uin, paramBoolean, this);
  }
  
  public void setAvatarDrawable(Drawable paramDrawable)
  {
    this.avatar.setImageDrawable(paramDrawable);
    this.iconV.setVisibility(8);
  }
  
  public void setLiveRingUrl(String paramString)
  {
    this.liveRingUrl = paramString;
    ThreadManager.a().post(new NativeAvatarView.2(this));
  }
  
  public void setLiveStatusUrl(String paramString)
  {
    this.liveStatusUrl = paramString;
    ThreadManager.a().post(new NativeAvatarView.3(this));
  }
  
  public void setModel(IReadInJoyModel paramIReadInJoyModel)
  {
    setModel(paramIReadInJoyModel, true);
  }
  
  public void setModel(IReadInJoyModel paramIReadInJoyModel, boolean paramBoolean)
  {
    this.mCtxt.a(paramIReadInJoyModel);
    if ((paramIReadInJoyModel != null) && (canRefreshInTimeLimit())) {
      refresh(paramBoolean);
    }
  }
  
  public void setUin(long paramLong)
  {
    if ((!canRefreshInTimeLimit()) && (paramLong == this.uin)) {
      return;
    }
    this.uin = paramLong;
    refresh(true);
  }
  
  @UiThread
  protected void showIconV()
  {
    if ((TextUtils.isEmpty(this.liveStatusUrl)) && (TextUtils.isEmpty(this.liveRingUrl)))
    {
      Object localObject = this.mCtxt;
      if ((localObject != null) && (((CmpCtxt)localObject).a != null))
      {
        localObject = this.mCtxt.a.a();
        if (localObject == null)
        {
          this.iconV.setVisibility(8);
          return;
        }
        this.iconV.setImageResource(2130842994);
        if (((AbsBaseArticleInfo)localObject).isAccountShown) {
          setIConVUrl(getIConVUrl((AbsBaseArticleInfo)localObject));
        } else if ((((AbsBaseArticleInfo)localObject).mSocialFeedInfo != null) && (((AbsBaseArticleInfo)localObject).mSocialFeedInfo.a != null)) {
          setIConVType((AbsBaseArticleInfo)localObject);
        } else {
          this.iconV.setVisibility(8);
        }
        bindStarStyle(this.mCtxt.a);
      }
      ReadInJoyVIconHelper.a(this.userInfo, this.iconV);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.view.impl.NativeAvatarView
 * JD-Core Version:    0.7.0.1
 */