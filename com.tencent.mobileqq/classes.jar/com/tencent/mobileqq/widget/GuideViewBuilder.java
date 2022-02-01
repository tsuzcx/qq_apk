package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.util.Pair;
import android.util.SparseArray;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import java.util.ArrayList;

public class GuideViewBuilder
{
  GuideViewBuilder.GuideView a;
  Context b;
  public PopupWindow c;
  private SparseArray<GuideViewBuilder.GuideTarget> d = new SparseArray();
  
  public GuideViewBuilder(Context paramContext)
  {
    this.b = paramContext;
    this.a = new GuideViewBuilder.GuideView(this, paramContext);
    this.c = new PopupWindow(this.b);
    this.c.setWindowLayoutMode(-1, -1);
    this.c.setFocusable(true);
    this.c.setBackgroundDrawable(new ColorDrawable(this.b.getResources().getColor(2131165809)));
  }
  
  public GuideViewBuilder a(int paramInt, View paramView, GuideViewBuilder.GuideLayoutParams paramGuideLayoutParams)
  {
    GuideViewBuilder.GuideTarget localGuideTarget = (GuideViewBuilder.GuideTarget)this.d.get(paramInt);
    if (localGuideTarget != null) {
      localGuideTarget.c.add(new Pair(paramView, paramGuideLayoutParams));
    }
    return this;
  }
  
  public GuideViewBuilder a(View paramView, int paramInt)
  {
    if (this.d.get(paramInt) == null)
    {
      GuideViewBuilder.GuideTarget localGuideTarget = new GuideViewBuilder.GuideTarget(this, null);
      localGuideTarget.a = paramView;
      if (paramView.isShown())
      {
        localGuideTarget.b = new int[2];
        paramView.getLocationOnScreen(localGuideTarget.b);
      }
      this.d.put(paramInt, localGuideTarget);
    }
    return this;
  }
  
  public void a(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    a(paramOnDismissListener, true);
  }
  
  public void a(PopupWindow.OnDismissListener paramOnDismissListener, boolean paramBoolean)
  {
    this.c.setContentView(this.a);
    this.c.showAtLocation(new View(this.b), 0, 0, 0);
    this.c.setOnDismissListener(paramOnDismissListener);
    this.a.setOnClickListener(new GuideViewBuilder.1(this, paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.GuideViewBuilder
 * JD-Core Version:    0.7.0.1
 */