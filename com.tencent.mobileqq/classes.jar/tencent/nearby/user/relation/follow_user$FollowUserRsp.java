package tencent.nearby.user.relation;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.nearby.common.nearby_common.ErrorInfo;

public final class follow_user$FollowUserRsp
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uin", "dst_uin", "result" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), null }, FollowUserRsp.class);
  public final PBUInt64Field dst_uin = PBField.initUInt64(0L);
  public nearby_common.ErrorInfo result = new nearby_common.ErrorInfo();
  public final PBUInt64Field uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     tencent.nearby.user.relation.follow_user.FollowUserRsp
 * JD-Core Version:    0.7.0.1
 */