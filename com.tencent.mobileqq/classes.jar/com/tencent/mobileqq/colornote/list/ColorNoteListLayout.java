package com.tencent.mobileqq.colornote.list;

import amin;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
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
  private amin jdField_a_of_type_Amin;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private View jdField_a_of_type_AndroidViewView;
  private int[] jdField_a_of_type_ArrayOfInt = new int[2];
  private int b;
  private int c = -1;
  
  public ColorNoteListLayout(@NonNull Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public ColorNoteListLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public ColorNoteListLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
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
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setId(2131364398);
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
      if ((paramKeyEvent.getAction() == 1) && (this.jdField_a_of_type_Amin != null)) {
        this.jdField_a_of_type_Amin.a();
      }
      return true;
    }
    return false;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = 0;
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (!paramBoolean) {
      return;
    }
    Object localObject;
    if (this.c < 0)
    {
      if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildCount() <= 0) {
        break label269;
      }
      paramInt1 = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildAt(0).getMeasuredHeight();
      localObject = (RecyclerView.LayoutParams)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildAt(0).getLayoutParams();
      paramInt3 = ((RecyclerView.LayoutParams)localObject).topMargin;
    }
    label269:
    for (paramInt3 = ((RecyclerView.LayoutParams)localObject).bottomMargin + (paramInt1 + paramInt3);; paramInt3 = 0)
    {
      paramInt1 = i;
      int j;
      if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildCount() <= 4)
      {
        getLocationOnScreen(this.jdField_a_of_type_ArrayOfInt);
        paramInt4 = paramInt3 * this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildCount();
        j = this.jdField_a_of_type_ArrayOfInt[1];
        if (((View)getParent()).getMeasuredHeight() - this.jdField_a_of_type_Int - getPaddingBottom() + j < paramInt4) {
          break label202;
        }
        paramInt1 = this.jdField_a_of_type_Int - j;
      }
      while (paramInt3 > 0)
      {
        this.c = paramInt1;
        localObject = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject).height = this.c;
        this.jdField_a_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        return;
        label202:
        paramInt1 = i;
        if (this.b - paramInt2 - getPaddingTop() + j >= paramInt4) {
          paramInt1 = this.b - paramInt4 - j;
        }
      }
      break;
      localObject = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).height = this.c;
      this.jdField_a_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
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
  
  public void setHideListener(amin paramamin)
  {
    this.jdField_a_of_type_Amin = paramamin;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.list.ColorNoteListLayout
 * JD-Core Version:    0.7.0.1
 */