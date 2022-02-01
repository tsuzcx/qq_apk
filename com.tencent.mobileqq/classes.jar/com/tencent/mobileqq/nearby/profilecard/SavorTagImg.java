package com.tencent.mobileqq.nearby.profilecard;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.nearby.interestTag.InterestTagInfo;
import com.tencent.widget.HorizontalListView;
import java.security.InvalidParameterException;
import java.util.List;

public class SavorTagImg
  extends LinearLayout
  implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener
{
  static final int[] jdField_a_of_type_ArrayOfInt = { 60, 60, 60 };
  static final int[] b = { 85, 60, 60 };
  int jdField_a_of_type_Int;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  OnTagClickListener jdField_a_of_type_ComTencentMobileqqNearbyProfilecardOnTagClickListener;
  HorizontalListView jdField_a_of_type_ComTencentWidgetHorizontalListView;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean = true;
  
  public SavorTagImg(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SavorTagImg(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  private void a()
  {
    removeAllViews();
    getResources().getDimensionPixelSize(2131297247);
    int i = getResources().getDimensionPixelSize(2131297248);
    setOrientation(1);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)LayoutInflater.from(getContext()).inflate(2131561233, null));
    LinearLayout.LayoutParams localLayoutParams = generateDefaultLayoutParams();
    localLayoutParams.width = -1;
    localLayoutParams.height = -2;
    localLayoutParams.topMargin = i;
    localLayoutParams.bottomMargin = i;
    addView(this.jdField_a_of_type_AndroidWidgetTextView, localLayoutParams);
  }
  
  private void a(View paramView, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardOnTagClickListener != null)
    {
      Object localObject = (SavorImgTagAdapter)this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getAdapter();
      if (localObject != null)
      {
        localObject = (InterestTagInfo)((SavorImgTagAdapter)localObject).getItem(paramInt);
        if (localObject != null) {
          this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardOnTagClickListener.a(paramView, this.jdField_a_of_type_Int, (InterestTagInfo)localObject);
        }
      }
    }
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_ComTencentWidgetHorizontalListView != null)
    {
      if (this.jdField_a_of_type_JavaLangString == null) {
        return "";
      }
      StringBuilder localStringBuilder = new StringBuilder(HardCodeUtil.a(2131713428));
      ListAdapter localListAdapter = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getAdapter();
      if (localListAdapter == null) {
        return "";
      }
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      localStringBuilder.append(localListAdapter.getCount());
      localStringBuilder.append("个");
      int i = 0;
      while (i < localListAdapter.getCount())
      {
        localStringBuilder.append(",");
        Object localObject = (InterestTagInfo)localListAdapter.getItem(i);
        if (localObject != null) {
          localObject = ((InterestTagInfo)localObject).tagName;
        } else {
          localObject = "";
        }
        localStringBuilder.append((String)localObject);
        i += 1;
      }
      return localStringBuilder.toString();
    }
    return "";
  }
  
  @TargetApi(9)
  public void a(String paramString, int paramInt, List<InterestTagInfo> paramList, OnTagClickListener paramOnTagClickListener)
  {
    if (this.jdField_a_of_type_ComTencentWidgetHorizontalListView == null)
    {
      this.jdField_a_of_type_JavaLangString = paramString;
      this.jdField_a_of_type_Int = paramInt;
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardOnTagClickListener = paramOnTagClickListener;
      if (paramInt != 5)
      {
        if (paramInt == 6) {
          break label52;
        }
        if (paramInt == 7) {}
      }
      else
      {
        i = 0;
        break label55;
      }
      int i = 2;
      break label55;
      label52:
      i = 1;
      label55:
      paramString = getResources();
      float f = paramString.getDisplayMetrics().density;
      int k = (int)(jdField_a_of_type_ArrayOfInt[i] * f);
      int j = (int)(b[i] * f);
      if ((paramInt == 10) || (paramInt == 9) || (paramInt == 11)) {
        j = (int)(jdField_a_of_type_ArrayOfInt[i] * f);
      }
      i = paramString.getDimensionPixelSize(2131298940);
      int m = paramString.getDimensionPixelSize(2131297248);
      paramString = new GradientDrawable();
      if (this.jdField_a_of_type_Int == 7)
      {
        paramString.setColor(getResources().getColor(2131165886));
        paramString.setCornerRadius(f * 10.0F);
        paramString.setShape(0);
        int n = getResources().getDimensionPixelSize(2131297462);
        paramString.setSize(n, n);
      }
      else
      {
        paramString.setColor(getResources().getColor(2131165886));
        paramString.setShape(0);
        paramString.setSize(k, j);
      }
      paramString = new SavorImgTagAdapter(getContext(), paramString, k, j, paramInt);
      paramString.a(0 - i);
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView = new HorizontalListView(getContext());
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setDividerWidth(i);
      paramOnTagClickListener = generateDefaultLayoutParams();
      paramOnTagClickListener.width = -1;
      paramOnTagClickListener.height = paramString.a();
      paramOnTagClickListener.bottomMargin = m;
      addView(this.jdField_a_of_type_ComTencentWidgetHorizontalListView, paramOnTagClickListener);
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(paramString);
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardOnTagClickListener != null)
      {
        this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnItemLongClickListener(this);
        this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnItemClickListener(this);
      }
      else
      {
        this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setTransTouchStateToParent(true);
      }
      if (Build.VERSION.SDK_INT >= 9) {
        this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOverScrollMode(0);
      }
      a(paramList);
      return;
    }
    throw new InvalidParameterException("SavorTagImg can not init twice");
  }
  
  public void a(List<InterestTagInfo> paramList)
  {
    Object localObject = this.jdField_a_of_type_ComTencentWidgetHorizontalListView;
    if (localObject != null)
    {
      localObject = (SavorImgTagAdapter)((HorizontalListView)localObject).getAdapter();
      if (localObject == null) {
        return;
      }
      ((SavorImgTagAdapter)localObject).a(paramList);
      int i;
      if (paramList == null) {
        i = 0;
      } else {
        i = paramList.size();
      }
      if (i > 0)
      {
        paramList = new StringBuilder(this.jdField_a_of_type_JavaLangString);
        paramList.append('(');
        paramList.append(i);
        paramList.append(')');
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramList.toString());
        this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setVisibility(0);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setVisibility(8);
      return;
    }
    throw new InvalidParameterException("can not updateData before init");
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_ComTencentWidgetHorizontalListView != null)
    {
      Rect localRect = new Rect();
      if (this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getGlobalVisibleRect(localRect))
      {
        double d1 = localRect.bottom - localRect.top;
        double d2 = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getMeasuredHeight();
        Double.isNaN(d2);
        if (d1 >= d2 * 0.5D) {
          return true;
        }
      }
    }
    return false;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((getContext() instanceof NearbyPeopleProfileActivity)) {
      ((NearbyPeopleProfileActivity)getContext()).setInterceptTouchFlag(false);
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    a(paramView, paramInt);
  }
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    a(paramView, paramInt);
    return true;
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
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.SavorTagImg
 * JD-Core Version:    0.7.0.1
 */