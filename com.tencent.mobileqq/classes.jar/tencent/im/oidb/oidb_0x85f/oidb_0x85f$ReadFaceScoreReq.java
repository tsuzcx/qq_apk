package tencent.im.oidb.oidb_0x85f;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x85f$ReadFaceScoreReq
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "uint64_user_id", "uint32_day", "uint32_range_min", "uint32_range_max" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ReadFaceScoreReq.class);
  public final PBUInt32Field uint32_day = PBField.initUInt32(0);
  public final PBUInt32Field uint32_range_max = PBField.initUInt32(0);
  public final PBUInt32Field uint32_range_min = PBField.initUInt32(0);
  public final PBUInt64Field uint64_user_id = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.oidb_0x85f.oidb_0x85f.ReadFaceScoreReq
 * JD-Core Version:    0.7.0.1
 */