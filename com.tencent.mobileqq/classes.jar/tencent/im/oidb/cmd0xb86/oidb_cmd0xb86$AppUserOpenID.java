package tencent.im.oidb.cmd0xb86;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xb86$AppUserOpenID
  extends MessageMicro<AppUserOpenID>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_appid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_openid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field uint64_from = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uint64_from", "bytes_appid", "bytes_openid" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2 }, AppUserOpenID.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb86.oidb_cmd0xb86.AppUserOpenID
 * JD-Core Version:    0.7.0.1
 */