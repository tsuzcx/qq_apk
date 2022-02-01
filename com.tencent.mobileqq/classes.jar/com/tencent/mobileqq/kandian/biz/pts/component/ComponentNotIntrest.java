package com.tencent.mobileqq.kandian.biz.pts.component;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;

public class ComponentNotIntrest
  extends FrameLayout
  implements View.OnClickListener, ComponentView
{
  CmpCtxt a;
  public View b;
  
  public ComponentNotIntrest(Context paramContext)
  {
    super(paramContext);
    b(paramContext);
  }
  
  public ComponentNotIntrest(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b(paramContext);
  }
  
  public ComponentNotIntrest(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b(paramContext);
  }
  
  private void b(Context paramContext)
  {
    this.a = new CmpCtxt();
    a(paramContext);
    a();
  }
  
  public void a()
  {
    this.b.setOnClickListener(this);
  }
  
  public void a(Context paramContext)
  {
    this.b = LayoutInflater.from(paramContext).inflate(2131626200, this, true).findViewById(2131449096);
  }
  
  public void a(FeedItemCell.CellListener paramCellListener)
  {
    this.a.a(paramCellListener);
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof IReadInJoyModel))
    {
      this.a.a((IReadInJoyModel)paramObject);
      b();
    }
  }
  
  public void b()
  {
    if (this.a.b())
    {
      this.b.setPadding(AIOUtils.b(5.0F, getResources()), AIOUtils.b(5.0F, getResources()), AIOUtils.b(5.0F, getResources()), AIOUtils.b(5.0F, getResources()));
      return;
    }
    if (RIJFeedsType.I(this.a.a.k()))
    {
      this.b.setPadding(AIOUtils.b(5.0F, getResources()), AIOUtils.b(5.0F, getResources()), AIOUtils.b(9.0F, getResources()), AIOUtils.b(5.0F, getResources()));
      return;
    }
    this.b.setPadding(AIOUtils.b(12.0F, getResources()), AIOUtils.b(9.0F, getResources()), AIOUtils.b(12.0F, getResources()), AIOUtils.b(9.0F, getResources()));
  }
  
  public void onClick(View paramView)
  {
    if (this.a.b != null) {
      this.a.b.a(paramView, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentNotIntrest
 * JD-Core Version:    0.7.0.1
 */