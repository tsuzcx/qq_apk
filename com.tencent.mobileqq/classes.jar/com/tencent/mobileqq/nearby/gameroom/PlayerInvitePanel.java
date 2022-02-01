package com.tencent.mobileqq.nearby.gameroom;

import android.content.Context;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import java.util.LinkedList;
import java.util.List;

public class PlayerInvitePanel
  extends AdapterView<BaseAdapter>
{
  private BaseAdapter a;
  private List<View> b = new LinkedList();
  private AdapterView.OnItemClickListener c;
  private int d = 5;
  private DataSetObserver e = new PlayerInvitePanel.2(this);
  
  public PlayerInvitePanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void a()
  {
    b();
    detachAllViewsFromParent();
    int i = 0;
    while (i < this.a.getCount())
    {
      View localView = this.a.getView(i, c(), this);
      localView.setOnClickListener(new PlayerInvitePanel.1(this, i));
      addViewInLayout(localView, i, new ViewGroup.LayoutParams(-2, -2));
      i += 1;
    }
    requestLayout();
  }
  
  protected void b()
  {
    this.b.clear();
    int i = 0;
    while (i < getChildCount())
    {
      this.b.add(getChildAt(i));
      i += 1;
    }
  }
  
  protected View c()
  {
    if (!this.b.isEmpty()) {
      return (View)this.b.remove(0);
    }
    return null;
  }
  
  public BaseAdapter getAdapter()
  {
    return this.a;
  }
  
  public View getSelectedView()
  {
    return null;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int k = super.getChildCount();
    int i = this.d;
    if (k <= i) {
      i = k;
    }
    int m = paramInt3 - paramInt1;
    int j = 0;
    while (j < k)
    {
      View localView = super.getChildAt(j);
      int n = localView.getMeasuredWidth();
      int i1 = localView.getMeasuredHeight();
      int i3 = this.d;
      int i4 = (m - i3 * n) / (i3 + 1);
      int i2 = (m - i * n - (i - 1) * i4) / 2 + (n + i4) * (j % i3);
      i3 = (i4 + i1) * (j / i3);
      localView.layout(i2, i3, n + i2, i1 + i3);
      j += 1;
    }
    invalidate(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      measureChild(getChildAt(i), paramInt1, paramInt2);
      i += 1;
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void setAdapter(BaseAdapter paramBaseAdapter)
  {
    this.a = paramBaseAdapter;
    paramBaseAdapter = this.a;
    if (paramBaseAdapter != null) {
      paramBaseAdapter.registerDataSetObserver(this.e);
    }
    a();
  }
  
  public void setColumnCount(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this.c = paramOnItemClickListener;
  }
  
  public void setSelection(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gameroom.PlayerInvitePanel
 * JD-Core Version:    0.7.0.1
 */