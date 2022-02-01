package com.tencent.mobileqq.troop.troopcreate.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.util.DisplayUtil;
import java.util.ArrayList;

public class SubCateListView
{
  protected final ViewStub a;
  protected final Context b;
  protected final View.OnClickListener c;
  protected final SubCateListView.OnToggleSubListListener d;
  protected boolean e = false;
  protected View f;
  protected SubCateListAdapter g;
  protected SingleItemViewHolder h;
  
  public SubCateListView(ViewStub paramViewStub, Context paramContext, View.OnClickListener paramOnClickListener, SubCateListView.OnToggleSubListListener paramOnToggleSubListListener)
  {
    this.a = paramViewStub;
    this.b = paramContext;
    this.c = paramOnClickListener;
    this.d = paramOnToggleSubListListener;
  }
  
  private void a(View paramView, int paramInt1, int paramInt2, Interpolator paramInterpolator, boolean paramBoolean)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { paramInt1, paramInt2 });
    localValueAnimator.setDuration(200L);
    localValueAnimator.setInterpolator(paramInterpolator);
    localValueAnimator.addUpdateListener(new SubCateListView.1(this, paramView));
    localValueAnimator.addListener(new SubCateListView.2(this, paramBoolean, paramView, paramInt2));
    localValueAnimator.start();
  }
  
  private void a(SingleItemViewHolder paramSingleItemViewHolder, boolean paramBoolean)
  {
    ValueAnimator localValueAnimator;
    if (paramBoolean) {
      localValueAnimator = ValueAnimator.ofInt(new int[] { 0, 100 });
    } else {
      localValueAnimator = ValueAnimator.ofInt(new int[] { 100, 0 });
    }
    localValueAnimator.setDuration(200L);
    localValueAnimator.setInterpolator(new LinearInterpolator());
    localValueAnimator.addUpdateListener(new SubCateListView.3(this, paramSingleItemViewHolder));
    localValueAnimator.start();
  }
  
  private void b()
  {
    if (this.e) {
      return;
    }
    this.e = true;
    this.f = this.a.inflate();
    GridView localGridView = (GridView)this.f.findViewById(2131446523);
    this.g = new SubCateListAdapter(this.b, this.c);
    localGridView.setAdapter(this.g);
  }
  
  public void a()
  {
    this.h = null;
    if (this.e) {
      this.f.setVisibility(8);
    }
  }
  
  public boolean a(SingleItemViewHolder paramSingleItemViewHolder, TroopCateListProvider.TroopCateInfo paramTroopCateInfo)
  {
    b();
    int i;
    if (this.h != null)
    {
      i = ((LinearLayout.LayoutParams)this.f.getLayoutParams()).height;
      localObject = this.h;
      if (localObject == paramSingleItemViewHolder)
      {
        a(paramSingleItemViewHolder, false);
        a(this.f, i, 0, new DecelerateInterpolator(), true);
        this.h = null;
        return false;
      }
      a((SingleItemViewHolder)localObject, false);
    }
    else
    {
      i = 0;
    }
    this.g.a(paramTroopCateInfo);
    this.h = paramSingleItemViewHolder;
    Object localObject = new int[2];
    paramSingleItemViewHolder.d.getLocationInWindow((int[])localObject);
    int j = (int)Math.ceil(paramTroopCateInfo.g.size() / 3.0F);
    j = DisplayUtil.a(this.b, j * 56 - 13 + 30);
    this.f.setVisibility(0);
    a(paramSingleItemViewHolder, true);
    a(this.f, i, j, new AccelerateInterpolator(), false);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcreate.ui.SubCateListView
 * JD-Core Version:    0.7.0.1
 */