package tencent.im.oidb.cmd0xea0;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xea0$HorizontalAvatarsItem
  extends MessageMicro<HorizontalAvatarsItem>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34 }, new String[] { "pts_page_name", "show_more", "more_url", "subscriber" }, new Object[] { "", Integer.valueOf(0), "", null }, HorizontalAvatarsItem.class);
  public final PBStringField more_url = PBField.initString("");
  public final PBStringField pts_page_name = PBField.initString("");
  public final PBUInt32Field show_more = PBField.initUInt32(0);
  public final PBRepeatMessageField<oidb_cmd0xea0.Subscriber> subscriber = PBField.initRepeatMessage(oidb_cmd0xea0.Subscriber.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xea0.oidb_cmd0xea0.HorizontalAvatarsItem
 * JD-Core Version:    0.7.0.1
 */