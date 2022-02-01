package com.tencent.mobileqq.kandian.biz.common;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.mobileqq.kandian.biz.pts.item.ProteusItemView;
import com.tencent.widget.XBaseAdapter;
import java.util.HashSet;

public class CustomAnimationAdapter
  extends XBaseAdapter
{
  private HashSet<Integer> a = new HashSet();
  
  private void a(View paramView)
  {
    if ((paramView instanceof ProteusItemView))
    {
      paramView = ((ProteusItemView)paramView).a();
      localValueAnimator = ValueAnimator.ofInt(new int[] { -paramView.getHeight(), 0 });
      localValueAnimator.setDuration(300L);
      localValueAnimator.addUpdateListener(new CustomAnimationAdapter.2(this, paramView));
      localValueAnimator.start();
      return;
    }
    paramView = paramView.findViewById(2131376809);
    if (paramView == null) {
      return;
    }
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { -paramView.getHeight(), 0 });
    localValueAnimator.setDuration(500L);
    localValueAnimator.addUpdateListener(new CustomAnimationAdapter.3(this, paramView));
    localValueAnimator.start();
  }
  
  protected View a(View paramView, int paramInt)
  {
    if (paramView == null) {
      return null;
    }
    if (this.a.contains(Integer.valueOf(paramInt)))
    {
      this.a.remove(Integer.valueOf(paramInt));
      paramView.getViewTreeObserver().addOnPreDrawListener(new CustomAnimationAdapter.1(this, paramView));
    }
    return paramView;
  }
  
  public void a(int paramInt)
  {
    this.a.add(Integer.valueOf(paramInt));
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.CustomAnimationAdapter
 * JD-Core Version:    0.7.0.1
 */