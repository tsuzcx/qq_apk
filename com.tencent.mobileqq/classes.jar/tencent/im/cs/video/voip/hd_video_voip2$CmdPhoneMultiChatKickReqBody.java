package tencent.im.cs.video.voip;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class hd_video_voip2$CmdPhoneMultiChatKickReqBody
  extends MessageMicro<CmdPhoneMultiChatKickReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_conf_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public hd_video_voip2.TelInfo msg_from_tel = new hd_video_voip2.TelInfo();
  public final PBRepeatMessageField<hd_video_voip2.TelInfo> msg_kick_tel = PBField.initRepeatMessage(hd_video_voip2.TelInfo.class);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "msg_from_tel", "bytes_conf_id", "msg_kick_tel" }, new Object[] { null, localByteStringMicro, null }, CmdPhoneMultiChatKickReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.cs.video.voip.hd_video_voip2.CmdPhoneMultiChatKickReqBody
 * JD-Core Version:    0.7.0.1
 */