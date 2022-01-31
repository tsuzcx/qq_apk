package tencent.im.oidb.cmd0xdc4;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class FavEmotionOcr$PicInfo
  extends MessageMicro<PicInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 40, 48 }, new String[] { "string_pic_fileid", "string_pic_md5", "uint32_img_width", "uint32_img_height", "uint64_img_size" }, new Object[] { "", "", Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L) }, PicInfo.class);
  public final PBStringField string_pic_fileid = PBField.initString("");
  public final PBStringField string_pic_md5 = PBField.initString("");
  public final PBUInt32Field uint32_img_height = PBField.initUInt32(0);
  public final PBUInt32Field uint32_img_width = PBField.initUInt32(0);
  public final PBUInt64Field uint64_img_size = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0xdc4.FavEmotionOcr.PicInfo
 * JD-Core Version:    0.7.0.1
 */