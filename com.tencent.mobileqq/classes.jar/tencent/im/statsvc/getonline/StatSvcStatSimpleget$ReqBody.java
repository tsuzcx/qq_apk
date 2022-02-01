package tencent.im.statsvc.getonline;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class StatSvcStatSimpleget$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "rept_bind_qq", "int32_battrey_status" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, ReqBody.class);
  public final PBInt32Field int32_battrey_status = PBField.initInt32(0);
  public final PBRepeatField<Long> rept_bind_qq = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.statsvc.getonline.StatSvcStatSimpleget.ReqBody
 * JD-Core Version:    0.7.0.1
 */