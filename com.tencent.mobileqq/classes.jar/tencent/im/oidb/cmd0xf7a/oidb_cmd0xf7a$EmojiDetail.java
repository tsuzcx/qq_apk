package tencent.im.oidb.cmd0xf7a;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xf7a$EmojiDetail
  extends MessageMicro<EmojiDetail>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40 }, new String[] { "tab_id", "tab_name", "tab_icon_url", "emoji_list", "emoji_size" }, new Object[] { "", "", "", null, Integer.valueOf(0) }, EmojiDetail.class);
  public final PBRepeatMessageField<oidb_cmd0xf7a.EmojiInfo> emoji_list = PBField.initRepeatMessage(oidb_cmd0xf7a.EmojiInfo.class);
  public final PBUInt32Field emoji_size = PBField.initUInt32(0);
  public final PBStringField tab_icon_url = PBField.initString("");
  public final PBStringField tab_id = PBField.initString("");
  public final PBStringField tab_name = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xf7a.oidb_cmd0xf7a.EmojiDetail
 * JD-Core Version:    0.7.0.1
 */