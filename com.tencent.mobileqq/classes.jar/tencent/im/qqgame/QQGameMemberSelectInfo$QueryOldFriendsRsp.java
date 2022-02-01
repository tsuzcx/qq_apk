package tencent.im.qqgame;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class QQGameMemberSelectInfo$QueryOldFriendsRsp
  extends MessageMicro<QueryOldFriendsRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uinList" }, new Object[] { Long.valueOf(0L) }, QueryOldFriendsRsp.class);
  public final PBRepeatField<Long> uinList = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.qqgame.QQGameMemberSelectInfo.QueryOldFriendsRsp
 * JD-Core Version:    0.7.0.1
 */