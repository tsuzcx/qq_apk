package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class QQCircleProfile$StGetQQFriendListReq
  extends MessageMicro<StGetQQFriendListReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uin", "circleUser" }, new Object[] { Integer.valueOf(0), Boolean.valueOf(false) }, StGetQQFriendListReq.class);
  public final PBBoolField circleUser = PBField.initBool(false);
  public final PBUInt32Field uin = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qqcircle.QQCircleProfile.StGetQQFriendListReq
 * JD-Core Version:    0.7.0.1
 */