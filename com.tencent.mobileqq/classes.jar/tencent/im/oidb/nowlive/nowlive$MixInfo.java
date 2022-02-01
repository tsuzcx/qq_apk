package tencent.im.oidb.nowlive;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class nowlive$MixInfo
  extends MessageMicro<MixInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "anchor_info", "live_info", "video_info" }, new Object[] { null, null, null }, MixInfo.class);
  public nowlive.AnchorInfo anchor_info = new nowlive.AnchorInfo();
  public nowlive.LiveInfo live_info = new nowlive.LiveInfo();
  public nowlive.VideoInfo video_info = new nowlive.VideoInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.nowlive.nowlive.MixInfo
 * JD-Core Version:    0.7.0.1
 */