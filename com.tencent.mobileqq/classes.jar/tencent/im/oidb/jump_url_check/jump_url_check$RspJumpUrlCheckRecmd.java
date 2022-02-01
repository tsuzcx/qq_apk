package tencent.im.oidb.jump_url_check;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class jump_url_check$RspJumpUrlCheckRecmd
  extends MessageMicro<RspJumpUrlCheckRecmd>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "err_code", "err_msg", "can_jump" }, new Object[] { Integer.valueOf(0), "", Boolean.valueOf(true) }, RspJumpUrlCheckRecmd.class);
  public final PBBoolField can_jump = PBField.initBool(true);
  public final PBInt32Field err_code = PBField.initInt32(0);
  public final PBStringField err_msg = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.jump_url_check.jump_url_check.RspJumpUrlCheckRecmd
 * JD-Core Version:    0.7.0.1
 */