package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class QQCirclePaybase$StGiftData
  extends MessageMicro<StGiftData>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "giftID", "giftName", "giftNum", "giftPrice" }, new Object[] { "", "", "", "" }, StGiftData.class);
  public final PBStringField giftID = PBField.initString("");
  public final PBStringField giftName = PBField.initString("");
  public final PBStringField giftNum = PBField.initString("");
  public final PBStringField giftPrice = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qqcircle.QQCirclePaybase.StGiftData
 * JD-Core Version:    0.7.0.1
 */