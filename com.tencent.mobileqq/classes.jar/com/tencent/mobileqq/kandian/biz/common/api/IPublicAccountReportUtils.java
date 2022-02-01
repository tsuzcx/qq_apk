package com.tencent.mobileqq.kandian.biz.common.api;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.kandian.base.annotation.IgnoreDenyDependencyToSelf;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.List;

@QAPI(process={"all"})
@IgnoreDenyDependencyToSelf
public abstract interface IPublicAccountReportUtils
  extends QRouteApi
{
  public static final String VIDEO_REPORT_ACTION_NAME = "VIDEO_REPORT_ACTION_NAME";
  public static final String VIDEO_REPORT_FROM_TYPE = "VIDEO_REPORT_FROM_TYPE";
  public static final String VIDEO_REPORT_R2 = "VIDEO_REPORT_R2";
  public static final String VIDEO_REPORT_R3 = "VIDEO_REPORT_R3";
  public static final String VIDEO_REPORT_R4 = "VIDEO_REPORT_R4";
  public static final String VIDEO_REPORT_R5 = "VIDEO_REPORT_R5";
  public static final String VIDEO_REPORT_RESULT = "VIDEO_REPORT_RESULT";
  public static final String VIDEO_REPORT_SHOULD_ENCODE = "VIDEO_REPORT_SHOULD_ENCODE";
  public static final String VIDEO_REPORT_SUBACTION = "VIDEO_REPORT_SUBACTION";
  public static final String VIDEO_REPORT_TOUIN = "VIDEO_REPORT_TOUIN";
  
  public abstract String changeToUTF8(String paramString);
  
  public abstract void doVideoDataReportWithFansInfoInR5(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, String paramString5, String paramString6, String paramString7, boolean paramBoolean);
  
  public abstract void publicAccountReportClickEvent(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, String paramString5, String paramString6, String paramString7);
  
  public abstract void publicAccountReportClickEvent(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, String paramString5, String paramString6, String paramString7, boolean paramBoolean);
  
  public abstract void publicAccountReportClickEventForMigrate(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, String paramString6, String paramString7, String paramString8, String paramString9);
  
  public abstract void publicAccountReportClickEventForMigrate(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, String paramString6, String paramString7, String paramString8, String paramString9, boolean paramBoolean);
  
  public abstract void publicAccountSimpleReportWithR5(String paramString1, int paramInt, String paramString2);
  
  public abstract void publicAccountSimpleReportWithR5(String paramString1, String paramString2);
  
  public abstract void reportFollowEvent(AppInterface paramAppInterface, String paramString, int paramInt);
  
  public abstract void reportLabelsClick(Entity paramEntity);
  
  public abstract void reportPAinfoToLighthouse(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6);
  
  public abstract void reportPubAccMsg(List<MessageRecord> paramList);
  
  public abstract void videoDataReportWithFansInfoInR5(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, String paramString5, String paramString6, String paramString7, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils
 * JD-Core Version:    0.7.0.1
 */