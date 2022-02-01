package com.tencent.mobileqq.qqlive.api.room.impl;

import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.room.IAudienceRoom;
import com.tencent.mobileqq.qqlive.api.room.IQQLiveAudienceRoomReportHelper;
import com.tencent.mobileqq.qqlive.data.QQLiveAudienceDtReportData;
import com.tencent.mobileqq.qqlive.room.QQLiveAudienceRoomReportHelper;
import java.util.HashMap;

public class QQLiveAudienceRoomReportHelperImpl
  implements IQQLiveAudienceRoomReportHelper
{
  public void doQQLiveReportEvent(String paramString, HashMap<String, String> paramHashMap, IAudienceRoom paramIAudienceRoom, IQQLiveSDK paramIQQLiveSDK, QQLiveAudienceDtReportData paramQQLiveAudienceDtReportData)
  {
    QQLiveAudienceRoomReportHelper.a(paramString, paramHashMap, paramIAudienceRoom, paramIQQLiveSDK, paramQQLiveAudienceDtReportData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.room.impl.QQLiveAudienceRoomReportHelperImpl
 * JD-Core Version:    0.7.0.1
 */