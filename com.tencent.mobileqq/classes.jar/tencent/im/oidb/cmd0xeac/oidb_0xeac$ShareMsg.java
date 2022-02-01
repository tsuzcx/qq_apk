package tencent.im.oidb.cmd0xeac;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class oidb_0xeac$ShareMsg
  extends MessageMicro<ShareMsg>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 66, 74 }, new String[] { "type", "title", "summary", "brief", "url", "picture_url", "action", "source", "source_url" }, new Object[] { "", "", "", "", "", "", "", "", "" }, ShareMsg.class);
  public final PBStringField action = PBField.initString("");
  public final PBStringField brief = PBField.initString("");
  public final PBStringField picture_url = PBField.initString("");
  public final PBStringField source = PBField.initString("");
  public final PBStringField source_url = PBField.initString("");
  public final PBStringField summary = PBField.initString("");
  public final PBStringField title = PBField.initString("");
  public final PBStringField type = PBField.initString("");
  public final PBStringField url = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xeac.oidb_0xeac.ShareMsg
 * JD-Core Version:    0.7.0.1
 */