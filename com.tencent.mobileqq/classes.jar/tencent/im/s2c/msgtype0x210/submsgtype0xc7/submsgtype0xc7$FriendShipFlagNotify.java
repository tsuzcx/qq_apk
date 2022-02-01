package tencent.im.s2c.msgtype0x210.submsgtype0xc7;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class submsgtype0xc7$FriendShipFlagNotify
  extends MessageMicro<FriendShipFlagNotify>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field uint32_chat_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_continuity_days = PBField.initUInt32(0);
  public final PBUInt32Field uint32_level_1 = PBField.initUInt32(0);
  public final PBUInt32Field uint32_level_2 = PBField.initUInt32(0);
  public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
  public final PBUInt64Field uint64_dst_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_last_chat_time = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_notify_time = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 64 }, new String[] { "uint64_dst_uin", "uint32_level_1", "uint32_level_2", "uint32_continuity_days", "uint32_chat_flag", "uint64_last_chat_time", "uint64_notify_time", "uint32_seq" }, new Object[] { localLong, localInteger, localInteger, localInteger, localInteger, localLong, localLong, localInteger }, FriendShipFlagNotify.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0xc7.submsgtype0xc7.FriendShipFlagNotify
 * JD-Core Version:    0.7.0.1
 */