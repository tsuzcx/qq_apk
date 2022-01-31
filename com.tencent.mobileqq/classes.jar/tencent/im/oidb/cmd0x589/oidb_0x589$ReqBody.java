package tencent.im.oidb.cmd0x589;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x589$ReqBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint64_app_id", "rpt_msg_user_id" }, new Object[] { Long.valueOf(0L), null }, ReqBody.class);
  public final PBRepeatMessageField rpt_msg_user_id = PBField.initRepeatMessage(oidb_0x589.GetUserOpenIdReq.class);
  public final PBUInt64Field uint64_app_id = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x589.oidb_0x589.ReqBody
 * JD-Core Version:    0.7.0.1
 */