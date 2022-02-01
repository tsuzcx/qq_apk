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
  TextView G;
  TextView H;
  
  public FeedItemCellTypeTopicMulti(Context paramContext, IFaceDecoder paramIFaceDecoder, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    super(paramContext, paramIFaceDecoder, paramReadInJoyBaseAdapter);
  }
  
  public FeedItemCell b()
  {
    return n().w().p();
  }
  
  public FeedItemCell e()
  {
    LinearLayout localLinearLayout = new LinearLayout(this.e);
    localLinearLayout.setOrientation(1);
    localLinearLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
    localLinearLayout.setOnClickListener(new FeedItemCellTypeTopicMulti.1(this));
    if ((this.C != null) && (this.C.size() >= 2))
    {
      Object localObject1 = LayoutInflater.from(this.e);
      int i = 0;
      localObject1 = (RelativeLayout)((LayoutInflater)localObject1).inflate(2131626245, localLinearLayout, false);
      this.G = ((TextView)((RelativeLayout)localObject1).findViewById(2131447463));
      this.H = ((TextView)((RelativeLayout)localObject1).findViewById(2131438844));
      Object localObject2 = this.e.getResources().getDisplayMetrics();
      if (localObject2 != null)
      {
        this.G.setMaxWidth(((DisplayMetrics)localObject2).widthPixels / 2);
        this.H.setMaxWidth(((DisplayMetrics)localObject2).widthPixels / 4);
      }
      localObject2 = (LinearLayout)((RelativeLayout)localObject1).findViewById(2131431324);
      while (i < 2)
      {
        ComponentTopicItemMulti localComponentTopicItemMulti = (ComponentTopicItemMulti)this.C.get(i);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
        localLayoutParams.weight = 1.0F;
        if (i < 1) {
          localLayoutParams.rightMargin = AIOUtils.b(0.75F, this.e.getResources());
        }
        if (i > 0) {
          localLayoutParams.leftMargin = AIOUtils.b(0.75F, this.e.getResources());
        }
        localComponentTopicItemMulti.setLayoutParams(localLayoutParams);
        ((LinearLayout)localObject2).addView(localComponentTopicItemMulti);
        i += 1;
      }
      localLinearLayout.addView((View)localObject1);
    }
    if (this.r != null) {
      localLinearLayout.addView(this.r);
    }
    if (this.t != null) {
      localLinearLayout.addView(this.t);
    }
    a(localLinearLayout);
    return this;
  }
  
  public FeedItemCell f()
  {
    return null;
  }
  
  public FeedItemCell q()
  {
    super.q();
    if ((this.b instanceof IReadInJoyModel))
    {
      AbsBaseArticleInfo localAbsBaseArticleInfo = ((IReadInJoyModel)this.b).k();
      TopicRecommendFeedsInfo localTopicRecommendFeedsInfo = localAbsBaseArticleInfo.mTopicRecommendFeedsInfo;
      if ((localTopicRecommendFeedsInfo != null) && (localTopicRecommendFeedsInfo.g != null))
      {
        if (localTopicRecommendFeedsInfo.g.size() < 2) {
          return this;
        }
        if (localTopicRecommendFeedsInfo.e != null) {
          this.G.setText(localTopicRecommendFeedsInfo.e.a);
        } else {
          this.G.setText("");
        }
        TopicRecommendFeedsInfo.TopicRecommendFeedsTitle localTopicRecommendFeedsTitle = localTopicRecommendFeedsInfo.f;
        int i = 0;
        if ((localTopicRecommendFeedsTitle != null) && (!TextUtils.isEmpty(localTopicRecommendFeedsInfo.f.a)))
        {
          this.H.setVisibility(0);
          this.H.setText(localTopicRecommendFeedsInfo.f.a);
          if (TextUtils.isEmpty(localTopicRecommendFeedsInfo.f.b))
          {
            this.H.setCompoundDrawables(null, null, null, null);
            this.H.setOnClickListener(null);
          }
          else
          {
            this.H.setOnClickListener(new FeedItemCellTypeTopicMulti.2(this, localAbsBaseArticleInfo, localTopicRecommendFeedsInfo));
          }
        }
        else
        {
          this.H.setVisibility(8);
        }
        if ((this.C != null) && (this.C.size() >= 2)) {
          while (i < 2)
          {
            ((ComponentTopicItemMulti)this.C.get(i)).a(localTopicRecommendFeedsInfo.g.get(i));
            ((ComponentTopicItemMulti)this.C.get(i)).setArticleInfo(localAbsBaseArticleInfo, ((IReadInJoyModel)this.b).m());
            i += 1;
          }
        }
      }
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.FeedItemCellTypeTopicMulti
 * JD-Core Version:    0.7.0.1
 */