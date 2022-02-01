package com.tencent.mobileqq.emosm.view;

import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.Recycler;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;
import android.view.View.OnClickListener;

public class CardLayoutManager
  extends RecyclerView.LayoutManager
{
  private View.OnClickListener a;
  
  public CardLayoutManager(View.OnClickListener paramOnClickListener)
  {
    this.a = paramOnClickListener;
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    layoutDecorated(paramView, paramInt1 + localLayoutParams.leftMargin, paramInt2 + localLayoutParams.topMargin, paramInt3 - localLayoutParams.rightMargin, paramInt4 - localLayoutParams.bottomMargin);
  }
  
  public RecyclerView.LayoutParams generateDefaultLayoutParams()
  {
    return new RecyclerView.LayoutParams(-2, -2);
  }
  
  public void onLayoutChildren(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    detachAndScrapAttachedViews(paramRecycler);
    int i = getItemCount();
    int k;
    int m;
    int j;
    float f;
    View.OnClickListener localOnClickListener;
    if (i > 3)
    {
      i = 3;
      while (i >= 0)
      {
        paramState = paramRecycler.getViewForPosition(i);
        addView(paramState);
        measureChildWithMargins(paramState, 0, 0);
        k = getWidth();
        m = getDecoratedMeasuredWidth(paramState);
        j = getHeight() - getDecoratedMeasuredHeight(paramState);
        k = (k - m) / 2;
        a(paramState, k, j, k + getDecoratedMeasuredWidth(paramState), getDecoratedMeasuredHeight(paramState) + j);
        if (i == 3)
        {
          j = i - 1;
          f = 1.0F - j * 0.1F;
          paramState.setScaleX(f);
          paramState.setScaleY(f);
          paramState.setTranslationY(j * paramState.getMeasuredHeight() / -10);
          paramState.setAlpha(0.8F);
        }
        else if (i > 0)
        {
          f = 1.0F - i * 0.1F;
          paramState.setScaleX(f);
          paramState.setScaleY(f);
          paramState.setTranslationY(paramState.getMeasuredHeight() * i / -10);
          paramState.setAlpha(0.6F);
        }
        else
        {
          localOnClickListener = this.a;
          if (localOnClickListener != null) {
            paramState.setOnClickListener(localOnClickListener);
          }
        }
        i -= 1;
      }
    }
    i -= 1;
    while (i >= 0)
    {
      paramState = paramRecycler.getViewForPosition(i);
      addView(paramState);
      measureChildWithMargins(paramState, 0, 0);
      k = getWidth();
      m = getDecoratedMeasuredWidth(paramState);
      j = getHeight() - getDecoratedMeasuredHeight(paramState);
      k = (k - m) / 2;
      a(paramState, k, j, k + getDecoratedMeasuredWidth(paramState), getDecoratedMeasuredHeight(paramState) + j);
      if (i > 0)
      {
        f = 1.0F - i * 0.1F;
        paramState.setScaleX(f);
        paramState.setScaleY(f);
        paramState.setTranslationY(paramState.getMeasuredHeight() * i / -10);
      }
      else
      {
        localOnClickListener = this.a;
        if (localOnClickListener != null) {
          paramState.setOnClickListener(localOnClickListener);
        }
      }
      i -= 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.view.CardLayoutManager
 * JD-Core Version:    0.7.0.1
 */