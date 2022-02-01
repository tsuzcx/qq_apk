package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x8b4$TagInfo
  extends MessageMicro<TagInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field uint32_0x7dd_seq = PBField.initUInt32(0);
  public final PBUInt32Field uint32_cnt = PBField.initUInt32(0);
  public final PBUInt32Field uint32_start = PBField.initUInt32(0);
  public final PBUInt32Field uint32_timestamp = PBField.initUInt32(0);
  public final PBUInt64Field uint64_dst_uin = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40 }, new String[] { "uint64_dst_uin", "uint32_start", "uint32_cnt", "uint32_timestamp", "uint32_0x7dd_seq" }, new Object[] { Long.valueOf(0L), localInteger, localInteger, localInteger, localInteger }, TagInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8b4.TagInfo
 * JD-Core Version:    0.7.0.1
 */