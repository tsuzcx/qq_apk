package tencent.im.oidb.cmd0xdc4;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class FavEmotionOcr$ModifyRsp
  extends MessageMicro<ModifyRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "pic_info", "int32_result", "string_fail_msg" }, new Object[] { null, Integer.valueOf(0), "" }, ModifyRsp.class);
  public final PBInt32Field int32_result = PBField.initInt32(0);
  public FavEmotionOcr.PicInfo pic_info = new FavEmotionOcr.PicInfo();
  public final PBStringField string_fail_msg = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xdc4.FavEmotionOcr.ModifyRsp
 * JD-Core Version:    0.7.0.1
 */