package tencent.im.oidb.cmd0xdc4;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class FavEmotionOcr$OcrInfo
  extends MessageMicro<OcrInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "pic_info", "string_pic_ocr", "string_self_desc", "string_bytes_other" }, new Object[] { null, "", "", "" }, OcrInfo.class);
  public FavEmotionOcr.PicInfo pic_info = new FavEmotionOcr.PicInfo();
  public final PBStringField string_bytes_other = PBField.initString("");
  public final PBStringField string_pic_ocr = PBField.initString("");
  public final PBStringField string_self_desc = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0xdc4.FavEmotionOcr.OcrInfo
 * JD-Core Version:    0.7.0.1
 */