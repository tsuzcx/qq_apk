package tencent.im.oidb.cmd0x5e9;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class GetPhotoList$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_uin_heads" }, new Object[] { null }, RspBody.class);
  public final PBRepeatMessageField<GetPhotoList.UinHeadInfo> rpt_msg_uin_heads = PBField.initRepeatMessage(GetPhotoList.UinHeadInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x5e9.GetPhotoList.RspBody
 * JD-Core Version:    0.7.0.1
 */