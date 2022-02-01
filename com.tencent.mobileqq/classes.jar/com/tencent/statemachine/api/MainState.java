package com.tencent.statemachine.api;

import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface MainState
{
  public static final String MAIN_STATE_ACTIVITY_HIDE = "main_activity_hide";
  public static final String MAIN_STATE_CONTACTS_TAB_SHOW = "main_contacts_tab_show";
  public static final String MAIN_STATE_DRAWER_TAB_SHOW = "main_drawer_tab_show";
  public static final String MAIN_STATE_DYNAMIC_TAB_SHOW = "main_dynamic_tab_show";
  public static final String MAIN_STATE_KANDIAN_TAB_SHOW = "main_kandian_tab_show";
  public static final String MAIN_STATE_MESSAGE_TAB_SHOW = "main_message_tab_show";
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.statemachine.api.MainState
 * JD-Core Version:    0.7.0.1
 */