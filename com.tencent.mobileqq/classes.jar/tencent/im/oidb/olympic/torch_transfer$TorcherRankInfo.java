package tencent.im.oidb.olympic;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class torch_transfer$TorcherRankInfo
  extends MessageMicro<TorcherRankInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "bool_only_torcher", "uint32_rankings" }, new Object[] { Boolean.valueOf(false), Integer.valueOf(0) }, TorcherRankInfo.class);
  public final PBBoolField bool_only_torcher = PBField.initBool(false);
  public final PBUInt32Field uint32_rankings = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.olympic.torch_transfer.TorcherRankInfo
 * JD-Core Version:    0.7.0.1
 */