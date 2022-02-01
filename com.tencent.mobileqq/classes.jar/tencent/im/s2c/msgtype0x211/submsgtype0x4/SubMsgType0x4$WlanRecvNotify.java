package tencent.im.s2c.msgtype0x211.submsgtype0x4;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SubMsgType0x4$WlanRecvNotify
  extends MessageMicro<WlanRecvNotify>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField str_file_name = PBField.initString("");
  public final PBUInt32Field uint32_random = PBField.initUInt32(0);
  public final PBUInt32Field uint32_send_client_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_target_client_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_time = PBField.initUInt32(0);
  public final PBUInt64Field uint64_file_size = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_session_id = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 48, 56 }, new String[] { "uint64_session_id", "uint32_send_client_type", "uint32_target_client_type", "str_file_name", "uint64_file_size", "uint32_time", "uint32_random" }, new Object[] { localLong, localInteger, localInteger, "", localLong, localInteger, localInteger }, WlanRecvNotify.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x211.submsgtype0x4.SubMsgType0x4.WlanRecvNotify
 * JD-Core Version:    0.7.0.1
 */