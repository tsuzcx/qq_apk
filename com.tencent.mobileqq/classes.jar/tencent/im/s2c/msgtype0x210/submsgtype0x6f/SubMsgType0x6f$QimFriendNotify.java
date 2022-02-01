package tencent.im.s2c.msgtype0x210.submsgtype0x6f;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SubMsgType0x6f$QimFriendNotify
  extends MessageMicro<QimFriendNotify>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatField<ByteStringMicro> rpt_bytes_mobiles = PBField.initRepeat(PBBytesField.__repeatHelper__);
  public final PBRepeatField<Long> rpt_uint64_uins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBUInt32Field uint32_op_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_fans_total_count = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_fans_unread_count = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_push_time = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 50 }, new String[] { "uint32_op_type", "rpt_uint64_uins", "uint64_fans_unread_count", "uint64_fans_total_count", "uint64_push_time", "rpt_bytes_mobiles" }, new Object[] { Integer.valueOf(0), localLong, localLong, localLong, localLong, localByteStringMicro }, QimFriendNotify.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x6f.SubMsgType0x6f.QimFriendNotify
 * JD-Core Version:    0.7.0.1
 */