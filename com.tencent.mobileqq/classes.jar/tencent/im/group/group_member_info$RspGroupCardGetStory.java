package tencent.im.group;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class group_member_info$RspGroupCardGetStory
  extends MessageMicro<RspGroupCardGetStory>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "result", "flag", "video_info" }, new Object[] { null, Integer.valueOf(0), null }, RspGroupCardGetStory.class);
  public final PBUInt32Field flag = PBField.initUInt32(0);
  public group_member_info.ErrorInfo result = new group_member_info.ErrorInfo();
  public final PBRepeatMessageField<group_member_info.InfoCardVideoInfo> video_info = PBField.initRepeatMessage(group_member_info.InfoCardVideoInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.group.group_member_info.RspGroupCardGetStory
 * JD-Core Version:    0.7.0.1
 */