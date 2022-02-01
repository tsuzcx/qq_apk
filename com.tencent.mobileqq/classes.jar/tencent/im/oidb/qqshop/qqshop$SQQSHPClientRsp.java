package tencent.im.oidb.qqshop;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqshop$SQQSHPClientRsp
  extends MessageMicro<SQQSHPClientRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 40 }, new String[] { "recmdlist", "bindlist", "retcode", "newusrrecmd", "rcpuin" }, new Object[] { null, null, Integer.valueOf(0), null, Long.valueOf(0L) }, SQQSHPClientRsp.class);
  public final PBRepeatMessageField<qqshop.SQQSHPAccoutRelation> bindlist = PBField.initRepeatMessage(qqshop.SQQSHPAccoutRelation.class);
  public qqshop.SQQSHPNewUserRecmd newusrrecmd = new qqshop.SQQSHPNewUserRecmd();
  public final PBUInt64Field rcpuin = PBField.initUInt64(0L);
  public final PBRepeatMessageField<qqshop.SQQSHPRecmdAccount> recmdlist = PBField.initRepeatMessage(qqshop.SQQSHPRecmdAccount.class);
  public final PBUInt32Field retcode = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.qqshop.qqshop.SQQSHPClientRsp
 * JD-Core Version:    0.7.0.1
 */