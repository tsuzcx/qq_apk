package com.tencent.mobileqq.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListAdapter;
import bbjd;
import bbje;
import bbjg;
import bbjh;
import behi;
import com.tencent.widget.XListView;

@Deprecated
public class GridListView
  extends XListView
{
  public int a;
  public View.OnClickListener a;
  public View a;
  public bbjg a;
  public bbjh a;
  public behi a;
  public int b = 4;
  public int c = 0;
  public int d;
  public int e;
  public int f;
  public int g;
  public int h;
  public int i;
  
  public GridListView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_AndroidViewView = new View(getContext());
    this.jdField_a_of_type_Bbjh = new bbjh(this);
  }
  
  public GridListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_AndroidViewView = new View(getContext());
    this.jdField_a_of_type_Bbjh = new bbjh(this);
  }
  
  public GridListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_AndroidViewView = new View(getContext());
    this.jdField_a_of_type_Bbjh = new bbjh(this);
  }
  
  private void a(int paramInt)
  {
    if (this.d != paramInt) {
      b(paramInt);
    }
  }
  
  private void b(int paramInt)
  {
    this.d = paramInt;
    this.c = this.d;
    if (this.jdField_a_of_type_Int == 1) {
      this.c = ((this.d + this.b - 1) / this.b);
    }
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    if (paramListAdapter == null) {
      return;
    }
    this.jdField_a_of_type_Bbjg = ((bbjg)paramListAdapter);
    this.jdField_a_of_type_Bbjg.registerDataSetObserver(new bbjd(this));
    this.jdField_a_of_type_Bbjg.a(this.jdField_a_of_type_Int);
    this.i = this.jdField_a_of_type_Bbjg.a();
    a(this.jdField_a_of_type_Bbjg.getCount());
    super.setAdapter(this.jdField_a_of_type_Bbjh);
  }
  
  public void setEmptyView(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    if (this.d == 0) {
      this.jdField_a_of_type_Bbjh.notifyDataSetChanged();
    }
  }
  
  public void setGridSize(int paramInt)
  {
    setGridSize(paramInt, paramInt);
  }
  
  public void setGridSize(int paramInt1, int paramInt2)
  {
    if ((this.g != paramInt1) || (this.h != paramInt2))
    {
      this.g = paramInt1;
      this.h = paramInt2;
      this.jdField_a_of_type_Bbjh.notifyDataSetChanged();
    }
  }
  
  public void setGridSpacing(int paramInt1, int paramInt2)
  {
    if ((this.e != paramInt1) || (this.f != paramInt2))
    {
      this.e = paramInt1;
      this.f = paramInt2;
      if (this.jdField_a_of_type_Int == 1) {
        setPadding(0, 0, 0, this.f);
      }
      this.jdField_a_of_type_Bbjh.notifyDataSetChanged();
    }
  }
  
  public void setMode(int paramInt)
  {
    if (this.jdField_a_of_type_Int != paramInt)
    {
      this.jdField_a_of_type_Int = paramInt;
      if (this.jdField_a_of_type_Bbjg != null)
      {
        this.jdField_a_of_type_Bbjg.a(this.jdField_a_of_type_Int);
        b(this.jdField_a_of_type_Bbjg.getCount());
      }
      if (this.jdField_a_of_type_Int != 1) {
        break label71;
      }
    }
    label71:
    for (paramInt = this.f;; paramInt = 0)
    {
      setPadding(0, 0, 0, paramInt);
      this.jdField_a_of_type_Bbjh.notifyDataSetChanged();
      return;
    }
  }
  
  public void setNumColumns(int paramInt)
  {
    if (paramInt != this.b)
    {
      this.b = paramInt;
      if (this.jdField_a_of_type_Bbjg != null) {
        a(this.jdField_a_of_type_Bbjg.getCount());
      }
    }
  }
  
  public void setOnItemClickListener(behi parambehi)
  {
    this.jdField_a_of_type_Behi = parambehi;
    if (this.jdField_a_of_type_AndroidViewView$OnClickListener == null) {
      this.jdField_a_of_type_AndroidViewView$OnClickListener = new bbje(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.GridListView
 * JD-Core Version:    0.7.0.1
 */