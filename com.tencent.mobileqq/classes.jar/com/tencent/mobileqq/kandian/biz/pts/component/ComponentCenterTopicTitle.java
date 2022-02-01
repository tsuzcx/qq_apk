package com.tencent.mobileqq.kandian.biz.pts.component;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.TextView;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TopicRecommendFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TopicRecommendFeedsInfo.TopicRecommendInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import java.util.ArrayList;

public class ComponentCenterTopicTitle
  extends ComponentTitle
  implements ComponentView
{
  TextView a;
  TextView b;
  
  public ComponentCenterTopicTitle(Context paramContext)
  {
    super(paramContext);
  }
  
  public ComponentCenterTopicTitle(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ComponentCenterTopicTitle(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a() {}
  
  public void a(Context paramContext)
  {
    LayoutInflater.from(paramContext).inflate(2131560159, this, true);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365056));
    this.b = ((TextView)findViewById(2131365517));
  }
  
  public void a(FeedItemCell.CellListener paramCellListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a(paramCellListener);
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof IReadInJoyModel))
    {
      paramObject = (IReadInJoyModel)paramObject;
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a(paramObject);
      paramObject = paramObject.a();
      if ((paramObject != null) && (paramObject.mSocialFeedInfo != null) && (paramObject.mSocialFeedInfo.a != null) && (paramObject.mSocialFeedInfo.a.a != null) && (!paramObject.mSocialFeedInfo.a.a.isEmpty()))
      {
        paramObject = (TopicRecommendFeedsInfo.TopicRecommendInfo)paramObject.mSocialFeedInfo.a.a.get(0);
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramObject.c);
        ((StringBuilder)localObject).append(paramObject.a);
        localObject = ((StringBuilder)localObject).toString();
        this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        if (paramObject.b > 0)
        {
          paramObject = String.format("- %s人正在参与 -", new Object[] { ReadInJoyHelper.a(paramObject.b) });
          this.b.setText(paramObject);
          this.b.setVisibility(0);
        }
        else
        {
          this.b.setVisibility(8);
        }
        b();
      }
    }
  }
  
  public void b() {}
  
  public void setReadedStatus(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentCenterTopicTitle
 * JD-Core Version:    0.7.0.1
 */