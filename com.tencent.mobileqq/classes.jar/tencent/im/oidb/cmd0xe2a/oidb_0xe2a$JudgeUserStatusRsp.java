package tencent.im.oidb.cmd0xe2a;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xe2a$JudgeUserStatusRsp
  extends MessageMicro<JudgeUserStatusRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "user_status" }, new Object[] { Integer.valueOf(0) }, JudgeUserStatusRsp.class);
  public final PBUInt32Field user_status = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe2a.oidb_0xe2a.JudgeUserStatusRsp
 * JD-Core Version:    0.7.0.1
 */