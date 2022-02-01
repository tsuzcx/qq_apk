package tencent.im.oidb.cmd0xb77;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xb77$ArkV1MsgBody
  extends MessageMicro<ArkV1MsgBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 48, 82, 90, 162 }, new String[] { "app", "view", "prompt", "ver", "desc", "feature_id", "meta", "items", "config" }, new Object[] { "", "", "", "", "", Integer.valueOf(0), "", null, "" }, ArkV1MsgBody.class);
  public final PBStringField app = PBField.initString("");
  public final PBStringField config = PBField.initString("");
  public final PBStringField desc = PBField.initString("");
  public final PBUInt32Field feature_id = PBField.initUInt32(0);
  public final PBRepeatMessageField<oidb_cmd0xb77.TemplateItem> items = PBField.initRepeatMessage(oidb_cmd0xb77.TemplateItem.class);
  public final PBStringField meta = PBField.initString("");
  public final PBStringField prompt = PBField.initString("");
  public final PBStringField ver = PBField.initString("");
  public final PBStringField view = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb77.oidb_cmd0xb77.ArkV1MsgBody
 * JD-Core Version:    0.7.0.1
 */