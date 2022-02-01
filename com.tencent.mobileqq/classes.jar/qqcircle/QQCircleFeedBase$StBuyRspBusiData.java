package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;

public final class QQCircleFeedBase$StBuyRspBusiData
  extends MessageMicro<StBuyRspBusiData>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "myFuel" }, new Object[] { Long.valueOf(0L) }, StBuyRspBusiData.class);
  public final PBInt64Field myFuel = PBField.initInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     qqcircle.QQCircleFeedBase.StBuyRspBusiData
 * JD-Core Version:    0.7.0.1
 */