package tencent.im.oidb.oidb_0x85f;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x85f$MatchItem
  extends MessageMicro<MatchItem>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_match_user_id", "uint32_match" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, MatchItem.class);
  public final PBUInt32Field uint32_match = PBField.initUInt32(0);
  public final PBUInt64Field uint64_match_user_id = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.oidb_0x85f.oidb_0x85f.MatchItem
 * JD-Core Version:    0.7.0.1
 */