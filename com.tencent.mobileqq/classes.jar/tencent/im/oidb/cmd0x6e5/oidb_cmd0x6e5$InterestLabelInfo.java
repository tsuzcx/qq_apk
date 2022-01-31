package tencent.im.oidb.cmd0x6e5;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0x6e5$InterestLabelInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_interest_label_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_interest_label_id = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_interest_label_id", "bytes_interest_label_name" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, InterestLabelInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x6e5.oidb_cmd0x6e5.InterestLabelInfo
 * JD-Core Version:    0.7.0.1
 */