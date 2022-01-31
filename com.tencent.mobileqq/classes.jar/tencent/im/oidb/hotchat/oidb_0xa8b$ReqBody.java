package tencent.im.oidb.hotchat;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xa8b$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "rpt_msg_store_poid", "rpt_msg_delete_poid", "uint32_start_num" }, new Object[] { null, null, Integer.valueOf(0) }, ReqBody.class);
  public final PBRepeatMessageField<oidb_0xa8b.DeletePoid> rpt_msg_delete_poid = PBField.initRepeatMessage(oidb_0xa8b.DeletePoid.class);
  public final PBRepeatMessageField<oidb_0xa8b.StorePoid> rpt_msg_store_poid = PBField.initRepeatMessage(oidb_0xa8b.StorePoid.class);
  public final PBUInt32Field uint32_start_num = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.hotchat.oidb_0xa8b.ReqBody
 * JD-Core Version:    0.7.0.1
 */