package tencent.im.oidb.cmd0xdc4;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class FavEmotionOcr$ModifyReq
  extends MessageMicro<ModifyReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "pic_info", "string_self_desc_new" }, new Object[] { null, "" }, ModifyReq.class);
  public FavEmotionOcr.PicInfo pic_info = new FavEmotionOcr.PicInfo();
  public final PBStringField string_self_desc_new = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xdc4.FavEmotionOcr.ModifyReq
 * JD-Core Version:    0.7.0.1
 */