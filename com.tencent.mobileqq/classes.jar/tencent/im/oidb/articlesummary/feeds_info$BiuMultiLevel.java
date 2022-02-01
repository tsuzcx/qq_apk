package tencent.im.oidb.articlesummary;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class feeds_info$BiuMultiLevel
  extends MessageMicro<BiuMultiLevel>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBEnumField enum_origin_verify_status = PBField.initEnum(2);
  public final PBRepeatMessageField<feeds_info.BiuOneLevelItem> rpt_biu_mutli_level = PBField.initRepeatMessage(feeds_info.BiuOneLevelItem.class);
  public final PBUInt64Field uint64_origin_feeds_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_origin_feeds_type = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32 }, new String[] { "rpt_biu_mutli_level", "uint64_origin_feeds_id", "uint64_origin_feeds_type", "enum_origin_verify_status" }, new Object[] { null, localLong, localLong, Integer.valueOf(2) }, BiuMultiLevel.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.articlesummary.feeds_info.BiuMultiLevel
 * JD-Core Version:    0.7.0.1
 */