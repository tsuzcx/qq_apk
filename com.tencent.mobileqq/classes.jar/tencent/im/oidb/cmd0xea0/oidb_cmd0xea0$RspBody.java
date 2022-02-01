package tencent.im.oidb.cmd0xea0;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xea0$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "channel_id", "dynamic_banner_list" }, new Object[] { Long.valueOf(0L), null }, RspBody.class);
  public final PBUInt64Field channel_id = PBField.initUInt64(0L);
  public final PBRepeatMessageField<oidb_cmd0xea0.DynamicBannerItem> dynamic_banner_list = PBField.initRepeatMessage(oidb_cmd0xea0.DynamicBannerItem.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xea0.oidb_cmd0xea0.RspBody
 * JD-Core Version:    0.7.0.1
 */