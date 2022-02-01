package com.tencent.mobileqq.kandian.biz.pts.component;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.kandian.biz.feeds.activity.ReadInJoyNewFeedsActivity;
import com.tencent.mobileqq.kandian.biz.tab.ReadinjoyTabFrame;
import com.tencent.mobileqq.kandian.repo.common.RIJShowKanDianTabSp;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;

public abstract class FeedItemCellTypeNewPolymericBaseHeader
  extends FeedItemCell
{
  private void a(LinearLayout paramLinearLayout, IReadInJoyModel paramIReadInJoyModel)
  {
    if (paramIReadInJoyModel.m() == 56)
    {
      this.F.setDividerWidth(AIOUtils.b(3.0F, this.e.getResources()));
      this.F.setPadding(DisplayUtil.a(this.e, 6.0F), 0, DisplayUtil.a(this.e, 6.0F), DisplayUtil.a(this.e, 15.0F));
    }
    else
    {
      this.F.setDividerWidth(AIOUtils.b(3.0F, this.e.getResources()));
      if (RIJFeedsType.J(paramIReadInJoyModel.k())) {
        this.F.setPadding(DisplayUtil.a(this.e, 12.0F), 0, DisplayUtil.a(this.e, 12.0F), DisplayUtil.a(this.e, 12.0F));
      } else {
        this.F.setPadding(DisplayUtil.a(this.e, 12.0F), 0, DisplayUtil.a(this.e, 12.0F), DisplayUtil.a(this.e, 10.0F));
      }
    }
    this.F.setClipToPadding(false);
    this.F.setClipChildren(false);
    paramLinearLayout.addView(this.F);
  }
  
  private void c(View paramView)
  {
    if ((this.e instanceof ReadInJoyNewFeedsActivity)) {
      return;
    }
    if (RIJShowKanDianTabSp.c()) {
      try
      {
        localObject = (ReadinjoyTabFrame)FrameHelperActivity.a((BaseActivity)this.e).a(ReadinjoyTabFrame.class);
        if (localObject != null)
        {
          ((ReadinjoyTabFrame)localObject).b(paramView);
          return;
        }
      }
      catch (Exception paramView)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("readinjoy tab add dispatch touch event view fail ! e : ");
        ((StringBuilder)localObject).append(paramView);
        QLog.d("FeedItemCellTypeNewPolymericBaseHeader", 2, ((StringBuilder)localObject).toString());
        paramView.printStackTrace();
      }
    }
  }
  
  protected abstract FeedItemCell A();
  
  protected abstract void a(LinearLayout paramLinearLayout);
  
  public FeedItemCell b()
  {
    this.h = true;
    return z().x().p().n();
  }
  
  public FeedItemCell e()
  {
    if (this.h)
    {
      LinearLayout localLinearLayout = new LinearLayout(this.e);
      localLinearLayout.setOrientation(1);
      localLinearLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
      a(localLinearLayout);
      if ((this.b != null) && ((this.b instanceof IReadInJoyModel)) && (this.F != null))
      {
        ((IReadInJoyModel)this.b).k();
        a(localLinearLayout, (IReadInJoyModel)this.b);
      }
      if (this.r != null) {
        localLinearLayout.addView(this.r);
      }
      if (this.t != null) {
        localLinearLayout.addView(this.t);
      }
      if (this.s != null) {
        localLinearLayout.addView(this.s);
      }
      a(localLinearLayout);
      c(a());
      return this;
    }
    throw new Exception("buildComponent() must after buildComponent()!");
  }
  
  public FeedItemCell f()
  {
    return this;
  }
  
  public FeedItemCell q()
  {
    super.q();
    A();
    if (this.F != null) {
      this.F.a(this.b);
    }
    try
    {
      f();
      return this;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      QLog.e("FeedItemCellTypeNewPolymericBaseHeader", 1, localException, new Object[0]);
    }
    return this;
  }
  
  public FeedItemCell r()
  {
    super.r();
    if (this.w != null) {
      this.w.a(this.u);
    }
    return this;
  }
  
  protected abstract FeedItemCell z();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.FeedItemCellTypeNewPolymericBaseHeader
 * JD-Core Version:    0.7.0.1
 */