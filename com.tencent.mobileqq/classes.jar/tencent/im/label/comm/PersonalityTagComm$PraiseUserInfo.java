package tencent.im.label.comm;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class PersonalityTagComm$PraiseUserInfo
  extends MessageMicro<PraiseUserInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint64_praise_uin", "str_nick" }, new Object[] { Long.valueOf(0L), "" }, PraiseUserInfo.class);
  public final PBStringField str_nick = PBField.initString("");
  public final PBUInt64Field uint64_praise_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     tencent.im.label.comm.PersonalityTagComm.PraiseUserInfo
 * JD-Core Version:    0.7.0.1
 */