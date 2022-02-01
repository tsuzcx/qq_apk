package tencent.im.mutualmark;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class mutualmark$SpecialWordCardGetInfo
  extends MessageMicro<SpecialWordCardGetInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint64_uin", "uint32_can_get_card_count", "uint64_last_give_card_time" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L) }, SpecialWordCardGetInfo.class);
  public final PBUInt32Field uint32_can_get_card_count = PBField.initUInt32(0);
  public final PBUInt64Field uint64_last_give_card_time = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.mutualmark.mutualmark.SpecialWordCardGetInfo
 * JD-Core Version:    0.7.0.1
 */