package com.tencent.widget;

import amle;
import amlf;
import amlg;
import amlh;
import android.content.Context;
import android.os.Handler;
import android.text.Editable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnLongClickListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class TCWNumberPicker
  extends LinearLayout
  implements View.OnClickListener, View.OnFocusChangeListener, View.OnLongClickListener
{
  public static final TCWNumberPicker.Formatter a;
  private static final char[] jdField_a_of_type_ArrayOfChar = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57 };
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = 300L;
  private final Handler jdField_a_of_type_AndroidOsHandler;
  private final InputFilter jdField_a_of_type_AndroidTextInputFilter;
  private final EditText jdField_a_of_type_AndroidWidgetEditText;
  private TCWNumberPicker.OnChangedListener jdField_a_of_type_ComTencentWidgetTCWNumberPicker$OnChangedListener;
  private TCWNumberPickerButton jdField_a_of_type_ComTencentWidgetTCWNumberPickerButton;
  private final Runnable jdField_a_of_type_JavaLangRunnable = new amlf(this);
  private boolean jdField_a_of_type_Boolean;
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  private int jdField_b_of_type_Int;
  private TCWNumberPicker.Formatter jdField_b_of_type_ComTencentWidgetTCWNumberPicker$Formatter;
  private TCWNumberPickerButton jdField_b_of_type_ComTencentWidgetTCWNumberPickerButton;
  private boolean jdField_b_of_type_Boolean;
  private int c;
  private int d;
  
  static
  {
    jdField_a_of_type_ComTencentWidgetTCWNumberPicker$Formatter = new amle();
  }
  
  public TCWNumberPicker(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TCWNumberPicker(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TCWNumberPicker(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    setOrientation(1);
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2130969143, this, true);
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    paramContext = new amlg(this, null);
    this.jdField_a_of_type_AndroidTextInputFilter = new amlh(this, null);
    this.jdField_a_of_type_ComTencentWidgetTCWNumberPickerButton = ((TCWNumberPickerButton)findViewById(2131365363));
    this.jdField_a_of_type_ComTencentWidgetTCWNumberPickerButton.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetTCWNumberPickerButton.setOnLongClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetTCWNumberPickerButton.setNumberPicker(this);
    this.jdField_b_of_type_ComTencentWidgetTCWNumberPickerButton = ((TCWNumberPickerButton)findViewById(2131365365));
    this.jdField_b_of_type_ComTencentWidgetTCWNumberPickerButton.setOnClickListener(this);
    this.jdField_b_of_type_ComTencentWidgetTCWNumberPickerButton.setOnLongClickListener(this);
    this.jdField_b_of_type_ComTencentWidgetTCWNumberPickerButton.setNumberPicker(this);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131365364));
    this.jdField_a_of_type_AndroidWidgetEditText.setOnFocusChangeListener(this);
    this.jdField_a_of_type_AndroidWidgetEditText.setFilters(new InputFilter[] { paramContext });
    this.jdField_a_of_type_AndroidWidgetEditText.setRawInputType(2);
    if (!isEnabled()) {
      setEnabled(false);
    }
  }
  
  private int a(String paramString)
  {
    if (this.jdField_a_of_type_ArrayOfJavaLangString == null) {}
    try
    {
      i = Integer.parseInt(paramString);
      return i;
    }
    catch (NumberFormatException paramString)
    {
      try
      {
        int i = Integer.parseInt(paramString);
        return i;
      }
      catch (NumberFormatException paramString)
      {
        break label68;
      }
      paramString = paramString;
    }
    i = 0;
    while (i < this.jdField_a_of_type_ArrayOfJavaLangString.length)
    {
      paramString = paramString.toLowerCase();
      if (this.jdField_a_of_type_ArrayOfJavaLangString[i].toLowerCase().startsWith(paramString)) {
        return i + this.jdField_a_of_type_Int;
      }
      i += 1;
    }
    label68:
    return this.jdField_a_of_type_Int;
  }
  
  private String a(int paramInt)
  {
    if (this.jdField_b_of_type_ComTencentWidgetTCWNumberPicker$Formatter != null) {
      return this.jdField_b_of_type_ComTencentWidgetTCWNumberPicker$Formatter.a(paramInt);
    }
    return String.valueOf(paramInt);
  }
  
  private void a(int paramInt)
  {
    int i;
    if (paramInt > this.jdField_b_of_type_Int) {
      i = this.jdField_a_of_type_Int;
    }
    for (;;)
    {
      this.d = this.c;
      this.c = i;
      c();
      d();
      return;
      i = paramInt;
      if (paramInt < this.jdField_a_of_type_Int) {
        i = this.jdField_b_of_type_Int;
      }
    }
  }
  
  private void a(View paramView)
  {
    paramView = String.valueOf(((TextView)paramView).getText());
    if ("".equals(paramView))
    {
      d();
      return;
    }
    a(paramView);
  }
  
  private void a(CharSequence paramCharSequence)
  {
    int i = a(paramCharSequence.toString());
    if ((i >= this.jdField_a_of_type_Int) && (i <= this.jdField_b_of_type_Int))
    {
      this.d = this.c;
      this.c = i;
      c();
    }
    d();
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_ComTencentWidgetTCWNumberPicker$OnChangedListener != null) {
      this.jdField_a_of_type_ComTencentWidgetTCWNumberPicker$OnChangedListener.a(this, this.d, this.c);
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ArrayOfJavaLangString == null) {
      this.jdField_a_of_type_AndroidWidgetEditText.setText(a(this.c));
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.jdField_a_of_type_AndroidWidgetEditText.getText().length());
      return;
      this.jdField_a_of_type_AndroidWidgetEditText.setText(this.jdField_a_of_type_ArrayOfJavaLangString[(this.c - this.jdField_a_of_type_Int)]);
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void b()
  {
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void onClick(View paramView)
  {
    a(this.jdField_a_of_type_AndroidWidgetEditText);
    if (!this.jdField_a_of_type_AndroidWidgetEditText.hasFocus()) {
      this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
    }
    if (2131365363 == paramView.getId()) {
      a(this.c + 1);
    }
    while (2131365365 != paramView.getId()) {
      return;
    }
    a(this.c - 1);
  }
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (!paramBoolean) {
      a(paramView);
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetEditText.clearFocus();
    if (2131365363 == paramView.getId())
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidOsHandler.post(this.jdField_a_of_type_JavaLangRunnable);
    }
    while (2131365365 != paramView.getId()) {
      return true;
    }
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler.post(this.jdField_a_of_type_JavaLangRunnable);
    return true;
  }
  
  public void setCurrent(int paramInt)
  {
    this.c = paramInt;
    d();
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    super.setEnabled(paramBoolean);
    this.jdField_a_of_type_ComTencentWidgetTCWNumberPickerButton.setEnabled(paramBoolean);
    this.jdField_b_of_type_ComTencentWidgetTCWNumberPickerButton.setEnabled(paramBoolean);
    this.jdField_a_of_type_AndroidWidgetEditText.setEnabled(paramBoolean);
  }
  
  public void setFormatter(TCWNumberPicker.Formatter paramFormatter)
  {
    this.jdField_b_of_type_ComTencentWidgetTCWNumberPicker$Formatter = paramFormatter;
  }
  
  public void setOnChangeListener(TCWNumberPicker.OnChangedListener paramOnChangedListener)
  {
    this.jdField_a_of_type_ComTencentWidgetTCWNumberPicker$OnChangedListener = paramOnChangedListener;
  }
  
  public void setRange(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.c = paramInt1;
    d();
  }
  
  public void setRange(int paramInt1, int paramInt2, String[] paramArrayOfString)
  {
    this.jdField_a_of_type_ArrayOfJavaLangString = paramArrayOfString;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.c = paramInt1;
    d();
  }
  
  public void setSpeed(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.widget.TCWNumberPicker
 * JD-Core Version:    0.7.0.1
 */