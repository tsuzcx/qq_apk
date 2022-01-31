package tencent.im.s2c.msgtype0x210.submsgtype0x26;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class submsgtype0x26$AppNotifyContent
  extends MessageMicro<AppNotifyContent>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_text = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field game_id = PBField.initUInt32(0);
  public final PBUInt32Field live_extra_mode = PBField.initUInt32(0);
  public final PBRepeatMessageField<submsgtype0x26.AppNotifyUser> opt_msg_app_notify_user = PBField.initRepeatMessage(submsgtype0x26.AppNotifyUser.class);
  public final PBUInt32Field room_mode = PBField.initUInt32(0);
  public final PBUInt32Field uint32_expire_ts = PBField.initUInt32(0);
  public final PBUInt32Field uint32_online_count = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 48, 56 }, new String[] { "bytes_text", "opt_msg_app_notify_user", "uint32_online_count", "uint32_expire_ts", "room_mode", "live_extra_mode", "game_id" }, new Object[] { localByteStringMicro, null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, AppNotifyContent.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x26.submsgtype0x26.AppNotifyContent
 * JD-Core Version:    0.7.0.1
 */