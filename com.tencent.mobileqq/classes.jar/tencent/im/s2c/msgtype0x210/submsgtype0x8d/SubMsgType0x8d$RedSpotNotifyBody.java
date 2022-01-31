package tencent.im.s2c.msgtype0x210.submsgtype0x8d;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SubMsgType0x8d$RedSpotNotifyBody
  extends MessageMicro<RedSpotNotifyBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_guide_wording = PBField.initBytes(ByteStringMicro.EMPTY);
  public SubMsgType0x8d.ChannelNotify msg_channel_notify = new SubMsgType0x8d.ChannelNotify();
  public final PBRepeatField<Long> rpt_new_channel_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBUInt32Field uint32_time = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34 }, new String[] { "uint32_time", "rpt_new_channel_list", "bytes_guide_wording", "msg_channel_notify" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro, null }, RedSpotNotifyBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x8d.SubMsgType0x8d.RedSpotNotifyBody
 * JD-Core Version:    0.7.0.1
 */