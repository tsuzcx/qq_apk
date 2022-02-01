package tencent.im.cs.longconn.voip;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class hd_video_voip_2$CmdPhoneMultiChatInviteReqBody
  extends MessageMicro<CmdPhoneMultiChatInviteReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_conf_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public hd_video_voip_2.TelInfo msg_from_tel = new hd_video_voip_2.TelInfo();
  public final PBRepeatMessageField<hd_video_voip_2.TelInfo> msg_invite_tel = PBField.initRepeatMessage(hd_video_voip_2.TelInfo.class);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "msg_from_tel", "bytes_conf_id", "msg_invite_tel" }, new Object[] { null, localByteStringMicro, null }, CmdPhoneMultiChatInviteReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.cs.longconn.voip.hd_video_voip_2.CmdPhoneMultiChatInviteReqBody
 * JD-Core Version:    0.7.0.1
 */