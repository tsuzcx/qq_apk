package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class QQCircleSwitch$GetBlockStrategyRsp
  extends MessageMicro<GetBlockStrategyRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "uid", "block" }, new Object[] { "", Boolean.valueOf(false) }, GetBlockStrategyRsp.class);
  public final PBBoolField block = PBField.initBool(false);
  public final PBStringField uid = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qqcircle.QQCircleSwitch.GetBlockStrategyRsp
 * JD-Core Version:    0.7.0.1
 */