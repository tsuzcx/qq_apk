package tencent.im.msg.hummer.resv;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ResvAttrForGiftMsg$ActivityGiftInfo
  extends MessageMicro<ActivityGiftInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "is_activity_gift", "text_color", "text", "url" }, new Object[] { Integer.valueOf(0), "", "", "" }, ActivityGiftInfo.class);
  public final PBUInt32Field is_activity_gift = PBField.initUInt32(0);
  public final PBStringField text = PBField.initString("");
  public final PBStringField text_color = PBField.initString("");
  public final PBStringField url = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.msg.hummer.resv.ResvAttrForGiftMsg.ActivityGiftInfo
 * JD-Core Version:    0.7.0.1
 */