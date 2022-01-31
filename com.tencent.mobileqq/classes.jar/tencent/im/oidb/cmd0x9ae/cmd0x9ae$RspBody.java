package tencent.im.oidb.cmd0x9ae;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;

public final class cmd0x9ae$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "bool_has_been_authenticated", "bool_need_auth_tips", "msg_auth_tips" }, new Object[] { Boolean.valueOf(false), Boolean.valueOf(false), null }, RspBody.class);
  public final PBBoolField bool_has_been_authenticated = PBField.initBool(false);
  public final PBBoolField bool_need_auth_tips = PBField.initBool(false);
  public cmd0x9ae.AuthTips msg_auth_tips = new cmd0x9ae.AuthTips();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0x9ae.cmd0x9ae.RspBody
 * JD-Core Version:    0.7.0.1
 */