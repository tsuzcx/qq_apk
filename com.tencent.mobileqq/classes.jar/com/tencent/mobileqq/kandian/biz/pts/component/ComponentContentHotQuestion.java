package com.tencent.mobileqq.kandian.biz.pts.component;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.base.utils.ReadInJoyDisplayUtils;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.NewPolymericInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.NewPolymericInfo.PackArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.NewPolymericInfo.PackQuestionAnswerExtraInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.NewPolymericInfo.PackTopicExtraInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.widget.BorderTextView;
import java.util.List;

public class ComponentContentHotQuestion
  extends RelativeLayout
  implements ComponentInheritView
{
  CmpCtxt a;
  Context b;
  KandianUrlImageView c;
  BorderTextView d;
  TextView e;
  TextView f;
  View.OnClickListener g = new ComponentContentHotQuestion.1(this);
  
  public ComponentContentHotQuestion(Context paramContext)
  {
    super(paramContext);
    c(paramContext);
  }
  
  public ComponentContentHotQuestion(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    c(paramContext);
  }
  
  public ComponentContentHotQuestion(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    c(paramContext);
  }
  
  private void c(Context paramContext)
  {
    this.a = new CmpCtxt();
    this.b = paramContext;
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
    this.c = ((KandianUrlImageView)paramView.findViewById(2131435435));
    this.d = ((BorderTextView)paramView.findViewById(2131432563));
    this.e = ((TextView)paramView.findViewById(2131447463));
    this.f = ((TextView)paramView.findViewById(2131439506));
    this.d.setBorderColor(Color.parseColor("#12B7F5"));
    this.d.setBorderWidth(2);
    this.d.setRadius(4.0F);
    this.d.setTextColor(Color.parseColor("#12B7F5"));
    this.d.setTextColor(Color.parseColor("#12B7F5"));
    this.d.setTextSize(1, 14.0F);
    this.d.setText(HardCodeUtil.a(2131900475));
    this.d.setOnClickListener(this.g);
    this.d.setGravity(17);
    this.e.setVisibility(8);
    this.f.setVisibility(8);
  }
  
  public void a(FeedItemCell.CellListener paramCellListener)
  {
    this.a.a(paramCellListener);
  }
  
  public void a(Object paramObject)
  {
    b();
    if ((paramObject instanceof IReadInJoyModel))
    {
      paramObject = (IReadInJoyModel)paramObject;
      this.a.a(paramObject);
      AbsBaseArticleInfo localAbsBaseArticleInfo = paramObject.k();
      NewPolymericInfo.PackArticleInfo localPackArticleInfo = (NewPolymericInfo.PackArticleInfo)localAbsBaseArticleInfo.mNewPolymericInfo.p.get(0);
      ReadInJoyDisplayUtils.a(this.c, localAbsBaseArticleInfo.mSinglePicture, getContext());
      if (!TextUtils.isEmpty(localPackArticleInfo.b))
      {
        this.e.setVisibility(0);
        this.e.setText(localPackArticleInfo.b);
      }
      if ((localPackArticleInfo.q != null) && (!TextUtils.isEmpty(localPackArticleInfo.q.b)))
      {
        this.e.setVisibility(0);
        this.e.setText(localPackArticleInfo.q.b);
      }
      if ((localPackArticleInfo.p != null) && (localPackArticleInfo.p.a >= 0))
      {
        this.f.setVisibility(0);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(ReadInJoyHelper.d(localPackArticleInfo.p.a));
        if (TextUtils.isEmpty(localPackArticleInfo.p.b)) {
          paramObject = HardCodeUtil.a(2131900487);
        } else {
          paramObject = localPackArticleInfo.p.b;
        }
        localStringBuilder.append(paramObject);
        paramObject = localStringBuilder.toString();
        this.f.setText(paramObject);
      }
      if (!TextUtils.isEmpty(localPackArticleInfo.r))
      {
        this.d.setText(localPackArticleInfo.r);
        return;
      }
      if (localAbsBaseArticleInfo.mNewPolymericInfo.d == 12)
      {
        this.d.setText(HardCodeUtil.a(2131900503));
        return;
      }
      if (localAbsBaseArticleInfo.mNewPolymericInfo.d == 13) {
        this.d.setText(HardCodeUtil.a(2131900442));
      }
    }
  }
  
  public View b(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131626173, this, true);
  }
  
  public void b()
  {
    ViewGroup.LayoutParams localLayoutParams = this.c.getLayoutParams();
    localLayoutParams.width = AIOUtils.b(150.0F, getResources());
    localLayoutParams.height = AIOUtils.b(150.0F, getResources());
    this.c.setLayoutParams(localLayoutParams);
    this.c.setScaleType(ImageView.ScaleType.CENTER_CROP);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentContentHotQuestion
 * JD-Core Version:    0.7.0.1
 */