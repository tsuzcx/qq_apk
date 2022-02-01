package tencent.im.nearfield_discuss;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class nearfield_discuss$RespJoinDiscuss
  extends MessageMicro<RespJoinDiscuss>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 48 }, new String[] { "msg_head", "str_number", "uint32_session_id", "uint32_discuss_id", "bool_is_creater", "uint32_join_type" }, new Object[] { null, "", Integer.valueOf(0), Integer.valueOf(0), Boolean.valueOf(false), Integer.valueOf(0) }, RespJoinDiscuss.class);
  public final PBBoolField bool_is_creater = PBField.initBool(false);
  public nearfield_discuss.BusiRespHead msg_head = new nearfield_discuss.BusiRespHead();
  public final PBStringField str_number = PBField.initString("");
  public final PBUInt32Field uint32_discuss_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_join_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_session_id = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.nearfield_discuss.nearfield_discuss.RespJoinDiscuss
 * JD-Core Version:    0.7.0.1
 */