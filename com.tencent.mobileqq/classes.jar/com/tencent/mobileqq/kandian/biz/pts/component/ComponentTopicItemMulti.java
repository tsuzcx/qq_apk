package com.tencent.mobileqq.kandian.biz.pts.component;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.kandian.base.utils.ReadInJoyDisplayUtils;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TopicRecommendFeedsInfo.TopicRecommendInfo;
import java.net.MalformedURLException;
import java.net.URL;

public class ComponentTopicItemMulti
  extends RelativeLayout
  implements ComponentInheritView
{
  private int jdField_a_of_type_Int;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  KandianUrlImageView jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView;
  private AbsBaseArticleInfo jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
  TopicRecommendFeedsInfo.TopicRecommendInfo jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityTopicRecommendFeedsInfo$TopicRecommendInfo;
  TextView b;
  
  public ComponentTopicItemMulti(Context paramContext)
  {
    super(paramContext);
    b(paramContext);
  }
  
  public ComponentTopicItemMulti(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b(paramContext);
  }
  
  public ComponentTopicItemMulti(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b(paramContext);
  }
  
  private void b(Context paramContext)
  {
    a(paramContext);
    a();
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131560157, this, true);
  }
  
  public void a() {}
  
  public void a(Context paramContext)
  {
    a(a(paramContext));
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView = ((KandianUrlImageView)findViewById(2131365284));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378784));
    this.b = ((TextView)findViewById(2131365517));
  }
  
  public void a(FeedItemCell.CellListener paramCellListener) {}
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof TopicRecommendFeedsInfo.TopicRecommendInfo))
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityTopicRecommendFeedsInfo$TopicRecommendInfo = ((TopicRecommendFeedsInfo.TopicRecommendInfo)paramObject);
      b();
      try
      {
        paramObject = new URL(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityTopicRecommendFeedsInfo$TopicRecommendInfo.d);
        ReadInJoyDisplayUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView, paramObject, getContext());
      }
      catch (MalformedURLException paramObject)
      {
        ReadInJoyDisplayUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView, null, getContext());
        paramObject.printStackTrace();
      }
      paramObject = this.jdField_a_of_type_AndroidWidgetTextView;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityTopicRecommendFeedsInfo$TopicRecommendInfo.c);
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityTopicRecommendFeedsInfo$TopicRecommendInfo.a);
      paramObject.setText(localStringBuilder.toString());
      paramObject = String.format(getResources().getString(2131718064), new Object[] { ReadInJoyHelper.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityTopicRecommendFeedsInfo$TopicRecommendInfo.jdField_b_of_type_Int) });
      this.b.setText(paramObject);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityTopicRecommendFeedsInfo$TopicRecommendInfo.jdField_b_of_type_JavaLangString))
      {
        setOnClickListener(new ComponentTopicItemMulti.1(this));
        return;
      }
      setOnClickListener(new ComponentTopicItemMulti.2(this));
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
  }
  
  public void setArticleInfo(AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo = paramAbsBaseArticleInfo;
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentTopicItemMulti
 * JD-Core Version:    0.7.0.1
 */