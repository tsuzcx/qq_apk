package tencent.im.oidb.cmd0x977;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_cmd0x977$FollowListInfo
  extends MessageMicro<FollowListInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 90 }, new String[] { "uint32_follow_list_type", "rpt_follow_status_info" }, new Object[] { Integer.valueOf(1), null }, FollowListInfo.class);
  public final PBRepeatMessageField<oidb_cmd0x977.FollowStatusInfo> rpt_follow_status_info = PBField.initRepeatMessage(oidb_cmd0x977.FollowStatusInfo.class);
  public final PBEnumField uint32_follow_list_type = PBField.initEnum(1);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x977.oidb_cmd0x977.FollowListInfo
 * JD-Core Version:    0.7.0.1
 */