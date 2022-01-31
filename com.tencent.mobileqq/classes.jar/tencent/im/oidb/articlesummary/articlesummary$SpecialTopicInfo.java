package tencent.im.oidb.articlesummary;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class articlesummary$SpecialTopicInfo
  extends MessageMicro<SpecialTopicInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_recommend_reason = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField<articlesummary.PackJumpInfo> rpt_jumps = PBField.initRepeatMessage(articlesummary.PackJumpInfo.class);
  public final PBStringField str_header_icon_url = PBField.initString("");
  public final PBStringField str_header_jump_url = PBField.initString("");
  public final PBStringField str_header_title = PBField.initString("");
  public final PBUInt32Field uint32_icon_shape = PBField.initUInt32(0);
  public final PBUInt32Field uint32_posttime = PBField.initUInt32(0);
  public final PBUInt32Field uint32_strategy_id = PBField.initUInt32(0);
  public final PBUInt64Field uint64_algorithm_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_puin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_topic_id = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40, 50, 56, 64, 72, 80, 88 }, new String[] { "str_header_icon_url", "str_header_title", "rpt_jumps", "str_header_jump_url", "uint32_posttime", "bytes_recommend_reason", "uint64_puin", "uint32_icon_shape", "uint64_algorithm_id", "uint32_strategy_id", "uint64_topic_id" }, new Object[] { "", "", null, "", Integer.valueOf(0), localByteStringMicro, Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L) }, SpecialTopicInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.articlesummary.articlesummary.SpecialTopicInfo
 * JD-Core Version:    0.7.0.1
 */