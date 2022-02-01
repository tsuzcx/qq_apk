package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class QQCircleProfile$StBatchVerifyQQFriendReq
  extends MessageMicro<StBatchVerifyQQFriendReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uinList" }, new Object[] { Integer.valueOf(0) }, StBatchVerifyQQFriendReq.class);
  public final PBRepeatField<Integer> uinList = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qqcircle.QQCircleProfile.StBatchVerifyQQFriendReq
 * JD-Core Version:    0.7.0.1
 */