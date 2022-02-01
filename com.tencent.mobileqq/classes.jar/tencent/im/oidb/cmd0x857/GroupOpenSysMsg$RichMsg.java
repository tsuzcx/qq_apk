package tencent.im.oidb.cmd0x857;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class GroupOpenSysMsg$RichMsg
  extends MessageMicro<RichMsg>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50 }, new String[] { "title", "desc", "brief", "cover", "url", "source" }, new Object[] { "", "", "", "", "", null }, RichMsg.class);
  public final PBStringField brief = PBField.initString("");
  public final PBStringField cover = PBField.initString("");
  public final PBStringField desc = PBField.initString("");
  public GroupOpenSysMsg.Source source = new GroupOpenSysMsg.Source();
  public final PBStringField title = PBField.initString("");
  public final PBStringField url = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x857.GroupOpenSysMsg.RichMsg
 * JD-Core Version:    0.7.0.1
 */