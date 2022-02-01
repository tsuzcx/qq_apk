package tencent.im.oidb.hotchat;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class LBS$Attribute
  extends MessageMicro<Attribute>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField imei = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField imsi = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField phone_num = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "imei", "imsi", "phone_num" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3 }, Attribute.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.hotchat.LBS.Attribute
 * JD-Core Version:    0.7.0.1
 */