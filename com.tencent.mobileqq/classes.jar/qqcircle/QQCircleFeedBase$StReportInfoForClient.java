package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class QQCircleFeedBase$StReportInfoForClient
  extends MessageMicro<StReportInfoForClient>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "feedtype1", "feedtype2", "feedtype3" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, StReportInfoForClient.class);
  public final PBUInt32Field feedtype1 = PBField.initUInt32(0);
  public final PBUInt32Field feedtype2 = PBField.initUInt32(0);
  public final PBUInt32Field feedtype3 = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     qqcircle.QQCircleFeedBase.StReportInfoForClient
 * JD-Core Version:    0.7.0.1
 */