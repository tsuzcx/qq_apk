package com.tencent.mobileqq.kandian.biz.pts.component;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.kandian.biz.feeds.activity.ReadInJoyNewFeedsActivity;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.tab.ReadinjoyTabFrame;
import com.tencent.mobileqq.kandian.repo.common.RIJShowKanDianTabSp;
import com.tencent.mobileqq.kandian.repo.feeds.PolymericInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;

public class FeedItemCellTypePolymeric
  extends FeedItemCell
{
  private static final String G = "FeedItemCellTypePolymeric";
  
  public FeedItemCellTypePolymeric(Context paramContext, IFaceDecoder paramIFaceDecoder, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    super(paramContext, paramIFaceDecoder, paramReadInJoyBaseAdapter);
  }
  
  private void a(LinearLayout paramLinearLayout, IReadInJoyModel paramIReadInJoyModel)
  {
    if (paramIReadInJoyModel.m() == 56)
    {
      this.F.setDividerWidth(AIOUtils.b(3.0F, this.e.getResources()));
      this.F.setPadding(DisplayUtil.a(this.e, 6.0F), 0, DisplayUtil.a(this.e, 6.0F), DisplayUtil.a(this.e, 15.0F));
    }
    else
    {
      this.F.setDividerWidth(AIOUtils.b(1.5F, this.e.getResources()));
      this.F.setPadding(DisplayUtil.a(this.e, 6.0F), DisplayUtil.a(this.e, 8.0F), DisplayUtil.a(this.e, 12.0F), DisplayUtil.a(this.e, 8.0F));
    }
    this.F.setClipToPadding(false);
    this.F.setClipChildren(false);
    paramLinearLayout.addView(this.F);
  }
  
  public static boolean b(int paramInt)
  {
    return (paramInt == 9) || (paramInt == 10) || (paramInt == 11);
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
        Object localObject = G;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("readinjoy tab add dispatch touch event view fail ! e : ");
        localStringBuilder.append(paramView);
        QLog.d((String)localObject, 2, localStringBuilder.toString());
        paramView.printStackTrace();
      }
    }
  }
  
  public FeedItemCell b()
  {
    this.h = true;
    if ((this.b != null) && ((this.b instanceof IReadInJoyModel)) && (((IReadInJoyModel)this.b).m() == 56))
    {
      if (((IReadInJoyModel)this.b).p() == 53) {
        return b(this.g, this.f).x().p();
      }
      return b(this.g, this.f).x().p().n().o();
    }
    return b(this.g, this.f).x().p().n();
  }
  
  public FeedItemCell e()
  {
    if (this.h)
    {
      LinearLayout localLinearLayout = new LinearLayout(this.e);
      localLinearLayout.setOrientation(1);
      localLinearLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
      if (this.w != null) {
        localLinearLayout.addView(this.w);
      }
      if ((this.b != null) && ((this.b instanceof IReadInJoyModel)) && (this.F != null))
      {
        Object localObject = ((IReadInJoyModel)this.b).k();
        if ((((AbsBaseArticleInfo)localObject).mPolymericInfo != null) && (b(((AbsBaseArticleInfo)localObject).mPolymericInfo.e)))
        {
          a(localLinearLayout, (IReadInJoyModel)this.b);
        }
        else
        {
          localObject = new LinearLayout.LayoutParams(-1, -2);
          ((LinearLayout.LayoutParams)localObject).leftMargin = DisplayUtil.a(this.e, 12.0F);
          ((LinearLayout.LayoutParams)localObject).bottomMargin = DisplayUtil.a(this.e, 20.0F);
          this.F.setDividerWidth(AIOUtils.b(3.0F, this.e.getResources()));
          localLinearLayout.addView(this.F, (ViewGroup.LayoutParams)localObject);
        }
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
    if (this.w != null) {
      this.w.a(this.b);
    }
    if (this.F != null) {
      this.F.a(this.b);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.FeedItemCellTypePolymeric
 * JD-Core Version:    0.7.0.1
 */