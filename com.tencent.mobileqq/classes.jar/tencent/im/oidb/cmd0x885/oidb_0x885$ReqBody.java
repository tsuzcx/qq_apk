package tencent.im.oidb.cmd0x885;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x885$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_ad_user_info = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBEnumField enum_ad_display = PBField.initEnum(2);
  public oidb_0x885.AdReqInfo msg_ad_req_info = new oidb_0x885.AdReqInfo();
  public oidb_0x885.PhoneInfo msg_phone_info = new oidb_0x885.PhoneInfo();
  public oidb_0x885.VideoFloatInfo msg_video_float_info = new oidb_0x885.VideoFloatInfo();
  public final PBRepeatField<ByteStringMicro> rpt_bytes_req_row_key = PBField.initRepeat(PBBytesField.__repeatHelper__);
  public final PBUInt32Field uint32_user_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_channel_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_last_pull_time = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_seq = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  public oidb_0x885.UserLocation user_location = new oidb_0x885.UserLocation();
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40, 50, 58, 64, 74, 82, 90, 98, 104 }, new String[] { "uint64_uin", "msg_phone_info", "uint64_last_pull_time", "uint64_channel_id", "enum_ad_display", "msg_video_float_info", "rpt_bytes_req_row_key", "uint32_user_type", "user_location", "bytes_cookie", "bytes_ad_user_info", "msg_ad_req_info", "uint64_seq" }, new Object[] { Long.valueOf(0L), null, Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(2), null, localByteStringMicro1, Integer.valueOf(0), null, localByteStringMicro2, localByteStringMicro3, null, Long.valueOf(0L) }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x885.oidb_0x885.ReqBody
 * JD-Core Version:    0.7.0.1
 */