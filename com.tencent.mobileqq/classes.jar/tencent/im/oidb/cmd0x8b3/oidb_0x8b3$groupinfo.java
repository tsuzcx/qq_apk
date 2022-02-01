package tencent.im.oidb.cmd0x8b3;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class oidb_0x8b3$groupinfo
  extends MessageMicro<groupinfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField string_group_memo = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField string_jumping_url = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "string_group_memo", "string_jumping_url" }, new Object[] { localByteStringMicro1, localByteStringMicro2 }, groupinfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8b3.oidb_0x8b3.groupinfo
 * JD-Core Version:    0.7.0.1
 */