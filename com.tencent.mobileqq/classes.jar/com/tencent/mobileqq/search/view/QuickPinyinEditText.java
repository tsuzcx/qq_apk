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
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class QuickPinyinEditText
  extends EditText
{
  private static String jdField_a_of_type_JavaLangString;
  public int a;
  private volatile boolean jdField_a_of_type_Boolean;
  private volatile String b = "";
  
  public QuickPinyinEditText(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = 200;
  }
  
  public QuickPinyinEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = 200;
  }
  
  public QuickPinyinEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Int = 200;
  }
  
  private void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QuickPinyinEditText", 2, "updateInputtingStatus : " + paramString);
    }
    if ((TextUtils.isEmpty(paramString)) || (TextUtils.isEmpty(paramString.trim())))
    {
      this.jdField_a_of_type_Boolean = false;
      return;
    }
    this.jdField_a_of_type_Boolean = true;
  }
  
  private void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QuickPinyinEditText", 2, "updateInputtingText : " + paramString);
    }
    a(paramString);
    if (paramString == null) {}
    int i;
    int j;
    Editable localEditable;
    do
    {
      do
      {
        return;
        i = getSelectionStart();
        j = getSelectionEnd();
        localEditable = getText();
      } while (localEditable.length() + paramString.length() > this.jdField_a_of_type_Int);
      if (j > i)
      {
        localEditable.replace(i, j, paramString);
        setSelection(i, paramString.length() + i);
        jdField_a_of_type_JavaLangString = paramString;
        return;
      }
    } while ((j != i) || (j == -1));
    localEditable.insert(i, paramString);
    setSelection(i, paramString.length() + i);
    jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QuickPinyinEditText", 2, "notifyInputMethodSuggestCommit : ");
    }
    if ((!TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) && (b()))
    {
      ((InputMethodManager)BaseApplicationImpl.getContext().getSystemService("input_method")).sendAppPrivateCommand(this, "com.sohu.inputmethod.sogou.search.enter", null);
      setSelection(getText().length());
    }
  }
  
  public boolean a()
  {
    boolean bool2 = false;
    String str = getText().toString();
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("isInputtingPinYin :  currentText= ").append(str).append("  isInputting=");
      if ((!str.startsWith(this.b)) || (str.equals(this.b))) {
        break label94;
      }
    }
    label94:
    for (boolean bool1 = true;; bool1 = false)
    {
      QLog.d("QuickPinyinEditText", 2, bool1);
      bool1 = bool2;
      if (b()) {
        bool1 = this.jdField_a_of_type_Boolean;
      }
      return bool1;
    }
  }
  
  public boolean b()
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
    String str;
    if (paramBundle != null)
    {
      str = paramBundle.getString("req");
      if ((!"com.sohu.inputmethod.sogou.send.input".equals(paramString)) || (!b())) {
        break label39;
      }
      b(str);
    }
    for (;;)
    {
      return super.onPrivateIMECommand(paramString, paramBundle);
      label39:
      a(str);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QuickPinyinEditText", 2, "onTouchEvent : ");
    }
    a();
    return super.onTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.search.view.QuickPinyinEditText
 * JD-Core Version:    0.7.0.1
 */