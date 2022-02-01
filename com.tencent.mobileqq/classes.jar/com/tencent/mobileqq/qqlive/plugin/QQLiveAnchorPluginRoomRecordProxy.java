package com.tencent.mobileqq.qqlive.plugin;

import com.tencent.mobileqq.qqlive.data.record.QQLiveCurRoomInfo;
import com.tencent.mobileqq.qqlive.record.QQLiveRoomRecordManagerProxy;

public class QQLiveAnchorPluginRoomRecordProxy
{
  public static QQLiveCurRoomInfo getCurRoomInfo()
  {
    return QQLiveRoomRecordManagerProxy.a("1037");
  }
  
  public static void recordCurRoomInfo(QQLiveCurRoomInfo paramQQLiveCurRoomInfo)
  {
    QQLiveRoomRecordManagerProxy.a("1037", paramQQLiveCurRoomInfo);
  }
  
  public static void removeCurRoomInfo(long paramLong)
  {
    QQLiveRoomRecordManagerProxy.a("1037", paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.plugin.QQLiveAnchorPluginRoomRecordProxy
 * JD-Core Version:    0.7.0.1
 */