package tencent.gdt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class MsgType0x210_SubMsgType0x13c$MsgContent
  extends MessageMicro<MsgContent>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50 }, new String[] { "str_msg_id", "str_title", "str_content", "str_button_txt", "str_img_url", "ad_info" }, new Object[] { "", "", "", "", "", null }, MsgContent.class);
  public qq_ad_get.QQAdGetRsp.AdInfo ad_info = new qq_ad_get.QQAdGetRsp.AdInfo();
  public final PBStringField str_button_txt = PBField.initString("");
  public final PBStringField str_content = PBField.initString("");
  public final PBStringField str_img_url = PBField.initString("");
  public final PBStringField str_msg_id = PBField.initString("");
  public final PBStringField str_title = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.gdt.MsgType0x210_SubMsgType0x13c.MsgContent
 * JD-Core Version:    0.7.0.1
 */