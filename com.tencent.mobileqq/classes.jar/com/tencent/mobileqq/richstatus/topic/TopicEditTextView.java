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
import awfs;
import awfv;
import awfw;
import awfy;
import com.tencent.qphone.base.util.QLog;

public class TopicEditTextView
  extends EditText
  implements TextWatcher
{
  public static Editable.Factory a;
  int jdField_a_of_type_Int;
  private TextWatcher jdField_a_of_type_AndroidTextTextWatcher;
  ActionMode.Callback jdField_a_of_type_AndroidViewActionMode$Callback = new awfw(this);
  awfs jdField_a_of_type_Awfs;
  boolean jdField_a_of_type_Boolean;
  int b;
  public boolean b;
  
  static
  {
    jdField_a_of_type_AndroidTextEditable$Factory = new awfv();
  }
  
  public TopicEditTextView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public TopicEditTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public TopicEditTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    setEditableFactory(jdField_a_of_type_AndroidTextEditable$Factory);
    setCustomSelectionActionModeCallback(this.jdField_a_of_type_AndroidViewActionMode$Callback);
    super.addTextChangedListener(this);
  }
  
  private boolean a()
  {
    int i = getSelectionStart();
    int j = getSelectionEnd();
    if (getEditableText() == null) {
      return false;
    }
    awfs[] arrayOfawfs = (awfs[])getEditableText().getSpans(i, j, awfs.class);
    if ((arrayOfawfs != null) && (arrayOfawfs.length > 0) && ((arrayOfawfs[0] instanceof awfs)))
    {
      i = getEditableText().getSpanEnd(arrayOfawfs[0]);
      j = getEditableText().getSpanStart(arrayOfawfs[0]);
      if ((j >= 0) && (i > j)) {
        return false;
      }
    }
    return true;
  }
  
  public void addTextChangedListener(TextWatcher paramTextWatcher)
  {
    this.jdField_a_of_type_AndroidTextTextWatcher = paramTextWatcher;
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (this.jdField_b_of_type_Boolean) {}
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("TopicEditTextView", 2, String.format("afterTextChanged [delTopic=%s] src=%s", new Object[] { this.jdField_a_of_type_Awfs, paramEditable }));
      }
      if (this.jdField_a_of_type_Awfs != null)
      {
        int i = paramEditable.getSpanStart(this.jdField_a_of_type_Awfs);
        int j = paramEditable.getSpanEnd(this.jdField_a_of_type_Awfs);
        if ((i >= 0) && (j > i))
        {
          this.jdField_b_of_type_Boolean = true;
          paramEditable.delete(i, j);
          if (QLog.isColorLevel()) {
            QLog.i("TopicEditTextView", 2, String.format("afterTextChanged after delete=%s", new Object[] { paramEditable }));
          }
          this.jdField_b_of_type_Boolean = false;
          setSelection(i);
        }
      }
      while (this.jdField_a_of_type_AndroidTextTextWatcher != null)
      {
        this.jdField_a_of_type_AndroidTextTextWatcher.afterTextChanged(paramEditable);
        return;
        if (!this.jdField_a_of_type_Boolean) {}
      }
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Awfs = null;
    if ((paramCharSequence instanceof Spannable))
    {
      Spannable localSpannable = (Spannable)paramCharSequence;
      awfs localawfs = awfy.a(localSpannable, paramInt1);
      if (localawfs != null)
      {
        int i = localSpannable.getSpanStart(localawfs);
        int j = localSpannable.getSpanEnd(localawfs);
        if ((j >= 0) && (j >= i) && (paramInt2 > paramInt3)) {
          this.jdField_a_of_type_Awfs = localawfs;
        }
      }
    }
    if (paramInt3 >= paramInt2) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      this.jdField_a_of_type_Int = paramInt1;
      this.jdField_b_of_type_Int = paramInt3;
      if (QLog.isColorLevel()) {
        QLog.i("TopicEditTextView", 2, String.format("beforeTextChanged [bAdd=%b][delTopic=%s][edit=%s]", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean), this.jdField_a_of_type_Awfs, paramCharSequence }));
      }
      if (this.jdField_a_of_type_AndroidTextTextWatcher == null) {
        break;
      }
      this.jdField_a_of_type_AndroidTextTextWatcher.beforeTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
      return;
    }
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
    if (getEditableText() == null) {}
    int i;
    int j;
    do
    {
      do
      {
        awfs[] arrayOfawfs;
        do
        {
          return;
          arrayOfawfs = (awfs[])getEditableText().getSpans(paramInt1, paramInt2, awfs.class);
        } while ((arrayOfawfs == null) || (arrayOfawfs.length <= 0));
        i = getEditableText().getSpanEnd(arrayOfawfs[0]);
        j = getEditableText().getSpanStart(arrayOfawfs[0]);
      } while ((i <= j) || (j < 0));
      if ((paramInt1 == j) && (paramInt2 == i))
      {
        setSelection(i);
        return;
      }
    } while (((paramInt1 >= i) && (paramInt2 >= i)) || ((paramInt1 <= j) && (paramInt2 <= j)));
    setSelection(i, i);
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_AndroidTextTextWatcher != null) {
      this.jdField_a_of_type_AndroidTextTextWatcher.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
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
      try
      {
        setSelection(getEditableText().length());
        return true;
      }
      catch (Throwable paramMotionEvent) {}
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.topic.TopicEditTextView
 * JD-Core Version:    0.7.0.1
 */