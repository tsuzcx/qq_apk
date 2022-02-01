package tencent.im.qqgame;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class QQGameMemberSelectInfo$QueryOldFriendsReq
  extends MessageMicro<QueryOldFriendsReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "groupCode" }, new Object[] { Long.valueOf(0L) }, QueryOldFriendsReq.class);
  public final PBUInt64Field groupCode = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.qqgame.QQGameMemberSelectInfo.QueryOldFriendsReq
 * JD-Core Version:    0.7.0.1
 */