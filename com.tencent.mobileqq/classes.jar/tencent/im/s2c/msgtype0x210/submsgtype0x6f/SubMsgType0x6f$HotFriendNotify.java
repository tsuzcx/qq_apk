package tencent.im.s2c.msgtype0x210.submsgtype0x6f;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SubMsgType0x6f$HotFriendNotify
  extends MessageMicro<HotFriendNotify>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 64, 72, 80, 88, 96, 104 }, new String[] { "uint64_dst_uin", "uint32_praise_hot_level", "uint32_chat_hot_level", "uint32_praise_hot_days", "uint32_chat_hot_days", "uint32_close_level", "uint32_close_days", "uint32_praise_flag", "uint32_chat_flag", "uint32_close_flag", "uint64_notify_time", "uint64_last_praise_time", "uint64_last_chat_time" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L) }, HotFriendNotify.class);
  public final PBUInt32Field uint32_chat_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_chat_hot_days = PBField.initUInt32(0);
  public final PBUInt32Field uint32_chat_hot_level = PBField.initUInt32(0);
  public final PBUInt32Field uint32_close_days = PBField.initUInt32(0);
  public final PBUInt32Field uint32_close_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_close_level = PBField.initUInt32(0);
  public final PBUInt32Field uint32_praise_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_praise_hot_days = PBField.initUInt32(0);
  public final PBUInt32Field uint32_praise_hot_level = PBField.initUInt32(0);
  public final PBUInt64Field uint64_dst_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_last_chat_time = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_last_praise_time = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_notify_time = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x6f.SubMsgType0x6f.HotFriendNotify
 * JD-Core Version:    0.7.0.1
 */