package tencent.im.oidb.nowlive;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class nowlive$GetAnchorFansReq
  extends MessageMicro<GetAnchorFansReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "anchor_info" }, new Object[] { null }, GetAnchorFansReq.class);
  public nowlive.AnchorInfo anchor_info = new nowlive.AnchorInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.nowlive.nowlive.GetAnchorFansReq
 * JD-Core Version:    0.7.0.1
 */