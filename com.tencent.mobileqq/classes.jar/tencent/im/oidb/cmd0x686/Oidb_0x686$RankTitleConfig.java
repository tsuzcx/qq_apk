package tencent.im.oidb.cmd0x686;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class Oidb_0x686$RankTitleConfig
  extends MessageMicro<RankTitleConfig>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uint32_listtype", "str_first_title", "str_second_title" }, new Object[] { Integer.valueOf(0), "", "" }, RankTitleConfig.class);
  public final PBStringField str_first_title = PBField.initString("");
  public final PBStringField str_second_title = PBField.initString("");
  public final PBUInt32Field uint32_listtype = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0x686.Oidb_0x686.RankTitleConfig
 * JD-Core Version:    0.7.0.1
 */