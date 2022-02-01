package tencent.im.oidb.cmd0xaee;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class Oidb_0xaee$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "list_rsp", "admin_rsp" }, new Object[] { null, null }, RspBody.class);
  public Oidb_0xaee.AdminRsp admin_rsp = new Oidb_0xaee.AdminRsp();
  public Oidb_0xaee.ListRsp list_rsp = new Oidb_0xaee.ListRsp();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xaee.Oidb_0xaee.RspBody
 * JD-Core Version:    0.7.0.1
 */