package tencent.im.cs.video.voip;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class hd_video_voip2$PhoneH5CheckReqBody
  extends MessageMicro<PhoneH5CheckReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public hd_video_voip2.TelInfo msg_from_tel = new hd_video_voip2.TelInfo();
  public hd_video_voip2.TelInfo msg_to_tel = new hd_video_voip2.TelInfo();
  public final PBUInt64Field uint64_prvt_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_seq = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32 }, new String[] { "uint64_seq", "msg_from_tel", "msg_to_tel", "uint64_prvt_id" }, new Object[] { localLong, null, null, localLong }, PhoneH5CheckReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.cs.video.voip.hd_video_voip2.PhoneH5CheckReqBody
 * JD-Core Version:    0.7.0.1
 */