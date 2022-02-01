package com.tencent.mobileqq.kandian.biz.feeds.controller;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyBaseListViewGroup;
import com.tencent.mobileqq.kandian.biz.feeds.ReadInJoyProteusFamilyListViewGroup;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import java.util.List;

public class ReadInJoyProteusFamilyViewController
  extends ReadInJoyBaseViewController
  implements View.OnClickListener
{
  private ViewGroup a;
  private ReadInJoyBaseListViewGroup i;
  private ReadInJoyBaseAdapter j;
  private boolean k = false;
  private View l;
  private View m;
  
  public ReadInJoyProteusFamilyViewController(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  private void k()
  {
    Object localObject = this.l;
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = this.a;
    if (localObject != null) {
      this.m = ((ViewGroup)localObject).findViewById(2131441404);
    }
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    super.a(paramViewGroup);
    this.a = paramViewGroup;
    k();
  }
  
  public void a(boolean paramBoolean, List<AbsBaseArticleInfo> paramList)
  {
    if (!this.k)
    {
      cT_();
      this.k = true;
    }
    Object localObject = this.m;
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    if (this.i != null)
    {
      if (this.a != null)
      {
        localObject = new ViewGroup.LayoutParams(-1, -1);
        if (this.i.getParent() != null) {
          ((ViewGroup)this.i.getParent()).removeView(this.i);
        }
        this.a.addView(this.i, (ViewGroup.LayoutParams)localObject);
      }
      ((ReadInJoyProteusFamilyListViewGroup)this.i).a(true, paramList);
    }
  }
  
  public void c()
  {
    super.c();
  }
  
  public void cT_()
  {
    super.cT_();
    this.i = new ReadInJoyProteusFamilyListViewGroup(this, 0, 0, 0, null, 2131626334);
    this.j = ((ReadInJoyProteusFamilyListViewGroup)this.i).getAdapter();
  }
  
  public void e()
  {
    ReadInJoyBaseAdapter localReadInJoyBaseAdapter = this.j;
    if (localReadInJoyBaseAdapter != null) {
      localReadInJoyBaseAdapter.s();
    }
  }
  
  public ViewGroup l()
  {
    return this.a;
  }
  
  public void onClick(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.controller.ReadInJoyProteusFamilyViewController
 * JD-Core Version:    0.7.0.1
 */