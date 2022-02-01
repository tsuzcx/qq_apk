package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class QQCircleRelation$AddFriendAuthReqBody
  extends MessageMicro<AddFriendAuthReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatMessageField<QQCircleRelation.ExtendInfo> extInfos = PBField.initRepeatMessage(QQCircleRelation.ExtendInfo.class);
  public final PBStringField source = PBField.initString("");
  public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_to_uin = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34 }, new String[] { "uint64_from_uin", "uint64_to_uin", "source", "extInfos" }, new Object[] { localLong, localLong, "", null }, AddFriendAuthReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     qqcircle.QQCircleRelation.AddFriendAuthReqBody
 * JD-Core Version:    0.7.0.1
 */