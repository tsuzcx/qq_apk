package tencent.im.oidb.articlesummary;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class feeds_info$VisibleShowInfo
  extends MessageMicro<VisibleShowInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "uint32_visible_type", "uint64_who", "uint64_feed_id", "uint32_is_visible" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0) }, VisibleShowInfo.class);
  public final PBUInt32Field uint32_is_visible = PBField.initUInt32(0);
  public final PBUInt32Field uint32_visible_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_feed_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_who = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.articlesummary.feeds_info.VisibleShowInfo
 * JD-Core Version:    0.7.0.1
 */