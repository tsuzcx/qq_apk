package tencent.im.oidb.olympic;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class cmd0x6f0$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_torchbearer_list" }, new Object[] { null }, RspBody.class);
  public final PBRepeatMessageField<torch_transfer.TorchbearerInfo> rpt_torchbearer_list = PBField.initRepeatMessage(torch_transfer.TorchbearerInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.olympic.cmd0x6f0.RspBody
 * JD-Core Version:    0.7.0.1
 */