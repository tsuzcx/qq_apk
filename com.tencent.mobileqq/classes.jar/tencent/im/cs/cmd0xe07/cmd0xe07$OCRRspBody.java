package tencent.im.cs.cmd0xe07;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0xe07$OCRRspBody
  extends MessageMicro<OCRRspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 810, 818, 826, 888, 896 }, new String[] { "textDetections", "language", "requestId", "ocrLanguageList", "dstTranslateLanguageList", "languageList", "afterCompressWeight", "afterCompressHeight" }, new Object[] { null, "", "", "", "", null, Integer.valueOf(0), Integer.valueOf(0) }, OCRRspBody.class);
  public final PBUInt32Field afterCompressHeight = PBField.initUInt32(0);
  public final PBUInt32Field afterCompressWeight = PBField.initUInt32(0);
  public final PBRepeatField<String> dstTranslateLanguageList = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBStringField language = PBField.initString("");
  public final PBRepeatMessageField<cmd0xe07.Language> languageList = PBField.initRepeatMessage(cmd0xe07.Language.class);
  public final PBRepeatField<String> ocrLanguageList = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBStringField requestId = PBField.initString("");
  public final PBRepeatMessageField<cmd0xe07.TextDetection> textDetections = PBField.initRepeatMessage(cmd0xe07.TextDetection.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.cs.cmd0xe07.cmd0xe07.OCRRspBody
 * JD-Core Version:    0.7.0.1
 */