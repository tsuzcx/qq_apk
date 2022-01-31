package com.tencent.mobileqq.leba.header;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.GridView;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.leba.view.LebaGridIndicator;
import com.tencent.mobileqq.troop.utils.TroopTechReportUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class GridMenuAdapter
{
  protected int a;
  public Context a;
  protected ArrayList a;
  protected List a;
  protected boolean a;
  protected int b;
  protected ArrayList b;
  protected int c;
  private ArrayList c;
  public int d;
  private ArrayList d;
  protected int e;
  protected int f;
  protected int g;
  
  public GridMenuAdapter(Context paramContext, List paramList, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_c_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_d_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_d_of_type_Int = (paramInt1 * paramInt2);
    this.jdField_c_of_type_Int = a(paramList.size(), this.jdField_d_of_type_Int);
    this.f = paramList.size();
  }
  
  private int a(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = paramInt3;
    if (paramInt1 <= paramInt2 * paramInt3) {
      i = (int)Math.ceil(1.0D * paramInt1 / paramInt2);
    }
    if (i != this.g)
    {
      this.jdField_a_of_type_Boolean = true;
      this.g = i;
    }
    return LebaGridUtils.a(this.jdField_a_of_type_AndroidContentContext, paramInt2) * i;
  }
  
  private void a(ViewPager paramViewPager)
  {
    ArrayList localArrayList = new ArrayList();
    LayoutInflater localLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
    int i = 0;
    if (i < this.jdField_c_of_type_Int) {
      for (;;)
      {
        for (;;)
        {
          Object localObject;
          try
          {
            if (Build.VERSION.SDK_INT <= 19) {
              localObject = new GridView(this.jdField_a_of_type_AndroidContentContext);
            }
          }
          catch (Exception localException1)
          {
            localObject = null;
          }
          try
          {
            ((GridView)localObject).setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            ((GridView)localObject).setPadding(0, 0, 0, 0);
            ((GridView)localObject).setSelector(new ColorDrawable(0));
            if (localObject != null)
            {
              ((GridView)localObject).setNumColumns(4);
              GridMenuAdapter.LebaGridAdapter localLebaGridAdapter = new GridMenuAdapter.LebaGridAdapter(this, this.jdField_a_of_type_JavaUtilList, i, this.jdField_d_of_type_Int);
              ((GridView)localObject).setAdapter(localLebaGridAdapter);
              ((GridView)localObject).setColumnWidth(this.jdField_a_of_type_Int);
              localArrayList.add(localObject);
              this.jdField_c_of_type_JavaUtilArrayList.add(localLebaGridAdapter);
            }
            i += 1;
          }
          catch (Exception localException2)
          {
            label171:
            break label171;
          }
        }
        localObject = (GridView)localLayoutInflater.inflate(2130970382, paramViewPager, false);
        continue;
        TroopTechReportUtils.a("leba_gird", "create", localException1.toString(), "", "", "");
      }
    }
    localObject = new GridMenuAdapter.ViewPagerAdapter(this, localArrayList);
    paramViewPager.setAdapter((PagerAdapter)localObject);
    this.jdField_d_of_type_JavaUtilArrayList.add(localObject);
  }
  
  private void a(ViewPager paramViewPager, int paramInt1, int paramInt2)
  {
    int i = paramInt2 - paramInt1;
    if (paramViewPager.getAdapter() != null) {
      if (!(paramViewPager.getAdapter() instanceof GridMenuAdapter.ViewPagerAdapter)) {
        break label395;
      }
    }
    label395:
    for (GridMenuAdapter.ViewPagerAdapter localViewPagerAdapter = (GridMenuAdapter.ViewPagerAdapter)paramViewPager.getAdapter();; localViewPagerAdapter = null)
    {
      if (localViewPagerAdapter == null) {}
      List localList;
      do
      {
        return;
        localList = localViewPagerAdapter.a();
      } while (localList == null);
      GridView localGridView;
      if (i < 0)
      {
        paramInt2 = -i;
        paramInt1 = 0;
        while (paramInt1 < paramInt2)
        {
          if (localList.size() >= 1)
          {
            localGridView = (GridView)localList.get(localList.size() - 1);
            paramViewPager = null;
            if ((localGridView.getAdapter() instanceof GridMenuAdapter.LebaGridAdapter)) {
              paramViewPager = (GridMenuAdapter.LebaGridAdapter)localGridView.getAdapter();
            }
            if (paramViewPager != null) {
              this.jdField_c_of_type_JavaUtilArrayList.remove(paramViewPager);
            }
            localList.remove(localGridView);
          }
          paramInt1 += 1;
        }
      }
      if (i > 0)
      {
        ArrayList localArrayList = new ArrayList();
        LayoutInflater localLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
        paramInt2 = 0;
        if (paramInt2 < i) {
          for (;;)
          {
            for (;;)
            {
              try
              {
                if (Build.VERSION.SDK_INT <= 19) {
                  localGridView = new GridView(this.jdField_a_of_type_AndroidContentContext);
                }
              }
              catch (Exception localException1)
              {
                localGridView = null;
              }
              try
              {
                localGridView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
                localGridView.setPadding(0, 0, 0, 0);
                localGridView.setSelector(new ColorDrawable(0));
                if (localGridView != null)
                {
                  localGridView.setNumColumns(4);
                  GridMenuAdapter.LebaGridAdapter localLebaGridAdapter = new GridMenuAdapter.LebaGridAdapter(this, this.jdField_a_of_type_JavaUtilList, paramInt2 + paramInt1, this.jdField_d_of_type_Int);
                  localGridView.setAdapter(localLebaGridAdapter);
                  localGridView.setColumnWidth(this.jdField_a_of_type_Int);
                  localArrayList.add(localGridView);
                  this.jdField_c_of_type_JavaUtilArrayList.add(localLebaGridAdapter);
                }
                paramInt2 += 1;
              }
              catch (Exception localException2)
              {
                label336:
                break label336;
              }
            }
            localGridView = (GridView)localLayoutInflater.inflate(2130970382, paramViewPager, false);
            continue;
            TroopTechReportUtils.a("leba_gird", "create", localException1.toString(), "", "", "");
          }
        }
        localList.addAll(localArrayList);
      }
      localViewPagerAdapter.notifyDataSetChanged();
      b();
      return;
      this.jdField_c_of_type_JavaUtilArrayList.clear();
      a(paramViewPager);
      return;
    }
  }
  
  public int a(int paramInt1, int paramInt2)
  {
    return (int)Math.ceil(paramInt1 * 1.0D / paramInt2);
  }
  
  protected abstract View a(int paramInt1, View paramView, ViewGroup paramViewGroup, int paramInt2);
  
  public Object a(View paramView, int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilArrayList != null))
    {
      if (paramView == null) {
        break label92;
      }
      paramView = paramView.getParent();
      if (paramView == null) {
        break label97;
      }
    }
    label92:
    label97:
    for (paramView = paramView.getParent();; paramView = null)
    {
      if ((paramView instanceof ViewPager)) {}
      for (paramView = (ViewPager)paramView;; paramView = null)
      {
        if (paramView == null) {}
        do
        {
          return null;
          paramInt = paramView.getCurrentItem() * this.jdField_d_of_type_Int + paramInt;
        } while ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilList.size()));
        return this.jdField_a_of_type_JavaUtilList.get(paramInt);
      }
    }
  }
  
  public void a()
  {
    if (this.f != this.jdField_a_of_type_JavaUtilList.size())
    {
      if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)) {
        return;
      }
      int i = a(this.jdField_a_of_type_JavaUtilList.size(), this.jdField_d_of_type_Int);
      Iterator localIterator;
      if ((i == 1) || (this.jdField_c_of_type_Int == 1) || (this.e == 0))
      {
        this.e = a(this.jdField_a_of_type_JavaUtilList.size(), this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
        if (this.jdField_a_of_type_Boolean)
        {
          localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
          while (localIterator.hasNext()) {
            ((ViewPager)localIterator.next()).setLayoutParams(new LinearLayout.LayoutParams(-1, this.e));
          }
        }
      }
      if (i != this.jdField_c_of_type_Int)
      {
        int j = this.jdField_c_of_type_Int;
        this.jdField_c_of_type_Int = i;
        localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext()) {
          a((ViewPager)localIterator.next(), j, i);
        }
        localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext()) {
          ((LebaGridIndicator)localIterator.next()).setButtons(i);
        }
      }
      b();
    }
    for (;;)
    {
      this.f = this.jdField_a_of_type_JavaUtilList.size();
      return;
      b();
    }
  }
  
  public void a(ViewPager paramViewPager, LebaGridIndicator paramLebaGridIndicator)
  {
    if (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramViewPager))
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramViewPager);
      a(paramViewPager);
      this.jdField_b_of_type_JavaUtilArrayList.add(paramLebaGridIndicator);
      paramLebaGridIndicator.setButtons(this.jdField_c_of_type_Int);
    }
    a();
  }
  
  public boolean a(int paramInt)
  {
    if (this.jdField_d_of_type_Int == 0) {}
    for (;;)
    {
      return false;
      paramInt /= this.jdField_d_of_type_Int;
      Iterator localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        ((LebaGridIndicator)localIterator.next()).setButtonToRedDot(paramInt);
      }
    }
  }
  
  public void b()
  {
    Iterator localIterator = this.jdField_c_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((GridMenuAdapter.LebaGridAdapter)localIterator.next()).notifyDataSetChanged();
    }
    localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      LebaGridIndicator localLebaGridIndicator = (LebaGridIndicator)localIterator.next();
      localLebaGridIndicator.onPageSelected(localLebaGridIndicator.jdField_b_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.leba.header.GridMenuAdapter
 * JD-Core Version:    0.7.0.1
 */