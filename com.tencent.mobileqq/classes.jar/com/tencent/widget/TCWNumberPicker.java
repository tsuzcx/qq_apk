package com.tencent.widget;

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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

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
  private final Runnable jdField_a_of_type_JavaLangRunnable = new TCWNumberPicker.AutoIncDecRunnable(this);
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
    jdField_a_of_type_ComTencentWidgetTCWNumberPicker$Formatter = new TCWNumberPicker.1();
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
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2131559527, this, true);
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    paramContext = new TCWNumberPicker.NumberPickerInputFilter(this, null);
    this.jdField_a_of_type_AndroidTextInputFilter = new TCWNumberPicker.NumberRangeKeyListener(this, null);
    this.jdField_a_of_type_ComTencentWidgetTCWNumberPickerButton = ((TCWNumberPickerButton)findViewById(2131368754));
    this.jdField_a_of_type_ComTencentWidgetTCWNumberPickerButton.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetTCWNumberPickerButton.setOnLongClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetTCWNumberPickerButton.setNumberPicker(this);
    this.jdField_b_of_type_ComTencentWidgetTCWNumberPickerButton = ((TCWNumberPickerButton)findViewById(2131365457));
    this.jdField_b_of_type_ComTencentWidgetTCWNumberPickerButton.setOnClickListener(this);
    this.jdField_b_of_type_ComTencentWidgetTCWNumberPickerButton.setOnLongClickListener(this);
    this.jdField_b_of_type_ComTencentWidgetTCWNumberPickerButton.setNumberPicker(this);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131378730));
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
      int i;
      break label67;
    }
    i = 0;
    while (i < this.jdField_a_of_type_ArrayOfJavaLangString.length)
    {
      paramString = paramString.toLowerCase();
      if (this.jdField_a_of_type_ArrayOfJavaLangString[i].toLowerCase().startsWith(paramString)) {
        return this.jdField_a_of_type_Int + i;
      }
      i += 1;
    }
    i = Integer.parseInt(paramString);
    return i;
    label67:
    return this.jdField_a_of_type_Int;
  }
  
  private String a(int paramInt)
  {
    TCWNumberPicker.Formatter localFormatter = this.jdField_b_of_type_ComTencentWidgetTCWNumberPicker$Formatter;
    if (localFormatter != null) {
      return localFormatter.a(paramInt);
    }
    return String.valueOf(paramInt);
  }
  
  private void a(int paramInt)
  {
    int j = this.jdField_b_of_type_Int;
    int i;
    if (paramInt > j)
    {
      i = this.jdField_a_of_type_Int;
    }
    else
    {
      i = paramInt;
      if (paramInt < this.jdField_a_of_type_Int) {
        i = j;
      }
    }
    this.d = this.c;
    this.c = i;
    c();
    d();
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
  
  private void a(Runnable paramRunnable)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      a(this.c + 1);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(paramRunnable, this.jdField_a_of_type_Long);
      return;
    }
    if (this.jdField_b_of_type_Boolean)
    {
      a(this.c - 1);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(paramRunnable, this.jdField_a_of_type_Long);
    }
  }
  
  private void c()
  {
    TCWNumberPicker.OnChangedListener localOnChangedListener = this.jdField_a_of_type_ComTencentWidgetTCWNumberPicker$OnChangedListener;
    if (localOnChangedListener != null) {
      localOnChangedListener.a(this, this.d, this.c);
    }
  }
  
  private void d()
  {
    Object localObject = this.jdField_a_of_type_ArrayOfJavaLangString;
    if (localObject == null) {
      this.jdField_a_of_type_AndroidWidgetEditText.setText(a(this.c));
    } else {
      this.jdField_a_of_type_AndroidWidgetEditText.setText(localObject[(this.c - this.jdField_a_of_type_Int)]);
    }
    localObject = this.jdField_a_of_type_AndroidWidgetEditText;
    ((EditText)localObject).setSelection(((EditText)localObject).getText().length());
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
    if (2131368754 == paramView.getId()) {
      a(this.c + 1);
    } else if (2131365457 == paramView.getId()) {
      a(this.c - 1);
    }
    EventCollector.getInstance().onViewClicked(paramView);
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
    if (2131368754 == paramView.getId())
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidOsHandler.post(this.jdField_a_of_type_JavaLangRunnable);
      return true;
    }
    if (2131365457 == paramView.getId())
    {
      this.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidOsHandler.post(this.jdField_a_of_type_JavaLangRunnable);
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.TCWNumberPicker
 * JD-Core Version:    0.7.0.1
 */