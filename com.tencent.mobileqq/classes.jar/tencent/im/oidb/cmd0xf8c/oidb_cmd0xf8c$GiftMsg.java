package tencent.im.oidb.cmd0xf8c;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xf8c$GiftMsg
  extends MessageMicro<GiftMsg>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "giftuin", "gitfnickname", "materialInfo" }, new Object[] { Long.valueOf(0L), "", null }, GiftMsg.class);
  public final PBUInt64Field giftuin = PBField.initUInt64(0L);
  public final PBStringField gitfnickname = PBField.initString("");
  public oidb_cmd0xf8c.MaterialInfo materialInfo = new oidb_cmd0xf8c.MaterialInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xf8c.oidb_cmd0xf8c.GiftMsg
 * JD-Core Version:    0.7.0.1
 */