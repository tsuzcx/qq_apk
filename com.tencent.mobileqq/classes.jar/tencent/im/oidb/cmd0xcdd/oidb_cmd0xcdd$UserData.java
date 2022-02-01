package tencent.im.oidb.cmd0xcdd;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBRepeatField;

public final class oidb_cmd0xcdd$UserData
  extends MessageMicro<UserData>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bssid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField ip = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBEnumField platform = PBField.initEnum(1);
  public final PBRepeatField<Integer> port = PBField.initRepeat(PBFixed32Field.__repeatHelper__);
  public final PBBytesField ssid = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 21, 26, 34, 40 }, new String[] { "ip", "port", "ssid", "bssid", "platform" }, new Object[] { localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2, localByteStringMicro3, Integer.valueOf(1) }, UserData.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xcdd.oidb_cmd0xcdd.UserData
 * JD-Core Version:    0.7.0.1
 */