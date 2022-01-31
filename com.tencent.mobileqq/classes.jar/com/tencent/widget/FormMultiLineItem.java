package com.tencent.widget;

import ajjy;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.R.styleable;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class FormMultiLineItem
  extends RelativeLayout
{
  private int jdField_a_of_type_Int;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private ArrayList<MultiImageTextView> jdField_a_of_type_JavaUtilArrayList;
  private int b = -1;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  
  public FormMultiLineItem(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FormMultiLineItem(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FormMultiLineItem(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramAttributeSet);
    a();
  }
  
  public static Drawable a(Resources paramResources, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return paramResources.getDrawable(2130839144);
    case 0: 
      return paramResources.getDrawable(2130839144);
    case 1: 
      return paramResources.getDrawable(2130839160);
    case 2: 
      return paramResources.getDrawable(2130839154);
    }
    return paramResources.getDrawable(2130839151);
  }
  
  private void a()
  {
    if ((this.b < 2) && (this.b > 0)) {
      throw new RuntimeException("mLineNum < 2, recommend to use FormSimpleItem");
    }
    int n = getResources().getDimensionPixelSize(2131165565);
    int k = getResources().getDimensionPixelSize(2131165574);
    int m = getResources().getDimensionPixelSize(2131165563);
    int j;
    MultiImageTextView localMultiImageTextView;
    RelativeLayout.LayoutParams localLayoutParams;
    if (this.b == 2)
    {
      j = getResources().getDimensionPixelSize(2131165549);
      this.c = m;
      setBackgroundDrawable(a(getResources(), this.jdField_a_of_type_Int));
      setMinimumHeight(this.d);
      setPadding(this.g, 0, this.h, 0);
      this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(getContext());
      this.jdField_a_of_type_AndroidWidgetImageView.setId(2131301006);
      this.jdField_a_of_type_AndroidWidgetImageView.setFocusable(false);
      this.jdField_a_of_type_AndroidWidgetImageView.setClickable(false);
      this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.FIT_XY);
      addView(this.jdField_a_of_type_AndroidWidgetImageView);
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      localMultiImageTextView = new MultiImageTextView(getContext());
      localMultiImageTextView.setId(2131301004);
      localMultiImageTextView.setTextSize(0, n);
      localMultiImageTextView.setTextColor(getResources().getColor(2131101320));
      localMultiImageTextView.setSingleLine(true);
      localMultiImageTextView.setDuplicateParentStateEnabled(true);
      localMultiImageTextView.setEllipsize(TextUtils.TruncateAt.END);
      localMultiImageTextView.setText(ajjy.a(2131638936));
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(1, 2131301006);
      localLayoutParams.bottomMargin = j;
      localLayoutParams.leftMargin = this.i;
      this.jdField_a_of_type_JavaUtilArrayList.add(localMultiImageTextView);
      addView(localMultiImageTextView, localLayoutParams);
      j = 1;
      label314:
      if (j >= this.b) {
        return;
      }
      localMultiImageTextView = new MultiImageTextView(getContext());
      localMultiImageTextView.setTextSize(0, k);
      localMultiImageTextView.setTextColor(getResources().getColor(2131101338));
      localMultiImageTextView.setSingleLine(true);
      localMultiImageTextView.setDuplicateParentStateEnabled(true);
      localMultiImageTextView.setEllipsize(TextUtils.TruncateAt.END);
      localMultiImageTextView.setText(ajjy.a(2131638938));
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.leftMargin = this.i;
      localLayoutParams.addRule(1, 2131301006);
      if (j != 1) {
        break label483;
      }
      localMultiImageTextView.setId(2131301010);
    }
    for (;;)
    {
      if (j != this.b - 1) {
        localLayoutParams.bottomMargin = m;
      }
      addView(localMultiImageTextView, localLayoutParams);
      this.jdField_a_of_type_JavaUtilArrayList.add(localMultiImageTextView);
      j += 1;
      break label314;
      j = getResources().getDimensionPixelSize(2131165564);
      break;
      label483:
      if (j == 2) {
        localMultiImageTextView.setId(2131301011);
      }
    }
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt3 = 0;
    paramInt2 = paramInt1;
    paramInt1 = paramInt3;
    while (paramInt1 < this.b)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((MultiImageTextView)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt1)).getLayoutParams();
      localLayoutParams.topMargin = paramInt2;
      localLayoutParams.leftMargin = this.i;
      paramInt2 += ((MultiImageTextView)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt1)).getMeasuredHeight();
      ((MultiImageTextView)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt1)).setLayoutParams(localLayoutParams);
      paramInt1 += 1;
    }
  }
  
  private void a(AttributeSet paramAttributeSet)
  {
    paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.MultiLineItem);
    try
    {
      if (this.b < 0) {
        this.b = paramAttributeSet.getInt(5, 2);
      }
      this.f = paramAttributeSet.getDimensionPixelSize(3, 0);
      this.e = paramAttributeSet.getDimensionPixelSize(2, 0);
      this.d = paramAttributeSet.getDimensionPixelSize(6, 0);
      int j = getResources().getDimensionPixelSize(2131165556);
      int k = getResources().getDimensionPixelSize(2131165558);
      int m = getResources().getDimensionPixelSize(2131165554);
      this.g = paramAttributeSet.getDimensionPixelSize(4, j);
      this.h = paramAttributeSet.getDimensionPixelSize(8, k);
      this.i = paramAttributeSet.getDimensionPixelSize(7, m);
      this.jdField_a_of_type_Int = paramAttributeSet.getInteger(0, 0);
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FormMultiLineItem", 2, localException.toString());
      }
      return;
    }
    finally
    {
      paramAttributeSet.recycle();
    }
  }
  
  public ImageView a()
  {
    return this.jdField_a_of_type_AndroidWidgetImageView;
  }
  
  public MultiImageTextView a(int paramInt)
  {
    if ((paramInt >= this.b) || (paramInt < 0)) {
      throw new RuntimeException("Qui MultiLineItem array index out of range");
    }
    return (MultiImageTextView)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.e == 0)
    {
      if (this.b == 2) {
        this.e = getResources().getDimensionPixelSize(2131165548);
      }
    }
    else
    {
      if (this.f == 0)
      {
        if (this.b != 2) {
          break label226;
        }
        this.f = getResources().getDimensionPixelSize(2131165548);
      }
      label58:
      if (this.d == 0) {
        if (this.b != 2) {
          break label243;
        }
      }
    }
    RelativeLayout.LayoutParams localLayoutParams;
    int k;
    int j;
    label226:
    label243:
    for (this.d = getResources().getDimensionPixelSize(2131165547);; this.d = getResources().getDimensionPixelSize(2131165561))
    {
      setMinimumHeight(this.d);
      setPadding(this.g, 0, this.h, 0);
      localLayoutParams = new RelativeLayout.LayoutParams(this.f, this.e);
      this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
      localLayoutParams.addRule(9, -1);
      localLayoutParams.addRule(15, -1);
      k = 0;
      j = 0;
      while (k < this.b)
      {
        ((MultiImageTextView)this.jdField_a_of_type_JavaUtilArrayList.get(k)).measure(paramInt1, paramInt2);
        j += ((MultiImageTextView)this.jdField_a_of_type_JavaUtilArrayList.get(k)).getMeasuredHeight();
        k += 1;
      }
      this.e = getResources().getDimensionPixelSize(2131165562);
      break;
      this.f = getResources().getDimensionPixelSize(2131165562);
      break label58;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.measure(paramInt1, paramInt2);
    if ((this.jdField_a_of_type_AndroidWidgetImageView.getMeasuredHeight() > j) || (this.b <= 3))
    {
      k = this.c;
      int m = this.b;
      a((this.d - (k * (m - 1) + j)) / 2, paramInt1, paramInt2);
    }
    for (;;)
    {
      super.onMeasure(paramInt1, paramInt2);
      return;
      j = getResources().getDimensionPixelSize(2131165559);
      k = getResources().getDimensionPixelSize(2131165555);
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      localLayoutParams.topMargin = j;
      this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
      a(j, paramInt1, paramInt2);
      localLayoutParams = (RelativeLayout.LayoutParams)((MultiImageTextView)this.jdField_a_of_type_JavaUtilArrayList.get(this.b - 1)).getLayoutParams();
      localLayoutParams.bottomMargin = k;
      ((MultiImageTextView)this.jdField_a_of_type_JavaUtilArrayList.get(this.b - 1)).setLayoutParams(localLayoutParams);
    }
  }
  
  public void setAllTextColor(int paramInt)
  {
    ColorStateList localColorStateList = getResources().getColorStateList(paramInt);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((MultiImageTextView)localIterator.next()).setTextColor(localColorStateList);
    }
  }
  
  public void setAllTextSize(float paramFloat)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((MultiImageTextView)localIterator.next()).setTextSize(paramFloat);
    }
  }
  
  public void setBackGroundByType(int paramInt)
  {
    setBackgroundDrawable(a(getResources(), paramInt));
  }
  
  public void setHeaderView(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(paramInt);
    }
  }
  
  public void setHeaderWeight(int paramInt1, int paramInt2)
  {
    this.f = paramInt1;
    this.e = paramInt2;
  }
  
  public void setLineNum(int paramInt)
  {
    if (paramInt < 2) {
      throw new RuntimeException("recommend to use >=2 lineNum, or use FormSingleItem widget");
    }
    if (this.b == paramInt) {}
    for (;;)
    {
      postInvalidate();
      return;
      int j;
      if (this.b < paramInt)
      {
        int k = getResources().getDimensionPixelSize(2131165574);
        int m = this.b;
        j = 0;
        while (j < paramInt - m)
        {
          MultiImageTextView localMultiImageTextView = new MultiImageTextView(getContext());
          localMultiImageTextView.setTextSize(0, k);
          localMultiImageTextView.setTextColor(getResources().getColor(2131101338));
          localMultiImageTextView.setSingleLine(true);
          localMultiImageTextView.setDuplicateParentStateEnabled(true);
          localMultiImageTextView.setEllipsize(TextUtils.TruncateAt.END);
          localMultiImageTextView.setText(ajjy.a(2131638937));
          RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
          localLayoutParams.leftMargin = this.i;
          localLayoutParams.addRule(1, 2131301006);
          this.jdField_a_of_type_JavaUtilArrayList.add(localMultiImageTextView);
          addView(localMultiImageTextView, localLayoutParams);
          j += 1;
        }
        this.b = paramInt;
      }
      else if (this.b > paramInt)
      {
        j = this.b;
        while (j > paramInt)
        {
          this.jdField_a_of_type_JavaUtilArrayList.remove(this.b - 1);
          j -= 1;
        }
        this.b = paramInt;
      }
    }
  }
  
  public void setMarginLeftRight(int paramInt1, int paramInt2)
  {
    this.g = paramInt1;
    this.h = paramInt2;
  }
  
  public void setmMinHeight(int paramInt)
  {
    this.d = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.widget.FormMultiLineItem
 * JD-Core Version:    0.7.0.1
 */