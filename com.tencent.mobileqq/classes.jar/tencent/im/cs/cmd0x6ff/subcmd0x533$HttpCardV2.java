package tencent.im.cs.cmd0x6ff;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class subcmd0x533$HttpCardV2
  extends MessageMicro<HttpCardV2>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 42 }, new String[] { "string_template_name", "bool_is_recommended", "rpt_msg_card_properties", "rpt_msg_carousel", "rpt_msg_subcards" }, new Object[] { "", Boolean.valueOf(false), null, null, null }, HttpCardV2.class);
  public final PBBoolField bool_is_recommended = PBField.initBool(false);
  public final PBRepeatMessageField<subcmd0x533.HttpMapItem> rpt_msg_card_properties = PBField.initRepeatMessage(subcmd0x533.HttpMapItem.class);
  public final PBRepeatMessageField<subcmd0x533.HttpCardV2.HttpCarouselUnitV2> rpt_msg_carousel = PBField.initRepeatMessage(subcmd0x533.HttpCardV2.HttpCarouselUnitV2.class);
  public final PBRepeatMessageField<HttpCardV2> rpt_msg_subcards = PBField.initRepeatMessage(HttpCardV2.class);
  public final PBStringField string_template_name = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     tencent.im.cs.cmd0x6ff.subcmd0x533.HttpCardV2
 * JD-Core Version:    0.7.0.1
 */