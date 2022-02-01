package tencent.im.oidb.cmd0xb57;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xb57$QualityNumItem
  extends MessageMicro<QualityNumItem>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_num_summary = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_approve_state = PBField.initUInt32(0);
  public final PBUInt32Field uint32_fans_num = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_star = PBField.initUInt32(0);
  public final PBUInt32Field uint32_mark_state = PBField.initUInt32(0);
  public final PBUInt32Field uint32_publish_num = PBField.initUInt32(0);
  public final PBUInt64Field uint64_quality_num = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 48, 56 }, new String[] { "uint64_quality_num", "uint32_mark_state", "uint32_approve_state", "bytes_num_summary", "uint32_fans_num", "uint32_publish_num", "uint32_is_star" }, new Object[] { Long.valueOf(0L), localInteger, localInteger, localByteStringMicro, localInteger, localInteger, localInteger }, QualityNumItem.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb57.oidb_cmd0xb57.QualityNumItem
 * JD-Core Version:    0.7.0.1
 */