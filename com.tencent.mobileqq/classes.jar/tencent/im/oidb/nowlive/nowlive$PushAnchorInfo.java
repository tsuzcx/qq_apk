package tencent.im.oidb.nowlive;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class nowlive$PushAnchorInfo
  extends MessageMicro<PushAnchorInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32 }, new String[] { "msg_type", "anchor_info", "live_info", "timestamp" }, new Object[] { Integer.valueOf(0), null, null, Long.valueOf(0L) }, PushAnchorInfo.class);
  public nowlive.AnchorInfo anchor_info = new nowlive.AnchorInfo();
  public nowlive.LiveInfo live_info = new nowlive.LiveInfo();
  public final PBUInt32Field msg_type = PBField.initUInt32(0);
  public final PBUInt64Field timestamp = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.nowlive.nowlive.PushAnchorInfo
 * JD-Core Version:    0.7.0.1
 */