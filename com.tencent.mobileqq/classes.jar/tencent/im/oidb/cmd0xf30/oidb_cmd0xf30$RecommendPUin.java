package tencent.im.oidb.cmd0xf30;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xf30$RecommendPUin
  extends MessageMicro<RecommendPUin>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_resaon = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field uint64_puin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint64_puin", "bytes_resaon" }, new Object[] { Long.valueOf(0L), localByteStringMicro }, RecommendPUin.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xf30.oidb_cmd0xf30.RecommendPUin
 * JD-Core Version:    0.7.0.1
 */