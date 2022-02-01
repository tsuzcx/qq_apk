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
  TextView jdField_a_of_type_AndroidWidgetTextView;
  KanDianRoundCornerTextView jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianRoundCornerTextView;
  KandianUrlImageView jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView;
  CmpCtxt jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt;
  protected URL a;
  
  public ComponentContentBig(Context paramContext)
  {
    super(paramContext);
    b(paramContext);
  }
  
  public ComponentContentBig(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b(paramContext);
  }
  
  public ComponentContentBig(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b(paramContext);
  }
  
  private void a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
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
            this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
            this.jdField_a_of_type_AndroidWidgetTextView.setText(paramAbsBaseArticleInfo);
          }
        }
      }
      return;
    }
    catch (Exception paramAbsBaseArticleInfo) {}
  }
  
  private void b(Context paramContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt = new CmpCtxt();
    a(paramContext);
    a();
  }
  
  protected int a()
  {
    return 2131560121;
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(a(), this, true);
  }
  
  protected URL a(IReadInJoyModel paramIReadInJoyModel)
  {
    if (ComponentPolymericView.a(paramIReadInJoyModel)) {
      return RIJPreParseData.a(((NewPolymericInfo.PackArticleInfo)paramIReadInJoyModel.a().mNewPolymericInfo.a.get(0)).c, true, true);
    }
    paramIReadInJoyModel = paramIReadInJoyModel.a();
    if ((paramIReadInJoyModel.mSocialFeedInfo != null) && (paramIReadInJoyModel.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo != null) && (paramIReadInJoyModel.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.b.size() > 0)) {
      return RIJPreParseData.a(((UGCVideoInfo)paramIReadInJoyModel.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.b.get(0)).d, true, true);
    }
    if ((paramIReadInJoyModel.mSocialFeedInfo != null) && (paramIReadInJoyModel.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityPGCFeedsInfo != null) && (paramIReadInJoyModel.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityPGCFeedsInfo.b.size() > 0)) {
      try
      {
        paramIReadInJoyModel = new URL(RIJSmartCropUtils.a(((PGCVideoInfo)paramIReadInJoyModel.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityPGCFeedsInfo.b.get(0)).d, this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.getWidth(), this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.getHeight()));
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
    if ((paramIReadInJoyModel.mSocialFeedInfo != null) && (paramIReadInJoyModel.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityTopicRecommendFeedsInfo != null) && (paramIReadInJoyModel.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityTopicRecommendFeedsInfo.a != null) && (paramIReadInJoyModel.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityTopicRecommendFeedsInfo.a.size() > 0)) {
      try
      {
        URL localURL = new URL(((TopicRecommendFeedsInfo.TopicRecommendInfo)paramIReadInJoyModel.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityTopicRecommendFeedsInfo.a.get(0)).d);
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
  
  public void a() {}
  
  public void a(Context paramContext)
  {
    a(a(paramContext));
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView = ((KandianUrlImageView)paramView.findViewById(2131368531));
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianRoundCornerTextView = ((KanDianRoundCornerTextView)paramView.findViewById(2131365260));
    KanDianRoundCornerTextView localKanDianRoundCornerTextView = this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianRoundCornerTextView;
    if (localKanDianRoundCornerTextView != null) {
      localKanDianRoundCornerTextView.setCorner(Utils.dp2px(2.0D));
    }
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362156));
  }
  
  public void a(FeedItemCell.CellListener paramCellListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a(paramCellListener);
  }
  
  protected void a(IReadInJoyModel paramIReadInJoyModel)
  {
    paramIReadInJoyModel = a(paramIReadInJoyModel);
    KandianUrlImageView localKandianUrlImageView = this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView;
    if (localKandianUrlImageView != null) {
      localKandianUrlImageView.setClickable(false);
    }
    PGCShortContentUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView, getContext(), this.jdField_a_of_type_JavaNetURL, paramIReadInJoyModel, new ComponentContentBig.1(this, paramIReadInJoyModel));
  }
  
  protected void a(IReadInJoyModel paramIReadInJoyModel, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianRoundCornerTextView != null) {
      if ((!RIJItemViewTypeUtils.t(paramAbsBaseArticleInfo)) && (!RIJItemViewTypeUtils.s(paramAbsBaseArticleInfo)))
      {
        if ((paramIReadInJoyModel.d() != 27) && ((paramIReadInJoyModel.d() != 18) || (paramAbsBaseArticleInfo.isPGCShortContent())) && (paramIReadInJoyModel.d() != 31) && ((!RIJFeedsType.h(paramAbsBaseArticleInfo)) || (RIJFeedsType.d(paramAbsBaseArticleInfo))))
        {
          StringBuilder localStringBuilder;
          if (paramIReadInJoyModel.d() == 52)
          {
            this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianRoundCornerTextView.setVisibility(0);
            paramIReadInJoyModel = this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianRoundCornerTextView;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(paramAbsBaseArticleInfo.mGalleryPicNumber);
            localStringBuilder.append(HardCodeUtil.a(2131702449));
            paramIReadInJoyModel.setText(localStringBuilder.toString());
            this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianRoundCornerTextView.setCompoundDrawablesWithIntrinsicBounds(2130846090, 0, 0, 0);
            return;
          }
          if ((paramIReadInJoyModel.d() != 48) && (paramIReadInJoyModel.d() != 49))
          {
            this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianRoundCornerTextView.setVisibility(8);
            return;
          }
          if ((paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityPGCFeedsInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityPGCFeedsInfo.a != null))
          {
            this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianRoundCornerTextView.setVisibility(0);
            paramIReadInJoyModel = this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianRoundCornerTextView;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityPGCFeedsInfo.a.a);
            localStringBuilder.append(HardCodeUtil.a(2131702506));
            paramIReadInJoyModel.setText(localStringBuilder.toString());
            this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianRoundCornerTextView.setCompoundDrawablesWithIntrinsicBounds(2130846090, 0, 0, 0);
            this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianRoundCornerTextView.setCompoundDrawablePadding(AIOUtils.b(2.0F, getContext().getResources()));
          }
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianRoundCornerTextView.setVisibility(0);
          this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianRoundCornerTextView.setText(2131717749);
          this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianRoundCornerTextView.setCompoundDrawablesWithIntrinsicBounds(2130842831, 0, 0, 0);
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianRoundCornerTextView.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianRoundCornerTextView.setText(2131718062);
        this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianRoundCornerTextView.setCompoundDrawablesWithIntrinsicBounds(2130843141, 0, 0, 0);
      }
    }
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof IReadInJoyModel))
    {
      paramObject = (IReadInJoyModel)paramObject;
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a(paramObject);
      b();
      AbsBaseArticleInfo localAbsBaseArticleInfo = paramObject.a();
      if (localAbsBaseArticleInfo == null) {
        return;
      }
      a(paramObject);
      a(localAbsBaseArticleInfo);
      a(paramObject, localAbsBaseArticleInfo);
    }
  }
  
  public void b()
  {
    if ((!this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.e()) && (!this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.g()))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.f())
      {
        localLayoutParams = this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.getLayoutParams();
        localLayoutParams.width = AIOUtils.b(250.0F, getResources());
        localLayoutParams.height = AIOUtils.b(141.0F, getResources());
        this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setLayoutParams(localLayoutParams);
        this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return;
      }
      UtilsForComponent.a(getContext(), this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView);
      return;
    }
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.getLayoutParams();
    localLayoutParams.width = -1;
    localLayoutParams.height = AIOUtils.b(190.0F, getResources());
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentContentBig
 * JD-Core Version:    0.7.0.1
 */