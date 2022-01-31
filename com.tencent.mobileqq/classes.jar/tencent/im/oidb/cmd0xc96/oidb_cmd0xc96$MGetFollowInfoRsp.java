package tencent.im.oidb.cmd0xc96;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_cmd0xc96$MGetFollowInfoRsp
  extends MessageMicro<MGetFollowInfoRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "follow_info" }, new Object[] { null }, MGetFollowInfoRsp.class);
  public final PBRepeatMessageField<oidb_cmd0xc96.FollowInfo> follow_info = PBField.initRepeatMessage(oidb_cmd0xc96.FollowInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0xc96.oidb_cmd0xc96.MGetFollowInfoRsp
 * JD-Core Version:    0.7.0.1
 */