package tencent.im.oidb.articlesummary;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class articlesummary$MultiBiuSameContent
  extends MessageMicro<MultiBiuSameContent>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_biu_comments = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBEnumField enum_uin_type = PBField.initEnum(0);
  public final PBRepeatMessageField<articlesummary.BiuOneLevelItem> rpt_biu_mutli_level = PBField.initRepeatMessage(articlesummary.BiuOneLevelItem.class);
  public final PBUInt32Field uint32_biu_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_feeds_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_strategy_id = PBField.initUInt32(0);
  public final PBUInt64Field uint64_algorithm_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_feeds_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 50, 56, 64, 74 }, new String[] { "uint64_uin", "enum_uin_type", "uint64_feeds_id", "uint32_feeds_type", "uint32_biu_time", "bytes_biu_comments", "uint64_algorithm_id", "uint32_strategy_id", "rpt_biu_mutli_level" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro, Long.valueOf(0L), Integer.valueOf(0), null }, MultiBiuSameContent.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.articlesummary.articlesummary.MultiBiuSameContent
 * JD-Core Version:    0.7.0.1
 */