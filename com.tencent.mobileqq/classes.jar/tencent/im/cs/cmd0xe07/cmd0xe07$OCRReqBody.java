package tencent.im.cs.cmd0xe07;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0xe07$OCRReqBody
  extends MessageMicro<OCRReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 82, 90, 96, 104, 112, 120 }, new String[] { "imageUrl", "languageType", "scene", "originMd5", "afterCompressMd5", "afterCompressFileSize", "afterCompressWeight", "afterCompressHeight", "isCut" }, new Object[] { "", "", "", "", "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Boolean.valueOf(false) }, OCRReqBody.class);
  public final PBUInt32Field afterCompressFileSize = PBField.initUInt32(0);
  public final PBUInt32Field afterCompressHeight = PBField.initUInt32(0);
  public final PBStringField afterCompressMd5 = PBField.initString("");
  public final PBUInt32Field afterCompressWeight = PBField.initUInt32(0);
  public final PBStringField imageUrl = PBField.initString("");
  public final PBBoolField isCut = PBField.initBool(false);
  public final PBStringField languageType = PBField.initString("");
  public final PBStringField originMd5 = PBField.initString("");
  public final PBStringField scene = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.cs.cmd0xe07.cmd0xe07.OCRReqBody
 * JD-Core Version:    0.7.0.1
 */