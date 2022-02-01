package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class QQCircleProfile$StGetQQFriendListRsp
  extends MessageMicro<StGetQQFriendListRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "friendList" }, new Object[] { Integer.valueOf(0) }, StGetQQFriendListRsp.class);
  public final PBRepeatField<Integer> friendList = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qqcircle.QQCircleProfile.StGetQQFriendListRsp
 * JD-Core Version:    0.7.0.1
 */