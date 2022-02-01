package com.tencent.mobileqq.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.XListView;

@Deprecated
public class GridListView
  extends XListView
{
  GridListView.GridListAdapter a;
  int b = 0;
  int c = 4;
  int d = 0;
  AdapterView.OnItemClickListener e;
  View.OnClickListener f;
  int g;
  int h;
  int i;
  int j;
  int k;
  View l = new View(getContext());
  GridListView.WraperAdapter m = new GridListView.WraperAdapter(this);
  int n;
  
  public GridListView(Context paramContext)
  {
    super(paramContext);
  }
  
  public GridListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public GridListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(int paramInt)
  {
    if (this.g != paramInt) {
      b(paramInt);
    }
  }
  
  private void b(int paramInt)
  {
    this.g = paramInt;
    paramInt = this.g;
    this.d = paramInt;
    if (this.b == 1)
    {
      int i1 = this.c;
      this.d = ((paramInt + i1 - 1) / i1);
    }
  }
  
  public int getGridChildCount()
  {
    int i1 = super.getChildCount();
    int i2 = i1;
    if (this.b == 1)
    {
      i2 = i1;
      if (i1 > 0)
      {
        int i3 = i1 - 1;
        LinearLayout localLinearLayout = (LinearLayout)super.getChildAt(i3);
        i2 = i1;
        if (i1 > 1) {
          i2 = this.c * i3;
        }
        i2 += localLinearLayout.getChildCount();
      }
    }
    return i2;
  }
  
  public int getMode()
  {
    return this.b;
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    if (paramListAdapter == null) {
      return;
    }
    this.a = ((GridListView.GridListAdapter)paramListAdapter);
    this.a.registerDataSetObserver(new GridListView.1(this));
    this.a.a(this.b);
    this.n = this.a.a();
    a(this.a.getCount());
    super.setAdapter(this.m);
  }
  
  public void setEmptyView(View paramView)
  {
    this.l = paramView;
    if (this.g == 0) {
      this.m.notifyDataSetChanged();
    }
  }
  
  public void setGridSize(int paramInt)
  {
    setGridSize(paramInt, paramInt);
  }
  
  public void setGridSize(int paramInt1, int paramInt2)
  {
    if ((this.j != paramInt1) || (this.k != paramInt2))
    {
      this.j = paramInt1;
      this.k = paramInt2;
      this.m.notifyDataSetChanged();
    }
  }
  
  public void setGridSpacing(int paramInt1, int paramInt2)
  {
    if ((this.h != paramInt1) || (this.i != paramInt2))
    {
      this.h = paramInt1;
      this.i = paramInt2;
      if (this.b == 1) {
        setPadding(0, 0, 0, this.i);
      }
      this.m.notifyDataSetChanged();
    }
  }
  
  public void setMode(int paramInt)
  {
    if (this.b != paramInt)
    {
      this.b = paramInt;
      GridListView.GridListAdapter localGridListAdapter = this.a;
      if (localGridListAdapter != null)
      {
        localGridListAdapter.a(this.b);
        b(this.a.getCount());
      }
      if (this.b == 1) {
        paramInt = this.i;
      } else {
        paramInt = 0;
      }
      setPadding(0, 0, 0, paramInt);
      this.m.notifyDataSetChanged();
    }
  }
  
  public void setNumColumns(int paramInt)
  {
    if (paramInt != this.c)
    {
      this.c = paramInt;
      GridListView.GridListAdapter localGridListAdapter = this.a;
      if (localGridListAdapter != null) {
        a(localGridListAdapter.getCount());
      }
    }
  }
  
  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this.e = paramOnItemClickListener;
    if (this.f == null) {
      this.f = new GridListView.2(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.GridListView
 * JD-Core Version:    0.7.0.1
 */