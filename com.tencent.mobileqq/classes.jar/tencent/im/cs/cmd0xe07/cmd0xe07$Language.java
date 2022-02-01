package tencent.im.cs.cmd0xe07;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class cmd0xe07$Language
  extends MessageMicro<Language>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "language", "languageDesc" }, new Object[] { "", "" }, Language.class);
  public final PBStringField language = PBField.initString("");
  public final PBStringField languageDesc = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.cs.cmd0xe07.cmd0xe07.Language
 * JD-Core Version:    0.7.0.1
 */