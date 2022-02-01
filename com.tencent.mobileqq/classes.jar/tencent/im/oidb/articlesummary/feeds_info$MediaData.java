package tencent.im.oidb.articlesummary;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class feeds_info$MediaData
  extends MessageMicro<MediaData>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32 }, new String[] { "str_text", "str_pic_url", "uint32_pic_width", "uint32_pci_height" }, new Object[] { "", "", Integer.valueOf(0), Integer.valueOf(0) }, MediaData.class);
  public final PBStringField str_pic_url = PBField.initString("");
  public final PBStringField str_text = PBField.initString("");
  public final PBUInt32Field uint32_pci_height = PBField.initUInt32(0);
  public final PBUInt32Field uint32_pic_width = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.articlesummary.feeds_info.MediaData
 * JD-Core Version:    0.7.0.1
 */