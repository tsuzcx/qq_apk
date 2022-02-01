package tencent.im.oidb.cmd0x77c;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x77c$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_wording = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_add_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_add_year = PBField.initUInt32(0);
  public final PBUInt32Field uint32_next_time_gap = PBField.initUInt32(0);
  public final PBUInt32Field uint32_qzone_interaction_numbers = PBField.initUInt32(0);
  public final PBUInt64Field uint64_friend_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 50, 56, 66 }, new String[] { "uint64_uin", "uint64_friend_uin", "uint32_add_time", "uint32_add_year", "uint32_qzone_interaction_numbers", "bytes_wording", "uint32_next_time_gap", "bytes_url" }, new Object[] { localLong, localLong, localInteger, localInteger, localInteger, localByteStringMicro1, localInteger, localByteStringMicro2 }, RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x77c.cmd0x77c.RspBody
 * JD-Core Version:    0.7.0.1
 */