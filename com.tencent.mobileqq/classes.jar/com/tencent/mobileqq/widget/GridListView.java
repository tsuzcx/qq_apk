package com.tencent.mobileqq.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListAdapter;
import bcmp;
import bcmq;
import bcms;
import bcmt;
import bfpt;
import com.tencent.widget.XListView;

@Deprecated
public class GridListView
  extends XListView
{
  public int a;
  public View.OnClickListener a;
  public View a;
  public bcms a;
  public bcmt a;
  public bfpt a;
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
    this.jdField_a_of_type_Bcmt = new bcmt(this);
  }
  
  public GridListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_AndroidViewView = new View(getContext());
    this.jdField_a_of_type_Bcmt = new bcmt(this);
  }
  
  public GridListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_AndroidViewView = new View(getContext());
    this.jdField_a_of_type_Bcmt = new bcmt(this);
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
    this.jdField_a_of_type_Bcms = ((bcms)paramListAdapter);
    this.jdField_a_of_type_Bcms.registerDataSetObserver(new bcmp(this));
    this.jdField_a_of_type_Bcms.a(this.jdField_a_of_type_Int);
    this.i = this.jdField_a_of_type_Bcms.a();
    a(this.jdField_a_of_type_Bcms.getCount());
    super.setAdapter(this.jdField_a_of_type_Bcmt);
  }
  
  public void setEmptyView(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    if (this.d == 0) {
      this.jdField_a_of_type_Bcmt.notifyDataSetChanged();
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
      this.jdField_a_of_type_Bcmt.notifyDataSetChanged();
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
      this.jdField_a_of_type_Bcmt.notifyDataSetChanged();
    }
  }
  
  public void setMode(int paramInt)
  {
    if (this.jdField_a_of_type_Int != paramInt)
    {
      this.jdField_a_of_type_Int = paramInt;
      if (this.jdField_a_of_type_Bcms != null)
      {
        this.jdField_a_of_type_Bcms.a(this.jdField_a_of_type_Int);
        b(this.jdField_a_of_type_Bcms.getCount());
      }
      if (this.jdField_a_of_type_Int != 1) {
        break label71;
      }
    }
    label71:
    for (paramInt = this.f;; paramInt = 0)
    {
      setPadding(0, 0, 0, paramInt);
      this.jdField_a_of_type_Bcmt.notifyDataSetChanged();
      return;
    }
  }
  
  public void setNumColumns(int paramInt)
  {
    if (paramInt != this.b)
    {
      this.b = paramInt;
      if (this.jdField_a_of_type_Bcms != null) {
        a(this.jdField_a_of_type_Bcms.getCount());
      }
    }
  }
  
  public void setOnItemClickListener(bfpt parambfpt)
  {
    this.jdField_a_of_type_Bfpt = parambfpt;
    if (this.jdField_a_of_type_AndroidViewView$OnClickListener == null) {
      this.jdField_a_of_type_AndroidViewView$OnClickListener = new bcmq(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.GridListView
 * JD-Core Version:    0.7.0.1
 */