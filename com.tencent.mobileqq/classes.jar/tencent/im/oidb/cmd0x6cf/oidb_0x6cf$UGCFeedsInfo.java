package tencent.im.oidb.cmd0x6cf;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x6cf$UGCFeedsInfo
  extends MessageMicro<UGCFeedsInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32 }, new String[] { "ugc_feeds_info", "uint64_cuin", "msg_ugc_video_info_list", "uint32_follow_status" }, new Object[] { null, Long.valueOf(0L), null, Integer.valueOf(0) }, UGCFeedsInfo.class);
  public oidb_0x6cf.UGCVideoInfo msg_ugc_video_info_list = new oidb_0x6cf.UGCVideoInfo();
  public oidb_0x6cf.FeedsIdInfo ugc_feeds_info = new oidb_0x6cf.FeedsIdInfo();
  public final PBUInt32Field uint32_follow_status = PBField.initUInt32(0);
  public final PBUInt64Field uint64_cuin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x6cf.oidb_0x6cf.UGCFeedsInfo
 * JD-Core Version:    0.7.0.1
 */