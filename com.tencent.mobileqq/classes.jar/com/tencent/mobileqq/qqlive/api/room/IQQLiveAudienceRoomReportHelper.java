package com.tencent.mobileqq.qqlive.api.room;

import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.data.QQLiveAudienceDtReportData;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.HashMap;

@QAPI(process={"all"})
public abstract interface IQQLiveAudienceRoomReportHelper
  extends QRouteApi
{
  public static final String EXTRA_KEY_GAME_TAG_ID = "gameTagId";
  public static final String EXTRA_KEY_ROOM_TYPE = "roomType";
  public static final String EXTRA_KEY_SOURCE = "source";
  public static final String EXTRA_KEY_TRACE_INFO = "traceInfo";
  public static final String EXTRA_KEY_VIDEO_SOURCE = "videoSource";
  public static final int VALUE_ZHI_BO_TYPE_GAME = 0;
  public static final int VALUE_ZHI_BO_TYPE_VIDEO = 1;
  
  public abstract void doQQLiveReportEvent(String paramString, HashMap<String, String> paramHashMap, IAudienceRoom paramIAudienceRoom, IQQLiveSDK paramIQQLiveSDK, QQLiveAudienceDtReportData paramQQLiveAudienceDtReportData);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.room.IQQLiveAudienceRoomReportHelper
 * JD-Core Version:    0.7.0.1
 */