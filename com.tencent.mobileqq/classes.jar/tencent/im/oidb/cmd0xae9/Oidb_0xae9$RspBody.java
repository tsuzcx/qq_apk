package tencent.im.oidb.cmd0xae9;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class Oidb_0xae9$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "get_list_rsp", "get_add_time_rsp" }, new Object[] { null, null }, RspBody.class);
  public Oidb_0xae9.GetAddTimeRsp get_add_time_rsp = new Oidb_0xae9.GetAddTimeRsp();
  public Oidb_0xae9.GetListRsp get_list_rsp = new Oidb_0xae9.GetListRsp();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xae9.Oidb_0xae9.RspBody
 * JD-Core Version:    0.7.0.1
 */