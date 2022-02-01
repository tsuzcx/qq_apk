package com.tencent.mobileqq.kandian.biz.fastweb.item;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.util.api.IPublicAccountHttpDownloader;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.kandian.base.utils.ReadInJoyDisplayUtils;
import com.tencent.mobileqq.kandian.base.utils.TimeUtil;
import com.tencent.mobileqq.kandian.base.utils.api.IReadInJoyTimeUtils;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.fastweb.FastWebActivity;
import com.tencent.mobileqq.kandian.biz.fastweb.data.RecommendData;
import com.tencent.mobileqq.kandian.biz.fastweb.data.VideoRecommendData;
import com.tencent.mobileqq.kandian.biz.fastweb.entity.BaseItemViewHolder;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsHelper;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicManager;
import com.tencent.mobileqq.kandian.repo.db.struct.BaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.fastweb.FastWebModule;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.BaseData;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FastWebArticleInfo;
import com.tencent.mobileqq.qroute.QRoute;

class WebFastRecommendCreator$RecommendViewHolder
  extends BaseItemViewHolder
  implements View.OnClickListener
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private TextView c;
  private TextView d;
  
  public WebFastRecommendCreator$RecommendViewHolder(View paramView, BaseData paramBaseData)
  {
    super(paramView, paramBaseData);
    paramView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131369181));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379930));
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131370041);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369549));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379972));
    this.c = ((TextView)paramView.findViewById(2131379607));
    this.d = ((TextView)paramView.findViewById(2131379500));
  }
  
  private AbsBaseArticleInfo a(RecommendData paramRecommendData)
  {
    BaseArticleInfo localBaseArticleInfo = new BaseArticleInfo();
    if (paramRecommendData.jdField_b_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo != null)
    {
      localBaseArticleInfo.mChannelID = paramRecommendData.jdField_b_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mChannelID;
      localBaseArticleInfo.mStrategyId = paramRecommendData.jdField_b_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mStrategyId;
      localBaseArticleInfo.mAlgorithmID = paramRecommendData.jdField_b_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mAlgorithmID;
    }
    localBaseArticleInfo.mTitle = paramRecommendData.jdField_a_of_type_JavaLangString;
    localBaseArticleInfo.mFirstPagePicUrl = paramRecommendData.jdField_b_of_type_JavaLangString;
    localBaseArticleInfo.mArticleContentUrl = paramRecommendData.c;
    localBaseArticleInfo.mArticleID = paramRecommendData.jdField_b_of_type_Long;
    localBaseArticleInfo.mSubscribeID = paramRecommendData.jdField_e_of_type_JavaLangString;
    localBaseArticleInfo.mSubscribeName = paramRecommendData.jdField_d_of_type_JavaLangString;
    localBaseArticleInfo.innerUniqueID = paramRecommendData.jdField_f_of_type_JavaLangString;
    return localBaseArticleInfo;
  }
  
  private void a()
  {
    int i = ((RecommendData)this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityBaseData).jdField_a_of_type_Int;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i == 3) {
          return;
        }
        throw new IllegalArgumentException();
      }
      a((VideoRecommendData)this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityBaseData);
      return;
    }
    a((RecommendData)this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityBaseData);
  }
  
  private void a(RecommendData paramRecommendData)
  {
    TimeUtil.b("fast_web_show_light_house_1");
    Object localObject = (QQAppInterface)ReadInJoyUtils.a();
    if (localObject != null)
    {
      localObject = ((ReadInJoyLogicManager)((QQAppInterface)localObject).getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER)).getReadInJoyLogicEngine().a();
      if (localObject != null) {
        ((FastWebModule)localObject).a(paramRecommendData.c, paramRecommendData.jdField_f_of_type_JavaLangString, paramRecommendData.jdField_e_of_type_JavaLangString, 1, null);
      }
    }
    a(paramRecommendData, null);
  }
  
  private void a(RecommendData paramRecommendData, FastWebArticleInfo paramFastWebArticleInfo)
  {
    ReadInJoyLogicEngine.a().a(paramRecommendData.jdField_b_of_type_Long, System.currentTimeMillis());
    TimeUtil.a("FastWebActivity.show");
    paramFastWebArticleInfo = new Intent(this.jdField_a_of_type_AndroidViewView.getContext(), FastWebActivity.class);
    paramFastWebArticleInfo.putExtra("fast_web_article_info", a(paramRecommendData));
    paramFastWebArticleInfo.putExtra("fast_web_from_article_recommend", true);
    if ((this.jdField_a_of_type_AndroidViewView.getContext() instanceof FastWebActivity)) {
      ((FastWebActivity)this.jdField_a_of_type_AndroidViewView.getContext()).a(paramFastWebArticleInfo);
    }
  }
  
  private void a(VideoRecommendData paramVideoRecommendData)
  {
    if (paramVideoRecommendData == null) {
      return;
    }
    VideoFeedsHelper.a((Activity)this.jdField_a_of_type_AndroidViewView.getContext(), null, 10, paramVideoRecommendData.jdField_f_of_type_JavaLangString, paramVideoRecommendData.g, paramVideoRecommendData.h, paramVideoRecommendData.jdField_e_of_type_Int, paramVideoRecommendData.jdField_f_of_type_Int, paramVideoRecommendData.jdField_d_of_type_Int, paramVideoRecommendData.jdField_a_of_type_JavaLangString, paramVideoRecommendData.jdField_b_of_type_JavaLangString, paramVideoRecommendData.c, paramVideoRecommendData.jdField_d_of_type_JavaLangString, paramVideoRecommendData.jdField_e_of_type_JavaLangString, 0L, false, 0L, 0, null, null, null, null, null);
  }
  
  private void c()
  {
    RecommendData localRecommendData = (RecommendData)this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityBaseData;
  }
  
  public void a(BaseData paramBaseData1, BaseData paramBaseData2, boolean paramBoolean)
  {
    if (paramBaseData2.u == 6)
    {
      paramBaseData1 = (RecommendData)paramBaseData2;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramBaseData1.jdField_a_of_type_JavaLangString);
      paramBaseData2 = URLDrawable.URLDrawableOptions.obtain();
      paramBaseData2.mRequestWidth = AIOUtils.b(88.0F, this.jdField_a_of_type_AndroidViewView.getContext().getResources());
      paramBaseData2.mRequestHeight = AIOUtils.b(68.0F, this.jdField_a_of_type_AndroidViewView.getContext().getResources());
      paramBaseData2.mLoadingDrawable = new ColorDrawable(-2565414);
      paramBaseData2.mPlayGifImage = true;
      paramBaseData2.mMemoryCacheKeySuffix = "fast_web";
      paramBaseData2 = URLDrawable.getDrawable(((IPublicAccountHttpDownloader)QRoute.api(IPublicAccountHttpDownloader.class)).makeURL(paramBaseData1.jdField_b_of_type_JavaLangString, 4), paramBaseData2);
      if ((paramBaseData2 != null) && (paramBaseData2.getStatus() == 2)) {
        paramBaseData2.restartDownload();
      }
      this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramBaseData2);
      if (paramBaseData1.jdField_a_of_type_Boolean) {
        this.jdField_b_of_type_AndroidViewView.setVisibility(4);
      } else {
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      }
      paramBaseData2 = this.c;
      if (paramBaseData2 != null) {
        paramBaseData2.setText(((IReadInJoyTimeUtils)QRoute.api(IReadInJoyTimeUtils.class)).getMMDDTimeString(paramBaseData1.jdField_a_of_type_Long));
      }
      paramBaseData2 = this.d;
      if (paramBaseData2 != null) {
        paramBaseData2.setText(paramBaseData1.jdField_d_of_type_JavaLangString);
      }
      paramBaseData2 = this.jdField_b_of_type_AndroidWidgetTextView;
      if (paramBaseData2 != null) {
        paramBaseData2.setVisibility(8);
      }
      paramBaseData2 = this.jdField_a_of_type_AndroidWidgetImageView;
      if (paramBaseData2 != null) {
        paramBaseData2.setVisibility(8);
      }
      if (paramBaseData1.jdField_a_of_type_Int == 2)
      {
        paramBaseData2 = this.jdField_b_of_type_AndroidWidgetTextView;
        if (paramBaseData2 != null)
        {
          paramBaseData2.setText(ReadInJoyDisplayUtils.a(((VideoRecommendData)paramBaseData1).jdField_d_of_type_Int));
          this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        }
        paramBaseData1 = this.jdField_a_of_type_AndroidWidgetImageView;
        if (paramBaseData1 != null) {
          paramBaseData1.setVisibility(0);
        }
      }
      return;
    }
    throw new IllegalArgumentException();
  }
  
  public void onClick(View paramView)
  {
    c();
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.item.WebFastRecommendCreator.RecommendViewHolder
 * JD-Core Version:    0.7.0.1
 */