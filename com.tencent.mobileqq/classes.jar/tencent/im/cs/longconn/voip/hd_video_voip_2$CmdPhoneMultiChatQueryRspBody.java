package tencent.im.cs.longconn.voip;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class hd_video_voip_2$CmdPhoneMultiChatQueryRspBody
  extends MessageMicro<CmdPhoneMultiChatQueryRspBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_conf_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField<hd_video_voip_2.TelInfo> msg_chating_tel = PBField.initRepeatMessage(hd_video_voip_2.TelInfo.class);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "bytes_conf_id", "msg_chating_tel" }, new Object[] { localByteStringMicro, null }, CmdPhoneMultiChatQueryRspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     tencent.im.cs.longconn.voip.hd_video_voip_2.CmdPhoneMultiChatQueryRspBody
 * JD-Core Version:    0.7.0.1
 */