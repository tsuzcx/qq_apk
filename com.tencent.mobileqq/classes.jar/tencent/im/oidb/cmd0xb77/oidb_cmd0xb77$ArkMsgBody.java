package tencent.im.oidb.cmd0xb77;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xb77$ArkMsgBody
  extends MessageMicro<ArkMsgBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 48, 82, 90, 98, 106, 114, 122, 130, 162 }, new String[] { "app", "view", "prompt", "ver", "desc", "feature_id", "meta", "meta_url1", "meta_url2", "meta_url3", "meta_text1", "meta_text2", "meta_text3", "config" }, new Object[] { "", "", "", "", "", Integer.valueOf(0), "", "", "", "", "", "", "", "" }, ArkMsgBody.class);
  public final PBStringField app = PBField.initString("");
  public final PBStringField config = PBField.initString("");
  public final PBStringField desc = PBField.initString("");
  public final PBUInt32Field feature_id = PBField.initUInt32(0);
  public final PBStringField meta = PBField.initString("");
  public final PBStringField meta_text1 = PBField.initString("");
  public final PBStringField meta_text2 = PBField.initString("");
  public final PBStringField meta_text3 = PBField.initString("");
  public final PBStringField meta_url1 = PBField.initString("");
  public final PBStringField meta_url2 = PBField.initString("");
  public final PBStringField meta_url3 = PBField.initString("");
  public final PBStringField prompt = PBField.initString("");
  public final PBStringField ver = PBField.initString("");
  public final PBStringField view = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb77.oidb_cmd0xb77.ArkMsgBody
 * JD-Core Version:    0.7.0.1
 */