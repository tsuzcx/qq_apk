package tencent.im.cs.video.voip;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class hd_video_voip2$CmdPhoneCallBackReqBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_prvt_session = PBField.initBytes(ByteStringMicro.EMPTY);
  public hd_video_voip2.TelInfo msg_from_tel = new hd_video_voip2.TelInfo();
  public hd_video_voip2.TelInfo msg_to_tel = new hd_video_voip2.TelInfo();
  public final PBUInt32Field uint32_cost_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_balance = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_prvt_id = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 50 }, new String[] { "msg_from_tel", "msg_to_tel", "uint64_balance", "uint32_cost_type", "uint64_prvt_id", "bytes_prvt_session" }, new Object[] { null, null, Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro }, CmdPhoneCallBackReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.cs.video.voip.hd_video_voip2.CmdPhoneCallBackReqBody
 * JD-Core Version:    0.7.0.1
 */