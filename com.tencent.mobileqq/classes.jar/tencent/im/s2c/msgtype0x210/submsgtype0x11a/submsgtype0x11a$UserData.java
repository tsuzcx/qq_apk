package tencent.im.s2c.msgtype0x210.submsgtype0x11a;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBRepeatField;

public final class submsgtype0x11a$UserData
  extends MessageMicro<UserData>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_bssid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_ip = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_ssid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBEnumField enum_platform = PBField.initEnum(1);
  public final PBRepeatField<Integer> rpt_fixed32_port = PBField.initRepeat(PBFixed32Field.__repeatHelper__);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 21, 26, 34, 40 }, new String[] { "bytes_ip", "rpt_fixed32_port", "bytes_ssid", "bytes_bssid", "enum_platform" }, new Object[] { localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2, localByteStringMicro3, Integer.valueOf(1) }, UserData.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x11a.submsgtype0x11a.UserData
 * JD-Core Version:    0.7.0.1
 */