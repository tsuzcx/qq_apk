package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class QQCircleCounter$PsvRedPointInfoRsp
  extends MessageMicro<PsvRedPointInfoRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "success", "redTotalNum", "redFilterNum", "uinList" }, new Object[] { Boolean.valueOf(false), Integer.valueOf(0), Integer.valueOf(0), "" }, PsvRedPointInfoRsp.class);
  public final PBUInt32Field redFilterNum = PBField.initUInt32(0);
  public final PBUInt32Field redTotalNum = PBField.initUInt32(0);
  public final PBBoolField success = PBField.initBool(false);
  public final PBRepeatField<String> uinList = PBField.initRepeat(PBStringField.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qqcircle.QQCircleCounter.PsvRedPointInfoRsp
 * JD-Core Version:    0.7.0.1
 */