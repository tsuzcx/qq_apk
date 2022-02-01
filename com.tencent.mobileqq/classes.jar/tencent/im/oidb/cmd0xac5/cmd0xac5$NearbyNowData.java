package tencent.im.oidb.cmd0xac5;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0xac5$NearbyNowData
  extends MessageMicro<NearbyNowData>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_more_anchor_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_more_video_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field is_authen = PBField.initInt32(0);
  public final PBRepeatMessageField<cmd0xac5.NearbyLabelInfo> label_info = PBField.initRepeatMessage(cmd0xac5.NearbyLabelInfo.class);
  public cmd0xac5.MasterState master_state = new cmd0xac5.MasterState();
  public cmd0xac5.NowConfig msg_now_config = new cmd0xac5.NowConfig();
  public cmd0xac5.NowAnchorState now_anchor_state = new cmd0xac5.NowAnchorState();
  public final PBInt32Field now_msg_switch = PBField.initInt32(0);
  public final PBRepeatMessageField<cmd0xac5.NowFollowAnchor> rpt_msg_now_follow_anchor = PBField.initRepeatMessage(cmd0xac5.NowFollowAnchor.class);
  public final PBRepeatMessageField<cmd0xac5.NowHaiWan> rpt_msg_now_haiwan = PBField.initRepeatMessage(cmd0xac5.NowHaiWan.class);
  public final PBRepeatMessageField<cmd0xac5.NowVideoFeed> rpt_msg_now_video_feed = PBField.initRepeatMessage(cmd0xac5.NowVideoFeed.class);
  public final PBUInt64Field uint64_uid = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 66, 74, 80, 88, 96 }, new String[] { "rpt_msg_now_haiwan", "rpt_msg_now_follow_anchor", "rpt_msg_now_video_feed", "bytes_more_anchor_url", "bytes_more_video_url", "msg_now_config", "master_state", "now_anchor_state", "label_info", "is_authen", "now_msg_switch", "uint64_uid" }, new Object[] { null, null, null, localByteStringMicro1, localByteStringMicro2, null, null, null, null, localInteger, localInteger, Long.valueOf(0L) }, NearbyNowData.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xac5.cmd0xac5.NearbyNowData
 * JD-Core Version:    0.7.0.1
 */