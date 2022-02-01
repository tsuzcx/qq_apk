package tencent.im.group_pro_proto.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class common$Meta
  extends MessageMicro<Meta>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "from_uin", "login_sig" }, new Object[] { Long.valueOf(0L), null }, Meta.class);
  public final PBUInt64Field from_uin = PBField.initUInt64(0L);
  public common.LoginSig login_sig = new common.LoginSig();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.group_pro_proto.common.common.Meta
 * JD-Core Version:    0.7.0.1
 */