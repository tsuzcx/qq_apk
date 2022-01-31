package tencent.im.oidb.cmd0xac5;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class cmd0xac5$NearbyNowData
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_more_anchor_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_more_video_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public cmd0xac5.MasterState master_state = new cmd0xac5.MasterState();
  public cmd0xac5.NowConfig msg_now_config = new cmd0xac5.NowConfig();
  public cmd0xac5.NowAnchorState now_anchor_state = new cmd0xac5.NowAnchorState();
  public final PBRepeatMessageField rpt_msg_now_follow_anchor = PBField.initRepeatMessage(cmd0xac5.NowFollowAnchor.class);
  public final PBRepeatMessageField rpt_msg_now_haiwan = PBField.initRepeatMessage(cmd0xac5.NowHaiWan.class);
  public final PBRepeatMessageField rpt_msg_now_video_feed = PBField.initRepeatMessage(cmd0xac5.NowVideoFeed.class);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 66 }, new String[] { "rpt_msg_now_haiwan", "rpt_msg_now_follow_anchor", "rpt_msg_now_video_feed", "bytes_more_anchor_url", "bytes_more_video_url", "msg_now_config", "master_state", "now_anchor_state" }, new Object[] { null, null, null, localByteStringMicro1, localByteStringMicro2, null, null, null }, NearbyNowData.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0xac5.cmd0xac5.NearbyNowData
 * JD-Core Version:    0.7.0.1
 */