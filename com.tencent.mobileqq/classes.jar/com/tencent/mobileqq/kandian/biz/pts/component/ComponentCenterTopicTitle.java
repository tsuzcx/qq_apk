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
    LayoutInflater.from(paramContext).inflate(2131626206, this, true);
    this.a = ((TextView)findViewById(2131431189));
    this.b = ((TextView)findViewById(2131431733));
  }
  
  public void a(FeedItemCell.CellListener paramCellListener)
  {
    this.c.a(paramCellListener);
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof IReadInJoyModel))
    {
      paramObject = (IReadInJoyModel)paramObject;
      this.c.a(paramObject);
      paramObject = paramObject.k();
      if ((paramObject != null) && (paramObject.mSocialFeedInfo != null) && (paramObject.mSocialFeedInfo.v != null) && (paramObject.mSocialFeedInfo.v.g != null) && (!paramObject.mSocialFeedInfo.v.g.isEmpty()))
      {
        paramObject = (TopicRecommendFeedsInfo.TopicRecommendInfo)paramObject.mSocialFeedInfo.v.g.get(0);
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramObject.d);
        ((StringBuilder)localObject).append(paramObject.b);
        localObject = ((StringBuilder)localObject).toString();
        this.a.setText((CharSequence)localObject);
        if (paramObject.e > 0)
        {
          paramObject = String.format("- %s人正在参与 -", new Object[] { ReadInJoyHelper.c(paramObject.e) });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentCenterTopicTitle
 * JD-Core Version:    0.7.0.1
 */