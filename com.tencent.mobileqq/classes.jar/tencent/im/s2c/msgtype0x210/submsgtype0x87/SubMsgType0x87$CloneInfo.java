package tencent.im.s2c.msgtype0x210.submsgtype0x87;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SubMsgType0x87$CloneInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_origin_nick = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_remark = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_to_nick = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_show_in_aio = PBField.initUInt32(0);
  public final PBUInt32Field uint32_src_gender = PBField.initUInt32(0);
  public final PBUInt64Field uint64_to_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40, 50, 56 }, new String[] { "uint64_uin", "bytes_remark", "bytes_origin_nick", "uint32_show_in_aio", "uint64_to_uin", "bytes_to_nick", "uint32_src_gender" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro3, Integer.valueOf(0) }, CloneInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x87.SubMsgType0x87.CloneInfo
 * JD-Core Version:    0.7.0.1
 */