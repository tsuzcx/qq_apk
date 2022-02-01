package tencent.im.cs.cmd0xe07;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0xe07$TextDetection
  extends MessageMicro<TextDetection>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34 }, new String[] { "detectedText", "confidence", "polygon", "advancedInfo" }, new Object[] { "", Integer.valueOf(0), null, "" }, TextDetection.class);
  public final PBStringField advancedInfo = PBField.initString("");
  public final PBUInt32Field confidence = PBField.initUInt32(0);
  public final PBStringField detectedText = PBField.initString("");
  public cmd0xe07.Polygon polygon = new cmd0xe07.Polygon();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.cs.cmd0xe07.cmd0xe07.TextDetection
 * JD-Core Version:    0.7.0.1
 */