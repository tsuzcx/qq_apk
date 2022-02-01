package com.tencent.mobileqq.widget;

import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Vibrator;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.qmethodmonitor.monitor.ClipboardMonitor;
import com.tencent.mobileqq.qqui.R.styleable;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class VerifyCodeView
  extends LinearLayout
  implements TextWatcher
{
  private static String jdField_a_of_type_JavaLangString = "VerifyCodeView";
  private int jdField_a_of_type_Int;
  private Vibrator jdField_a_of_type_AndroidOsVibrator;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private Runnable jdField_a_of_type_JavaLangRunnable = new VerifyCodeView.1(this);
  private ArrayList<TextView> jdField_a_of_type_JavaUtilArrayList;
  private int jdField_b_of_type_Int;
  private ArrayList<VerifyCodeView.OnVerifyCodeCompleteListener> jdField_b_of_type_JavaUtilArrayList;
  private int c;
  private int d;
  
  public VerifyCodeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setOrientation(0);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.bK);
    this.jdField_a_of_type_Int = paramAttributeSet.getInteger(R.styleable.cg, 6);
    this.c = paramAttributeSet.getColor(R.styleable.cc, -16777216);
    this.d = paramAttributeSet.getColor(R.styleable.cd, -65536);
    float f = paramAttributeSet.getFloat(R.styleable.cf, 29.0F);
    int j = (int)paramAttributeSet.getDimension(R.styleable.ce, 20.0F);
    int k = (int)paramAttributeSet.getDimension(R.styleable.cb, 80.0F);
    int m = (int)paramAttributeSet.getDimension(R.styleable.ca, 80.0F);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidWidgetEditText = new EditText(paramContext);
    int i = 0;
    while (i < this.jdField_a_of_type_Int)
    {
      paramAttributeSet = new VerifyCodeView.SingleDigitView(paramContext, f, this.c, k, m, this.jdField_a_of_type_AndroidWidgetEditText);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams.rightMargin = j;
      addView(paramAttributeSet, localLayoutParams);
      this.jdField_a_of_type_JavaUtilArrayList.add(paramAttributeSet.a);
      i += 1;
    }
    this.jdField_a_of_type_AndroidWidgetEditText.setCursorVisible(true);
    this.jdField_a_of_type_AndroidWidgetEditText.setInputType(2);
    this.jdField_a_of_type_AndroidWidgetEditText.setSingleLine();
    this.jdField_a_of_type_AndroidWidgetEditText.setFilters(new InputFilter[] { new InputFilter.LengthFilter(this.jdField_a_of_type_Int) });
    this.jdField_a_of_type_AndroidWidgetEditText.setTextSize(0.0F);
    this.jdField_a_of_type_AndroidWidgetEditText.setTextColor(0);
    this.jdField_a_of_type_AndroidWidgetEditText.setBackgroundResource(2131167333);
    addView(this.jdField_a_of_type_AndroidWidgetEditText);
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this);
    this.jdField_a_of_type_AndroidWidgetEditText.setFocusable(true);
    this.jdField_a_of_type_AndroidWidgetEditText.setFocusableInTouchMode(true);
    this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
    c();
    ((TextView)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_b_of_type_Int)).setBackgroundResource(2130851171);
  }
  
  private void a(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((TextView)localIterator.next()).setTextColor(paramInt);
    }
  }
  
  private void a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.length() <= this.jdField_a_of_type_Int))
    {
      Object localObject = paramString.toCharArray();
      int k = localObject.length;
      int j = 0;
      int i = 0;
      while (i < k)
      {
        if (!Character.isDigit(localObject[i]))
        {
          QLog.e(jdField_a_of_type_JavaLangString, 1, "setCode error: verify code not digit string");
          return;
        }
        i += 1;
      }
      this.jdField_b_of_type_Int = paramString.length();
      for (i = j; i < this.jdField_b_of_type_Int; i = j)
      {
        localObject = (TextView)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        j = i + 1;
        ((TextView)localObject).setText(paramString.substring(i, j));
      }
      return;
    }
    QLog.e(jdField_a_of_type_JavaLangString, 1, "setCode error: invalid verify code length");
  }
  
  private static String b(Context paramContext)
  {
    Object localObject1 = (ClipboardManager)paramContext.getSystemService("clipboard");
    if (localObject1 == null) {
      return "";
    }
    ClipboardMonitor.getPrimaryClip((ClipboardManager)localObject1);
    localObject1 = ((ClipboardManager)localObject1).getPrimaryClip();
    if (localObject1 == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < ((ClipData)localObject1).getItemCount())
    {
      Object localObject2 = ((ClipData)localObject1).getItemAt(i).coerceToText(paramContext).toString();
      if (localObject2 != null)
      {
        localObject2 = ((String)localObject2).toCharArray();
        int k = localObject2.length;
        int j = 0;
        while (j < k)
        {
          char c1 = localObject2[j];
          if (Character.isDigit(c1)) {
            localStringBuilder.append(c1);
          }
          j += 1;
        }
      }
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  private void b()
  {
    Object localObject = this.jdField_b_of_type_JavaUtilArrayList;
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((VerifyCodeView.OnVerifyCodeCompleteListener)((Iterator)localObject).next()).onVerifyCodeComplete();
      }
    }
  }
  
  private void c()
  {
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    if (localArrayList != null)
    {
      if (localArrayList.isEmpty()) {
        return;
      }
      int i = 0;
      while (i < this.jdField_a_of_type_Int)
      {
        ((TextView)this.jdField_a_of_type_JavaUtilArrayList.get(i)).setText("");
        i += 1;
      }
      this.jdField_b_of_type_Int = 0;
    }
  }
  
  private void d()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((TextView)localIterator.next()).setBackgroundResource(2130851172);
    }
  }
  
  private void e()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidOsVibrator == null) {
        this.jdField_a_of_type_AndroidOsVibrator = ((Vibrator)getContext().getSystemService("vibrator"));
      }
      if (this.jdField_a_of_type_AndroidOsVibrator != null)
      {
        this.jdField_a_of_type_AndroidOsVibrator.vibrate(50L);
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "exception when doVibrate.", localException);
    }
  }
  
  public String a()
  {
    return this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
  }
  
  public void a()
  {
    a(this.d);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((TextView)localIterator.next()).setBackgroundResource(2130851173);
    }
    startAnimation(AnimationUtils.loadAnimation(getContext(), 2130772380));
    e();
    postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
  }
  
  public void a(VerifyCodeView.OnVerifyCodeCompleteListener paramOnVerifyCodeCompleteListener)
  {
    if (this.jdField_b_of_type_JavaUtilArrayList == null) {
      this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    }
    this.jdField_b_of_type_JavaUtilArrayList.add(paramOnVerifyCodeCompleteListener);
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    c();
    d();
    a(paramEditable.toString());
    int i = this.jdField_b_of_type_Int;
    if (i == this.jdField_a_of_type_Int)
    {
      b();
      return;
    }
    ((TextView)this.jdField_a_of_type_JavaUtilArrayList.get(i)).setBackgroundResource(2130851171);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void setCode(String paramString)
  {
    this.jdField_a_of_type_AndroidWidgetEditText.setText(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.VerifyCodeView
 * JD-Core Version:    0.7.0.1
 */