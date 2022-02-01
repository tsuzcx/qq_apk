package tencent.im.cs.longconn.voip;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class hd_video_voip_2$CmdPhoneMultiChatCreateReqBody
  extends MessageMicro<CmdPhoneMultiChatCreateReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "msg_from_tel", "msg_to_tel", "uint64_balance" }, new Object[] { null, null, Long.valueOf(0L) }, CmdPhoneMultiChatCreateReqBody.class);
  public hd_video_voip_2.TelInfo msg_from_tel = new hd_video_voip_2.TelInfo();
  public final PBRepeatMessageField<hd_video_voip_2.TelInfo> msg_to_tel = PBField.initRepeatMessage(hd_video_voip_2.TelInfo.class);
  public final PBUInt64Field uint64_balance = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.cs.longconn.voip.hd_video_voip_2.CmdPhoneMultiChatCreateReqBody
 * JD-Core Version:    0.7.0.1
 */