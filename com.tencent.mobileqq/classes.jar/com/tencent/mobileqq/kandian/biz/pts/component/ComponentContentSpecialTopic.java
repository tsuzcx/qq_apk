package com.tencent.mobileqq.kandian.biz.pts.component;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.kandian.base.utils.ReadInJoyDisplayUtils;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;
import com.tencent.mobileqq.kandian.repo.common.RIJConvertString2URL;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.kandian.repo.pts.UtilsForComponent;

public class ComponentContentSpecialTopic
  extends RelativeLayout
  implements ComponentInheritView
{
  CmpCtxt a;
  KandianUrlImageView b;
  double c;
  
  public ComponentContentSpecialTopic(Context paramContext)
  {
    super(paramContext);
    c(paramContext);
  }
  
  public ComponentContentSpecialTopic(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    c(paramContext);
  }
  
  public ComponentContentSpecialTopic(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
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
    this.a = new CmpCtxt();
    this.c = 0.0D;
    a(b(paramContext));
  }
  
  public void a(View paramView)
  {
    this.b = ((KandianUrlImageView)paramView.findViewById(2131435435));
  }
  
  public void a(FeedItemCell.CellListener paramCellListener)
  {
    this.a.a(paramCellListener);
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof IReadInJoyModel))
    {
      paramObject = (IReadInJoyModel)paramObject;
      this.a.a(paramObject);
      b();
      paramObject = paramObject.k();
      if (paramObject != null) {
        ReadInJoyDisplayUtils.a(this.b, RIJConvertString2URL.b(paramObject.mFirstPagePicUrl), getContext());
      }
    }
  }
  
  public View b(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131626182, this, true);
  }
  
  public void b()
  {
    if (this.a.a != null)
    {
      AbsBaseArticleInfo localAbsBaseArticleInfo = this.a.a.k();
      if (localAbsBaseArticleInfo == null) {
        return;
      }
      double d = this.c;
      if ((d == 0.0D) || (d != localAbsBaseArticleInfo.mTopicPicWHRatio))
      {
        UtilsForComponent.a(getContext(), this.b, localAbsBaseArticleInfo.mTopicPicWHRatio);
        this.c = localAbsBaseArticleInfo.mTopicPicWHRatio;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentContentSpecialTopic
 * JD-Core Version:    0.7.0.1
 */