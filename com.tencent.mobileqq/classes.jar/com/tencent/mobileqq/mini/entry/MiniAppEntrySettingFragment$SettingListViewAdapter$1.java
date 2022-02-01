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
    int i = 1;
    paramCompoundButton = this.val$miniAppSwitchInfo.key;
    Object localObject = this.val$miniAppSwitchInfo.title;
    String str = this.val$miniAppSwitchInfo.subTitle;
    if (this.val$miniAppSwitchInfo.value == 1) {
      i = 0;
    }
    localObject = new MiniAppSettingSwitchInfoEntity(paramCompoundButton, (String)localObject, str, i);
    MiniAppCmdUtil.getInstance().setUserSwitch(null, ((MiniAppSettingSwitchInfoEntity)localObject).key, ((MiniAppSettingSwitchInfoEntity)localObject).value, new MiniAppEntrySettingFragment.SettingListViewAdapter.1.1(this, (MiniAppSettingSwitchInfoEntity)localObject));
    if (paramBoolean) {}
    for (paramCompoundButton = "set_on";; paramCompoundButton = "set_off")
    {
      MiniProgramLpReportDC04239.reportAsync("desktop", "set", paramCompoundButton, ((MiniAppSettingSwitchInfoEntity)localObject).key);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppEntrySettingFragment.SettingListViewAdapter.1
 * JD-Core Version:    0.7.0.1
 */