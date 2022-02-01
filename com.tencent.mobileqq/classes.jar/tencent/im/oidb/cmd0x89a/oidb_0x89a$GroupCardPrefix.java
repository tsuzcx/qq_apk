package tencent.im.oidb.cmd0x89a;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;

public final class oidb_0x89a$GroupCardPrefix
  extends MessageMicro<GroupCardPrefix>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_introduction = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatField<ByteStringMicro> rpt_bytes_prefix = PBField.initRepeat(PBBytesField.__repeatHelper__);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "bytes_introduction", "rpt_bytes_prefix" }, new Object[] { localByteStringMicro1, localByteStringMicro2 }, GroupCardPrefix.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x89a.oidb_0x89a.GroupCardPrefix
 * JD-Core Version:    0.7.0.1
 */