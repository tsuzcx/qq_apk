package tencent.im.oidb.cmd0xdb1;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class oidb_0xdb1$SearchKeyWord
  extends MessageMicro<SearchKeyWord>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "str_school_name", "str_school_id" }, new Object[] { "", "" }, SearchKeyWord.class);
  public final PBStringField str_school_id = PBField.initString("");
  public final PBStringField str_school_name = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xdb1.oidb_0xdb1.SearchKeyWord
 * JD-Core Version:    0.7.0.1
 */