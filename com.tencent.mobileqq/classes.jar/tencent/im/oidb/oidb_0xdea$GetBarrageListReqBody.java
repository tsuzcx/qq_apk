package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xdea$GetBarrageListReqBody
  extends MessageMicro<GetBarrageListReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBEnumField entrance = PBField.initEnum(1);
  public final PBEnumField terminal = PBField.initEnum(0);
  public final PBUInt32Field uint32_barrage_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_last_update_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_start_index = PBField.initUInt32(0);
  public final PBUInt32Field uint32_video_end_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_video_start_time = PBField.initUInt32(0);
  public final PBUInt64Field uint64_barrage_seq = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 64, 72 }, new String[] { "uint64_group_code", "uint64_barrage_seq", "uint32_last_update_time", "uint32_start_index", "uint32_barrage_count", "uint32_video_start_time", "uint32_video_end_time", "entrance", "terminal" }, new Object[] { localLong, localLong, localInteger, localInteger, localInteger, localInteger, localInteger, Integer.valueOf(1), localInteger }, GetBarrageListReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xdea.GetBarrageListReqBody
 * JD-Core Version:    0.7.0.1
 */