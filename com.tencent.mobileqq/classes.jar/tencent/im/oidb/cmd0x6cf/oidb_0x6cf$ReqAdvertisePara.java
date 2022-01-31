package tencent.im.oidb.cmd0x6cf;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x6cf$ReqAdvertisePara
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "msg_phone_info", "uint64_last_time", "msg_video_float_info" }, new Object[] { null, Long.valueOf(0L), null }, ReqAdvertisePara.class);
  public oidb_0x6cf.PhoneInfo msg_phone_info = new oidb_0x6cf.PhoneInfo();
  public oidb_0x6cf.VideoFloatInfo msg_video_float_info = new oidb_0x6cf.VideoFloatInfo();
  public final PBUInt64Field uint64_last_time = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x6cf.oidb_0x6cf.ReqAdvertisePara
 * JD-Core Version:    0.7.0.1
 */