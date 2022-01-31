package tencent.im.oidb.cmd0x885;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x885$FeedsItem
  extends MessageMicro<FeedsItem>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40, 48, 56, 66 }, new String[] { "uint32_feed_pos", "string_title", "uint32_score", "uint32_ai_kongbu_level", "uint32_ai_disu_level", "uint32_ai_biaotidang_level", "uint32_ai_unsocial_level", "rpt_kd_tag_list" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null }, FeedsItem.class);
  public final PBRepeatMessageField<oidb_0x885.KdTagItem> rpt_kd_tag_list = PBField.initRepeatMessage(oidb_0x885.KdTagItem.class);
  public final PBStringField string_title = PBField.initString("");
  public final PBUInt32Field uint32_ai_biaotidang_level = PBField.initUInt32(0);
  public final PBUInt32Field uint32_ai_disu_level = PBField.initUInt32(0);
  public final PBUInt32Field uint32_ai_kongbu_level = PBField.initUInt32(0);
  public final PBUInt32Field uint32_ai_unsocial_level = PBField.initUInt32(0);
  public final PBUInt32Field uint32_feed_pos = PBField.initUInt32(0);
  public final PBUInt32Field uint32_score = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0x885.oidb_0x885.FeedsItem
 * JD-Core Version:    0.7.0.1
 */