package tencent.gdt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cps_info$ProductShareInfo
  extends MessageMicro<ProductShareInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "product_id", "share_rate" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, ProductShareInfo.class);
  public final PBUInt64Field product_id = PBField.initUInt64(0L);
  public final PBUInt32Field share_rate = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.gdt.cps_info.ProductShareInfo
 * JD-Core Version:    0.7.0.1
 */