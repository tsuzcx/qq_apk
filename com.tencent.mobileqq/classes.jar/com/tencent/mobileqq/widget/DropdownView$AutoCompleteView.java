package com.tencent.mobileqq.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.PopupWindow;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

class DropdownView$AutoCompleteView
  extends AutoCompleteTextView
{
  private boolean jdField_a_of_type_Boolean;
  
  public DropdownView$AutoCompleteView(DropdownView paramDropdownView, Context paramContext)
  {
    super(paramContext);
    setId(526);
    this.jdField_a_of_type_Boolean = true;
  }
  
  public DropdownView$AutoCompleteView(DropdownView paramDropdownView, Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setId(526);
    this.jdField_a_of_type_Boolean = true;
  }
  
  public DropdownView$AutoCompleteView(DropdownView paramDropdownView, Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setId(526);
    this.jdField_a_of_type_Boolean = true;
  }
  
  public boolean enoughToFilter()
  {
    return true;
  }
  
  public boolean isPopupShowing()
  {
    if (this.jdField_a_of_type_Boolean) {
      return super.isPopupShowing();
    }
    return false;
  }
  
  public void onEditorAction(int paramInt)
  {
    if (paramInt == 5)
    {
      View localView = focusSearch(130);
      if (localView != null)
      {
        if (localView.requestFocus(130)) {
          return;
        }
        throw new IllegalStateException("focus search returned a view that wasn't able to take focus!");
      }
      return;
    }
    super.onEditorAction(paramInt);
  }
  
  protected void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    try
    {
      if (isPopupShowing()) {
        dismissDropDown();
      }
      return;
    }
    catch (Exception paramCharSequence) {}
  }
  
  protected void performFiltering(CharSequence paramCharSequence, int paramInt) {}
  
  public void showDropDown()
  {
    try
    {
      super.showDropDown();
      if (Build.VERSION.SDK_INT <= 8) {
        return;
      }
      Object localObject1;
      label76:
      Object localObject2;
      return;
    }
    catch (Exception localException1)
    {
      try
      {
        localObject1 = getClass().getSuperclass().getDeclaredField("mDropDownList");
        ((Field)localObject1).setAccessible(true);
        localObject1 = ((Field)localObject1).get(this);
        localObject1.getClass().getSuperclass().getMethod("setDividerHeight", new Class[] { Integer.TYPE }).invoke(localObject1, new Object[] { Integer.valueOf(0) });
        return;
      }
      catch (Exception localException2)
      {
        break label76;
      }
      try
      {
        localObject1 = getClass().getSuperclass().getDeclaredField("mPopup");
        ((Field)localObject1).setAccessible(true);
        localObject1 = ((Field)localObject1).get(this);
        localObject2 = localObject1.getClass().getDeclaredField("mDropDownList");
        ((Field)localObject2).setAccessible(true);
        localObject2 = ((Field)localObject2).get(localObject1);
        localObject2.getClass().getSuperclass().getMethod("setDividerHeight", new Class[] { Integer.TYPE }).invoke(localObject2, new Object[] { Integer.valueOf(0) });
        ((PopupWindow)localObject1).setAnimationStyle(2130772343);
        return;
      }
      catch (Exception localException3) {}
      localException1 = localException1;
      localException1.printStackTrace();
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      localOutOfMemoryError.printStackTrace();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.DropdownView.AutoCompleteView
 * JD-Core Version:    0.7.0.1
 */