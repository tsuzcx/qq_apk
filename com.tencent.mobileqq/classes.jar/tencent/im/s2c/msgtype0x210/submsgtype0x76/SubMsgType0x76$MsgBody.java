package tencent.im.s2c.msgtype0x210.submsgtype0x76;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class SubMsgType0x76$MsgBody
  extends MessageMicro<MsgBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBoolField bool_strong_notify = PBField.initBool(false);
  public final PBBytesField bytes_notify_wording = PBField.initBytes(ByteStringMicro.EMPTY);
  public SubMsgType0x76.BirthdayNotify msg_birthday_notify = new SubMsgType0x76.BirthdayNotify();
  public SubMsgType0x76.GeoGraphicNotify msg_geographic_notify = new SubMsgType0x76.GeoGraphicNotify();
  public SubMsgType0x76.MemorialDayNotify msg_memorialday_notify = new SubMsgType0x76.MemorialDayNotify();
  public final PBUInt32Field uint32_msg_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_push_time = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 50, 58 }, new String[] { "uint32_msg_type", "bool_strong_notify", "uint32_push_time", "msg_geographic_notify", "msg_birthday_notify", "bytes_notify_wording", "msg_memorialday_notify" }, new Object[] { Integer.valueOf(0), Boolean.valueOf(false), Integer.valueOf(0), null, null, localByteStringMicro, null }, MsgBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x76.SubMsgType0x76.MsgBody
 * JD-Core Version:    0.7.0.1
 */