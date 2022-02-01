package com.tencent.mobileqq.mini.entry;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton.OnCheckedChangeListener;
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
    ArrayList localArrayList = this.mData;
    if (localArrayList != null) {
      return localArrayList.size();
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
    Object localObject = this.mData;
    if ((localObject != null) && (paramInt < ((ArrayList)localObject).size()))
    {
      localObject = (MiniAppSettingSwitchInfoEntity)this.mData.get(paramInt);
      if (localObject != null)
      {
        if (TextUtils.isEmpty(((MiniAppSettingSwitchInfoEntity)localObject).subTitle)) {
          return 0;
        }
        return 1;
      }
    }
    return -1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    MiniAppSettingSwitchInfoEntity localMiniAppSettingSwitchInfoEntity = (MiniAppSettingSwitchInfoEntity)this.mData.get(paramInt);
    if (paramView == null)
    {
      paramViewGroup = LayoutInflater.from(this.mContext).inflate(2131628802, null);
      paramView = new MiniAppEntrySettingFragment.SettingListViewAdapter.Holder(this);
      paramView.singleLineSwitchItem = ((FormSwitchItem)paramViewGroup.findViewById(2131438742));
      paramView.multiLineSwitchItem = ((FormMultiLineSwitchItem)paramViewGroup.findViewById(2131438741));
      paramViewGroup.setTag(paramView);
    }
    else
    {
      localObject = (MiniAppEntrySettingFragment.SettingListViewAdapter.Holder)paramView.getTag();
      paramViewGroup = paramView;
      paramView = (View)localObject;
    }
    paramInt = getItemViewType(paramInt);
    boolean bool1 = false;
    boolean bool2 = true;
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return paramViewGroup;
      }
      paramView.singleLineSwitchItem.setVisibility(8);
      paramView.multiLineSwitchItem.setText(localMiniAppSettingSwitchInfoEntity.title);
      paramView.multiLineSwitchItem.setSecendLineText(localMiniAppSettingSwitchInfoEntity.subTitle);
      localObject = paramView.multiLineSwitchItem;
      if (localMiniAppSettingSwitchInfoEntity.value == 1) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
      ((FormMultiLineSwitchItem)localObject).setChecked(bool1);
      paramView.multiLineSwitchItem.setOnCheckedChangeListener(getOnCheckedChangeListener(localMiniAppSettingSwitchInfoEntity));
      paramView.multiLineSwitchItem.setVisibility(0);
      return paramViewGroup;
    }
    paramView.singleLineSwitchItem.setVisibility(0);
    paramView.singleLineSwitchItem.setText(localMiniAppSettingSwitchInfoEntity.title);
    Object localObject = paramView.singleLineSwitchItem;
    if (localMiniAppSettingSwitchInfoEntity.value == 1) {
      bool1 = true;
    }
    ((FormSwitchItem)localObject).setChecked(bool1);
    paramView.singleLineSwitchItem.setOnCheckedChangeListener(getOnCheckedChangeListener(localMiniAppSettingSwitchInfoEntity));
    paramView.multiLineSwitchItem.setVisibility(8);
    return paramViewGroup;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppEntrySettingFragment.SettingListViewAdapter
 * JD-Core Version:    0.7.0.1
 */