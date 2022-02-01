package com.tencent.mobileqq.leba.business.impl;

import com.tencent.biz.now.NowLiveManager;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.leba.business.ILebaSettingChangeBiz;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class LebaPluginSettingChange
  implements ILebaSettingChangeBiz
{
  public void a(String paramString, boolean paramBoolean, long paramLong)
  {
    try
    {
      paramLong = Long.parseLong(paramString);
    }
    catch (Exception paramString)
    {
      QLog.e("LebaPluginSettingChange", 1, paramString, new Object[0]);
      paramLong = 0L;
    }
    if (paramLong == 886L)
    {
      if (paramBoolean)
      {
        ReportController.b(null, "dc00899", "Grp_nearby", "", "dyn_set", "open_nearby", 0, 0, "", "", "", "");
        return;
      }
      ReportController.b(null, "dc00899", "Grp_nearby", "", "dyn_set", "close_nearby", 0, 0, "", "", "", "");
      return;
    }
    if (paramLong == NowLiveManager.a)
    {
      if (paramBoolean)
      {
        StoryReportor.a("dynamic_more", "entry_switch_on", 0, 0, new String[] { "", "", "", "" });
        return;
      }
      StoryReportor.a("dynamic_more", "entry_switch_off", 0, 0, new String[] { "", "", "", "" });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.leba.business.impl.LebaPluginSettingChange
 * JD-Core Version:    0.7.0.1
 */