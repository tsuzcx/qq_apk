package tencent.im.oidb.cmd0xd68;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class oidb_cmd0xd68$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "forward_group_req", "forward_offline_req", "forward_data_wire_req" }, new Object[] { null, null, null }, ReqBody.class);
  public oidb_cmd0xd68.ForwardDataWireReqBody forward_data_wire_req = new oidb_cmd0xd68.ForwardDataWireReqBody();
  public oidb_cmd0xd68.ForwardGroupReqBody forward_group_req = new oidb_cmd0xd68.ForwardGroupReqBody();
  public oidb_cmd0xd68.ForwardOfflineFileReqBody forward_offline_req = new oidb_cmd0xd68.ForwardOfflineFileReqBody();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xd68.oidb_cmd0xd68.ReqBody
 * JD-Core Version:    0.7.0.1
 */