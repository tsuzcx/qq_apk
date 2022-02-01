package com.tencent.mobileqq.colornote.list;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

public class ColorNoteListLayout
  extends LinearLayout
{
  private int jdField_a_of_type_Int;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private View jdField_a_of_type_AndroidViewView;
  private OnListHideListener jdField_a_of_type_ComTencentMobileqqColornoteListOnListHideListener;
  private int[] jdField_a_of_type_ArrayOfInt = new int[2];
  private int b;
  private int c = -1;
  
  public ColorNoteListLayout(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public ColorNoteListLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public ColorNoteListLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    setOrientation(1);
    this.jdField_a_of_type_AndroidViewView = new View(paramContext);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    addView(this.jdField_a_of_type_AndroidViewView, localLayoutParams);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = new RecyclerView(paramContext);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setId(2131364848);
    paramContext = new LinearLayout.LayoutParams(-1, -1);
    addView(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView, paramContext);
  }
  
  public RecyclerView a()
  {
    return this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent.getKeyCode() == 4)
    {
      if (paramKeyEvent.getAction() == 1)
      {
        paramKeyEvent = this.jdField_a_of_type_ComTencentMobileqqColornoteListOnListHideListener;
        if (paramKeyEvent != null) {
          paramKeyEvent.b();
        }
      }
      return true;
    }
    return false;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (!paramBoolean) {
      return;
    }
    Object localObject;
    if (this.c < 0)
    {
      paramInt1 = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildCount();
      paramInt4 = 0;
      if (paramInt1 > 0)
      {
        paramInt1 = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildAt(0).getMeasuredHeight();
        localObject = (RecyclerView.LayoutParams)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildAt(0).getLayoutParams();
        paramInt1 = paramInt1 + ((RecyclerView.LayoutParams)localObject).topMargin + ((RecyclerView.LayoutParams)localObject).bottomMargin;
      }
      else
      {
        paramInt1 = 0;
      }
      paramInt3 = paramInt4;
      if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildCount() <= 4)
      {
        getLocationOnScreen(this.jdField_a_of_type_ArrayOfInt);
        int j = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildCount() * paramInt1;
        int i = this.jdField_a_of_type_ArrayOfInt[1];
        if (((View)getParent()).getMeasuredHeight() - this.jdField_a_of_type_Int - getPaddingBottom() + i >= j) {}
        for (paramInt2 = this.jdField_a_of_type_Int;; paramInt2 = this.b - j)
        {
          paramInt3 = paramInt2 - i;
          break;
          paramInt3 = paramInt4;
          if (this.b - paramInt2 - getPaddingTop() + i < j) {
            break;
          }
        }
      }
      if (paramInt1 > 0)
      {
        this.c = paramInt3;
        localObject = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject).height = this.c;
        this.jdField_a_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
    else
    {
      localObject = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).height = this.c;
      this.jdField_a_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setAnchor(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  public void setHideListener(OnListHideListener paramOnListHideListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqColornoteListOnListHideListener = paramOnListHideListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.list.ColorNoteListLayout
 * JD-Core Version:    0.7.0.1
 */