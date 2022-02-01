package com.tencent.mobileqq.richstatus.topic;

import android.content.Context;
import android.text.Editable;
import android.text.Editable.Factory;
import android.text.Spannable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.ActionMode.Callback;
import android.view.ContextMenu;
import android.view.MotionEvent;
import android.widget.EditText;
import com.tencent.mobileqq.text.ITopic;
import com.tencent.qphone.base.util.QLog;

public class TopicEditTextView
  extends EditText
  implements TextWatcher
{
  public static Editable.Factory a = new TopicEditTextView.1();
  ITopic b;
  boolean c;
  int d;
  int e;
  public boolean f = false;
  ActionMode.Callback g = new TopicEditTextView.2(this);
  private TextWatcher h;
  
  public TopicEditTextView(Context paramContext)
  {
    super(paramContext);
    b();
  }
  
  public TopicEditTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
  }
  
  public TopicEditTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b();
  }
  
  private boolean a()
  {
    int i = getSelectionStart();
    int j = getSelectionEnd();
    if (getEditableText() == null) {
      return false;
    }
    ITopic[] arrayOfITopic = (ITopic[])getEditableText().getSpans(i, j, ITopic.class);
    if ((arrayOfITopic != null) && (arrayOfITopic.length > 0) && ((arrayOfITopic[0] instanceof ITopic)))
    {
      i = getEditableText().getSpanEnd(arrayOfITopic[0]);
      j = getEditableText().getSpanStart(arrayOfITopic[0]);
      if ((j >= 0) && (i > j)) {
        return false;
      }
    }
    return true;
  }
  
  private void b()
  {
    setEditableFactory(a);
    setCustomSelectionActionModeCallback(this.g);
    super.addTextChangedListener(this);
  }
  
  public void a(Exception paramException)
  {
    QLog.e("TopicEditTextView", 2, "handleException", paramException);
    for (;;)
    {
      try
      {
        if (getEditableText().length() >= 0)
        {
          i = getEditableText().length();
          setSelection(i);
          return;
        }
      }
      catch (Exception paramException)
      {
        QLog.e("TopicEditTextView", 2, "handleException: setSelection", paramException);
        return;
      }
      int i = 0;
    }
  }
  
  public void addTextChangedListener(TextWatcher paramTextWatcher)
  {
    this.h = paramTextWatcher;
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (this.f) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("TopicEditTextView", 2, String.format("afterTextChanged [delTopic=%s] src=%s", new Object[] { this.b, paramEditable }));
    }
    Object localObject = this.b;
    if (localObject != null)
    {
      int i = paramEditable.getSpanStart(localObject);
      int j = paramEditable.getSpanEnd(this.b);
      if ((i >= 0) && (j > i))
      {
        this.f = true;
        paramEditable.delete(i, j);
        if (QLog.isColorLevel()) {
          QLog.i("TopicEditTextView", 2, String.format("afterTextChanged after delete=%s", new Object[] { paramEditable }));
        }
        this.f = false;
        setSelection(i);
      }
    }
    else
    {
      boolean bool = this.c;
    }
    localObject = this.h;
    if (localObject != null) {
      ((TextWatcher)localObject).afterTextChanged(paramEditable);
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.f) {
      return;
    }
    this.b = null;
    if ((paramCharSequence instanceof Spannable))
    {
      localObject = (Spannable)paramCharSequence;
      ITopic localITopic = TopicUtil.a((Spannable)localObject, paramInt1);
      if (localITopic != null)
      {
        int i = ((Spannable)localObject).getSpanStart(localITopic);
        int j = ((Spannable)localObject).getSpanEnd(localITopic);
        if ((j >= 0) && (j >= i) && (paramInt2 > paramInt3)) {
          this.b = localITopic;
        }
      }
    }
    boolean bool;
    if (paramInt3 >= paramInt2) {
      bool = true;
    } else {
      bool = false;
    }
    this.c = bool;
    this.d = paramInt1;
    this.e = paramInt3;
    if (QLog.isColorLevel()) {
      QLog.i("TopicEditTextView", 2, String.format("beforeTextChanged [bAdd=%b][delTopic=%s][edit=%s]", new Object[] { Boolean.valueOf(this.c), this.b, paramCharSequence }));
    }
    Object localObject = this.h;
    if (localObject != null) {
      ((TextWatcher)localObject).beforeTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    try
    {
      boolean bool = super.dispatchTouchEvent(paramMotionEvent);
      return bool;
    }
    catch (Exception paramMotionEvent)
    {
      a(paramMotionEvent);
    }
    return false;
  }
  
  protected void onCreateContextMenu(ContextMenu paramContextMenu)
  {
    if (a()) {
      super.onCreateContextMenu(paramContextMenu);
    }
  }
  
  protected void onSelectionChanged(int paramInt1, int paramInt2)
  {
    super.onSelectionChanged(paramInt1, paramInt2);
    if (getEditableText() == null) {
      return;
    }
    ITopic[] arrayOfITopic = (ITopic[])getEditableText().getSpans(paramInt1, paramInt2, ITopic.class);
    if ((arrayOfITopic != null) && (arrayOfITopic.length > 0))
    {
      int i = getEditableText().getSpanEnd(arrayOfITopic[0]);
      int j = getEditableText().getSpanStart(arrayOfITopic[0]);
      if ((i > j) && (j >= 0))
      {
        if ((paramInt1 == j) && (paramInt2 == i))
        {
          setSelection(i);
          return;
        }
        if (((paramInt1 < i) || (paramInt2 < i)) && ((paramInt1 > j) || (paramInt2 > j))) {
          setSelection(i, i);
        }
      }
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    TextWatcher localTextWatcher = this.h;
    if (localTextWatcher != null) {
      localTextWatcher.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    try
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      return bool;
    }
    catch (Throwable paramMotionEvent)
    {
      if (QLog.isColorLevel()) {
        QLog.i("TopicEditTextView", 2, paramMotionEvent.getMessage(), paramMotionEvent);
      }
    }
    try
    {
      setSelection(getEditableText().length());
      label39:
      return true;
    }
    catch (Throwable paramMotionEvent)
    {
      break label39;
    }
  }
  
  public boolean performClick()
  {
    try
    {
      boolean bool = super.performClick();
      return bool;
    }
    catch (Exception localException)
    {
      a(localException);
    }
    return false;
  }
  
  public boolean performLongClick()
  {
    try
    {
      boolean bool = super.performLongClick();
      return bool;
    }
    catch (Exception localException)
    {
      a(localException);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.topic.TopicEditTextView
 * JD-Core Version:    0.7.0.1
 */