package tencent.im.oidb.cmd0xe9b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class oidb_0xe9b$SelectedPicInfo
  extends MessageMicro<SelectedPicInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "str_ori_pic_url", "str_medium_pic_url", "str_small_pic_url", "str_big_pic_url" }, new Object[] { "", "", "", "" }, SelectedPicInfo.class);
  public final PBStringField str_big_pic_url = PBField.initString("");
  public final PBStringField str_medium_pic_url = PBField.initString("");
  public final PBStringField str_ori_pic_url = PBField.initString("");
  public final PBStringField str_small_pic_url = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe9b.oidb_0xe9b.SelectedPicInfo
 * JD-Core Version:    0.7.0.1
 */