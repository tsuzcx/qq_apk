package tencent.im.cs.cmd0x355;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Stt$TransC2CPttReq
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 48, 56 }, new String[] { "uint64_sessionid", "uint64_sender_uin", "uint64_receiver_uin", "str_file_path", "uint32_ptt_time", "uint32_filesize", "uint32_ptt_format" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, TransC2CPttReq.class);
  public final PBStringField str_file_path = PBField.initString("");
  public final PBUInt32Field uint32_filesize = PBField.initUInt32(0);
  public final PBUInt32Field uint32_ptt_format = PBField.initUInt32(0);
  public final PBUInt32Field uint32_ptt_time = PBField.initUInt32(0);
  public final PBUInt64Field uint64_receiver_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_sender_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_sessionid = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.cs.cmd0x355.Stt.TransC2CPttReq
 * JD-Core Version:    0.7.0.1
 */