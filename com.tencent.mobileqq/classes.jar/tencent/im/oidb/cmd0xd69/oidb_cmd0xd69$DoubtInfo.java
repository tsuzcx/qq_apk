package tencent.im.oidb.cmd0xd69;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xd69$DoubtInfo
  extends MessageMicro<DoubtInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_city = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_msg = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_name_more = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_nick = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_reason = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_session_key = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_source = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_age = PBField.initUInt32(0);
  public final PBUInt32Field uint32_comm_frd_num = PBField.initUInt32(0);
  public final PBUInt32Field uint32_sex = PBField.initUInt32(0);
  public final PBUInt32Field uint32_time = PBField.initUInt32(0);
  public final PBUInt64Field uint64_group = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro7 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 42, 50, 58, 64, 72, 80, 90, 98, 106 }, new String[] { "uint64_uin", "bytes_nick", "uint32_age", "uint32_sex", "bytes_msg", "bytes_source", "bytes_reason", "uint32_time", "uint64_group", "uint32_comm_frd_num", "bytes_name_more", "bytes_city", "bytes_session_key" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro5, localByteStringMicro6, localByteStringMicro7 }, DoubtInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0xd69.oidb_cmd0xd69.DoubtInfo
 * JD-Core Version:    0.7.0.1
 */