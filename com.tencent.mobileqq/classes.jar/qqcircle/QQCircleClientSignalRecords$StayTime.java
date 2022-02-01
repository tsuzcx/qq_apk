package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;

public final class QQCircleClientSignalRecords$StayTime
  extends MessageMicro<StayTime>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "todayTotalStayTime", "lastSyncStayTime" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L) }, StayTime.class);
  public final PBInt64Field lastSyncStayTime = PBField.initInt64(0L);
  public final PBInt64Field todayTotalStayTime = PBField.initInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qqcircle.QQCircleClientSignalRecords.StayTime
 * JD-Core Version:    0.7.0.1
 */