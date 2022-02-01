package tencent.im.oidb.cmd0xf77;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xf77$Community
  extends MessageMicro<Community>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field community_id = PBField.initUInt64(0L);
  public final PBBytesField community_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField community_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField description = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "community_id", "community_name", "community_url", "description" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3 }, Community.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xf77.oidb_cmd0xf77.Community
 * JD-Core Version:    0.7.0.1
 */