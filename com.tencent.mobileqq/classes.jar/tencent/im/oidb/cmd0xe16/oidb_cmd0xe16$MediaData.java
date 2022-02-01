package tencent.im.oidb.cmd0xe16;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xe16$MediaData
  extends MessageMicro<MediaData>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField str_pic_url = PBField.initString("");
  public final PBStringField str_text = PBField.initString("");
  public final PBUInt32Field uint32_pci_height = PBField.initUInt32(0);
  public final PBUInt32Field uint32_pic_width = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32 }, new String[] { "str_text", "str_pic_url", "uint32_pic_width", "uint32_pci_height" }, new Object[] { "", "", localInteger, localInteger }, MediaData.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe16.oidb_cmd0xe16.MediaData
 * JD-Core Version:    0.7.0.1
 */