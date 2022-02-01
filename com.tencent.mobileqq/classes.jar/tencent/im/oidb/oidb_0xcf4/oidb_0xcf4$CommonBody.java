package tencent.im.oidb.oidb_0xcf4;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xcf4$CommonBody
  extends MessageMicro<CommonBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField string_oidb_body = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_oidb_cmd = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 26, 40 }, new String[] { "string_oidb_body", "uint32_oidb_cmd" }, new Object[] { localByteStringMicro, Integer.valueOf(0) }, CommonBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xcf4.oidb_0xcf4.CommonBody
 * JD-Core Version:    0.7.0.1
 */