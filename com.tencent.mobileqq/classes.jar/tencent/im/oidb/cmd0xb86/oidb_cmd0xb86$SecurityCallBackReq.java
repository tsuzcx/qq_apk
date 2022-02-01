package tencent.im.oidb.cmd0xb86;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xb86$SecurityCallBackReq
  extends MessageMicro<SecurityCallBackReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField str_beat_desc = PBField.initString("");
  public final PBStringField str_message_id = PBField.initString("");
  public final PBUInt64Field uint64_appid = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_beat_common = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_beat_reason = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_post_time = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_src = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_sub_src = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 50, 56, 66 }, new String[] { "uint64_appid", "uint64_src", "uint64_sub_src", "uint64_beat_reason", "uint64_beat_common", "str_message_id", "uint64_post_time", "str_beat_desc" }, new Object[] { localLong, localLong, localLong, localLong, localLong, "", localLong, "" }, SecurityCallBackReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb86.oidb_cmd0xb86.SecurityCallBackReq
 * JD-Core Version:    0.7.0.1
 */