package tencent.nearby.user.relation;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class UserFollowStatus$UserFollowStatusReq
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uin", "dst_uin_list" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L) }, UserFollowStatusReq.class);
  public final PBRepeatField dst_uin_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     tencent.nearby.user.relation.UserFollowStatus.UserFollowStatusReq
 * JD-Core Version:    0.7.0.1
 */