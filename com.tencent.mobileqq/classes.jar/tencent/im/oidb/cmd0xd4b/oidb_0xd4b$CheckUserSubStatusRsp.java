package tencent.im.oidb.cmd0xd4b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_0xd4b$CheckUserSubStatusRsp
  extends MessageMicro<CheckUserSubStatusRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_subscribe_status" }, new Object[] { null }, CheckUserSubStatusRsp.class);
  public final PBRepeatMessageField<oidb_0xd4b.SubscribeStatus> rpt_subscribe_status = PBField.initRepeatMessage(oidb_0xd4b.SubscribeStatus.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xd4b.oidb_0xd4b.CheckUserSubStatusRsp
 * JD-Core Version:    0.7.0.1
 */