package tencent.im.cs.cmd0xe07;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class cmd0xe07$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 82 }, new String[] { "retCode", "errMsg", "wording", "ocrRspBody" }, new Object[] { Integer.valueOf(0), "", "", null }, RspBody.class);
  public final PBStringField errMsg = PBField.initString("");
  public cmd0xe07.OCRRspBody ocrRspBody = new cmd0xe07.OCRRspBody();
  public final PBInt32Field retCode = PBField.initInt32(0);
  public final PBStringField wording = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.cs.cmd0xe07.cmd0xe07.RspBody
 * JD-Core Version:    0.7.0.1
 */