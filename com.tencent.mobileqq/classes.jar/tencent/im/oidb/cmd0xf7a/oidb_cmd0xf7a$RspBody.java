package tencent.im.oidb.cmd0xf7a;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xf7a$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "ret", "err_message", "emoji_detail_list" }, new Object[] { Integer.valueOf(0), "", null }, RspBody.class);
  public final PBRepeatMessageField<oidb_cmd0xf7a.EmojiDetail> emoji_detail_list = PBField.initRepeatMessage(oidb_cmd0xf7a.EmojiDetail.class);
  public final PBStringField err_message = PBField.initString("");
  public final PBUInt32Field ret = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xf7a.oidb_cmd0xf7a.RspBody
 * JD-Core Version:    0.7.0.1
 */