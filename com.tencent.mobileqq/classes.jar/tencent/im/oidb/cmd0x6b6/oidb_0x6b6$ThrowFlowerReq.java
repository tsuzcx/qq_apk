package tencent.im.oidb.cmd0x6b6;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x6b6$ThrowFlowerReq
  extends MessageMicro<ThrowFlowerReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "int32_count", "uint32_play_rule", "uint32_product_id" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ThrowFlowerReq.class);
  public final PBInt32Field int32_count = PBField.initInt32(0);
  public final PBUInt32Field uint32_play_rule = PBField.initUInt32(0);
  public final PBUInt32Field uint32_product_id = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0x6b6.oidb_0x6b6.ThrowFlowerReq
 * JD-Core Version:    0.7.0.1
 */