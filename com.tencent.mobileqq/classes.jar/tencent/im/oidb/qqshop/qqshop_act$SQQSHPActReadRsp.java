package tencent.im.oidb.qqshop;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qqshop_act$SQQSHPActReadRsp
  extends MessageMicro<SQQSHPActReadRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "code", "act_id" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, SQQSHPActReadRsp.class);
  public final PBUInt32Field act_id = PBField.initUInt32(0);
  public final PBUInt32Field code = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.qqshop.qqshop_act.SQQSHPActReadRsp
 * JD-Core Version:    0.7.0.1
 */