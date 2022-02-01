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
  List<ProfileLabelInfo> a;
  
  private ProfileLabelPanelAdapter$AllLabelGridViewAdapter(ProfileLabelPanelAdapter paramProfileLabelPanelAdapter) {}
  
  public void a(List<ProfileLabelInfo> paramList)
  {
    this.a = paramList;
  }
  
  public int getCount()
  {
    return this.a.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.a.get(paramInt);
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
      localObject1 = new ToggleButton(this.b.c);
      ((View)localObject1).setLayoutParams(new AbsListView.LayoutParams(-1, (int)(this.b.e * 28.0F)));
      ((View)localObject1).setBackgroundResource(2130852776);
      paramView = (ToggleButton)localObject1;
      paramView.setGravity(17);
      paramView.setTextSize(this.b.c.getResources().getInteger(2131492881));
      paramView.setTextColor(Color.parseColor("#777777"));
      paramView.setOnClickListener(this.b);
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
        this.b.i.a((ProfileLabelInfo)localObject2, paramView);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.ProfileLabelPanelAdapter.AllLabelGridViewAdapter
 * JD-Core Version:    0.7.0.1
 */