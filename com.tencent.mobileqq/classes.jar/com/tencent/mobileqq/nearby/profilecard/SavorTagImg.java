package com.tencent.mobileqq.nearby.profilecard;

import alpo;
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
import avll;
import avlp;
import com.tencent.mobileqq.nearby.interestTag.InterestTagInfo;
import com.tencent.widget.HorizontalListView;
import java.security.InvalidParameterException;
import java.util.List;

public class SavorTagImg
  extends LinearLayout
  implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener
{
  public static final int[] a;
  static final int[] b = { 85, 60, 60 };
  int jdField_a_of_type_Int;
  public TextView a;
  avll jdField_a_of_type_Avll;
  public HorizontalListView a;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean = true;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 60, 60, 60 };
  }
  
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
    getResources().getDimensionPixelSize(2131297112);
    int i = getResources().getDimensionPixelSize(2131297113);
    setOrientation(1);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)LayoutInflater.from(getContext()).inflate(2131561086, null));
    LinearLayout.LayoutParams localLayoutParams = generateDefaultLayoutParams();
    localLayoutParams.width = -1;
    localLayoutParams.height = -2;
    localLayoutParams.topMargin = i;
    localLayoutParams.bottomMargin = i;
    addView(this.jdField_a_of_type_AndroidWidgetTextView, localLayoutParams);
  }
  
  private void a(View paramView, int paramInt)
  {
    if (this.jdField_a_of_type_Avll != null)
    {
      Object localObject = (avlp)this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getAdapter();
      if (localObject != null)
      {
        localObject = (InterestTagInfo)((avlp)localObject).getItem(paramInt);
        if (localObject != null) {
          this.jdField_a_of_type_Avll.a(paramView, this.jdField_a_of_type_Int, (InterestTagInfo)localObject);
        }
      }
    }
  }
  
  public String a()
  {
    if ((this.jdField_a_of_type_ComTencentWidgetHorizontalListView == null) || (this.jdField_a_of_type_JavaLangString == null)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder(alpo.a(2131713885));
    ListAdapter localListAdapter = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getAdapter();
    if (localListAdapter == null) {
      return "";
    }
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString).append(localListAdapter.getCount()).append("个");
    int i = 0;
    if (i < localListAdapter.getCount())
    {
      localStringBuilder.append(",");
      Object localObject = (InterestTagInfo)localListAdapter.getItem(i);
      if (localObject != null) {}
      for (localObject = ((InterestTagInfo)localObject).tagName;; localObject = "")
      {
        localStringBuilder.append((String)localObject);
        i += 1;
        break;
      }
    }
    return localStringBuilder.toString();
  }
  
  @TargetApi(9)
  public void a(String paramString, int paramInt, List<InterestTagInfo> paramList, avll paramavll)
  {
    if (this.jdField_a_of_type_ComTencentWidgetHorizontalListView != null) {
      throw new InvalidParameterException("SavorTagImg can not init twice");
    }
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Avll = paramavll;
    int i = 0;
    int k;
    int j;
    switch (paramInt)
    {
    default: 
      paramString = getResources();
      float f = paramString.getDisplayMetrics().density;
      k = (int)(jdField_a_of_type_ArrayOfInt[i] * f);
      j = (int)(b[i] * f);
      if ((paramInt == 10) || (paramInt == 9) || (paramInt == 11)) {
        j = (int)(jdField_a_of_type_ArrayOfInt[i] * f);
      }
      i = paramString.getDimensionPixelSize(2131298683);
      int m = paramString.getDimensionPixelSize(2131297113);
      paramString = new GradientDrawable();
      if (this.jdField_a_of_type_Int == 7)
      {
        paramString.setColor(getResources().getColor(2131165804));
        paramString.setCornerRadius(10.0F * f);
        paramString.setShape(0);
        int n = getResources().getDimensionPixelSize(2131297274);
        paramString.setSize(n, n);
        label214:
        paramString = new avlp(getContext(), paramString, k, j, paramInt);
        paramString.a(0 - i);
        this.jdField_a_of_type_ComTencentWidgetHorizontalListView = new HorizontalListView(getContext());
        this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setDividerWidth(i);
        paramavll = generateDefaultLayoutParams();
        paramavll.width = -1;
        paramavll.height = paramString.a();
        paramavll.bottomMargin = m;
        addView(this.jdField_a_of_type_ComTencentWidgetHorizontalListView, paramavll);
        this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(paramString);
        if (this.jdField_a_of_type_Avll == null) {
          break label402;
        }
        this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnItemLongClickListener(this);
        this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnItemClickListener(this);
      }
      break;
    }
    for (;;)
    {
      if (Build.VERSION.SDK_INT >= 9) {
        this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOverScrollMode(0);
      }
      a(paramList);
      return;
      i = 0;
      break;
      i = 1;
      break;
      i = 2;
      break;
      paramString.setColor(getResources().getColor(2131165804));
      paramString.setShape(0);
      paramString.setSize(k, j);
      break label214;
      label402:
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setTransTouchStateToParent(true);
    }
  }
  
  public void a(List<InterestTagInfo> paramList)
  {
    if (this.jdField_a_of_type_ComTencentWidgetHorizontalListView == null) {
      throw new InvalidParameterException("can not updateData before init");
    }
    avlp localavlp = (avlp)this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getAdapter();
    if (localavlp == null) {
      return;
    }
    localavlp.a(paramList);
    if (paramList == null) {}
    for (int i = 0; i > 0; i = paramList.size())
    {
      paramList = new StringBuilder(this.jdField_a_of_type_JavaLangString);
      paramList.append('(').append(i).append(')');
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramList.toString());
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setVisibility(8);
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_ComTencentWidgetHorizontalListView != null)
    {
      Rect localRect = new Rect();
      if ((this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getGlobalVisibleRect(localRect)) && (localRect.bottom - localRect.top >= 0.5D * this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getMeasuredHeight())) {
        return true;
      }
    }
    return false;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((getContext() instanceof NearbyPeopleProfileActivity)) {
      ((NearbyPeopleProfileActivity)getContext()).a(false);
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
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130839097, 0);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
  }
  
  public void setTitleTextColor(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.SavorTagImg
 * JD-Core Version:    0.7.0.1
 */