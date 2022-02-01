package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class QQCircleCounter$RedPointNumRsp
  extends MessageMicro<RedPointNumRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "success", "redTotalNum", "uinlist" }, new Object[] { Boolean.valueOf(false), Integer.valueOf(0), "" }, RedPointNumRsp.class);
  public final PBUInt32Field redTotalNum = PBField.initUInt32(0);
  public final PBBoolField success = PBField.initBool(false);
  public final PBRepeatField<String> uinlist = PBField.initRepeat(PBStringField.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     qqcircle.QQCircleCounter.RedPointNumRsp
 * JD-Core Version:    0.7.0.1
 */