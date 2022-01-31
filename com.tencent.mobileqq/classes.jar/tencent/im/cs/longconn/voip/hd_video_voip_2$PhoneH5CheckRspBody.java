package tencent.im.cs.longconn.voip;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class hd_video_voip_2$PhoneH5CheckRspBody
  extends MessageMicro<PhoneH5CheckRspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40 }, new String[] { "uint64_seq", "msg_from_tel", "msg_to_tel", "uint32_error_no", "uint64_balance" }, new Object[] { Long.valueOf(0L), null, null, Integer.valueOf(0), Long.valueOf(0L) }, PhoneH5CheckRspBody.class);
  public hd_video_voip_2.TelInfo msg_from_tel = new hd_video_voip_2.TelInfo();
  public hd_video_voip_2.TelInfo msg_to_tel = new hd_video_voip_2.TelInfo();
  public final PBUInt32Field uint32_error_no = PBField.initUInt32(0);
  public final PBUInt64Field uint64_balance = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_seq = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     tencent.im.cs.longconn.voip.hd_video_voip_2.PhoneH5CheckRspBody
 * JD-Core Version:    0.7.0.1
 */