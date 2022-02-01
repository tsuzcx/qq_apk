package tencent.im.s2c.msgtype0x210.submsgtype0xc5;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class submsgtype0xc5$RedPointInfo
  extends MessageMicro<RedPointInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBEnumField red_point_item_type = PBField.initEnum(0);
  public final PBUInt32Field uint32_item_id = PBField.initUInt32(0);
  public final PBUInt64Field uint64_effect_time = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_failure_time = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 40 }, new String[] { "uint32_item_id", "red_point_item_type", "bytes_url", "uint64_effect_time", "uint64_failure_time" }, new Object[] { localInteger, localInteger, localByteStringMicro, localLong, localLong }, RedPointInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0xc5.submsgtype0xc5.RedPointInfo
 * JD-Core Version:    0.7.0.1
 */