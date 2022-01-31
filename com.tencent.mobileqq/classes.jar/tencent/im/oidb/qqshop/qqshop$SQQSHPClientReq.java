package tencent.im.oidb.qqshop;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqshop$SQQSHPClientReq
  extends MessageMicro<SQQSHPClientReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 33, 41, 48, 56, 64 }, new String[] { "eventid", "puinlist", "cuinlist", "longitude", "latitude", "msglistlen", "rcpuin", "ad_id" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Double.valueOf(0.0D), Double.valueOf(0.0D), Integer.valueOf(-1), Long.valueOf(0L), Long.valueOf(0L) }, SQQSHPClientReq.class);
  public final PBUInt64Field ad_id = PBField.initUInt64(0L);
  public final PBRepeatField<Long> cuinlist = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBUInt32Field eventid = PBField.initUInt32(0);
  public final PBDoubleField latitude = PBField.initDouble(0.0D);
  public final PBDoubleField longitude = PBField.initDouble(0.0D);
  public final PBInt32Field msglistlen = PBField.initInt32(-1);
  public final PBRepeatField<Long> puinlist = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBUInt64Field rcpuin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.qqshop.qqshop.SQQSHPClientReq
 * JD-Core Version:    0.7.0.1
 */