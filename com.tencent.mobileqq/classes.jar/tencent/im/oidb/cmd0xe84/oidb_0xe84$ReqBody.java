package tencent.im.oidb.cmd0xe84;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xe84$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint64_appid", "msg_condi" }, new Object[] { Long.valueOf(0L), null }, ReqBody.class);
  public final PBRepeatMessageField<oidb_0xe84.Condition> msg_condi = PBField.initRepeatMessage(oidb_0xe84.Condition.class);
  public final PBUInt64Field uint64_appid = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe84.oidb_0xe84.ReqBody
 * JD-Core Version:    0.7.0.1
 */