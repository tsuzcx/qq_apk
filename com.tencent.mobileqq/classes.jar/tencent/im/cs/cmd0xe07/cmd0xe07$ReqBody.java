package tencent.im.cs.cmd0xe07;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0xe07$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBEnumField client = PBField.initEnum(0);
  public final PBEnumField entrance = PBField.initEnum(0);
  public cmd0xe07.OCRReqBody ocrReqBody = new cmd0xe07.OCRReqBody();
  public final PBUInt32Field version = PBField.initUInt32(1);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 82 }, new String[] { "version", "client", "entrance", "ocrReqBody" }, new Object[] { Integer.valueOf(1), localInteger, localInteger, null }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.cs.cmd0xe07.cmd0xe07.ReqBody
 * JD-Core Version:    0.7.0.1
 */