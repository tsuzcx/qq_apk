package tencent.im.cs.longconn.voip;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class hd_video_voip_2$CmdPhoneMultiChatCancelReqBody
  extends MessageMicro<CmdPhoneMultiChatCancelReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_conf_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public hd_video_voip_2.TelInfo msg_from_tel = new hd_video_voip_2.TelInfo();
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_from_tel", "bytes_conf_id" }, new Object[] { null, localByteStringMicro }, CmdPhoneMultiChatCancelReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.cs.longconn.voip.hd_video_voip_2.CmdPhoneMultiChatCancelReqBody
 * JD-Core Version:    0.7.0.1
 */