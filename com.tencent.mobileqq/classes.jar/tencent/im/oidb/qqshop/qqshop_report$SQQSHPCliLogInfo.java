package tencent.im.oidb.qqshop;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqshop_report$SQQSHPCliLogInfo
  extends MessageMicro<SQQSHPCliLogInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 50, 58, 66, 72, 80, 88, 96, 106, 114 }, new String[] { "puin", "tvalue", "cnt", "network", "strp1", "strp2", "strp3", "strp4", "uintp1", "uintp2", "uintp3", "uintp4", "wifimac", "ifda" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", "", "", "", Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), "", "" }, SQQSHPCliLogInfo.class);
  public final PBUInt32Field cnt = PBField.initUInt32(0);
  public final PBStringField ifda = PBField.initString("");
  public final PBUInt32Field network = PBField.initUInt32(0);
  public final PBUInt64Field puin = PBField.initUInt64(0L);
  public final PBStringField strp1 = PBField.initString("");
  public final PBStringField strp2 = PBField.initString("");
  public final PBStringField strp3 = PBField.initString("");
  public final PBStringField strp4 = PBField.initString("");
  public final PBUInt32Field tvalue = PBField.initUInt32(0);
  public final PBUInt64Field uintp1 = PBField.initUInt64(0L);
  public final PBUInt64Field uintp2 = PBField.initUInt64(0L);
  public final PBUInt64Field uintp3 = PBField.initUInt64(0L);
  public final PBUInt64Field uintp4 = PBField.initUInt64(0L);
  public final PBStringField wifimac = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.qqshop.qqshop_report.SQQSHPCliLogInfo
 * JD-Core Version:    0.7.0.1
 */