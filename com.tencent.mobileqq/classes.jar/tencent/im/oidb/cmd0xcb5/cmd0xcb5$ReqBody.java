package tencent.im.oidb.cmd0xcb5;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0xcb5$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32 }, new String[] { "uint64_uin", "uint32_report_type", "str_report_conent", "uint64_report_time" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), "", Long.valueOf(0L) }, ReqBody.class);
  public final PBStringField str_report_conent = PBField.initString("");
  public final PBUInt32Field uint32_report_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_report_time = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xcb5.cmd0xcb5.ReqBody
 * JD-Core Version:    0.7.0.1
 */