package tencent.im.cs.cmd0x6ff;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class subcmd0x533$HttpCardV2$HttpCarouselUnitV2
  extends MessageMicro<HttpCarouselUnitV2>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_card_properties" }, new Object[] { null }, HttpCarouselUnitV2.class);
  public final PBRepeatMessageField<subcmd0x533.HttpMapItem> rpt_msg_card_properties = PBField.initRepeatMessage(subcmd0x533.HttpMapItem.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.cs.cmd0x6ff.subcmd0x533.HttpCardV2.HttpCarouselUnitV2
 * JD-Core Version:    0.7.0.1
 */