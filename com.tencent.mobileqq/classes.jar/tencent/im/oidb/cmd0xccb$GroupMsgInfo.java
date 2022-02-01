package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0xccb$GroupMsgInfo
  extends MessageMicro<GroupMsgInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "msg_seq", "roam_flag" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, GroupMsgInfo.class);
  public final PBUInt32Field msg_seq = PBField.initUInt32(0);
  public final PBUInt32Field roam_flag = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0xccb.GroupMsgInfo
 * JD-Core Version:    0.7.0.1
 */