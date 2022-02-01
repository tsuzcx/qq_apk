package com.tencent.mobileqq.kandian.biz.fastweb.item;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.util.api.IPublicAccountHttpDownloader;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.kandian.ad.api.IRIJFastWebAdService;
import com.tencent.mobileqq.kandian.base.image.PublicDrawableUtil;
import com.tencent.mobileqq.kandian.biz.fastweb.data.AdData;
import com.tencent.mobileqq.kandian.biz.fastweb.data.AttachedAdData;
import com.tencent.mobileqq.kandian.biz.fastweb.entity.BaseItemViewHolder;
import com.tencent.mobileqq.kandian.repo.feeds.entity.BaseData;
import com.tencent.mobileqq.qroute.QRoute;

class WebFastAttachedAdCreator$AdViewHolder
  extends BaseItemViewHolder
  implements View.OnClickListener
{
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private TextView b;
  
  public WebFastAttachedAdCreator$AdViewHolder(View paramView, BaseData paramBaseData)
  {
    super(paramView, paramBaseData);
    paramView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131369181));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379930));
    this.b = ((TextView)paramView.findViewById(2131379613));
    PublicDrawableUtil.a((FrameLayout)paramView.findViewById(2131367043), 0.0F, Color.parseColor("#dedfe0"), 1);
    PublicDrawableUtil.a((TextView)paramView.findViewById(2131379695), AIOUtils.b(2.0F, paramView.getResources()), Color.parseColor("#fa8726"), 1);
    PublicDrawableUtil.a((TextView)paramView.findViewById(2131379811), AIOUtils.b(2.0F, paramView.getResources()), Color.parseColor("#12b7f5"), 1);
  }
  
  public void a(BaseData paramBaseData1, BaseData paramBaseData2, boolean paramBoolean)
  {
    if (paramBaseData2.u == 11)
    {
      paramBaseData1 = (AttachedAdData)paramBaseData2;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramBaseData1.j);
      this.b.setText(paramBaseData1.k);
      paramBaseData2 = URLDrawable.URLDrawableOptions.obtain();
      paramBaseData2.mRequestWidth = AIOUtils.b(85.0F, this.jdField_a_of_type_AndroidViewView.getContext().getResources());
      paramBaseData2.mRequestHeight = AIOUtils.b(72.0F, this.jdField_a_of_type_AndroidViewView.getContext().getResources());
      paramBaseData2.mLoadingDrawable = new ColorDrawable(-2565414);
      paramBaseData2.mPlayGifImage = true;
      paramBaseData2.mMemoryCacheKeySuffix = "fast_web";
      paramBaseData1 = URLDrawable.getDrawable(((IPublicAccountHttpDownloader)QRoute.api(IPublicAccountHttpDownloader.class)).makeURL(paramBaseData1.l, 4), paramBaseData2);
      if ((paramBaseData1 != null) && (paramBaseData1.getStatus() == 2)) {
        paramBaseData1.restartDownload();
      }
      this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramBaseData1);
      return;
    }
    throw new IllegalArgumentException();
  }
  
  public void onClick(View paramView)
  {
    ((IRIJFastWebAdService)QRoute.api(IRIJFastWebAdService.class)).jumpAd((Activity)paramView.getContext(), (AdData)this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityBaseData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.item.WebFastAttachedAdCreator.AdViewHolder
 * JD-Core Version:    0.7.0.1
 */