package tencent.im.msgrevoke;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class msgrevoke_userdef$MsgInfoUserDef
  extends MessageMicro<MsgInfoUserDef>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uint32_long_message_flag", "long_msg_info", "str_file_uuid" }, new Object[] { Integer.valueOf(0), null, "" }, MsgInfoUserDef.class);
  public final PBRepeatMessageField<msgrevoke_userdef.MsgInfoUserDef.MsgInfoDef> long_msg_info = PBField.initRepeatMessage(msgrevoke_userdef.MsgInfoUserDef.MsgInfoDef.class);
  public final PBRepeatField<String> str_file_uuid = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBUInt32Field uint32_long_message_flag = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.msgrevoke.msgrevoke_userdef.MsgInfoUserDef
 * JD-Core Version:    0.7.0.1
 */