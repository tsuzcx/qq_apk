package tencent.im.oidb.cmd0xae9;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class Oidb_0xae9$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "get_list_req", "get_add_time_req" }, new Object[] { null, null }, ReqBody.class);
  public Oidb_0xae9.GetAddTimeReq get_add_time_req = new Oidb_0xae9.GetAddTimeReq();
  public Oidb_0xae9.GetListReq get_list_req = new Oidb_0xae9.GetListReq();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0xae9.Oidb_0xae9.ReqBody
 * JD-Core Version:    0.7.0.1
 */