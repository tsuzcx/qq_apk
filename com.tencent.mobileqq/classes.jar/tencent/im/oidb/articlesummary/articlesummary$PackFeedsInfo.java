package tencent.im.oidb.articlesummary;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class articlesummary$PackFeedsInfo
  extends MessageMicro<PackFeedsInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_feeds_id", "uint32_feeds_type" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, PackFeedsInfo.class);
  public final PBUInt32Field uint32_feeds_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_feeds_id = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.articlesummary.articlesummary.PackFeedsInfo
 * JD-Core Version:    0.7.0.1
 */