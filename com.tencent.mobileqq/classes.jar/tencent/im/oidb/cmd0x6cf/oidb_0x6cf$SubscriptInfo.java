package tencent.im.oidb.cmd0x6cf;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x6cf$SubscriptInfo
  extends MessageMicro<SubscriptInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_background_color = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_subscript_color = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_subscript_txt = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_subscript_type = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32 }, new String[] { "bytes_subscript_txt", "bytes_subscript_color", "bytes_background_color", "uint32_subscript_type" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0) }, SubscriptInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x6cf.oidb_0x6cf.SubscriptInfo
 * JD-Core Version:    0.7.0.1
 */