package com.tencent.mobileqq.profile.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ToggleButton;
import com.tencent.mobileqq.profilecard.entity.ProfileLabelInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class ProfileLabelPanelAdapter$AllLabelGridViewAdapter
  extends BaseAdapter
{
  List<ProfileLabelInfo> jdField_a_of_type_JavaUtilList;
  
  private ProfileLabelPanelAdapter$AllLabelGridViewAdapter(ProfileLabelPanelAdapter paramProfileLabelPanelAdapter) {}
  
  public void a(List<ProfileLabelInfo> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
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
    Object localObject1;
    if (paramView == null)
    {
      localObject1 = new ToggleButton(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileLabelPanelAdapter.jdField_a_of_type_AndroidContentContext);
      ((View)localObject1).setLayoutParams(new AbsListView.LayoutParams(-1, (int)(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileLabelPanelAdapter.jdField_a_of_type_Float * 28.0F)));
      ((View)localObject1).setBackgroundResource(2130850924);
      paramView = (ToggleButton)localObject1;
      paramView.setGravity(17);
      paramView.setTextSize(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileLabelPanelAdapter.jdField_a_of_type_AndroidContentContext.getResources().getInteger(2131427338));
      paramView.setTextColor(Color.parseColor("#777777"));
      paramView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileLabelPanelAdapter);
    }
    else
    {
      localObject2 = (ToggleButton)paramView;
      localObject1 = paramView;
      paramView = (View)localObject2;
    }
    Object localObject2 = (ProfileLabelInfo)getItem(paramInt);
    if (localObject2 != null)
    {
      paramView.setTag(localObject2);
      boolean bool;
      if (((ProfileLabelInfo)localObject2).labelStatus == ProfileLabelInfo.STATUS_CHECKED) {
        bool = true;
      } else {
        bool = false;
      }
      paramView.setChecked(bool);
      paramView.setText(((ProfileLabelInfo)localObject2).labelName);
      paramView.setTextOn(((ProfileLabelInfo)localObject2).labelName);
      paramView.setTextOff(((ProfileLabelInfo)localObject2).labelName);
      if (((ProfileLabelInfo)localObject2).labelStatus == ProfileLabelInfo.STATUS_CHECKED) {
        this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileLabelPanelAdapter.jdField_a_of_type_ComTencentMobileqqProfileViewProfileLabelPanel$LabelStatusManager.a((ProfileLabelInfo)localObject2, paramView);
      }
    }
    else
    {
      paramView.setVisibility(8);
    }
    EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.ProfileLabelPanelAdapter.AllLabelGridViewAdapter
 * JD-Core Version:    0.7.0.1
 */