package tencent.im.cs.video.voip;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class hd_video_voip2$CmdPhoneMultiChatCreateRspBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_call_phone = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_call_prompt = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_conf_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField msg_not_support_to_tel = PBField.initRepeatMessage(hd_video_voip2.TelInfo.class);
  public final PBUInt32Field uint32_call_phone_type = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40 }, new String[] { "bytes_conf_id", "msg_not_support_to_tel", "bytes_call_prompt", "bytes_call_phone", "uint32_call_phone_type" }, new Object[] { localByteStringMicro1, null, localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0) }, CmdPhoneMultiChatCreateRspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.cs.video.voip.hd_video_voip2.CmdPhoneMultiChatCreateRspBody
 * JD-Core Version:    0.7.0.1
 */