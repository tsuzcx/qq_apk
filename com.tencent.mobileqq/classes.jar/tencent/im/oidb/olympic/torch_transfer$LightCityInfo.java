package tencent.im.oidb.olympic;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class torch_transfer$LightCityInfo
  extends MessageMicro<LightCityInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_cur_city_id", "uint32_next_city_num" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, LightCityInfo.class);
  public final PBUInt32Field uint32_cur_city_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_next_city_num = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.olympic.torch_transfer.LightCityInfo
 * JD-Core Version:    0.7.0.1
 */