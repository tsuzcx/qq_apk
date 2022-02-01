package com.tencent.mobileqq.search.view;

import android.content.Context;
import android.os.Bundle;
import android.provider.Settings.Secure;
import android.text.Editable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class QuickPinyinEditText
  extends EditText
{
  private static String b;
  public int a = 200;
  private volatile boolean c = false;
  private volatile String d = "";
  
  public QuickPinyinEditText(Context paramContext)
  {
    super(paramContext);
  }
  
  public QuickPinyinEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public QuickPinyinEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateInputtingStatus : ");
      localStringBuilder.append(paramString);
      QLog.d("QuickPinyinEditText", 2, localStringBuilder.toString());
    }
    if ((!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty(paramString.trim())))
    {
      this.c = true;
      return;
    }
    this.c = false;
  }
  
  private void b(String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateInputtingText : ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("QuickPinyinEditText", 2, ((StringBuilder)localObject).toString());
    }
    a(paramString);
    if (paramString == null) {
      return;
    }
    int i = getSelectionStart();
    int j = getSelectionEnd();
    Object localObject = getText();
    if (((Editable)localObject).length() + paramString.length() > this.a) {
      return;
    }
    if (j > i)
    {
      ((Editable)localObject).replace(i, j, paramString);
      setSelection(i, paramString.length() + i);
      b = paramString;
      return;
    }
    if ((j == i) && (j != -1))
    {
      ((Editable)localObject).insert(i, paramString);
      setSelection(i, paramString.length() + i);
      b = paramString;
    }
  }
  
  public boolean a()
  {
    String str = getText().toString();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isInputtingPinYin :  currentText= ");
      localStringBuilder.append(str);
      localStringBuilder.append("  isInputting=");
      boolean bool;
      if ((str.startsWith(this.d)) && (!str.equals(this.d))) {
        bool = true;
      } else {
        bool = false;
      }
      localStringBuilder.append(bool);
      QLog.d("QuickPinyinEditText", 2, localStringBuilder.toString());
    }
    if (c()) {
      return this.c;
    }
    return false;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QuickPinyinEditText", 2, "notifyInputMethodSuggestCommit : ");
    }
    if ((!TextUtils.isEmpty(b)) && (c()))
    {
      ((InputMethodManager)BaseApplication.getContext().getSystemService("input_method")).sendAppPrivateCommand(this, "com.sohu.inputmethod.sogou.search.enter", null);
      setSelection(getText().length());
    }
  }
  
  public boolean c()
  {
    String str = Settings.Secure.getString(getContext().getContentResolver(), "default_input_method");
    return (str != null) && (str.contains("com.sohu.inputmethod.sogou"));
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QuickPinyinEditText", 2, "onCreateInputConnection : ");
    }
    return super.onCreateInputConnection(paramEditorInfo);
  }
  
  public boolean onPrivateIMECommand(String paramString, Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      String str = paramBundle.getString("req");
      if (("com.sohu.inputmethod.sogou.send.input".equals(paramString)) && (c())) {
        b(str);
      } else {
        a(str);
      }
    }
    return super.onPrivateIMECommand(paramString, paramBundle);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QuickPinyinEditText", 2, "onTouchEvent : ");
    }
    b();
    return super.onTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.view.QuickPinyinEditText
 * JD-Core Version:    0.7.0.1
 */