package tencent.im.oidb.cmd0xc46;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class oidb_cmd0xc46$AtData
  extends MessageMicro<AtData>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42 }, new String[] { "uid", "nick_name", "avatar", "homepage", "content" }, new Object[] { "", "", "", "", "" }, AtData.class);
  public final PBStringField avatar = PBField.initString("");
  public final PBStringField content = PBField.initString("");
  public final PBStringField homepage = PBField.initString("");
  public final PBStringField nick_name = PBField.initString("");
  public final PBStringField uid = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xc46.oidb_cmd0xc46.AtData
 * JD-Core Version:    0.7.0.1
 */