package tencent.im.oidb.cmd0x435;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_0x435$GetAllPKItemsRspBody
  extends MessageMicro<GetAllPKItemsRspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_pk_item" }, new Object[] { null }, GetAllPKItemsRspBody.class);
  public final PBRepeatMessageField<oidb_0x435.PKItem> rpt_msg_pk_item = PBField.initRepeatMessage(oidb_0x435.PKItem.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0x435.oidb_0x435.GetAllPKItemsRspBody
 * JD-Core Version:    0.7.0.1
 */