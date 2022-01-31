package tencent.im.oidb.cmd0xbe0;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0xbe0$UserInfo
  extends MessageMicro<UserInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field bytes_user_bir = PBField.initUInt32(0);
  public final PBBytesField bytes_user_city = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_user_sex = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "bytes_user_bir", "uint32_user_sex", "bytes_user_city" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro }, UserInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0xbe0.cmd0xbe0.UserInfo
 * JD-Core Version:    0.7.0.1
 */