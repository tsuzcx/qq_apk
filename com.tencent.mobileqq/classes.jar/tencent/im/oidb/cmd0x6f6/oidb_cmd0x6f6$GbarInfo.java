package tencent.im.oidb.cmd0x6f6;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0x6f6$GbarInfo
  extends MessageMicro<GbarInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField str_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_bid = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_bid", "str_name" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, GbarInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x6f6.oidb_cmd0x6f6.GbarInfo
 * JD-Core Version:    0.7.0.1
 */