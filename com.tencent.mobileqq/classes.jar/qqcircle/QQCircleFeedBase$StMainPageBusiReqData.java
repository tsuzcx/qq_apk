package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class QQCircleFeedBase$StMainPageBusiReqData
  extends MessageMicro<StMainPageBusiReqData>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "reqType", "entrySchema" }, new Object[] { Integer.valueOf(0), "" }, StMainPageBusiReqData.class);
  public final PBStringField entrySchema = PBField.initString("");
  public final PBUInt32Field reqType = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qqcircle.QQCircleFeedBase.StMainPageBusiReqData
 * JD-Core Version:    0.7.0.1
 */