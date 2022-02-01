package tencent.im.s2c.msgtype0x210.submsgtype0xdd;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class submsgtype0xdd$MsgBody$SeatsInfo
  extends MessageMicro<SeatsInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field uint32_seat_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_seat_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_seat_seq = PBField.initUInt32(0);
  public final PBUInt64Field uint64_guest_uin = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "uint32_seat_flag", "uint64_guest_uin", "uint32_seat_id", "uint32_seat_seq" }, new Object[] { localInteger, Long.valueOf(0L), localInteger, localInteger }, SeatsInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0xdd.submsgtype0xdd.MsgBody.SeatsInfo
 * JD-Core Version:    0.7.0.1
 */