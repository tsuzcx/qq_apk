package tencent.im.oidb.cmd0xb40;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_0xb40$CheckFavoriteRspBody
  extends MessageMicro<CheckFavoriteRspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_rsp_items" }, new Object[] { null }, CheckFavoriteRspBody.class);
  public final PBRepeatMessageField<oidb_0xb40.CheckFavoriteRspItem> rpt_msg_rsp_items = PBField.initRepeatMessage(oidb_0xb40.CheckFavoriteRspItem.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb40.oidb_0xb40.CheckFavoriteRspBody
 * JD-Core Version:    0.7.0.1
 */