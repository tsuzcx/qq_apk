package com.tencent.mobileqq.kandian.biz.pts.component;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.kandian.repo.common.RIJItemViewTypeUtils;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.NewPolymericInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.NewPolymericInfo.PackArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UGCFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.kandian.repo.video.entity.UGCVideoInfo;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import java.util.ArrayList;
import java.util.List;

public class ComponentTitle
  extends FrameLayout
  implements ComponentView
{
  CmpCtxt c;
  TextView d;
  
  public ComponentTitle(Context paramContext)
  {
    super(paramContext);
    b(paramContext);
  }
  
  public ComponentTitle(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b(paramContext);
  }
  
  public ComponentTitle(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b(paramContext);
  }
  
  public ComponentTitle(Context paramContext, Object paramObject)
  {
    super(paramContext);
    a(paramContext, paramObject);
  }
  
  private void a(Context paramContext, Object paramObject)
  {
    b(paramContext);
    if ((paramObject instanceof IReadInJoyModel))
    {
      this.c.a((IReadInJoyModel)paramObject);
      b();
    }
  }
  
  private void b(Context paramContext)
  {
    this.c = new CmpCtxt();
    a(paramContext);
    a();
  }
  
  public void a() {}
  
  public void a(Context paramContext)
  {
    LayoutInflater.from(paramContext).inflate(2131626203, this, true);
    this.d = ((TextView)findViewById(2131431189));
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
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
      try
      {
        AbsBaseArticleInfo localAbsBaseArticleInfo = paramObject.k();
        if (((RIJItemViewTypeUtils.m(localAbsBaseArticleInfo)) || (RIJItemViewTypeUtils.l(localAbsBaseArticleInfo)) || (RIJItemViewTypeUtils.n(localAbsBaseArticleInfo)) || (RIJItemViewTypeUtils.p(localAbsBaseArticleInfo))) && (!RIJItemViewTypeUtils.x(paramObject.k()))) {
          paramObject = ((UGCVideoInfo)paramObject.k().mSocialFeedInfo.s.c.get(0)).e;
        } else if (RIJFeedsType.l(localAbsBaseArticleInfo)) {
          paramObject = ((NewPolymericInfo.PackArticleInfo)localAbsBaseArticleInfo.mNewPolymericInfo.p.get(0)).b;
        } else {
          paramObject = paramObject.k().mTitle;
        }
        localSpannableStringBuilder.append(paramObject);
        this.d.setText(localSpannableStringBuilder);
        return;
      }
      catch (Exception paramObject)
      {
        paramObject.printStackTrace();
      }
    }
  }
  
  public void b()
  {
    FrameLayout.LayoutParams localLayoutParams1 = (FrameLayout.LayoutParams)this.d.getLayoutParams();
    if (this.c.l())
    {
      localLayoutParams1.setMargins(0, 0, 0, 0);
      if (this.c.m()) {
        this.d.setLineSpacing(4.0F, 1.0F);
      }
    }
    else if (RIJFeedsType.l(this.c.a.k()))
    {
      this.d.setTextSize(14.0F);
      this.d.setTextColor(Color.parseColor("#D8FFFFFF"));
      this.d.setLines(2);
      this.d.setEllipsize(TextUtils.TruncateAt.END);
      FrameLayout.LayoutParams localLayoutParams2 = (FrameLayout.LayoutParams)this.d.getLayoutParams();
      localLayoutParams2.leftMargin = 0;
      localLayoutParams2.topMargin = AIOUtils.b(4.0F, getResources());
      localLayoutParams2.rightMargin = AIOUtils.b(10.0F, getResources());
      localLayoutParams2.bottomMargin = AIOUtils.b(0.0F, getResources());
      this.d.setLayoutParams(localLayoutParams2);
      this.d.setGravity(51);
      this.d.setPadding(0, AIOUtils.b(2.0F, getResources()), 0, AIOUtils.b(2.0F, getResources()));
    }
    else if (this.c.k())
    {
      int i = this.d.getPaddingTop();
      this.d.getBottom();
      int j = this.d.getPaddingLeft();
      int k = this.d.getPaddingRight();
      if (this.c.b())
      {
        localLayoutParams1.topMargin = AIOUtils.b(0.0F, getResources());
        localLayoutParams1.bottomMargin = AIOUtils.b(0.0F, getResources());
        localLayoutParams1.leftMargin = AIOUtils.b(11.0F, getResources());
        localLayoutParams1.rightMargin = AIOUtils.b(11.0F, getResources());
        int m = AIOUtils.b(10.0F, getResources());
        this.d.setPadding(j, i, k, m);
      }
      else
      {
        localLayoutParams1.topMargin = AIOUtils.b(18.0F, getResources());
        localLayoutParams1.bottomMargin = AIOUtils.b(0.0F, getResources());
        localLayoutParams1.leftMargin = AIOUtils.b(11.0F, getResources());
        localLayoutParams1.rightMargin = AIOUtils.b(11.0F, getResources());
        this.d.setPadding(j, i, k, 0);
      }
    }
    else if ((!this.c.c()) && (!this.c.d()))
    {
      if (this.c.e())
      {
        localLayoutParams1.topMargin = AIOUtils.b(0.0F, getResources());
        localLayoutParams1.bottomMargin = AIOUtils.b(0.0F, getResources());
        localLayoutParams1.leftMargin = AIOUtils.b(12.0F, getResources());
        localLayoutParams1.rightMargin = AIOUtils.b(20.0F, getResources());
      }
      else if ((!this.c.f()) && (!this.c.h()) && (!CmpCtxt.b(this.c.a.k())) && (!this.c.i()))
      {
        if (this.c.g())
        {
          this.d.setMinimumHeight(AIOUtils.b(40.0F, getResources()));
        }
        else if (this.c.b())
        {
          localLayoutParams1.topMargin = AIOUtils.b(13.0F, getResources());
          localLayoutParams1.bottomMargin = AIOUtils.b(0.0F, getResources());
          localLayoutParams1.leftMargin = AIOUtils.b(11.0F, getResources());
          localLayoutParams1.rightMargin = AIOUtils.b(11.0F, getResources());
        }
        else
        {
          localLayoutParams1.topMargin = AIOUtils.b(13.0F, getResources());
          localLayoutParams1.bottomMargin = AIOUtils.b(11.0F, getResources());
          localLayoutParams1.leftMargin = AIOUtils.b(11.0F, getResources());
          localLayoutParams1.rightMargin = AIOUtils.b(11.0F, getResources());
        }
      }
      else
      {
        localLayoutParams1.topMargin = AIOUtils.b(13.0F, getResources());
        localLayoutParams1.bottomMargin = AIOUtils.b(17.0F, getResources());
        localLayoutParams1.leftMargin = AIOUtils.b(12.0F, getResources());
        localLayoutParams1.rightMargin = AIOUtils.b(12.0F, getResources());
      }
    }
    else
    {
      localLayoutParams1.topMargin = AIOUtils.b(0.0F, getResources());
      localLayoutParams1.bottomMargin = AIOUtils.b(0.0F, getResources());
      localLayoutParams1.leftMargin = AIOUtils.b(12.0F, getResources());
      localLayoutParams1.rightMargin = AIOUtils.b(20.0F, getResources());
    }
    if ((DeviceInfoUtil.F() >= 1080L) && ((this.d.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)))
    {
      localLayoutParams1.topMargin = Math.max(localLayoutParams1.topMargin - AIOUtils.b(4.5F, getResources()), 0);
      localLayoutParams1.bottomMargin = Math.max(localLayoutParams1.bottomMargin - AIOUtils.b(6.0F, getResources()), 0);
    }
    this.d.setLayoutParams(localLayoutParams1);
  }
  
  public TextView getTitle()
  {
    return this.d;
  }
  
  public void setReadedStatus(boolean paramBoolean)
  {
    if ((!this.c.j()) && (!this.c.l()) && (!CmpCtxt.b(this.c.a.k())))
    {
      if (!paramBoolean)
      {
        this.d.setTextColor(getContext().getResources().getColor(2131165564));
        return;
      }
      this.d.setTextColor(getContext().getResources().getColor(2131167365));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentTitle
 * JD-Core Version:    0.7.0.1
 */