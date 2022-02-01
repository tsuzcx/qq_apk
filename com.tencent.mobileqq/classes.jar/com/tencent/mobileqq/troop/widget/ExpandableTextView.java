package com.tencent.mobileqq.troop.widget;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.text.Layout;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.util.SparseBooleanArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.view.animation.AlphaAnimation;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.troop.impl.R.styleable;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ExpandableTextView
  extends LinearLayout
  implements View.OnClickListener
{
  private static float jdField_a_of_type_Float = 0.7F;
  private int jdField_a_of_type_Int;
  private SparseBooleanArray jdField_a_of_type_AndroidUtilSparseBooleanArray;
  protected TextView a;
  private ExpandableTextView.OnExpandStateListener jdField_a_of_type_ComTencentMobileqqTroopWidgetExpandableTextView$OnExpandStateListener;
  private ExpandableTextView.OnGlobalLayoutListenerByEllipsize jdField_a_of_type_ComTencentMobileqqTroopWidgetExpandableTextView$OnGlobalLayoutListenerByEllipsize;
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
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131366359));
    this.jdField_a_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131366354));
    TextView localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
    String str;
    if (this.jdField_b_of_type_Boolean) {
      str = this.jdField_a_of_type_JavaLangString;
    } else {
      str = this.jdField_b_of_type_JavaLangString;
    }
    localTextView.setText(str);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
  }
  
  private void a(AttributeSet paramAttributeSet)
  {
    paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.V);
    this.jdField_c_of_type_Int = paramAttributeSet.getInt(R.styleable.i, 7);
    this.e = paramAttributeSet.getInt(R.styleable.f, 400);
    this.jdField_b_of_type_Float = paramAttributeSet.getFloat(R.styleable.e, jdField_a_of_type_Float);
    this.jdField_a_of_type_JavaLangString = paramAttributeSet.getString(R.styleable.h);
    this.jdField_b_of_type_JavaLangString = paramAttributeSet.getString(R.styleable.g);
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131704349);
    }
    if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      this.jdField_b_of_type_JavaLangString = "";
    }
    paramAttributeSet.recycle();
    setOrientation(1);
    setVisibility(8);
  }
  
  private static boolean a()
  {
    return Build.VERSION.SDK_INT >= 11;
  }
  
  @TargetApi(11)
  private static void b(View paramView, float paramFloat)
  {
    if (a())
    {
      paramView.setAlpha(paramFloat);
      return;
    }
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(paramFloat, paramFloat);
    localAlphaAnimation.setDuration(0L);
    localAlphaAnimation.setFillAfter(true);
    paramView.clearAnimation();
    paramView.startAnimation(localAlphaAnimation);
  }
  
  public TextView a()
  {
    return this.jdField_a_of_type_AndroidWidgetTextView;
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() == 0)
    {
      this.jdField_b_of_type_Boolean ^= true;
      if (this.jdField_b_of_type_Boolean)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
      }
      else
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_b_of_type_JavaLangString);
        if (!this.jdField_a_of_type_AndroidWidgetTextView.getText().equals(this.jdField_a_of_type_JavaLangCharSequence)) {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangCharSequence);
        }
      }
      Object localObject = this.jdField_a_of_type_AndroidUtilSparseBooleanArray;
      if (localObject != null) {
        ((SparseBooleanArray)localObject).put(this.f, this.jdField_b_of_type_Boolean);
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetExpandableTextView$OnExpandStateListener;
      if (localObject != null) {
        ((ExpandableTextView.OnExpandStateListener)localObject).a(this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_b_of_type_AndroidWidgetTextView, this.jdField_b_of_type_Boolean ^ true);
      }
      this.jdField_a_of_type_Boolean = true;
    }
    EventCollector.getInstance().onViewClicked(paramView);
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
    if ((this.jdField_a_of_type_Boolean) && (getVisibility() != 8))
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(2147483647);
      super.onMeasure(paramInt1, paramInt2);
      if (this.jdField_a_of_type_AndroidWidgetTextView.getLineCount() <= this.jdField_c_of_type_Int) {
        return;
      }
      this.jdField_b_of_type_Int = a(this.jdField_a_of_type_AndroidWidgetTextView);
      if (this.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(this.jdField_c_of_type_Int);
        if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetExpandableTextView$OnGlobalLayoutListenerByEllipsize == null) {
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetExpandableTextView$OnGlobalLayoutListenerByEllipsize = new ExpandableTextView.OnGlobalLayoutListenerByEllipsize(this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_c_of_type_Int);
        }
        this.jdField_a_of_type_AndroidWidgetTextView.getViewTreeObserver().addOnGlobalLayoutListener(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetExpandableTextView$OnGlobalLayoutListenerByEllipsize);
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      super.onMeasure(paramInt1, paramInt2);
      if (this.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.post(new ExpandableTextView.1(this));
        this.jdField_a_of_type_Int = getMeasuredHeight();
      }
      return;
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void setOnExpandStateChangeListener(ExpandableTextView.OnExpandStateListener paramOnExpandStateListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetExpandableTextView$OnExpandStateListener = paramOnExpandStateListener;
  }
  
  public void setOrientation(int paramInt)
  {
    if (paramInt != 0)
    {
      super.setOrientation(paramInt);
      return;
    }
    throw new IllegalArgumentException("ExpandableTextView only supports Vertical Orientation.");
  }
  
  public void setText(CharSequence paramCharSequence)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangCharSequence = paramCharSequence;
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramCharSequence);
    int i;
    if (TextUtils.isEmpty(paramCharSequence)) {
      i = 8;
    } else {
      i = 0;
    }
    setVisibility(i);
  }
  
  public void setText(CharSequence paramCharSequence, SparseBooleanArray paramSparseBooleanArray, int paramInt)
  {
    this.jdField_a_of_type_AndroidUtilSparseBooleanArray = paramSparseBooleanArray;
    this.f = paramInt;
    boolean bool = paramSparseBooleanArray.get(paramInt, true);
    clearAnimation();
    this.jdField_b_of_type_Boolean = bool;
    TextView localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
    if (this.jdField_b_of_type_Boolean) {
      paramSparseBooleanArray = this.jdField_a_of_type_JavaLangString;
    } else {
      paramSparseBooleanArray = this.jdField_b_of_type_JavaLangString;
    }
    localTextView.setText(paramSparseBooleanArray);
    setText(paramCharSequence);
    getLayoutParams().height = -2;
    requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.ExpandableTextView
 * JD-Core Version:    0.7.0.1
 */