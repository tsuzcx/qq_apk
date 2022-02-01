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
import com.tencent.mobileqq.text.TextUtils;
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
  private XEditTextEx.OnKeyEventPreImeListener jdField_a_of_type_ComTencentWidgetXEditTextEx$OnKeyEventPreImeListener;
  private XEditTextEx.OnKeyboardShowListener jdField_a_of_type_ComTencentWidgetXEditTextEx$OnKeyboardShowListener;
  private XEditTextEx.OnPrivateIMECommandListener jdField_a_of_type_ComTencentWidgetXEditTextEx$OnPrivateIMECommandListener;
  private XEditTextEx.OnWindowFocusChangedListener jdField_a_of_type_ComTencentWidgetXEditTextEx$OnWindowFocusChangedListener;
  private XEditTextEx.PerformClick jdField_a_of_type_ComTencentWidgetXEditTextEx$PerformClick;
  public Object a;
  private List<WeakReference<View.OnClickListener>> jdField_a_of_type_JavaUtilList;
  private int jdField_b_of_type_Int;
  private List<XEditTextEx.TextMenuListener> jdField_b_of_type_JavaUtilList = new ArrayList();
  
  public XEditTextEx(Context paramContext)
  {
    super(paramContext);
  }
  
  public XEditTextEx(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a()
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList != null) {
      localList.clear();
    }
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilList.add(new WeakReference(paramOnClickListener));
  }
  
  public void a(@Nullable XEditTextEx.TextMenuListener paramTextMenuListener)
  {
    this.jdField_b_of_type_JavaUtilList.add(paramTextMenuListener);
  }
  
  public boolean a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    float f = -paramFloat3;
    return (paramFloat1 >= f) && (paramFloat2 >= f) && (paramFloat1 < getRight() - getLeft() + paramFloat3) && (paramFloat2 < getBottom() - getTop() + paramFloat3);
  }
  
  public void b(@Nullable XEditTextEx.TextMenuListener paramTextMenuListener)
  {
    this.jdField_b_of_type_JavaUtilList.remove(paramTextMenuListener);
  }
  
  public boolean dispatchKeyEventPreIme(KeyEvent paramKeyEvent)
  {
    XEditTextEx.OnKeyEventPreImeListener localOnKeyEventPreImeListener = this.jdField_a_of_type_ComTencentWidgetXEditTextEx$OnKeyEventPreImeListener;
    if ((localOnKeyEventPreImeListener != null) && (localOnKeyEventPreImeListener.a(paramKeyEvent))) {
      return true;
    }
    return super.dispatchKeyEventPreIme(paramKeyEvent);
  }
  
  public boolean onCheckIsTextEditor()
  {
    XEditTextEx.OnKeyboardShowListener localOnKeyboardShowListener = this.jdField_a_of_type_ComTencentWidgetXEditTextEx$OnKeyboardShowListener;
    if (localOnKeyboardShowListener != null) {
      return localOnKeyboardShowListener.a();
    }
    return super.onCheckIsTextEditor();
  }
  
  @TargetApi(14)
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    String str = TextUtils.emoticonToTextForTalkBack(getText().toString());
    paramAccessibilityNodeInfo.setText(str);
    paramAccessibilityNodeInfo.setContentDescription(str);
  }
  
  public boolean onPrivateIMECommand(String paramString, Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onPrivateIMECommand(), action:");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" data:");
      ((StringBuilder)localObject).append(paramBundle);
      QLog.d("XEditTextEx", 1, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_ComTencentWidgetXEditTextEx$OnPrivateIMECommandListener;
    if (localObject != null) {
      return ((XEditTextEx.OnPrivateIMECommandListener)localObject).a(paramString, paramBundle);
    }
    return super.onPrivateIMECommand(paramString, paramBundle);
  }
  
  public boolean onTextContextMenuItem(int paramInt)
  {
    try
    {
      Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
      boolean bool;
      while (localIterator.hasNext())
      {
        XEditTextEx.TextMenuListener localTextMenuListener = (XEditTextEx.TextMenuListener)localIterator.next();
        switch (paramInt)
        {
        case 16908322: 
          if (localTextMenuListener.c()) {
            return true;
          }
          break;
        case 16908321: 
          if (localTextMenuListener.a()) {
            return true;
          }
          break;
        case 16908320: 
          bool = localTextMenuListener.b();
          if (bool) {
            return true;
          }
          break;
        }
      }
      try
      {
        bool = super.onTextContextMenuItem(paramInt);
        return bool;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("XEditTextEx", 2, "onTextContextMenuItem has exception,", localException);
        }
        return false;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;) {}
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (!paramView.isClickable()) {
      return false;
    }
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    int i = paramMotionEvent.getAction();
    long l = System.currentTimeMillis();
    if (this.jdField_a_of_type_Int == 0) {
      this.jdField_a_of_type_Int = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }
    if (this.jdField_b_of_type_Int == 0) {
      this.jdField_b_of_type_Int = ViewConfiguration.getLongPressTimeout();
    }
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3) {
            return false;
          }
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx$PerformClick = null;
          return false;
        }
        if (!a(f1, f2, this.jdField_a_of_type_Int))
        {
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx$PerformClick = null;
          return false;
        }
      }
      else
      {
        paramView = this.jdField_a_of_type_ComTencentWidgetXEditTextEx$PerformClick;
        if ((paramView != null) && (Math.abs(l - paramView.a) < this.jdField_b_of_type_Int)) {
          post(this.jdField_a_of_type_ComTencentWidgetXEditTextEx$PerformClick);
        }
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx$PerformClick = null;
        return false;
      }
    }
    else {
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx$PerformClick = new XEditTextEx.PerformClick(this, paramView, l);
    }
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    XEditTextEx.OnWindowFocusChangedListener localOnWindowFocusChangedListener = this.jdField_a_of_type_ComTencentWidgetXEditTextEx$OnWindowFocusChangedListener;
    if (localOnWindowFocusChangedListener != null) {
      localOnWindowFocusChangedListener.a(paramBoolean);
    }
  }
  
  public void scrollTo(int paramInt1, int paramInt2)
  {
    XEditTextEx.OnKeyboardShowListener localOnKeyboardShowListener = this.jdField_a_of_type_ComTencentWidgetXEditTextEx$OnKeyboardShowListener;
    if ((localOnKeyboardShowListener == null) || (localOnKeyboardShowListener.a())) {
      super.scrollTo(paramInt1, paramInt2);
    }
  }
  
  public void setKeyEventPreImeListener(XEditTextEx.OnKeyEventPreImeListener paramOnKeyEventPreImeListener)
  {
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx$OnKeyEventPreImeListener = paramOnKeyEventPreImeListener;
  }
  
  public void setOnKeyboardShowListener(XEditTextEx.OnKeyboardShowListener paramOnKeyboardShowListener)
  {
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx$OnKeyboardShowListener = paramOnKeyboardShowListener;
  }
  
  public void setOnPrivateIMECommandListener(XEditTextEx.OnPrivateIMECommandListener paramOnPrivateIMECommandListener)
  {
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx$OnPrivateIMECommandListener = paramOnPrivateIMECommandListener;
  }
  
  public void setOnWindowFocusChangedListener(XEditTextEx.OnWindowFocusChangedListener paramOnWindowFocusChangedListener)
  {
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx$OnWindowFocusChangedListener = paramOnWindowFocusChangedListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.XEditTextEx
 * JD-Core Version:    0.7.0.1
 */