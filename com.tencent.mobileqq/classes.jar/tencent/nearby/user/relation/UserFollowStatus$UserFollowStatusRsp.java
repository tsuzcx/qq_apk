package tencent.nearby.user.relation;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.nearby.common.nearby_common.ErrorInfo;

public final class UserFollowStatus$UserFollowStatusRsp
  extends MessageMicro<UserFollowStatusRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uin", "follow_status_info_list", "result" }, new Object[] { Long.valueOf(0L), null, null }, UserFollowStatusRsp.class);
  public final PBRepeatMessageField<UserFollowStatus.UserFollowStatusInfo> follow_status_info_list = PBField.initRepeatMessage(UserFollowStatus.UserFollowStatusInfo.class);
  public nearby_common.ErrorInfo result = new nearby_common.ErrorInfo();
  public final PBUInt64Field uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.nearby.user.relation.UserFollowStatus.UserFollowStatusRsp
 * JD-Core Version:    0.7.0.1
 */