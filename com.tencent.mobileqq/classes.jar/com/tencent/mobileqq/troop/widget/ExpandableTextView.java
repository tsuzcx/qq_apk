package com.tencent.mobileqq.troop.widget;

import ajyc;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.Layout;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.util.SparseBooleanArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.TextView;
import bank;
import banl;
import com.tencent.mobileqq.R.styleable;

public class ExpandableTextView
  extends LinearLayout
  implements View.OnClickListener
{
  private static float jdField_a_of_type_Float = 0.7F;
  private int jdField_a_of_type_Int;
  private SparseBooleanArray jdField_a_of_type_AndroidUtilSparseBooleanArray;
  protected TextView a;
  private bank jdField_a_of_type_Bank;
  private banl jdField_a_of_type_Banl;
  private CharSequence jdField_a_of_type_JavaLangCharSequence;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  protected TextView b;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean = true;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  private int d;
  private int e;
  private int f;
  
  public ExpandableTextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ExpandableTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramAttributeSet);
  }
  
  @TargetApi(11)
  public ExpandableTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramAttributeSet);
  }
  
  private int a(TextView paramTextView)
  {
    return paramTextView.getLayout().getLineTop(paramTextView.getLineCount()) + (paramTextView.getCompoundPaddingTop() + paramTextView.getCompoundPaddingBottom());
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365782));
    this.jdField_a_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365780));
    TextView localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
    if (this.jdField_b_of_type_Boolean) {}
    for (String str = this.jdField_a_of_type_JavaLangString;; str = this.jdField_b_of_type_JavaLangString)
    {
      localTextView.setText(str);
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
      return;
    }
  }
  
  private void a(AttributeSet paramAttributeSet)
  {
    paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.ExpandableTextView);
    this.jdField_c_of_type_Int = paramAttributeSet.getInt(4, 7);
    this.e = paramAttributeSet.getInt(1, 400);
    this.jdField_b_of_type_Float = paramAttributeSet.getFloat(0, jdField_a_of_type_Float);
    this.jdField_a_of_type_JavaLangString = paramAttributeSet.getString(3);
    this.jdField_b_of_type_JavaLangString = paramAttributeSet.getString(2);
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_JavaLangString = ajyc.a(2131704230);
    }
    if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      this.jdField_b_of_type_JavaLangString = "";
    }
    paramAttributeSet.recycle();
    setOrientation(1);
    setVisibility(8);
  }
  
  public TextView a()
  {
    return this.jdField_a_of_type_AndroidWidgetTextView;
  }
  
  public void onClick(View paramView)
  {
    boolean bool2 = true;
    if (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() != 0) {}
    label45:
    do
    {
      return;
      if (this.jdField_b_of_type_Boolean) {
        break;
      }
      bool1 = true;
      this.jdField_b_of_type_Boolean = bool1;
      if (!this.jdField_b_of_type_Boolean) {
        break label117;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
      if (this.jdField_a_of_type_AndroidUtilSparseBooleanArray != null) {
        this.jdField_a_of_type_AndroidUtilSparseBooleanArray.put(this.f, this.jdField_b_of_type_Boolean);
      }
    } while (this.jdField_a_of_type_Bank == null);
    paramView = this.jdField_a_of_type_Bank;
    TextView localTextView1 = this.jdField_a_of_type_AndroidWidgetTextView;
    TextView localTextView2 = this.jdField_b_of_type_AndroidWidgetTextView;
    if (!this.jdField_b_of_type_Boolean) {}
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramView.a(localTextView1, localTextView2, bool1);
      return;
      bool1 = false;
      break;
      label117:
      this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_b_of_type_JavaLangString);
      if (this.jdField_a_of_type_AndroidWidgetTextView.getText().equals(this.jdField_a_of_type_JavaLangCharSequence)) {
        break label45;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangCharSequence);
      break label45;
    }
  }
  
  @SuppressLint({"MissingSuperCall"})
  protected void onFinishInflate()
  {
    a();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if ((!this.jdField_a_of_type_Boolean) || (getVisibility() == 8)) {
      super.onMeasure(paramInt1, paramInt2);
    }
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_Boolean = false;
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(2147483647);
        super.onMeasure(paramInt1, paramInt2);
      } while (this.jdField_a_of_type_AndroidWidgetTextView.getLineCount() <= this.jdField_c_of_type_Int);
      this.jdField_b_of_type_Int = a(this.jdField_a_of_type_AndroidWidgetTextView);
      if (this.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(this.jdField_c_of_type_Int);
        if (this.jdField_a_of_type_Banl == null) {
          this.jdField_a_of_type_Banl = new banl(this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_c_of_type_Int);
        }
        this.jdField_a_of_type_AndroidWidgetTextView.getViewTreeObserver().addOnGlobalLayoutListener(this.jdField_a_of_type_Banl);
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      super.onMeasure(paramInt1, paramInt2);
    } while (!this.jdField_b_of_type_Boolean);
    this.jdField_a_of_type_AndroidWidgetTextView.post(new ExpandableTextView.1(this));
    this.jdField_a_of_type_Int = getMeasuredHeight();
  }
  
  public void setOnExpandStateChangeListener(bank parambank)
  {
    this.jdField_a_of_type_Bank = parambank;
  }
  
  public void setOrientation(int paramInt)
  {
    if (paramInt == 0) {
      throw new IllegalArgumentException("ExpandableTextView only supports Vertical Orientation.");
    }
    super.setOrientation(paramInt);
  }
  
  public void setText(CharSequence paramCharSequence)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangCharSequence = paramCharSequence;
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramCharSequence);
    if (TextUtils.isEmpty(paramCharSequence)) {}
    for (int i = 8;; i = 0)
    {
      setVisibility(i);
      return;
    }
  }
  
  public void setText(CharSequence paramCharSequence, SparseBooleanArray paramSparseBooleanArray, int paramInt)
  {
    this.jdField_a_of_type_AndroidUtilSparseBooleanArray = paramSparseBooleanArray;
    this.f = paramInt;
    boolean bool = paramSparseBooleanArray.get(paramInt, true);
    clearAnimation();
    this.jdField_b_of_type_Boolean = bool;
    TextView localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
    if (this.jdField_b_of_type_Boolean) {}
    for (paramSparseBooleanArray = this.jdField_a_of_type_JavaLangString;; paramSparseBooleanArray = this.jdField_b_of_type_JavaLangString)
    {
      localTextView.setText(paramSparseBooleanArray);
      setText(paramCharSequence);
      getLayoutParams().height = -2;
      requestLayout();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.ExpandableTextView
 * JD-Core Version:    0.7.0.1
 */