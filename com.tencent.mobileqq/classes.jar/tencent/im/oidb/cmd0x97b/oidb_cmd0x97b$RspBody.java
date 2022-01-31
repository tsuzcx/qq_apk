package tencent.im.oidb.cmd0x97b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0x97b$RspBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uint64_uin", "msg_follow_count_info", "msg_limit_info" }, new Object[] { Long.valueOf(0L), null, null }, RspBody.class);
  public oidb_cmd0x97b.FollowCountInfo msg_follow_count_info = new oidb_cmd0x97b.FollowCountInfo();
  public oidb_cmd0x97b.LimitInfo msg_limit_info = new oidb_cmd0x97b.LimitInfo();
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x97b.oidb_cmd0x97b.RspBody
 * JD-Core Version:    0.7.0.1
 */