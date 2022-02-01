package tencent.im.oidb.oidb_0xcf4;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xcf4$DnaDetail
  extends MessageMicro<DnaDetail>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_desc = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_bold_index = PBField.initUInt32(0);
  public final PBUInt32Field uint32_bold_len = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "bytes_desc", "uint32_bold_index", "uint32_bold_len" }, new Object[] { localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0) }, DnaDetail.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xcf4.oidb_0xcf4.DnaDetail
 * JD-Core Version:    0.7.0.1
 */