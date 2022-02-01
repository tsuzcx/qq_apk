package tencent.im.oidb.oidb_0x85f;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x85f$ReadScoreListReq
  extends MessageMicro<ReadScoreListReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field uint32_day = PBField.initUInt32(0);
  public final PBUInt32Field uint32_dimension = PBField.initUInt32(0);
  public final PBUInt32Field uint32_index_begin = PBField.initUInt32(0);
  public final PBUInt32Field uint32_index_end = PBField.initUInt32(0);
  public final PBUInt32Field uint32_index_order = PBField.initUInt32(0);
  public final PBUInt64Field uint64_user_id = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48 }, new String[] { "uint32_index_begin", "uint32_index_end", "uint32_dimension", "uint32_index_order", "uint32_day", "uint64_user_id" }, new Object[] { localInteger, localInteger, localInteger, localInteger, localInteger, Long.valueOf(0L) }, ReadScoreListReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.oidb_0x85f.oidb_0x85f.ReadScoreListReq
 * JD-Core Version:    0.7.0.1
 */