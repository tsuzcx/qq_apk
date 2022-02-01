package tencent.im.oidb.cmd0x8dd;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_0x8dd$LoginConf
  extends MessageMicro<LoginConf>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_login_score" }, new Object[] { null }, LoginConf.class);
  public final PBRepeatMessageField<oidb_0x8dd.LoginScore> rpt_msg_login_score = PBField.initRepeatMessage(oidb_0x8dd.LoginScore.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8dd.oidb_0x8dd.LoginConf
 * JD-Core Version:    0.7.0.1
 */