package com.tencent.qqperf.monitor.dropframe.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IDropFrameMonitor
  extends QRouteApi
{
  public static final String QCIRCLE_ALL_PUSH_TAB_PAGE = "qcircle_all_push_tab_page";
  public static final String QCIRCLE_CHAT_LIST = "qcircle_chat_list";
  public static final String QCIRCLE_COMMENT_PAGE = "qcircle_comment_page";
  public static final String QCIRCLE_CONTENT_PAGE = "qcircle_content_page";
  public static final String QCIRCLE_FOLLOW_TAB_PAGE = "qcircle_follow_tab_page";
  public static final String QCIRCLE_FOLLOW_TAG_LIST = "qcircle_follow_tag_list";
  public static final String QCIRCLE_FOLLOW_USER_LIST = "qcircle_follow_user_list";
  public static final String QCIRCLE_MESSAGE_NOTICE = "qcircle_message_notice_page";
  public static final String QCIRCLE_PERSONAL_DETAIL_PAGE = "qcircle_personal_detail_page";
  public static final String QCIRCLE_POLYMERIZATION_PAGE = "qcircle_polymerization_page";
  public static final String QCIRCLE_SPECIAL_FOLLOW_LIST = "qcircle_special_follow_list";
  public static final String QCIRCLE_TAG_PAGE = "qcircle_tag_page";
  public static final String QCIRLE_BLACK_LIST_PAGE = "qcircle_black_list";
  public static final String QCIRLE_LIKE_LIST_PAGE = "qcircle_like_page";
  
  public abstract void startMonitorScene(String paramString);
  
  public abstract void stopMonitorScene(String paramString, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqperf.monitor.dropframe.api.IDropFrameMonitor
 * JD-Core Version:    0.7.0.1
 */