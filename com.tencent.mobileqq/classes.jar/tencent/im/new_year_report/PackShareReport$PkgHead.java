package tencent.im.new_year_report;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class PackShareReport$PkgHead
  extends MessageMicro<PkgHead>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field cmdtype = PBField.initUInt32(0);
  public final PBBytesField resp_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field retcode = PBField.initUInt32(0);
  public final PBStringField retmsg = PBField.initString("");
  public final PBUInt64Field seq = PBField.initUInt64(0L);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 50 }, new String[] { "cmdtype", "uin", "seq", "resp_name", "retcode", "retmsg" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro, Integer.valueOf(0), "" }, PkgHead.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     tencent.im.new_year_report.PackShareReport.PkgHead
 * JD-Core Version:    0.7.0.1
 */