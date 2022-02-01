package tencent.im.oidb.cmd0xc32;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xc32$GetVisibleListRspBody
  extends MessageMicro<GetVisibleListRspBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatField<Long> rpt_uint64_visible_uins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBUInt32Field uint32_is_end = PBField.initUInt32(0);
  public final PBUInt32Field uint32_next_ix = PBField.initUInt32(0);
  public final PBUInt32Field uint32_total_count = PBField.initUInt32(0);
  public final PBUInt64Field uint64_feeds_author = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_feeds_id = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48 }, new String[] { "uint64_feeds_id", "rpt_uint64_visible_uins", "uint32_total_count", "uint32_next_ix", "uint32_is_end", "uint64_feeds_author" }, new Object[] { localLong, localLong, localInteger, localInteger, localInteger, localLong }, GetVisibleListRspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xc32.oidb_cmd0xc32.GetVisibleListRspBody
 * JD-Core Version:    0.7.0.1
 */