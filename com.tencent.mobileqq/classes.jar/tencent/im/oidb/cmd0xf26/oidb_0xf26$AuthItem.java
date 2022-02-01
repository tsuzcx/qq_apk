package tencent.im.oidb.cmd0xf26;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xf26$AuthItem
  extends MessageMicro<AuthItem>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField auth_group_desc = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field auth_group_id = PBField.initUInt32(0);
  public final PBBytesField auth_group_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field auth_result = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32 }, new String[] { "auth_group_id", "auth_group_name", "auth_group_desc", "auth_result" }, new Object[] { localInteger, localByteStringMicro1, localByteStringMicro2, localInteger }, AuthItem.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xf26.oidb_0xf26.AuthItem
 * JD-Core Version:    0.7.0.1
 */