package tencent.im.oidb.cmd0x84c;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x84c$CItemInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "item_id", "pool_num", "item_num", "dist_num" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L) }, CItemInfo.class);
  public final PBUInt64Field dist_num = PBField.initUInt64(0L);
  public final PBUInt32Field item_id = PBField.initUInt32(0);
  public final PBUInt64Field item_num = PBField.initUInt64(0L);
  public final PBUInt64Field pool_num = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x84c.oidb_0x84c.CItemInfo
 * JD-Core Version:    0.7.0.1
 */