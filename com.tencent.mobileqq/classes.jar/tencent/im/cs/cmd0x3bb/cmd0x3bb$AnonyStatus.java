package tencent.im.cs.cmd0x3bb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x3bb$AnonyStatus
  extends MessageMicro<AnonyStatus>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField str_err_msg = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_forbid_talking = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 82 }, new String[] { "uint32_forbid_talking", "str_err_msg" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, AnonyStatus.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     tencent.im.cs.cmd0x3bb.cmd0x3bb.AnonyStatus
 * JD-Core Version:    0.7.0.1
 */