package tencent.im.oidb.cmd0xb57;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xb57$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "uint32_oper", "msg_get_top_quality_rsp", "msg_get_num_approve_state_rsp", "msg_get_num_approve_list_rsp" }, new Object[] { Integer.valueOf(0), null, null, null }, RspBody.class);
  public oidb_cmd0xb57.GetNumApproveListRspBody msg_get_num_approve_list_rsp = new oidb_cmd0xb57.GetNumApproveListRspBody();
  public oidb_cmd0xb57.GetNumApproveStateRspBody msg_get_num_approve_state_rsp = new oidb_cmd0xb57.GetNumApproveStateRspBody();
  public oidb_cmd0xb57.GetTopQualityNumRspBody msg_get_top_quality_rsp = new oidb_cmd0xb57.GetTopQualityNumRspBody();
  public final PBUInt32Field uint32_oper = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb57.oidb_cmd0xb57.RspBody
 * JD-Core Version:    0.7.0.1
 */