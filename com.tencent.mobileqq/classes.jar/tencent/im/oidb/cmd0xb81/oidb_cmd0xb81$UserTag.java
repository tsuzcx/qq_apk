package tencent.im.oidb.cmd0xb81;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xb81$UserTag
  extends MessageMicro<UserTag>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field class_id = PBField.initUInt32(0);
  public final PBUInt32Field id = PBField.initUInt32(0);
  public final PBStringField name = PBField.initString("");
  public final PBStringField topic_rowkey = PBField.initString("");
  public final PBStringField url = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 82, 90 }, new String[] { "id", "name", "class_id", "topic_rowkey", "url" }, new Object[] { localInteger, "", localInteger, "", "" }, UserTag.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb81.oidb_cmd0xb81.UserTag
 * JD-Core Version:    0.7.0.1
 */