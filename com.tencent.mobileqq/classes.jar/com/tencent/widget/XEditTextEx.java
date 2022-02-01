package com.tencent.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityNodeInfo;
import behh;
import blqy;
import blqz;
import blra;
import blrb;
import blrc;
import blrd;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class XEditTextEx
  extends XEditText
  implements View.OnTouchListener
{
  private int jdField_a_of_type_Int;
  private blqy jdField_a_of_type_Blqy;
  private blqz jdField_a_of_type_Blqz;
  private blra jdField_a_of_type_Blra;
  private blrb jdField_a_of_type_Blrb;
  public blrc a;
  private XEditTextEx.PerformClick jdField_a_of_type_ComTencentWidgetXEditTextEx$PerformClick;
  public Object a;
  private List<WeakReference<View.OnClickListener>> jdField_a_of_type_JavaUtilList;
  private int jdField_b_of_type_Int;
  private List<blrd> jdField_b_of_type_JavaUtilList = new ArrayList();
  
  public XEditTextEx(Context paramContext)
  {
    super(paramContext);
  }
  
  public XEditTextEx(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilList.add(new WeakReference(paramOnClickListener));
  }
  
  public void a(@Nullable blrd paramblrd)
  {
    this.jdField_b_of_type_JavaUtilList.add(paramblrd);
  }
  
  public boolean a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return (paramFloat1 >= -paramFloat3) && (paramFloat2 >= -paramFloat3) && (paramFloat1 < getRight() - getLeft() + paramFloat3) && (paramFloat2 < getBottom() - getTop() + paramFloat3);
  }
  
  public void b(@Nullable blrd paramblrd)
  {
    this.jdField_b_of_type_JavaUtilList.remove(paramblrd);
  }
  
  public boolean dispatchKeyEventPreIme(KeyEvent paramKeyEvent)
  {
    if ((this.jdField_a_of_type_Blqy != null) && (this.jdField_a_of_type_Blqy.a(paramKeyEvent))) {
      return true;
    }
    return super.dispatchKeyEventPreIme(paramKeyEvent);
  }
  
  public boolean onCheckIsTextEditor()
  {
    if (this.jdField_a_of_type_Blqz != null) {
      return this.jdField_a_of_type_Blqz.a();
    }
    return super.onCheckIsTextEditor();
  }
  
  @TargetApi(14)
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    String str = behh.e(getText().toString());
    paramAccessibilityNodeInfo.setText(str);
    paramAccessibilityNodeInfo.setContentDescription(str);
  }
  
  public boolean onPrivateIMECommand(String paramString, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("XEditTextEx", 1, "onPrivateIMECommand(), action:" + paramString + " data:" + paramBundle);
    }
    if (this.jdField_a_of_type_Blra != null) {
      return this.jdField_a_of_type_Blra.a(paramString, paramBundle);
    }
    return super.onPrivateIMECommand(paramString, paramBundle);
  }
  
  public boolean onTextContextMenuItem(int paramInt)
  {
    for (;;)
    {
      try
      {
        Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
        if (!localIterator.hasNext()) {
          continue;
        }
        localblrd = (blrd)localIterator.next();
        switch (paramInt)
        {
        case 16908320: 
          if (!localblrd.b()) {
            continue;
          }
          return true;
        }
      }
      catch (Throwable localThrowable)
      {
        try
        {
          blrd localblrd;
          boolean bool = super.onTextContextMenuItem(paramInt);
          return bool;
        }
        catch (Exception localException)
        {
          if (!QLog.isColorLevel()) {
            break;
          }
        }
        QLog.d("XEditTextEx", 2, "onTextContextMenuItem has exception,", localException);
        return false;
      }
      if (localblrd.a())
      {
        return true;
        bool = localblrd.c();
        if (bool) {
          return true;
        }
      }
    }
    return false;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (!paramView.isClickable()) {}
    float f1;
    float f2;
    long l;
    do
    {
      return false;
      f1 = paramMotionEvent.getX();
      f2 = paramMotionEvent.getY();
      int i = paramMotionEvent.getAction();
      l = System.currentTimeMillis();
      if (this.jdField_a_of_type_Int == 0) {
        this.jdField_a_of_type_Int = ViewConfiguration.get(getContext()).getScaledTouchSlop();
      }
      if (this.jdField_b_of_type_Int == 0) {
        this.jdField_b_of_type_Int = ViewConfiguration.getLongPressTimeout();
      }
      switch (i)
      {
      default: 
        return false;
      case 0: 
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx$PerformClick = new XEditTextEx.PerformClick(this, paramView, l);
        return false;
      case 3: 
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx$PerformClick = null;
        return false;
      }
    } while (a(f1, f2, this.jdField_a_of_type_Int));
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx$PerformClick = null;
    return false;
    if ((this.jdField_a_of_type_ComTencentWidgetXEditTextEx$PerformClick != null) && (Math.abs(l - this.jdField_a_of_type_ComTencentWidgetXEditTextEx$PerformClick.a) < this.jdField_b_of_type_Int)) {
      post(this.jdField_a_of_type_ComTencentWidgetXEditTextEx$PerformClick);
    }
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx$PerformClick = null;
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (this.jdField_a_of_type_Blrb != null) {
      this.jdField_a_of_type_Blrb.a(paramBoolean);
    }
  }
  
  public void scrollTo(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_Blqz == null) || (this.jdField_a_of_type_Blqz.a())) {
      super.scrollTo(paramInt1, paramInt2);
    }
  }
  
  public void setKeyEventPreImeListener(blqy paramblqy)
  {
    this.jdField_a_of_type_Blqy = paramblqy;
  }
  
  public void setOnKeyboardShowListener(blqz paramblqz)
  {
    this.jdField_a_of_type_Blqz = paramblqz;
  }
  
  public void setOnPrivateIMECommandListener(blra paramblra)
  {
    this.jdField_a_of_type_Blra = paramblra;
  }
  
  public void setOnWindowFocusChangedListener(blrb paramblrb)
  {
    this.jdField_a_of_type_Blrb = paramblrb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.widget.XEditTextEx
 * JD-Core Version:    0.7.0.1
 */