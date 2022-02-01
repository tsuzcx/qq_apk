package tencent.nearby.user.relation;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class UserFollowStatus$UserFollowStatusReq
  extends MessageMicro<UserFollowStatusReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatField<Long> dst_uin_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uin", "dst_uin_list" }, new Object[] { localLong, localLong }, UserFollowStatusReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.nearby.user.relation.UserFollowStatus.UserFollowStatusReq
 * JD-Core Version:    0.7.0.1
 */