package tencent.im.oidb.cmd0x64e;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0x64e$BiuMultiLevel
  extends MessageMicro<BiuMultiLevel>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "rpt_biu_mutli_level", "uint64_origin_feeds_id", "uint64_origin_feeds_type" }, new Object[] { null, Long.valueOf(0L), Long.valueOf(0L) }, BiuMultiLevel.class);
  public final PBRepeatMessageField<oidb_cmd0x64e.BiuOneLevelItem> rpt_biu_mutli_level = PBField.initRepeatMessage(oidb_cmd0x64e.BiuOneLevelItem.class);
  public final PBUInt64Field uint64_origin_feeds_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_origin_feeds_type = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0x64e.oidb_cmd0x64e.BiuMultiLevel
 * JD-Core Version:    0.7.0.1
 */