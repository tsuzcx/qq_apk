package tencent.im.oidb.cmd0xa28;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class oidb_0xa28$RoleInfo
  extends MessageMicro<RoleInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_role_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_role_score = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField str_role_url = PBField.initString("");
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "bytes_role_name", "bytes_role_score", "str_role_url" }, new Object[] { localByteStringMicro1, localByteStringMicro2, "" }, RoleInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xa28.oidb_0xa28.RoleInfo
 * JD-Core Version:    0.7.0.1
 */