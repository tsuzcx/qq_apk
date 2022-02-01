package com.tencent.mobileqq.onlinestatus;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import azbu;
import azbz;
import azcg;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class OnlineStatusPagerAdapter
  extends PagerAdapter
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private ViewPager jdField_a_of_type_AndroidSupportV4ViewViewPager;
  private azbz jdField_a_of_type_Azbz;
  private azcg jdField_a_of_type_Azcg = new azcg();
  public ArrayList<azbu> a;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private ArrayList<azbu> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private int c;
  
  OnlineStatusPagerAdapter(Context paramContext, int paramInt1, int paramInt2, boolean paramBoolean, ViewPager paramViewPager)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = (paramInt1 * 4);
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager = paramViewPager;
  }
  
  private List<azbu> a(int paramInt)
  {
    paramInt = this.jdField_a_of_type_Int * paramInt;
    int i = Math.min(this.jdField_b_of_type_JavaUtilArrayList.size(), this.jdField_a_of_type_Int + paramInt);
    return this.jdField_b_of_type_JavaUtilArrayList.subList(paramInt, i);
  }
  
  public int a()
  {
    int k = 0;
    if (this.jdField_a_of_type_Boolean) {
      return 0;
    }
    int j = k;
    azbu localazbu;
    int i;
    if (this.jdField_a_of_type_JavaUtilArrayList.size() == 1)
    {
      localazbu = (azbu)this.jdField_a_of_type_JavaUtilArrayList.get(0);
      i = 0;
    }
    for (;;)
    {
      j = k;
      if (i < this.jdField_b_of_type_JavaUtilArrayList.size())
      {
        if (((azbu)this.jdField_b_of_type_JavaUtilArrayList.get(i)).a == localazbu.a) {
          j = i;
        }
      }
      else {
        return j / this.jdField_a_of_type_Int;
      }
      i += 1;
    }
  }
  
  public ArrayList<azbu> a()
  {
    return this.jdField_b_of_type_JavaUtilArrayList;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidSupportV4ViewViewPager == null) {
      return;
    }
    int j = getCount();
    int k = this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getChildCount();
    int i = 0;
    label23:
    OnlineStatusListLayout localOnlineStatusListLayout;
    if (i < k)
    {
      localOnlineStatusListLayout = (OnlineStatusListLayout)this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getChildAt(i);
      if (localOnlineStatusListLayout != null) {
        break label53;
      }
    }
    for (;;)
    {
      i += 1;
      break label23;
      break;
      label53:
      int m = localOnlineStatusListLayout.a();
      if ((m >= 0) && (m < j)) {
        localOnlineStatusListLayout.a(a(m), this.jdField_a_of_type_JavaUtilArrayList);
      }
    }
  }
  
  public void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void a(azbu paramazbu, View paramView)
  {
    azbu localazbu = null;
    if (!this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
        localazbu = (azbu)this.jdField_a_of_type_JavaUtilArrayList.get(0);
      }
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilArrayList.add(paramazbu);
      if (this.jdField_a_of_type_Azbz != null) {
        this.jdField_a_of_type_Azbz.a(localazbu, paramazbu, paramView);
      }
    }
    do
    {
      do
      {
        return;
        if (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramazbu)) {
          break;
        }
        this.jdField_a_of_type_JavaUtilArrayList.remove(paramazbu);
      } while (this.jdField_a_of_type_Azbz == null);
      this.jdField_a_of_type_Azbz.a(paramazbu, null, paramView);
      return;
      this.jdField_a_of_type_JavaUtilArrayList.add(paramazbu);
    } while (this.jdField_a_of_type_Azbz == null);
    this.jdField_a_of_type_Azbz.a(null, paramazbu, paramView);
  }
  
  public void a(azbz paramazbz)
  {
    this.jdField_a_of_type_Azbz = paramazbz;
  }
  
  public void a(ArrayList<azbu> paramArrayList)
  {
    this.jdField_b_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    if ((paramObject instanceof OnlineStatusListLayout))
    {
      OnlineStatusListLayout localOnlineStatusListLayout = (OnlineStatusListLayout)paramObject;
      localOnlineStatusListLayout.setPageIndex(-1);
      paramViewGroup.removeView(localOnlineStatusListLayout);
      this.jdField_a_of_type_Azcg.a(paramInt, (View)paramObject);
    }
  }
  
  public int getCount()
  {
    int i = this.jdField_b_of_type_JavaUtilArrayList.size();
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
    boolean bool2 = true;
    List localList = a(paramInt);
    OnlineStatusListLayout localOnlineStatusListLayout2 = (OnlineStatusListLayout)this.jdField_a_of_type_Azcg.a(paramInt);
    OnlineStatusListLayout localOnlineStatusListLayout1 = localOnlineStatusListLayout2;
    if (localOnlineStatusListLayout2 == null)
    {
      localOnlineStatusListLayout1 = new OnlineStatusListLayout(this.jdField_a_of_type_AndroidContentContext);
      localOnlineStatusListLayout1.setItemWidth(this.c);
      localOnlineStatusListLayout1.setItemMargin(OnlineStatusPanel.a(this.jdField_b_of_type_Int, localOnlineStatusListLayout1.getResources()));
      if (this.jdField_b_of_type_Int != 1) {
        break label172;
      }
      bool1 = true;
      localOnlineStatusListLayout1.setUseWhiteBg(bool1);
      if (this.jdField_b_of_type_Int != 3) {
        break label177;
      }
    }
    label172:
    label177:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localOnlineStatusListLayout1.setUseLightNightBg(bool1);
      localOnlineStatusListLayout1.setMultiMode(this.jdField_a_of_type_Boolean);
      localOnlineStatusListLayout1.setOnClickListener(this);
      localOnlineStatusListLayout1.a(this.jdField_a_of_type_Int, this);
      localOnlineStatusListLayout1.a(localList, this.jdField_a_of_type_JavaUtilArrayList);
      localOnlineStatusListLayout1.setPageIndex(paramInt);
      if ((localOnlineStatusListLayout1.getParent() != paramViewGroup) && (paramInt < getCount())) {
        paramViewGroup.addView(localOnlineStatusListLayout1);
      }
      return localOnlineStatusListLayout1;
      bool1 = false;
      break;
    }
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((paramView instanceof OnlineStatusListLayout)) {
      if ((((OnlineStatusListLayout)paramView).a()) && (this.jdField_a_of_type_Azbz != null)) {
        this.jdField_a_of_type_Azbz.a(paramView);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((localObject instanceof azbu))
      {
        a((azbu)localObject, paramView);
        a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.OnlineStatusPagerAdapter
 * JD-Core Version:    0.7.0.1
 */