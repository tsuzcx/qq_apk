package com.tencent.mobileqq.nearby.profilecard;

import amtj;
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
import axdg;
import com.tencent.mobileqq.nearby.interestTag.InterestTagInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
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
  axdg jdField_a_of_type_Axdg;
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
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaLangString == null)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder(amtj.a(2131712616));
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString).append(this.jdField_a_of_type_JavaUtilList.size()).append("个");
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      localStringBuilder.append(",");
      localStringBuilder.append(((InterestTagInfo)this.jdField_a_of_type_JavaUtilList.get(i)).tagName);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  protected void a()
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0))
    {
      this.h = ((int)(this.jdField_a_of_type_Float * 12.0F));
      this.f = 0;
      return;
    }
    this.h = ((int)(this.jdField_a_of_type_Float * 12.0F));
    this.f = ((int)(this.jdField_a_of_type_Float * 12.0F));
  }
  
  public void a(String paramString, int paramInt, List<InterestTagInfo> paramList, axdg paramaxdg)
  {
    this.jdField_a_of_type_Axdg = paramaxdg;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
    paramString = jdField_a_of_type_ArrayOfJavaLangString[0];
    switch (this.jdField_a_of_type_Int)
    {
    }
    try
    {
      for (;;)
      {
        this.c = Color.parseColor(paramString);
        a(paramList);
        return;
        paramString = jdField_a_of_type_ArrayOfJavaLangString[0];
        continue;
        paramString = jdField_a_of_type_ArrayOfJavaLangString[1];
        continue;
        paramString = jdField_a_of_type_ArrayOfJavaLangString[2];
        continue;
        paramString = jdField_a_of_type_ArrayOfJavaLangString[3];
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        if (QLog.isDevelopLevel()) {
          paramString.printStackTrace();
        }
      }
    }
  }
  
  public void a(List<InterestTagInfo> paramList)
  {
    int j = 1;
    int i;
    if (this.jdField_a_of_type_JavaUtilList.size() > 0)
    {
      i = 1;
      this.jdField_a_of_type_JavaUtilList.clear();
      if ((paramList != null) && (paramList.size() > 0)) {
        this.jdField_a_of_type_JavaUtilList.addAll(paramList);
      }
      if (this.jdField_a_of_type_JavaUtilList.size() <= 0) {
        break label120;
      }
    }
    for (;;)
    {
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
      return;
      i = 0;
      break;
      label120:
      j = 0;
    }
  }
  
  public boolean a()
  {
    Rect localRect = new Rect();
    int j = getChildCount();
    int i = 0;
    while ((i < j - 1) && (j > 1))
    {
      View localView = getChildAt(i + 1);
      if ((localView.getGlobalVisibleRect(localRect)) && (localRect.bottom - localRect.top >= 0.5D * localView.getMeasuredHeight())) {
        return true;
      }
      i += 1;
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
    this.g = ((int)(this.jdField_a_of_type_Float * 12.0F));
    this.h = ((int)(this.jdField_a_of_type_Float * 12.0F));
    this.e = ((int)(this.jdField_a_of_type_Float * 12.0F));
    this.d = ((int)(this.jdField_a_of_type_Float * 12.0F));
    a();
    setPadding(getPaddingLeft(), 0, getPaddingRight(), 0);
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaUtilList = new ArrayList(2);
    this.b = getResources().getDimensionPixelSize(2131298842);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)LayoutInflater.from(getContext()).inflate(2131561228, null));
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
        localObject1 = LayoutInflater.from(getContext()).inflate(2131561224, null);
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
      ((StringBuilder)localObject1).append('(').append(j).append(')');
      this.jdField_a_of_type_AndroidWidgetTextView.setText(((StringBuilder)localObject1).toString());
      int k = this.jdField_a_of_type_JavaUtilList.size();
      i = 0;
      label205:
      if (i >= k) {
        return;
      }
      localObject1 = getChildAt(i + 1);
      if (localObject1 != null) {
        break label282;
      }
      if (QLog.isDevelopLevel()) {
        QLog.i("SavorTagIcon", 4, "refreshView child is null, index = " + String.valueOf(i + 1));
      }
    }
    for (;;)
    {
      i += 1;
      break label205;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
      break;
      label282:
      localObject2 = (InterestTagInfo)this.jdField_a_of_type_JavaUtilList.get(i);
      if (localObject2 == null)
      {
        if (QLog.isDevelopLevel()) {
          QLog.i("SavorTagIcon", 4, "refreshView item is null, index = " + String.valueOf(i));
        }
      }
      else
      {
        String str = ((InterestTagInfo)localObject2).tagName;
        j = this.c;
        try
        {
          j = Color.parseColor(((InterestTagInfo)localObject2).tagBgColor);
          localGradientDrawable = new GradientDrawable();
          localGradientDrawable.setColor(j);
          localGradientDrawable.setCornerRadius(this.b);
        }
        catch (Exception localException1)
        {
          try
          {
            GradientDrawable localGradientDrawable;
            j = Color.parseColor(((InterestTagInfo)localObject2).tagTextColor);
            TextView localTextView = (TextView)((View)localObject1).findViewById(2131379944);
            if (localTextView != null)
            {
              localTextView.setText(str);
              localTextView.setTextColor(j);
            }
            ((View)localObject1).setBackgroundDrawable(localGradientDrawable);
            ((View)localObject1).setTag(localObject2);
            if (this.jdField_a_of_type_Axdg != null)
            {
              ((View)localObject1).setOnClickListener(this);
              continue;
              localException1 = localException1;
              if (QLog.isDevelopLevel()) {
                localException1.printStackTrace();
              }
              j = this.c;
            }
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              if (QLog.isDevelopLevel()) {
                localException2.printStackTrace();
              }
              j = -1;
            }
          }
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView == null) {}
    for (Object localObject = null;; localObject = paramView.getTag())
    {
      if (((localObject instanceof InterestTagInfo)) && (this.jdField_a_of_type_Axdg != null)) {
        this.jdField_a_of_type_Axdg.a(paramView, this.jdField_a_of_type_Int, (InterestTagInfo)localObject);
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((getContext() instanceof NearbyPeopleProfileActivity)) {
      ((NearbyPeopleProfileActivity)getContext()).a(false);
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
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130839316, 0);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
  }
  
  public void setTitleTextColor(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.SavorTagIcon
 * JD-Core Version:    0.7.0.1
 */