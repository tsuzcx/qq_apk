package tencent.im.oidb.cmd0x703;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class cmd0x703$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_uin_photo_list" }, new Object[] { null }, RspBody.class);
  public final PBRepeatMessageField<cmd0x703.UinPhotoListInfo> rpt_msg_uin_photo_list = PBField.initRepeatMessage(cmd0x703.UinPhotoListInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x703.cmd0x703.RspBody
 * JD-Core Version:    0.7.0.1
 */