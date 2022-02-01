package com.tencent.mobileqq.mini.activity;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.mini.entry.MiniAppSettingSwitchInfoEntity;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class MiniAppEntrySettingFragment$SettingListViewAdapter$1
  implements CompoundButton.OnCheckedChangeListener
{
  MiniAppEntrySettingFragment$SettingListViewAdapter$1(MiniAppEntrySettingFragment.SettingListViewAdapter paramSettingListViewAdapter, MiniAppSettingSwitchInfoEntity paramMiniAppSettingSwitchInfoEntity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int i = 1;
    String str1 = this.val$miniAppSwitchInfo.key;
    Object localObject = this.val$miniAppSwitchInfo.title;
    String str2 = this.val$miniAppSwitchInfo.subTitle;
    if (this.val$miniAppSwitchInfo.value == 1) {
      i = 0;
    }
    localObject = new MiniAppSettingSwitchInfoEntity(str1, (String)localObject, str2, i);
    MiniAppCmdUtil.getInstance().setUserSwitch(null, ((MiniAppSettingSwitchInfoEntity)localObject).key, ((MiniAppSettingSwitchInfoEntity)localObject).value, new MiniAppEntrySettingFragment.SettingListViewAdapter.1.1(this, (MiniAppSettingSwitchInfoEntity)localObject));
    if (paramBoolean) {}
    for (str1 = "set_on";; str1 = "set_off")
    {
      MiniProgramLpReportDC04239.reportAsync("desktop", "set", str1, ((MiniAppSettingSwitchInfoEntity)localObject).key);
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.activity.MiniAppEntrySettingFragment.SettingListViewAdapter.1
 * JD-Core Version:    0.7.0.1
 */