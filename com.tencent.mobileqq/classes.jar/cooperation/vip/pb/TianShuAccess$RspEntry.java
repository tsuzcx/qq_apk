package cooperation.vip.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class TianShuAccess$RspEntry
  extends MessageMicro<RspEntry>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "key", "value" }, new Object[] { Integer.valueOf(0), null }, RspEntry.class);
  public final PBUInt32Field key = PBField.initUInt32(0);
  public TianShuAccess.AdPlacementInfo value = new TianShuAccess.AdPlacementInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.vip.pb.TianShuAccess.RspEntry
 * JD-Core Version:    0.7.0.1
 */