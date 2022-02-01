package com.tencent.mobileqq.hotpic;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

class HotPicTab$HotPicTabAdapter
  extends BaseAdapter
{
  ArrayList<Integer> jdField_a_of_type_JavaUtilArrayList;
  List<HotPicTagInfo> jdField_a_of_type_JavaUtilList;
  boolean jdField_a_of_type_Boolean;
  
  public HotPicTab$HotPicTabAdapter(List<HotPicTagInfo> paramList, ArrayList<Integer> paramArrayList, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilList = paramArrayList;
    this.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)paramBoolean.clone());
    boolean bool;
    this.jdField_a_of_type_Boolean = bool;
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    if (paramView == null)
    {
      localObject = new HotPicTab.ViewHolder(this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTab);
      paramView = LayoutInflater.from(HotPicTab.a(this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTab)).inflate(2131558655, null);
      ((HotPicTab.ViewHolder)localObject).a = ((TextView)paramView.findViewById(2131368545));
      paramView.setTag(localObject);
    }
    for (;;)
    {
      String str = ((HotPicTagInfo)getItem(paramInt)).tagName;
      localObject = ((HotPicTab.ViewHolder)localObject).a;
      ((TextView)localObject).setText(str);
      ((TextView)localObject).setTextSize(2, HotPicTab.b());
      ((TextView)localObject).setTextColor(HotPicTab.c());
      ((TextView)localObject).setPadding(0, 0, 0, 0);
      ((TextView)localObject).setFocusable(true);
      ((TextView)localObject).setGravity(17);
      paramView.setLayoutParams(new RelativeLayout.LayoutParams(((Integer)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).intValue(), -1));
      paramView.setContentDescription(str);
      paramView.setFocusable(true);
      paramView.setOnHoverListener(new HotPicTab.HotPicTabAdapter.1(this));
      if (!HotPicTab.a(this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTab).contains(Integer.valueOf(paramInt)))
      {
        ReportController.b(null, "dc00898", "", "", "0X8008077", "0X8008077", 0, 0, paramInt + "", "", str, "");
        HotPicTab.a(this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTab).add(Integer.valueOf(paramInt));
      }
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      localObject = (HotPicTab.ViewHolder)paramView.getTag();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.HotPicTab.HotPicTabAdapter
 * JD-Core Version:    0.7.0.1
 */