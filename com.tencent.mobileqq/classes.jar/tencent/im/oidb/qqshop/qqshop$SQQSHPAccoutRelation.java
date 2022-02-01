package tencent.im.oidb.qqshop;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqshop$SQQSHPAccoutRelation
  extends MessageMicro<SQQSHPAccoutRelation>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "puin", "binduin", "distance", "customerservice" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(-1), Integer.valueOf(0) }, SQQSHPAccoutRelation.class);
  public final PBUInt64Field binduin = PBField.initUInt64(0L);
  public final PBInt32Field customerservice = PBField.initInt32(0);
  public final PBInt32Field distance = PBField.initInt32(-1);
  public final PBUInt64Field puin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.qqshop.qqshop.SQQSHPAccoutRelation
 * JD-Core Version:    0.7.0.1
 */