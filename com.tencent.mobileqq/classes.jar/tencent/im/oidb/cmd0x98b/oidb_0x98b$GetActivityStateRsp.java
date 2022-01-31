package tencent.im.oidb.cmd0x98b;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x98b$GetActivityStateRsp
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_act_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_failed_notice = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField rpt_user_list = PBField.initRepeatMessage(oidb_0x98b.UserInfo.class);
  public final PBUInt32Field uint32_act_state = PBField.initUInt32(0);
  public final PBUInt32Field uint32_boom_rate = PBField.initUInt32(0);
  public final PBUInt64Field uint64_act_time = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_state_time = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 42, 80, 114 }, new String[] { "bytes_act_id", "uint32_act_state", "uint64_act_time", "uint64_state_time", "bytes_failed_notice", "uint32_boom_rate", "rpt_user_list" }, new Object[] { localByteStringMicro1, Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro2, Integer.valueOf(0), null }, GetActivityStateRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x98b.oidb_0x98b.GetActivityStateRsp
 * JD-Core Version:    0.7.0.1
 */