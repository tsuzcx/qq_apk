package tencent.im.oidb.qqshop;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qqshop_act$SQQSHPActRsp
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "code", "act_info", "act_show_info" }, new Object[] { Integer.valueOf(0), null, null }, SQQSHPActRsp.class);
  public qqshop_act.SQQSHPActInfo act_info = new qqshop_act.SQQSHPActInfo();
  public qqshop_act.SQQSHPActShowInfo act_show_info = new qqshop_act.SQQSHPActShowInfo();
  public final PBUInt32Field code = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.qqshop.qqshop_act.SQQSHPActRsp
 * JD-Core Version:    0.7.0.1
 */