package com.tencent.mobileqq.studyroom.ui;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.os.Process;
import android.support.v4.app.FragmentActivity;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.studyroom.utils.StudyRoomUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Iterator;
import java.util.List;

class StudyRoomDebugSettingFragment$1
  implements CompoundButton.OnCheckedChangeListener
{
  StudyRoomDebugSettingFragment$1(StudyRoomDebugSettingFragment paramStudyRoomDebugSettingFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool;
    if (!StudyRoomUtils.a(paramBoolean))
    {
      paramCompoundButton.setOnCheckedChangeListener(null);
      if (!paramBoolean)
      {
        bool = true;
        paramCompoundButton.setChecked(bool);
        paramCompoundButton.setOnCheckedChangeListener(this);
        label27:
        break label67;
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      bool = false;
      break;
      Iterator localIterator = ((ActivityManager)this.a.getActivity().getSystemService("activity")).getRunningAppProcesses().iterator();
      label67:
      if (localIterator.hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)localIterator.next();
        if (!localRunningAppProcessInfo.processName.equals("com.tencent.mobileqq:live")) {
          break label27;
        }
        Process.killProcess(localRunningAppProcessInfo.pid);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.studyroom.ui.StudyRoomDebugSettingFragment.1
 * JD-Core Version:    0.7.0.1
 */