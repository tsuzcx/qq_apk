package tencent.im.msg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class im_msg_body$ConferenceTipsInfo
  extends MessageMicro<ConferenceTipsInfo>
{
  public static final int ECONFST_BUDDY_AV = 2;
  public static final int ECONFST_DISCUSS_AV = 1;
  public static final int ECONFST_NONE = 0;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint32_session_type", "uint64_session_uin", "str_text" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), "" }, ConferenceTipsInfo.class);
  public final PBStringField str_text = PBField.initString("");
  public final PBUInt32Field uint32_session_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_session_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.msg.im_msg_body.ConferenceTipsInfo
 * JD-Core Version:    0.7.0.1
 */