package com.tencent.mobileqq.troop.api;

import android.content.Intent;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={""})
public abstract interface ILaunchTroopSysMsgUIUtilApi
  extends QRouteApi
{
  public static final int FROM_MSG_LIST = 2;
  public static final int FROM_SEARCH = 1;
  public static final String KEY_FROM = "key_from";
  public static final String KEY_HAS_RED = "has_red";
  public static final String KEY_MODE = "_key_mode";
  public static final String KEY_SHOW_MODE = "show_mode";
  public static final String KEY_SHOW_TYPE = "show_type";
  public static final String KEY_TAB_MODE = "key_tab_mode";
  public static final int MODE_NOTIFICATION = 1;
  public static final int MODE_RECOMMEND = 0;
  public static final int MODE_TAB_ALL = 0;
  public static final int MODE_TAB_NOTIFICATION_AND_RECOMEND = 2;
  public static final int MODE_TROOP = 0;
  public static final String SP_NAME = "nearby_troop_count";
  
  public abstract String getFragmentNameForLaunch();
  
  public abstract void launchTroopNotificationFragment(Intent paramIntent);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.ILaunchTroopSysMsgUIUtilApi
 * JD-Core Version:    0.7.0.1
 */