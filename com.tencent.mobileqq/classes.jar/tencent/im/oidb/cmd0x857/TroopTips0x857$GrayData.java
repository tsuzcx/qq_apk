package tencent.im.oidb.cmd0x857;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class TroopTips0x857$GrayData
  extends MessageMicro<GrayData>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "all_read", "feed_id" }, new Object[] { Integer.valueOf(0), "" }, GrayData.class);
  public final PBUInt32Field all_read = PBField.initUInt32(0);
  public final PBStringField feed_id = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0x857.TroopTips0x857.GrayData
 * JD-Core Version:    0.7.0.1
 */