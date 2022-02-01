package tencent.im.group.broadcast;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class BroadcastMsgCtr$ExtJoinGroupInfo
  extends MessageMicro<ExtJoinGroupInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "enmum_join_group_type", "uint64_share_uin" }, new Object[] { Integer.valueOf(1), Long.valueOf(0L) }, ExtJoinGroupInfo.class);
  public final PBEnumField enmum_join_group_type = PBField.initEnum(1);
  public final PBUInt64Field uint64_share_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.group.broadcast.BroadcastMsgCtr.ExtJoinGroupInfo
 * JD-Core Version:    0.7.0.1
 */