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
import com.tencent.mobileqq.widget.shape.DotView;

class VerifyCodeView$SingleDigitView
  extends RelativeLayout
  implements TextWatcher, View.OnKeyListener
{
  public TextView a;
  public EditText b;
  public EditText c;
  private DotView d;
  
  public VerifyCodeView$SingleDigitView(Context paramContext, float paramFloat, int paramInt1, int paramInt2, int paramInt3, EditText paramEditText)
  {
    super(paramContext);
    this.c = paramEditText;
    this.a = new TextView(paramContext);
    this.a.setMaxLines(1);
    this.a.setSingleLine();
    this.a.setFilters(new InputFilter[] { new InputFilter.LengthFilter(1) });
    this.a.setTextSize(paramFloat);
    this.a.setTextColor(paramInt1);
    this.a.setTypeface(Typeface.createFromAsset(getContext().getResources().getAssets(), "fonts/DIN Alternate.ttf"));
    this.a.setFocusable(false);
    this.a.setBackgroundColor(0);
    this.a.setGravity(17);
    this.a.setPadding(0, 0, 1, 1);
    this.a.setWidth(paramInt2);
    this.a.setHeight(paramInt3);
    this.a.setGravity(17);
    paramEditText = new RelativeLayout.LayoutParams(-2, -2);
    paramEditText.addRule(13);
    addView(this.a, paramEditText);
    b(VerifyCodeView.c());
    a(paramContext, paramFloat, paramInt2, paramInt3);
    a(paramContext, paramInt1);
  }
  
  private void a(Context paramContext, float paramFloat, int paramInt1, int paramInt2)
  {
    this.b = new VerifyCodeView.SingleDigitView.1(this, paramContext, paramContext);
    this.b.setWidth(paramInt1);
    this.b.setHeight(paramInt2);
    this.b.setMaxLines(1);
    this.b.setSingleLine();
    this.b.setInputType(2);
    this.b.setTextSize(paramFloat);
    this.b.setTextColor(0);
    this.b.setBackgroundColor(0);
    this.b.addTextChangedListener(this);
    this.b.setOnKeyListener(this);
    paramContext = new RelativeLayout.LayoutParams(-2, -2);
    paramContext.addRule(13);
    addView(this.b, paramContext);
  }
  
  private void a(Context paramContext, int paramInt)
  {
    this.d = new DotView(paramContext);
    this.d.setRadius(5.4F);
    this.d.setColor(paramInt);
    this.d.setVisibility(8);
    paramContext = new RelativeLayout.LayoutParams(-2, -2);
    paramContext.addRule(13);
    addView(this.d, paramContext);
  }
  
  public void a()
  {
    a("");
    this.d.setVisibility(8);
    this.a.setVisibility(0);
  }
  
  public void a(int paramInt)
  {
    this.a.setTextColor(paramInt);
    this.d.setColor(paramInt);
  }
  
  public void a(String paramString)
  {
    this.a.setText(paramString);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.a.setVisibility(8);
      this.d.setVisibility(0);
      return;
    }
    this.a.setVisibility(0);
    this.d.setVisibility(8);
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (!TextUtils.isEmpty(paramEditable))
    {
      this.c.getText().append(paramEditable.toString());
      this.c.requestFocus();
      paramEditable = this.c;
      paramEditable.setSelection(paramEditable.getText().length());
      this.b.setText("");
    }
  }
  
  public void b(int paramInt)
  {
    setBackgroundResource(paramInt);
  }
  
  public void b(boolean paramBoolean)
  {
    this.b.setLongClickable(paramBoolean);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 67) && (paramKeyEvent.getAction() == 0) && ((paramView instanceof EditText)) && (((EditText)paramView).getText().length() == 0))
    {
      paramView = this.c.getText().toString();
      paramInt = paramView.length();
      if (paramInt > 0)
      {
        paramKeyEvent = this.c;
        paramInt -= 1;
        paramKeyEvent.setText(paramView.substring(0, paramInt));
        this.c.requestFocus();
        this.c.setSelection(paramInt);
      }
    }
    return false;
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.VerifyCodeView.SingleDigitView
 * JD-Core Version:    0.7.0.1
 */