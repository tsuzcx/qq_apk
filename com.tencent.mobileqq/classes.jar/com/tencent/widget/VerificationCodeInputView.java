package com.tencent.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import bfsz;
import bfwi;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class VerificationCodeInputView
  extends LinearLayout
  implements TextWatcher, View.OnKeyListener, bfsz
{
  public static final int[] a;
  private int jdField_a_of_type_Int = 4;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private bfwi jdField_a_of_type_Bfwi;
  private final List<EditText> jdField_a_of_type_JavaUtilList = new ArrayList();
  private final InputFilter[] jdField_a_of_type_ArrayOfAndroidTextInputFilter = new InputFilter[0];
  private int jdField_b_of_type_Int;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  private final InputFilter[] jdField_b_of_type_ArrayOfAndroidTextInputFilter = { new InputFilter.LengthFilter(1) };
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 2131364341, 2131364342, 2131364343, 2131364344, 2131364345, 2131364346 };
  }
  
  public VerificationCodeInputView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public VerificationCodeInputView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public VerificationCodeInputView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130844193);
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130844194);
    LayoutInflater.from(getContext()).inflate(2131559367, this);
    b();
  }
  
  private void b()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    int i = 0;
    if (i < jdField_a_of_type_ArrayOfInt.length)
    {
      EditText localEditText = (EditText)findViewById(jdField_a_of_type_ArrayOfInt[i]);
      if (localEditText == null) {}
      for (;;)
      {
        i += 1;
        break;
        localEditText.setOnKeyListener(null);
        localEditText.removeTextChangedListener(this);
        localEditText.setFilters(this.jdField_a_of_type_ArrayOfAndroidTextInputFilter);
        localEditText.setEnabled(true);
        if (this.jdField_a_of_type_JavaUtilList.size() < this.jdField_a_of_type_Int)
        {
          localEditText.setVisibility(0);
          localEditText.setOnKeyListener(this);
          localEditText.addTextChangedListener(this);
          localEditText.setFilters(this.jdField_b_of_type_ArrayOfAndroidTextInputFilter);
          localEditText.setEms(1);
          localEditText.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
          this.jdField_a_of_type_JavaUtilList.add(localEditText);
          if ((localEditText instanceof ListenCutCopyPasteEditText)) {
            ((ListenCutCopyPasteEditText)localEditText).setCutCopyPasteCallback(this);
          }
        }
        else
        {
          localEditText.setVisibility(8);
          localEditText.setBackgroundDrawable(null);
          if ((localEditText instanceof ListenCutCopyPasteEditText)) {
            ((ListenCutCopyPasteEditText)localEditText).setCutCopyPasteCallback(null);
          }
        }
      }
    }
  }
  
  private void c()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int j = getChildCount();
    int i = 0;
    EditText localEditText;
    String str;
    if ((i < this.jdField_a_of_type_Int) && (i < j))
    {
      localEditText = (EditText)getChildAt(i);
      str = localEditText.getText().toString();
      if (str.length() == 0)
      {
        localEditText.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        localEditText.requestFocus();
      }
    }
    for (i = 0;; i = 1)
    {
      if (i != 0)
      {
        if (this.jdField_a_of_type_Bfwi != null) {
          this.jdField_a_of_type_Bfwi.a(localStringBuilder.toString());
        }
        setEnabled(false);
      }
      return;
      localEditText.setBackgroundDrawable(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable);
      localStringBuilder.append(str);
      i += 1;
      break;
    }
  }
  
  public void a(EditText paramEditText, CharSequence paramCharSequence)
  {
    if (QLog.isColorLevel()) {
      QLog.i("VerificationCodeInputView", 2, "onCut content: " + paramCharSequence);
    }
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    c();
  }
  
  public void b(EditText paramEditText, CharSequence paramCharSequence)
  {
    if (QLog.isColorLevel()) {
      QLog.i("VerificationCodeInputView", 2, "onCopy content: " + paramCharSequence);
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void c(EditText paramEditText, CharSequence paramCharSequence)
  {
    if (QLog.isColorLevel()) {
      QLog.i("VerificationCodeInputView", 2, "onPaste content: " + paramCharSequence);
    }
    if ((paramCharSequence != null) && (paramCharSequence.length() == this.jdField_a_of_type_Int) && (TextUtils.isDigitsOnly(paramCharSequence))) {
      setContent(paramCharSequence.toString());
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
  }
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    paramView = (EditText)paramView;
    if ((paramInt == 67) && (paramView.getText().length() == 0))
    {
      paramInt = paramKeyEvent.getAction();
      if ((this.jdField_b_of_type_Int != 0) && (paramInt == 0))
      {
        this.jdField_b_of_type_Int -= 1;
        ((EditText)this.jdField_a_of_type_JavaUtilList.get(this.jdField_b_of_type_Int)).requestFocus();
        ((EditText)this.jdField_a_of_type_JavaUtilList.get(this.jdField_b_of_type_Int)).setText("");
      }
    }
    return false;
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 == 0) && (paramInt3 >= 1) && (this.jdField_b_of_type_Int != this.jdField_a_of_type_JavaUtilList.size() - 1))
    {
      this.jdField_b_of_type_Int += 1;
      ((EditText)this.jdField_a_of_type_JavaUtilList.get(this.jdField_b_of_type_Int)).requestFocus();
    }
  }
  
  public void setContent(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (TextUtils.isDigitsOnly(paramString)))
    {
      this.jdField_b_of_type_Int = 0;
      int i;
      int j;
      label33:
      EditText localEditText;
      if (paramString == null)
      {
        i = 0;
        int k = getChildCount();
        j = 0;
        if ((j >= this.jdField_a_of_type_Int) || (j >= k)) {
          return;
        }
        localEditText = (EditText)getChildAt(j);
        localEditText.setEnabled(true);
        if (j >= i) {
          break label105;
        }
        localEditText.setText(paramString.substring(j, j + 1));
        localEditText.setBackgroundDrawable(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable);
      }
      for (;;)
      {
        j += 1;
        break label33;
        i = paramString.length();
        break;
        label105:
        localEditText.setText("");
        localEditText.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      }
    }
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    int j = getChildCount();
    int i = 0;
    while ((i < this.jdField_a_of_type_Int) && (i < j))
    {
      getChildAt(i).setEnabled(paramBoolean);
      i += 1;
    }
  }
  
  public void setMode(int paramInt)
  {
    if ((paramInt != this.jdField_a_of_type_Int) && ((paramInt == 4) || (paramInt == 6)))
    {
      this.jdField_a_of_type_Int = paramInt;
      b();
    }
  }
  
  public void setOnCompleteListener(bfwi parambfwi)
  {
    this.jdField_a_of_type_Bfwi = parambfwi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.widget.VerificationCodeInputView
 * JD-Core Version:    0.7.0.1
 */