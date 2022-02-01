package tencent.im.cs.longconn.voip;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class hd_video_voip_2$CmdPhoneBindReqBody
  extends MessageMicro<CmdPhoneBindReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatField<ByteStringMicro> bytes_last_call_id = PBField.initRepeat(PBBytesField.__repeatHelper__);
  public final PBBytesField bytes_prvt_session = PBField.initBytes(ByteStringMicro.EMPTY);
  public hd_video_voip_2.TelInfo msg_from_tel = new hd_video_voip_2.TelInfo();
  public hd_video_voip_2.SpeedTestInfo msg_speed_test_info = new hd_video_voip_2.SpeedTestInfo();
  public hd_video_voip_2.TelInfo msg_to_tel = new hd_video_voip_2.TelInfo();
  public final PBUInt32Field uint32_call_policy = PBField.initUInt32(0);
  public final PBUInt32Field uint32_from_flag = PBField.initUInt32(0);
  public final PBUInt64Field uint64_prvt_id = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 42, 48, 58, 66 }, new String[] { "uint32_from_flag", "msg_from_tel", "msg_to_tel", "uint32_call_policy", "msg_speed_test_info", "uint64_prvt_id", "bytes_prvt_session", "bytes_last_call_id" }, new Object[] { localInteger, null, null, localInteger, null, Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2 }, CmdPhoneBindReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.cs.longconn.voip.hd_video_voip_2.CmdPhoneBindReqBody
 * JD-Core Version:    0.7.0.1
 */