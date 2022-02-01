package tencent.im.s2c.msgtype0x210.submsgtype0xe4;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class submsgtype0xe4$LikeMsg
  extends MessageMicro<LikeMsg>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_to_uin = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_from_uin", "uint64_to_uin" }, new Object[] { localLong, localLong }, LikeMsg.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0xe4.submsgtype0xe4.LikeMsg
 * JD-Core Version:    0.7.0.1
 */