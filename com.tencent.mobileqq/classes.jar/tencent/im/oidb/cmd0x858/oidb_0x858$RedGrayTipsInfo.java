package tencent.im.oidb.cmd0x858;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x858$RedGrayTipsInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_authkey = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_receiver_rich_content = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_sender_rich_content = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field opt_uint32_show_lastest = PBField.initUInt32(0);
  public final PBUInt64Field uint64_receiver_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_sender_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 50 }, new String[] { "opt_uint32_show_lastest", "uint64_sender_uin", "uint64_receiver_uin", "bytes_sender_rich_content", "bytes_receiver_rich_content", "bytes_authkey" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3 }, RedGrayTipsInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x858.oidb_0x858.RedGrayTipsInfo
 * JD-Core Version:    0.7.0.1
 */