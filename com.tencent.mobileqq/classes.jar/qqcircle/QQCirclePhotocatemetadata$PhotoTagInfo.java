package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBStringField;

public final class QQCirclePhotocatemetadata$PhotoTagInfo
  extends MessageMicro<PhotoTagInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 29 }, new String[] { "classifyType", "classifyName", "classifyConfidence" }, new Object[] { "", "", Float.valueOf(0.0F) }, PhotoTagInfo.class);
  public final PBFloatField classifyConfidence = PBField.initFloat(0.0F);
  public final PBStringField classifyName = PBField.initString("");
  public final PBStringField classifyType = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qqcircle.QQCirclePhotocatemetadata.PhotoTagInfo
 * JD-Core Version:    0.7.0.1
 */