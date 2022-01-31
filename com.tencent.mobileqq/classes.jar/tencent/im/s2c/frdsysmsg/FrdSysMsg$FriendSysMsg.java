package tencent.im.s2c.frdsysmsg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class FrdSysMsg$FriendSysMsg
  extends MessageMicro<FriendSysMsg>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 90, 98, 106, 800 }, new String[] { "msg_group_ext", "msg_intite_info", "msg_school_info", "uint32_doubt_flag" }, new Object[] { null, null, null, Integer.valueOf(0) }, FriendSysMsg.class);
  public FrdSysMsg.GroupInfoExt msg_group_ext = new FrdSysMsg.GroupInfoExt();
  public FrdSysMsg.InviteInfo msg_intite_info = new FrdSysMsg.InviteInfo();
  public FrdSysMsg.SchoolInfo msg_school_info = new FrdSysMsg.SchoolInfo();
  public final PBUInt32Field uint32_doubt_flag = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.s2c.frdsysmsg.FrdSysMsg.FriendSysMsg
 * JD-Core Version:    0.7.0.1
 */