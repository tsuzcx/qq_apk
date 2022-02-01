package tencent.im.oidb.cmd0xf8b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_cmd0xf8b$BiuMultiLevel
  extends MessageMicro<BiuMultiLevel>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_biu_mutli_level" }, new Object[] { null }, BiuMultiLevel.class);
  public final PBRepeatMessageField<oidb_cmd0xf8b.BiuOneLevelItem> rpt_biu_mutli_level = PBField.initRepeatMessage(oidb_cmd0xf8b.BiuOneLevelItem.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xf8b.oidb_cmd0xf8b.BiuMultiLevel
 * JD-Core Version:    0.7.0.1
 */