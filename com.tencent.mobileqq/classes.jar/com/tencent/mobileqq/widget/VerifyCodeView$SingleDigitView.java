package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

class VerifyCodeView$SingleDigitView
  extends RelativeLayout
  implements TextWatcher, View.OnKeyListener
{
  public EditText a;
  public TextView a;
  public EditText b;
  
  public VerifyCodeView$SingleDigitView(Context paramContext, float paramFloat, int paramInt1, int paramInt2, int paramInt3, EditText paramEditText)
  {
    super(paramContext);
    this.b = paramEditText;
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(paramContext);
    this.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(1);
    this.jdField_a_of_type_AndroidWidgetTextView.setSingleLine();
    this.jdField_a_of_type_AndroidWidgetTextView.setFilters(new InputFilter[] { new InputFilter.LengthFilter(1) });
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(paramFloat);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramInt1);
    this.jdField_a_of_type_AndroidWidgetTextView.setTypeface(Typeface.createFromAsset(getContext().getResources().getAssets(), "fonts/DIN Alternate.ttf"));
    this.jdField_a_of_type_AndroidWidgetTextView.setFocusable(false);
    this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130851172);
    this.jdField_a_of_type_AndroidWidgetTextView.setGravity(17);
    this.jdField_a_of_type_AndroidWidgetTextView.setPadding(0, 0, 1, 1);
    this.jdField_a_of_type_AndroidWidgetTextView.setWidth(paramInt2);
    this.jdField_a_of_type_AndroidWidgetTextView.setHeight(paramInt3);
    paramEditText = new RelativeLayout.LayoutParams(-2, -2);
    paramEditText.addRule(13);
    addView(this.jdField_a_of_type_AndroidWidgetTextView, paramEditText);
    this.jdField_a_of_type_AndroidWidgetEditText = new VerifyCodeView.SingleDigitView.1(this, paramContext, paramContext);
    this.jdField_a_of_type_AndroidWidgetEditText.setMaxLines(1);
    this.jdField_a_of_type_AndroidWidgetEditText.setSingleLine();
    this.jdField_a_of_type_AndroidWidgetEditText.setInputType(2);
    this.jdField_a_of_type_AndroidWidgetEditText.setTextSize(paramFloat);
    this.jdField_a_of_type_AndroidWidgetEditText.setTextColor(0);
    this.jdField_a_of_type_AndroidWidgetEditText.setBackgroundColor(0);
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this);
    this.jdField_a_of_type_AndroidWidgetEditText.setOnKeyListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setGravity(17);
    this.jdField_a_of_type_AndroidWidgetTextView.setWidth(paramInt2);
    this.jdField_a_of_type_AndroidWidgetTextView.setHeight(paramInt3);
    paramEditText.addRule(13);
    addView(this.jdField_a_of_type_AndroidWidgetEditText, paramEditText);
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (!TextUtils.isEmpty(paramEditable))
    {
      EditText localEditText = this.b;
      localEditText.setText(localEditText.getText().append(paramEditable.toString()));
      this.b.requestFocus();
      paramEditable = this.b;
      paramEditable.setSelection(paramEditable.getText().length());
      this.jdField_a_of_type_AndroidWidgetEditText.setText("");
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 67) && (paramKeyEvent.getAction() == 0) && ((paramView instanceof EditText)) && (((EditText)paramView).getText().length() == 0))
    {
      paramView = this.b.getText().toString();
      paramInt = paramView.length();
      if (paramInt > 0)
      {
        paramKeyEvent = this.b;
        paramInt -= 1;
        paramKeyEvent.setText(paramView.substring(0, paramInt));
        this.b.requestFocus();
        this.b.setSelection(paramInt);
      }
    }
    return false;
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.VerifyCodeView.SingleDigitView
 * JD-Core Version:    0.7.0.1
 */