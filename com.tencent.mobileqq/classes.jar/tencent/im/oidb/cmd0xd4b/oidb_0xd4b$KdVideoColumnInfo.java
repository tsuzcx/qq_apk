package tencent.im.oidb.cmd0xd4b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xd4b$KdVideoColumnInfo
  extends MessageMicro<KdVideoColumnInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "uint32_video_column_id", "int64_last_update_time", "uint32_video_num", "uint32_is_subscribed" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0) }, KdVideoColumnInfo.class);
  public final PBInt64Field int64_last_update_time = PBField.initInt64(0L);
  public final PBUInt32Field uint32_is_subscribed = PBField.initUInt32(0);
  public final PBUInt32Field uint32_video_column_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_video_num = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0xd4b.oidb_0xd4b.KdVideoColumnInfo
 * JD-Core Version:    0.7.0.1
 */