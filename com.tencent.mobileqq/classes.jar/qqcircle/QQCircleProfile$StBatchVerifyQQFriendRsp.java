package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class QQCircleProfile$StBatchVerifyQQFriendRsp
  extends MessageMicro<StBatchVerifyQQFriendRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "friendInfoList" }, new Object[] { null }, StBatchVerifyQQFriendRsp.class);
  public final PBRepeatMessageField<QQCircleProfile.StQQFriendInfo> friendInfoList = PBField.initRepeatMessage(QQCircleProfile.StQQFriendInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qqcircle.QQCircleProfile.StBatchVerifyQQFriendRsp
 * JD-Core Version:    0.7.0.1
 */