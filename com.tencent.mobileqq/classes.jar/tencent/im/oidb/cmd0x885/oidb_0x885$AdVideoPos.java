package tencent.im.oidb.cmd0x885;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x885$AdVideoPos
  extends MessageMicro<AdVideoPos>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_trace_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field int32_kd_pos = PBField.initInt32(0);
  public final PBUInt64Field uint64_aid = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "bytes_trace_id", "uint64_aid", "int32_kd_pos" }, new Object[] { localByteStringMicro, Long.valueOf(0L), Integer.valueOf(0) }, AdVideoPos.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x885.oidb_0x885.AdVideoPos
 * JD-Core Version:    0.7.0.1
 */