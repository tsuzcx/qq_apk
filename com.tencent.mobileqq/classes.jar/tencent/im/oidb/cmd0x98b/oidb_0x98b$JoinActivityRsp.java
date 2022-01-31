package tencent.im.oidb.cmd0x98b;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x98b$JoinActivityRsp
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_act_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_failed_notice = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_boom_remain_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_delay_open_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_ios_use_arkit = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_boom = PBField.initUInt32(0);
  public final PBUInt32Field uint32_pack_limit = PBField.initUInt32(0);
  public final PBUInt32Field uint32_rain_time = PBField.initUInt32(0);
  public final PBUInt64Field uint64_boom_time = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 40, 48, 56, 64, 72 }, new String[] { "bytes_act_id", "uint32_rain_time", "uint32_pack_limit", "bytes_failed_notice", "uint32_ios_use_arkit", "uint32_delay_open_time", "uint32_is_boom", "uint64_boom_time", "uint32_boom_remain_time" }, new Object[] { localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0) }, JoinActivityRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x98b.oidb_0x98b.JoinActivityRsp
 * JD-Core Version:    0.7.0.1
 */