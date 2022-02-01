package com.tencent.mobileqq.nearby.profilecard;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.nearby.interestTag.InterestTagInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalLabelLayout;
import java.util.ArrayList;
import java.util.List;

public class SavorTagIcon
  extends HorizontalLabelLayout
  implements View.OnClickListener
{
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "#C6DAF7", "#FFCCC5", "#D9CAF7", "#B6ECD1" };
  float jdField_a_of_type_Float;
  int jdField_a_of_type_Int;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  OnTagClickListener jdField_a_of_type_ComTencentMobileqqNearbyProfilecardOnTagClickListener;
  String jdField_a_of_type_JavaLangString;
  List<InterestTagInfo> jdField_a_of_type_JavaUtilList;
  boolean jdField_a_of_type_Boolean = true;
  int b;
  int c;
  int d;
  int e;
  int f;
  int g;
  int h;
  
  public SavorTagIcon(Context paramContext)
  {
    super(paramContext);
    b();
  }
  
  public SavorTagIcon(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SavorTagIcon(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b();
  }
  
  public String a()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaLangString != null))
    {
      StringBuilder localStringBuilder = new StringBuilder(HardCodeUtil.a(2131713427));
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      localStringBuilder.append(this.jdField_a_of_type_JavaUtilList.size());
      localStringBuilder.append("个");
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        localStringBuilder.append(",");
        localStringBuilder.append(((InterestTagInfo)this.jdField_a_of_type_JavaUtilList.get(i)).tagName);
        i += 1;
      }
      return localStringBuilder.toString();
    }
    return "";
  }
  
  protected void a()
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if ((localList != null) && (localList.size() != 0))
    {
      float f1 = this.jdField_a_of_type_Float;
      this.h = ((int)(f1 * 12.0F));
      this.f = ((int)(f1 * 12.0F));
      return;
    }
    this.h = ((int)(this.jdField_a_of_type_Float * 12.0F));
    this.f = 0;
  }
  
  public void a(String paramString, int paramInt, List<InterestTagInfo> paramList, OnTagClickListener paramOnTagClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardOnTagClickListener = paramOnTagClickListener;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
    paramOnTagClickListener = jdField_a_of_type_ArrayOfJavaLangString;
    paramString = paramOnTagClickListener[0];
    paramInt = this.jdField_a_of_type_Int;
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt == 4) {
            paramString = paramOnTagClickListener[3];
          }
        }
        else {
          paramString = paramOnTagClickListener[2];
        }
      }
      else {
        paramString = paramOnTagClickListener[1];
      }
    }
    else {
      paramString = paramOnTagClickListener[0];
    }
    try
    {
      this.c = Color.parseColor(paramString);
    }
    catch (Exception paramString)
    {
      if (QLog.isDevelopLevel()) {
        paramString.printStackTrace();
      }
    }
    a(paramList);
  }
  
  public void a(List<InterestTagInfo> paramList)
  {
    int i = this.jdField_a_of_type_JavaUtilList.size();
    int j = 1;
    if (i > 0) {
      i = 1;
    } else {
      i = 0;
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    if ((paramList != null) && (paramList.size() > 0)) {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
    if (this.jdField_a_of_type_JavaUtilList.size() <= 0) {
      j = 0;
    }
    if (i != j)
    {
      a();
      setPadding(getPaddingLeft(), 0, getPaddingRight(), 0);
      paramList = this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
      if ((paramList instanceof ViewGroup.MarginLayoutParams)) {
        ((ViewGroup.MarginLayoutParams)paramList).bottomMargin = this.f;
      }
    }
    c();
  }
  
  public boolean a()
  {
    Rect localRect = new Rect();
    int k = getChildCount();
    int i = 0;
    while ((i < k - 1) && (k > 1))
    {
      int j = i + 1;
      View localView = getChildAt(j);
      i = j;
      if (localView.getGlobalVisibleRect(localRect))
      {
        double d1 = localRect.bottom - localRect.top;
        double d2 = localView.getMeasuredHeight();
        Double.isNaN(d2);
        i = j;
        if (d1 >= d2 * 0.5D) {
          return true;
        }
      }
    }
    return false;
  }
  
  protected void b()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("SavorTagIcon", 4, "initView");
    }
    removeAllViews();
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
    if (this.jdField_a_of_type_Float < 0.01F) {
      this.jdField_a_of_type_Float = 1.0F;
    }
    float f1 = this.jdField_a_of_type_Float;
    this.g = ((int)(f1 * 12.0F));
    this.h = ((int)(f1 * 12.0F));
    this.e = ((int)(f1 * 12.0F));
    this.d = ((int)(f1 * 12.0F));
    a();
    setPadding(getPaddingLeft(), 0, getPaddingRight(), 0);
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaUtilList = new ArrayList(2);
    this.b = getResources().getDimensionPixelSize(2131298938);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)LayoutInflater.from(getContext()).inflate(2131561233, null));
    FrameLayout.LayoutParams localLayoutParams = a();
    localLayoutParams.width = -1;
    localLayoutParams.height = -2;
    localLayoutParams.topMargin = this.g;
    localLayoutParams.bottomMargin = this.h;
    addView(this.jdField_a_of_type_AndroidWidgetTextView, localLayoutParams);
  }
  
  protected void c()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("SavorTagIcon", 4, "refreshView");
    }
    int j = this.jdField_a_of_type_JavaUtilList.size();
    int i = getChildCount() - 1;
    Object localObject1;
    if (i > j) {
      while (i > j)
      {
        localObject1 = getChildAt(i);
        ((View)localObject1).setOnClickListener(null);
        removeView((View)localObject1);
        i -= 1;
      }
    }
    Object localObject2;
    if (i < j) {
      while (i < j)
      {
        localObject1 = LayoutInflater.from(getContext()).inflate(2131561229, null);
        localObject2 = a();
        ((ViewGroup.MarginLayoutParams)localObject2).width = -2;
        ((ViewGroup.MarginLayoutParams)localObject2).height = -2;
        ((ViewGroup.MarginLayoutParams)localObject2).bottomMargin = this.e;
        ((ViewGroup.MarginLayoutParams)localObject2).rightMargin = this.d;
        addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
        i += 1;
      }
    }
    if (j > 0)
    {
      localObject1 = new StringBuilder(this.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject1).append('(');
      ((StringBuilder)localObject1).append(j);
      ((StringBuilder)localObject1).append(')');
      this.jdField_a_of_type_AndroidWidgetTextView.setText(((StringBuilder)localObject1).toString());
    }
    else
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
    }
    int k = this.jdField_a_of_type_JavaUtilList.size();
    for (i = 0; i < k; i = j)
    {
      j = i + 1;
      localObject1 = getChildAt(j);
      if (localObject1 == null)
      {
        if (QLog.isDevelopLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("refreshView child is null, index = ");
          ((StringBuilder)localObject1).append(String.valueOf(j));
          QLog.i("SavorTagIcon", 4, ((StringBuilder)localObject1).toString());
        }
      }
      else
      {
        localObject2 = (InterestTagInfo)this.jdField_a_of_type_JavaUtilList.get(i);
        if (localObject2 == null)
        {
          if (QLog.isDevelopLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("refreshView item is null, index = ");
            ((StringBuilder)localObject1).append(String.valueOf(i));
            QLog.i("SavorTagIcon", 4, ((StringBuilder)localObject1).toString());
          }
        }
        else
        {
          String str = ((InterestTagInfo)localObject2).tagName;
          i = this.c;
          try
          {
            i = Color.parseColor(((InterestTagInfo)localObject2).tagBgColor);
          }
          catch (Exception localException1)
          {
            if (QLog.isDevelopLevel()) {
              localException1.printStackTrace();
            }
            i = this.c;
          }
          GradientDrawable localGradientDrawable = new GradientDrawable();
          localGradientDrawable.setColor(i);
          localGradientDrawable.setCornerRadius(this.b);
          try
          {
            i = Color.parseColor(((InterestTagInfo)localObject2).tagTextColor);
          }
          catch (Exception localException2)
          {
            if (QLog.isDevelopLevel()) {
              localException2.printStackTrace();
            }
            i = -1;
          }
          TextView localTextView = (TextView)((View)localObject1).findViewById(2131379994);
          if (localTextView != null)
          {
            localTextView.setText(str);
            localTextView.setTextColor(i);
          }
          ((View)localObject1).setBackgroundDrawable(localGradientDrawable);
          ((View)localObject1).setTag(localObject2);
          if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardOnTagClickListener != null) {
            ((View)localObject1).setOnClickListener(this);
          }
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject;
    if (paramView == null) {
      localObject = null;
    } else {
      localObject = paramView.getTag();
    }
    if ((localObject instanceof InterestTagInfo))
    {
      OnTagClickListener localOnTagClickListener = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardOnTagClickListener;
      if (localOnTagClickListener != null) {
        localOnTagClickListener.a(paramView, this.jdField_a_of_type_Int, (InterestTagInfo)localObject);
      }
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((getContext() instanceof NearbyPeopleProfileActivity)) {
      ((NearbyPeopleProfileActivity)getContext()).setInterceptTouchFlag(false);
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void setRightArrowVisible(boolean paramBoolean)
  {
    if (paramBoolean == this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130839270, 0);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
  }
  
  public void setTitleTextColor(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.SavorTagIcon
 * JD-Core Version:    0.7.0.1
 */