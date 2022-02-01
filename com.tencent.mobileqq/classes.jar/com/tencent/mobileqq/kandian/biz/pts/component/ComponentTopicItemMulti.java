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
  TopicRecommendFeedsInfo.TopicRecommendInfo a;
  KandianUrlImageView b;
  TextView c;
  TextView d;
  private AbsBaseArticleInfo e;
  private int f;
  
  public ComponentTopicItemMulti(Context paramContext)
  {
    super(paramContext);
    c(paramContext);
  }
  
  public ComponentTopicItemMulti(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    c(paramContext);
  }
  
  public ComponentTopicItemMulti(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    c(paramContext);
  }
  
  private void c(Context paramContext)
  {
    a(paramContext);
    a();
  }
  
  public void a() {}
  
  public void a(Context paramContext)
  {
    a(b(paramContext));
  }
  
  public void a(View paramView)
  {
    this.b = ((KandianUrlImageView)findViewById(2131431458));
    this.c = ((TextView)findViewById(2131447463));
    this.d = ((TextView)findViewById(2131431733));
  }
  
  public void a(FeedItemCell.CellListener paramCellListener) {}
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof TopicRecommendFeedsInfo.TopicRecommendInfo))
    {
      this.a = ((TopicRecommendFeedsInfo.TopicRecommendInfo)paramObject);
      b();
      try
      {
        paramObject = new URL(this.a.f);
        ReadInJoyDisplayUtils.a(this.b, paramObject, getContext());
      }
      catch (MalformedURLException paramObject)
      {
        ReadInJoyDisplayUtils.a(this.b, null, getContext());
        paramObject.printStackTrace();
      }
      paramObject = this.c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.a.d);
      localStringBuilder.append(this.a.b);
      paramObject.setText(localStringBuilder.toString());
      paramObject = String.format(getResources().getString(2131915541), new Object[] { ReadInJoyHelper.c(this.a.e) });
      this.d.setText(paramObject);
      if (!TextUtils.isEmpty(this.a.c))
      {
        setOnClickListener(new ComponentTopicItemMulti.1(this));
        return;
      }
      setOnClickListener(new ComponentTopicItemMulti.2(this));
    }
  }
  
  public View b(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131626204, this, true);
  }
  
  public void b()
  {
    this.b.setScaleType(ImageView.ScaleType.CENTER_CROP);
  }
  
  public void setArticleInfo(AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    this.e = paramAbsBaseArticleInfo;
    this.f = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentTopicItemMulti
 * JD-Core Version:    0.7.0.1
 */