package tencent.im.oidb.cmd0x954;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x954$Counter
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 88, 96, 104, 112, 120 }, new String[] { "uint32_school_id", "uint64_uv", "uint64_pv", "uint64_feeds_count", "uint64_comments_count", "uint64_like_count" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L) }, Counter.class);
  public final PBUInt32Field uint32_school_id = PBField.initUInt32(0);
  public final PBUInt64Field uint64_comments_count = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_feeds_count = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_like_count = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_pv = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_uv = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x954.cmd0x954.Counter
 * JD-Core Version:    0.7.0.1
 */