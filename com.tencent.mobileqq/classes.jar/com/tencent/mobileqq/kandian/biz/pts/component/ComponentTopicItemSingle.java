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
import com.tencent.mobileqq.kandian.repo.feeds.entity.TopicRecommendFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TopicRecommendFeedsInfo.TopicRecommendInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class ComponentTopicItemSingle
  extends RelativeLayout
  implements ComponentInheritView
{
  CmpCtxt a;
  KandianUrlImageView b;
  TextView c;
  TextView d;
  
  public ComponentTopicItemSingle(Context paramContext)
  {
    super(paramContext);
    c(paramContext);
  }
  
  public ComponentTopicItemSingle(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    c(paramContext);
  }
  
  public ComponentTopicItemSingle(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    c(paramContext);
  }
  
  private void c(Context paramContext)
  {
    this.a = new CmpCtxt();
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
    if ((paramObject instanceof IReadInJoyModel))
    {
      paramObject = (IReadInJoyModel)paramObject;
      this.a.a(paramObject);
      b();
      paramObject = paramObject.k();
      if ((paramObject != null) && (paramObject.mTopicRecommendFeedsInfo != null) && (paramObject.mTopicRecommendFeedsInfo.g != null))
      {
        if (paramObject.mTopicRecommendFeedsInfo.g.size() == 0) {
          return;
        }
        paramObject = (TopicRecommendFeedsInfo.TopicRecommendInfo)paramObject.mTopicRecommendFeedsInfo.g.get(0);
        try
        {
          URL localURL = new URL(paramObject.f);
          ReadInJoyDisplayUtils.a(this.b, localURL, getContext());
        }
        catch (MalformedURLException localMalformedURLException)
        {
          ReadInJoyDisplayUtils.a(this.b, null, getContext());
          localMalformedURLException.printStackTrace();
        }
        Object localObject = this.c;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramObject.d);
        localStringBuilder.append(paramObject.b);
        ((TextView)localObject).setText(localStringBuilder.toString());
        localObject = String.format(getResources().getString(2131915542), new Object[] { ReadInJoyHelper.c(paramObject.e) });
        this.d.setText((CharSequence)localObject);
        if (!TextUtils.isEmpty(paramObject.c))
        {
          setOnClickListener(new ComponentTopicItemSingle.1(this, paramObject));
          return;
        }
        setOnClickListener(new ComponentTopicItemSingle.2(this));
      }
    }
  }
  
  public View b(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131626205, this, true);
  }
  
  public void b()
  {
    this.b.setScaleType(ImageView.ScaleType.CENTER_CROP);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentTopicItemSingle
 * JD-Core Version:    0.7.0.1
 */