package tencent.im.oidb.cmd0xf51;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xf51$GroupMsgInfo
  extends MessageMicro<GroupMsgInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_msg_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_msg_seq = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_msg_time = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_msg_type = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_msg_uid = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48 }, new String[] { "uint64_group_code", "uint64_msg_type", "uint64_msg_seq", "uint64_msg_time", "uint64_msg_uid", "uint64_msg_id" }, new Object[] { localLong, localLong, localLong, localLong, localLong, localLong }, GroupMsgInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xf51.oidb_cmd0xf51.GroupMsgInfo
 * JD-Core Version:    0.7.0.1
 */