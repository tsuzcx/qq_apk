package tencent.im.pushsvr;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class pushsvrExt$ExtData
  extends MessageMicro<ExtData>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField str_remark = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field uint64_to_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint64_to_uin", "str_remark" }, new Object[] { Long.valueOf(0L), localByteStringMicro }, ExtData.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     tencent.im.pushsvr.pushsvrExt.ExtData
 * JD-Core Version:    0.7.0.1
 */