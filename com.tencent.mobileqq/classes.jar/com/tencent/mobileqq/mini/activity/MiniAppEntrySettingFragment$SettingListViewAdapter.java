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
    boolean bool = true;
    MiniAppSettingSwitchInfoEntity localMiniAppSettingSwitchInfoEntity = (MiniAppSettingSwitchInfoEntity)this.mData.get(paramInt);
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.mContext).inflate(2131562159, null);
      paramViewGroup = new MiniAppEntrySettingFragment.SettingListViewAdapter.Holder(this);
      paramViewGroup.singleLineSwitchItem = ((FormSwitchItem)paramView.findViewById(2131370625));
      paramViewGroup.multiLineSwitchItem = ((FormMultiLineSwitchItem)paramView.findViewById(2131370624));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      switch (getItemViewType(paramInt))
      {
      default: 
        return paramView;
        paramViewGroup = (MiniAppEntrySettingFragment.SettingListViewAdapter.Holder)paramView.getTag();
      }
    }
    paramViewGroup.singleLineSwitchItem.setVisibility(0);
    paramViewGroup.singleLineSwitchItem.setText(localMiniAppSettingSwitchInfoEntity.title);
    Object localObject = paramViewGroup.singleLineSwitchItem;
    if (localMiniAppSettingSwitchInfoEntity.value == 1) {}
    for (bool = true;; bool = false)
    {
      ((FormSwitchItem)localObject).setChecked(bool);
      paramViewGroup.singleLineSwitchItem.setOnCheckedChangeListener(getOnCheckedChangeListener(localMiniAppSettingSwitchInfoEntity));
      paramViewGroup.multiLineSwitchItem.setVisibility(8);
      return paramView;
    }
    paramViewGroup.singleLineSwitchItem.setVisibility(8);
    paramViewGroup.multiLineSwitchItem.setText(localMiniAppSettingSwitchInfoEntity.title);
    paramViewGroup.multiLineSwitchItem.setSecendLineText(localMiniAppSettingSwitchInfoEntity.subTitle);
    localObject = paramViewGroup.multiLineSwitchItem;
    if (localMiniAppSettingSwitchInfoEntity.value == 1) {}
    for (;;)
    {
      ((FormMultiLineSwitchItem)localObject).setChecked(bool);
      paramViewGroup.multiLineSwitchItem.setOnCheckedChangeListener(getOnCheckedChangeListener(localMiniAppSettingSwitchInfoEntity));
      paramViewGroup.multiLineSwitchItem.setVisibility(0);
      return paramView;
      bool = false;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.activity.MiniAppEntrySettingFragment.SettingListViewAdapter
 * JD-Core Version:    0.7.0.1
 */