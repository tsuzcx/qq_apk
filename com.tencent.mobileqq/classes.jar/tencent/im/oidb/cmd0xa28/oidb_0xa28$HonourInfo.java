package tencent.im.oidb.cmd0xa28;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_0xa28$HonourInfo
  extends MessageMicro<HonourInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_achieve_info", "msg_role_list" }, new Object[] { null, null }, HonourInfo.class);
  public oidb_0xa28.Achievement msg_achieve_info = new oidb_0xa28.Achievement();
  public final PBRepeatMessageField<oidb_0xa28.RoleInfo> msg_role_list = PBField.initRepeatMessage(oidb_0xa28.RoleInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xa28.oidb_0xa28.HonourInfo
 * JD-Core Version:    0.7.0.1
 */