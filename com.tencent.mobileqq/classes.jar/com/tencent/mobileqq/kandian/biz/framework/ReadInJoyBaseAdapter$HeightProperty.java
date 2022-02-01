package com.tencent.mobileqq.kandian.biz.framework;

import android.util.Property;
import android.view.View;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;

class ReadInJoyBaseAdapter$HeightProperty
  extends Property<View, Integer>
{
  private AbsBaseArticleInfo a;
  
  public ReadInJoyBaseAdapter$HeightProperty(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    super(Integer.class, "height");
    this.a = paramAbsBaseArticleInfo;
  }
  
  public Integer a(View paramView)
  {
    return Integer.valueOf(paramView.getHeight());
  }
  
  public void a(View paramView, Integer paramInteger)
  {
    if (paramView.getLayoutParams() != null)
    {
      paramView.getLayoutParams().height = paramInteger.intValue();
      paramView.setLayoutParams(paramView.getLayoutParams());
      paramView = this.a;
      if (paramView != null) {
        paramView.curHeight = paramInteger.intValue();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter.HeightProperty
 * JD-Core Version:    0.7.0.1
 */