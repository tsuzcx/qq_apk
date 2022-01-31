package tencent.im.s2c.msgtype0x210.submsgtype0xee;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class submsgtype0xee$MsgBody
  extends MessageMicro<MsgBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField<submsgtype0xee.NotifyInfo> rpt_msg_notify_list = PBField.initRepeatMessage(submsgtype0xee.NotifyInfo.class);
  public final PBUInt32Field uint32_bid = PBField.initUInt32(0);
  public final PBUInt64Field uint64_seq = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 90 }, new String[] { "bytes_id", "uint64_seq", "uint32_bid", "rpt_msg_notify_list" }, new Object[] { localByteStringMicro, Long.valueOf(0L), Integer.valueOf(0), null }, MsgBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0xee.submsgtype0xee.MsgBody
 * JD-Core Version:    0.7.0.1
 */