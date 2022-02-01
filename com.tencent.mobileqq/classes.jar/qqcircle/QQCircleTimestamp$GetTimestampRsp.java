package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;

public final class QQCircleTimestamp$GetTimestampRsp
  extends MessageMicro<GetTimestampRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "timestamp" }, new Object[] { Long.valueOf(0L) }, GetTimestampRsp.class);
  public final PBInt64Field timestamp = PBField.initInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qqcircle.QQCircleTimestamp.GetTimestampRsp
 * JD-Core Version:    0.7.0.1
 */