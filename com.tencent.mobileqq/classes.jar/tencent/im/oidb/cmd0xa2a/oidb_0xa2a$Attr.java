package tencent.im.oidb.cmd0xa2a;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class oidb_0xa2a$Attr
  extends MessageMicro<Attr>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField str_imei = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField str_imsi = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField str_phone_num = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "str_imei", "str_imsi", "str_phone_num" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3 }, Attr.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xa2a.oidb_0xa2a.Attr
 * JD-Core Version:    0.7.0.1
 */