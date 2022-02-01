package com.tencent.mobileqq.kandian.biz.fastweb.item;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.kandian.base.image.api.impl.PublicAccountHttpDownloaderImpl;
import com.tencent.mobileqq.kandian.base.utils.ReadInJoyDisplayUtils;
import com.tencent.mobileqq.kandian.base.utils.ReadInJoyTimeUtils;
import com.tencent.mobileqq.kandian.base.utils.TimeUtil;
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

class WebFastRecommendCreator$RecommendViewHolder
  extends BaseItemViewHolder
  implements View.OnClickListener
{
  private URLImageView a;
  private TextView b;
  private View c;
  private ImageView d;
  private TextView n;
  private TextView o;
  private TextView p;
  
  public WebFastRecommendCreator$RecommendViewHolder(View paramView, BaseData paramBaseData)
  {
    super(paramView, paramBaseData);
    paramView.setOnClickListener(this);
    this.a = ((URLImageView)paramView.findViewById(2131436155));
    this.b = ((TextView)paramView.findViewById(2131448814));
    this.c = paramView.findViewById(2131437197);
    this.d = ((ImageView)paramView.findViewById(2131436652));
    this.n = ((TextView)paramView.findViewById(2131448869));
    this.o = ((TextView)paramView.findViewById(2131448369));
    this.p = ((TextView)paramView.findViewById(2131448247));
  }
  
  private void a()
  {
    int i = ((RecommendData)this.g).i;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i == 3) {
          return;
        }
        throw new IllegalArgumentException();
      }
      a((VideoRecommendData)this.g);
      return;
    }
    a((RecommendData)this.g);
  }
  
  private void a(RecommendData paramRecommendData)
  {
    TimeUtil.b("fast_web_show_light_house_1");
    Object localObject = (QQAppInterface)ReadInJoyUtils.b();
    if (localObject != null)
    {
      localObject = ((ReadInJoyLogicManager)((QQAppInterface)localObject).getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER)).getReadInJoyLogicEngine().d();
      if (localObject != null) {
        ((FastWebModule)localObject).a(paramRecommendData.c, paramRecommendData.h, paramRecommendData.g, 1, null);
      }
    }
    a(paramRecommendData, null);
  }
  
  private void a(RecommendData paramRecommendData, FastWebArticleInfo paramFastWebArticleInfo)
  {
    ReadInJoyLogicEngine.a().a(paramRecommendData.e, System.currentTimeMillis());
    TimeUtil.a("FastWebActivity.show");
    paramFastWebArticleInfo = new Intent(this.f.getContext(), FastWebActivity.class);
    paramFastWebArticleInfo.putExtra("fast_web_article_info", b(paramRecommendData));
    paramFastWebArticleInfo.putExtra("fast_web_from_article_recommend", true);
    if ((this.f.getContext() instanceof FastWebActivity)) {
      ((FastWebActivity)this.f.getContext()).a(paramFastWebArticleInfo);
    }
  }
  
  private void a(VideoRecommendData paramVideoRecommendData)
  {
    if (paramVideoRecommendData == null) {
      return;
    }
    VideoFeedsHelper.a((Activity)this.f.getContext(), null, 10, paramVideoRecommendData.h, paramVideoRecommendData.r, paramVideoRecommendData.q, paramVideoRecommendData.o, paramVideoRecommendData.p, paramVideoRecommendData.n, paramVideoRecommendData.a, paramVideoRecommendData.b, paramVideoRecommendData.c, paramVideoRecommendData.f, paramVideoRecommendData.g, 0L, false, 0L, 0, null, null, null, null, null);
  }
  
  private AbsBaseArticleInfo b(RecommendData paramRecommendData)
  {
    BaseArticleInfo localBaseArticleInfo = new BaseArticleInfo();
    if (paramRecommendData.aQ != null)
    {
      localBaseArticleInfo.mChannelID = paramRecommendData.aQ.mChannelID;
      localBaseArticleInfo.mStrategyId = paramRecommendData.aQ.mStrategyId;
      localBaseArticleInfo.mAlgorithmID = paramRecommendData.aQ.mAlgorithmID;
    }
    localBaseArticleInfo.mTitle = paramRecommendData.a;
    localBaseArticleInfo.mFirstPagePicUrl = paramRecommendData.b;
    localBaseArticleInfo.mArticleContentUrl = paramRecommendData.c;
    localBaseArticleInfo.mArticleID = paramRecommendData.e;
    localBaseArticleInfo.mSubscribeID = paramRecommendData.g;
    localBaseArticleInfo.mSubscribeName = paramRecommendData.f;
    localBaseArticleInfo.innerUniqueID = paramRecommendData.h;
    return localBaseArticleInfo;
  }
  
  private void c()
  {
    RecommendData localRecommendData = (RecommendData)this.g;
  }
  
  public void a(BaseData paramBaseData1, BaseData paramBaseData2, boolean paramBoolean)
  {
    if (paramBaseData2.aP == 6)
    {
      paramBaseData1 = (RecommendData)paramBaseData2;
      this.b.setText(paramBaseData1.a);
      paramBaseData2 = URLDrawable.URLDrawableOptions.obtain();
      paramBaseData2.mRequestWidth = AIOUtils.b(88.0F, this.f.getContext().getResources());
      paramBaseData2.mRequestHeight = AIOUtils.b(68.0F, this.f.getContext().getResources());
      paramBaseData2.mLoadingDrawable = new ColorDrawable(-2565414);
      paramBaseData2.mPlayGifImage = true;
      paramBaseData2.mMemoryCacheKeySuffix = "fast_web";
      paramBaseData2 = URLDrawable.getDrawable(new PublicAccountHttpDownloaderImpl().makeURL(paramBaseData1.b, 4), paramBaseData2);
      if ((paramBaseData2 != null) && (paramBaseData2.getStatus() == 2)) {
        paramBaseData2.restartDownload();
      }
      this.a.setImageDrawable(paramBaseData2);
      if (paramBaseData1.m) {
        this.c.setVisibility(4);
      } else {
        this.c.setVisibility(0);
      }
      paramBaseData2 = this.o;
      if (paramBaseData2 != null) {
        paramBaseData2.setText(ReadInJoyTimeUtils.INSTANCE.getMMDDTimeString(paramBaseData1.d));
      }
      paramBaseData2 = this.p;
      if (paramBaseData2 != null) {
        paramBaseData2.setText(paramBaseData1.f);
      }
      paramBaseData2 = this.n;
      if (paramBaseData2 != null) {
        paramBaseData2.setVisibility(8);
      }
      paramBaseData2 = this.d;
      if (paramBaseData2 != null) {
        paramBaseData2.setVisibility(8);
      }
      if (paramBaseData1.i == 2)
      {
        paramBaseData2 = this.n;
        if (paramBaseData2 != null)
        {
          paramBaseData2.setText(ReadInJoyDisplayUtils.a(((VideoRecommendData)paramBaseData1).n));
          this.n.setVisibility(0);
        }
        paramBaseData1 = this.d;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.item.WebFastRecommendCreator.RecommendViewHolder
 * JD-Core Version:    0.7.0.1
 */