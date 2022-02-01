package com.tencent.mobileqq.kandian.base.view.widget;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.os.Build.VERSION;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.qphone.base.util.QLog;

@TargetApi(14)
public class ReadinjoySlidingIndicator
  extends FrameLayout
{
  private static final int[] jdField_a_of_type_ArrayOfInt = { 16842901, 16842904 };
  private int jdField_a_of_type_Int;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout.LayoutParams jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private ReadinjoySlidingIndicator.OnIndicatorChangeListener jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadinjoySlidingIndicator$OnIndicatorChangeListener;
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  private int jdField_b_of_type_Int = 0;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private int[] jdField_b_of_type_ArrayOfInt;
  private int c = 0;
  private int d = -16777216;
  private int e = -7829368;
  private int f = 18;
  private int g = 18;
  private int h = 4;
  private int i = -16776961;
  private int j;
  
  public ReadinjoySlidingIndicator(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ReadinjoySlidingIndicator(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ReadinjoySlidingIndicator(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setWillNotDraw(false);
    Object localObject = getResources().getDisplayMetrics();
    this.h = ((int)TypedValue.applyDimension(1, this.h, (DisplayMetrics)localObject));
    this.f = ((int)TypedValue.applyDimension(1, this.f, (DisplayMetrics)localObject));
    this.g = ((int)TypedValue.applyDimension(2, this.g, (DisplayMetrics)localObject));
    localObject = paramContext.obtainStyledAttributes(paramAttributeSet, jdField_a_of_type_ArrayOfInt);
    this.g = ((TypedArray)localObject).getDimensionPixelSize(0, this.g);
    ((TypedArray)localObject).recycle();
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ReadingJoySlidingIndicator);
    this.i = paramAttributeSet.getColor(2, this.i);
    this.d = paramAttributeSet.getColor(1, this.d);
    this.e = paramAttributeSet.getColor(4, this.e);
    this.h = paramAttributeSet.getDimensionPixelSize(0, this.h);
    this.f = paramAttributeSet.getDimensionPixelSize(3, this.f);
    paramAttributeSet.recycle();
    a();
    a(paramContext);
    if (Build.VERSION.SDK_INT >= 14) {
      setAccessibilityDelegate(new ReadinjoySlidingIndicator.1(this));
    }
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(this.g);
  }
  
  private void a(int paramInt, View paramView)
  {
    paramView.setFocusable(true);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramView, paramInt, this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams);
  }
  
  private void a(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    TextView localTextView = new TextView(getContext());
    localTextView.setGravity(17);
    localTextView.setMaxLines(1);
    int k = this.f;
    localTextView.setPadding(k, 0, k, 0);
    localTextView.setTextSize(0, this.g);
    localTextView.setFilters(new InputFilter[] { new InputFilter.LengthFilter(paramInt3 + 3) });
    localTextView.setEllipsize(TextUtils.TruncateAt.END);
    Object localObject = paramString;
    if (paramString.length() > paramInt3)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString.substring(0, paramInt3));
      ((StringBuilder)localObject).append("...");
      localObject = ((StringBuilder)localObject).toString();
    }
    localTextView.setText((CharSequence)localObject);
    paramString = new RedTouch(getContext(), localTextView).b(53).d(8).e(12).a(true).a();
    paramString.setId(paramInt2);
    a(paramInt1, paramString);
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams = new LinearLayout.LayoutParams(-2, -1);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(paramContext);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(0);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setGravity(1);
    b();
  }
  
  private void b()
  {
    this.jdField_b_of_type_AndroidWidgetLinearLayout = new LinearLayout(getContext());
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setOrientation(0);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 1));
    this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(a());
    addView(this.jdField_b_of_type_AndroidWidgetLinearLayout);
  }
  
  private void b(int paramInt)
  {
    int m = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
    int k = 0;
    while (k < m)
    {
      TextView localTextView = (TextView)((RedTouch)this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(k)).a();
      if (k == paramInt) {
        localTextView.setTextColor(this.d);
      } else {
        localTextView.setTextColor(this.e);
      }
      k += 1;
    }
  }
  
  private void c()
  {
    ImageView localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
    if (localImageView != null)
    {
      localImageView.setColorFilter(this.d);
      QLog.d("tag", 2, new Object[] { "color: ", Integer.valueOf(this.d) });
    }
  }
  
  private void c(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    this.jdField_a_of_type_Int = this.jdField_a_of_type_ArrayOfJavaLangString.length;
    int k = 0;
    while (k < this.jdField_a_of_type_Int)
    {
      a(k, this.jdField_a_of_type_ArrayOfJavaLangString[k], this.jdField_b_of_type_ArrayOfInt[k], paramInt);
      k += 1;
    }
    getViewTreeObserver().addOnGlobalLayoutListener(new ReadinjoySlidingIndicator.3(this));
  }
  
  private void d()
  {
    int k = this.c;
    int m = this.jdField_b_of_type_Int;
    if (k != m)
    {
      Object localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(k);
      View localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(this.jdField_b_of_type_Int);
      if ((localObject != null) && (localView != null))
      {
        localObject = ValueAnimator.ofInt(new int[] { ((View)localObject).getLeft(), localView.getLeft() });
        ((ValueAnimator)localObject).setDuration(200L);
        ((ValueAnimator)localObject).addUpdateListener(new ReadinjoySlidingIndicator.2(this));
        ((ValueAnimator)localObject).start();
      }
    }
    else
    {
      this.j = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(m).getLeft();
      invalidate();
    }
  }
  
  public ImageView a()
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView == null)
    {
      this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(getContext());
      c();
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849811);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(AIOUtils.b(7.0F, getResources()), AIOUtils.b(7.0F, getResources()));
      localLayoutParams.gravity = 16;
      localLayoutParams.leftMargin = (-AIOUtils.b(11.0F, getResources()));
      this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
    }
    return this.jdField_a_of_type_AndroidWidgetImageView;
  }
  
  public LinearLayout a()
  {
    return this.jdField_b_of_type_AndroidWidgetLinearLayout;
  }
  
  public void a(int paramInt)
  {
    RedTouch localRedTouch = (RedTouch)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(paramInt);
    if ((localRedTouch != null) && (localRedTouch.c())) {
      localRedTouch.d();
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.d = getResources().getColor(paramInt1);
    this.e = (this.d & 0xFFFFFF | 0x99000000);
    this.i = getResources().getColor(paramInt3);
    b(this.jdField_b_of_type_Int);
    c();
    invalidate();
  }
  
  protected void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.c = this.jdField_b_of_type_Int;
    this.jdField_b_of_type_Int = paramInt;
    int k = this.jdField_b_of_type_Int;
    if ((k != this.c) && (k >= 0))
    {
      localObject = (RedTouch)this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(k);
      b(paramInt);
      if (paramBoolean1)
      {
        d();
      }
      else
      {
        this.j = ((RedTouch)localObject).getLeft();
        invalidate();
      }
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadinjoySlidingIndicator$OnIndicatorChangeListener;
    if (localObject != null) {
      ((ReadinjoySlidingIndicator.OnIndicatorChangeListener)localObject).a(this.c, this.jdField_b_of_type_Int, paramBoolean2);
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (!isInEditMode())
    {
      if (this.jdField_a_of_type_Int == 0) {
        return;
      }
      getHeight();
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.i);
    }
  }
  
  public void setAccessibilityMsg()
  {
    if (AppSetting.d)
    {
      int k = 0;
      while (k < this.jdField_a_of_type_Int)
      {
        View localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(k);
        if (localView != null)
        {
          Object localObject = new StringBuilder();
          ((StringBuilder)localObject).append(this.jdField_a_of_type_ArrayOfJavaLangString[k]);
          ((StringBuilder)localObject).append(HardCodeUtil.a(2131712913));
          String str = ((StringBuilder)localObject).toString();
          localObject = str;
          if (k == this.jdField_b_of_type_Int)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(str);
            ((StringBuilder)localObject).append(HardCodeUtil.a(2131713051));
            localObject = ((StringBuilder)localObject).toString();
          }
          localView.setContentDescription((CharSequence)localObject);
        }
        k += 1;
      }
    }
  }
  
  public void setCurrentPosition(int paramInt, boolean paramBoolean)
  {
    a(paramInt, paramBoolean, false);
  }
  
  public void setOnIndicatorChangeListener(ReadinjoySlidingIndicator.OnIndicatorChangeListener paramOnIndicatorChangeListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadinjoySlidingIndicator$OnIndicatorChangeListener = paramOnIndicatorChangeListener;
  }
  
  public void setOverScrollMode(int paramInt)
  {
    super.setOverScrollMode(2);
  }
  
  public void setTabData(String[] paramArrayOfString, int[] paramArrayOfInt, int paramInt)
  {
    if ((paramArrayOfString != null) && (paramArrayOfString.length != 0) && (paramArrayOfInt != null))
    {
      if (paramArrayOfInt.length != paramArrayOfString.length) {
        return;
      }
      this.jdField_a_of_type_ArrayOfJavaLangString = ((String[])paramArrayOfString.clone());
      this.jdField_b_of_type_ArrayOfInt = ((int[])paramArrayOfInt.clone());
      c(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.ReadinjoySlidingIndicator
 * JD-Core Version:    0.7.0.1
 */