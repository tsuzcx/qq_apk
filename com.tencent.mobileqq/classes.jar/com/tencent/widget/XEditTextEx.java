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
import android.view.View.OnLongClickListener;
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
  public Object a;
  private XEditTextEx.OnPrivateIMECommandListener b;
  private int c;
  private int d;
  private XEditTextEx.PerformClick e;
  private XEditTextEx.OnKeyEventPreImeListener f;
  private XEditTextEx.OnWindowFocusChangedListener g;
  private List<WeakReference<View.OnClickListener>> h;
  private View.OnLongClickListener i;
  private List<XEditTextEx.TextMenuListener> j = new ArrayList();
  private XEditTextEx.OnKeyboardShowListener k;
  
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
    List localList = this.h;
    if (localList != null) {
      localList.clear();
    }
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    if (this.h == null) {
      this.h = new ArrayList();
    }
    this.h.add(new WeakReference(paramOnClickListener));
  }
  
  public void a(@Nullable XEditTextEx.TextMenuListener paramTextMenuListener)
  {
    this.j.add(paramTextMenuListener);
  }
  
  public boolean a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    float f1 = -paramFloat3;
    return (paramFloat1 >= f1) && (paramFloat2 >= f1) && (paramFloat1 < getRight() - getLeft() + paramFloat3) && (paramFloat2 < getBottom() - getTop() + paramFloat3);
  }
  
  public void b(@Nullable XEditTextEx.TextMenuListener paramTextMenuListener)
  {
    this.j.remove(paramTextMenuListener);
  }
  
  public boolean dispatchKeyEventPreIme(KeyEvent paramKeyEvent)
  {
    XEditTextEx.OnKeyEventPreImeListener localOnKeyEventPreImeListener = this.f;
    if ((localOnKeyEventPreImeListener != null) && (localOnKeyEventPreImeListener.a(paramKeyEvent))) {
      return true;
    }
    return super.dispatchKeyEventPreIme(paramKeyEvent);
  }
  
  public boolean onCheckIsTextEditor()
  {
    XEditTextEx.OnKeyboardShowListener localOnKeyboardShowListener = this.k;
    if (localOnKeyboardShowListener != null) {
      return localOnKeyboardShowListener.b();
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
    Object localObject = this.b;
    if (localObject != null) {
      return ((XEditTextEx.OnPrivateIMECommandListener)localObject).a(paramString, paramBundle);
    }
    return super.onPrivateIMECommand(paramString, paramBundle);
  }
  
  public boolean onTextContextMenuItem(int paramInt)
  {
    try
    {
      Iterator localIterator = this.j.iterator();
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
    int m = paramMotionEvent.getAction();
    long l = System.currentTimeMillis();
    if (this.c == 0) {
      this.c = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }
    if (this.d == 0) {
      this.d = ViewConfiguration.getLongPressTimeout();
    }
    if (m != 0)
    {
      if (m != 1)
      {
        if (m != 2)
        {
          if (m != 3) {
            return false;
          }
          this.e = null;
          return false;
        }
        if (!a(f1, f2, this.c))
        {
          this.e = null;
          return false;
        }
      }
      else
      {
        paramView = this.e;
        if ((paramView != null) && (Math.abs(l - paramView.a) < this.d)) {
          post(this.e);
        }
        this.e = null;
        return false;
      }
    }
    else {
      this.e = new XEditTextEx.PerformClick(this, paramView, l);
    }
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    XEditTextEx.OnWindowFocusChangedListener localOnWindowFocusChangedListener = this.g;
    if (localOnWindowFocusChangedListener != null) {
      localOnWindowFocusChangedListener.a(paramBoolean);
    }
  }
  
  public boolean performLongClick()
  {
    boolean bool = super.performLongClick();
    View.OnLongClickListener localOnLongClickListener = this.i;
    if (localOnLongClickListener != null) {
      localOnLongClickListener.onLongClick(this);
    }
    return bool;
  }
  
  public void scrollTo(int paramInt1, int paramInt2)
  {
    XEditTextEx.OnKeyboardShowListener localOnKeyboardShowListener = this.k;
    if ((localOnKeyboardShowListener == null) || (localOnKeyboardShowListener.b())) {
      super.scrollTo(paramInt1, paramInt2);
    }
  }
  
  public void setKeyEventPreImeListener(XEditTextEx.OnKeyEventPreImeListener paramOnKeyEventPreImeListener)
  {
    this.f = paramOnKeyEventPreImeListener;
  }
  
  public void setOnKeyboardShowListener(XEditTextEx.OnKeyboardShowListener paramOnKeyboardShowListener)
  {
    this.k = paramOnKeyboardShowListener;
  }
  
  public void setOnLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    this.i = paramOnLongClickListener;
  }
  
  public void setOnPrivateIMECommandListener(XEditTextEx.OnPrivateIMECommandListener paramOnPrivateIMECommandListener)
  {
    this.b = paramOnPrivateIMECommandListener;
  }
  
  public void setOnWindowFocusChangedListener(XEditTextEx.OnWindowFocusChangedListener paramOnWindowFocusChangedListener)
  {
    this.g = paramOnWindowFocusChangedListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.XEditTextEx
 * JD-Core Version:    0.7.0.1
 */