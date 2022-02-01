package tencent.im.oidb.cmd0xdb1;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class oidb_0xdb1$matchTaskInfo
  extends MessageMicro<matchTaskInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42 }, new String[] { "msg_base_info", "msg_kuolie_school", "msg_kuolie_declaration", "msg_personal_label", "msg_photo" }, new Object[] { null, null, null, null, null }, matchTaskInfo.class);
  public oidb_0xdb1.oneTask msg_base_info = new oidb_0xdb1.oneTask();
  public oidb_0xdb1.oneTask msg_kuolie_declaration = new oidb_0xdb1.oneTask();
  public oidb_0xdb1.oneTask msg_kuolie_school = new oidb_0xdb1.oneTask();
  public oidb_0xdb1.oneTask msg_personal_label = new oidb_0xdb1.oneTask();
  public oidb_0xdb1.oneTask msg_photo = new oidb_0xdb1.oneTask();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xdb1.oidb_0xdb1.matchTaskInfo
 * JD-Core Version:    0.7.0.1
 */