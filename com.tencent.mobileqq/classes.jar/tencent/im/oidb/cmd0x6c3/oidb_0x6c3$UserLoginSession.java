package tencent.im.oidb.cmd0x6c3;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class oidb_0x6c3$UserLoginSession
  extends MessageMicro<UserLoginSession>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_accesstoken = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_appid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_openid = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "bytes_appid", "bytes_openid", "bytes_accesstoken" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3 }, UserLoginSession.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0x6c3.oidb_0x6c3.UserLoginSession
 * JD-Core Version:    0.7.0.1
 */