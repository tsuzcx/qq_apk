package tencent.im.oidb.cmd0xea0;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class oidb_cmd0xea0$DynamicBannerItem
  extends MessageMicro<DynamicBannerItem>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "dynamic_json", "unique_id", "card_report_json" }, new Object[] { "", "", "" }, DynamicBannerItem.class);
  public final PBStringField card_report_json = PBField.initString("");
  public final PBStringField dynamic_json = PBField.initString("");
  public final PBStringField unique_id = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xea0.oidb_cmd0xea0.DynamicBannerItem
 * JD-Core Version:    0.7.0.1
 */