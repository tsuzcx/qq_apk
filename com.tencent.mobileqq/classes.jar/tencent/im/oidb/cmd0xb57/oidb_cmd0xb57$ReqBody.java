package tencent.im.oidb.cmd0xb57;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xb57$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "uint32_oper", "msg_get_top_quality_req", "msg_get_num_approve_state_req", "msg_get_num_approve_list_req" }, new Object[] { Integer.valueOf(0), null, null, null }, ReqBody.class);
  public oidb_cmd0xb57.GetNumApproveListReqBody msg_get_num_approve_list_req = new oidb_cmd0xb57.GetNumApproveListReqBody();
  public oidb_cmd0xb57.GetNumApproveStateReqBody msg_get_num_approve_state_req = new oidb_cmd0xb57.GetNumApproveStateReqBody();
  public oidb_cmd0xb57.GetTopQualityNumReqBody msg_get_top_quality_req = new oidb_cmd0xb57.GetTopQualityNumReqBody();
  public final PBUInt32Field uint32_oper = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb57.oidb_cmd0xb57.ReqBody
 * JD-Core Version:    0.7.0.1
 */