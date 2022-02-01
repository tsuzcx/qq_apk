package tencent.im.s2c.msgtype0x210.submsgtype0x26;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class submsgtype0x26$AppTipNotify
  extends MessageMicro<AppTipNotify>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_text = PBField.initBytes(ByteStringMicro.EMPTY);
  public submsgtype0x26.AppTip msg_app_tip = new submsgtype0x26.AppTip();
  public submsgtype0x26.AppNotifyContent opt_msg_app_notify_content = new submsgtype0x26.AppNotifyContent();
  public final PBUInt32Field uint32_action = PBField.initUInt32(0);
  public final PBUInt32Field uint32_needed_tip_info_seq = PBField.initUInt32(0);
  public final PBUInt32Field uint32_notify_seq = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32, 40, 50 }, new String[] { "msg_app_tip", "uint32_action", "bytes_text", "uint32_notify_seq", "uint32_needed_tip_info_seq", "opt_msg_app_notify_content" }, new Object[] { null, localInteger, localByteStringMicro, localInteger, localInteger, null }, AppTipNotify.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x26.submsgtype0x26.AppTipNotify
 * JD-Core Version:    0.7.0.1
 */