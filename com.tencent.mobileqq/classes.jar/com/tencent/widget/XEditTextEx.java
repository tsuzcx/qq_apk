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
import aylc;
import bfxh;
import bfxi;
import bfxj;
import bfxk;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class XEditTextEx
  extends XEditText
  implements View.OnTouchListener
{
  private int jdField_a_of_type_Int;
  private bfxh jdField_a_of_type_Bfxh;
  private bfxi jdField_a_of_type_Bfxi;
  public bfxj a;
  private bfxk jdField_a_of_type_Bfxk;
  private XEditTextEx.PerformClick jdField_a_of_type_ComTencentWidgetXEditTextEx$PerformClick;
  public Object a;
  private List<WeakReference<View.OnClickListener>> jdField_a_of_type_JavaUtilList;
  private int b;
  
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
  
  public boolean a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return (paramFloat1 >= -paramFloat3) && (paramFloat2 >= -paramFloat3) && (paramFloat1 < getRight() - getLeft() + paramFloat3) && (paramFloat2 < getBottom() - getTop() + paramFloat3);
  }
  
  public boolean dispatchKeyEventPreIme(KeyEvent paramKeyEvent)
  {
    if ((this.jdField_a_of_type_Bfxh != null) && (this.jdField_a_of_type_Bfxh.a(paramKeyEvent))) {
      return true;
    }
    return super.dispatchKeyEventPreIme(paramKeyEvent);
  }
  
  @TargetApi(14)
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    String str = aylc.e(getText().toString());
    paramAccessibilityNodeInfo.setText(str);
    paramAccessibilityNodeInfo.setContentDescription(str);
  }
  
  public boolean onPrivateIMECommand(String paramString, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("XEditTextEx", 1, "onPrivateIMECommand(), action:" + paramString + " data:" + paramBundle);
    }
    if (this.jdField_a_of_type_Bfxi != null) {
      return this.jdField_a_of_type_Bfxi.a(paramString, paramBundle);
    }
    return super.onPrivateIMECommand(paramString, paramBundle);
  }
  
  public boolean onTextContextMenuItem(int paramInt)
  {
    for (;;)
    {
      try
      {
        if ((this.jdField_a_of_type_Bfxk != null) && (paramInt == 16908322)) {
          this.jdField_a_of_type_Bfxk.a();
        }
      }
      catch (Throwable localThrowable)
      {
        boolean bool;
        continue;
      }
      try
      {
        bool = super.onTextContextMenuItem(paramInt);
        return bool;
      }
      catch (Exception localException)
      {
        bool = false;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("XEditTextEx", 2, "onTextContextMenuItem has exception,", localException);
        return false;
      }
    }
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
      if (this.b == 0) {
        this.b = ViewConfiguration.getLongPressTimeout();
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
    if ((this.jdField_a_of_type_ComTencentWidgetXEditTextEx$PerformClick != null) && (Math.abs(l - this.jdField_a_of_type_ComTencentWidgetXEditTextEx$PerformClick.a) < this.b)) {
      post(this.jdField_a_of_type_ComTencentWidgetXEditTextEx$PerformClick);
    }
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx$PerformClick = null;
    return false;
  }
  
  public void setKeyEventPreImeListener(bfxh parambfxh)
  {
    this.jdField_a_of_type_Bfxh = parambfxh;
  }
  
  public void setOnPrivateIMECommandListener(bfxi parambfxi)
  {
    this.jdField_a_of_type_Bfxi = parambfxi;
  }
  
  public void setTextMenuListener(@Nullable bfxk parambfxk)
  {
    this.jdField_a_of_type_Bfxk = parambfxk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.widget.XEditTextEx
 * JD-Core Version:    0.7.0.1
 */