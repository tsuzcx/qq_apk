package com.tencent.mobileqq.mini.entry;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;

class MiniAppEntrySettingFragment$SettingListViewAdapter$1
  implements CompoundButton.OnCheckedChangeListener
{
  MiniAppEntrySettingFragment$SettingListViewAdapter$1(MiniAppEntrySettingFragment.SettingListViewAdapter paramSettingListViewAdapter, MiniAppSettingSwitchInfoEntity paramMiniAppSettingSwitchInfoEntity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    paramCompoundButton = this.val$miniAppSwitchInfo.key;
    Object localObject = this.val$miniAppSwitchInfo.title;
    String str = this.val$miniAppSwitchInfo.subTitle;
    int j = this.val$miniAppSwitchInfo.value;
    int i = 1;
    if (j == 1) {
      i = 0;
    }
    localObject = new MiniAppSettingSwitchInfoEntity(paramCompoundButton, (String)localObject, str, i);
    MiniAppCmdUtil.getInstance().setUserSwitch(null, ((MiniAppSettingSwitchInfoEntity)localObject).key, ((MiniAppSettingSwitchInfoEntity)localObject).value, new MiniAppEntrySettingFragment.SettingListViewAdapter.1.1(this, (MiniAppSettingSwitchInfoEntity)localObject));
    if (paramBoolean) {
      paramCompoundButton = "set_on";
    } else {
      paramCompoundButton = "set_off";
    }
    MiniProgramLpReportDC04239.reportAsync("desktop", "set", paramCompoundButton, ((MiniAppSettingSwitchInfoEntity)localObject).key);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppEntrySettingFragment.SettingListViewAdapter.1
 * JD-Core Version:    0.7.0.1
 */