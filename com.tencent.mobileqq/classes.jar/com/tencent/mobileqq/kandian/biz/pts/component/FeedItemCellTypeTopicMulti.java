package com.tencent.mobileqq.kandian.biz.pts.component;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TopicRecommendFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TopicRecommendFeedsInfo.TopicRecommendFeedsTitle;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.ArrayList;
import java.util.List;

public class FeedItemCellTypeTopicMulti
  extends FeedItemCell
{
  TextView a;
  TextView b;
  
  public FeedItemCellTypeTopicMulti(Context paramContext, IFaceDecoder paramIFaceDecoder, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    super(paramContext, paramIFaceDecoder, paramReadInJoyBaseAdapter);
  }
  
  public FeedItemCell a()
  {
    return l().t().n();
  }
  
  public FeedItemCell d()
  {
    LinearLayout localLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
    localLinearLayout.setOrientation(1);
    localLinearLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
    localLinearLayout.setOnClickListener(new FeedItemCellTypeTopicMulti.1(this));
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() >= 2))
    {
      Object localObject1 = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
      int i = 0;
      localObject1 = (RelativeLayout)((LayoutInflater)localObject1).inflate(2131560198, localLinearLayout, false);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((RelativeLayout)localObject1).findViewById(2131378784));
      this.b = ((TextView)((RelativeLayout)localObject1).findViewById(2131371472));
      Object localObject2 = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics();
      if (localObject2 != null)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth(((DisplayMetrics)localObject2).widthPixels / 2);
        this.b.setMaxWidth(((DisplayMetrics)localObject2).widthPixels / 4);
      }
      localObject2 = (LinearLayout)((RelativeLayout)localObject1).findViewById(2131365171);
      while (i < 2)
      {
        ComponentTopicItemMulti localComponentTopicItemMulti = (ComponentTopicItemMulti)this.jdField_a_of_type_JavaUtilList.get(i);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
        localLayoutParams.weight = 1.0F;
        if (i < 1) {
          localLayoutParams.rightMargin = AIOUtils.b(0.75F, this.jdField_a_of_type_AndroidContentContext.getResources());
        }
        if (i > 0) {
          localLayoutParams.leftMargin = AIOUtils.b(0.75F, this.jdField_a_of_type_AndroidContentContext.getResources());
        }
        localComponentTopicItemMulti.setLayoutParams(localLayoutParams);
        ((LinearLayout)localObject2).addView(localComponentTopicItemMulti);
        i += 1;
      }
      localLinearLayout.addView((View)localObject1);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentDivider != null) {
      localLinearLayout.addView(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentDivider);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentLastRead != null) {
      localLinearLayout.addView(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentLastRead);
    }
    a(localLinearLayout);
    return this;
  }
  
  public FeedItemCell e()
  {
    return null;
  }
  
  public FeedItemCell o()
  {
    super.o();
    if ((this.jdField_a_of_type_JavaLangObject instanceof IReadInJoyModel))
    {
      AbsBaseArticleInfo localAbsBaseArticleInfo = ((IReadInJoyModel)this.jdField_a_of_type_JavaLangObject).a();
      TopicRecommendFeedsInfo localTopicRecommendFeedsInfo = localAbsBaseArticleInfo.mTopicRecommendFeedsInfo;
      if ((localTopicRecommendFeedsInfo != null) && (localTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList != null))
      {
        if (localTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList.size() < 2) {
          return this;
        }
        if (localTopicRecommendFeedsInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityTopicRecommendFeedsInfo$TopicRecommendFeedsTitle != null) {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(localTopicRecommendFeedsInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityTopicRecommendFeedsInfo$TopicRecommendFeedsTitle.a);
        } else {
          this.jdField_a_of_type_AndroidWidgetTextView.setText("");
        }
        TopicRecommendFeedsInfo.TopicRecommendFeedsTitle localTopicRecommendFeedsTitle = localTopicRecommendFeedsInfo.b;
        int i = 0;
        if ((localTopicRecommendFeedsTitle != null) && (!TextUtils.isEmpty(localTopicRecommendFeedsInfo.b.a)))
        {
          this.b.setVisibility(0);
          this.b.setText(localTopicRecommendFeedsInfo.b.a);
          if (TextUtils.isEmpty(localTopicRecommendFeedsInfo.b.b))
          {
            this.b.setCompoundDrawables(null, null, null, null);
            this.b.setOnClickListener(null);
          }
          else
          {
            this.b.setOnClickListener(new FeedItemCellTypeTopicMulti.2(this, localAbsBaseArticleInfo, localTopicRecommendFeedsInfo));
          }
        }
        else
        {
          this.b.setVisibility(8);
        }
        if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() >= 2)) {
          while (i < 2)
          {
            ((ComponentTopicItemMulti)this.jdField_a_of_type_JavaUtilList.get(i)).a(localTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList.get(i));
            ((ComponentTopicItemMulti)this.jdField_a_of_type_JavaUtilList.get(i)).setArticleInfo(localAbsBaseArticleInfo, ((IReadInJoyModel)this.jdField_a_of_type_JavaLangObject).c());
            i += 1;
          }
        }
      }
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.FeedItemCellTypeTopicMulti
 * JD-Core Version:    0.7.0.1
 */