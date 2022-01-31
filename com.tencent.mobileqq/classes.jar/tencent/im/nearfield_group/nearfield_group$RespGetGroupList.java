package tencent.im.nearfield_group;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class nearfield_group$RespGetGroupList
  extends MessageMicro<RespGetGroupList>
{
  public static final int MSG_HEAD_FIELD_NUMBER = 1;
  public static final int RPT_MSG_GROUP_LIST_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_head", "rpt_msg_group_list" }, new Object[] { null, null }, RespGetGroupList.class);
  public nearfield_group.BusiRespHead msg_head = new nearfield_group.BusiRespHead();
  public final PBRepeatMessageField<nearfield_group.GroupProfile> rpt_msg_group_list = PBField.initRepeatMessage(nearfield_group.GroupProfile.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.nearfield_group.nearfield_group.RespGetGroupList
 * JD-Core Version:    0.7.0.1
 */