package com.tencent.mobileqq.kandian.biz.pts.component;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.map.geolocation.TencentLocationUtils;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.base.view.widget.KanDianRoundCornerTextView;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;
import com.tencent.mobileqq.kandian.biz.pts.util.PGCShortContentUtils;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.utils.RIJPreParseData;
import com.tencent.mobileqq.kandian.glue.utils.RIJSmartCropUtils;
import com.tencent.mobileqq.kandian.repo.common.RIJItemViewTypeUtils;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.GalleryPGCFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.NewPolymericInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.NewPolymericInfo.PackArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.PGCFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TopicRecommendFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TopicRecommendFeedsInfo.TopicRecommendInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UGCFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.kandian.repo.pts.UtilsForComponent;
import com.tencent.mobileqq.kandian.repo.video.entity.PGCVideoInfo;
import com.tencent.mobileqq.kandian.repo.video.entity.UGCVideoInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class ComponentContentBig
  extends RelativeLayout
  implements ComponentInheritView
{
  CmpCtxt a;
  KandianUrlImageView b;
  KanDianRoundCornerTextView c;
  TextView d;
  protected URL e;
  
  public ComponentContentBig(Context paramContext)
  {
    super(paramContext);
    c(paramContext);
  }
  
  public ComponentContentBig(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    c(paramContext);
  }
  
  public ComponentContentBig(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    c(paramContext);
  }
  
  private void c(Context paramContext)
  {
    this.a = new CmpCtxt();
    a(paramContext);
    a();
  }
  
  private void setPosition(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    TextView localTextView = this.d;
    if (localTextView != null)
    {
      localTextView.setVisibility(8);
      if ((ReadInJoyLogicEngine.a().a(null)) && ((paramAbsBaseArticleInfo instanceof AdvertisementInfo)))
      {
        paramAbsBaseArticleInfo = (AdvertisementInfo)paramAbsBaseArticleInfo;
        if (TextUtils.isEmpty(paramAbsBaseArticleInfo.mAdExtInfo)) {
          return;
        }
      }
    }
    try
    {
      paramAbsBaseArticleInfo = new JSONObject(paramAbsBaseArticleInfo.mAdExtInfo);
      double d1 = paramAbsBaseArticleInfo.getDouble("latitude");
      double d2 = paramAbsBaseArticleInfo.getDouble("longitude");
      paramAbsBaseArticleInfo = ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).getCachedLbsInfo("readinjoy_feed_ad_distance");
      if (paramAbsBaseArticleInfo != null)
      {
        if (paramAbsBaseArticleInfo.mLocation == null) {
          return;
        }
        double d3 = paramAbsBaseArticleInfo.mLocation.mLat02;
        double d4 = paramAbsBaseArticleInfo.mLocation.mLon02;
        if ((d3 >= 0.0D) && (d4 >= 0.0D) && (d1 >= 0.0D))
        {
          if (d2 < 0.0D) {
            return;
          }
          d1 = TencentLocationUtils.distanceBetween(d3, d4, d1, d2);
          paramAbsBaseArticleInfo = ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).distance2String(d1);
          if (!TextUtils.isEmpty(paramAbsBaseArticleInfo))
          {
            this.d.setVisibility(0);
            this.d.setText(paramAbsBaseArticleInfo);
          }
        }
      }
      return;
    }
    catch (Exception paramAbsBaseArticleInfo) {}
  }
  
  public void a() {}
  
  public void a(Context paramContext)
  {
    a(b(paramContext));
  }
  
  public void a(View paramView)
  {
    this.b = ((KandianUrlImageView)paramView.findViewById(2131435435));
    this.c = ((KanDianRoundCornerTextView)paramView.findViewById(2131431431));
    KanDianRoundCornerTextView localKanDianRoundCornerTextView = this.c;
    if (localKanDianRoundCornerTextView != null) {
      localKanDianRoundCornerTextView.setCorner(Utils.dp2px(2.0D));
    }
    this.d = ((TextView)paramView.findViewById(2131427735));
  }
  
  public void a(FeedItemCell.CellListener paramCellListener)
  {
    this.a.a(paramCellListener);
  }
  
  protected void a(IReadInJoyModel paramIReadInJoyModel)
  {
    paramIReadInJoyModel = b(paramIReadInJoyModel);
    KandianUrlImageView localKandianUrlImageView = this.b;
    if (localKandianUrlImageView != null) {
      localKandianUrlImageView.setClickable(false);
    }
    PGCShortContentUtils.a(this.b, getContext(), this.e, paramIReadInJoyModel, new ComponentContentBig.1(this, paramIReadInJoyModel));
  }
  
  protected void a(IReadInJoyModel paramIReadInJoyModel, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (this.c != null) {
      if ((!RIJItemViewTypeUtils.t(paramAbsBaseArticleInfo)) && (!RIJItemViewTypeUtils.s(paramAbsBaseArticleInfo)))
      {
        if ((paramIReadInJoyModel.o() != 27) && ((paramIReadInJoyModel.o() != 18) || (paramAbsBaseArticleInfo.isPGCShortContent())) && (paramIReadInJoyModel.o() != 31) && ((!RIJFeedsType.l(paramAbsBaseArticleInfo)) || (RIJFeedsType.d(paramAbsBaseArticleInfo))))
        {
          StringBuilder localStringBuilder;
          if (paramIReadInJoyModel.o() == 52)
          {
            this.c.setVisibility(0);
            paramIReadInJoyModel = this.c;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(paramAbsBaseArticleInfo.mGalleryPicNumber);
            localStringBuilder.append(HardCodeUtil.a(2131900452));
            paramIReadInJoyModel.setText(localStringBuilder.toString());
            this.c.setCompoundDrawablesWithIntrinsicBounds(2130847560, 0, 0, 0);
            return;
          }
          if ((paramIReadInJoyModel.o() != 48) && (paramIReadInJoyModel.o() != 49))
          {
            this.c.setVisibility(8);
            return;
          }
          if ((paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.t != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.t.h != null))
          {
            this.c.setVisibility(0);
            paramIReadInJoyModel = this.c;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(paramAbsBaseArticleInfo.mSocialFeedInfo.t.h.a);
            localStringBuilder.append(HardCodeUtil.a(2131900502));
            paramIReadInJoyModel.setText(localStringBuilder.toString());
            this.c.setCompoundDrawablesWithIntrinsicBounds(2130847560, 0, 0, 0);
            this.c.setCompoundDrawablePadding(AIOUtils.b(2.0F, getContext().getResources()));
          }
        }
        else
        {
          this.c.setVisibility(0);
          this.c.setText(2131915224);
          this.c.setCompoundDrawablesWithIntrinsicBounds(2130843787, 0, 0, 0);
        }
      }
      else
      {
        this.c.setVisibility(0);
        this.c.setText(2131915539);
        this.c.setCompoundDrawablesWithIntrinsicBounds(2130844096, 0, 0, 0);
      }
    }
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof IReadInJoyModel))
    {
      paramObject = (IReadInJoyModel)paramObject;
      this.a.a(paramObject);
      b();
      AbsBaseArticleInfo localAbsBaseArticleInfo = paramObject.k();
      if (localAbsBaseArticleInfo == null) {
        return;
      }
      a(paramObject);
      setPosition(localAbsBaseArticleInfo);
      a(paramObject, localAbsBaseArticleInfo);
    }
  }
  
  public View b(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(getLayoutId(), this, true);
  }
  
  protected URL b(IReadInJoyModel paramIReadInJoyModel)
  {
    if (ComponentPolymericView.a(paramIReadInJoyModel)) {
      return RIJPreParseData.a(((NewPolymericInfo.PackArticleInfo)paramIReadInJoyModel.k().mNewPolymericInfo.p.get(0)).d, true, true);
    }
    paramIReadInJoyModel = paramIReadInJoyModel.k();
    if ((paramIReadInJoyModel.mSocialFeedInfo != null) && (paramIReadInJoyModel.mSocialFeedInfo.s != null) && (paramIReadInJoyModel.mSocialFeedInfo.s.c.size() > 0)) {
      return RIJPreParseData.a(((UGCVideoInfo)paramIReadInJoyModel.mSocialFeedInfo.s.c.get(0)).d, true, true);
    }
    if ((paramIReadInJoyModel.mSocialFeedInfo != null) && (paramIReadInJoyModel.mSocialFeedInfo.t != null) && (paramIReadInJoyModel.mSocialFeedInfo.t.b.size() > 0)) {
      try
      {
        paramIReadInJoyModel = new URL(RIJSmartCropUtils.a(((PGCVideoInfo)paramIReadInJoyModel.mSocialFeedInfo.t.b.get(0)).d, this.b.getWidth(), this.b.getHeight()));
        return paramIReadInJoyModel;
      }
      catch (MalformedURLException paramIReadInJoyModel)
      {
        QLog.d("ComponentContentBig", 2, paramIReadInJoyModel, new Object[0]);
        return null;
      }
    }
    if ((!RIJItemViewTypeUtils.t(paramIReadInJoyModel)) && (!RIJItemViewTypeUtils.s(paramIReadInJoyModel))) {
      return paramIReadInJoyModel.mSinglePicture;
    }
    if ((paramIReadInJoyModel.mSocialFeedInfo != null) && (paramIReadInJoyModel.mSocialFeedInfo.v != null) && (paramIReadInJoyModel.mSocialFeedInfo.v.g != null) && (paramIReadInJoyModel.mSocialFeedInfo.v.g.size() > 0)) {
      try
      {
        URL localURL = new URL(((TopicRecommendFeedsInfo.TopicRecommendInfo)paramIReadInJoyModel.mSocialFeedInfo.v.g.get(0)).f);
        return localURL;
      }
      catch (MalformedURLException localMalformedURLException)
      {
        QLog.d("ComponentContentBig", 2, localMalformedURLException, new Object[0]);
        return paramIReadInJoyModel.mSinglePicture;
      }
    }
    return paramIReadInJoyModel.mSinglePicture;
  }
  
  public void b()
  {
    if ((!this.a.f()) && (!this.a.h()))
    {
      if (this.a.g())
      {
        localLayoutParams = this.b.getLayoutParams();
        localLayoutParams.width = AIOUtils.b(250.0F, getResources());
        localLayoutParams.height = AIOUtils.b(141.0F, getResources());
        this.b.setLayoutParams(localLayoutParams);
        this.b.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return;
      }
      UtilsForComponent.a(getContext(), this.b);
      return;
    }
    ViewGroup.LayoutParams localLayoutParams = this.b.getLayoutParams();
    localLayoutParams.width = -1;
    localLayoutParams.height = AIOUtils.b(190.0F, getResources());
    this.b.setLayoutParams(localLayoutParams);
    this.b.setScaleType(ImageView.ScaleType.CENTER_CROP);
  }
  
  protected int getLayoutId()
  {
    return 2131626168;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentContentBig
 * JD-Core Version:    0.7.0.1
 */