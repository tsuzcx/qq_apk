package com.tencent.mobileqq.onlinestatus;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import awev;
import awew;
import awex;
import java.util.ArrayList;
import java.util.List;

public class OnlineStatusPagerAdapter
  extends PagerAdapter
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  public awev a;
  private awew jdField_a_of_type_Awew;
  private awex jdField_a_of_type_Awex = new awex();
  private ArrayList<awev> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  OnlineStatusPagerAdapter(Context paramContext, int paramInt)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = (paramInt * 3);
  }
  
  private List<awev> a(int paramInt)
  {
    paramInt = this.jdField_a_of_type_Int * paramInt;
    int i = Math.min(this.jdField_a_of_type_JavaUtilArrayList.size(), this.jdField_a_of_type_Int + paramInt);
    return this.jdField_a_of_type_JavaUtilArrayList.subList(paramInt, i);
  }
  
  public void a(awew paramawew)
  {
    this.jdField_a_of_type_Awew = paramawew;
  }
  
  public void a(ArrayList<awev> paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    if ((paramObject instanceof OnlineStatusListLayout))
    {
      paramViewGroup.removeView((OnlineStatusListLayout)paramObject);
      this.jdField_a_of_type_Awex.a(paramInt, (View)paramObject);
    }
  }
  
  public int getCount()
  {
    int i = this.jdField_a_of_type_JavaUtilArrayList.size();
    int j = i / this.jdField_a_of_type_Int;
    if (i % this.jdField_a_of_type_Int > 0) {}
    for (i = 1;; i = 0) {
      return i + j;
    }
  }
  
  public int getItemPosition(Object paramObject)
  {
    return -2;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    OnlineStatusListLayout localOnlineStatusListLayout = (OnlineStatusListLayout)this.jdField_a_of_type_Awex.a(paramInt);
    if (localOnlineStatusListLayout == null) {
      localOnlineStatusListLayout = new OnlineStatusListLayout(this.jdField_a_of_type_AndroidContentContext);
    }
    for (;;)
    {
      localOnlineStatusListLayout.a(a(paramInt), this);
      localOnlineStatusListLayout.a(this.jdField_a_of_type_Awev);
      if ((localOnlineStatusListLayout.getParent() != paramViewGroup) && (paramInt < getCount())) {
        paramViewGroup.addView(localOnlineStatusListLayout);
      }
      return localOnlineStatusListLayout;
      localOnlineStatusListLayout.removeAllViews();
    }
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
  
  public void onClick(View paramView)
  {
    paramView = paramView.getTag();
    if ((paramView instanceof awev))
    {
      paramView = (awev)paramView;
      if (this.jdField_a_of_type_Awew != null) {
        this.jdField_a_of_type_Awew.a(this.jdField_a_of_type_Awev, paramView);
      }
      this.jdField_a_of_type_Awev = paramView;
      notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.OnlineStatusPagerAdapter
 * JD-Core Version:    0.7.0.1
 */