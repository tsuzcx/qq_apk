package tencent.nearby.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class nearby_now_anchor$AnchorStatus
  extends MessageMicro<AnchorStatus>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_uin", "enum_stat" }, new Object[] { Long.valueOf(0L), Integer.valueOf(1) }, AnchorStatus.class);
  public final PBEnumField enum_stat = PBField.initEnum(1);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     tencent.nearby.now.nearby_now_anchor.AnchorStatus
 * JD-Core Version:    0.7.0.1
 */