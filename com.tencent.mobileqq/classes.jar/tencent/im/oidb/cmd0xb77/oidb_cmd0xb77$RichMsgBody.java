package tencent.im.oidb.cmd0xb77;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class oidb_cmd0xb77$RichMsgBody
  extends MessageMicro<RichMsgBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 82, 90, 98, 106, 114, 122, 130, 170 }, new String[] { "using_ark", "title", "summary", "brief", "url", "picture_url", "action", "music_url", "image_info" }, new Object[] { Boolean.valueOf(false), "", "", "", "", "", "", "", null }, RichMsgBody.class);
  public final PBStringField action = PBField.initString("");
  public final PBStringField brief = PBField.initString("");
  public oidb_cmd0xb77.ImageInfo image_info = new oidb_cmd0xb77.ImageInfo();
  public final PBStringField music_url = PBField.initString("");
  public final PBStringField picture_url = PBField.initString("");
  public final PBStringField summary = PBField.initString("");
  public final PBStringField title = PBField.initString("");
  public final PBStringField url = PBField.initString("");
  public final PBBoolField using_ark = PBField.initBool(false);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb77.oidb_cmd0xb77.RichMsgBody
 * JD-Core Version:    0.7.0.1
 */