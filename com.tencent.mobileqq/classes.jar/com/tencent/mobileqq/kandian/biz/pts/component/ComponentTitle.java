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
  CmpCtxt a;
  TextView c;
  
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
      this.a.a((IReadInJoyModel)paramObject);
      b();
    }
  }
  
  private void b(Context paramContext)
  {
    this.a = new CmpCtxt();
    a(paramContext);
    a();
  }
  
  public void a() {}
  
  public void a(Context paramContext)
  {
    LayoutInflater.from(paramContext).inflate(2131560156, this, true);
    this.c = ((TextView)findViewById(2131365056));
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
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
      try
      {
        AbsBaseArticleInfo localAbsBaseArticleInfo = paramObject.a();
        if (((RIJItemViewTypeUtils.m(localAbsBaseArticleInfo)) || (RIJItemViewTypeUtils.l(localAbsBaseArticleInfo)) || (RIJItemViewTypeUtils.n(localAbsBaseArticleInfo)) || (RIJItemViewTypeUtils.p(localAbsBaseArticleInfo))) && (!RIJItemViewTypeUtils.x(paramObject.a()))) {
          paramObject = ((UGCVideoInfo)paramObject.a().mSocialFeedInfo.a.b.get(0)).e;
        } else if (RIJFeedsType.h(localAbsBaseArticleInfo)) {
          paramObject = ((NewPolymericInfo.PackArticleInfo)localAbsBaseArticleInfo.mNewPolymericInfo.a.get(0)).a;
        } else {
          paramObject = paramObject.a().mTitle;
        }
        localSpannableStringBuilder.append(paramObject);
        this.c.setText(localSpannableStringBuilder);
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
    FrameLayout.LayoutParams localLayoutParams1 = (FrameLayout.LayoutParams)this.c.getLayoutParams();
    if (this.a.k())
    {
      localLayoutParams1.setMargins(0, 0, 0, 0);
      if (this.a.l()) {
        this.c.setLineSpacing(4.0F, 1.0F);
      }
    }
    else if (RIJFeedsType.h(this.a.a.a()))
    {
      this.c.setTextSize(14.0F);
      this.c.setTextColor(Color.parseColor("#D8FFFFFF"));
      this.c.setLines(2);
      this.c.setEllipsize(TextUtils.TruncateAt.END);
      FrameLayout.LayoutParams localLayoutParams2 = (FrameLayout.LayoutParams)this.c.getLayoutParams();
      localLayoutParams2.leftMargin = 0;
      localLayoutParams2.topMargin = AIOUtils.b(4.0F, getResources());
      localLayoutParams2.rightMargin = AIOUtils.b(10.0F, getResources());
      localLayoutParams2.bottomMargin = AIOUtils.b(0.0F, getResources());
      this.c.setLayoutParams(localLayoutParams2);
      this.c.setGravity(51);
      this.c.setPadding(0, AIOUtils.b(2.0F, getResources()), 0, AIOUtils.b(2.0F, getResources()));
    }
    else if (this.a.j())
    {
      int i = this.c.getPaddingTop();
      this.c.getBottom();
      int j = this.c.getPaddingLeft();
      int k = this.c.getPaddingRight();
      if (this.a.a())
      {
        localLayoutParams1.topMargin = AIOUtils.b(0.0F, getResources());
        localLayoutParams1.bottomMargin = AIOUtils.b(0.0F, getResources());
        localLayoutParams1.leftMargin = AIOUtils.b(11.0F, getResources());
        localLayoutParams1.rightMargin = AIOUtils.b(11.0F, getResources());
        int m = AIOUtils.b(10.0F, getResources());
        this.c.setPadding(j, i, k, m);
      }
      else
      {
        localLayoutParams1.topMargin = AIOUtils.b(18.0F, getResources());
        localLayoutParams1.bottomMargin = AIOUtils.b(0.0F, getResources());
        localLayoutParams1.leftMargin = AIOUtils.b(11.0F, getResources());
        localLayoutParams1.rightMargin = AIOUtils.b(11.0F, getResources());
        this.c.setPadding(j, i, k, 0);
      }
    }
    else if ((!this.a.b()) && (!this.a.c()))
    {
      if (this.a.d())
      {
        localLayoutParams1.topMargin = AIOUtils.b(0.0F, getResources());
        localLayoutParams1.bottomMargin = AIOUtils.b(0.0F, getResources());
        localLayoutParams1.leftMargin = AIOUtils.b(12.0F, getResources());
        localLayoutParams1.rightMargin = AIOUtils.b(20.0F, getResources());
      }
      else if ((!this.a.e()) && (!this.a.g()) && (!CmpCtxt.b(this.a.a.a())) && (!this.a.h()))
      {
        if (this.a.f())
        {
          this.c.setMinimumHeight(AIOUtils.b(40.0F, getResources()));
        }
        else if (this.a.a())
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
    if ((DeviceInfoUtil.k() >= 1080L) && ((this.c.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)))
    {
      localLayoutParams1.topMargin = Math.max(localLayoutParams1.topMargin - AIOUtils.b(4.5F, getResources()), 0);
      localLayoutParams1.bottomMargin = Math.max(localLayoutParams1.bottomMargin - AIOUtils.b(6.0F, getResources()), 0);
    }
    this.c.setLayoutParams(localLayoutParams1);
  }
  
  public void setReadedStatus(boolean paramBoolean)
  {
    if ((!this.a.i()) && (!this.a.k()) && (!CmpCtxt.b(this.a.a.a())))
    {
      if (!paramBoolean)
      {
        this.c.setTextColor(getContext().getResources().getColor(2131165327));
        return;
      }
      this.c.setTextColor(getContext().getResources().getColor(2131166508));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentTitle
 * JD-Core Version:    0.7.0.1
 */