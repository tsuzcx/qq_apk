package com.tencent.mobileqq.troop.api.impl;

import android.content.Intent;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicFragmentActivity.Launcher;
import com.tencent.mobileqq.troop.api.ILaunchTroopSysMsgUIUtilApi;
import com.tencent.mobileqq.troop.troopnotification.TroopNotificationFragment;

public class LaunchTroopSysMsgUIUtilApiImpl
  implements ILaunchTroopSysMsgUIUtilApi
{
  public String getFragmentNameForLaunch()
  {
    return TroopNotificationFragment.class.getName();
  }
  
  public void launchTroopNotificationFragment(Intent paramIntent)
  {
    QPublicFragmentActivity.Launcher.a(paramIntent, QPublicFragmentActivity.class, TroopNotificationFragment.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.impl.LaunchTroopSysMsgUIUtilApiImpl
 * JD-Core Version:    0.7.0.1
 */