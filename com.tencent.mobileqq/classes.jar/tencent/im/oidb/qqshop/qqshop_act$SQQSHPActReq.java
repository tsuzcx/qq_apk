package tencent.im.oidb.qqshop;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qqshop_act$SQQSHPActReq
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "act_id", "usr_info" }, new Object[] { Integer.valueOf(0), null }, SQQSHPActReq.class);
  public final PBUInt32Field act_id = PBField.initUInt32(0);
  public qqshop_act.SQQSHPUsrInfo usr_info = new qqshop_act.SQQSHPUsrInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.qqshop.qqshop_act.SQQSHPActReq
 * JD-Core Version:    0.7.0.1
 */