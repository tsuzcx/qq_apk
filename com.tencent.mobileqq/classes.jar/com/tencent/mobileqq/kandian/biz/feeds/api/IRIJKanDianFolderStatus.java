package com.tencent.mobileqq.kandian.biz.feeds.api;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.kandian.biz.feeds.entity.RedPntInfoForReport;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IRIJKanDianFolderStatus
  extends QRouteApi
{
  public static final int REPORT_FLODER_STATUS_INTEREST_RED_POINT = 4;
  public static final int REPORT_FLODER_STATUS_KANDIAN_RED_POINT = 3;
  public static final int REPORT_FLODER_STATUS_NULL_RED_POINT = 1;
  public static final int REPORT_FLODER_STATUS_SUBSCRIPT_RED_POINT = 2;
  public static final int REPORT_FOLDER_STATUS_APP_IN_PUSH = 10;
  public static final int REPORT_FOLDER_STATUS_FROM_LEBA = 7;
  public static final int REPORT_FOLDER_STATUS_FROM_OTHER = 9;
  public static final int REPORT_FOLDER_STATUS_FROM_SEARCH = 8;
  public static final int REPORT_FOLDER_STATUS_INDIVIDUAL_RED_POINT = 5;
  public static final int REPORT_FOLDER_STATUS_MESSAGE_RED_POINT = 6;
  
  public abstract RedPntInfoForReport getRedPntInfoForReport();
  
  public abstract int getReportFolderStatus();
  
  public abstract void setReportLastRedPntPosition(int paramInt);
  
  public abstract void updateKandianFolderStatus(BaseQQAppInterface paramBaseQQAppInterface, MessageRecord paramMessageRecord);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.api.IRIJKanDianFolderStatus
 * JD-Core Version:    0.7.0.1
 */