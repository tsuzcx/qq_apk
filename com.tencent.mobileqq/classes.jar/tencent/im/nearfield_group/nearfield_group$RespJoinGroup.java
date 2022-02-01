package tencent.im.nearfield_group;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class nearfield_group$RespJoinGroup
  extends MessageMicro<RespJoinGroup>
{
  public static final int MSG_HEAD_FIELD_NUMBER = 1;
  public static final int UINT64_GROUP_CODE_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "msg_head", "uint64_group_code" }, new Object[] { null, Long.valueOf(0L) }, RespJoinGroup.class);
  public nearfield_group.BusiRespHead msg_head = new nearfield_group.BusiRespHead();
  public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.nearfield_group.nearfield_group.RespJoinGroup
 * JD-Core Version:    0.7.0.1
 */