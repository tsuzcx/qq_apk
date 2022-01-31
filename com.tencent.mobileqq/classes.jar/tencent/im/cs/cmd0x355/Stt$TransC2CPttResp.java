package tencent.im.cs.cmd0x355;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Stt$TransC2CPttResp
  extends MessageMicro<TransC2CPttResp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 50, 56, 66 }, new String[] { "uint64_sessionid", "uint32_error_code", "uint32_waittime", "uint64_sender_uin", "uint64_receiver_uin", "str_file_path", "uint32_serviceprovider", "str_text" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), "", Integer.valueOf(0), "" }, TransC2CPttResp.class);
  public final PBStringField str_file_path = PBField.initString("");
  public final PBStringField str_text = PBField.initString("");
  public final PBUInt32Field uint32_error_code = PBField.initUInt32(0);
  public final PBUInt32Field uint32_serviceprovider = PBField.initUInt32(0);
  public final PBUInt32Field uint32_waittime = PBField.initUInt32(0);
  public final PBUInt64Field uint64_receiver_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_sender_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_sessionid = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     tencent.im.cs.cmd0x355.Stt.TransC2CPttResp
 * JD-Core Version:    0.7.0.1
 */