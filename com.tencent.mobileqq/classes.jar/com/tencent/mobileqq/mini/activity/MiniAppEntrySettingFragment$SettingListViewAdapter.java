package com.tencent.mobileqq.mini.activity;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.mini.entry.MiniAppSettingSwitchInfoEntity;
import com.tencent.mobileqq.widget.FormMultiLineSwitchItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class MiniAppEntrySettingFragment$SettingListViewAdapter
  extends BaseAdapter
{
  private final int TYPE_ERROR = -1;
  private final int TYPE_MUULTI_LINE = 1;
  private final int TYPE_SINGLE_LINE = 0;
  private Context mContext;
  private ArrayList<MiniAppSettingSwitchInfoEntity> mData;
  
  public MiniAppEntrySettingFragment$SettingListViewAdapter(MiniAppEntrySettingFragment paramMiniAppEntrySettingFragment, Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private CompoundButton.OnCheckedChangeListener getOnCheckedChangeListener(MiniAppSettingSwitchInfoEntity paramMiniAppSettingSwitchInfoEntity)
  {
    return new MiniAppEntrySettingFragment.SettingListViewAdapter.1(this, paramMiniAppSettingSwitchInfoEntity);
  }
  
  public int getCount()
  {
    if (this.mData != null) {
      return this.mData.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((this.mData != null) && (paramInt < this.mData.size()))
    {
      MiniAppSettingSwitchInfoEntity localMiniAppSettingSwitchInfoEntity = (MiniAppSettingSwitchInfoEntity)this.mData.get(paramInt);
      if (localMiniAppSettingSwitchInfoEntity != null)
      {
        if (TextUtils.isEmpty(localMiniAppSettingSwitchInfoEntity.subTitle)) {
          return 0;
        }
        return 1;
      }
    }
    return -1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    MiniAppSettingSwitchInfoEntity localMiniAppSettingSwitchInfoEntity = (MiniAppSettingSwitchInfoEntity)this.mData.get(paramInt);
    View localView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.mContext).inflate(2131562453, null);
      paramView = new MiniAppEntrySettingFragment.SettingListViewAdapter.Holder(this);
      paramView.singleLineSwitchItem = ((FormSwitchItem)localView.findViewById(2131371305));
      paramView.multiLineSwitchItem = ((FormMultiLineSwitchItem)localView.findViewById(2131371304));
      localView.setTag(paramView);
    }
    for (;;)
    {
      switch (getItemViewType(paramInt))
      {
      default: 
        EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
        return localView;
        localObject = (MiniAppEntrySettingFragment.SettingListViewAdapter.Holder)paramView.getTag();
        localView = paramView;
        paramView = (View)localObject;
      }
    }
    paramView.singleLineSwitchItem.setVisibility(0);
    paramView.singleLineSwitchItem.setText(localMiniAppSettingSwitchInfoEntity.title);
    Object localObject = paramView.singleLineSwitchItem;
    if (localMiniAppSettingSwitchInfoEntity.value == 1) {}
    for (;;)
    {
      ((FormSwitchItem)localObject).setChecked(bool1);
      paramView.singleLineSwitchItem.setOnCheckedChangeListener(getOnCheckedChangeListener(localMiniAppSettingSwitchInfoEntity));
      paramView.multiLineSwitchItem.setVisibility(8);
      break;
      bool1 = false;
    }
    paramView.singleLineSwitchItem.setVisibility(8);
    paramView.multiLineSwitchItem.setText(localMiniAppSettingSwitchInfoEntity.title);
    paramView.multiLineSwitchItem.setSecendLineText(localMiniAppSettingSwitchInfoEntity.subTitle);
    localObject = paramView.multiLineSwitchItem;
    if (localMiniAppSettingSwitchInfoEntity.value == 1) {}
    for (bool1 = bool2;; bool1 = false)
    {
      ((FormMultiLineSwitchItem)localObject).setChecked(bool1);
      paramView.multiLineSwitchItem.setOnCheckedChangeListener(getOnCheckedChangeListener(localMiniAppSettingSwitchInfoEntity));
      paramView.multiLineSwitchItem.setVisibility(0);
      break;
    }
  }
  
  public void setData(ArrayList<MiniAppSettingSwitchInfoEntity> paramArrayList)
  {
    if (paramArrayList == null) {
      return;
    }
    this.mData = paramArrayList;
    notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.activity.MiniAppEntrySettingFragment.SettingListViewAdapter
 * JD-Core Version:    0.7.0.1
 */