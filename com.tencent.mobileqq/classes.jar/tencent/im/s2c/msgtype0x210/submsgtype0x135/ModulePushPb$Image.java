package tencent.im.s2c.msgtype0x210.submsgtype0x135;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class ModulePushPb$Image
  extends MessageMicro<Image>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field height = PBField.initInt32(0);
  public final PBStringField str_url = PBField.initString("");
  public final PBInt32Field width = PBField.initInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "str_url", "width", "height" }, new Object[] { "", localInteger, localInteger }, Image.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x135.ModulePushPb.Image
 * JD-Core Version:    0.7.0.1
 */