package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class QQCircleRelation$FollowListKeyType
  extends MessageMicro<FollowListKeyType>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "userId", "keyType" }, new Object[] { "", Integer.valueOf(0) }, FollowListKeyType.class);
  public final PBInt32Field keyType = PBField.initInt32(0);
  public final PBStringField userId = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     qqcircle.QQCircleRelation.FollowListKeyType
 * JD-Core Version:    0.7.0.1
 */