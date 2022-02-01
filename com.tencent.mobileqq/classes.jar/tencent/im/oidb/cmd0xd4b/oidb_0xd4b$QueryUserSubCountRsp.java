package tencent.im.oidb.cmd0xd4b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_0xd4b$QueryUserSubCountRsp
  extends MessageMicro<QueryUserSubCountRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_user_sub_count" }, new Object[] { null }, QueryUserSubCountRsp.class);
  public final PBRepeatMessageField<oidb_0xd4b.UserSubCount> rpt_msg_user_sub_count = PBField.initRepeatMessage(oidb_0xd4b.UserSubCount.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0xd4b.oidb_0xd4b.QueryUserSubCountRsp
 * JD-Core Version:    0.7.0.1
 */