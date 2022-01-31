package tencent.im.oidb.cmd0x857;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class GroupOpenSysMsg$LightApp
  extends MessageMicro<LightApp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 66 }, new String[] { "app", "view", "desc", "prompt", "ver", "meta", "config", "source" }, new Object[] { "", "", "", "", "", "", "", null }, LightApp.class);
  public final PBStringField app = PBField.initString("");
  public final PBStringField config = PBField.initString("");
  public final PBStringField desc = PBField.initString("");
  public final PBStringField meta = PBField.initString("");
  public final PBStringField prompt = PBField.initString("");
  public GroupOpenSysMsg.Source source = new GroupOpenSysMsg.Source();
  public final PBStringField ver = PBField.initString("");
  public final PBStringField view = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x857.GroupOpenSysMsg.LightApp
 * JD-Core Version:    0.7.0.1
 */