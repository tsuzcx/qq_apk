package tencent.im.oidb.cmd0x857;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class GroupOpenSysMsg$SysMsgBody
  extends MessageMicro<SysMsgBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field appid = PBField.initUInt64(0L);
  public final PBStringField content = PBField.initString("");
  public final PBUInt64Field group_id = PBField.initUInt64(0L);
  public GroupOpenSysMsg.LightApp light_app = new GroupOpenSysMsg.LightApp();
  public final PBUInt32Field msg_type = PBField.initUInt32(0);
  public GroupOpenSysMsg.RichMsg rich_msg = new GroupOpenSysMsg.RichMsg();
  public GroupOpenSysMsg.Sender sender = new GroupOpenSysMsg.Sender();
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 42, 50, 58 }, new String[] { "group_id", "appid", "sender", "msg_type", "content", "rich_msg", "light_app" }, new Object[] { localLong, localLong, null, Integer.valueOf(0), "", null, null }, SysMsgBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x857.GroupOpenSysMsg.SysMsgBody
 * JD-Core Version:    0.7.0.1
 */