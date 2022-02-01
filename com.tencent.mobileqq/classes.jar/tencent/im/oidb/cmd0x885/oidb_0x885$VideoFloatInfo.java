package tencent.im.oidb.cmd0x885;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x885$VideoFloatInfo
  extends MessageMicro<VideoFloatInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 40 }, new String[] { "uint32_ad_support", "uint32_info_num", "rpt_msg_ad_video_pos", "uint32_req_info_num", "uint32_req_vertical_video" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0) }, VideoFloatInfo.class);
  public final PBRepeatMessageField<oidb_0x885.AdVideoPos> rpt_msg_ad_video_pos = PBField.initRepeatMessage(oidb_0x885.AdVideoPos.class);
  public final PBUInt32Field uint32_ad_support = PBField.initUInt32(0);
  public final PBUInt32Field uint32_info_num = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_info_num = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_vertical_video = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0x885.oidb_0x885.VideoFloatInfo
 * JD-Core Version:    0.7.0.1
 */