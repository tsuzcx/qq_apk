package tencent.im.oidb.cmd0xb57;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xb57$GetNumApproveListRspBody
  extends MessageMicro<GetNumApproveListRspBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatMessageField<oidb_cmd0xb57.NumApproveStateItem> rpt_msg_num_approve_state_items = PBField.initRepeatMessage(oidb_cmd0xb57.NumApproveStateItem.class);
  public final PBUInt32Field uint32_isend = PBField.initUInt32(0);
  public final PBUInt32Field uint32_next_index = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint32_isend", "uint32_next_index", "rpt_msg_num_approve_state_items" }, new Object[] { localInteger, localInteger, null }, GetNumApproveListRspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb57.oidb_cmd0xb57.GetNumApproveListRspBody
 * JD-Core Version:    0.7.0.1
 */