package tencent.im.oidb.cmd0x7c4;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x7c4$OneFrdData
  extends MessageMicro<OneFrdData>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_smart_remark = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_ages = PBField.initUInt32(0);
  public final PBUInt32Field uint32_gender = PBField.initUInt32(0);
  public final PBUInt32Field uint32_reason_id = PBField.initUInt32(0);
  public final PBUInt64Field uint64_frd_id = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 40 }, new String[] { "uint64_frd_id", "uint32_reason_id", "bytes_smart_remark", "uint32_gender", "uint32_ages" }, new Object[] { Long.valueOf(0L), localInteger, localByteStringMicro, localInteger, localInteger }, OneFrdData.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x7c4.cmd0x7c4.OneFrdData
 * JD-Core Version:    0.7.0.1
 */