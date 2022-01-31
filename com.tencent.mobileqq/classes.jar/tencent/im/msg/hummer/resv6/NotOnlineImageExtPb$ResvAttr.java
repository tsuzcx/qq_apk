package tencent.im.msg.hummer.resv6;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class NotOnlineImageExtPb$ResvAttr
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 50 }, new String[] { "uint32_image_biz_type", "uint32_customface_type", "uint32_emoji_packageid", "uint32_emoji_id", "string_text", "string_doutu_suppliers" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", "" }, ResvAttr.class);
  public final PBStringField string_doutu_suppliers = PBField.initString("");
  public final PBStringField string_text = PBField.initString("");
  public final PBUInt32Field uint32_customface_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_emoji_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_emoji_packageid = PBField.initUInt32(0);
  public final PBUInt32Field uint32_image_biz_type = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.msg.hummer.resv6.NotOnlineImageExtPb.ResvAttr
 * JD-Core Version:    0.7.0.1
 */