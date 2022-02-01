package tencent.im.oidb.cmd0xb77;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xb77$MiniAppMsgBody
  extends MessageMicro<MiniAppMsgBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 42, 50, 82 }, new String[] { "mini_app_appid", "mini_app_path", "web_page_url", "mini_app_type", "title", "desc", "json_str" }, new Object[] { Long.valueOf(0L), "", "", Integer.valueOf(0), "", "", "" }, MiniAppMsgBody.class);
  public final PBStringField desc = PBField.initString("");
  public final PBStringField json_str = PBField.initString("");
  public final PBUInt64Field mini_app_appid = PBField.initUInt64(0L);
  public final PBStringField mini_app_path = PBField.initString("");
  public final PBUInt32Field mini_app_type = PBField.initUInt32(0);
  public final PBStringField title = PBField.initString("");
  public final PBStringField web_page_url = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb77.oidb_cmd0xb77.MiniAppMsgBody
 * JD-Core Version:    0.7.0.1
 */