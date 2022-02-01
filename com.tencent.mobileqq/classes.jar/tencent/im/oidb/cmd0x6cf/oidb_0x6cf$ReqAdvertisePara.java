package tencent.im.oidb.cmd0x6cf;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.cmd0x885.oidb_0x885.AdReqInfo;

public final class oidb_0x6cf$ReqAdvertisePara
  extends MessageMicro<ReqAdvertisePara>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_ad_user_info = PBField.initBytes(ByteStringMicro.EMPTY);
  public oidb_0x885.AdReqInfo msg_ad_req_info = new oidb_0x885.AdReqInfo();
  public oidb_0x6cf.PhoneInfo msg_phone_info = new oidb_0x6cf.PhoneInfo();
  public oidb_0x6cf.VideoFloatInfo msg_video_float_info = new oidb_0x6cf.VideoFloatInfo();
  public final PBUInt64Field uint64_last_time = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 42 }, new String[] { "msg_phone_info", "uint64_last_time", "msg_video_float_info", "msg_ad_req_info", "bytes_ad_user_info" }, new Object[] { null, Long.valueOf(0L), null, null, localByteStringMicro }, ReqAdvertisePara.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0x6cf.oidb_0x6cf.ReqAdvertisePara
 * JD-Core Version:    0.7.0.1
 */