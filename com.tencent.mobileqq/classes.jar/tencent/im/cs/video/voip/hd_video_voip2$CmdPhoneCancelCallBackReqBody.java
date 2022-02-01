package tencent.im.cs.video.voip;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class hd_video_voip2$CmdPhoneCancelCallBackReqBody
  extends MessageMicro<CmdPhoneCancelCallBackReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_call_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public hd_video_voip2.TelInfo msg_from_tel = new hd_video_voip2.TelInfo();
  public hd_video_voip2.TelInfo msg_to_tel = new hd_video_voip2.TelInfo();
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "msg_from_tel", "msg_to_tel", "bytes_call_id" }, new Object[] { null, null, localByteStringMicro }, CmdPhoneCancelCallBackReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.cs.video.voip.hd_video_voip2.CmdPhoneCancelCallBackReqBody
 * JD-Core Version:    0.7.0.1
 */