package tencent.im.oidb.cmd0xd68;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class oidb_cmd0xd68$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42 }, new String[] { "int32_ret_code", "str_internal_err_msg", "forward_group_rsp", "forward_offline_rsp", "forward_data_wire_rsp" }, new Object[] { Integer.valueOf(0), "", null, null, null }, RspBody.class);
  public oidb_cmd0xd68.ForwardDataWireRspBody forward_data_wire_rsp = new oidb_cmd0xd68.ForwardDataWireRspBody();
  public oidb_cmd0xd68.ForwardGroupRspBody forward_group_rsp = new oidb_cmd0xd68.ForwardGroupRspBody();
  public oidb_cmd0xd68.ForwardOfflineFileRspBody forward_offline_rsp = new oidb_cmd0xd68.ForwardOfflineFileRspBody();
  public final PBInt32Field int32_ret_code = PBField.initInt32(0);
  public final PBStringField str_internal_err_msg = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xd68.oidb_cmd0xd68.RspBody
 * JD-Core Version:    0.7.0.1
 */